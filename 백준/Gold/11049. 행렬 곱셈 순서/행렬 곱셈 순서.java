
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static class info {
		int row, col;

		public info(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}

	static info[] input;
	static int[][] dp;
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine());
		dp = new int[n + 1][n + 1];
		input = new info[n + 1];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			input[i] = new info(a, b);
			for (int j = 1; j <= n; j++) {
				dp[i][j] = Integer.MAX_VALUE; // 이부분 max 말고 어짜피 0은 있을 수 없으니깐 0고려해도 될 듯
			}
		}
		// 3개를 입력 받는다고 할 떄 0번 1번 2번 이렇게 3개의 노드가 있음
		// 결국 마지막에는 dp[0][n-1] 값을 출력하면 됨
		System.out.println(divideConquer(0, n - 1));

	}

	static int divideConquer(int start, int end) {
		if (start == end) {
			return 0;
		}

		// 갱신된 적 있으면
		if (dp[start][end] != Integer.MAX_VALUE) {
			return dp[start][end];
		}

		int left, right;
		for (int i = start; i < end; i++) { // 부분 정복
			// start,i i+1 end가 dp[start][end] 보다 작으면 갱신
			left = divideConquer(start, i);
			right = divideConquer(i + 1, end);

			// *POINT* 항상 순서대로 곱셈 가능한 크기만 입력으로 주어짐
			dp[start][end] = Math.min(dp[start][end],
					left + right + (input[start].row * input[i].col * input[end].col));
		}

		return dp[start][end];
	}

}
