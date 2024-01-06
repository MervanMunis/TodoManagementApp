package com.javaguides.todo.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoDto {

    private Long id;
    private String title;
    private String description;
    private Timestamp todoTime;
    private boolean completed;
}
