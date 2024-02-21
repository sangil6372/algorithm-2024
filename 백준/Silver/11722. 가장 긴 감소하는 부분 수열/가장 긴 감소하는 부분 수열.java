import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] arr, location; // arr[i] 가 들어간 위치가 location[i]임 
	static ArrayList<Integer> LIS;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        location = new int[N];
        LIS = new ArrayList<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        reverseArray(arr);
        // N이 1이면?
        // ** N은 1이면 바로 끝내기
     		if (N==1) {
     			System.out.println("1\n");
     			br.close();
     			return;
     		}
     	// 초기값 설정
     	LIS.add(arr[0]);
     	location[0] = 0;

        // 이진 탐색으로 LIS 배열 만들기 
     	for (int i = 1 ; i < N ; i++) {
     		// 값이 작으면 마지막에 추가 
     		if ( arr[i] > LIS.get(LIS.size()-1)) {
     			LIS.add(arr[i]);
     			location[i] = LIS.size()-1;
     		}
     		else {
     			binarySerach(i);
     		}
     		// 값이 작은경우 ! 이진 탐색으로 중간에 추가 (대치?)
     		
     	}
     	bw.write(LIS.size() + "\n");
     	
     	
     	
        bw.flush();
        bw.close();
        br.close();
	}
	
	
	static void binarySerach(int key) {
		int start, end, mid;
		start = 0;
		end = LIS.size()-1;
		
		while (start < end) {
			mid = (start + end)/ 2;
			if (LIS.get(mid)>= arr[key]) {
				end = mid;
			}
			else { 
				start = mid + 1;
			}
		}
		// LIS 갱신 및 위치 기록
		LIS.set(start, arr[key]); // 찾은 곳에 배열 기록 
		location[key] = start; // key번째 배열숫자가 들어간 곳이 start임  
		
	}
     // 배열을 거꾸로 변환하는 메서드
    public static void reverseArray(int[] arr) {
        int start = 0; // 시작 인덱스
        int end = arr.length - 1; // 끝 인덱스

        // 시작 인덱스가 끝 인덱스보다 작은 동안 스왑 수행
        while (start < end) {
            // 시작 인덱스와 끝 인덱스의 원소를 스왑
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            // 다음 인덱스로 이동
            start++;
            end--;
        }
    }
}
