import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        
        
        int[][] list = new int[1001][1001];
        
        for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
        	
			for (int j = x; j < x+width; j++) {
				for (int j2 = y; j2 < y+height; j2++) {
					list[j][j2] = i;
				}
			}
		}
        
        for (int i = 1; i <= n; i++) {
        	int sum = 0;
        	for (int j = 0; j < 1001; j++) {
    			for (int j2 = 0; j2 < 1001; j2++) {
    				if (list[j][j2] == i) sum ++;
    			}
    		}
        	System.out.println(sum);
		}
        
        
         	
    }
}
