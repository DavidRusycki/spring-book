package com.product.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.api.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> 
{
}