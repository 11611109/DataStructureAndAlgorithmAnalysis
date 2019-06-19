package lab9;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumBridgeCost {	
	static int island,x,count;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testcases=input.nextInt();
		for (int t=0;t<testcases;t++) {
			int n=input.nextInt();
			island=n;
			int m=input.nextInt();
			int K=input.nextInt();
			if(m+K<n-1){
				System.out.println(-1);
			}else{
				Edge[] edges=new Edge[m+K];
			for (int i=0; i<m+K;i++) {
				Edge edge=new Edge();
				edges[i]=edge;
				int one=input.nextInt();
				int two=input.nextInt();
				int val=input.nextInt();
				edges[i].begin=Math.min(two,one); 
				edges[i].end=Math.max(two,one); 
				edges[i].weight =val;
			}
		
			Arrays.sort(edges);
			kruskal(edges);
			System.out.println(x);
			}
			if(count!=island-1)
				System.out.println(-1);
		}
	}
public static void kruskal(Edge[] edges) {
		int[] parent=new int[island+1];
		
		for (int i=0;i<edges.length;i++) {
			Edge edge = edges[i];
			int rootOfBegin=findParentRoot(edge.begin,parent);
			int rootOfend=findParentRoot(edge.end,parent);
			if (rootOfBegin !=rootOfend) {
				x+=edge.weight;
				count++;
				parent[rootOfBegin]=rootOfend;
			}
		}
	}
	private static int findParentRoot(int target, int[] parent) {
		while (parent[target] > 0) {
			target = parent[target];
		}
		return target;
	}
}
class Graph {
	Edge[] edges;
	int[][] arr;
}

class Edge implements Comparable<Edge> {
	int begin;
	int end;
	int weight;
	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}

}

