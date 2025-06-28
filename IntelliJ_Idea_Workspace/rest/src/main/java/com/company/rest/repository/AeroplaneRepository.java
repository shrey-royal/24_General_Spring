package com.company.rest.repository;

import com.company.rest.entity.Aeroplane;
import com.company.rest.util.AeroplaneStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AeroplaneRepository extends JpaRepository<Aeroplane, Long> {
    List<Aeroplane> findByStatus(AeroplaneStatus status);
}
