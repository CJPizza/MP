import java.util.*;

public class Person 
{
    private int id;
    private List<Integer> friends;

    public Person(int id) 
    {
        this.id = id;
        this.friends = new ArrayList<>();
    }

    public int getId() 
    {
        return id;
    }

    public void addFriend(int friendId) 
    {
        friends.add(friendId);
    }

    public List<Integer> getFriends() 
    {
        return friends;
    }
}



