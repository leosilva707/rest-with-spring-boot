package br.com.leo.restwithspringboot.models

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.io.Serializable
import javax.persistence.*

@Entity
class User: UserDetails, Serializable {
    companion object {
        private const val serialVersionUID = 1L;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0;

    @Column(name = "user_name", unique = true)
    var userName: String = "";

    @Column(name = "full_name")
    var fullName: String = "";

    private var password: String = "";

    @Column(name = "account_non_expired")
    private var accountNonExpired: Boolean = true;

    @Column(name = "account_non_locked")
    private var accountNonLocked: Boolean = true;

    @Column(name = "credentials_non_expired")
    private var credentialsNonExpired: Boolean = true;

    private var enable: Boolean = true;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_permission", joinColumns = [JoinColumn(name = "id_user")], inverseJoinColumns = [JoinColumn(name = "id_permission")])
    private var permissions: List<Permission> = emptyList()

    fun getRoles(): List<String> {
        val roles: List<String> = emptyList();
        permissions.forEach {
            roles.plus(it.description)
        }
        return roles;
    }

    override fun getAuthorities(): List<Permission> {
        return permissions;
    }

    override fun getPassword(): String {
        return password
    }

    override fun getUsername(): String {
        return  userName
    }

    override fun isAccountNonExpired(): Boolean {
        return accountNonExpired;
    }

    override fun isAccountNonLocked(): Boolean {
        return accountNonLocked;
    }

    override fun isCredentialsNonExpired(): Boolean {
        return  credentialsNonExpired;
    }

    override fun isEnabled(): Boolean {
        return enable;
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (id != other.id) return false
        if (userName != other.userName) return false
        if (fullName != other.fullName) return false
        if (password != other.password) return false
        if (accountNonExpired != other.accountNonExpired) return false
        if (accountNonLocked != other.accountNonLocked) return false
        if (credentialsNonExpired != other.credentialsNonExpired) return false
        if (enable != other.enable) return false
        if (permissions != other.permissions) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + userName.hashCode()
        result = 31 * result + fullName.hashCode()
        result = 31 * result + password.hashCode()
        result = 31 * result + accountNonExpired.hashCode()
        result = 31 * result + accountNonLocked.hashCode()
        result = 31 * result + credentialsNonExpired.hashCode()
        result = 31 * result + enable.hashCode()
        result = 31 * result + permissions.hashCode()
        return result
    }


}