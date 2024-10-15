import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> a[1]-b[1]);
        
        int curTime = 0;
        int totalTime = 0;
        int jobIdx = 0;
        int completedCnt = 0;
        
        while(completedCnt < jobs.length){
            
            while(jobIdx < jobs.length && jobs[jobIdx][0] <= curTime){
                pq.offer(jobs[jobIdx]);
                jobIdx++;
            }
            
            // 큐에 넣었으니깐 해당 작업들을 전부 쳐내야함 (우선순위대로)
            
            if (!pq.isEmpty()){
                int[] sj =pq.poll();
                curTime+=sj[1];
                totalTime += curTime - sj[0];
                completedCnt++;
            } 
            else curTime = jobs[jobIdx][0];
                
        }

        return (totalTime)/jobs.length;
    }
}