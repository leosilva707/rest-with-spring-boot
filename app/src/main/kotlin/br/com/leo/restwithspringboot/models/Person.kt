package br.com.leo.restwithspringboot.models

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "person")
class Person : Serializable {
    companion object {
        private const val serialVersionUID = 1L;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0;

    @Column(name = "first_name", nullable = false, length = 80)
    var firstName: String = "";

    @Column(name = "last_name", nullable = false, length = 80)
    var lastName: String = "";

    @Column(nullable = false, length = 100)
    var address: String = "";

    @Column(nullable = false, length = 6)
    var gender: String = "";

    fun id(id: Long) = apply { this.id = id }
    fun firstName(firstName: String) = apply { this.firstName = firstName }
    fun lastName(lastName: String) = apply { this.lastName = lastName }
    fun address(address: String) = apply { this.address = address }
    fun gender(gender: String) = apply { this.gender = gender }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Person

        if (id != other.id) return false
        if (firstName != other.firstName) return false
        if (lastName != other.lastName) return false
        if (address != other.address) return false
        if (gender != other.gender) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + firstName.hashCode()
        result = 31 * result + lastName.hashCode()
        result = 31 * result + address.hashCode()
        result = 31 * result + gender.hashCode()
        return result
    }

}
