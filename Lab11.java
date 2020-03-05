import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
//java.util.ArrayList<E>



public class Lab11 {

	private static Scanner input;
	private static Scanner user;
	
	public static void main(String[] args) 
	{
	
		
	user = new Scanner(System.in);	
	System.out.println("Enter a file name: ");
	String pathname = user.next();
	File file = new File(pathname);
	input = null;
	try 
	{
		input = new Scanner(file);
		//declare new arrayList
		ArrayList<String> schools = new ArrayList<String>();
		
		//schools.add(input.next());
		while(input.hasNext()) 
		{
			// next name in the file
			String newSchool = input.next();
			if(schools.isEmpty()) 
			{
				schools.add(newSchool);
			}
			else {
			
			//cycles through existing schools
			for(int i = 0; i< schools.size(); i++) 
			{
				String str = schools.get(i);
				
				
				//inserts new school before the school after it in alphabetical order
				if(str.compareTo(newSchool) > 0 )
				{
					schools.add(i, newSchool);
					i++;
					break;
				}
				
			}
			
			//in case its last alphabetically
			if(!schools.contains(newSchool)) {
				schools.add(newSchool);
			}
			
			}
			System.out.println(schools);
		}
		
		menu(schools);
		
	}
	catch (FileNotFoundException ex)
	{
		System.out.println("*** Cannot open " + pathname
				+ " ***");
		System.exit(1);  // quit the program
	} 
}
	
	public static void menu(ArrayList<String> array)
	{
	    int choice = 0;
	    do 
	    {
	    	//menu
	       System.out.println("Welcome the menu: please select a task or type '-1' to quit:");
	       System.out.println("1. displayList");
	       System.out.println("2. insertItem");
	       System.out.println("3. removeItem");
	       System.out.println("4. saveList");
	       System.out.println("-1 Quit");
	       choice = user.nextInt();

	       
	       if(choice == 1) 
	 {
	       displayList(array);        
	 }
	       else if (choice == 2) 
	 {
	       insertItem(array);     
	 }
	       else if (choice == 3) 
	 {
	       removeItem(array);     
	 }
	       else if (choice == 4) 
	 {
	       saveList(array);      
	 }
	
	     }while (choice != -1);
	     System.out.println("Thank You for using my program.");
	    }

	
	public static void displayList(ArrayList<String> array)
	{
		//for each loop to display each word
		for(String str: array) 
		{
			System.out.println(str);
		}
		
		
	}
	
	public static void insertItem(ArrayList<String> array)
	{
		System.out.println("Enter a new school to be placed in the array: ");
		String newSchool = user.next();
		
		//cant use for each loop to add or remove elements
		for(int i = 0; i < array.size(); i++) 
		{
			String str = array.get(i);
			
			//prevent duplicates
			if(str.compareTo(newSchool) == 0) {
				break;
			}
			
			//find correct place alphabetically
			else if(str.compareTo(newSchool) > 0)
			{
				array.add(i, newSchool);
				break;
			}
		}
		//in case it is last alphabetically
		if(!array.contains(newSchool)) {
			array.add(newSchool);
		}
		//display the list
		displayList(array);
		
	}
	
	public static void removeItem(ArrayList<String> array) {
		System.out.println("Which school would you like to remove?");
		String remove = user.next();
		for(int i = 0; i < array.size(); i++) 
		{
			String str = array.get(i);
			//if the two are the same, remove it from the list
			if(str.compareTo(remove) == 0)
			{
				array.remove(i);
				break;
			}
		}
		//display the new list
		displayList(array);
	}	
	public static void saveList(ArrayList<String> array) 
	{
		String pathname = "Schools";
	    File file = new File(pathname);
	    PrintWriter output = null;
	    try
	    {
	    	//writing to the file
	       output = new PrintWriter(file);
	       
	       //for each loop to write each new word
	       for(String str : array)
	       {
	    	   output.print(str + " ");
	       }
	    }
	    catch (FileNotFoundException ex)
	    {
	       System.out.println("Cannot create " + pathname);
	       System.exit(1);  // quit the program
	    }
	    output.close();

	}
	
}
