import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 줄 세우기
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<Integer>[] edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            edges[i] = new ArrayList<>();

        int[] cnt = new int[N + 1]; // 해당 노드의 진입 차수를 기록 기본 0세팅
        boolean[] visited = new boolean[N + 1]; // 방문 여부 체크

        while (M-- > 0) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            cnt[B]++;
            edges[A].add(B);
        }

        // 일단 진입 차수가 0인 것들 먼저 담음
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (cnt[i] == 0) {
                q.add(i);
                visited[i] = true;
            }
        }

        StringBuilder sb = new StringBuilder(); // 나중에 한 번에 출력하기 위함

        while (!q.isEmpty()) {
            int curNode = q.poll(); // 큐의 가장 앞 노드 꺼냄
            sb.append(curNode).append(' ');
            for (int n : edges[curNode]) {
                if (--cnt[n] == 0 && !visited[n]) {
                    q.add(n);
                    visited[n] = true;
                }
            }
        }

        System.out.println(sb);

    }
}
