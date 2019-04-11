import java.io.IOException;

//A linked list class that stores Nodes objects, each Node has a Person object as key
public class PersonList 
{
	//first node of a FriendList
	private Node head;
	
	/**
	 * constructor for the PersonList class, constructs an empty list
	 */
	public PersonList()
	{
		head = null;
	}
	
	/**
	 * searches for a person in this list 
	 * @param name name of the person to be searched
	 * @return name of the person if search is successful, return null if can't find the specified person
	 */
	public Node search(String name) 
	{
		
	    Node x = head;
	      while(x!=null && name.compareTo(x.getKey().getName())!=0)
	      {
	    	  	x = x.getNext();
	      }
	      return x;
	}
	
	/**
	 * adds a person to this list
	 * @param x the Node containing the person object to be added
	 */
	public void add(Node x)
	{
		x.setNext(head);
		if (head !=null)
		{
			head.setPrev(x);
		}
		head =x;
		x.setPrev(null);
	}
	
	/**
	 * deletes a person from this list
	 * @param x the Node containing the person object to be deleted
	 */
	public void delete(Node x)
	{
		if (x.getPrev()!=null)
		{
			x.getPrev().setNext(x.getNext());
		}
		else 
		{
			head=x.getNext();
		}
		if (x.getNext()!=null)
		{
			x.getNext().setPrev(x.getPrev());
		}
	}
	
	/**
	 * prints this list of person's names
	 * @return the list of person's names
	 */
	public String printList()
	{
		String total="";
	    Node x = head;
		while (x!=null)
		{
		  total = total + x.getKey().getName() + " ";
		  x=x.getNext();
		}
		return total;
	}
	
	/**
	 * gets the first element of this list
	 * @return null if the list is empty
	 */
	public Node getHead()
	{
		return head;
	}
	
	/**
	 * checks if there is a duplicate in this list 
	 * @param a the person to checked to see if there is a duplicate
	 * @return true if there is no duplicate, false otherwise
	 */
	public boolean contains(Person a)
	{
		Node x =head;
		while (x!=null)
		{
			if (x.getKey().getName().equals(a.getName()))
			{
				return true;
			}
			x = x.getNext();
		}
		return false;
	}
}
