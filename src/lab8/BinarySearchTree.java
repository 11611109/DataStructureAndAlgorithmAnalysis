package lab8;

import java.util.Scanner;

public class BinarySearchTree {
    static int cmp,nodes;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int testcases=input.nextInt();
		
		if(1<=testcases&&testcases<=100){
			for(int m=0;m<testcases;m++){
				cmp=input.nextInt();
				nodes=input.nextInt();
				
				//READ THE STANDARD TREE
				Node [] std=new Node[nodes+1];
				Node [] judged=new Node[nodes+1];
				for(int i=0;i<nodes+1;i++){
					std[i]=new Node();
					judged[i]=new Node();
				}
				for(int j=1;j<(nodes+1);j++){
					std[j].value=input.nextInt();
				}
				Node [] stdTree=createBST(std);
				
				for(int n=0;n<cmp;n++){
					for(int x=1;x<(nodes+1);x++){
						judged[x].value=input.nextInt();
						judged[x].leftIndex=0;
						judged[x].rightIndex=0;
					}
					Node [] judgedTree=createBST(judged);
					
					preOrderStack(stdTree[1],judgedTree[1],stdTree,judgedTree);
				}
				
			}
		}
	}
	public static Node [] createBST(Node [] a){
		for(int k=2;k<a.length;k++){
			int root=1;
			int flag=0;
			while(flag!=1){
				if(a[k].value>a[root].value){
					if(a[root].rightIndex==0){
						a[root].rightIndex=k;
						flag=1;
					}else{
						root=a[root].rightIndex;
					}
				}else if(a[k].value<a[root].value){
					if(a[root].leftIndex==0){
						a[root].leftIndex=k;
						flag=1;
					}else{
						root=a[root].leftIndex;
					}
				}
			}
		}
		return a;
	}

	static int count=0;
	public static void preOrderStack(Node rt1,Node rt2,Node []array1,Node []array2){
		if(rt1==null||rt2==null)return;
		Stack s1=new Stack(nodes);
		Stack s2=new Stack(nodes);
		while((rt1.value!=0&&rt2.value!=0)||(!s1.isEmpty()&&!s2.isEmpty())){
			while(rt1.value!=0&&rt2.value!=0){
				s1.push(rt1);
				s2.push(rt2);
				if(rt1.value==rt2.value){
					count++;
				}
				rt1=array1[rt1.leftIndex];
				rt2=array2[rt2.leftIndex];
			}
			rt1=s1.pop();
			rt2=s2.pop();
			rt1=array1[rt1.rightIndex];
			rt2=array2[rt2.rightIndex];
		}
		if(count==array1.length-1){
			System.out.println("YES");
			count=0;
		}else{
			System.out.println("NO");
			count=0;
		}
	}
}
class Stack {
		Node [] stack;
		int capacity;
		private int top=-1;
		public Stack(int c){
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
}
class Node{
	int value;
	int leftIndex;
	int rightIndex;
	public Node(){
		value=0;
		leftIndex=0;
		rightIndex=0;
	}
}