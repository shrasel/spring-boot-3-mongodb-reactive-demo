package com.ngs.reactive.reactive.Student;

import com.ngs.reactive.reactive.Student.Dto.StudentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    public Mono<Student> createStudent(Student student) {
        return studentRepository.save(student);
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

    Mono<Student> findById(String id){
        return studentRepository.findById(id);
    }

    Mono<StudentResponse> findByStudentId(Integer id){
        return studentRepository.findByStudentId(id);
    }

    public Mono<Student> save(Student student){
        return studentRepository.save(student);
    }

    public Mono<Student> update(String id, Student student){
        student.setId(id);
        return studentRepository.save(student);
    }

    public Mono<Void> delete(String id){
        return studentRepository.deleteById(id);
    }
}
