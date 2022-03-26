package br.com.leo.restwithspringboot.repositories

import br.com.leo.restwithspringboot.models.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<Person, Long>