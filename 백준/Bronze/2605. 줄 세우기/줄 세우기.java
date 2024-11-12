import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int number = Integer.parseInt(st.nextToken());
    	
    	LinkedList<Integer> list = new LinkedList<>();
    	
    	
    	st = new StringTokenizer(br.readLine());
    	
    	for (int i = 1; i <= number; i++) {
			int n = Integer.parseInt(st.nextToken());
    		if(n==0) {
    			list.add(i);
    		}
    		else {
    			list.add(i-1-n,i);
    		}
		}
    	
    	for (Integer integer : list) {
			System.out.print(integer+" ");
		}
    	
         	
    }
}
