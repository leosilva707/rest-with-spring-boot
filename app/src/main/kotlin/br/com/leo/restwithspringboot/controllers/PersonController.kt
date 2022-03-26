package br.com.leo.restwithspringboot.controllers

import br.com.leo.restwithspringboot.dtos.PersonDTO
import br.com.leo.restwithspringboot.services.PersonService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Person entry point", description = "All entry points for the person API")
@RestController
@RequestMapping("api/person/v1")
class PersonController(private val personService: PersonService) {

    @Operation(summary = "Create a new person", description = "enter person data")
    @PostMapping(produces = ["application/json", "application/xml", "application/x-yaml"], consumes = ["application/json", "application/xml", "application/x-yaml"])
    fun create(@RequestBody personDTO: PersonDTO): ResponseEntity<PersonDTO> {
        return ResponseEntity.ok(personService.create(personDTO));
    }

    @Operation(summary = "Update a person", description = "update a person with the new data")
    @PutMapping(produces = ["application/json", "application/xml", "application/x-yaml"], consumes = ["application/json", "application/xml", "application/x-yaml"])
    fun update(@RequestBody personDTO: PersonDTO): ResponseEntity<PersonDTO> {
        return ResponseEntity.ok(personService.update(personDTO));
    }

    @Operation(summary = "Retrieve a person", description = "retrieve a person by id")
    @GetMapping(value = ["/{id}"], produces = ["application/json", "application/xml", "application/x-yaml"])
    fun findById(@PathVariable("id") id: String): ResponseEntity<PersonDTO> {
        return ResponseEntity.ok(personService.findById((id)));
    }

    @Operation(summary = "Retrieve people", description = "find all people recorded")
    @GetMapping(produces = ["application/json", "application/xml", "application/x-yaml"])
    fun findAll(): ResponseEntity<List<PersonDTO>> {
        return ResponseEntity.ok(personService.findAll());
    }

    @Operation(summary = "Delete a person", description = "Delete a person by id")
    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: String): ResponseEntity<HttpStatus> {
        personService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK)
    }
}