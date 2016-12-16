package DAO;

import Controller.ConnectionController;

import java.sql.Connection;

/**
 * Created by Ronan
 * on 15/12/2016.
 */
public abstract class AbstractDAO {
    private Connection connection;

    public AbstractDAO(Connection connection) {
        this.connection = connection;
    }
}
