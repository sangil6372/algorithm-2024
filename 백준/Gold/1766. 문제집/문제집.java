
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		count = new int[N+1];

		ArrayList<ArrayList<Integer>> a = new ArrayList<>(); // 먼저 풀어야 하는 정보
		for (int i = 0; i <= N; i++) {
			a.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int last = Integer.parseInt(st.nextToken());
			a.get(first).add(last);
			count[last]++;
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 1; i <= N; i++) {  // 쉬운 문제 부터 (먼저 풀어야 하는 문제가 없는 것들 먼저 넣기)
			if (count[i]==0) {
				pq.offer(i);
			}
		}
		
		while(!pq.isEmpty()) {
			int curNum = pq.poll();
			bw.write(curNum + " ");
			
			// 연결된 문제가 있는지 먼저 확인
			for (int nxt : a.get(curNum)) {
				count[nxt]--;
				
				// 먼저 풀어야 하는 문제가 없으면 큐에 넣음 
				if (count[nxt]==0) pq.offer(nxt);
				
			}
		}
		bw.flush();
		bw.close();
		br.close();
		
	}

}
