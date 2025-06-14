package com.buenaroma.buenaroma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buenaroma.buenaroma.entities.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

}
