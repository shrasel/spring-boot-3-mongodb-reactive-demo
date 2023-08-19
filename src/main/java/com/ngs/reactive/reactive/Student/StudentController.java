package com.ngs.reactive.reactive.Student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


    @PostMapping
    public Mono<Student> createStudent(@RequestBody Student student){
        return studentService.save(student);
    }

    @GetMapping
    Flux<Student> findAll(){
        return studentService.findAll(); //.delayElements(Duration.ofSeconds(1));
    }

    @GetMapping("/{id}")
    Mono<Student> getById(@PathVariable String id){
        return studentService.findById(id);
    }

    @GetMapping("/studentId/{id}")
    Mono<Student> getByStudentId(@PathVariable Integer id){
        return studentService.findByStudentId(id);
    }

    @PutMapping("/{id}")
    public Mono<Student> updateStudent(@PathVariable String id, @RequestBody Student student) {
        return studentService.update(id, student);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteStudent(@PathVariable String id) {
        return studentService.delete(id)
                .onErrorResume(ex -> Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found")));
    }

}
