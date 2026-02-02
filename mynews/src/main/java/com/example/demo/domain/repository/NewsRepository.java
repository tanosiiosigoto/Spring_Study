package com.example.demo.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.entity.news.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {
    public List<News> findAllByOrderById();
    public List<News> findByTitleLike(String title);
}
