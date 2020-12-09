package com.managementtool.demo.repository;

import com.managementtool.demo.models.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ManagerRepo extends JpaRepository<Manager, Long> {
    Manager findByEmail(String email);
}
