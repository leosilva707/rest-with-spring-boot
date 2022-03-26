package br.com.leo.restwithspringboot.models

import java.io.Serializable
import java.util.Date
import javax.persistence.*

@Entity
@Table(name = "book")
class Book: Serializable {
    companion object {
        private const val serialVersionUID = 1L;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0;

    @Column(nullable = false, length = 180)
    var author: String = "";

    @Column(name = "launch_date", nullable = false)
    @Temporal(TemporalType.DATE)
    var launchDate: Date = Date();

    @Column(nullable = false)
    var price: Double = 0.0;

    @Column(nullable = false, length = 250)
    var title: String = "";

    fun id(id: Long) = apply { this.id = id }
    fun author(author: String) = apply { this.author = author }
    fun launchDate(launchDate: Date) = apply { this.launchDate = launchDate }
    fun price(price: Double) = apply { this.price = price }
    fun title(title: String) = apply { this.title = title }


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Book

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