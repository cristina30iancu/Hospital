package com.example.hospital.repository;

import com.example.hospital.models.Disease;
import com.example.hospital.models.Pacient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacientRepository extends JpaRepository<Pacient, Long> {
    List<Pacient> findAllByDiseaseName(String disease);
    List<Pacient> findByName(String name);
}
