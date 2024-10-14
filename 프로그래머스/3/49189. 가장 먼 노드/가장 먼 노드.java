import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0 ;i <= n;i++){
            graph.add(new ArrayList<>());
        }
        
        // 간선 추가 
        for (int[] e : edge){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]); // 양방향 추가 
        }
        
        // 최장 노드를 구하기 위해 최단거리가 필요함! 
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);
        dist[1] = 0;  // 각 노드에서 모든 노드 이건 좀 어려운데 1번 노드에서만 기준으로 하면 간단할 듯?
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        
        while(!queue.isEmpty()){
            int curNode = queue.poll();
            for (int node : graph.get(curNode)){
                if (dist[node] == -1){ // 아직 방문하지 않은 노드 
                    dist[node] = dist[curNode]+1; // 이렇게 최단 거리를 갱신
                    queue.add(node);
                }
            }         
        }
        
        int max = 0;
        int count = 0;    
    
        for (int i = 1;i <= n;i++){
            if (max < dist[i]){
                max = dist[i];
                count = 1;
            }
            else if (max == dist[i]) count++;
        }
        
        
        return count;
    }
}