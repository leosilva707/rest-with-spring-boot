package br.com.leo.restwithspringboot.services

import br.com.leo.restwithspringboot.dtos.PersonDTO
import br.com.leo.restwithspringboot.exceptions.ResourceNotFoundException
import br.com.leo.restwithspringboot.mappers.PersonMapper
import br.com.leo.restwithspringboot.models.Person
import br.com.leo.restwithspringboot.repositories.PersonRepository
import org.springframework.stereotype.Service

@Service
class PersonService(private val personRepository: PersonRepository) {
    fun create(personDTO: PersonDTO): PersonDTO {
        val storedPerson = personRepository.save(PersonMapper.convertToEntity(personDTO));
        return PersonMapper.convertToDto(storedPerson);
    }

    @Throws(ResourceNotFoundException::class)
    fun update(personDTO: PersonDTO): PersonDTO {
        val storedPerson = personRepository.findById(personDTO.id.toLong())
            .orElseThrow { ResourceNotFoundException("No records found for this ID") };
        storedPerson
            .firstName(personDTO.firstName)
            .lastName(personDTO.lastName)
            .address(personDTO.address)
            .gender(personDTO.gender);
        return PersonMapper.convertToDto(personRepository.save(storedPerson));
    }

    @Throws(ResourceNotFoundException::class)
    fun delete(id: String) {
        val person = personRepository.findById(id.toLong())
            .orElseThrow { ResourceNotFoundException("No records found for this ID") };
        personRepository.delete(person);
    }

    @Throws(ResourceNotFoundException::class)
    fun findById(id: String): PersonDTO {
        val person = personRepository.findById(id.toLong())
            .orElseThrow { ResourceNotFoundException("No records found for this ID") };
        return PersonMapper.convertToDto(person);
    }


    fun findAll(): List<PersonDTO> {
        return PersonMapper.convertToDtos(personRepository.findAll());
    }
}

