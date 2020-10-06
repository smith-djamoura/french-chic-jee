package beans.userComponent;

import entities.*;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.NotFoundException;
import java.util.*;


@Stateless
public class UserManager implements IUserManager {
    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getUsers() {
        //Static User for the moment - NO BD connexion
        List<User> listOfUsers =new ArrayList<User>();
        listOfUsers.add(new User("Smith", "Djamoura"));
        listOfUsers.add(new User("Ilyas", "El Bani"));
        return listOfUsers;
    }

    public boolean userExist(String pseudo, String password){
        //Only User(smith, 1234) is allowed for now
        if ( pseudo.equals("smith") && password.equals("1234") ) {
            return true;
        }else{
            return false;
        }
    }
}
