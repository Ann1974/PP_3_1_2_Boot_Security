package ru.kata.spring.boot_security.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class LoadUser {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public LoadUser(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void load() {
        Role roleAdmin = new Role( "ROLE_ADMIN");
        Role roleUser = new Role( "ROLE_USER");
        Set<Role> adminSet = new HashSet<>();

        roleService.addRole(roleAdmin);
        adminSet.add(roleAdmin);

        User admin = new User("Boris", "Borisov", 25, "BorisKata",
                "100", adminSet);


        userService.saveUser(admin);


    }
}
