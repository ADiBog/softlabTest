package org.example.softlabtest;

import org.example.softlabtest.model.Interest;
import org.example.softlabtest.model.Person;
import org.example.softlabtest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        Person person = new Person();
        person.setName("John Doe");
        person.setEmail("john.doe@example.com");

        Interest interest1 = new Interest();
        interest1.setName("Programming");
        interest1.setUser(person);

        Interest interest2 = new Interest();
        interest2.setName("Reading");
        interest2.setUser(person);

        person.setInterests(Arrays.asList(interest1, interest2));

        userRepository.save(person);
    }
}