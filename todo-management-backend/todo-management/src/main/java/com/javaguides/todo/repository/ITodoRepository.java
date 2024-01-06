package com.javaguides.todo.repository;

import com.javaguides.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITodoRepository extends JpaRepository<Todo, Long> {

}
