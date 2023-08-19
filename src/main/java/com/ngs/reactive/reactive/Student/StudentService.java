package com.ngs.reactive.reactive.Student;

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

    Flux<Student> findAll(){
        return studentRepository.findAll();
    }

    Mono<Student> findById(String id){
        return studentRepository.findById(id);
    }

    Mono<Student> findByStudentId(Integer id){
        return studentRepository.findByStudentId(id);
    }

    public Mono<Student> save(Student student){
        return studentRepository.save(student);
    }
}
