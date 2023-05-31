package org.example;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {


    private List<Double> createList(Double... elems) {
        return new ArrayList<>(Arrays.asList(elems));
    }


    @Test

    void BranchTest() {
        User nullUser = null;
        RuntimeException ex;
        List<User> allUsers = new ArrayList<>();
        User user = new User("Anja", "anja123", "anjared.gmail.com");
        try {
            String username = user.getUsername();
            if (username == null) {
                throw new RuntimeException("The username is not correct");
            }
        } catch (RuntimeException e) {
            assertTrue(e.getMessage().contains("The username is not correct"));
        }

        try {
            String email = user.getEmail();
            if (!email.matches("@")) {
                throw new RuntimeException("The email is not correct");
            }
        } catch (RuntimeException e) {
            assertTrue(e.getMessage().contains("The email is not correct"));
        }


        try {
            String password = user.getPassword();
            if (!password.matches(".*[!@#$%^&*].*")) {
                throw new RuntimeException("The password does not contain any special characters");
            }
        } catch (RuntimeException e) {
            assertTrue(e.getMessage().contains("The password does not contain any special characters"));
        }
        try {
            String password = user.getPassword();
            if (!password.matches(" ")) {
                throw new RuntimeException("The password does not contain any special characters");
            }
        } catch (RuntimeException e) {
            assertTrue(e.getMessage().contains("The password does not contain any special characters"));
        }
    }
    // T || T/F || T/F = T
    // F || F || F = F
    // F || T || T/F = T
    // F || F || T = T

    @Test
    void MultipleTest() {
        User nullUser = null;
        RuntimeException ex;
        List<User> allUsers = new ArrayList<>();
        User user = new User("Anja", "anja123", "anjared@gmail.com");

        String username = user.getUsername();
        if(username == null) {
            ex = assertThrows(RuntimeException.class, () -> SILab2.function(nullUser, allUsers));
            assertTrue(ex.getMessage().contains("Not correct username, everything fails from the conditions"));
        }

        User userWithNullPassword = new User("Anja", null, "anjared@gmail.com");
        if (userWithNullPassword==null) {
            ex = assertThrows(RuntimeException.class, () -> SILab2.function(userWithNullPassword, allUsers));
            assertTrue(ex.getMessage().contains("The password is incorrect!"));
        }

        User userWithNullEmail = new User("Anja", "anja123", null);
        if (userWithNullEmail ==null) {
            ex = assertThrows(RuntimeException.class, () -> SILab2.function(userWithNullEmail, allUsers));
            assertTrue(ex.getMessage().contains("The email is incorrect!"));
        }
        User everythingisCorrect = new User("Anja", "anja+*34", "anja.red@gmail.com");
        if (everythingisCorrect != null) {
            //  ex = assertThrows(RuntimeException.class, () -> SILab2.function(user,allUsers));
            //assertTrue((ex.getMessage().contains("Everything is okay")));
            assertNotNull(SILab2.function(user, allUsers));
        }

    }
}