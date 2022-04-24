package com.revature.services;

import com.revature.models.UserModel;
import com.revature.repositories.UserDAO;

import java.util.Optional;

/**
 * The AuthService should handle login and registration for the ERS application.
 *
 * {@code login} and {@code register} are the minimum methods required; however, additional methods can be added.
 *
 * Examples:
 * <ul>
 *     <li>Retrieve Currently Logged-in User</li>
 *     <li>Change Password</li>
 *     <li>Logout</li>
 * </ul>
 */
public class AuthService {

    private final UserDAO userDao;
    public AuthService() {
        this.userDao = new UserDAO();
    }

    /**
     * <ul>
     *     <li>Needs to check for existing users with username/email provided.</li>
     *     <li>Must throw exception if user does not exist.</li>
     *     <li>Must compare password provided and stored password for that user.</li>
     *     <li>Should throw exception if the passwords do not match.</li>
     *     <li>Must return user object if the user logs in successfully.</li>
     * </ul>
     */
    public UserModel login(UserModel model) {
        return userDao.read(model);
    }

    /**
     * <ul>
     *     <li>Should ensure that the username/email provided is unique.</li>
     *     <li>Must throw exception if the username/email is not unique.</li>
     *     <li>Should persist the user object upon successful registration.</li>
     *     <li>Must throw exception if registration is unsuccessful.</li>
     *     <li>Must return user object if the user registers successfully.</li>
     *     <li>Must throw exception if provided user has a non-zero ID</li>
     * </ul>
     *
     * Note: userToBeRegistered will have an id=0, additional fields may be null.
     * After registration, the id will be a positive integer.
     */
    public UserModel register(UserModel userModelToBeRegistered) {
        return null;
    }

    /**
     * This is an example method signature for retrieving the currently logged-in user.
     * It leverages the Optional type which is a useful interface to handle the
     * possibility of a user being unavailable.
     */
    public Optional<UserModel> exampleRetrieveCurrentUser() {
        return Optional.empty();
    }
}


//login to ERS.
//	public String login(){
//		UserDAO userDao = new UserDAO();
//		String output;
//		UserModel read_model = new UserModel("AliGoodi123","12345");
//		if (userDao.read(read_model).equals("successful")){
//			output="Welcome to ERS system!";
//		}else if(userDao.read(read_model).equals("invalid_user_name")){
//			output="You have entered a wrong User Name in the system!";
//		}else{
//			output="Wrong Password! Try again!";
//		};
//		return output;
//	}