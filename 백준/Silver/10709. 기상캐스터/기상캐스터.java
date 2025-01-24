import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		char[][] sky = new char[H + 1][W + 1];

		for (int i = 0; i < H; i++) {
			sky[i] = br.readLine().toCharArray();

			for (int j = 0; j < W; j++) {
				int steps = 0;
				for (int k = j; k >= 0; k--) {
					if (sky[i][k] == 'c') { // equals 비교
						sb.append(steps+" ");
						break;
					}
					steps++;
					if (k==0) {
						sb.append(-1+" ");
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
