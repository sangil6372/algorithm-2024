import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N; // 최대 N개의 도시
	static int[][] W;
	static final int INF = 16_0000_00; // 각 선분의 길이 최대 1,000,000
	static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		W = new int[N][N]; // 선분의 정보
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				W[i][j] = Integer.parseInt(st.nextToken());
		}
		dp = new int[N][(1 << N) - 1]; // 비트마스킹이 되지 않은 도시들을 모두 방문한 뒤 돌아오는 최소 비용
		// ex ) dp[1][1010] 0번 2번 도시를 방문 한 후 최소 비용임
		for (int i = 0; i < N; i++)
			Arrays.fill(dp[i], -1); // 초기 값 설정

		bw.write(dfs(0, 1) + "\n");
		bw.flush();
		br.close();
	}

	static int dfs(int now, int visit) {
		if (visit == (1 << N) - 1) { // 모든 도시를 다 지났으면 출발 도시로 돌아가면 됨
			// now -> 출발 도시로 가는 경로가 존재하면 돌아갈 수 있음
			if (W[now][0] == 0)
				return INF;
			return W[now][0];
		}

		if (dp[now][visit] != -1)
			return dp[now][visit];
        dp[now][visit] = INF;
        
		for (int i = 0; i < N; i++) {
			if ((visit & (1 << i)) == 0 && W[now][i] != 0) {
				dp[now][visit] = Math.min(dp[now][visit], W[now][i] + dfs(i, visit | (1 << i)));
			}

		}
		return dp[now][visit];
	}

}
