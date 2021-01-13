package com.emse.spring.faircorp.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class DummyUserService implements UserService {

    private GreetingService greetingService;
    private ArrayList<String> users;

    @Autowired
    public DummyUserService(GreetingService greetingService) {
        this.greetingService = greetingService;
        this.users = new ArrayList<String>();
        this.users.add("Charles");
        this.users.add("Elodie");
    }

    public GreetingService getGreetingService() {
        return greetingService;
    }

    @Override
    public void greetAll() {
        for(int i=0; i < users.size() ; i++)
            this.greetingService.greet(users.get(i));
    }
}
