package com.example.hospital.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String specialization;
//    @ManyToMany(mappedBy = "doctors")
//    private Set<Pacient> pacients;

    public void notifyDoctor(Pacient pacient) {
        System.out.println("Doctor "+name+", pacient "+pacient+" registered!");
    }
}
