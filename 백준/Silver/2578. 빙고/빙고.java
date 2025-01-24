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

				for (int k = 0; k < 5; k++) {
					for (int k2 = 0; k2 < 5; k2++) {
						if (board[k][k2] == nextNum) {
							board[k][k2] = 0;
							if (countBingo(board) >= 3) {
								System.out.println(step);
								return;
							}
						}
					}
				}
			}
		}
	}

	public static int countBingo(int[][] board) {
		int bingoCnt = 0;

		// 좌상우하 대각선 체크
		int cnt = 0;
		for (int k = 0; k < 5; k++) {
			if (board[k][k] == 0)
				cnt++;
		}
		if (cnt == 5)
			bingoCnt++;
		// 우상좌하 대각선 체크
		cnt = 0;
		for (int k = 0; k < 5; k++) {
			if (board[k][4 - k] == 0)
				cnt++;
		}
		if (cnt == 5)
			bingoCnt++;
		// 가로 줄 체크
		for (int k = 0; k < 5; k++) {
			cnt = 0;
			for (int k2 = 0; k2 < 5; k2++) {
				if (board[k][k2] == 0)
					cnt++;
			}
			if (cnt == 5)
				bingoCnt++;
		}
		// 세로 줄 체크
		for (int k = 0; k < 5; k++) {
			cnt = 0;
			for (int k2 = 0; k2 < 5; k2++) {
				if (board[k2][k] == 0)
					cnt++;
			}
			if (cnt == 5)
				bingoCnt++;
		}
		// 모든 케이스 마다 빙고 카운트를 가져옴 <- 메소드로 구현했다면 return 값
		return bingoCnt;
	}

}
