package sorting;

//a class for storing Rank object, assigning Rank object linking property with other Nodes to support BST manipulation.
public class Node 
{
	private Node left;
	private Node right;
	private Node p;
	private Rank key;
	
	//default constructor
	public Node()
	{}
	
	//constructor when the key of Node is known
	//@param key the Rank object to construct the Node
	public Node(Rank key)
	{
		this.key = key;
		this.left =null;
		this.right = null;
		this.p =null;
	}
	
	public Node getLeft()
	{
		return this.left;
	}
	
	public Node getRight()
	{
		return this.right;
	}
	
	public Node getParent()
	{
		return this.p;
	}
	
	public Rank getKey()
	{
		return key;
	}
	public void setLeft(Node i)
	{
		this.left = i;
	}
	
	public void setRight(Node i)
	{
		this.right =i;
	}
	
	public void setParent(Node i)
	{
		this.p =i;
	}
	public void setKey(Rank r)
	{
		this.key = r;
	}

}
