package Server;

import Server.DataLayer.User;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.time.Instant;
import java.util.concurrent.ConcurrentHashMap;

import static java.time.temporal.ChronoUnit.HOURS;

/**
 * Basic session-based authorization.
 *
 * @author Palle Sohn Christensen
 */

public class AuthService {

    private SecureRandom secureRandom = new SecureRandom();
    private ConcurrentHashMap<String, User> current_sessions;
    private ConcurrentHashMap<String, User> current_users;


    public AuthService() {
        secureRandom = new SecureRandom();
        current_sessions = new ConcurrentHashMap<>();
        current_users = new ConcurrentHashMap<>();

    }

    /**
     * If given a valid username-password combination,
     * a random sessionID is generated,
     * the User is put in a HashMap of active sessions with the sessionID as key,
     * the User is also put in a HashMap of active users with the username as key,
     * and the randomly generated sessionID is returned.
     * @param username is the username of the user
     * @param password is the password of the user
     * @return sessionID
     * @throws SQLException
     */
    public String login(String username, String password) throws SQLException {
        if (current_users.containsKey(username)) {
            if (current_users.get(username).currentSessionExpires.isAfter(Instant.now())) {
                return current_users.get(username).currentSessionID;
            }
        }
        if (User.validUser(username, password) != null) {
            User user = User.find(username);
            user.currentSessionID = generateSessionID();
            user.currentSessionExpires = (Instant.now().now()).plus(6, HOURS);
            current_sessions.put(user.currentSessionID, user);
            current_users.put(user.username, user);
            return user.currentSessionID;
        }
        return null;
    }

    /**
     * Checks if the sessionID is valid.
     * @param sessionID is the unique ID that identifies the session
     * @return
     */
    public boolean validSession(String sessionID) {
        if (current_sessions.containsKey(sessionID)) {
            if (current_sessions.get(sessionID).currentSessionExpires.isAfter(Instant.now())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the username of the User with the given sessionID.
     * @param sessionID is the unique ID that identifies the session
     * @return
     */
    public User getUserBySessionID(String sessionID) {
        return current_sessions.get(sessionID);
    }

    /**
     * Generates random sessionID.
     * @return
     */
    private String generateSessionID() {
        return new BigInteger(256, secureRandom).toString(32);
    }

}
