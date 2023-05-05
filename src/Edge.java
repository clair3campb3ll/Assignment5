/**
 * <h1>Edge Class<\h1>
 * This class creates an object that represents an edge in the graph.
 */
class Edge
{
    public Vertex     dest;   // Second vertex in Edge
    public double     cost;   // Edge cost
    /**
     * Creates an edge with a destination vertex and a cost of the edge
     * @param d
     * @param c
     */
    public Edge( Vertex d, double c )
    {
        dest = d;
        cost = c;
    }
}
