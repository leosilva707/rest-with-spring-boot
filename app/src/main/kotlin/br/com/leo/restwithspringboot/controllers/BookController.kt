package br.com.leo.restwithspringboot.controllers

import br.com.leo.restwithspringboot.dtos.BookDTO
import br.com.leo.restwithspringboot.services.BookService
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

@Tag(name = "Book entrypoint", description = "All entry points for the book API")
@RestController
@RequestMapping("api/book/v1")
class BookController(private val bookService: BookService) {
    @Operation(summary = "Create a new book", description = "enter book data")
    @PostMapping(produces = ["application/json", "application/xml", "application/x-yaml"], consumes = ["application/json", "application/xml", "application/x-yaml"])
    fun create(@RequestBody bookDTO: BookDTO): ResponseEntity<BookDTO> {
        return ResponseEntity.ok(bookService.create(bookDTO));
    }

    @Operation(summary = "Update a book", description = "update a book with the new data")
    @PutMapping(produces = ["application/json", "application/xml", "application/x-yaml"], consumes = ["application/json", "application/xml", "application/x-yaml"])
    fun update(@RequestBody bookDTO: BookDTO): ResponseEntity<BookDTO> {
        return ResponseEntity.ok(bookService.update(bookDTO));
    }

    @Operation(summary = "Retrieve a book", description = "retrieve a book by id")
    @GetMapping(value = ["/{id}"], produces = ["application/json", "application/xml", "application/x-yaml"])
    fun findById(@PathVariable("id") id: String): ResponseEntity<BookDTO> {
        return ResponseEntity.ok(bookService.findById((id)));
    }

    @Operation(summary = "Retrieve books", description = "find all books recorded")
    @GetMapping(produces = ["application/json", "application/xml", "application/x-yaml"])
    fun findAll(): ResponseEntity<List<BookDTO>> {
        return ResponseEntity.ok(bookService.findAll());
    }

    @Operation(summary = "Delete a book", description = "Delete a book by id")
    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: String): ResponseEntity<HttpStatus> {
        bookService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK)
    }
}