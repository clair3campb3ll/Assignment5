/**
 * <h1>GraphExperiment</h1>
 * The GraphExperiment class is used to create and load graphs into text files, and then use Dijkstra's shortest paths 
 * algorithm to find the shortest path from a specified starting node to all other nodes in the graph. 
 * 
 * The program generates graphs with varying numbers of vertices and edges, and stores them in text files with the 
 * format "dataset.V.E" where V is the number of vertices and E is the number of edges. 
 * 
 * The graph data is stored in a HashMap where the keys are a combination of two nodes (source and destination) 
 * and the value is the weight of the edge connecting the two nodes.
 * 
 * @author Claire Campbell
 */
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class GraphExperiment {
    /**
     * 
     */
    private static final int cost = 10;

    public static void main(String[] args) {
        int[] V = {10, 20, 30, 40, 50};
        int[] E = {20, 35, 50, 65, 80};
        Random random = new Random();

        for (int v : V){ // for different numbers of vertices
            List<String> nodes = new ArrayList<>(); // creates list to store nodes in correct format
            for (int i=1; i<(v+1); i++) { // for creating all the nodes
                String node = String.format("Node%03d", i);
                nodes.add(node);
            }
            Collections.shuffle(nodes); // shuffles the order of the nodes
            for (int e: E){  // for different numbers of edges
                HashMap<String,Integer> graph = new HashMap<String, Integer> (); // creates a hashmap to store the edges of the graph
                
                for (int j=0; j<(e); j++){ 
                    String source = nodes.get(random.nextInt(v));
                    String dest = nodes.get(random.nextInt(v));
                    String vertices = source + " " + dest;
                    int weight = random.nextInt(cost);
                    if (source!=dest && !graph.containsKey(vertices)){
                        graph.put(vertices, weight); // adds the edge to the HashMap
                    } // end if statement to check that source!=dest
                    else { // if source = dest
                        do {
                            source = nodes.get(random.nextInt(v));
                            dest = nodes.get(random.nextInt(v));
                            vertices = source + " " + dest;
                            weight = random.nextInt(cost);   
                        } while (source==dest || graph.containsKey(vertices)); // loops until the criteria is met for an edge
                        graph.put(vertices, weight); // adds the edge to the HashMap
                    }
                } 
                // Load the graph (stored in the Hashmap) into a textfile in the same format as Graph1.txt:
                String filename = "dataset." + Integer.toString(v) + "." + Integer.toString(e);
                try {
                FileWriter writer = new FileWriter(filename);  
                for (Map.Entry<String, Integer> entry : graph.entrySet()){
                    String line = entry.getKey() + " " + entry.getValue()+"\n"; // read each line of HashMap into a textfile
                    writer.write(line);
                }
                writer.close();
                } catch (IOException error) {
                    error.printStackTrace();
                }
            } // end loop for varied edges
        } // end loop for varied vertices 
        
        Graph g = new Graph();
        for (int v:V){
            for (int e:E){
                try {
                    FileReader reader = new FileReader("dataset."+v+"."+e);  
                    Scanner graphFile = new Scanner(reader); 

                    // Read the edges and insert
                    String line;
                    while( graphFile.hasNextLine( ) )
                    {
                        // Loads the dataset into a textfile
                        line = graphFile.nextLine( );
                        StringTokenizer st = new StringTokenizer( line );

                        try {
                            if( st.countTokens( ) != 3 )
                            {
                                System.err.println( "Skipping ill-formatted line " + line );
                                continue;
                            }
                            String source  = st.nextToken( );
                            String dest    = st.nextToken( );
                            int    cost    = Integer.parseInt( st.nextToken( ) );
                            g.addEdge( source, dest, cost ); // adds edge to graph
                        }
                        catch( NumberFormatException error )
                        { System.err.println( "Skipping ill-formatted line " + line ); }
                    }
                    graphFile.close();
                } catch (IOException error) {
                    System.err.println(error);
                }
                System.out.println("\nGraph with "+ Integer.toString(v)+" vertices and "+ Integer.toString(e)+ " edges");
                g.dijkstra("Node001"); // performing Dijkstra's shortest paths algorithm to all nodes from Node001
                
            } // for varied edges
        } // for varied vertices

    } // end main class

} // end GraphExperiment class
