package lab6;

import java.util.Scanner;

public class LevelTranversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int testcases=input.nextInt();
		int node,root=0;
		if(1<=testcases&&testcases<=50){
			for(int m=0;m<testcases;m++){
				node=input.nextInt();
				Node [] nodeArray=new Node[node+1];
				for(int j=0;j<node+1;j++){
					nodeArray[j]=new Node();
				}
				//root=input.nextInt();
				
				//nodeArray[root].root=true;
				//nodeArray[root].left=input.nextInt();
				for(int i=0;i<node-1;i++){
					int a=input.nextInt();
					int b=input.nextInt();
					if(nodeArray[a].left!=0){
						nodeArray[a].right=b;
					}else{
						nodeArray[a].left=b;
					}
					nodeArray[b].root=false;
				}//Read finished.
				
				myQueue queue=new myQueue(node);
				for(int k=1;k<node+1;k++){
					if(nodeArray[k].root!=false){
						root=k;
					}
				}
				queue.push(root);
				while(!queue.isEmpty()){
					int e=queue.pop();
					System.out.print(e);
					if(nodeArray[e].left!=0){
						queue.push(nodeArray[e].left);
					}
					if(nodeArray[e].right!=0){
						queue.push(nodeArray[e].right);
					}
					if(!queue.isEmpty()){
						System.out.print(" ");
					}
				}System.out.println( );
			}
		}
	}

}
class Node{
	boolean root;
	int left;
	int right;
	public Node(){
		this.root=true;
		this.left=0;
		this.right=0;
	}
}
class myQueue {

	int size;
	int front;
	int rear;
	int [] queue;
	
	public myQueue(int c){
		front=0;
		rear=0;
		size=c;
		queue=new int[c+1];
	}
	
	public boolean isEmpty(){
		return front==rear;
	}
	
	public boolean isFull(){
		if(rear==size){
			return rear%size==front;
		}else{
		return rear+1==front;
		}
	}
	
	public boolean push(int e){
			queue[rear]=e;
			rear=(rear+1)%(size+1);
			return true;
	}
	public int pop(){
			int e=queue[front];
			front=(front+1)%(size+1);
			return e;
	}
}
