package com.example.demo.repository;

import com.example.demo.model.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends CrudRepository<User,Long> {
//public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
}
