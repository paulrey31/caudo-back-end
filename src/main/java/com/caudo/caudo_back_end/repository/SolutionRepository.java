package com.caudo.caudo_back_end.repository;

import com.caudo.caudo_back_end.model.Solution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolutionRepository extends JpaRepository<Solution, String> {
}
