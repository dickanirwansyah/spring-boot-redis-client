package com.core.be.appbe.repository;

import com.core.be.appbe.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from users where username=:username", nativeQuery = true)
    Optional<User> findByUsername(@Param("username")String username);

    @Query(value = "select * from users where username like %:username% and status like %:status% and role like %:role% ",
            nativeQuery = true)
    Page<User> getUserByParam(@Param("username") String username,
                              @Param("status")String status,
                              @Param("role")String role,
                              Pageable pageable);

    @Query(value = "select * from users", nativeQuery = true)
    Page<User> getAllUsers(Pageable pageable);
}
