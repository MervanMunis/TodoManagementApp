package com.javaguides.todo.repository;

import com.javaguides.todo.entity.DeletedTodo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDeletedTodoRepository extends JpaRepository<DeletedTodo, Long> {

}
