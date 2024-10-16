class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int total = brown + yellow;
        
        for (int width = 3; width <=total/3 ; width ++){
            int height = total/width;
            
            if ( total == width*height && (width*2+(height-2)*2 == brown)){
                answer[0] = Math.max(width,height);
                answer[1] = Math.min(width,height);
                return answer;
            }
            
        }
        
        
        return answer;
        
    }
}