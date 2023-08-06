import java.util.ArrayList;

public class Search {
    boolean find(int[][] maze, int x, int y, ArrayList<Integer> path){
        if(maze[x][y]==9){
            path.add(x);
            path.add(y);
            return true;
        }
        int[] dx ={0,0,-1,+1};
        int[] dy = {+1,-1,0,0};
        if(maze[x][y]==0){
            maze[x][y]=2;
            for(int i=0;i<4;i++){
                if(find(maze,x+dx[i],y+dy[i],path)){
                    path.add(x);
                    path.add(y);
                    return true;
                }
            }
        }
        return false;
    }
}
