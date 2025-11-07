public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.printGraph();
        System.out.println("Minimum colors required: " + graph.colorsRequired());
    }
}
