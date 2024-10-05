package com.example.demo.repository;

import com.example.demo.model.Gardener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GardenerRepository extends JpaRepository<Gardener, Long> {
}
