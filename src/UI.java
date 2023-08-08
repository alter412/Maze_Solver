import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UI extends JPanel{
    // Maze initialization with 1,0,9
    // 1 -> Blocked
    // 0 -> Allowed to travel
    // 9 -> Destination
    private int[][] maze = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 9, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };
    // ArrayList to store the coordinate of the cells in the path to destination
    private ArrayList<Integer> path = new ArrayList<>();
    UI(){
        // calling the find function to get the path to destination
        new Search().find(maze,1,1,path);
    }
    // overriding the paintComponent method to display the maze
    @Override
    protected void paintComponent(Graphics g) {
                // calling the parent's class paintComponent method to draw the maze
                 super.paintComponent(g);
                // Fetching the root component
                JFrame t = (JFrame) SwingUtilities.getRoot(this);
                // Calculating the size of the grid's cell based on the frame size
                // this will make the grid responsive as the frame size changes
                int size = (Math.min(t.getWidth(),t.getHeight())/2)/ maze.length;
                // calculating the initial x and y coordinate to show the maze in the center
                int x = (t.getWidth()/2)-(size* (maze[0].length/2));
                int y = (t.getHeight()/2)-(size*(maze.length/2));
                // store the x and y in temporary variable
                int tx = x;
                int ty= y;
                // Drawing the maze
                for(int i=0;i<maze.length;i++){
                    Color c ;
                    for(int j=0;j<maze[0].length;j++) {
                        // setting color based on the value of the cell
                        switch (maze[i][j]) {
                            case 1:
                                // Blocker cell
                                c = Color.BLACK;
                                break;
                            case 9:
                                // Destination cell
                                c = Color.GREEN;
                                break;
                            default:
                                // allowed cells
                                c = Color.WHITE;
                        }
                        g.setColor(c);
                        // method used to paint filled rectangle
                        g.fillRect(tx, ty, size, size);
                        g.setColor(Color.RED);
                        // method used to paint the rectangle without filling the body
                        g.drawRect(tx, ty,size, size);
                        // incrementing the tx by size we calculated above
                        tx+=size;
                    }
                    // resetting the tx to x value calculated above so that next row cell starts from the same position
                    tx=x;
                    // incrementing the ty so that the height of the cells will be next row
                    ty+=size;
                }

                // painting the path we get from find function which  we call above
                for(int i=0;i<path.size();i+=2){
                    // calculating the x coordinate for path
                    tx = x+(path.get(i+1)*size);
                    // calculating the y coordinate for path
                    ty = y+(path.get(i)*size);
                    // setting the color of the path
                    g.setColor(Color.CYAN);
                    // paint path with half size of the grid cell's size so that we can see which all cell
                    // is included in the path
                    g.fillRect(tx,ty,size/2,size/2);
                }

    }
}