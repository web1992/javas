package cn.web1992.data.struct.graph;

/**
 * @author web1992
 * @date 2022/3/2  5:32 下午
 */
public class GraphMain {

    public static void main(String[] args) {

        Graph graph = init();
        graph.bfs(3, 7);

    }


    private static Graph init() {
        Graph graph = new Graph(8);

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);

        graph.addEdge(1, 2);
        graph.addEdge(1, 4);

        graph.addEdge(3, 4);

        graph.addEdge(2, 5);

        graph.addEdge(4, 5);
        graph.addEdge(4, 6);

        graph.addEdge(5, 7);

        graph.addEdge(6, 7);

        return graph;
    }


}
