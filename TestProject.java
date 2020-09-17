package testproject;
import java.util.Scanner;
public class test {
	public static boolean testforone(int[][] array, int ycord, int xcord) {
		if(array[ycord][xcord] == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int[][] array1 = new int[8][8];
		for(int i = 0; i < 8; i++) {
			int [] temp = new int[8];
			String TempBinary = Integer.toBinaryString(Integer.parseInt(console.next(), 16)); 
			while(TempBinary.length() != 8) {
				TempBinary = "0" + TempBinary;
			}//stuffed with 0
			for(int c = 0; c < 8; c ++) {
				array1[i][c] = TempBinary.charAt(c)-'0';
			}
		}
		for(int finish = 0; finish <5; finish++) {
		int[][] array2 = new int[8][8];
		int y = console.nextInt()-1;
		int x = console.nextInt()-1;
		char direction= console.next().charAt(0);
		int run= console.nextInt();
		if(direction == 'L') {
			direction = 'R';
		}
		else if(direction == 'R') {
			direction = 'L';
		}
		else if(direction == 'B') {
			direction = 'A';
		}
		else {//direction == 'A
			direction = 'B';
		}
		//flip
		while(run > 0) {
			x = x%8;
			y = y%8;
			run--;
			if(direction == 'L') {//right
				array2[y][x]++;
				if(testforone(array1, y, x)) {
					if(array2[y][x] == 1) {
						direction = 'B';
						y += 1;
						
					}
					else if(array2[y][x] == 2) {
						direction = 'L';
						x -= 1;
					}
					else if(array2[y][x] == 3) {
						direction = 'A';
						y -= 1;
					}
					else if(array2[y][x] == 4) {
						direction = 'R';
						x += 1;
					}
					
				}
				else {
					x -= 1;
				}
				
			}
			else if(direction == 'R') {//from left
				array2[y][x]++;		
				if(testforone(array1, y, x)) {
					if(array2[y][x] == 1) {
						direction = 'A';
						y -= 1;
					}
					else if(array2[y][x] == 2) {
						direction = 'R';
						x += 1;
					}
					else if(array2[y][x] == 3) {
						direction = 'B';
						y += 1;
					}
					else if(array2[y][x] == 4) {
						direction = 'L';
						x -= 1;
					}
					
				}
				else {
					x += 1;
				}
			}
			else if(direction == 'B') {//from above
				array2[y][x]++;
				if(testforone(array1, y, x)) {
					if(array2[y][x] == 1) {
						direction = 'R';
						x += 1;
					}
					else if(array2[y][x] == 2) {
						direction = 'B';
						y += 1;
					}
					else if(array2[y][x] == 3) {
						direction = 'L';
						x -= 1;
					}
					else if(array2[y][x] == 4) {
						direction = 'A';
						y -= 1;
						
					}
					
				}
				else {
					y += 1;
				}
				
			}
			else {
				array2[y][x]++;
				if(testforone(array1, y, x)) {
					if(array2[y][x] == 1) {
						direction = 'L';
						x -= 1;
					}
					else if(array2[y][x] == 2) {
						direction = 'A';
						y -= 1;
					}
					else if(array2[y][x] == 3) {
						direction = 'R';
						x += 1;
					}
					else if(array2[y][x] == 4) {
						direction = 'B';
						y += 1;
					}
				}
				else {
					y -= 1;
				}
			}		
		}
		System.out.print(y+1);
		System.out.print(", ");
		System.out.println(x+1);
		}
	}
}