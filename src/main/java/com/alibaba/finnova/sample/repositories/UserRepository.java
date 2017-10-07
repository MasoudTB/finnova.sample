package com.alibaba.finnova.sample.repositories;

import com.alibaba.finnova.sample.Domains.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
