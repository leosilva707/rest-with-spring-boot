package br.com.leo.restwithspringboot.dtos

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName
import java.io.Serializable
import java.util.Date

@JsonRootName("Book")
class BookDTO: Serializable {
    var id: Long = 0;

    var author: String = "";

    @JsonProperty("launch_date")
    var launchDate: Date = Date();

    var price: Double = 0.0;

    var title: String = "";

    fun id(id: Long) = apply { this.id = id }
    fun author(author: String) = apply { this.author = author }
    fun launchDate(launchDate: Date) = apply { this.launchDate = launchDate }
    fun price(price: Double) = apply { this.price = price }
    fun title(title: String) = apply { this.title = title }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BookDTO

        if (id != other.id) return false
        if (author != other.author) return false
        if (launchDate != other.launchDate) return false
        if (price != other.price) return false
        if (title != other.title) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + author.hashCode()
        result = 31 * result + launchDate.hashCode()
        result = 31 * result + price.hashCode()
        result = 31 * result + title.hashCode()
        return result
    }
}