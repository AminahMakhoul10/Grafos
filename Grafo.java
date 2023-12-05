import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Grafo {
    private ArrayList<Integer> vertices;
    private ArrayList<ArrayList<Integer>> arestas;

    public Grafo() {
        this.vertices = new ArrayList<>();
        this.arestas = new ArrayList<>();
    }

    public void adicionarVertice(int vertice) {
        if (!vertices.contains(vertice)) {
            vertices.add(vertice);
            arestas.add(new ArrayList<>());
        }
    }

    public void adicionarAresta(int vertice1, int vertice2) {
        if (vertices.contains(vertice1) && vertices.contains(vertice2)) {
            arestas.get(vertices.indexOf(vertice1)).add(vertice2);
            arestas.get(vertices.indexOf(vertice2)).add(vertice1);
        }
    }

    public void bfs(int verticeInicial) {
        boolean[] visitados = new boolean[vertices.size()];
        Queue<Integer> fila = new LinkedList<>();

        visitados[vertices.indexOf(verticeInicial)] = true;
        fila.add(verticeInicial);

        while (!fila.isEmpty()) {
            int atual = fila.poll();
            System.out.print(atual + " ");

            for (int vizinho : arestas.get(vertices.indexOf(atual))) {
                if (!visitados[vertices.indexOf(vizinho)]) {
                    visitados[vertices.indexOf(vizinho)] = true;
                    fila.add(vizinho);
                }
            }
        }
    }

    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        grafo.adicionarVertice(1);
        grafo.adicionarVertice(2);
        grafo.adicionarVertice(3);
        grafo.adicionarVertice(4);
        grafo.adicionarVertice(5);

        grafo.adicionarAresta(1, 2);
        grafo.adicionarAresta(1, 3);
        grafo.adicionarAresta(2, 4);
        grafo.adicionarAresta(2, 5);

        System.out.println("(BFS) Travessia em Largura a partir do vértice 1:");
        grafo.bfs(1);
    }
}
