package com.oasis;

import java.util.HashMap;
import java.util.Scanner;

public class Task3_AtmInterface {

	public static void main(String[] args) {
		// install machine
		//creating object of class Atm_opn
		Atm_opn obj = new Atm_opn();
	}
}
class Data{
	//variables
	float  Balance;
	String name;
	int pin;
}

class Atm_opn{
	
	int transactions = 0;
	String transactionHistory = "";
	
	Scanner sc = new Scanner(System.in);

	HashMap<String, Data> map =new HashMap<>();
	
	Atm_opn(){
		//constructor
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println("\t\t\tGoliath National Bank - Your Financial Wingman");
		System.out.println("-------------------------------------------------------------------------------------------\n\n");
		System.out.println("Welcome to GNB Bank");
		opn();
	}
	
	public void opn()
	{
		
		System.out.print("Enter your Account Number: ");
		String AccNum = sc.next();
		try
		{
			if (map.containsKey(AccNum)==true)
			{
				Data obj = map.get(AccNum);
				Menu(obj);
			}
		else
			{
			System.out.println("Account Does not exist");
			System.out.println("-------------------------------------------------------------------------------------------\n\n");
			System.out.println("Kindly, create Bank Account first\n");
			System.out.print("Set your Bank Account Number: ");
			String AccNumber = sc.next();
			
			Data obj = new Data();
			map.put(AccNumber, obj);
			
			System.out.print("Enter your Name: ");
			obj.name = sc.next();
			
			System.out.print("Set your 4 digit pin : ");
			obj.pin = sc.nextInt();
			
			Menu(obj);
			}
		}
		catch ( Exception e) {
		}
		}
	
	public void Menu(Data obj) {
		System.out.println("\n\n-------------------------------------------------------------------------------------------");

		System.out.println("Please Select valid number ");
		
		System.out.println("1 . Check balance");
        System.out.println("2 . Deposit money");
        System.out.println("3 . Withdraw money");
        System.out.println("4 . Check another account");
        System.out.println("5 . Transfer money");
        System.out.println("6 . Transaction history");
        System.out.println("7 . exit");
		System.out.println("-------------------------------------------------------------------------------------------\n");

        System.out.print("Enter your choice: ");
		int x = sc.nextInt();
		System.out.println("");
		
		switch (x)
		{
		case 1:
		{
			check_Bal(obj);
			break;
		}
		case 2:
		{
			deposit(obj);
			break;
		}
		case 3:
		{
			withdraw(obj);
			break;
		}
		case 4:
		{
			opn();
			break;
		}
		case 5:
		{
			transfer(obj);
			break;
		}
		case 6:
		{
			transHistory(obj);
			break;
		}
		case 7:
		{
			System.out.println("Thank you!");
			break;
		}
		default:
		{
			System.out.println("Please enter valid number: ");
			Menu(obj);
		}
		}
	}
	
		public void check_Bal(Data obj)
		{
			System.out.println("Your Bank Balance is: "+ obj.Balance);
			Menu(obj);
		}
		
		public void deposit(Data obj)
		{
			System.out.print("Enter your amount to deposite: ");
			float a = sc.nextFloat();
			
			try
			{
			obj.Balance = obj.Balance +a;
			System.out.println("Amount deposited succesfully");
			String str = a + " Rs deposited\n";
			transactionHistory = transactionHistory.concat(str);
			transactions++;
			Menu(obj);
			}
			catch ( Exception e) {
			}
		}
		
		public void withdraw(Data obj)
		{
			System.out.print("Enter your amount to withdraw: ");
			float w = sc.nextFloat();
			
			try
			{
			if(obj.Balance>= w)
			{
				obj.Balance = obj.Balance -w;
				System.out.println("Amount withdrawn succesfully");
				String str = w + " Rs Withdrawn\n";
				transactionHistory = transactionHistory.concat(str);
				transactions++;
			}
			else
			{
				System.out.println("Insufficient Balance\nEnter a valid number to withdraw\n");
				withdraw(obj);
			}
			}
			catch ( Exception e) {
			}
			
			Menu(obj);
		}
		
		public void transfer(Data obj) {
			System.out.println("Enter amount to tranfer");
			float trans = sc.nextFloat();
			
			try
			{
				if(trans==0)
				{
					System.out.println("Transfer amount cannot be Null/0");
				}
		
			if(obj.Balance>= trans)
			{
				obj.Balance = obj.Balance -trans;
			}
			else
			{
				System.out.println("Insufficient Balance");
				transfer(obj);
			}
			}
			catch ( Exception e) {
			}
			Amount_trans(trans);
	}
		
		public void Amount_trans(float trans)
		{
			System.out.print("Enter Account Number of the recipient to transfer amount: ");
			String AccNum = sc.next();
			
			try
			{
				if (map.containsKey(AccNum)==true)
			{
				Data obj = map.get(AccNum);

				obj.Balance = obj.Balance +trans;
				System.out.println("Amount transfer succesfully to "+ obj.name);
				transactions++;
				String str = trans + " Rs transfered to " + obj.name +"\n";
				transactionHistory = transactionHistory.concat(str);
				
				Menu(obj);
			}
			else {
				System.out.println("Account of the recipient does not exist");

				System.out.println("Kindly, create Bank Account first\n");
				
				System.out.print("Set your Bank Account Number: ");
				String AccNumber = sc.next();
				
				Data obj = new Data();
				map.put(AccNumber, obj);
				
				System.out.print("Enter your Name: ");
				obj.name = sc.next();
				
				System.out.print("Set your 4 digit pin : ");
				obj.pin = sc.nextInt();
				
				obj.Balance = obj.Balance +trans;
				System.out.println("Amount transfer succesfully");
				transactions++;
				String str = trans + " Rs transfered to " + obj.name +"\n";
				transactionHistory = transactionHistory.concat(str);
				Menu(obj);
			}
			}
			catch ( Exception e) {
			}
		}
			
		public void transHistory(Data obj) {
			if ( transactions == 0 ) {
				System.out.println("\nEmpty");
			}
			else {
				System.out.println("\n" + transactionHistory);
				Menu(obj);
			}
		}	
}