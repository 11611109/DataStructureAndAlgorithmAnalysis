package lab9_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Convenience {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testcases=input.nextInt();
		for (int t=0;t<testcases;t++) {
			int node = input.nextInt();
			GraphNode[] graph=new GraphNode[node+1];
			int cycle=0;
			int max=1;
			int mmax = 1;
			ArrayList<Integer> ai = new ArrayList<>();
			
			for(int i=1; i<node+1; ++i){
				int des = input.nextInt();
				graph[i]=new GraphNode();
				graph[i].index = i;
				graph[i].destination = des;
			}
			
			for(int i=1; i<node+1; ++i){
				if(graph[i].visit==0){
					int start = graph[i].index;
					int des = graph[i].destination;
					int cOfNode = 1;
					while(des!=start){
						cOfNode++;
						graph[start].visit=1;
						graph[des].visit=1;
						//start = des;
						des = graph[des].destination;
					}
					ai.add(cOfNode);
					if(start == des){
						graph[start].visit=1;
						graph[des].visit=1;
						cycle++;
					}
					
					if(cOfNode>=max){
						mmax = max;
						max = cOfNode;
					}
					else if(cOfNode>=mmax){
						mmax = cOfNode;
					}
				}
			}

			int cov = 0;
			for(int k : ai){    
				cov+=k*k;
			}
			if(cycle>1)
				System.out.println(cov+max*mmax*2);
			else
				System.out.println(cov);
		}
	}
}
class GraphNode {
	int visit;
	int index;
	int destination;
}
