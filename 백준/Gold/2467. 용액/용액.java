
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] arr;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int p1,p2;
		int pointer1 = 0;
		int pointer2 = arr.length - 1;
		p1 = pointer1;
		p2 = pointer2;
		int std = Integer.MAX_VALUE;
		while (pointer1 < pointer2) {
			int sum = arr[pointer1] + arr[pointer2];

			if (std > Math.abs(sum)) {
				std = Math.abs(sum);
				p1 = pointer1;
				p2 = pointer2;
			}
			
		
			if (sum > 0) {
				pointer2--;
			} else if (sum < 0) {
				pointer1++;
			}
			else {
				p1 = pointer1;
				p2 = pointer2;
				break;
			}
		}
		bw.write(arr[p1] + " " + arr[p2]);
		
		bw.flush();
		bw.close();
		br.close();
	}
}
