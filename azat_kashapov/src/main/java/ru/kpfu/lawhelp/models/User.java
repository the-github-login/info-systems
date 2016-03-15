package ru.kpfu.lawhelp.models;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.*;
import javax.persistence.*;
import ru.kpfu.lawhelp.utils.FieldMatch;


/**
 * Created by  Azat on 13.03.2016.
 */
@FieldMatch.List({
        @FieldMatch(first = "password", second = "passwordRepeat", message = "The password fields must match")
})
@DynamicUpdate
@Entity
@Table(name = "users")
public class User implements CredentialsContainer, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) /* http://www.objectdb.com/java/jpa/entity/generated */

    private Integer id;

    @Length(max = 255)
    @NotBlank
    @Column(nullable = false)
    private String fullName;

    @NotBlank
    @Column(nullable = false)
    private String password;

    @NotBlank
    @Transient
    private String passwordRepeat;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinTable(
            name = "user_user_role",
            joinColumns = @JoinColumn(name = "users"),
            inverseJoinColumns = @JoinColumn(name = "user_role")
    )
    private Set<UserAuthority> authorities = new HashSet<>();


    @Column(columnDefinition = "boolean default false")
    private Boolean hasadmin;

    @Email
    @NotBlank
    @Column(nullable = false, unique = true)
    private String username;

    @Column(columnDefinition = "boolean default false")
    private Boolean lockated;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Topic> topics = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Topic> messages = new ArrayList<>();

    /*
   SPECIAL METHODS
   */

    /**
     * Clear all sensitive data.
     * http://docs.spring.io/autorepo/docs/spring-security/current/apidocs/org/springframework/security/core/CredentialsContainer.html
     */
    @Override
    public void eraseCredentials() {
        this.password = null;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.id);
        hash = 19 * hash + Objects.hashCode(this.username);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.fullName;
    }

    /*
     GETTERS AND SETTERS
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
    }

    public void addAuthority(UserAuthority authority) {
        this.authorities.add(authority);
    }

    @Override
    public Set<UserAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<UserAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean isLockated() {
        return lockated;
    }

    public void setLockated(Boolean lockated) {
        this.lockated = lockated;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public List<Topic> getMessages() {
        return messages;
    }

    public void setMessages(List<Topic> messages) {
        this.messages = messages;
    }

    /*
         Below there are some dummy methods. But they can be used properly with adding new fields to Entity.
         */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return lockated;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Boolean isHasadmin() {
        return hasadmin;
    }

    public void setHasadmin(Boolean hasadmin) {
        this.hasadmin = hasadmin;
    }
}