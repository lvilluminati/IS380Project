/**
 * THIS CLASS IS NO LONGER NECESSARY AND SHOULD BE DELETED.
 */

public class TopWindowClass {
    public MainMenu mainWindow;
    //public OrderMenu orderWindow;

    public TopWindowClass() {
    mainWindow = new MainMenu();
    //orderWindow = new OrderMenu();
    mainWindow.setVisible(true);
    //orderWindow.setVisible(false);
    }
}
