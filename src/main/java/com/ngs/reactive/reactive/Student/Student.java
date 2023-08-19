package com.ngs.reactive.reactive.Student;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.lang.NonNull;

@Document(collection = "students")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {


    @Id
    private String id;

    private Integer studentId;

    private String firstName;

    private String lastName;

    private int age;

    private String gender;

}
