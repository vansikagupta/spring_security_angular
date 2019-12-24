package com.vansika.userMangement.security;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Integer> {

	Optional<UserModel> findByUsername(String username);
}