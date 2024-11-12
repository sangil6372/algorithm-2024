import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] list = new int[R + 1][C + 1];

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int target = Integer.parseInt(br.readLine());

        // 목표 값이 전체 좌석 수를 초과할 경우 처리
        if (target > R * C) {
            System.out.println(0);
            return;
        }

        int x = 1, y = 1;
        
        int dist = 0;

        for (int i = 1; i <= target; i++) {
            list[y][x] = 1;
            if (i == target) {
                System.out.println(x + " " + y);
                break;
            }

            int nx = x + dx[dist];
            int ny = y + dy[dist];

            // 유효한 범위 및 미방문 좌석 확인
            if (ny >= 1 && ny <= R && nx >= 1 && nx <= C && list[ny][nx] == 0) {
                x = nx;
                y = ny;
            } else {
                dist = (dist + 1) % 4;  // 방향 전환
                i--;
            }
        }
    }
}
