package com.revature.services;
import com.revature.models.UserModel;
import com.revature.repositories.UserDAO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Mock
    static UserDAO ud;


    @InjectMocks
    static UserService us;


    @Test
    public void readUserTest() {


    }
}