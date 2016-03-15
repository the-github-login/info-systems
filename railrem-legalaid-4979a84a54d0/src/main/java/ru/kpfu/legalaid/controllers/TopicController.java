package ru.kpfu.legalaid.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.legalaid.models.Message;
import ru.kpfu.legalaid.models.Topic;
import ru.kpfu.legalaid.models.User;
import ru.kpfu.legalaid.models.UserAuthority;
import ru.kpfu.legalaid.repositories.MessageRepository;
import ru.kpfu.legalaid.repositories.TopicRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

/**
 * Created by Rail on 09.06.2015.
 */
@Controller
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private MessageRepository messageRepository;

    @RequestMapping("/topics")
    public String list(ModelMap map) {
        map.put("topics", topicRepository.findByResolution(true));
        return "topics";
    }

    @RequestMapping("/topic/{id}")

    public String topic(@PathVariable int id, ModelMap map) {
try{
        map.put("topic", topicRepository.findOne(id));
        map.put("messages", messageRepository.findByTopicId(id));}
catch (Exception e){

}
        return "topic";
    }


    @RequestMapping(value = "/send/{topic_id}", method = RequestMethod.POST)
    @PreAuthorize("hasRole('USER')")
    public String ask(
            @PathVariable int topic_id,
            @RequestParam("content") String content,
            ModelMap map
    ) {
        Topic topic = topicRepository.findOne(topic_id);
        Message message = new Message();
        message.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        message.setTopic(topic);
        message.setMessage(content);
        messageRepository.save(message);
        map.put("topic", topic);
        map.put("messages", messageRepository.findByTopicId(topic_id));

        return "topic";
    }

    @RequestMapping(value = "/deleteMessage/{message_id}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER')")
    public String deleteMessage(
            @PathVariable int message_id,
            ModelMap map
    ) {
        Message message = messageRepository.findOne(message_id);
        Topic topic = message.getTopic();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user.equals(null)) {
            return "access_denied";
        }
        if (user.getId().equals(message.getUser().getId())) {
            messageRepository.delete(message_id);
        } else {
            ArrayList<UserAuthority> roles = (ArrayList<UserAuthority>) user.getAuthorities();
            boolean flag = false;
            for (UserAuthority role : roles) {
                if (role.getAuthority().equals("ROLE USER")) {
                    flag = true;
                }
            }
            if (flag){
                messageRepository.delete(message_id);
            }else{
                return "access_denied";
            }
        }
        map.put("topic", topic);
        map.put("messages", messageRepository.findByTopicId(topic.getId()));

        return "topic";
    }


    @RequestMapping("/deleteTopic/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String delete(@PathVariable int id, ModelMap map) {
       topicRepository.delete(id);
        messageRepository.deleteByTopicId(id);
        map.put("topics", topicRepository.findByResolution(true));
        return "topics";
    }

}
