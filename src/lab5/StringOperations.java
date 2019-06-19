package lab5;

import java.util.LinkedList;
import java.util.Scanner;

public class StringOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int testcases=input.nextInt();
		String a,order;
		int length,operations;
	
		if(0<=testcases&&testcases<=10){
			for(int i=0;i<testcases;i++){
				LinkedList<String> string=new LinkedList<String>();
				a=input.next();
				length=a.length();
				char [] b=a.toCharArray();
				
				operations=input.nextInt();
				for(int j=0;j<length;j++){
					string.add(String.valueOf(b[j]));
				}//×Ö·û´®´¢´æ½ølinklist
				
				int pos=0,pos2=0;
				
				for(int k=0;k<operations;k++){
					order=input.next();
					switch(order){
					case "Add":
						String value=input.next();
						pos=input.nextInt();
						string.add(pos, value);
						//System.out.println(string);
						printlist(string);
						break;
					case "Delete":
						pos=input.nextInt();
						string.remove(pos);
						//System.out.println(string);
						printlist(string);
						break;
					case "Sstr":
						StringBuffer x=new StringBuffer(string.get(0));
						for(int n=1;n<string.size();n++){
							x.append(string.get(n));
						}
						pos=input.nextInt();
						pos2=input.nextInt();
						String y=x.substring(pos, pos2+1);
						System.out.println(y);
						break;
					case "Reverse":
						pos=input.nextInt();
						pos2=input.nextInt();
						String listToString=tostring(string);
						String part1=listToString.substring(0, pos);
						String part2=listToString.substring(pos,pos2+1);
						String part3=listToString.substring(pos2+1,listToString.length());
						
						StringBuffer reverse=new StringBuffer();
						reverse.append(part2);
						reverse.reverse();
						
						String newString=part1+reverse.toString()+part3;
						int lengthAll=newString.length();
						
						char [] result=newString.toCharArray();
						string.clear();
						
						for(int q=0;q<lengthAll;q++){
							string.add(String.valueOf(result[q]));
						}
						printlist(string);
						break;
					}
					
				}
			}
		}
	}
	public static void printlist(LinkedList<String> a){
		int length=a.size();
		for(int r=0;r<length;r++){
			System.out.print(a.get(r));
		}
		System.out.println( );
	}
	public static String tostring(LinkedList<String> a){
		StringBuffer x=new StringBuffer(a.get(0));
		for(int n=1;n<a.size();n++){
			x.append(a.get(n));
		}
		String y=x.toString();
		return y;
	}

}
