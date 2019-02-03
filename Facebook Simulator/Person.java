
//A class for person object that has one field for the name and another field for the list of friends
public class Person implements Comparable<Person>
{
	private String name;
	private PersonList friendList;
	
	/**
	 * constructor of the Person class, constructs a Person with given name and a friend list of 0 friend
	 * @param name the name of person
	 */
	public Person(String name)
	{
		this.name =name;
		friendList = new PersonList();
	}
	
	/**
	 * gets the name of the person
	 * @return name of the person
	 */
	public String getName()
	{
		return name;
	}
	
	@Override
	/**
	 * defines rules for comparing 2 Person objects
	 * @param arg an input object to compare with
	 * @return value of comparing the two Person objects: 0 if 2 Persons are equal
	 */
	public int compareTo(Person arg) 
	{
		return this.getName().compareTo(arg.getName());
	}
	
	/**
	 * makes two persons be in each other's friend list 
	 * @param p the person to be added to this friend list and to add this person to p's friend list
	 */
	public void makeFriend(Person p)
	{
		this.friendList.add(new Node(p));
		p.getFriendList().add(new Node(this));
		
	}
	
	/**
	 * removes two persons from each other's friend list
	 * @param p the person to be removed from this friend list and to remove this person from p's friend list
	 */
	public void unFriend(Person p) 
	{
		this.friendList.delete(friendList.search(p.getName()));
		p.getFriendList().delete(p.getFriendList().search(this.name));
	}
	
	/**
	 * gets the friend list of this person
	 * @return return the friend list 
	 */
	public PersonList getFriendList()
	{
		return friendList;
	}	
	
	/**
	 * checks if two persons are friend or not
	 * @param a one person to be checked
	 * @param b the other person to be checked
	 * @return true if two input persons are friends, false otherwise
	 */
	public static boolean checkFriendStatus(Person a, Person b) 
	{
		if (a.getFriendList().search(b.getName())!= null)
		{
			return true;
		}
		return false;
	} 
}
