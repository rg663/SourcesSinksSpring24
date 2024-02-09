package org.example.bfs;

import java.util.*;

public class BFS {
    public static void bfs(HashMap<Integer, List<Integer>> map){
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        HashSet<Integer> visited = new HashSet<>();
        visited.add(0);
        HashMap<Integer, Integer> distance = new HashMap<>();
        distance.put(0, 0);

        while (!q.isEmpty()){
            int node = q.poll();
            if (map.containsKey(node)){
                for (Integer neighbor : map.get(node)){
                    if (!visited.contains(neighbor)){
                        visited.add(neighbor);
                        q.add(neighbor);
                        distance.put(neighbor, distance.get(node) + 1);
                    }
                }
            }
        }
        System.out.println(distance);

    }


    public static void main(String[] args) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(0, 2));
        graph.put(2, Arrays.asList(0, 1, 3));
        bfs(graph);
    }
}