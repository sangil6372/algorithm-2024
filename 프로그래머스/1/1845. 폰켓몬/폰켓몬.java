import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        // 중복을 허용하지 않는 HashSet을 사용하여 고유한 폰켓몬 종류를 저장
        HashSet<Integer> numsSet = new HashSet<>();

        // nums 배열을 순회하면서 고유한 폰켓몬을 HashSet에 추가
        for (int num : nums) {
            numsSet.add(num);
        }

        // 최대 선택할 수 있는 폰켓몬의 개수는 배열 크기의 절반
        int maxSelectable = nums.length / 2;

        // 고유한 폰켓몬의 개수와 최대 선택 가능한 개수를 비교하여 더 작은 값을 반환
        return Math.min(numsSet.size(), maxSelectable);
    }
}