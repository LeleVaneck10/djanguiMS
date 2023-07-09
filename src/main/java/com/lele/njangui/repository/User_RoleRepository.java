package com.lele.njangui.repository;

import com.lele.njangui.model.User_Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User_RoleRepository extends JpaRepository<User_Role, Long> {
}

