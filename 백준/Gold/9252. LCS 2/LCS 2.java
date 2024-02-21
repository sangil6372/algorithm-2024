import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	static int[][] dp;
	static BufferedWriter bw;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str1 = br.readLine();
		String str2 = br.readLine();

		LCS(str1, str2);
		
		bw.flush();
		bw.close();
		br.close();
	}

	static void LCS(String str1, String str2) throws IOException {

		// 개수를 dp에 저장 할 것임
		dp = new int[str1.length() + 1][str2.length() + 1];

		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		Stack<Character> stack = new Stack<>();

		int s1 = str1.length();
		int s2 = str2.length();

		while (s1 > 0 && s2 > 0) {
			if (s1 == 0 || s2 == 0) break; // 둘 중 하나가 다 떨어지면 그만
			// 모서리를 찾는 과정
			if (dp[s1][s2] == dp[s1-1][s2]) {
				s1--;
			}
			else if (dp[s1][s2] == dp[s1][s2-1]) {
				s2--;
			}
			else { // 절벽구간 찾으면 
				stack.push(str1.charAt(s1-1));
				s1--; s2--;
			}
		}
		
		System.out.println(dp[str1.length()][str2.length()]);
		while(!stack.isEmpty()) {
			bw.write(stack.pop());
		}
		

	}

}
