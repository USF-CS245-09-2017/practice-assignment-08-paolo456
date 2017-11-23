import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;


public class GraphAdjMatrix implements Graph {
	int[][] edges;
	//constructor
	public GraphAdjMatrix(int vertices){
		
		edges = new int[vertices][vertices];
		
	}
	//method to add edge
	public void addEdge(int v1, int v2) {
		edges[v1][v2] = 1;
		edges[v2][v1] = 1;
	}
	//tss method 
	public void tss(int i, boolean[] b, Stack<Integer> s){
		b[i] = true;
		Integer p;
		
		Iterator<Integer> it = getNeighbors(i).iterator();
		
		while(it.hasNext()){
			p = it.next();
			
			if(!b[p]){
				tss(p, b, s);
			}
		}
		
		s.push(new Integer(i));
 	}
	//topological sort method
	public void topologicalSort() {
		Stack<Integer> stack = new Stack<Integer>();
		
		boolean visited[] = new boolean[edges.length];
		
		for(int i = 0; i < edges.length; i++){
			visited[i] = false;
		}
		for(int i = 0; i < edges.length; i++){
			if(visited[i] == false)
				tss(i, visited, stack);
		}
		while(stack.empty() == false)
			System.out.println(stack.pop() + " ");

	}
	//gets all neighbors of v and returns it as a linkedlist
	LinkedList<Integer> getNeighbors(int v){
		LinkedList<Integer> ll = new LinkedList<Integer>();
		for(int i = 0; i < edges.length; i++)
			if(edges[v][i] == 1)
				ll.add(new Integer(i));
		return ll;
	}
	
	//function to check for neighbors of vertex
	public int[] neighbors(int vertex) {
		int[] n = new int[outdegree(vertex)];
		int count = 0;
		
		for(int i = 0; i < edges.length; i++){
			if(edges[i][vertex] == 1){
				n[count] = i;
				count++;
			}
		}
		return n;
	}
	//collects number of nodes v1 points to. return int
	public int outdegree(int v1){
		int degree = 0;
		for(int k = 0; k < edges.length; k++){
			if(edges[k][v1] == 1){
				degree++;}
			
		}
		return degree;
	}
	

}
