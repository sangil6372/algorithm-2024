import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // BufferedReader, StringTokenizer
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bReader.readLine());

        // 길이가 N인 직선
        // 심판 M명을 적절한 곳에 배치
        // 미리 정해진 K개의 곳에만 위치
        // 가장 가까운 두 심판의 거리를 최대로

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] spot = new int[K];

        st = new StringTokenizer(bReader.readLine());
        for (int i = 0; i < K; i++) {
            spot[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 정렬
        Arrays.sort(spot);

        // 이진탐색 범위 설정
        int start = 0;
        int end = N;
        String result = "";

        while (start <= end) {
            int mid = (start + end) / 2;
            String res = "1";
            int cnt = 1;
            int pre = spot[0];
            for (int i = 1; i < K; i++) {
                if (spot[i] - pre >= mid) {
                    res += "1";
                    cnt++;
                    pre = spot[i];
                    if (cnt >= M) break;
                }else {
                	res += "0";
                }
            }
            while (res.length() < K) {
                res += "0";
            }

            if (cnt >= M) {
                start = mid + 1;
                result = res;
            } else {
                end = mid - 1;
            }
        }

        // 결과 출력
        System.out.println(result);
    }
}
