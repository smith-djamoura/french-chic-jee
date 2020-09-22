package components.UserComponent;
import beans.*;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.NotFoundException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Stateless
public class UserEJB implements  IUserManagement{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsers() {

        //Static User for the moment
        List<User> listOfUsers =new ArrayList<User>();
        listOfUsers.add(new User("Smith", "Djamoura"));
        listOfUsers.add(new User("Ilyas", "El Bani"));
        return listOfUsers;
    }
}
