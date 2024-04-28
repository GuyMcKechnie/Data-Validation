package ABCHospital;

import javax.swing.*;

public class main {
    public String output = "";
    public static void main(String[] args) {
        mainMenu();
    }
    public static JFrame mainMenu() {
        //Main Menu
        MainMenu mainMenu = new MainMenu();
        mainMenu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainMenu.pack();
        mainMenu.setSize(700, 600);
        mainMenu.setVisible(true);
        return mainMenu;
    }
}