package lab3;//ÏµÊý double

import java.util.Scanner;

public class lab3_2 {
	public static void main(String[] args) {
	Scanner input=new Scanner(System.in);
	int testcases=input.nextInt();
	int branch1;
	int branch2;
	
	if(0<=testcases&&testcases<=100){
		for(int i=0;i<testcases;i++){
			branch1=input.nextInt();
		
			if(branch1>=0&&branch1<=1000){
				
				Node head1=new Node(input.nextInt(),input.nextInt());
				Node temp=head1;
				for(int k=0;k<(branch1-1);k++){						
					temp.next=new Node(input.nextInt(),input.nextInt());
					temp=temp.next;
				}
				branch2=input.nextInt();
				if(branch2>=0&&branch2<=1000){
					Node head2=new Node(input.nextInt(),input.nextInt());
					Node temp2=head2;
					for(int j=0;j<(branch2-1);j++){
						temp2.next=new Node(input.nextInt(),input.nextInt());
						temp2=temp2.next;
					}

					Node result=addPolynomial(head1,head2);
					
					if(result==null){
						System.out.print("No input");
					}
					printHead(result);
					Node now=result.next;
					while(now!=null){
						printPoly(now);
						now=now.next;
					}
				}
				else System.out.println("Input error!");
			}
			else System.out.println("Input error!");
		}
		}
	else System.out.print("Test cases should be 0-100");
	}
	public static class Node{
		int coefficient;
		int exponent;
		Node next;
		public Node(int value1,int value2){
			this.coefficient=value1;
			this.exponent=value2;
		}
	}
	public static Node addPolynomial(Node head1,Node head2){
		if(head1==null)
			return head2;
		if(head2==null)
			return head1;
		if(head1.exponent<head2.exponent){
		    head1.next=addPolynomial(head1.next,head2);
		    return head1;
		}
		else if(head1.exponent>head2.exponent){
			head2.next=addPolynomial(head2.next,head1);
			return head2;
		}
		else{
			head1.coefficient=head1.coefficient+head2.coefficient;
			head1.next=addPolynomial(head1.next,head2.next);
			return head1; 
		}
	}
	public static void printPoly(Node current){
		if(current.exponent!=1&&current.exponent!=0){
		if(current.coefficient>=0){
			if(current.coefficient!=0&&current.coefficient!=1){
				System.out.print("+"+current.coefficient+"x^"+current.exponent);
			}
			else if(current.coefficient==0){
			}
			else{
				System.out.print("+x^"+current.exponent);
			}
			}
			else {
				if(current.coefficient!=-1){
					System.out.print(current.coefficient+"x^"+current.exponent);
				}
				else if(current.coefficient==-1){
					System.out.print("-"+"x^"+current.exponent);
				}
			}
		}
		else if(current.exponent==1){
			if(current.coefficient>=0){
			if(current.coefficient!=0&&current.coefficient!=1){
				System.out.print("+"+current.coefficient+"x");
			}
			else if(current.coefficient==0){
			}
			else{
				System.out.print("x");
			}
			}
			else {
				if(current.coefficient!=-1){
					System.out.print(current.coefficient+"x");
				}
				else if(current.coefficient==-1){
					System.out.print("-"+"x");
				}
			}
		}
		else if(current.exponent==0){
			if(current.coefficient>=1){
				System.out.print("+"+current.coefficient);
			}
			else if(current.coefficient==0){
			}
			else if(current.coefficient==-1){
				System.out.print(current.coefficient);
			}
			else if(current.coefficient<-1){
				System.out.print(current.coefficient);
			}
		}
	}
	public static void printHead(Node current){

		if(current.exponent!=1&&current.exponent!=0){
		if(current.coefficient>=0){
			if(current.coefficient!=0&&current.coefficient!=1){
				System.out.print(current.coefficient+"x^"+current.exponent);
			}
			else if(current.coefficient==0){
			}
			else{
				System.out.print("x^"+current.exponent);
			}
			}
			else {
				if(current.coefficient!=-1){
					System.out.print(current.coefficient+"x^"+current.exponent);
				}
				else if(current.coefficient==-1){
					System.out.print("-"+"x^"+current.exponent);
				}
			}
		
		}
		else if(current.exponent==1){
			if(current.coefficient>=0){
			if(current.coefficient!=0&&current.coefficient!=1){
				System.out.print(current.coefficient+"x");
			}
			else if(current.coefficient==0){
			}
			else{
				System.out.print("x");
			}
			}
			else {
				if(current.coefficient!=-1){
					System.out.print(current.coefficient+"x");
				}
				else if(current.coefficient==-1){
					System.out.print("-"+"x");
				}
			}
		}
		else if(current.exponent==0){
			if(current.coefficient!=0){
				System.out.print(current.coefficient);
			}
			else if(current.coefficient==0){
			}
		}
	}
}

