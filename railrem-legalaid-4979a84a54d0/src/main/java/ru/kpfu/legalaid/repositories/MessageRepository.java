package ru.kpfu.legalaid.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.legalaid.models.Message;

import java.util.List;

/**
 * Created by Rail on 20.05.2015.
 */
@Repository
public interface MessageRepository extends CrudRepository<Message, Integer> {
    List<Message> findByTopicId(int topic_id);
    void deleteByTopicId(int topic_id);
    void deleteByUserId(int user_id);
}
