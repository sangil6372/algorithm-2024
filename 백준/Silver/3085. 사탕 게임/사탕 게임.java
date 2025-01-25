import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		char[][] board = new char[N][N];

		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}
		int[] dx = { 0, 0, 1, -1 };
		int[] dy = { 1, -1, 0, 0 };
		
		int curX = 0;
		int curY = 0;
		int maxCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < 4; j2++) {
					curX = i;
					curY = j;
					int nX = i + dx[j2];
					int nY = j + dy[j2];
					if (nX<0||nX>=N||nY<0||nY>=N) continue;
					if (board[curX][curY]== board[nX][nY]) continue;
					switchArr(board, curX, curY, nX, nY);
					maxCnt = Math.max(maxCnt,countArr(board, N));
					switchArr(board, curX, curY, nX, nY);
				}
			}
		}
		System.out.println(maxCnt);
	}
	public static void switchArr(char[][] board, int curX, int curY,int nX,int nY) {
		char tmp = board[curX][curY];
		board[curX][curY] = board[nX][nY];
		board[nX][nY] = tmp;
	}
	
	
	public static int countArr(char[][] arr, int N) {
		int maxCnt = 1;
		for (int i = 0; i < N; i++) {
			int cnt = 1;
			char prevChar = arr[i][0];
			for (int j = 1; j < N; j++) {
				if(prevChar==arr[i][j]) {
					cnt++;
					maxCnt = Math.max(maxCnt,cnt);
				}
				else {
					cnt = 1;
				}
				prevChar = arr[i][j];
			}
		}
		for (int j = 0; j < N; j++) {
			int cnt = 1;
			char prevChar = arr[0][j];
			for (int i = 1; i < N; i++) {
				if(prevChar==arr[i][j]) {
					cnt++;
					maxCnt = Math.max(maxCnt,cnt);
				}
				else {
					cnt = 1;
				}
				prevChar = arr[i][j];			}
		}
		
		return maxCnt;
	}
}
