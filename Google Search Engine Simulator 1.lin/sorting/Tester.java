package sorting;
import java.awt.TextArea;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


import webCrawler.Spider;

//driver for creating a search engine simulator
public class Tester 
{
	//static method for Rank[] formatting
	//@param a a Rank list to be printed
	//@return a formatted String array for printing
	public static String printArray(ArrayList<Rank> a)
	{
		String total ="";
	    for (int i=0; i<a.size(); i++)
	    {
	        total = total + "PageRank: " + a.get(i).getPageRank() + ",   Total Score: " + a.get(i).getTotalScore() +",   Index: " + a.get(i).getIndex() + ",   URL: " + a.get(i).getUrl()+ System.lineSeparator();
	    }
	    return total;
	}
	
	//static method for Keyword[] formatting
    //@param a a Keyword list to be printed
	//@return a formatted String array for printing
	public static String printKeywords(ArrayList<Keyword> a)
	{
		String total ="";
	    for (int i=0; i<a.size(); i++)
	    {
	        total = total + "Keywords: " + a.get(i).getWord() + ",   Count: " + a.get(i).getCount() + System.lineSeparator();
	    }
	    return total;
	}
	
	//static method for Rank object formatting
    //@param a a Keyword list to be printed
	//@return a formatted String for printing
	public static String printRank(Rank a)
	{
		String total ="";
	    total = total + "PageRank: " + a.getPageRank() + ",   Total Score: " + a.getTotalScore() +",   Index: " + a.getIndex() + ",   URL: " + a.getUrl()+ System.lineSeparator();
	    return total;
	}
	
	//static method for URLs formatting
    //@param a a URL list to be printed
	//@return a formatted String for printing
	public static String printURLs(LinkedList<String> a)
	{
		String total ="";
		for (int i=0;i<a.size();i++)
		{
	        total = total + a.get(i)+ System.lineSeparator();
		}
	    return total;
	}
	
	//Tester: all test results present here
	public static void main(String args[]) throws IOException
	{
		
		//Testing problem statement 3
		//It creates a spider that takes user input of a search word and a web site, to crawl the web
		//creates a Spider object;
		
		//creates a GUI panel for web crawling
		JPanel crawlPanel = new JPanel();	
	    JTextField keywordField = new JTextField(5);				
	    JTextField websiteField = new JTextField(30);				
	    JButton crawlEnter = new JButton("Enter");
	    final JTextArea crawlLabel = new JTextArea(1,20);  			
	    crawlLabel.setText("Crawl: Enter a search word, and a website to begin with:");	
	  //creates a GUI panel for showing bucket sorted URL list from search history
	  JButton showBucketSort = new JButton("Show bucket sort");
	    crawlPanel.add(crawlLabel);
	    crawlPanel.add(keywordField);
	    crawlPanel.add(websiteField);
	    crawlPanel.add(crawlEnter);
	    crawlPanel.add(showBucketSort);
	    
	    //creates GUI for displaying results
	    final JTextArea textArea = new JTextArea(20, 120); 
	    final JTextArea popularKeywordArea = new JTextArea(20, 10);
	      			//This text area shows label for changing 4 Page Rank factors
	    
	    //creates a GUI panel for URL Insertion
	    JPanel addPanel = new JPanel();	
	    final JTextArea addLabel = new JTextArea(1,40);
	    addLabel.setText("Insertion: Enter URL/ Keyword Score/History Score/Link Score/Paid Score");	 
	    JTextField textField1 = new JTextField(30);				//These five text field takes user input of 4 factors
	    JTextField textField2 = new JTextField(5);				
	    JTextField textField3 = new JTextField(5);
	    JTextField textField4 = new JTextField(5);
	    JTextField textField5 = new JTextField(5);
	    JButton addEnter = new JButton("Enter");
	    addPanel.add(addLabel);
	    addPanel.add(textField1);
	    addPanel.add(textField2);
	    addPanel.add(textField3);
	    addPanel.add(textField4);
	    addPanel.add(textField5);
	    addPanel.add(addEnter);
	    
	    //creates a GUI panel for searching a specific URL from the URL list
	    JPanel searchPanel = new JPanel();
	    JTextField textField6 = new JTextField(10);
	    JButton searchEnter = new JButton("Enter");
	    final JTextArea searchLabel = new JTextArea(1,12);  			
	    searchLabel.setText("Search: Enter Page Rank");	 
	    searchPanel.add(searchLabel);
	    searchPanel.add(textField6);
	    searchPanel.add(searchEnter);
	 
	    //creates a GUI panel for deleting a specific URL from the URL list
	    JPanel deletePanel = new JPanel();
	    JTextField textField7 = new JTextField(10);
	    JButton deleteEnter = new JButton("Enter");
        final JTextArea deleteLabel = new JTextArea(1,12);  			
        deleteLabel.setText("Deletion: Enter Page Rank");	
	    deletePanel.add(deleteLabel);
	    deletePanel.add(textField7);
	    deletePanel.add(deleteEnter);
	    JButton showEnter = new JButton("Show sorted result");  
		deletePanel.add(showEnter);
	       
		
		
		//initializing a list of Keyword objects
	    	ArrayList<Keyword> keywords = new ArrayList<Keyword>();
	    	//initializing a list of Rank objects
	    	ArrayList<Rank> rankList =  new ArrayList<Rank>();
	    	//initializing a list of top 10 popular Keyword objects
	    ArrayList<Keyword>top10Keywords = new ArrayList<Keyword>();
	    	//initializing a Binary Tree for manipulating Rank list
	    	BinaryTree test2 = new BinaryTree();
	    	//initializing a Heap for manipulating Keyword list
	    	Heap test = new Heap();
	    	//initializing a QuickSort for manipulating Rank list
		Quicksort test1 = new Quicksort();
		//initializing a Bucket to use bucket sort
		Bucket test3 = new Bucket();
	 
		
		
		//actions taking place after hitting the enter to crawl web
	    	crawlEnter.addActionListener(event -> 							
	    { 
	    		//crawls the web
	    		rankList.clear();
	    		Spider spider = new Spider(); 
	    		//store collected URLs in an arrayList
    			ArrayList<String> urlList = new ArrayList<String>();
    			//counter for top10 extraction 
	    		
	    		Keyword toadd = new Keyword(keywordField.getText(),null);
	    		if (!top10Keywords.contains(toadd))
	    		{
	    			spider.search(websiteField.getText(),keywordField.getText());
	    			urlList = spider.getUsableLinks();	
	    			toadd.setURL(urlList);
	    			//construct a Keywords object for every search, and add it to the arrayList of Keyword objects
	    			
	    			if (!keywords.contains(toadd))
	    			{
	    				try { test.maxHeapInsert(keywords, toadd); } 
	    				catch (IOException e) { System.out.println("insert key error"); }
	    			}
	    			else
	    			{
	    				try {test.heapIncreaseKey(keywords, toadd.findKeywordIndex(keywords), keywords.get(toadd.findKeywordIndex(keywords)).increaseCount()); } 
	 	   			catch (IOException e) { System.out.println("error"); }	
	    			}	
	    		}
	    		else
	    		{
	    			try {urlList.addAll(keywords.get(toadd.findKeywordIndex(keywords)).getUrl());	} 
	    			catch (IOException e) { System.out.println("error");}	
	    			try {test.heapIncreaseKey(keywords, toadd.findKeywordIndex(keywords), keywords.get(toadd.findKeywordIndex(keywords)).increaseCount()); } 
	 	   			catch (IOException e) { System.out.println("error"); }	
	    		}
	    		
	    		//construct a list of Rank objects
    		    for (int i=0; i<30;i++)				
    		 	{ 
    		       	String url = urlList.get(i);
    		       	rankList.add(new Rank(url,i));	
    		    }
    			top10Keywords.clear();
    		    int counter;
    	   		if (keywords.size()<10) { counter =keywords.size();	}
    	   		else { counter =10;}
    	   		ArrayList<Keyword> temp = (ArrayList<Keyword>) keywords.clone();
    	   		for (int i=0;i<counter;i++)	
    	   		{
    	   			//extracts top 10 Rank object to put in a list
    	   			try {top10Keywords.add(test.extractMax(temp)	);	} 
    	   			catch (IOException e) { System.out.print("top10 extraction error");}		
    	   	    }
	 	      
	 	   //testing 1st Problem Statement
		    ArrayList<Rank> list1 = (ArrayList<Rank>) rankList.clone();
		    test1.quickSort(list1, 0, 29);
		    test1.assignPageRank(list1);
		    textArea.setText(printArray(list1)); 
		    popularKeywordArea.setText(printKeywords(top10Keywords));
		   
		  //tester for 2nd Problem Statement (a)
		   ArrayList<Rank> list2 = (ArrayList<Rank>) rankList.clone();
		   Node root = new Node(list2.get(0));
		   test2.setRoot(root);
		   for (int i=1; i<list2.size(); i++)
		   {
		      test2.treeInsert(test2,new Node(list2.get(i)));
		   }  
		   
		  
	   }); 
	 	
	    	//testing for 3rd Problem Statement
	    	showBucketSort.addActionListener(event ->
		{
			Keyword toadd = new Keyword(keywordField.getText(),null);
			try 
			{
				textArea.setText(printURLs(test3.bucketSort(keywords.get(toadd.findKeywordIndex(keywords)))));
			} 
			catch (IOException e) 
			{	
				System.out.println("3rd Problem Statement Error");
			}
		}
		
		);
       //testing for 2nd Problem Statement (b)
       searchEnter.addActionListener(event -> 							
       { 
    	        	textArea.setText(printRank(test2.treeSearch(test2.getRoot(), textField6.getText()).getKey()));			
       }); 
      
       //tester for 2nd Problem Statement (c)
       addEnter.addActionListener(event -> 							
       { 
    	     	test2.treeInsert(test2, new Node(new Rank(textField1.getText(),textField2.getText(),textField3.getText(),textField4.getText(),textField5.getText(),test2.getCounter())));
    	     	test2.completeTreeWalk();
    	     	textArea.setText(printArray(test2.getNodeKeysArray()));		
       });
       
       //tester for 2nd Problem Statement (d)
       deleteEnter.addActionListener(event -> 							
       { 
    	     	test2.treeDelete(test2, test2.treeSearch(test2.getRoot(), textField7.getText()));
    	     	test2.completeTreeWalk();
    	     	textArea.setText(printArray(test2.getNodeKeysArray()));	
       });
     
       //tester for 2nd Problem Statement (d) 
       showEnter.addActionListener(event -> 							
       { 
    	     	textArea.setText(printArray(test2.getNodeKeysArray()));	
       });
       
       //create a GUI frame for containing all the GUI components created above
        JFrame frame = new JFrame();	
        BoxLayout boxLayout = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
        frame.setLayout(boxLayout);
        frame.add(crawlPanel);
        frame.add(addPanel);				
	    frame.add(searchPanel);	
	    frame.add(deletePanel);	
	    frame.add(textArea);
	    frame.add(popularKeywordArea);  
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.pack();
	    frame.setVisible(true);	      
    }
}   

