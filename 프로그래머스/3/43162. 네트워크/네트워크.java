class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
      
        
        boolean[] visited = new boolean[n];
        
        
        int count = 0;
        
        for (int i = 0 ; i < n; i++){
            if (visited[i] == false){
                dfs(computers, i, visited);
                count ++;
            }   
        }
        return count;
    }
    public static void dfs( int[][] computers, int start, boolean[] visited){
        visited[start] = true;
        
        for (int i = 0 ;i <computers.length; i++){
            if (computers[start][i] == 1 && visited[i] ==false){
                dfs(computers, i, visited);
            }
            
        }
        
        
        
    }
        
}