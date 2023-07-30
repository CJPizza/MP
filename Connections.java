import java.util.*;
import java.io.*;

class Connections 
{
    private static Connections graph = new Connections();
    private Map<Integer, Person> people;

    public Connections() 
    {
        people = new HashMap<>();
    }

    public Person getPerson(int id) 
    {
        return people.get(id);
    }

    public boolean hasPerson(int id) 
    {
        return people.containsKey(id);
    }

    public static void displayFriendList() 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID number of the person: ");
        int id = scanner.nextInt();

        if (graph.hasPerson(id)) 
        {
            Person person = graph.getPerson(id);
            List<Integer> friends = person.getFriends();
            System.out.println("Person " + id + " has " + friends.size() + " friends: " + friends);
        } 
        else 
        {
            System.out.println("Person " + id + " not found in the dataset.");
        }
    }

    public static void displayConnections() 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ID of the first person: ");
        int a = scanner.nextInt();
        System.out.print("Enter ID of the second person: ");
        int b = scanner.nextInt();

        if (!graph.hasPerson(a) || !graph.hasPerson(b)) {
            System.out.println("One or both persons not found in the dataset.");
        } 
        else 
        {
            List<Integer> connection = findConnection(a, b);
            if (connection == null) 
            {
                System.out.println("Cannot find connection between " + a + " and " + b);
            } 
            else 
            {
                
                System.out.println(a + " is friends with " + b);
            }
        }
    }

    public static List<Integer> findConnection(int start, int end) 
    {
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[graph.getPerson(start).getId() + 1];
        dfs(start, end, visited, path);
        return path.isEmpty() ? null : path;
    }

    public static boolean dfs(int current, int end, boolean[] visited, List<Integer> path) {
        visited[current] = true;
        path.add(current);

        if (current == end) {
            return true;
        }

        for (int friend : graph.getPerson(current).getFriends()) {
            if (!visited[friend] && dfs(friend, end, visited, path)) {
                return true;
            }
        }

        path.remove(path.size() - 1);
        return false;
    }
}