class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        String[] str = s.toLowerCase().split(" ", -1);
        
        for (String st : str){
            if (!st.isEmpty()){
                sb.append(Character.toUpperCase(st.charAt(0)));
                sb.append(st.substring(1));

            } 
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        answer = sb.toString();
        
        
        return answer;
    }
}