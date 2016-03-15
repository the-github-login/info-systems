package ru.kpfu.lawhelp.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * Created by  Azat on 10.03.2016.
*/
 @Entity
 @Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) /* http://www.objectdb.com/java/jpa/entity/generated */
    private Integer id;



    @NotBlank
    @Column(nullable = false,name = "message")
    private String message;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "top_id", nullable = false)
    private Topic topic;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }




}
