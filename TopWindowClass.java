/**
 * THIS CLASS IS NO LONGER NECESSARY AND SHOULD BE DELETED.
 */

public class TopWindowClass {
    public MainMenu mainWindow;
    //public OrderMenu orderWindow;

    /**
    Constructor for creating top window.
    */
    public TopWindowClass() {
    mainWindow = new MainMenu();
    //orderWindow = new OrderMenu();
    mainWindow.setVisible(true);
    //orderWindow.setVisible(false);
    }
}
