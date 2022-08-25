package com.example.hospital.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@ApiModel
@NoArgsConstructor
@Getter
@Setter
public class Pacient {
    @ApiModelProperty(value = "Andrei", required = true, example = "Exemplu")
    private String name;
    @OneToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private Disease disease;
    private int age;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "doctor_pacient",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "pacient_id")
    )
    private Set<Doctor> doctors;

    public void addDoctor(Doctor doctor) {
        doctors = new HashSet<>();
        doctors.add(doctor);
        doctor.notifyDoctor(this);
    }

    @Override
    public String toString() {
        return "Pacient{" +
                "name='" + name + '\'' +
                ", disease=" + disease +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
