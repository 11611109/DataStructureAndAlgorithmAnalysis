package lab9_2;

import java.util.Scanner;

public class ConnectedRegions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int testcases = input.nextInt();
		int n, m, C = 0;
		for (int i = 0; i < testcases; i++) {
			n = input.nextInt();
			m = input.nextInt();
			C = input.nextInt();
			;
			node[][] graph = new node[n][m];

			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					graph[j][k] = new node();
					graph[j][k].value = input.nextInt();
					graph[j][k].row = j;
					graph[j][k].column = k;
				}
			} // Read finished.
			int count = 0;
			for (int x = 0; x < n; x++) {
				for (int y = 0; y < m; y++) {
					if (graph[x][y].visit == false) {
						find(x, y, graph, n, m);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}

	public static void find(int i, int j, node[][] a, int allrow, int allcol) {
		queue myqueue = new queue(allrow * allcol);
		node tmp;
		myqueue.push(a[i][j]);
		while (!myqueue.isEmpty()) {
			tmp = myqueue.pop();
			i = tmp.row;
			j = tmp.column;
			if ((i + 1) < allrow && a[i + 1][j].value == tmp.value && a[i + 1][j].visit == false) {
				myqueue.push(a[i + 1][j]);
				a[i + 1][j].visit = true;
			}
			if ((i - 1) >= 0 && a[i - 1][j].value == tmp.value && a[i - 1][j].visit == false) {
				myqueue.push(a[i - 1][j]);
				a[i - 1][j].visit = true;
			}
			if ((j + 1) < allcol && a[i][j + 1].value == tmp.value && a[i][j + 1].visit == false) {
				myqueue.push(a[i][j + 1]);
				a[i][j + 1].visit = true;
			}
			if ((j - 1) >= 0 && a[i][j - 1].value == tmp.value && a[i][j - 1].visit == false) {
				myqueue.push(a[i][j - 1]);
				a[i][j - 1].visit = true;
			}
		}

	}

}

class node {
	boolean visit;
	int value;
	int row;
	int column;

	public node() {
		this.value = 0;
		this.visit = false;
		this.row = 0;
		this.column = 0;
	}
}

class queue {

	int size;
	int front;
	int rear;
	node[] queue;

	public queue(int c) {
		front = 0;
		rear = 0;
		size = c + 1;
		queue = new node[c + 1];
	}

	public boolean isEmpty() {
		return front == rear;
	}

	public boolean isFull() {
		return (rear + 1) % size == front;
	}

	public boolean push(node e) {
		if (!isFull()) {
			queue[rear] = e;
			rear = (rear + 1) % size;
			return true;
		} else
			return false;
	}

	public node pop() {
		node e = queue[front];
		front = (front + 1) % size;
		return e;
	}
}