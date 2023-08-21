package com.ngs.reactive.Student;

import com.ngs.reactive.Student.Dto.StudentResponse;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface StudentRepository  extends ReactiveMongoRepository<Student, String> {
    Mono<StudentResponse> findByStudentId(Integer studentId);
}
