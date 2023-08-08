import java.util.ArrayList;
// Search Class to find the path to destination
public class Search {
    // DFS search function to find the destination from the starting point
    boolean find(int[][] maze, int x, int y, ArrayList<Integer> path){
        // if the cell is destination include the cell's coordinate in the path arrayList
        // and return true
        if(maze[x][y]==9){
            path.add(x);
            path.add(y);
            return true;
        }
        // used to getting coordinate of all four adjacent cells
        int[] dx ={0,0,-1,+1};
        int[] dy = {+1,-1,0,0};
        // if it is allowed cell
        if(maze[x][y]==0){
            // mark it visited
            maze[x][y]=2;
            for(int i=0;i<4;i++){
                // traverse the adjacent cell recursively
                if(find(maze,x+dx[i],y+dy[i],path)){
                    // true returned
                    // add it in the path arrayList
                    path.add(x);
                    path.add(y);
                    // and return true to the caller
                    return true;
                }
            }
        }
        // else return false
        return false;
    }
}
