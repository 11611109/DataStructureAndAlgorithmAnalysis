package lab3;

import java.util.Scanner;

public class lab3_1  {
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner input=new Scanner(System.in);
			int testcases=input.nextInt();
			int branch1;
			int branch2;
			
			if(0<=testcases&&testcases<=10){
				for(int i=0;i<testcases;i++){
					branch1=input.nextInt();
					branch2=input.nextInt();
					if(branch1>=1&&branch1<=100000&&branch2>=1&&branch2<=100000){
						Node head1=new Node(input.nextInt());
						Node temp=head1;
						for(int k=0;k<(branch1-1);k++){						
							temp.next=new Node(input.nextInt());
							temp=temp.next;
						}
						
						Node head2=new Node(input.nextInt());
						Node temp2=head2;
						for(int j=0;j<(branch2-1);j++){
							temp2.next=new Node(input.nextInt());
							temp2=temp2.next;
						}
						
						Node result=mergeSortedList(head1,head2);
						Node current=result;
						if(result==null){
							System.out.print("Error");
						}
						while(current!=null){
							System.out.print(current.value+" ");
							current=current.next;
						}
						
					}
					else System.out.println("Input error!(numbers of sodiers in two branches)");
				}
				
			}
			else System.out.print("Test cases should be in 0-10");

	}
		public static class Node{
			int value;
			Node next;
			public Node(int value){
				this.value=value;
				this.next=null;
			}
		}
		public static Node mergeSortedList(Node head1,Node head2){
			if(head1==null)
				return head2;
			if(head2==null)
				return head1;
			if(head1.value<=head2.value){
			    head1.next=mergeSortedList(head1.next,head2);
			    return head1;
			}
			else{
				head2.next=mergeSortedList(head2.next,head1);
				return head2;
			}
		}
}

			/*if(head1==null)
				return head2;
			if(head2==null)
				return head1;
			Node target=null;
			if(head1.value>head2.value){
				target=head2;
				head2=head2.next;
			}
			else{
				target=head1;
				head1=head1.next;
			}
			target.next=null;
		    Node mergeHead=target;
		    while(head1!=null&&head2!=null){
		    	if(head1.value>head2.value){
		    		target.next=head2;
		    		head2=head2.next;
		    	}
		    	else{
		    		target.next=head1;
					head1=head1.next;
		    	}
		    	target=target.next;
		    	target.next=null;
		    }
		    if(head1==null)
		    	target.next=head2;
		    else target.next=head1;
		    return mergeHead;*/
		
