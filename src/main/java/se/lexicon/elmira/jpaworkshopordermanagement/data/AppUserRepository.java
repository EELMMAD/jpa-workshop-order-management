package se.lexicon.elmira.jpaworkshopordermanagement.data;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.elmira.jpaworkshopordermanagement.entity.AppUser;

import java.util.List;
import java.util.Optional;

public interface AppUserRepository extends CrudRepository<AppUser, Integer> {

    List<AppUser> findAllBy();

    Optional<AppUser> findByEmailIgnoreCase(String email);

}


