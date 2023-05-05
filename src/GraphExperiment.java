import java.util.*;

public class GraphExperiment {
    private static final int cost = 10;

    public static void main(String[] args) {
        int[] V = {10, 20, 30, 40, 50};
        int[] E = {20, 35, 50, 65, 80, 95};
        Random random = new Random();

        //Graph graph = new Graph();

        

        for (int v : V){ // for different numbers of vertices
            List<String> nodes = new ArrayList<>(); // creates list to store nodes in correct format
            for (int i=1; i<(v+1); i++) {
                String node = String.format("Node%03d", i);
                nodes.add(node);
            }
            Collections.shuffle(nodes); // shuffles the order of the nodes
            for (int e: E){  // for different numbers of edges
                HashMap<String,Integer> graph = new HashMap<String, Integer> (); // creates a hashmap to store the edges of the graph
                String filename = "dataset." + Integer.toString(v) + "." + Integer.toString(e);
                for (int j=0; j<(e+1); j++){ 
                    String source = nodes.get(random.nextInt(e));
                    String dest = nodes.get(random.nextInt(e));
                    String vertices = source + " " + dest;
                    int weight = random.nextInt(cost);
                    if (source!=dest) {
                        graph.putIfAbsent(vertices, weight);
                    }
                }    
            }
        }    
        
    }
    private boolean edgeExists(String source, String dest, List<String> edges) {
        for (String edge : edges) {
            String[] parts = edge.split("\\s+");
            if (source.equals(parts[0]) && dest.equals(parts[1])) {
                return true;
            }
            if (source.equals(parts[1]) && dest.equals(parts[0])) {
                return true;
            }
        }
        return false;
    }
}
