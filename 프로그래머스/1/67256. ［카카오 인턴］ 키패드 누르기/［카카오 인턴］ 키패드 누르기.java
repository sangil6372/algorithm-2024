class Solution {
    public String solution(int[] numbers, String hand) {
        
        StringBuilder sb = new StringBuilder();
        
        // hand는 "left" 또는 "right" 입니다. 
        // 147 -> left 369->right
        // 거리 구하는 함수는 필요 
        
        // 초기 값 갱신
        int left = 10;
        int right = 12;
        
        for (int n : numbers){
            if ( n==1 || n==4 || n==7){
                left = n;
                sb.append("L");
            }else if  ( n==3 || n==6 || n==9){
                right = n;
                sb.append("R");
            }else{
                if (n==0) n = 11;
                
                // 거리 계산 필요 
                int leftDist = Math.abs(n-left)/3 + Math.abs(n-left)%3;
                int rightDist = Math.abs(n-right)/3 + Math.abs(n-right)%3;
                
                if (leftDist>rightDist){
                    right = n;
                    sb.append("R");
                }else if (leftDist<rightDist){
                    left = n;
                    sb.append("L");
                }else{
                    if (hand.equals("right")){
                        right = n;
                        sb.append("R");
                    }else if (hand.equals("left")){
                        left = n;
                        sb.append("L");
                    }
                }
                
                
                
            }
            
            
            
        }
        
        
        
        
        
        return sb.toString();
    }
}