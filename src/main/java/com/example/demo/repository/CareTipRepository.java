package com.example.demo.repository;

import com.example.demo.model.CareTip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareTipRepository extends JpaRepository<CareTip, Long> {
}
