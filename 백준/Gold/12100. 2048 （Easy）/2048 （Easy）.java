
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, answer, map[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		answer = 0;

		map = new int[n][n];
		StringTokenizer stz;
		for (int i = 0; i < n; i++) {
			stz = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				map[i][j] = Integer.parseInt(stz.nextToken());
		}
		// 2048 시행
		game(0);

		System.out.println(answer);
	}

	static void game(int count) {
		if (count == 5) { // 마지막 경우에만 max 갱신
			findMax();
			return;
		}
		int copy[][] = new int[n][n];
		for (int i = 0; i < n; i++)
			copy[i] = map[i].clone(); // 클론 배열 만듦 ( 원상복구 시키는 용도 )

		for (int i = 0; i < 4; i++) {
			move(i); // 각 방향대로 움직임 -> 배열 갱신
			game(count + 1);
			for (int a = 0; a < n; a++)
				map[a] = copy[a].clone(); // 배열 원상복구
		}
	}

	static void move(int dir) {
		switch (dir) {
		case 0: // 위로 몰기
			for (int i = 0; i < n; i++) { // 각 세로줄 위로 올림
				int block = 0; // 임시 블럭
				int index = 0; // 임시 인덱스 위에 해당하는 인덱스 index 0부터 갱신해야함
				for (int j = 0; j < n; j++) {
					if (map[j][i] == 0)
						continue;
					if (block == map[j][i]) // 위에 블럭과 현재 블록이 같으면? 위에 인덱스에 해당하는 블럭 갱신
					{
						map[index - 1][i] = block * 2;
						block = 0; // 블럭 초기화
						map[j][i] = 0;
					} else {
						block = map[j][i];
						map[j][i] = 0;
						map[index][i] = block;
						index++;
					}
				}
			}
			break;
		case 1: // 아래로 몰기
			for (int i = 0; i < n; i++) { // 각 세로줄 위로 올림
				int block = 0; // 임시 블럭
				int index = n-1; // 임시 인덱스 위에 해당하는 인덱스 index 0부터 갱신해야함
				for (int j = n-1; j >=0; j--) {
					if (map[j][i] == 0)
						continue;
					if (block == map[j][i]) // 위에 블럭과 현재 블록이 같으면? 위에 인덱스에 해당하는 블럭 갱신
					{
						map[index + 1][i] = block * 2;
						block = 0; // 블럭 초기화
						map[j][i] = 0;
					} else {
						block = map[j][i];
						map[j][i] = 0;
						map[index][i] = block;
						index--;
					}
				}
			}
			break;
		case 2: // 왼쪽으로 몰기
			for (int i = 0; i < n; i++) { // 각 세로줄 위로 올림
				int block = 0; // 임시 블럭
				int index = 0; // 임시 인덱스 위에 해당하는 인덱스 index 0부터 갱신해야함
				for (int j = 0; j < n; j++) {
					if (map[i][j] == 0)
						continue;
					if (block == map[i][j]) // 위에 블럭과 현재 블록이 같으면? 위에 인덱스에 해당하는 블럭 갱신
					{
						map[i][index-1] = block * 2;
						block = 0; // 블럭 초기화
						map[i][j] = 0;
					} else {
						block = map[i][j];
						map[i][j] = 0;
						map[i][index] = block;
						index++;
					}
				}
			}
			break;
		case 3: // 오른족으로 몰기
			for (int i = 0; i < n; i++) { // 각 세로줄 위로 올림
				int block = 0; // 임시 블럭
				int index = n-1; // 임시 인덱스 위에 해당하는 인덱스 index 0부터 갱신해야함
				for (int j = n-1; j >= 0; j--) {
					if (map[i][j] == 0)
						continue;
					if (block == map[i][j]) // 위에 블럭과 현재 블록이 같으면? 위에 인덱스에 해당하는 블럭 갱신
					{
						map[i][index+1] = block * 2;
						block = 0; // 블럭 초기화
						map[i][j] = 0;
					} else {
						block = map[i][j];
						map[i][j] = 0;
						map[i][index] = block;
						index--;
					}
				}
			}
			break;

		default:
			break;
		}

	}

	public static void findMax() {
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				answer = Math.max(answer, map[i][j]);
	}
}
