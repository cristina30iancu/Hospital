package com.example.hospital.controller;

import com.example.hospital.models.Disease;
import com.example.hospital.models.Pacient;
import com.example.hospital.service.PacientService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacient")
public class PacientController {
    @Autowired
    PacientService pacientService;

    /*
    * 2. O modalitate de a vedea toti pacientii din sistem - GET
NO /getall
NO /patient-all
YES GET /patients ||  GET /pacienti
3. O modalitate de a filtra pacientii in functie de afectiunea lor - GET
NO /patients/raceala
YES /patients?afectiune=raceala*/
    @GetMapping("")
    public List<Pacient> getAll(@RequestParam (required = false) String disease) {
        if(disease != null) {
            return pacientService.getAllByDisease(disease);
        }
        return pacientService.getAll();
    }


    @ApiOperation(value = "Adding a pacient", notes = "Adding a pacient and his doctor and disease.",
            response = Pacient.class)
    @ApiResponses({@ApiResponse(code=200, message="Successfully added pacient", response=Pacient.class),
            @ApiResponse(code=500, message = "Exception", response = Exception.class)})
    @PostMapping("")
    public Pacient addPacient(@RequestBody Pacient pacient){
        return pacientService.insertPacient(pacient);
    }

    /*4. O modalitate de a modifica afectiunea unui pacient identificat dupa nume - PUT
/patients?username=costel
@RequestBody -> [POSTMAN] {afectiune: "raceala"} -> [JAVA] clasa cu String afectiune AfectiuneDTO @ApiModel*/
    @PutMapping("")
    public Pacient modifyByName(@RequestParam String name, @RequestBody Disease disease) {
        return pacientService.modifyPacient(name,disease);
    }


   /* 5. O modalitate de a modifica afectiunea unui pacient identificat dupa id - PUT
/patients/{id}
@RequestBody -> [POSTMAN] {afectiune: "raceala"} -> [JAVA] clasa cu String afectiune*/
    @PutMapping("/{id}")
    public Pacient modifyById(@PathVariable Long id, @RequestBody Disease disease) {
        return pacientService.modifyPacient(id, disease);
    }
}
