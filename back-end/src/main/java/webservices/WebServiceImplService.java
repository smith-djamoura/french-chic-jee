package webservices;

import beans.*;
import components.UserComponent.IUserManagement;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;


@WebService(targetNamespace = "http://deliveryWS/WS")
@Stateless(name = "frenchchicWS")
public class WebServiceImplService implements WebInt {
    @EJB
    private IUserManagement userManagement;

    @Override
    public List<User> getUsers(){
        System.out.println("Webservice : getting all users");
        return userManagement.getUsers();
    }
}
