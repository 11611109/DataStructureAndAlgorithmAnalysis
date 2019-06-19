package lab3;

import java.util.Scanner;

public class lab3_4 {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int testcases=input.nextInt();
		
		
		if(0<=testcases&&testcases<=10){
			for(int i=0;i<testcases;i++){
				int sodier=input.nextInt();//安排string读入，long检查后转换为int?
				int count=input.nextInt();
				
				if(sodier>=1&&sodier<=100&&count>=1&&count<=100){
					Node head=new Node(0);
					Node temp=head;
					for(int k=1;k<sodier;k++){						
						temp.next=new Node(k);
						temp=temp.next;
					}
					temp.next=head;//循环链表
					
					Node countNode=head;
					for(int j=0;j<count-1;j++){
						countNode=countNode.next;
					}
					System.out.println(countNode.value);
				}
				else System.out.print("The number of sodiers and the number of count shoubld be between 1-100.");//如果这里要求用户重新输入除了goto还有什么办法？
			}
			}
		else System.out.print("Test cases should be in 0-10");
		input.close();
		}
	public static class Node{
		int value;
		Node next;
		public Node(int value){
			this.value=value;
			this.next=null;
		}
	}
}
