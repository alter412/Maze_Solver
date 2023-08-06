import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UI extends JFrame {
    private int[][] maze = {{1,1,1,1,1,1,1,1,1,1},
            {1,0,0,0,1,0,0,1,1,1},
            {1,0,0,0,1,0,0,1,1,1},
            {1,0,0,0,1,0,0,1,1,1},
            {1,0,0,0,1,0,0,1,1,1},
            {1,0,0,0,0,0,0,1,1,1},
            {1,0,0,0,1,0,0,1,1,1},
            {1,0,0,0,1,0,0,1,1,1},
            {1,0,0,0,0,0,0,9,1,1},
            {1,1,1,1,1,1,1,1,1,1}};
    private ArrayList<Integer> path = new ArrayList<>();
    UI(){
        super("Maze Solver");
        setLayout(null);
        setSize(700,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        new Search().find(maze,1,1,path);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for(int i=0;i<maze.length;i++){
            Color c ;
            for(int j=0;j<maze[0].length;j++) {
                switch (maze[i][j]) {
                    case 1:
                        c = Color.BLACK;
                        break;
                    case 9:
                        c = Color.RED;
                        break;
                    default:
                        c = Color.WHITE;
                }
                g.setColor(c);
                g.fillRect(j * 30, i * 30, 30, 30);
                g.setColor(Color.RED);
                g.drawRect(j * 30, i * 30, 30, 30);
                g.translate(300,300);
            }
        }
        for(int i=0;i<path.size();i+=2){
            int tx = path.get(i);
            int ty = path.get(i+1);
            g.setColor(Color.GREEN);
            g.fillRect(ty*30,tx*30,20,20);
        }
    }

    public static void main(String[] args) {
        new UI();
    }
}
