package lab9_3;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TopologicalSorting {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int testcases=input.nextInt();
		int node,edge;
			for(int i=0;i<testcases;i++){
				node=input.nextInt();
				edge=input.nextInt();
				
				node [] nodes=new node[node+1];
				graphNode[] lists=new graphNode[node+1];
				for(int k=0;k<node+1;k++){
					nodes[k]=new node(k);
				}
				for(int a=1;a<node+1;a++){
					lists[a]=new graphNode();
					lists[a].list.add(nodes[a]);
				}//list存储edge,初始化添加第N个node
				int start,end;
				for(int j=0;j<edge;j++){
					start=input.nextInt();
					end=input.nextInt();
					nodes[end].indeg++;
					lists[start].list.add(nodes[end]);
				}//edge储存完毕
				
				Comparator<node> cmp=new Comparator<node>(){
					public int compare(node a,node b){
						if(a.index>b.index){
							return 1;
						}else if(a.index==b.index){
							return 0;
						}else{
							return -1;
						}
					}
				};//comparator重载
				LinkedList<Integer> result=new LinkedList<Integer>();
				PriorityQueue<node> heap=new PriorityQueue<node>(node,cmp);
				for(int c=1;c<node+1;c++){
					if(nodes[c].indeg==0){
						heap.add(nodes[c]);
					}
				}//入度为0的结点加入heap
				
				/*for(int f=0;f<heap.size();f++){
					System.out.print(" "+heap.poll().index);
				}*/
				while(!heap.isEmpty()){
					node cur=heap.poll();
					result.add(cur.index);
					//System.out.println("2nd"+lists[1].list.get(2).index);
					while(lists[cur.index].list.size()!=1){
						node x=lists[cur.index].list.get(1);
						lists[cur.index].list.remove(1);
						x.indeg--;
						if(x.indeg==0){
							heap.add(x);
						}
					}//拓扑排序核心
				}
				
				int count=0;
				for(int q=1;q<node+1;q++){
					if(lists[1].list.size()==1){
						count++;
					}
				}

				if(count==node){
					for(int o=0;o<result.size();o++){
						System.out.print(result.get(o)+" ");
					}System.out.println();
				}else{
					System.out.println("impossible");
				}
			}
	}
}
class node{//node对象们
	int index;
	int indeg;
	boolean visit;//Record the information of visit.
	public node(int id){
		this.index=id;
		this.indeg=0;
		this.visit=false;
	}
}
class graphNode{//保存edge信息
	LinkedList<node> list;
	public graphNode(){
		list=new LinkedList<node>();
	}
}
