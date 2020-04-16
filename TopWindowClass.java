//////THIS MIGHT NOT BE NECESSARY, NOT SURE YET!!!

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
