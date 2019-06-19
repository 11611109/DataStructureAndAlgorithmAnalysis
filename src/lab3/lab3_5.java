package lab3;

import java.util.LinkedList;
import java.util.Scanner;


public class lab3_5 {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int testcases=input.nextInt();
		int branch1=0;
		int branch2=0;
		
		
		if(0<=testcases&&testcases<=10){
			for(int i=0;i<testcases;i++){
				branch1=input.nextInt();
				
				if(branch1>=0&&branch1<=100){
					
					Node head1=new Node(input.nextInt(),input.nextInt());
					Node temp=head1;
					for(int k=0;k<(branch1-1);k++){						
						temp.next=new Node(input.nextInt(),input.nextInt());
						temp=temp.next;
					}
					
					branch2=input.nextInt();
				
					if(branch2>=0&&branch2<=100){
						Node head2=new Node(input.nextInt(),input.nextInt());
						Node temp2=head2;
						for(int j=0;j<(branch2-1);j++){
							temp2.next=new Node(input.nextInt(),input.nextInt());
							temp2=temp2.next;
						}
					
						Node Head=mutiplyPoly(head1,head2);
				
						LinkedList result=simplify(Head);
						printHead((Node)result.get(0));
						for(int l=1;l<result.size();l++){
							printPoly((Node)result.get(l));
						}
						System.out.println( );
			        }
			}
		    else System.out.print("Test cases should be in 0-10");
		    }
        }
	}
	public static class Node{
		int coefficient;
		int exponent;
		Node next;
		public Node(int value1,int value2){
			this.coefficient=value1;
			this.exponent=value2;
		}
		public Node( ){
		}
		public void setCoefficient(int a){
			coefficient=a;
		}
	}
	public static Node mutiplyPoly(Node head1,Node head2){
		Node head=new Node(0,0);//为什么不加node()的初始化方法就不行,只能shiNull?
		Node p=head;
		for(Node m=head1;m!=null;m=m.next){
			for(Node n=head2;n!=null;n=n.next){
				p.coefficient=m.coefficient*n.coefficient;
				p.exponent=m.exponent+n.exponent;
				
				p.next=new Node();
				p=p.next;
			}
		}
		
		return head;
	}
	public static LinkedList simplify(Node head){
		LinkedList<Node> myList=new LinkedList<Node>();
		Node p=new Node(head.coefficient,head.exponent);
		Node q=head;
		int count=0;
		myList.add(p);
		if(head.next!=null){
			while(q.next!=null){
				q=q.next;
				while(q.exponent>p.exponent){
					count++;
					if(p.next==null){
						break;}
					p=p.next;}
				myList.add(count, q);
				p=myList.get(0);}
			Node pointer;
			Node next;
			for(int n=0;n<myList.size()-1;n++){
				pointer=myList.get(n);
				next=myList.get(n+1);
				if(pointer.exponent==next.exponent){
					pointer.setCoefficient(pointer.coefficient+next.coefficient);
					myList.set(n,pointer);
					myList.remove(n+1);}}
			return myList;
		}
		else return myList;
	}
	public static Node add(Node first,Node second,Node third){
		
			first.next=second;
		    second.next=third;//特殊情况
			
		return first;
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
