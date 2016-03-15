package ru.kpfu.lawhelp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.lawhelp.models.UserAuthority;

/**
 * Created by  Azat on 10.03.2016.
 */
@Repository
public interface UserAuthorityRepository extends CrudRepository<UserAuthority, Integer> {

public UserAuthority findByAuthority(String role_user);

        }