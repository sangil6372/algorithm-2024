class Solution {
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        
//     간만에 재밌어보이는 문제 발견!
//     우선 문제 보자마자 느낀 것 
//         1. 단순하다 +랑 -로만 이루어졌다
//          ㄴ 숫자 순서는 중요하지 않을 듯
//         2. 경우의 수는 2의 N제곱 이다 
//          ㄴ 순서가 중요하지 않은데 그러면 순서는 어떻게 설정하지?
//         3. 일단 배열을 순회 
//         4. 순회하면서 + or - 로 경우가 나뉨
//         5. 특정 target을 만족하는 경우 count++
//         6. 결국엔 모든 경우의 수를 건드리긴 해야겠네 
//          ㄴ 그렇기엔 2의 20승인데? ㅋㅋ 
//          ㄴ 남은 모든 수를 더해도 작을 경우 back ? -> 백 트래킹 ? 
//          ㄴ 남은 모든 수를 빼도 number보다 클 경우 back ? -> 백트래킹?
        
//         i부터 N까지 더한 값을 저장하는 배열
//         i부터 N까지 뺀 값을 저장하는 배열 
        
        
//         for (int i = 0;i<numbers.length;i++){
//             for( int j = i; j< numbers.length;j++){
//                 plusBack[i] += numbers[j];
//                 minusBack[i] -= numbers[j];
//             }
//         }  --> 와 미쳤다 
        int[] plusBack = new int[numbers.length];
        int[] minusBack = new int[numbers.length]; 
        
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (i == numbers.length - 1) {
                plusBack[i] = numbers[i];
                minusBack[i] = -numbers[i];
            }else {
                plusBack[i] = plusBack[i + 1] + numbers[i];
                minusBack[i] = minusBack[i + 1] - numbers[i];
            }
        }
        
        return backTracking(numbers, target, 0, 0, plusBack, minusBack);
    }
    
        // 오늘은 DFS로 풀어보고 내일 BFS로 풀어보자 
    public static int backTracking(int numbers[], int target, int index, int current, int[] plusBack, int[] minusBack){
        
        if (index == numbers.length){
            return current==target?1:0;
        }
        
        if (current + plusBack[index] < target) return 0;
        if (current + minusBack[index] > target) return 0;
        
        // 이 부분이 가장 헷갈렸는데 그냥 두 경우의 수 각각을 더하는 구나 
        int plusCase = backTracking(numbers, target, index+1, current+numbers[index], plusBack, minusBack);
        int minusCase = backTracking(numbers, target, index+1, current-numbers[index], plusBack, minusBack);
        
        return plusCase + minusCase;
    }
    
}