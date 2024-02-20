import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static Integer[][] dp;
	static int[] W, V;
	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()); // 최대 K만큼의 무게만 넣을 수 있음

		dp = new Integer[N][K+1];
		W = new int[N];
		V = new int[N];
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken()); // 각 물건의 무게
			V[i] = Integer.parseInt(st.nextToken()); // 각 물건의 가치
			 
		}
		
		System.out.println(knapsack(N-1, K));
	}

	static int knapsack(int i, int k) { // i번째까지 탐색 했을 때 
		if (i<0) {
			return 0;
		}
		
		// 탐색하지 않은 위치?
		if (dp[i][k]==null) {
			
			if (W[i]> k) {
				dp[i][k] = knapsack(i-1, k);
			}
			else if (W[i] <= k) {
				dp[i][k] = Math.max(knapsack(i-1, k), knapsack(i-1, k - W[i]) + V[i]);
			}
			
		}
		return dp[i][k];
		
		
	}

}
