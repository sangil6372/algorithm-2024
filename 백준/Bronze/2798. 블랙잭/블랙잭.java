import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		
		int n = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] list = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		
		for (int i = 0; i < list.length; i++) {
			for (int j = i+1; j < list.length; j++) {
				for (int k = j+1; k < list.length; k++) {
					int tempSum = list[i] + list[j]+list[k];
					if (tempSum <= M) sum = Math.max(sum, tempSum);
				}
			}
		}
		System.out.println(sum);
	}

}
