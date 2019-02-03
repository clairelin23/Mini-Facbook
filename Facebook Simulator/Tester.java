import java.awt.Color;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//tester class for testing and creating a GUI for all programming requirements listed
public class Tester 
{
	public static void main(String[] args) throws IOException
	{
		//creates a hash table that store Nodes with Persons as key
		HashTable test = new HashTable();
		// creates a Person to keep track of the current Person for adding and deleting friends
		Node currentPerson = new Node();
		
		//test case - insert 30 Person objects
		Person a = new Person("Amy");
		Person b = new Person("Z");
		Person c = new Person("Jade");
		Person d = new Person("AJ");
		Person e = new Person("Zerubbabel");
		Person f = new Person("Christimarie");
		Person g = new Person("Hannalynnienn");
		Person h  = new Person("Ana");
		Person i  = new Person("Katrina");
		Person j  = new Person("Benson");
		Person k = new Person("Bryant");
		Person l  = new Person("Alan");
		Person m  = new Person("Dana");
		Person n  = new Person("Chloerittie");
		Person o  = new Person("Bob");
		Person p  = new Person("Clement");
		Person q  = new Person("Elizabeth");
		Person r  = new Person("Morrison");
		Person s  = new Person("Ashley");
		Person t  = new Person("Folucho");
		Person u  = new Person("Jennifer");
		Person v  = new Person("Ocean");
		Person w  = new Person("James");
		Person x  = new Person("Catherine");
		Person y  = new Person("Cathy");
		Person z  = new Person("E");
		Person a1  = new Person("RichistMan");
		Person a2  = new Person("Kevin");
		Person a3  = new Person("CJ");
		Person a4  = new Person("Charllaute");
		test.chainedHashInsert(test, a);
		test.chainedHashInsert(test, b);
		test.chainedHashInsert(test, c);
		test.chainedHashInsert(test, d);
		test.chainedHashInsert(test, e);
		test.chainedHashInsert(test, f);
		test.chainedHashInsert(test, g);
		test.chainedHashInsert(test, h);
		test.chainedHashInsert(test, i);
		test.chainedHashInsert(test, j);
		test.chainedHashInsert(test, k);
		test.chainedHashInsert(test, l);
		test.chainedHashInsert(test, m);
		test.chainedHashInsert(test, n);
		test.chainedHashInsert(test, o);
		test.chainedHashInsert(test, q);
		test.chainedHashInsert(test, r);
		test.chainedHashInsert(test, s);
		test.chainedHashInsert(test, t);
		test.chainedHashInsert(test, u);
		test.chainedHashInsert(test, z);
		test.chainedHashInsert(test, w);
		test.chainedHashInsert(test, x);
		test.chainedHashInsert(test, y);
		test.chainedHashInsert(test, a1);
		test.chainedHashInsert(test, a2);
		test.chainedHashInsert(test, a3);
		test.chainedHashInsert(test, a4);
		test.chainedHashInsert(test, p);
		test.chainedHashInsert(test, v);
	
		System.out.print(test.printList());
		
		
		//a display screen to display function messages
		JTextArea display = new JTextArea(5,20);
		
		//panel for displaying current logged-in profile
	    JPanel profilePanel = new JPanel();
	    JLabel profileLabel = new JLabel();
		JLabel profileName = new JLabel();
		profilePanel.add(profileName);
		profilePanel.add(profileLabel);
					
		//panel for creating a new profile for a person
		JPanel createRecordPanel = new JPanel();
		JLabel createLabel = new JLabel();
		createLabel.setText("Enter your name to create your profile");
		JTextField name1 = new JTextField(5);
		JButton createButton  = new JButton("Create Profile");
		createRecordPanel.add(createLabel);
		createRecordPanel.add(name1);
		createRecordPanel.add(createButton);
		createButton.addActionListener(event ->
		{
			display.setText("");
			test.chainedHashInsert(test,new Person(name1.getText()));
			display.setText(name1.getText() +"'s profile is created!");
			name1.setText("");	
		});	
		
		//panel for login
		JPanel loginPanel = new JPanel();
		JTextField loginName = new JTextField(5);
		JButton loginButton = new JButton("login");
		loginPanel.add(loginName);
		loginPanel.add(loginButton);
		loginButton.addActionListener(event ->
		{
			display.setText("");
			//from name to find person's profile record in hash table
			Node loginPerson = test.chainedHashSearch(test, loginName.getText());
			if (loginPerson == null)
			{
				display.setText("ERROR: no profile with input name: " + loginName.getText());		
			}
			else
			{
				currentPerson.setKey(loginPerson.getKey());
				profileName.setText(currentPerson.getKey().getName());
				profileLabel.setText("logged in");
				profileName.setOpaque(true);
				profileName.setBackground(Color.CYAN);
			}
			loginName.setText("");
		});
				
		//panel for making friend 
		JPanel makeFriendPanel = new JPanel();
		JLabel makeFriendLabel = new JLabel();
		makeFriendLabel.setText("Add friends");
		JTextField friend1 = new JTextField(5);
		JButton makeFriendButton  = new JButton("Make Friend");
		makeFriendPanel.add(makeFriendLabel);
		makeFriendPanel.add(friend1);
		makeFriendPanel.add(makeFriendButton);
		makeFriendButton.addActionListener(event ->
		{
			display.setText("");
			Node friend = test.chainedHashSearch(test, friend1.getText());
			// check if friend is in hash table
			if (friend ==null)
			{
				display.setText("ERROR:" + friend1.getText() + "'s profile is not in record");
			}
			else
			{
				//if two people are already friends
				if (currentPerson.getKey().getFriendList().contains(friend.getKey()))
				{
					display.setText("ERROR: "+ friend.getKey().getName() + " and " + currentPerson.getKey().getName() + " are already friends");
				}
				//if two people are not friends yet
				else
				{
				    currentPerson.getKey().makeFriend(friend.getKey());
				    display.setText(currentPerson.getKey().getName() + " and " +friend.getKey().getName() + " make friend success :)");	
				}
			}
			friend1.setText("");	
		});
				
		//create panel for un-friending
		JPanel unFriendPanel = new JPanel();
		JLabel unFriendLabel = new JLabel();
		unFriendLabel.setText("Remove friends");
		JTextField friend2 = new JTextField(5);
		JButton unfriendButton  = new JButton("Unfriend");
		unFriendPanel.add(unFriendLabel);
		unFriendPanel.add(friend2);
		unFriendPanel.add(unfriendButton);
		unfriendButton.addActionListener(event ->
		{
			display.setText("");
			Node friend = test.chainedHashSearch(test, friend2.getText());
			//check if friend is in hash table
			if (friend ==null)
			{
				display.setText("ERROR: " + friend2.getText() + "'s profile is not in record");
			}
			//if two friends are not friends
			else
			{
				//if two friends are not friends already
				if (!currentPerson.getKey().getFriendList().contains(friend.getKey()))
				{
					display.setText("ERROR: "+ friend.getKey().getName() + " and " + currentPerson.getKey().getName() + " are not friends in the first place");
				}
				//if two friends are friends
				else
				{	
					currentPerson.getKey().unFriend(friend.getKey());
					display.setText(currentPerson.getKey().getName() + " and " + friend.getKey().getName() + " unfriend success :(");				    
				}	
			}
			friend2.setText("");
		});
			
		//create panel for display friend list of a person
		JPanel friendListPanel = new JPanel();
		JTextField name2 = new JTextField(5);
		JLabel friendListLabel = new JLabel();
		friendListLabel.setText("Enter a name to display friend list:");
		JButton displayFriendList  = new JButton("display all friends");
		friendListPanel.add(friendListLabel);
		friendListPanel.add(name2);
		friendListPanel.add(displayFriendList);
		displayFriendList.addActionListener(event ->
		{
			display.setText("");
			Node person = test.chainedHashSearch(test, name2.getText());
			//if the person is not in hash table
			if (person == null)
			{
				display.setText("ERROR:" + name2.getText() + "'s profile is not in record");
				name2.setText("");
				return;
			}
			PersonList friends = person.getKey().getFriendList();
			//if the person has 0 friend
			if (friends.getHead()==null)
			{
				display.setText(person.getKey().getName() + " has no friends..lonely");
			}
			//if the person has > 0 friends
			else
			{
				display.setText(person.getKey().getName() +"'s friends: " + friends.printList());
			}
			name2.setText("");
		});
		
		//create panel for checking friend status
		JPanel checkFriendStatusPanel = new JPanel();
		JTextField name3 = new JTextField(5);
		JTextField name4 = new JTextField(5);
		JTextArea friendStatusLabel = new JTextArea(1,15);
		friendStatusLabel.setText("Check two person's friendship status:");
		JButton checkStatus  = new JButton("check");
		checkFriendStatusPanel.add(friendStatusLabel);
		checkFriendStatusPanel.add(name3);
		checkFriendStatusPanel.add(name4);
		checkFriendStatusPanel.add(checkStatus);
		checkStatus.addActionListener(event ->
		{
			display.setText("");
			Node person1 = test.chainedHashSearch(test, name3.getText());
			Node person2 = test.chainedHashSearch(test, name4.getText());
			//if both input persons are not in hash table
			if (person2==null && person1==null)
			{
				display.setText("ERROR: " +  name3.getText() + " , " + name4.getText() + " not found in record");
				return;
			}
			//if one of the input person is not in hash table
			else if (person1==null)
			{
				display.setText("ERROR: " + name3.getText() + " not found in record");
				return;
			}
			//if one of the input person is not in hash table
			else if (person2==null)
			{
				display.setText("ERROR: " + name4.getText() + " not found in record");
				return;
			}
			Boolean status = Person.checkFriendStatus(person1.getKey(),person2.getKey());
			//if two people are friends
			if (status ==true)
			{
				display.setText(name3.getText() + " and " + name4.getText() + " are friends");
			}
			//if two people are not friends
			else
			{
			     display.setText(name3.getText() + " and " + name4.getText() + " are NOT friends");
			}
			name3.setText("");
			name4.setText("");		
		});
					
		//create a frame for containing all the GUI components created above
     	JFrame frame = new JFrame();	
     	//create a rectangular bar to seperate functions in the frame
     	JPanel bar = new JPanel();
     	bar.setBackground(Color.CYAN);
     	//set layout of frame
     	BoxLayout boxLayout = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
     	frame.setLayout(boxLayout);
     	//add all components to frame
     	frame.add(profilePanel);	
     	frame.add(loginPanel);
     	frame.add(makeFriendPanel);
     	frame.add(unFriendPanel);
     	frame.add(bar);
     	frame.add(createRecordPanel);
     	frame.add(friendListPanel);
     	frame.add(checkFriendStatusPanel);
     	frame.add(display);
     	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     	frame.pack();
     	frame.setVisible(true);	      		
	}

}
