package ru.kpfu.lawhelp.models;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by  Azat on 15.03.2016.
 */
@Entity
@Table(name = "topic")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) /* http://www.objectdb.com/java/jpa/entity/generated */
    private Integer id;

    @Length(max = 255)
    @NotBlank
    @Column(nullable = false)
    private String theme;


    @OneToMany(mappedBy = "topic", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Message> messages = new ArrayList<Message>();

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;



    @Column
    private Boolean resolution;

    public Boolean isResolution() {
        return resolution;
    }

    public void setResolution(Boolean resolution) {
        this.resolution = resolution;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


   public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
