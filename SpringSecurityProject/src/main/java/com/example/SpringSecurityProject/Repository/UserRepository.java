package com.example.SpringSecurityProject.Repository;

import com.example.SpringSecurityProject.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {
    Users findByUsername(String name);
}
