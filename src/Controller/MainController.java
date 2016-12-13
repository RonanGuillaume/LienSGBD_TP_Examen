package Controller;

/**
 * Created by Ronan
 * 08/12/2016.
 */
public class MainController {

    private ConnectionController connectionController;
    private BookController bookController;

    public MainController() {
        connectionController = new ConnectionController();
    }
}
