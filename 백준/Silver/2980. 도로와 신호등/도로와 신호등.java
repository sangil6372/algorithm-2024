import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int lightNum = Integer.parseInt(st.nextToken());
		int roadLength = Integer.parseInt(st.nextToken());
		int[][] road = new int[roadLength+1][2];
		
		int times = 0;
		
		// 현재 정보 
		int curLocation = 0;
		// 신호등 정보? -> 도로 정보?
		
		// 도로 상황 정보 		
		for (int i = 0; i < lightNum; i++) {
			st = new StringTokenizer(br.readLine());
			int lightLocation = Integer.parseInt(st.nextToken());
			int redLength = Integer.parseInt(st.nextToken());
			int greenLength = Integer.parseInt(st.nextToken());
			
			road[lightLocation][0] = redLength;
			road[lightLocation][1] = greenLength;
		}
		
		// 신호등 정보는 어디에 저장해?
		while(curLocation<roadLength){
			times++;
			if (road[curLocation][0]!=0) {
				// 해당 신호등 상황 
				if(times%(road[curLocation][0]+road[curLocation][1])>=road[curLocation][0]) {
					// 초록 불이니깐 건너기 
					curLocation++;
				}
				else {
					continue;
				}
			}else {
				curLocation++;
			}
		}
		times++;
		System.out.println(times);
		
		
		
		
		

	}

}
