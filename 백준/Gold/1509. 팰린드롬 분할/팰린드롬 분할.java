import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int[] dp; // dp[i] = i까지의 최소 팰린드롬 분할 수
    static boolean[][] isPalindrome; // isPalindrome[i][j] = i부터 j까지가 팰린드롬인지 여부

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            String str = br.readLine();
            int len = str.length();

            dp = new int[len + 1];
            isPalindrome = new boolean[len][len];

            // 팰린드롬 체크
            for (int end = 0; end < len; end++) {
                for (int start = 0; start <= end; start++) {
                    if (str.charAt(start) == str.charAt(end) && (end - start < 2 || isPalindrome[start + 1][end - 1])) {
                        isPalindrome[start][end] = true;
                    }
                }
            }

            // 최소 분할 팰린드롬 - 메모이제이션
            for (int i = 1; i <= len; i++) {
                dp[i] = Integer.MAX_VALUE; // 일단 초기값 (최소값으로 갱신)
                for (int j = 0; j < i; j++) {
                    if (isPalindrome[j][i - 1]) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }

            bw.write(dp[len] + "\n");
            bw.flush();
        }
    }
}
