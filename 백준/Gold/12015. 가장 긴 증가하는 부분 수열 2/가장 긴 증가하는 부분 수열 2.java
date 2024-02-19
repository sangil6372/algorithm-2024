import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] seq = new int[N];
		int[] LIS = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}

		// 최대 길이를 구해야 함
		// 풀이 1 부분 수열을 통째로 사이즈를 늘려가면서 갱신해나감 -> 너무 많은 갱신이 필요
		// 풀이 2 길이에만 포커스를 맞춰서 대치해서 품

		// 마지막 값보다 크면 뒤에 붙임
		// 그게 아니라면 중간에 끼어넣음 ? no 불가능
		// 그러면 대치?
		// ex ) 10 20 30 15 18 19 -> 10 20 30 -> 10 15 30 -> 10 15 18 -> 10 15 18 19

		LIS[0] = seq[0]; // 초기 값
		int length = 1;

		for (int i = 1; i < N; i++) {
			
			int key = seq[i]; // 이걸로 이분 탐색을 할 거임 
			
			if (LIS[length-1]<key) {
				length++;
				LIS[length-1] = key;
			}
			else {
				// 이분탐색 시작
				int start = 0;
				int end = length - 1;
				while (start<= end) {
					int mid = (start+end)/2;
					if (LIS[mid] < key) {
						start = mid+1;
					}
					else  { 
						end = mid-1;
					}
				}
				// 다 수행하면 start 위치가 가장 가까운 수임 
				LIS[start] = key;
			}
		}
		
		System.out.println(length);
		
	}

}
