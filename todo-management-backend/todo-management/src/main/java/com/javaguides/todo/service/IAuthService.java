package com.javaguides.todo.service;

import com.javaguides.todo.dto.LoginDto;
import com.javaguides.todo.dto.RegisterDto;

public interface IAuthService {
    String register(RegisterDto registerDto);

    String login(LoginDto loginDto);
}
