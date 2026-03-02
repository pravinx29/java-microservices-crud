package com.ms.userserv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.userserv.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
