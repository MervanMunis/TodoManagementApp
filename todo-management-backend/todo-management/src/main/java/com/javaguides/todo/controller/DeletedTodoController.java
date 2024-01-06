package com.javaguides.todo.controller;

import com.javaguides.todo.dto.TodoDto;
import com.javaguides.todo.service.IDeletedTodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("api/deletedtodos")
public class DeletedTodoController {

    private IDeletedTodoService deletedTodoService;

    // Build Get All DeletedTodo REST API
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping()
    public ResponseEntity<List<TodoDto>> getAllDeletedTodos(){
        List<TodoDto> deletedTodos = deletedTodoService.getAllDeletedTodos();
        return ResponseEntity.ok(deletedTodos);
    }

    // Build Get DeletedTodo REST API
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/{id}")
    public ResponseEntity<TodoDto> getDeletedDto(@PathVariable Long id) {
        TodoDto deletedTodo = deletedTodoService.getDeletedTodo(id);
        return ResponseEntity.ok(deletedTodo);
    }

    // Build Delete DeletedTodo REST API
    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDeletedTodo(@PathVariable("id") Long id) {
        deletedTodoService.deleteDeletedTodo(id);
        return ResponseEntity.ok("Permanently deleted");
    }
}
