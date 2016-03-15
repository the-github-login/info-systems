package ru.kpfu.legalaid.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.legalaid.models.UserAuthority;

/**
 * Created by Rail on 17.05.2015.
 */
@Repository
public interface UserAuthorityRepository extends CrudRepository<UserAuthority, Integer> {

public UserAuthority findByAuthority(String role_user);

        }