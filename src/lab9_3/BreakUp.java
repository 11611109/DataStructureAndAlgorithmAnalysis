package lab9_3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BreakUp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int testcases=input.nextInt();
		int node,roads;
			for(int i=0;i<testcases;i++){
				node=input.nextInt();
				roads=input.nextInt();
				
				nnode[] city=new nnode[node+1];
				for(int k=0;k<node+1;k++){
					city[k]=new nnode(k);
				}//city的创建
				
				int row,column;
				int [][] AM=new int [node+1][node+1];
				if(roads!=0){
					for(int j=0;j<roads;j++){
						row=input.nextInt();
						column=input.nextInt();
						AM[row][column]=1;
						AM[column][row]=1;
					}
				}//adjacency matrix
				/*System.out.println("pre");
				
				for(int a=1;a<node+1;a++){
					for(int b=1;b<node+1;b++){
						System.out.print(AM[a][b]);
					}
					System.out.println( );
				}*/
				if(AM[1][node]!=0){//1和n之间有road，去寻找railway怎么到n
					for(int x=1;x<node+1;x++){
						for(int y=1;y<node+1;y++){
							if(AM[x][y]==1){
								AM[x][y]=0;
							}else if(AM[x][y]!=1&&x!=y){
								AM[x][y]=1;
							}
						}
					}
				}//if there is no road between 1-n,means there is a railway
				/*System.out.println("after");
				for(int a=1;a<node+1;a++){
					for(int b=1;b<node+1;b++){
						System.out.print(AM[a][b]);
					}
					System.out.println( );
				}*/
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
				city[1].dis=0;
				city[1].visit=true;
				heap.add(city[1]);
				for(int x=1;x<node+1;x++){
					if(x!=1){
						city[x].dis=800000;
						city[x].visit=false;
						//heap.add(city[x]);
					}
				}
				//System.out.println(city[2].dis);
				int [] from1=caculate(AM,city,heap,node);
				
				if(from1[node]>=800000){
					System.out.println(-1);
				}else{
					System.out.println(from1[node]);
				}	
			}
	}
	public static int[] caculate(int [][] a,nnode[] b,PriorityQueue<nnode> c,int node){
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
		int [] distances=new int [node+1];
		for(int p=1;p<node+1;p++){
			distances[p]=b[p].dis;
			//System.out.println("distances:"+distances[p]);
		}
		return distances;
	}
}
class nnode{//node对象们
	int index;
	int dis;
	boolean visit;//Record the information of visit.
	public nnode(int id){
		this.index=id;
		this.dis=0;
		this.visit=false;
	}
}
