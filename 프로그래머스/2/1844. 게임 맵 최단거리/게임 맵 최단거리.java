import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        
        int n = maps.length;
        int m = maps[0].length;
        
        
        int[] dx = new int[]{0,0,1,-1};
        int[] dy = new int[]{1,-1,0,0};
        
        boolean visited[][] = new boolean[n][m];
        
        int[][] dist =  new int[n][m];
        dist[0][0] = 1;
        
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            int[] curNode = queue.poll();
            
            
            int x = curNode[0];
            int y = curNode[1];
            
            if (x == n-1 && y == m-1){
                return dist[x][y];
            }
            
            for (int i = 0 ;i < 4; i++){
                int nx = x +dx[i];
                int ny = y +dy[i];
                
                if ( nx>=0 && ny>=0 && nx <n &&ny <m && maps[nx][ny] ==1 ){
                    if (visited[nx][ny]==false){
                        visited[nx][ny]=true;
                        dist[nx][ny] = dist[x][y] + 1;
                        queue.add(new int[]{nx,ny});
                    }
                }
            
                
            }
            
                
        }
        
            
        
        
        return -1;
    }
}