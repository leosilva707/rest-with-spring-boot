package br.com.leo.restwithspringboot.repositories

import br.com.leo.restwithspringboot.models.Book
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<Book, Long>