package com.ngs.reactive.Student;

import com.ngs.reactive.Student.Dto.StudentRequest;
import com.ngs.reactive.Student.Dto.StudentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    public Mono<StudentResponse> save(Student student){
        return studentRepository.save(student).map(this::mapToStudentResponse);
    }

    public Flux<StudentResponse> findAll() {
        return studentRepository.findAll()
                .map(this::mapToStudentResponse);
    }

    private StudentResponse mapToStudentResponse(Student student) {
        return StudentResponse.builder()
                .id(student.getId())
                .studentId(student.getStudentId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .age(student.getAge())
                .createdAt(student.getCreatedAt())
                .gender(student.getGender())
                .updatedAt(student.getUpdatedAt())
                .build();
    }

    Mono<StudentResponse> findById(String id){
        return studentRepository.findById(id).map(this::mapToStudentResponse);
    }

    Mono<StudentResponse> findByStudentId(Integer id){
        return studentRepository.findByStudentId(id);
    }

    public Mono<StudentResponse> update(String id, StudentRequest studentRequest){
        Student student = Student.builder()
                .studentId(studentRequest.getStudentId())
                .firstName(studentRequest.getFirstName())
                .lastName(studentRequest.getLastName())
                .age(studentRequest.getAge())
                .gender(studentRequest.getGender())
                .updatedAt(LocalDateTime.now())
                .build();
            student.setId(id);
        return studentRepository.save(student).map(this::mapToStudentResponse);
    }

    public Mono<Void> delete(String id){
        return studentRepository.deleteById(id);
    }
}
