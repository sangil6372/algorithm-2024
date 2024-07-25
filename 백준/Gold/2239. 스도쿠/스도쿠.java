import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[9][9];

        // 스도쿠 퍼즐 입력 받기
        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

     // 스도쿠 퍼즐 해결
        if (solve(board)) {
            printBoard(board);
        } else {
            System.out.println("No solution exists");
        }
        
        
	}
	
	// 스도쿠 퍼즐을 출력하는 메서드
    public static void printBoard(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
    
    // 스도쿠 퍼즐을 해결하는 백트래킹 메서드
    public static boolean solve(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                	// 이 부분이 핵심 
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            if (solve(board)) {
                                return true;
                            }
                            board[row][col] = 0; // 백트래킹
                        }
                    }
                    return false; // 가능한 숫자가 없으면 false 반환
                    
                }
            }
        }
        return true; // 모든 빈 칸을 채웠으면 true 반환
    }
    
    public static boolean isValid(int[][] board, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            // 같은 행에 같은 숫자가 있는지 검사
            if (board[row][i] == num) {
                return false;
            }
            // 같은 열에 같은 숫자가 있는지 검사
            if (board[i][col] == num) {
                return false;
            }
            // 같은 3x3 격자 안에 같은 숫자가 있는지 검사
            if (board[row - row % 3 + i / 3][col - col % 3 + i % 3] == num) {
                return false;
            }
        }
        return true;
    }
    
}
