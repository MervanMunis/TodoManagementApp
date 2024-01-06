package com.javaguides.todo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // if name is not specified then the defined name will be assigned which is title
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(name = "todo_time", nullable = false)
    private Timestamp todoTime;
    private boolean completed;
}
