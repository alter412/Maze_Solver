import javax.swing.*;
import java.awt.*;
// main class of the project
public class Main {
    public static void main(String[] args) {
        // Creating the Frame
        JFrame frame = new JFrame("Maze Solver");
        // Setting the default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Setting the Size of the frame
        frame.setSize(1000,1000);
        // Creating the Panel to display the Maze
        UI u = new UI();
        // Setting background of Maze
        u.setBackground(Color.LIGHT_GRAY);
        // Add the panel to frame
        frame.add(u);
        // Setting the frame visible
        frame.setVisible(true);
    }
}
