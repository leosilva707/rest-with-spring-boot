package br.com.leo.restwithspringboot.mappers

import br.com.leo.restwithspringboot.dtos.BookDTO
import br.com.leo.restwithspringboot.models.Book

class BookMapper {
    companion object {
        @JvmStatic
        fun convertToEntity(bookDTO: BookDTO): Book {
            return Book()
                .id(bookDTO.id)
                .author(bookDTO.author)
                .title(bookDTO.title)
                .price(bookDTO.price)
                .launchDate(bookDTO.launchDate);
        }

        @JvmStatic
        fun convertToDto(book: Book): BookDTO {
            return BookDTO()
                .id(book.id)
                .author(book.author)
                .title(book.title)
                .price(book.price)
                .launchDate(book.launchDate);
        }

        fun convertToDtos(books: List<Book>): List<BookDTO> {
            return books.map { book -> this.convertToDto(book) };
        }
    }
}