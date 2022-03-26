package br.com.leo.restwithspringboot.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class ResourceNotFoundException(message: String): RuntimeException(message) {
    companion object {
        private const val serialVersionUID = 1L;
    }
};