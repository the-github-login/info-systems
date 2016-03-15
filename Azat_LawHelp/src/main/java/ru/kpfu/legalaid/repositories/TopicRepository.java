package ru.kpfu.legalaid.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.legalaid.models.Topic;

import java.util.List;

/**
 * Created by Rail on 20.05.2015.
 */
@Repository
public interface TopicRepository  extends CrudRepository<Topic, Integer> {

    List<Topic> findByResolution(boolean resolutionVal);
    void deleteByUserId(int user_id);
}
