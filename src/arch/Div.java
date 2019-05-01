package arch;

import java.util.Scanner;

public class Div {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		
		int oa = a,ob = b;
		
		while(b!=0){
			int r = a%b;
			a=b;
			b=r;
		}
		System.out.println(a);
	}
}
