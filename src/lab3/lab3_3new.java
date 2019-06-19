package lab3;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Collections;

public class lab3_3new {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int testcases=input.nextInt();
		int total=0;
		int totalIns,ins;
		int position,value;
		
		if(0<=testcases&&testcases<=50){
			for(int i=0;i<testcases;i++){
				LinkedList<Integer> newList=new LinkedList<Integer>();
				total=input.nextInt();
				for(int j=0;j<total;j++){
					newList.add(input.nextInt());
				}
				totalIns=input.nextInt();
				for(int k=0;k<totalIns;k++){
					ins=input.nextInt();
					switch(ins){
					case 1:
						position=input.nextInt();
						value=input.nextInt();
						newList.add(position, value);
						total++;
						break;
					case 2:
						position=input.nextInt();
						newList.remove(position);
						total--;
						break;
					case 3:
						position=input.nextInt();
						value=input.nextInt();
						newList.set(position, value);
						break;
					case 4:
						Collections.reverse(newList);
						break;
					default:
						System.out.print("Wrong instruction!It should be a integer between 1 and 4.");
						break;
					}
					for(int p=0;p<total;p++){
						System.out.print(newList.get(p)+" ");	
					}
					System.out.println( );
					
				}
			}
		}
		else System.out.print("Test cases should be in 0-50");
	}


}
