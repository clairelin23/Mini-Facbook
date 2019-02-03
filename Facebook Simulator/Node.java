
	//a Node class for storing Person object and assigning ordering relationship with other Nodes to support PersonList manipulation
	public class Node 
	{
		private Node next;
		private Node prev;
		private Person p;
		
		/**
		 * default constructor, constructs an empty node with no ordering relationship
		 */
		public Node() 
		{}
		
		/**
		 * constructor for when the key this Node is known
		 * @param p the key of this Node
		 */
		public Node(Person p)
		{
			this.p = p;
			this.next =null;
			this.prev =null;	
		}
		
		/**
		 * gets the next node of this node
		 * @return the next node
		 */
		public Node getNext()
		{
			return this.next;
		}
				
		/**
		 * gets the previous node of this node
		 * @return the previous node
		 */
		public Node getPrev()
		{
			return this.prev;
		}
		
		/**
		 * gets the key of this node
		 * @return the key which is a Person object
		 */
		public Person getKey()
		{
			return p;
		}
		
		/**
		 * sets the next node of this node
		 * @param i the node to be set as next node
		 */
		public void setNext(Node i)
		{
			this.next= i;
		}
		
		/**
		 * sets the previous node of this node
		 * @param i the node to be set as the previous node
		 */
		public void setPrev(Node i)
		{
			this.prev =i;
		}
		
		/**
		 * sets the key of this node
		 * @param r the Person object to be set as this node's key
		 */
		public void setKey(Person r)
		{
			this.p = r;
		}
}
