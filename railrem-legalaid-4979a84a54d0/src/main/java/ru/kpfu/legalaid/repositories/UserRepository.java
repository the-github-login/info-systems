package ru.kpfu.legalaid.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.legalaid.models.User;
import ru.kpfu.legalaid.models.UserAuthority;

import java.util.Set;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);


  /*@Modifying
 /* @Query("update user_user_role as p set p.classifyer = ?1 where p.classifyer = ?2")
  void makeAdmin(int id);*/
}
