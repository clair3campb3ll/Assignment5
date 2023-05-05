import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class GraphExperiment {
    private static final int cost = 10;

    public static void main(String[] args) {
        int[] V = {10, 20, 30, 40, 50};
        int[] E = {20, 35, 50, 65, 80, 95};
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
                
                for (int j=0; j<(e+1); j++){ 
                    String source = nodes.get(random.nextInt(v));
                    String dest = nodes.get(random.nextInt(v));
                    String vertices = source + " " + dest;
                    int weight = random.nextInt(cost);
                    if (source!=dest && !graph.containsKey(vertices)){
                        graph.put(vertices, weight);
                    } // end if statement to check that source!=dest
                    else { // if source = dest
                        do {
                            source = nodes.get(random.nextInt(v));
                            dest = nodes.get(random.nextInt(v));
                            vertices = source + " " + dest;
                            weight = random.nextInt(cost);
                            if (source!=dest) {
                                graph.putIfAbsent(vertices, weight);
                            } // end if statement to check that source!=dest    
                        } while (source==dest || graph.containsKey(vertices));
                    }
                } 
                // Load the graph (stored in the Hashmap) into a textfile in the same format as Graph1.txt:
                String filename = "dataset." + Integer.toString(v) + "." + Integer.toString(e);
                try {
                FileWriter writer = new FileWriter(filename);  
                for (Map.Entry<String, Integer> entry : graph.entrySet()){
                    String line = entry.getKey() + " " + entry.getValue()+"\n";
                    writer.write(line);
                }
                writer.close();
                } catch (IOException error) {
                    error.printStackTrace();
                }

            } // end loop for varied edges
        } // end loop for varied vertices 
        
    } // end main class
} // end GraphExperiment class
