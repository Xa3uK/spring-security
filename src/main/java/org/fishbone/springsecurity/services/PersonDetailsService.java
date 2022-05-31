package org.fishbone.springsecurity.services;

import java.util.Optional;
import org.fishbone.springsecurity.models.Person;
import org.fishbone.springsecurity.repositories.PeopleRepository;
import org.fishbone.springsecurity.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PersonDetailsService implements UserDetailsService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PersonDetailsService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person = peopleRepository.findByUserName(username);

        if (person.isEmpty()) {
            throw new UsernameNotFoundException("User not found ((");
        } else {
            return new PersonDetails(person.get());
        }
    }
}
