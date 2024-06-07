import java.util.*;
public class main {
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int M = scanner.nextInt();
        int N = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        Map<String, List<String>> adjacencyList = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String relation = scanner.nextLine();
            String[] parts = relation.split(" ");
            String person1 = parts[0];
            String person2 = parts[2];

            adjacencyList.computeIfAbsent(person1, k -> new ArrayList<>()).add(person2);
            adjacencyList.computeIfAbsent(person2, k -> new ArrayList<>()).add(person1);
        }

        int numFamilies = findNumberOfFamilies(adjacencyList);
        System.out.println(numFamilies);
    }
private static int findNumberOfFamilies(Map<String, List<String>> adjacencyList) {
        Set<String> visited = new HashSet<>();
        int numFamilies = 0;

        for (String person : adjacencyList.keySet()) {
            if (!visited.contains(person)) {
                bfs(person, adjacencyList, visited);
                numFamilies++;
            }
        }

        return numFamilies;
}

private static void bfs(String start, Map<String, List<String>> adjacencyList, Set<String> visited) {
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            for (String neighbor : adjacencyList.getOrDefault(current, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }
}

   
