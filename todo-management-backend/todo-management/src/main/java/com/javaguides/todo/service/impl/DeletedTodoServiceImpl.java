package com.javaguides.todo.service.impl;

import com.javaguides.todo.dto.TodoDto;
import com.javaguides.todo.entity.DeletedTodo;
import com.javaguides.todo.exception.ResourceNotFoundException;
import com.javaguides.todo.repository.IDeletedTodoRepository;
import com.javaguides.todo.service.IDeletedTodoService;
import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class DeletedTodoServiceImpl implements IDeletedTodoService {

    private IDeletedTodoRepository deletedTodoRepository;

    private ModelMapper modelMapper;


    @Override
    public TodoDto addDeletedTodo(TodoDto todoDto) {
        DeletedTodo deletedTodo = modelMapper.map(todoDto, DeletedTodo.class);

        // Get the deleted date and time
        java.time.LocalDateTime currentDateTime = java.time.LocalDateTime.now();

        // Convert to SQL Timestamp
        Timestamp sqlTimestamp = Timestamp.valueOf(currentDateTime);

        // At front-end developing, the passed time can be provided.
        todoDto.setTodoTime(sqlTimestamp);

        DeletedTodo savedTodo = deletedTodoRepository.save(deletedTodo);

        return modelMapper.map(savedTodo,TodoDto.class);
    }

    @Override
    public TodoDto getDeletedTodo(Long id) {
        DeletedTodo deletedTodo = deletedTodoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));
        return modelMapper.map(deletedTodo, TodoDto.class);
    }

    @Override
    public List<TodoDto> getAllDeletedTodos() {
        List<DeletedTodo> todos = deletedTodoRepository.findAll();
        return todos.stream().map((todo) -> modelMapper.map(todo, TodoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteDeletedTodo(Long id) {
        DeletedTodo deletedTodo = deletedTodoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));
        deletedTodoRepository.deleteById(id);
    }
}
