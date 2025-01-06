import java.util.*;

class Solution {
    
    static List<List<Integer>> graph; // static 구현체 
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        graph = new ArrayList<>(); // 우측에 생략하는 이유
        
        for (int i = 0; i <= n; i++){
            graph.add(new ArrayList<>()); //없어도 get이 가능한 이유? -> 나 바본가
        }
        
        for (int[] e : edge){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        // 이제 큐를 이용해서 BFS를 구현하고 최단거리를 저장하는 리스트에 담자 
        List<Integer> routes = new ArrayList<>();
       
        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[n+1];
        Arrays.fill(dist,-1); // -1은 미방문을 의미   boolean과 int 결정 조건
        
        queue.add(1);  // 아 큐는 현재 상태만 넣는건가?
        dist[1] = 0;    
        
        while(!queue.isEmpty()){
            int curNode = queue.poll();     // 현재 노드가 의미하는 바?
            
            for (int next : graph.get(curNode)){  // 이걸 또 next로 해야 되는 이유? 
                if (dist[next]== -1){
                    dist[next] = dist[curNode]+1;
                    queue.add(next);
                }
            }
        }
        int cnt = 0;
        int maxDist = 0;
        for (int d : dist){
            if (d > maxDist){
                maxDist = d;
                cnt = 1;
            }else if (d == maxDist) cnt++;
            
            
        }
        answer = cnt;
        
        return answer;
    }
}