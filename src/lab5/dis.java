package lab5;
import java.util.Scanner;

public class dis {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner input=new Scanner(System.in);
			int testcases=input.nextInt();
			int node,root=0;
			int largestDis=0;
			if(1<=testcases&&testcases<=50){
				for(int m=0;m<testcases;m++){
					node=input.nextInt();
					//if(node)
					Node [] nodeArray=new Node[node+1];
					int [] dis=new int[node+1];
					for(int j=0;j<node+1;j++){
						nodeArray[j]=new Node();
					}
					for(int i=0;i<node-1;i++){
						int a=input.nextInt();
						int b=input.nextInt();
						if(nodeArray[a].left!=0){
							nodeArray[a].right=b;
						}else{
							nodeArray[a].left=b;
						}
						nodeArray[b].father=a;
					}//Read finished.
					
					myQueue queue=new myQueue(node);
					queue.push(1);//push in a node randomly
					while(!queue.isEmpty()){
						int e=queue.pop();
						if(nodeArray[e].left!=0){
							queue.push(nodeArray[e].left);
						}
						if(nodeArray[e].right!=0){
							queue.push(nodeArray[e].right);
						}
						if(queue.isEmpty()){
							root=e;
						}
					}//find one of the deepest nodes
					
					queue.push(root);
					dis[root]=0;
					nodeArray[root].visit=true;
					int f=0;
					while(!queue.isEmpty()){
						f=queue.pop();
						if(nodeArray[f].father!=0&&nodeArray[nodeArray[f].father].visit==false){
							nodeArray[nodeArray[f].father].visit=true;
							dis[nodeArray[f].father]=dis[f]+1;
							queue.push(nodeArray[f].father);
						}
						if(nodeArray[f].left!=0&&nodeArray[nodeArray[f].left].visit==false){
							nodeArray[nodeArray[f].left].visit=true;
							dis[nodeArray[f].left]=dis[f]+1;
							queue.push(nodeArray[f].left);
						}
						if(nodeArray[f].right!=0&&nodeArray[nodeArray[f].right].visit==false){
							nodeArray[nodeArray[f].right].visit=true;
							dis[nodeArray[f].right]=dis[f]+1;
							queue.push(nodeArray[f].right);
						}
						if(queue.isEmpty()){
							largestDis=dis[f];
						}
					}
					System.out.println(largestDis);
				}
				
			}
		

	}
}
	class Node{
		boolean visit;
		int father;
		int left;
		int right;
		public Node(){
			this.visit=false;
			this.father=0;
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
			size=c+1;
			queue=new int[c+1];
		}
		
		public boolean isEmpty(){
			return front==rear;
		}
		
		public boolean isFull(){
			if((rear+1)%size==front){
				return true;
			}else{
			return false;
			}
		}
		
		public boolean push(int e){
				queue[rear]=e;
				rear=(rear+1)%size;
				return true;
		}
		public int pop(){
				int e=queue[front];
				front=(front+1)%size;
				return e;
		}
	}



