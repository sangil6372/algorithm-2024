import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

//		int[] graph = new int[1001];
		List<int[]> list = new ArrayList<int[]>();
		
		int N = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			list.add(new int[] {idx,height});
//			graph[idx] = height;
		}
		Collections.sort(list, (n1,n2)-> n1[0]-n2[0]);
		
		int maxIdx = 0;
		int maxHeight = 0;
		
		for (int i = 0; i < list.size(); i++) {
			int height = list.get(i)[1];
			if(maxHeight<height) {
				maxIdx = i;
				maxHeight = height;
			}
		}
		
		
		int total = maxHeight;
		
		int prevLoc = list.get(0)[0];
		int prevHeight = list.get(0)[1];
		
		for (int i = 1; i<=maxIdx; i++) {
			int curHeight = list.get(i)[1];
			int curLoc = list.get(i)[0];
			if (prevHeight>=curHeight) continue;
			total += (curLoc-prevLoc)*prevHeight;
			prevHeight = curHeight;
			prevLoc = curLoc;
		}
		prevLoc = list.get(list.size() - 1)[0];
		prevHeight = list.get(list.size() - 1)[1];
		for (int i = list.size()-2; i>=maxIdx; i--) {
			int curHeight = list.get(i)[1];
			int curLoc = list.get(i)[0];
			if (prevHeight>curHeight) continue;
			total += (prevLoc - curLoc)*prevHeight;
			prevHeight = curHeight;
			prevLoc = curLoc;
		}
		
		System.out.println(total);
	}

}
