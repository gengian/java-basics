package demo;

import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("hello world");
		Scanner sc = null;
		while(true) {
			System.out.print("please input word:");
			sc = new Scanner(System.in);
			String line = sc.nextLine();
			if("e".equals(line)) break;
			System.out.println(line);
		}
		if(sc != null) sc.close();

	}

}
