/**
 * <h1>Path Class<\h1>
 * This class creates an object that represents an entry in the priority queue for Dijkstra's algorithm
 */
class Path implements Comparable<Path>
{
    public Vertex     dest;   // w
    public double     cost;   // d(w)
    /**
     * Creates a path with the destination node and cost of the edge.
     * @param d destination vertex
     * @param c cost of edge
     */
    public Path( Vertex d, double c )
    {
        dest = d;
        cost = c;
    }
    /**
     * Compares the cost of this Path object to another Path object received as a paramter
     * @param rhs
     */
    public int compareTo( Path rhs )
    {
        double otherCost = rhs.cost;
        
        return cost < otherCost ? -1 : cost > otherCost ? 1 : 0;
    }
}
