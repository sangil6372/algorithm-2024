class Solution {
    static int maxCnt = 0;
    
    public int solution(int k, int[][] dungeons) {
        
        boolean[] visited = new boolean[dungeons.length]; // 방문 여부를 체크하는 배열
        dfs(k, dungeons, visited, 0);
        
        
        return maxCnt;
    }
    
    public static void dfs (int k, int[][] dungeons, boolean[] visited, int count){
        maxCnt = Math.max(maxCnt, count);
        
        
        for (int i = 0; i <dungeons.length; i++){
            if (visited[i]==false && dungeons[i][0] <= k){        
                visited[i] = true;
                dfs (k - dungeons[i][1], dungeons, visited, count+1);
                visited[i] = false; // backtracking
            }
        }
        
    }
    
}