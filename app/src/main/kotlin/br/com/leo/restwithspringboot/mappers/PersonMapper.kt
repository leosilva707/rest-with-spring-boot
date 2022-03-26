package br.com.leo.restwithspringboot.mappers

import br.com.leo.restwithspringboot.dtos.PersonDTO
import br.com.leo.restwithspringboot.models.Person

class PersonMapper {
    companion object {
        @JvmStatic
        fun convertToEntity(personDTO: PersonDTO): Person {
            val person =
                Person()
                    .id(personDTO.id)
                    .firstName(personDTO.firstName)
                    .lastName(personDTO.firstName)
                    .gender(personDTO.gender)
                    .address(personDTO.address);
            return person;
        }

        @JvmStatic
        fun convertToDto(person: Person): PersonDTO {
            val personDTO =
                PersonDTO()
                    .id(person.id)
                    .firstName(person.firstName)
                    .lastName(person.firstName)
                    .gender(person.gender)
                    .address(person.address);
            return personDTO;
        }

        fun convertToDtos(persons: List<Person>): List<PersonDTO> {
            return persons.map { person -> this.convertToDto(person) };
        }
    }
}