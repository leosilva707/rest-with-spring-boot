package br.com.leo.restwithspringboot.services

import br.com.leo.restwithspringboot.dtos.BookDTO
import br.com.leo.restwithspringboot.exceptions.ResourceNotFoundException
import br.com.leo.restwithspringboot.mappers.BookMapper
import br.com.leo.restwithspringboot.repositories.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(private val bookRepository: BookRepository) {
    fun create(bookDTO: BookDTO): BookDTO {
        val bookStored = bookRepository.save(BookMapper.convertToEntity(bookDTO));
        return BookMapper.convertToDto(bookStored);
    }

    @Throws(ResourceNotFoundException::class)
    fun update(bookDTO: BookDTO): BookDTO {
        val storedBook = bookRepository
            .findById(bookDTO.id.toLong())
            .orElseThrow { ResourceNotFoundException("No records found for this ID") };
        storedBook.author(bookDTO.author);
        storedBook.price(bookDTO.price);
        storedBook.launchDate(bookDTO.launchDate);
        storedBook.title(bookDTO.title);
        return BookMapper.convertToDto(bookRepository.save(storedBook));
    }

    @Throws(ResourceNotFoundException::class)
    fun delete(id: String) {
        val storedBook = bookRepository
            .findById(id.toLong())
            .orElseThrow { ResourceNotFoundException("No records found for this ID") };
        bookRepository.delete(storedBook);
    }

    @Throws(ResourceNotFoundException::class)
    fun findById(id: String): BookDTO {
        val storedBook = bookRepository
            .findById(id.toLong())
            .orElseThrow { ResourceNotFoundException("No records found for this ID") };
        return BookMapper.convertToDto(storedBook);
    }

    fun findAll(): List<BookDTO> {
        return BookMapper.convertToDtos(bookRepository.findAll());
    }
}