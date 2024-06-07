import java.util.*;
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
