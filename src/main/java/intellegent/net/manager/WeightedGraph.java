package intellegent.net.manager;

public class WeightedGraph {

   private int [][]  edges;  // adjacency matrix
   private Object [] labels;
   private int [] weight; // add

   public WeightedGraph (int n) {
      edges  = new int [n][n];
      labels = new Object[n];
      weight = new int [n]; // add
   }


   public int size() { return labels.length; }

   public void   setLabel (int vertex, Object label) { labels[vertex]=label; }
   public Object getLabel (int vertex)               { return labels[vertex]; }
   public void	 setVertexWeight (int vertex, int x) { weight[vertex] = x; } //add
   public int	 getVertexWeight (int vertex) { return weight[vertex]; }

   public void    addEdge    (int source, int target, int w)  { edges[source][target] = w; }
   public boolean isEdge     (int source, int target)  { return edges[source][target]>0; }
   public void    removeEdge (int source, int target)  { edges[source][target] = 0; }
   public int     getWeight  (int source, int target)  { return edges[source][target]; }

   public int [] neighbors (int vertex) {
      int count = 0;
      for (int i=0; i<edges[vertex].length; i++) {
	 if (edges[vertex][i]>0) count++;
      }
      final int[]answer= new int[count];
      count = 0;
      for (int i=0; i<edges[vertex].length; i++) {
	 if (edges[vertex][i]>0) answer[count++]=i;
      }
      return answer;
   }

   public void print () {
      for (int j=0; j<edges.length; j++) {
	 System.out.print (labels[j]+": ");
	 for (int i=0; i<edges[j].length; i++) {
	    if (edges[j][i]>0) System.out.print (labels[i]+":"+edges[j][i]+" ");
	 }
	 System.out.println ();
      }
   }

  public static void main (Integer[] NumberEvent) {
      Integer NumberNodes = 5;
	  final WeightedGraph t = new WeightedGraph (NumberNodes);
	  for ( int Vertex = 0; Vertex < NumberNodes; Vertex++) {
		  //int VertexWeight = NumberEvent[Vertex];
		  t.setLabel (Vertex, "v" + Vertex); t.setVertexWeight(Vertex, NumberEvent[Vertex]+1);
		  //t.print(); //add
	  }
	  //t.setLabel (0, "v0"); t.setVertexWeight(0, 1); //add
      //t.setLabel (1, "v1"); t.setVertexWeight(1, 1); //add
      //t.setLabel (2, "v2"); t.setVertexWeight(2, 1); //add
      //t.setLabel (3, "v3"); t.setVertexWeight(3, 1); //add
      //t.setLabel (4, "v4"); t.setVertexWeight(4, 1); //add
      //t.setLabel (5, "v5"); t.setVertexWeight(5, 10); //add
      t.addEdge (0,1,1);
      t.addEdge (0,2,1);
      t.addEdge (1,4,1);
      t.addEdge (2,3,1);
      t.addEdge (3,4,1);
      //t.print();

      final int [] pred = Dijkstra.dijkstra (t, 0);
      for (int n=0; n<NumberNodes; n++) {
    	  Dijkstra.printPath (t, pred, 0, n);
      }
   }
   
   
 /*  public static WeightedGraph WeightInit () {
	      Integer NumberNodes = 5;
		  final WeightedGraph t = new WeightedGraph (NumberNodes);
		  t.setLabel (0, "v0"); t.setVertexWeight(0, 0); //add
	      t.setLabel (1, "v1"); t.setVertexWeight(1, 0); //add
	      t.setLabel (2, "v2"); t.setVertexWeight(2, 0); //add
	      t.setLabel (3, "v3"); t.setVertexWeight(3, 0); //add
	      t.setLabel (4, "v4"); t.setVertexWeight(4, 0); //add

	      //t.addEdge (0,1,1);
	      //t.addEdge (0,2,1);
	      //t.addEdge (1,4,1);
	      //t.addEdge (2,3,1);
	      //t.addEdge (3,4,1);
	      //t.addEdge (2,3,1);
	      //t.addEdge (4,3,1);
	      //t.addEdge (4,2,1);
	      //t.addEdge (5,4,1);
	      t.print();
	      return t;
	   }

   public static void PathCalculation (WeightedGraph Graph){
	      final int [] pred = Dijkstra.dijkstra (Graph, 0);
	      int NumberNodes = 5;
	      for (int n=0; n<NumberNodes; n++) {
	    	  Dijkstra.printPath (Graph, pred, 0, n);
	      }
   }*/

}