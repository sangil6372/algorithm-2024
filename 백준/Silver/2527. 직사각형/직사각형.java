import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1 ; i <= 4 ;i ++) {
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int x3 = Integer.parseInt(st.nextToken());
			int y3 = Integer.parseInt(st.nextToken());
			int x4 = Integer.parseInt(st.nextToken());
			int y4 = Integer.parseInt(st.nextToken());
			
			
			 // 1. 겹치지 않는 경우 (d)
            if (x3 > x2 || x4 < x1 || y3 > y2 || y4 < y1) {
                sb.append("d\n");
            }
            // 2. 점으로 접촉하는 경우 (c)
            else if ((x2 == x3 && y2 == y3) || (x2 == x3 && y1 == y4) ||
                    (x1 == x4 && y2 == y3) || (x1 == x4 && y1 == y4)) {
               sb.append("c\n");
            }
            else if ((x2==x3)||(x1==x4)||(y2==y3)||(y1==y4)) {
            	sb.append("b\n");
            }
            else {
            	sb.append("a\n");
            }
			
		}
		System.out.println(sb);
		
	}

	

	
}
