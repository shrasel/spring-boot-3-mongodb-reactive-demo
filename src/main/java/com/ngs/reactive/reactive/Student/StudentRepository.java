package com.ngs.reactive.reactive.Student;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface StudentRepository  extends ReactiveMongoRepository<Student, String> {
    Mono<Student> findByStudentId(Integer studentId);
}
