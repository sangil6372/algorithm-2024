
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	
	static int[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str1 = br.readLine();
        String str2 = br.readLine();
        
        LCS(str1, str2);
        
        System.out.println(dp[str1.length()][str2.length()]);
	}
	
	static void LCS ( String str1, String str2) {
		
		// 개수를 dp에 저장 할 것임 
		dp = new int[str1.length()+1][str2.length()+1];
		
		for (int i=1 ; i<= str1.length(); i++ ) {
			for (int j=1; j <= str2.length() ; j++ ) {
				if (str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		
		
	}

}
