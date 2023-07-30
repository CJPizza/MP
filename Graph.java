import java.util.*;
import java.io.*;
public class Graph 
{
    private ArrayList<ArrayList<Integer>> graph;
    private ArrayList<Integer> path;
    private boolean choice = false;
    private int numAcc;
    private int numFriends;

        public Graph(File file)
        {
            this.graph = new ArrayList<ArrayList<Integer>>();
            Scanner read = null;
            try 
            {
               read = new Scanner(file);
            } catch (FileNotFoundException e) 
            {
                System.out.println("ERROR!!!");
            }

            this.numAcc = read.nextInt();
            this.numFriends = read.nextInt();
            System.out.println(numAcc);
            System.out.println(numFriends);
            for (int i = 0; i < numAcc; i++)
            {
                graph.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < numFriends; i++)
            {
                int v = read.nextInt();
                int u = read.nextInt();
                addEdge(v, u);
            }
        }
        public void printGraph()
        {
            System.out.print(graph);
        }
        public void addEdge(int v, int u)
        {
            graph.get(v).add(u);
            graph.get(u).add(v);
        }
}

