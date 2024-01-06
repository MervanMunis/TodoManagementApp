package com.javaguides.todo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "deletedtodos")
public class DeletedTodo {

    // After one month delete it permanently
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;


    @Column(nullable = false)
    private String description;

    @Column(name = "todo_time", nullable = false)
    private Timestamp todoTime;
    private boolean completed;

}
