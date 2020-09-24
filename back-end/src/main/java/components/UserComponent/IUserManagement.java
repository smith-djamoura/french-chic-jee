package components.UserComponent;
import entities.User;


import javax.ejb.Local;
import java.util.List;

@Local
public interface IUserManagement {
    public List<User> getUsers();
}
