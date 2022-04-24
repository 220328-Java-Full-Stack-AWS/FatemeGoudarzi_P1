package com.revature.services;

import com.revature.models.UserModel;
import com.revature.repositories.UserDAO;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * The UserService should handle the processing and retrieval of Users for the ERS application.
 *
 * {@code getByUsername} is the only method required;
 * however, additional methods can be added.
 *
 * Examples:
 * <ul>
 *     <li>Create User</li>
 *     <li>Update User Information</li>
 *     <li>Get Users by ID</li>
 *     <li>Get Users by Email</li>
 *     <li>Get All Users</li>
 * </ul>
 */


	//Create an Account in ERS.
	public class UserService {
		private final UserDAO userDao;
		public UserService() {
			this.userDao = new UserDAO();
		}


	public UserModel createAccount(UserModel model){
		return userDao.create(model);
	}

	/**
	 *     Should retrieve a User with the corresponding username or an empty optional if there is no match.
	 */

	//Retrieve a user data from system
	public UserModel read(UserModel model) {
		return userDao.read(model);
	}

	//Retrieve list of all usernames in the system
	public List getAllUserNames(){
		List<String> userNamesList = new LinkedList<>();
		List rawList = userDao.getAll();

		for( int i = 0;i<rawList.size() ;i++){
			UserModel out = (UserModel) rawList.get(i);
			userNamesList.add(out.getUserName());
		}
		return userNamesList;
	}







}
