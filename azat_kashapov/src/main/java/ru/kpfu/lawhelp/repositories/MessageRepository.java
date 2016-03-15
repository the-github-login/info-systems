package ru.kpfu.lawhelp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.lawhelp.models.Message;

import java.util.List;

/**
 * Created by  Azat on 10.03.2016.
 */
@Repository
public interface MessageRepository extends CrudRepository<Message, Integer> {
    List<Message> findByTopicId(int topic_id);
    void deleteByTopicId(int topic_id);
    void deleteByUserId(int user_id);
}
