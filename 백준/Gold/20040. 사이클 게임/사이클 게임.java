
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[] parents;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); // 점 개수
		m = Integer.parseInt(st.nextToken()); // 진행된 차례 수

		parents = new int[n];
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (union(a,b)==false) { // 서로 부모가 같으면 사이클 형성됨
				bw.write(i+1 + "\n");
				break;
			}
			if (i==m-1) bw.write(0 + "\n");
		}

		br.close();
		bw.flush();

	}

	static int find(int n) {
		if (n == parents[n])
			return n;
		return parents[n] = find(parents[n]);
	}

	static boolean union(int a, int b) {
		int aParent = find(a);
		int bParent = find(b);
		
		if (aParent == bParent) return false;
		else {
			parents[aParent] = bParent;
			return true;
		}
		
	}

}
