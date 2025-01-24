import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[][] board = new int[5][5];

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int step = 0;

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				step++;
				int nextNum = Integer.parseInt(st.nextToken());

				int x = 0;
				int y = 0;
				for (int k = 0; k < 5; k++) {
					for (int k2 = 0; k2 < 5; k2++) {
						if (board[k][k2] == nextNum) {
							x = k;
							y = k2;
							break;
						}
					}
				}

				board[x][y] = 0;
				int bingoCnt = 0;

				int cnt = 0;
				for (int k = 0; k < 5; k++) {
					if (board[k][k] == 0)
						cnt++;
				}
				if (cnt == 5)
					bingoCnt++;

				cnt = 0;
				for (int k = 0; k < 5; k++) {
					if (board[k][4 - k] == 0)
						cnt++;
				}
				if (cnt == 5)
					bingoCnt++;

				for (int k = 0; k < 5; k++) {
					cnt = 0;
					for (int k2 = 0; k2 < 5; k2++) {
						if (board[k][k2] == 0)
							cnt++;
					}
					if (cnt == 5)
						bingoCnt++;
				}
				
				cnt = 0;
				for (int k = 0; k < 5; k++) {
					cnt = 0;
					for (int k2 = 0; k2 < 5; k2++) {
						if (board[k2][k] == 0)
							cnt++;
					}
					if (cnt == 5)
						bingoCnt++;
				}
				
				if (bingoCnt >= 3) {
					System.out.println(step);
					return;
				}

			}
		}

		// 빙고 조건
		// 대각선 or 세로 or 가로

	}
}
