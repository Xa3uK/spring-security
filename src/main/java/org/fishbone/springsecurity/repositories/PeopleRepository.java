package org.fishbone.springsecurity.repositories;

import java.util.Optional;
import org.fishbone.springsecurity.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<Person, Integer> {

    Optional<Person> findByUserName(String userName);
}
