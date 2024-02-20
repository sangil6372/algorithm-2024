
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int[] dp;
	static int[] W, V;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		W = new int[N];
		V = new int[N];

		// 최소 비용 V으로 M이상의 메모리를 확보하는 문제 
		// V[i]의 전체 합 -> cost 
		// dp  0~cost 까지 갱신 (dp[비용] 은 특정 비용으로 확보하는 최대메모리 
		// 점화식 dp[j] = Math.max(dp[j], dp[j - V[i]] + W[i]);
		// j만큼의 비용을 가지고 있을 때 메모리 최대값은 i번째 비용을 뺀 dp[j - V[i]] 에서 i번째 메모리를 고려한 값을 비교한 것
		// dp를 0부터 ~ 차례로 갱신하는게 아니라 여러번 갱신
		
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			W[i] = Integer.parseInt(st.nextToken()); // 각 물건의 무게
		}

		int cost = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			V[i] = Integer.parseInt(st.nextToken()); // 각 물건의 가치
			cost += V[i];
		}

		// cost의 총합을 이용해서 dp를 만든다?
		dp = new int[cost + 1]; // 특정 비용에 대해 최대의 메모리 사용 계산
		for (int i = 0; i < N; i++) { // 1~N번째까지의 가치
			for (int j = cost; j >= V[i] ; j--) {	// 
				dp[j] = Math.max(dp[j], dp[j - V[i]] + W[i]);
			}
		}
		
		for (int i = 0; i <= cost; i++) {
			if (dp[i] >= M) {
				bw.write(i + "\n");
				break;
			}
		}
		br.close();
		bw.flush();
	}

}
