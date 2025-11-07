import java.util.*;

public class Graph {

    private int V;
    private int E;
    private List<List<Integer>> adj;
    Scanner sc = new Scanner(System.in);
    public Graph(){
        System.out.print("Enter the number of vertices (1 - 100): ");
        try {
            V = sc.nextInt();
        } catch (InputMismatchException ime) {
            throw new IllegalArgumentException("Expected an integer for number of vertices.");
        }

        if (V < 1 || V > 100) {
            throw new IllegalArgumentException("Invalid number of vertices: " + V + ". Must be 1..100.");
        }

        // adjacency list with initial capacity V
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        int maxEdges = V * (V - 1) / 2;
        System.out.printf("Enter the number of edges (0 - %d): ", maxEdges);

        try {
            E = sc.nextInt();
        } catch (InputMismatchException ime) {
            throw new IllegalArgumentException("Expected an integer for number of edges.");
        }

        if (E < 0 || E > maxEdges) {
            throw new IllegalArgumentException("Invalid number of edges: " + E + ". Must be 0.." + maxEdges + ".");
        }


        System.out.println("Enter the edges: ");
        for(int i = 0; i < E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            if(u < 0 || u >= V || v < 0 || v >= V){
                System.out.println("Edge not added : Invalid vertices.");
                i--;
                continue;
            }
            else if(u == v){
                System.out.println("Edge not added : Self loop not allowed.");
                i--;
                continue;
            }
            else if(adj.get(u).contains(v)){
                System.out.println("Edge not added : Duplicate edge.");
                i--;
                continue;
            }

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    }

    public void printGraph(){
        for(int i = 0; i < V; i++){
            System.out.println("Adjacency list of vertex " + i);
            System.out.println(adj.get(i));
            System.out.println();
        }

    }

    public int colorsRequired(){
        if (V == 0) return 0;

        int[] color = new int[V];
        Arrays.fill(color, -1);
        List<HashSet<Integer>> adjCols = new ArrayList<>(V);
        int[] degree = new int[V];

        for (int i = 0; i < V; i++) {
            adjCols.add(new HashSet<>());
            degree[i] = adj.get(i).size();
        }

        PriorityQueue<NodeDeg> pq = new PriorityQueue<>();
        for (int i = 0; i < V; i++) {
            pq.add(new NodeDeg(0, degree[i], i));
        }

        int coloredCount = 0;
        while(!pq.isEmpty() && coloredCount < V){
            NodeDeg node = pq.poll();
            int u = node.u;

            if(color[u] != -1) continue;

            int currSat = adjCols.get(u).size();
            if(node.sat != currSat || node.deg != degree[u]){
                pq.add(new NodeDeg(currSat, degree[u], u));
                continue;
            }

            boolean[] used = new boolean[V];
            for (int v : adj.get(u)) {
                if (color[v] != -1) used[color[v]] = true;
            }

            int assignColor = 0;
            while (assignColor < used.length && used[assignColor]) assignColor++;
            color[u] = assignColor;
            coloredCount++;

            for (int v : adj.get(u)) {
                if (color[v] == -1 && !adjCols.get(v).contains(assignColor)) {
                    adjCols.get(v).add(assignColor);
                    pq.add(new NodeDeg(adjCols.get(v).size(), degree[v], v));
                }
            }
        }

        return Arrays.stream(color).max().orElse(-1) + 1;
    }
}
