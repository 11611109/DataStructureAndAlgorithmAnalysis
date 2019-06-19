package lab9_3;

import java.util.LinkedList;
import java.util.Scanner;

public class fight {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int testcases=input.nextInt();
		int stu,rec;
			for(int i=0;i<testcases;i++){
				int start,end;
				stu=input.nextInt();
				rec=input.nextInt();
				Node[] stuAry=new Node[stu+1];
				for(int k=0;k<stu+1;k++){
					stuAry[k]=new Node(k);
					stuAry[k].index=k;
				}//n个学生创建
				
				GraphNode[] lists=new GraphNode[stu+1];
				for(int a=1;a<stu+1;a++){
					lists[a]=new GraphNode();
					lists[a].list.add(stuAry[a]);
				}//list存储edge,初始化添加第N个node
				for(int j=0;j<rec;j++){
					start=input.nextInt();
					end=input.nextInt();
					lists[start].list.add(stuAry[end]);
					lists[end].list.add(stuAry[start]);
				}//edge储存完毕
				
				//进行DFS
				stack myS=new stack(stu);
				
				int crtClr;
				int flag=0,allVisit=0;
				for(int y=1;y<stu+1;y++){
					if(stuAry[y].visit==false&&flag==0){
						myS.push(stuAry[y]);
						stuAry[y].visit=true;
						stuAry[y].color=1;
						
						while(!myS.isEmpty()){
							//System.out.println("error");
							if(flag==0){
								Node e=myS.gettop();
								crtClr=e.color;
								for(int x=1;x<lists[e.index].list.size();x++){
									if(lists[e.index].list.get(x).visit==true){
										if(lists[e.index].list.get(x).color==crtClr){
										flag=1;
										break;
										}else{
										allVisit++;	
										}
									}else if(lists[e.index].list.get(x).visit==false){
										if(lists[e.index].list.get(0).color==1){
											lists[e.index].list.get(x).color=2;
										}else{
											lists[e.index].list.get(x).color=1;
										}//set 颜色
										myS.push(lists[e.index].list.get(x));
										lists[e.index].list.get(x).visit=true;
									}
								}
								if(allVisit==(lists[e.index].list.size()-1)){
									//System.out.println(allVisit);
									myS.pop();
									allVisit=0;
								}
							}else{
								break;
							}
						}
					}else if(flag==1){
						break;
					}
				}
				
				if(flag==0){
					System.out.println("legal");
				}else{
					System.out.println("illegal");
				}
			}
			
	}

}
class GraphNode{//保存edge信息
	LinkedList<Node> list;
	public GraphNode(){
		list=new LinkedList<Node>();
	}
}
class Node{//node对象们
	int index;
	int color;
	boolean visit;//Record the information of visit.
	public Node(int id){
		this.index=id;
		this.color=0;
		this.visit=false;
	}
}
class stack {
	Node [] stack;
	int capacity;
	private int top=-1;
	public stack(int c){
		stack=new Node [c];
		capacity=c;
	}
	public boolean isEmpty(){
		return top==-1;
	}
	public boolean isFull(){
		return top+1==capacity;
	}
	public void push(Node e){
		stack[++top]=e;
	}
	public Node pop(){//出栈返回参数	
		Node e=stack[top];
	    top--;
		return e;
	}
	public Node gettop(){
		Node n=stack[top];
		return n;
	}
}
