import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int L = Integer.parseInt(st.nextToken());
    	
    	
    	int time = 0;
    	int curPosition = 0;
    	
    	
    	for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int D = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int G = Integer.parseInt(st.nextToken());
    		
			
			time += (D-curPosition);
			curPosition = D;
			
			int signalTime = time % (R+G);
			if (signalTime < R) {
				time += (R-signalTime);
			}
		}
    	
    	time += (L-curPosition);
    	System.out.println(time);
    	
    	
    	
    }   
}
