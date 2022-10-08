package com.springbook.repository;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

import com.springbook.repository.entity.User;

@Repository 
public interface UserRepository extends JpaRepository<User,Long> 
{
	User findByCpf(String cpf);
	List<User> queryByNomeLike(String name);
}