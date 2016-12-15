package Controller;

/**
 * Created by Ronan
 * 08/12/2016.
 */
public class MainController {

    private ConnectionController connectionController;

    public MainController(String userBBD, String passwordBDD) {
        connectionController = new ConnectionController(userBBD, passwordBDD);
    }
}
