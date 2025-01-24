import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc =  new Scanner(System.in);
		
		int N = sc.nextInt(); // 스캐너는 왜 넥스트 인트?
		Map<Integer, Integer> map = new HashMap<>();
		
		// 3과 5로 만들 수 있는 수 ?
		for(int i = 0; i <= N/3 ; i++) {
			if (i==0) {
				if (N%5==0) {
					map.put(i,N/5);
				}
			}else {
				if ((N-3*i)%5==0) {
					map.put(i,(N-3*i)/5);
				}
			}
		}
		if (map.size()==0) {
			System.out.println(-1);
			return; 
		}
		int minNum = Integer.MAX_VALUE;
		for (Entry<Integer,Integer> entry : map.entrySet()) {
			minNum = Math.min(minNum,entry.getKey()+entry.getValue());
		}
		System.out.println(minNum);
	}

}
