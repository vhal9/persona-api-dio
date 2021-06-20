package one.digitalinnovation.personapi.controllers;

import one.digitalinnovation.personapi.exceptions.PersonNotFoundException;
import one.digitalinnovation.personapi.models.dto.request.PersonDTO;
import one.digitalinnovation.personapi.models.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.models.entity.Person;
import one.digitalinnovation.personapi.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonServices personServices;

    @Autowired
    public PersonController(PersonServices personServices) {
        this.personServices = personServices;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){

        return personServices.createPerson(personDTO);

    }

    @GetMapping
    public List<PersonDTO> listAll(){

        return personServices.listAll();

    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {

        return personServices.findById(id);

    }

}
