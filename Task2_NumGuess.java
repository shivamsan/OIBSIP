package com.oasis;
import java.util.*;
public class Task2_NumGuess {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		System.out.println("----------------------------------------------------------------------------------------------------------");
		System.out.println("\t\t\t\t\tNumber Guessing Game");
		System.out.println("----------------------------------------------------------------------------------------------------------\n");
		
		System.out.println("\t\t\t\t\t\tRules\n\t\t\t\t\t\t-----");
		
		System.out.println("1. This game generates a random number between 1-100 and you will have to guess it right");
		System.out.println("2. There will be in total 10 rounds");
		System.out.println("3. For each correct guess, you will gain 10 points and will advance to next guess");
		System.out.println("4. If you guess all consicutive 10 guesses correctly you will be declared the winner");
		System.out.println("5. Any wrong guess would result into termination of game and you will have to start over");
		System.out.println("6. To still continue playing the game press 1");
		System.out.println("7. To exit out of the game press 0\n\n");
		
		System.out.println("Let the game begin\n");
		int ch =1;
		int points=0;
		
		int round=1;
		do
		{
			System.out.println("Round "+round);
			round=round+1;
			System.out.println("Your current score = "+points);
			System.out.println("Generating number...\n");
			System.out.println("Guess the number ###");
			
			int n=sc.nextInt();
			int ran = r.nextInt(100);
			//int ran =5;
			
			if (n==ran)
			{
				System.out.println("You Guessed it right.");
				if(round==10)
				{
					System.out.println("You just scored a 100!! \nCongrats!! YOU WON THE GAME!!");
					break;
				}
				System.out.println("You earned +10 points Advancing to next round...\n\n");
				points= points+10;
				
				continue;
			}
			else if(n<ran)
			{
				System.out.println("You guessed too low");
				
			}
			else if(n>ran && n<=100)
			{
				System.out.println("You guessed too high");
			}
			else if(n>100)
			{
				System.out.println("Entered number is out limit. Enter number between 1 to 100");
			}
			System.out.println("The number was "+ran);
			System.out.println("Do you still wanna continue. \nTo still continue playing the game press 1. \nTo exit the game press 0.");
			ch=sc.nextInt();
			
		}while(ch==1 && round <=10);
		System.out.println("Thank you for playing. \nEnding Game...");
		sc.close();
		
		
	}

}
