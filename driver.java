import java.util.*;
import java.io.*;

public class driver extends Connections
{
    public static void main (String[] args)
    {
        boolean flag = false;
        String filename = null;
        File file = null;
        int choice = 0;
        Scanner input = new Scanner(System.in);
        do{
        System.out.print("Input file path: ");
        filename = input.nextLine();
        file = new File(filename);
        flag = false;
        if(!file.exists())
        {
            System.out.println("\nFile does not exist...\n");
            flag = true;
        }
        }while(flag);

        Graph graph = new Graph(file);
        graph.printGraph();
        System.out.println("\nGraph loaded!");

        while (!flag)
        {
        do{
            System.out.println("\nMAIN MENU\n[1] Get Friend List\n[2] Get Connections\n[3] Exit\n");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
        }while(choice > 3 && choice < 0);

        switch(choice)
        {
            case 1: displayFriendList(); break;
            case 2: displayConnections(); break;
            case 3: System.out.println("Exiting Program.");
                    flag = true; break;
            default: System.out.println("Invalid Option. Please try again."); break; 
        }
        }
    }
}