package com.javaguides.todo.service;

import com.javaguides.todo.dto.TodoDto;

import java.util.List;

public interface IDeletedTodoService {
    // addDeletedTodo added under the IDeletedServc
    TodoDto addDeletedTodo(TodoDto TodoDto);

    TodoDto getDeletedTodo(Long id);

    List<TodoDto> getAllDeletedTodos();

    void deleteDeletedTodo(Long id);
}

