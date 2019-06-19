package lab3;

import java.util.Arrays;
import java.util.Scanner;

public class lab3_3 {
	public static int total;
	public static Node head;
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int testcases=input.nextInt();
	
		Node current=null;
		
		if(0<=testcases&&testcases<=50){
			for(int i=0;i<testcases;i++){
				total=input.nextInt();
				head.value=input.nextInt();
				Node temp=head;
				for(int k=0;k<(total-1);k++){						
					temp.next=new Node(input.nextInt());
					temp=temp.next;
				}
				Node test=head;
				while(test!=null){
					System.out.print(test.value+" ");
					test=test.next;
				}
				
				int instructions=input.nextInt();
				System.out.println(instructions);
				System.out.println(total);
				System.out.println(head.value);
				
				String s=null;
				s=input.nextLine();
				for(int n=0;n<instructions;n++){
					
					s=input.nextLine();
					System.out.print(s);
					
					current=make(s);
					
	
					System.out.print(current.value);
					while(current!=null){
						System.out.print(current.value+" ");
						current=current.next;
					}
					head=current;
					System.out.println( );
				}
			}
			}
		else System.out.print("Test cases should be in 0-50");
		}
	public static class Node{
		int value;
		Node next;
		public Node(int value){
			this.value=value;
			this.next=null;
		}
	}
	public static Node make(String s){
		int a=0;
		Node p=head;		
		String [] oneIns=s.split(" ");
		int [] ins=new int [oneIns.length];
		
		for(int x=0;x<oneIns.length;x++){
			try{ins[x]=Integer.parseInt(oneIns[x]);}
			catch (NumberFormatException e){
				System.out.println("Please input the right number");
			}
		}
		System.out.println(Arrays.toString(ins));
		int order=ins[0];
		if(order==1){
			total++;
			System.out.println(total);
			int position1=ins[1];
			int insert=ins[2];
			System.out.println(position1);
			System.out.println(insert);
			Node q=new Node(insert);

		    if(position1!=0){
			while(a<position1-1){
				p=p.next;
				a++;
			}
			Node tmp=p.next;
			p.next=q;
			q.next=tmp;
			return head;
		    }
		    else if(position1==0){
		    	q.next=head;
		    	return  q;
		    }
		    else if(position1==total){
		    	while(p!=null){
					p=p.next;
				}
		    	p.next=q;
		    	return head;
		    }
		    else{
		    	System.out.print("Please input the right position where you want to insert a node at.");
		    	Node error=null;
		    	return error;
		    }	
		}
		else if(order==2){
			int position2=ins[1];
	        System.out.println(total);
			System.out.println(total);
			if(position2==0){
				head=head.next;
			}
			else if(position2>0&&position2<total-1){
				while(a<position2-1){
					p=p.next;
					a++;
				}
				p.next=p.next.next;
			}
			else if(position2==total-1){
				while(a<position2-1){
					p=p.next;
					a++;
				}
				p.next=null;
			}
			else{
				System.out.println("Wrong input of the index of the element to be removed.");
			}
			total--;
			return head;
		}
		else if (order==3){
			int before=ins[1];
			int after=ins[2];
			while(p!=null){
				if(before==p.value)
					p.value=after;
				p=p.next;
			}
			return head;
		}
		else if (order==4){
			if(head==null||head.next==null)
				return head;
			Node pre=head;
			Node cur=head.next;
			Node tmp;
			while(cur!=null){
				tmp=cur.next;
				cur.next=pre;
				
				pre=cur;
				cur=tmp;
			}
			head.next=null;
			return pre;
		}

		else{
			System.out.print("Wrong instruction!It should be a integer between 1 and 4.");
			Node y=null;
			return y;
		}
		}
	}
	/*public static Node reverse(Node head){
		if(head==null||head.next==null)
			return head;
		Node rev=reverse(head.next);
		head.next.next=head;
		head.next=null;
		return rev;
	}*/

