package ru.kpfu.lawhelp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.kpfu.lawhelp.models.Topic;
import ru.kpfu.lawhelp.models.User;
import ru.kpfu.lawhelp.repositories.TopicRepository;

import javax.validation.Valid;
import java.sql.Timestamp;


/**
 * Created by Rail on 21.05.2015.
 */
//@PreAuthorize(("hasRole('USER')"))
@Controller
public class QuestionController {

    @Autowired
    TopicRepository topicRepository;

    @RequestMapping(value = "/ask", method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER')")
    public String ask() {
        return "ask";
    }

    @RequestMapping(value = "/ask", method = RequestMethod.POST)
    public String ask(
            @RequestParam("theme") String theme,
            RedirectAttributes redirectAttributes,
            ModelMap map
    ) {
        try {
            Topic topic = new Topic();
            topic.setTheme(theme);
            topic.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
           topic.setResolution(false);
            topicRepository.save(topic);
            map.addAttribute("message", "Ваш вопрос отправлен,ждите пока администратор утвердит его");
        } catch (TransactionSystemException e) {
            e.printStackTrace();
            map.addAttribute("message", "Ваш вопрос не отправлен");
        }
        return "ask";
    }

}
