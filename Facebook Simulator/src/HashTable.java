import java.io.IOException;

//Create a global hash table that indexes each Node object under the name.
public class HashTable
{
	PersonList[] hashTable;
	
	/**
	 * constructor for the class, initializes a hash table with 12 slots of PersonList
	 */
	public HashTable()
	{
		hashTable = new PersonList[12];
		for (int i=0; i<12;i++)
		{
			hashTable[i] = new PersonList();
		}
	}
	
	/**
	 * calculates hash code of a name
	 * @param name the name which the hash code is based on
	 * @return the calculated hash code
	 */
	public int hashCode(String name)
	{
		return name.length() % 12;
	}
	
	/**
	 * inserts a Person to a HashTable, assuming no two persons with the same name is inserted
	 * @param T the HashTable where the insertion takes place
	 * @param p the Person to be inserted
	 */
	public void chainedHashInsert(HashTable T, Person p)
	{		
		T.hashTable[hashCode(p.getName())].add(new Node(p));	
		System.out.println(hashCode(p.getName()));
	}
	
	/**
	 * searches for a Person in a HashTable
	 * @param T the HashTable where the search takes place
	 * @param name the name of Person to be searched
	 * @return the Node containing the Person with input name
	 */
	public Node chainedHashSearch(HashTable T, String name) 
	{		
		return T.hashTable[hashCode(name)].search(name);	
	}
	
	/**
	 * deletes a Person from a HashTable
	 * @param T the HashTable where the deletion takes place
	 * @param name the name of Person to be deleted
	 */
	public void chainedHashDelete(HashTable T, String name) 
	{		  
		T.hashTable[hashCode(name)].delete(T.chainedHashSearch(T,name));	
	}
	
	/**
	 * prints the entire HashTable
	 * @return a formated String of the entire HashTable
	 */
	public String printList()
	{
		String total ="";
		for (int i=0;i<12;i++)
		{
			total = total + "line " + i + " : "+ hashTable[i].printList() + System.lineSeparator();
		}
		return total;
	}
}
