package lab9;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Arrays;

public class BobAndAlice {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int testcases=input.nextInt();
		int node,edge;
			for(int i=0;i<testcases;i++){
				node=input.nextInt();
				edge=input.nextInt();
				nnode[] city=new nnode[node+1];
				for(int k=0;k<node+1;k++){
					city[k]=new nnode(k);
				}//city的创建
				
				int row,column,weight;
				int [][] AM=new int [node+1][node+1];
				
				if(edge!=0){
					for(int j=0;j<edge;j++){
						row=input.nextInt();
						column=input.nextInt();
						weight=input.nextInt();
						if(AM[row][column]==0||AM[row][column]>weight){
						AM[row][column]=weight;
						AM[column][row]=weight;
						}
					}
				}//adjacency matrix
				int loc1=input.nextInt();
				int loc2=input.nextInt();
				
				Comparator<nnode> cmp=new Comparator<nnode>(){
					public int compare(nnode a,nnode b){
						if(a.dis>b.dis){
							return 1;
						}else if(a.dis==b.dis){
							return 0;
						}else{
							return -1;
						}
					}
				};//comparator重载
				
				PriorityQueue<nnode> heap=new PriorityQueue<nnode>(node,cmp);
				//计算从城市1开始各点距离
				city[loc1].dis=0;
				city[loc1].visit=true;
				heap.add(city[loc1]);
				for(int x=1;x<node+1;x++){
					if(x!=loc1){
						city[x].dis=10000000001L;
						//heap.add(city[x]);
					}
				}
				long [] from1=caculate(AM,city,heap,node);
				PriorityQueue<nnode> heap2=new PriorityQueue<nnode>(node,cmp);
				//计算从城市n开始各点最短距离
				city[loc2].dis=0;
				city[loc2].visit=true;
				heap2.add(city[loc2]);
				for(int y=1;y<node+1;y++){
					if(y!=loc2){
						city[y].dis=10000000001L;
					    city[y].visit=false;
					//heap2.add(city[y]);
					}
				}
				long [] from2=caculate(AM,city,heap2,node);
				//compare
				long [] max=new long[node];
				for(int q=0;q<node;q++){
					if(from1[q+1]>from2[q+1]){
						max[q]=from1[q+1];
					}else{
						max[q]=from2[q+1];
					}
				}
				Arrays.sort(max);
				System.out.println(max[0]);
			}
	}

	public static long[] caculate(int [][] a,nnode[] b,PriorityQueue<nnode> c,int node){
		while(!c.isEmpty()){
			nnode cur=c.poll();

			for(int z=1;z<node+1;z++){
				if(a[cur.index][z]!=0){
					if(b[z].visit==false){
						b[z].dis=cur.dis+a[cur.index][z];
						b[z].visit=true;

						c.add(b[z]);
		
					}else{
						if(b[z].dis>cur.dis+a[cur.index][z]){
							b[z].dis=cur.dis+a[cur.index][z];
							c.remove(b[z]);
							c.add(b[z]);
						}
					}
				}
				
			}
		}
		long [] distances=new long [node+1];
		for(int p=1;p<node+1;p++){
			distances[p]=b[p].dis;
			//System.out.println("distances:"+distances[p]);
		}
		return distances;
	}
}
class nnode{//node对象们
	int index;
	long dis;
	boolean visit;//Record the information of visit.
	public nnode(int id){
		this.index=id;
		this.dis=0;
		this.visit=false;
	}
}
