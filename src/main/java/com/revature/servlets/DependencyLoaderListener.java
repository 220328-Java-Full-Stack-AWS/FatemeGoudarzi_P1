package com.revature.servlets;
import com.revature.util.ConnectionManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;

public class DependencyLoaderListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
//        Connection conn;
//        conn = ConnectionManager.getConnection();
        System.out.println("Inside context initializer!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
