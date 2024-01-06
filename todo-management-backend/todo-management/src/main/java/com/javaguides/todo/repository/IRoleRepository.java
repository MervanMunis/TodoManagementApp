package com.javaguides.todo.repository;

import com.javaguides.todo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role, Long>  {
    Role findByName(String name);

}
