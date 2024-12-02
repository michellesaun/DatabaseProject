package com.example.application.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCouncilRepository extends JpaRepository<StudentCouncil, Integer> {

}
