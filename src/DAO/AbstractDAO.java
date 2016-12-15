package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Controller.ConnectionController;

import static sun.plugin2.message.JavaScriptSlotOpMessage.SET;

/**
 * Created by Ronan
 * on 15/12/2016.
 */
public abstract class AbstractDAO {

    public int getStock(String product){
        int stock = -1;
        try {
            //TODO : I don't see how we can put all DAO fonction in ABSTRACT DAO...

            String query =  "SELECT `stock` " +
                            "FROM product" +
                            " WHERE name LIKE '?'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, product);
            ResultSet result = preparedStatement.executeQuery();


            while(result.next()){
                stock = (int) result.getInt("stock");
            }

            preparedStatement.close();

        } catch (SQLException ex2) {
            System.out.println("Error JDBC: "+ex2);
            System.exit(1);
        }
        return stock;
    }
    public int addProvider(String name, String forname, String address, String city){
        int stock = -1;
        try {
            //TODO : I don't see how we can put all DAO fonction in ABSTRACT DAO...

            String query =  "INSERT INTO `provider` " +
                    "(`name`, `forname`, `address`, `city`) " +
                    "VALUES ('?', '?', '?', '?');";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, forname);
            preparedStatement.setString(3, address);
            preparedStatement.setString(4, city);

            preparedStatement.close();

        } catch (SQLException ex2) {
            System.out.println("Error JDBC: "+ex2);
            System.exit(1);
        }
        return stock;
    }
    public void setStock(int number, String product){
        //On fati la vérif avant mais on est jamais trop sûr ;)
        if(getStock(product) >= number){
            try {
                //TODO : I don't see how we can put all DAO fonction in ABSTRACT DAO...

                String query =  "UPDATE `product` " +
                                "SET stock = stock+?" +
                                " WHERE name LIKE '?'";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, number);
                preparedStatement.setString(2, product);

                //Result vraiment necessaire ?
                ResultSet result = preparedStatement.executeQuery();

                preparedStatement.close();


            } catch (SQLException ex2) {
                System.out.println("Error JDBC: "+ex2);
                System.exit(1);
            }
        }
    }
}
