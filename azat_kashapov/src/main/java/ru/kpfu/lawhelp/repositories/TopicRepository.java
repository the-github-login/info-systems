package ru.kpfu.lawhelp.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.lawhelp.models.Topic;

import java.util.List;

/**
 * Created by Azat on 10.03.2016.
 */
@Repository
public interface TopicRepository  extends CrudRepository<Topic, Integer> {

    List<Topic> findByResolution(boolean resolutionVal);
    void deleteByUserId(int user_id);
}
