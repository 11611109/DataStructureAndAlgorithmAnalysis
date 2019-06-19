package lab7;

import java.util.Scanner;

public class MostValuablePath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int testcases=input.nextInt();
		int node=0;
		if(1<=testcases&&testcases<=10){
			for(int m=0;m<testcases;m++){
				int rootKey=0;
				node=input.nextInt();
				//Array built.
				Tree [] tree=new Tree[node+1];
				Node [] nextNode=new Node[node+1];
				for(int s=0;s<node+1;s++){
					tree[s]=new Tree();
					nextNode[s]=new Node();
				}
				for(int k=1;k<node+1;k++){
					tree[k].value=input.nextInt();
				}
				//Read data.
				int x,y=0;
				for(int i=0;i<node-1;i++){
					x=input.nextInt();
					y=input.nextInt();
					tree[y].root=false;
					if(tree[x].firstChild==0){
						tree[x].firstChild=y;
					}else{
						int z=tree[x].firstChild;
						while(nextNode[z].next!=0){
							z=nextNode[z].next;
						}
						nextNode[z].next=y;
					}
				}
				//Search for root
				for(int p=1;p<node+1;p++){
					if(tree[p].root==true)
						rootKey=p;
				}
				Queue queue=new Queue(node);
				queue.push(rootKey);
				tree[rootKey].sum=tree[rootKey].value;
				while(!queue.isEmpty()){
					int e=queue.pop();
					int c=tree[e].firstChild;
					if(c!=0){
						queue.push(c);
						tree[c].sum=tree[e].sum+tree[c].value;
						while(nextNode[c].next!=0){
							queue.push(nextNode[c].next);
							tree[nextNode[c].next].sum=tree[e].sum+tree[nextNode[c].next].value;
							c=nextNode[c].next;
						}
					}
				}
				//Find the most valuable path.
				long maxSum=0;
				for(int q=1;q<node+1;q++){
					if(tree[q].sum>maxSum){
						maxSum=tree[q].sum;
					}
				}
				System.out.println(maxSum);
			}
		}
	}

}
class Tree{
	long sum;
	int firstChild;
	boolean root;
	int value;
	public Tree(){
		this.sum=0;
		this.firstChild=0;
		this.root=true;
		this.value=0;
	}
}
class Node{
	int next;
	public Node(){
		this.next=0;
	}
}
class Queue {

	int size;
	int front;
	int rear;
	int [] queue;
	
	public Queue(int c){
		front=0;
		rear=0;
		size=c+1;
		queue=new int[c+1];
	}
	
	public boolean isEmpty(){
		return front==rear;
	}
	
	public boolean isFull(){
		return (rear+1)%size==front;
	}
	
	public boolean push(int e){
		if(!isFull()){
			queue[rear]=e;
			rear=(rear+1)%size;
			return true;
		}else
			return false;
	}
	public int pop(){
		if(!isEmpty()){
			int e=queue[front];
			front=(front+1)%size;
			return e;
		}else
			return -1;
	}
}