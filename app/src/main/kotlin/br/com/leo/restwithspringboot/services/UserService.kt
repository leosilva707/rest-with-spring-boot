package br.com.leo.restwithspringboot.services

import br.com.leo.restwithspringboot.models.User
import br.com.leo.restwithspringboot.repositories.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) : UserDetailsService {
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String?): UserDetails {
        val user: User? = userRepository.findByUsername(username);
        if (user != null) {
            return user;
        }
        throw UsernameNotFoundException("Username $username not found")
    }

}