import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int H = Integer.parseInt(st.nextToken());
    	int W = Integer.parseInt(st.nextToken());
    	
    	char[][] list =  new char[H][W];
    	int[][] result = new int[H][W];
    	
    	for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				result[i][j] = -1;
			}
		}
    	
    	for (int i = 0; i < H; i++) {
			st =  new StringTokenizer(br.readLine());
			char[] row = st.nextToken().toCharArray();
    		for (int j = 0; j < W; j++) {
				char temp = row[j];
    			if (temp == 'c') {
    				for (int k = j; k < W; k++) {
						result[i][k] = k-j;
					}
    			}
			}
    		for (int j = 0; j < W; j++) {
				System.out.print(result[i][j]+" ");
			}
    		System.out.println();
		}
    	
    	
    	
    	
    	
    	
    }   
}
