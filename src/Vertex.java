/**
 * <h1>Vertex Class<\h1>
 * This class creates an object that represents a vertex in the graph
 */

import java.util.List;
import java.util.LinkedList;

class Vertex
{
    public String     name;   // Vertex name
    public List<Edge> adj;    // Adjacent vertices
    public double     dist;   // Cost
    public Vertex     prev;   // Previous vertex on shortest path
    public int        scratch;// Extra variable used in algorithm

    /**
     * Creates a vertex with a name, creates a linked list to store the adjacent vertices and calls reset()
     * @param nm name
     */
    public Vertex( String nm )
      { name = nm; adj = new LinkedList<Edge>( ); reset( ); }

    /**
     * Sets the distances to all other vertices to infinity and sets the previous vertex to null
     */
    public void reset( )
    //  { dist = Graph.INFINITY; prev = null; pos = null; scratch = 0; }    
    { dist = Graph.INFINITY; prev = null; scratch = 0; }
   
}
