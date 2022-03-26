package br.com.leo.restwithspringboot.dtos

import java.io.Serializable
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.fasterxml.jackson.annotation.JsonRootName

@JsonRootName("Person")
@JsonPropertyOrder(*[ "id", "address", "first_name", "last_name", "gender" ])
class PersonDTO : Serializable{

    var id: Long = 0;

    @JsonProperty("first_name")
    var firstName: String = "";

    @JsonProperty("last_name")
    var lastName: String = "";

    var address: String = "";

    var gender: String = "";

    fun id(id: Long) = apply { this.id = id };
    fun firstName(firstName: String) = apply { this.firstName = firstName };
    fun lastName(lastName: String) = apply { this.lastName = lastName };
    fun address(address: String) = apply { this.address = address };
    fun gender(gender: String) = apply { this.gender = gender };

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PersonDTO

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