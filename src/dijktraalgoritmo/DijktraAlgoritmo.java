
package dijktraalgoritmo;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Manuel Franisco Lino Romo
 */
public class DijktraAlgoritmo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingresa la cantidad de nodos en el grafo: ");
        int n = scanner.nextInt();
        
        int[][] graph = new int[n][n];
        
        System.out.println("Ingresa los valores de la matriz: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }
        
        System.out.print("ingresa el nodo origen: ");
        int source = scanner.nextInt();
        int dest = scanner.nextInt();
        
        int[] distance = dijkstra(graph, source);
        
        System.out.println("La distancia mas corta desde el nodo " + source + " al nodo " + dest + "es: "+ distance[dest]);
    }
    
    public static int[] dijkstra(int[][] graph, int source){
        int n = graph.length;
        int[] distances = new int[n];
        boolean[] visited = new boolean[n];
        
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;
        
        for (int i = 0; i <n - 1; i++) {
            int minDistance = Integer.MAX_VALUE;
            int minNode = -1;
            
            for (int j = 0; j < n; j++) {
                if (!visited[j] && distances[j] < minDistance) {
                    minDistance = distances [j];
                    minNode = j;
                }
            }
            
            visited[minNode] = true;
            
            for (int j = 0; j < n; j++) {
                if (graph[minNode][j] != 0 && distances[minNode] != Integer.MAX_VALUE && distances [minNode]
                        + graph[minNode][j] < distances[j]) {
                    distances[j] = distances[minNode] + graph[minNode][j];
                }
            }
        }
        return distances;
    }
}
