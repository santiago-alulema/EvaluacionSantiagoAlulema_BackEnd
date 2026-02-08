package com.example.evaluacionsantiagoalulema.repositories;

import com.example.evaluacionsantiagoalulema.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query("select p.title from Post p where p.userId = :userId order by p.id asc")
    List<String> findTitlesByUserId(Integer userId);
}