package com.user.api.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.api.entity.User;

@Repository 
public interface UserRepository extends JpaRepository<User,Long> 
{
	User findByCpf(String cpf);
	List<User> queryByNomeLike(String name);
	Page<User> findAll(Pageable page);
}