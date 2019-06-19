package lab5;

import java.util.Scanner;

public class abracadabra_new {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int testcases=input.nextInt();
		if(0<=testcases&&testcases<=10){
			for(int m=0;m<testcases;m++){
				int textLength=input.nextInt();
				String text=input.next();
				int patternLength=input.nextInt();
				String pattern=input.next();	
				int lengthBefore=textLength;
				int lengthAfter=0;
				
				while(lengthBefore!=lengthAfter){
					/*if(lengthBefore==lengthAfter){
						break;
					}*/
					lengthBefore=text.length();
					text=text.replace(pattern, "");
					lengthAfter=text.length();
		
				}
				System.out.print(text);	
			}
		}
	}

}
