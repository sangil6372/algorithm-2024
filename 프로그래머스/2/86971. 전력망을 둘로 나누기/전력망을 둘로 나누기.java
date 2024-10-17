import java.util.*;


class Solution {
    public int solution(int n, int[][] wires) {
        int answer = -1;
        
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0 ; i < n+1 ;i++){
            graph.add(new ArrayList<>());
        }
        
        
        for (int i = 0 ; i < wires.length;i++){
            graph.get(wires[i][0]).add(wires[i][1]);
            graph.get(wires[i][1]).add(wires[i][0]);
        }
        
        int minDiff = Integer.MAX_VALUE;
        
        for (int i = 0 ; i < wires.length; i++){
            graph.get(wires[i][0]).remove(Integer.valueOf(wires[i][1]));
            graph.get(wires[i][1]).remove(Integer.valueOf(wires[i][0]));
            
            int cnt1 = bfs(graph,wires[i][0], n);
            int cnt2 = bfs(graph, wires[i][1], n);
            
            minDiff = Math.min(minDiff, Math.abs(cnt1-cnt2));
            
            graph.get(wires[i][0]).add(wires[i][1]);
            graph.get(wires[i][1]).add(wires[i][0]);
        }
        
        return minDiff;
    }
    
    public static int bfs(List<List<Integer>> graph, int start, int n){
        boolean visited[] = new boolean[n+1];
        visited[start] = true;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        
        int count = 0;
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            count++;
            
            // 인접한 노드들을 다 탐색해야 함 
            for (int nod : graph.get(node)){
                if (visited[nod]==false){
                    visited[nod] = true;
                    queue.add(nod);
                }
            }
        }
        return count;
    }
}