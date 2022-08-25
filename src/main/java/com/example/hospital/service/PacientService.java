package com.example.hospital.service;

import com.example.hospital.models.Disease;
import com.example.hospital.models.Doctor;
import com.example.hospital.models.Pacient;
import com.example.hospital.repository.DoctorRepository;
import com.example.hospital.repository.PacientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PacientService {
    @Autowired
    PacientRepository pacientRepository;
    @Autowired
    DoctorRepository doctorRepository;

    public List<Pacient> getAll() {
        return pacientRepository.findAll();
    }
    public Pacient insertPacient(Pacient pacient) {
        Long doctorId = ((Doctor) pacient.getDoctors().toArray()[0]).getId();
        Doctor doctor = doctorRepository.findById(doctorId).get();
        pacient.addDoctor(doctor);
        return pacientRepository.save(pacient);
    }
    public List<Pacient> getAllByDisease(String disease) {
        return pacientRepository.findAllByDiseaseName(disease);
    }
    public Pacient modifyPacient(String pacientName, Disease disease) {
        Pacient pacient = pacientRepository.findByName(pacientName).get(0);
        pacient.setDisease(disease);
        return pacientRepository.save(pacient);
    }
    public Pacient modifyPacient(Long id, Disease disease) {
        Pacient pacient = pacientRepository.findById(id).get();
        pacient.setDisease(disease);
        return pacientRepository.save(pacient);
    }
}
