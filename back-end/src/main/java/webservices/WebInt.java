package webservices;
import entities.*;

import javax.interceptor.Interceptors;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.time.LocalDate;
import java.util.List;

@WebService(targetNamespace = "http://frenchchichWS/WS")
public interface WebInt {
    @WebMethod
    @WebResult(name = "users")
    public List<User> getUsers();

}
