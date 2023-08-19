package com.ngs.reactive.reactive.Student;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    Flux<Student> findAll(){
        return studentService.findAll().delayElements(Duration.ofSeconds(1));
    }

    @GetMapping("/{id}")
    Mono<Student> getByStudentId(@PathVariable Integer id){
        return studentService.findByStudentId(id);
    }

    @GetMapping("/id/{id}")
    Mono<Student> getById(@PathVariable String id){
        return studentService.findById(id);
    }

}
