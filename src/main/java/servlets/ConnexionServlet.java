package servlets;

import beans.userComponent.UserManager;
import entities.User;

import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "ConnexionServlet")
public class ConnexionServlet extends HttpServlet {
    public static final String ATT_USER         = "user";
    public static final String ATT_SESSION_USER = "userSession";
    public static final String VIEW             = "/WEB-INF/connexion.jsp";


    private static final String INPUT_PSEUDO  = "pseudo";
    private static final String INPUT_PASS   = "pass";
    private boolean validUser = false;
    private String result;
    private Map<String, String> errors = new HashMap<String, String>();

    @EJB
    private UserManager userManager;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Get session from request */
        User user = connectUser(request);
        HttpSession session = request.getSession();

        /**
         * If everything went well
         */
        if ( errors.isEmpty() ) {
            session.setAttribute( ATT_SESSION_USER, user );
        } else {
            session.setAttribute( ATT_SESSION_USER, null );
        }

        /* save user in request */
        request.setAttribute( ATT_USER, user );

        this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*Show connexion page*/
        RequestDispatcher rd = request.getRequestDispatcher(VIEW);
        rd.include(request, response);
        //this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );
    }


    public User connectUser(HttpServletRequest request){
        /* Getting inputs values */
        String pseudo = getInputValue( request, INPUT_PSEUDO);
        String pass = getInputValue( request, INPUT_PASS );

        User user= new User();

        /* Pseudo Validation. */
        try {
            pseudoValidation( pseudo );
        } catch ( Exception e ) {
            setError( INPUT_PSEUDO, e.getMessage() );
        }

        /* Password validation. */
        try {
            passValidation( pass );
        } catch ( Exception e ) {
            setError( INPUT_PASS, e.getMessage() );
        }

        if (userManager.userExist(pseudo, pass)){
            user.setPassword(pass);
            user.setPseudo( pseudo );
            validUser = true;
        } else {
            setError( "Utilisateur non trouvé","Le pseudo ou le mot de passe saisi est incorrecte.");
        }

        /* Initialisation of result string.*/
        if ( errors.isEmpty() && validUser==true ) {
            result = "Succès de la connexion.";
        } else {
            result = "Échec de la connexion.";
        }

        return user;
    }

    /*Pass and pseudo validation methods*/
    private void passValidation(String pass)  throws Exception{
        if ( pass != null ) {
            if ( pass.length() < 3 ) {
                throw new Exception( "Le mot de passe doit contenir au moins 3 caractères." );
            }
        } else {
            throw new Exception( "Merci de saisir votre mot de passe." );
        }
    }

    private void pseudoValidation(String pseudo)  throws Exception{
        if ( pseudo != null ) {
            if ( pseudo.length() < 5 ) {
                throw new Exception( "Le pseudo doit contenir au moins 5 caractères." );
            }
        } else {
            throw new Exception( "Merci de saisir votre pseudo." );
        }
    }

    /*
     * Add new error to the map error.
     */
    private void setError( String input, String message ) {
        errors.put( input, message );
    }

    /*
     * Utility method that returns  null if empty input, either the input value
     */
    private static String getInputValue( HttpServletRequest request, String inputName ) {
        String val = request.getParameter( inputName );
        if ( val == null || val.trim().length() == 0 ) {
            return null;
        } else {
            return val;
        }
    }
}
