package com.qa.main;

import java.sql.SQLException;
import java.util.Scanner;

public class Runner {
	
	// Scanner
    public static Scanner scan = new Scanner(System.in);
	
    public static void main(String[] args) throws SQLException {
        DatabaseConnector db = new DatabaseConnector();
        
        String action = "";
   //	create, read, update, delete
        action = getAction();
      try
      {
    	  do 
    	  {
    		  switch(action)
    	        {
    	        case "create":
    	        	System.out.println("Please enter a first name: ");
    	        	String first_name = scan.nextLine();
    	        	System.out.println("Please enter a last name: ");
    	        	String last_name = scan.nextLine();
    	        	db.createActor(first_name, last_name);
    	        	break;
    	        case "read":
    	        	db.readAllActors();
    	        	break;
    	        case "update":
    	        	System.out.println("Please enter the ID of the actor you want to change: ");
    	        	int updateId = Integer.parseInt(scan.nextLine());
    	        	System.out.println("Please enter a new first name: ");
    	        	String updateForename = scan.nextLine();
    	        	System.out.println("Please enter a new last name: ");
    	        	String updateSurname = scan.nextLine();
    	        	db.updateActor(updateForename, updateSurname, updateId);
    	        	break;
    	        case "delete":
    	        	System.out.println("Please enter the ID of the actor you want to delete: ");
    	        	int deleteId = scan.nextInt();
    	        	db.deleteActor(deleteId);
    	        	break;
    	        default:
    	        	System.out.println("No matching case-statement");
    	        }
    		  action = getAction();
    	  }
    	  	while(!action.equals("exit"));
    		System.out.println("Bye");
    	}
    	  finally
    	  {
    		  scan.close();
    		  db.close();
    	  }
    }
        
//        db.readAllActors();
//        db.createActor("Geoff", "Rush");
//        db.readAllActors();
//        db.updateActor("Geoff", "Bush", 1);
//        db.readAllActors();
//        db.deleteActor(1);
    
    private static String getAction()
    {
        System.out.println("Please enter the CRUD method you want: ");
        return scan.nextLine();
    }
}
