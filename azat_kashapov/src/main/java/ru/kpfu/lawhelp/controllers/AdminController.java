package ru.kpfu.lawhelp.controllers;

import ru.kpfu.lawhelp.repositories.TopicRepository;
import ru.kpfu.lawhelp.repositories.UserAuthorityRepository;
import ru.kpfu.lawhelp.repositories.MessageRepository;
import ru.kpfu.lawhelp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.kpfu.lawhelp.models.Topic;
import ru.kpfu.lawhelp.models.User;
import ru.kpfu.lawhelp.models.UserAuthority;

import ru.kpfu.lawhelp.services.UserService;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.HashSet;
import java.util.Set;

import ru.kpfu.lawhelp.exceptions.NotFoundException;

/**
 * Created by  Azat on 10.03.2016.
 */
@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserAuthorityRepository userAuthorityRepository;

    @Autowired
    private TopicRepository topicRepository;

    @RequestMapping("/resList")
    @PreAuthorize("hasRole('ADMIN')")
    public String resList(ModelMap map) {
        map.put("topics", topicRepository.findByResolution(false));
        return "resList";
    }

    @RequestMapping("/list")
    @PreAuthorize("hasRole('ADMIN')")
    public String list(ModelMap map) {
        map.put("users", userRepo.findAll());

        return "list";
    }

    @RequestMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String delete(@PathVariable int id, ModelMap map) {
        User user = userRepo.findOne(id);
        if (user != null) {
            userRepo.delete(id);
        }
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("AC#list").build();
    }

    @RequestMapping("/acsess/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String acsess(@PathVariable int id, ModelMap map) {
        Topic topic = topicRepository.findOne(id);
        topicRepository.delete(id);
        topic.setResolution(true);
        topicRepository.save(topic);
      /*  map.put("topics", topicRepository.findByResolution(false));
        return "resList";*/
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("AC#resList").build();
    }

    @RequestMapping("/isus/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String isus(@PathVariable int id, ModelMap map) {


        User user = userRepo.findOne(id);
        if (user == null) {
            throw new EntityNotFoundException("User with id " + id + "has not been found.");
        }
        Set<UserAuthority> authorities = user.getAuthorities();
        authorities.add(userAuthorityRepository.findOne(2));
        try {
            user = userService.updateAuthorities(user.getId(), authorities);
           // user = userService.updateHasadmin(user.getId(), new Boolean(true));
        } catch (EntityNotFoundException ex) {
            throw new NotFoundException("user");
        }

        /*  Set<UserAuthority> authorities = user.getAuthorities();

            authorities.add(userAuthorityRepository.findOne(2));
            user.setHasadmin(true);
            user.setAuthorities(authorities);

        /*messageRepository.deleteByUserId(id);
        topicRepository.deleteByUserId(id);*/

        userRepo.save(user);
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("AC#list").build();
    }

}

