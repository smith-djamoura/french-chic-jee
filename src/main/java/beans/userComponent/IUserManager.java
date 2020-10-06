package beans.userComponent;

import entities.User;

import javax.ejb.Local;
import java.util.List;

@Local
public interface IUserManager {
    public List<User> getUsers();
    public boolean userExist(String pseudo, String password);
}
