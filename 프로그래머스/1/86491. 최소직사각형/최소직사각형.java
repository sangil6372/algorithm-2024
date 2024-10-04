
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        // 그냥 긴 걸 세로로 할까?
        int height = 0;
        int width = 0;
        
        for (int[] wallet : sizes ){
            int h = Math.max(wallet[0],wallet[1]);
            int w = Math.min(wallet[0],wallet[1]);
                
            height = Math.max(h, height);
            width = Math.max(w, width);
        }
        answer = height*width;
        
        return answer;
    }
}