package Search;

import java.util.*;

public class BreadthFirstSearch {
    private static Map<String, List<String>> graph = new HashMap<>();

    private static boolean search(String name, char targetChar) {
        Queue<String> searchQueue = new ArrayDeque<>(graph.get(name));
        List<String> searched = new ArrayList<>();

        while (!searchQueue.isEmpty()) {
            String person = searchQueue.poll();

            if (!searched.contains(person)) {
                //System.out.println(person); // 顯示節點名字

                if (person_is_seller(person, targetChar)) {
                    System.out.println(person + " is a seller!");
                    return true;
                } else {
                    List<String> neighbors = graph.get(person);
                    if (neighbors != null) {
                        searchQueue.addAll(neighbors);
                    }
                    searched.add(person);
                }
            }
        }

        return false;
    }

    private static boolean person_is_seller(String name, char targetChar) {
        //return name.endsWith("m");
    	return name.startsWith(String.valueOf(targetChar));
    }

    public static void main(String[] args) {
        graph.put("you", Arrays.asList("alice", "bob", "claire"));
        graph.put("bob", Arrays.asList("anuj", "peggy"));
        graph.put("alice", Arrays.asList("peggy"));
        graph.put("claire", Arrays.asList("thom", "jonny"));
        graph.put("anuj", Collections.emptyList());
        graph.put("peggy", Collections.emptyList());
        graph.put("thom", Collections.emptyList());
        graph.put("jonny", Collections.emptyList());

        search("bob",'a');
    }
}
