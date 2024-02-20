
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int test, n;
	static int[] students;
	static boolean[] visited, finished;
	static int soloCnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		test = Integer.parseInt(st.nextToken());
		for (int i = 0; i < test; i++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			students = new int[n + 1];
			visited = new boolean[n + 1];
			finished = new boolean[n + 1];
			for (int j = 1; j <= n; j++) {
				students[j] = Integer.parseInt(st.nextToken());
			}

			soloCnt = n;
			for (int j = 1; j <= n; j++) {
				if (visited[j] == true)
					continue;
				dfs(j);
			}
			// 내가 방문한 건지 이전 서치에서 방문한건지 모호함
			bw.write(soloCnt + "\n");
		}
		bw.flush();
		br.close();
	}

	static void dfs(int n) {
		visited[n] = true;

		int next = students[n]; // 다음 학생
		if (visited[next] == true) { // 다음 학생이 이미 방문한 학생인 경우 순환 구성
			if (!finished[next]) {
				// 사이클 인원 카운트
				soloCnt--;
				while (next != n) {
					next = students[next];
					soloCnt--;
				}
			}
		} else {
			dfs(next); // dfs 확장
		}
		finished[n] = true; // 해당 학생 탐색 종료 
	}
}
