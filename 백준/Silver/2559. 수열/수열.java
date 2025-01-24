import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] arr = new int[N+1];
		
		int max = -50000000;
		for (int i = 1;i<=N;i++) {
			arr[i] = sc.nextInt() + arr[i-1];
			if (i>=K) {
				if (max<arr[i]-arr[i-K]) max = arr[i]-arr[i-K];
			}
		}
		
		
		
		
		System.out.println(max);
		
		sc.close();
	}

}
