package com.ngs.reactive.Student;

import com.ngs.reactive.Student.Dto.StudentRequest;
import com.ngs.reactive.Student.Dto.StudentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public Mono<StudentResponse> createStudent(@RequestBody StudentRequest studentRequest) {
       Student student = Student.builder()
               .studentId(studentRequest.getStudentId())
               .firstName(studentRequest.getFirstName())
               .lastName(studentRequest.getLastName())
               .age(studentRequest.getAge())
               .gender(studentRequest.getGender())
               .createdAt(studentRequest.getCreatedAt())
               .build();
        return studentService.save(student);
    }


    @GetMapping
    Flux<StudentResponse> findAll(){
        return studentService.findAll(); //.delayElements(Duration.ofSeconds(1));
    }

    @GetMapping("/{id}")
    Mono<StudentResponse> getById(@PathVariable String id){
        return studentService.findById(id);
    }

    @GetMapping("/studentId/{id}")
    Mono<StudentResponse> getByStudentId(@PathVariable Integer id){
        return studentService.findByStudentId(id);
    }

    @PutMapping("/{id}")
    public Mono<StudentResponse> updateStudent(@PathVariable String id, @RequestBody StudentRequest studentRequest) {
        return studentService.update(id, studentRequest);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteStudent(@PathVariable String id) {
        return studentService.delete(id)
                .onErrorResume(ex -> Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found")));
    }

}
