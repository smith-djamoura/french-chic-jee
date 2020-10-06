package entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
//import java.util.Objects; // import static methods from Objetcts/*

@Embeddable
public class User implements Serializable {
    private String firstName;
    private String lastName;
    private String pseudo;
    private String password;

    public User() {
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String firstName, String lastName, String pseudo, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pseudo = pseudo;
        this.password = password;
    }

    //@Column(name = "userFirstName")
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //@Column(name = "userLastName")
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //@Column(name = "userPseudo")
    public String getPseudo() {
        return pseudo;
    }
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }


    //@Column(name = "userPassword")
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "user " + getFirstName() + " " + getLastName();
    }

}