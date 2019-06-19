import java.util.LinkedList;
import java.util.Scanner;

public class Test_ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int testcases=input.nextInt();
		int node,edge;
		int head,list,query=0;
			for(int m=0;m<testcases;m++){
				node=input.nextInt();
				edge=input.nextInt();
				GraphNode [] graph=new GraphNode [node+1];
				Node [] nodes=new Node[node+1];
				for(int p=0;p<node+1;p++){
					nodes[p]=new Node(p);
				}
				for(int j=0;j<node+1;j++){
					graph[j]=new GraphNode(j);
				}
				for(int i=0;i<edge;i++){
					head=input.nextInt();
					list=input.nextInt();
					Node a=new Node(list);
					graph[head].list.getLast().next=a;
					graph[head].list.add(a);
				}
				//Search
				Queue myqueue=new Queue(node);
				int flag=0;
				int start=0,end=0;
				query=input.nextInt();
				for(int k=0;k<query;k++){
					start=input.nextInt();
					end=input.nextInt();
					
					for(int x=0;x<graph[start].list.size();x++){
						if(graph[start].list.get(x).index==end){
							flag=1;
							System.out.println("YES");
							break;
						}else{
							myqueue.push(graph[start].list.get(x));
							graph[graph[start].list.get(x).index].visit=true;
						}
					}//push in the first list
					int count=0;
					if(flag==0){
						while(!myqueue.isEmpty()){
							//System.out.println("first loop");
							Node tmp=myqueue.pop();
							Node first=graph[tmp.index].list.getFirst();
							while(first!=null){
								//System.out.println("second loop");
								if(count==node){
									break;
								}else if(graph[first.index].visit==true){
									first=first.next;
									count++;
								}else if(graph[first.index].visit==false){
									if(first.index==end){
										System.out.println("YES");
										flag=1;
										break;
									}else{
										myqueue.push(first);
										first=first.next;
									}
								}
							}
							if(flag==1){
								break;
							}
						}
					}
					if(flag!=1){
						System.out.println("NO");
					}
					//All refresh
					while(!myqueue.isEmpty()){
						myqueue.pop();
					}
					for(int y=0;y<node+1;y++){
						graph[y].visit=false;
					}
					count=0;
					flag=0;
				}
				
			}
	}

}
class GraphNode{
	boolean visit;//Record the information of visit.
	LinkedList<Node> list;
	public GraphNode(int i){
		list=new LinkedList<Node>();
		list.add(new Node(i));
		this.visit=false;
	}
}
class Node{
	int index;
	Node next;
	public Node(int id){
		this.index=id;
		this.next=null;
	}
}
class Queue {

	int size;
	int front;
	int rear;
	Node [] queue;
	
	public Queue(int c){
		front=0;
		rear=0;
		size=c+1;
		queue=new Node[c+1];
	}
	
	public boolean isEmpty(){
		return front==rear;
	}
	
	public boolean isFull(){
		return (rear+1)%size==front;
	}
	
	public boolean push(Node e){
		if(!isFull()){
			queue[rear]=e;
			rear=(rear+1)%size;
			return true;
		}else
			return false;
	}
	public Node pop(){
		Node e=queue[front];
		front=(front+1)%size;
		return e;
	}

}
