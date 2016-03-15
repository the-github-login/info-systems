package ru.kpfu.lawhelp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kpfu.lawhelp.models.User;
import ru.kpfu.lawhelp.models.UserAuthority;
import ru.kpfu.lawhelp.repositories.UserAuthorityRepository;
import ru.kpfu.lawhelp.repositories.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Set;

/**
 * Created by  Azat on 10.03.2016.
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserAuthorityRepository userAuthorityRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }

    public void registerUser(User user) {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new DuplicateKeyException("Duplicate key - username field.");
        }
        user.addAuthority(userAuthorityRepo.findByAuthority("ROLE_USER"));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setPasswordRepeat(user.getPassword());

        userRepo.save(user);
    }

    public User updateAuthorities(Integer id, Set<UserAuthority> authorities) {
        User user = userRepo.findOne(id);
        if (user == null) {
            throw new EntityNotFoundException("User with id " + id + "has not been found.");
        }
        user.setAuthorities(authorities);
       // user.setHasadmin(new Boolean(true));
        return user;
    }

  /*  public User updateHasadmin(Integer id,Boolean hasadmin) {
        User user = userRepo.findOne(id);
        if (user == null) {
            throw new EntityNotFoundException("User with id " + id + "has not been found.");
        }

         user.setHasadmin(hasadmin);
        return user;
    }*/
}
