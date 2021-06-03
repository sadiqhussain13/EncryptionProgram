package encryp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class EncryptionProgram 
{
	private Scanner scanner;
	private Random random;
	private ArrayList<Character> list;
	private ArrayList<Character> shuffledList;
	private char character;
	private String line;
	private char[] letters;
	
	 EncryptionProgram() 
	 {
		scanner = new Scanner(System.in);
		random = new Random();
		list = new ArrayList();
		shuffledList = new ArrayList();
		character = ' ';
		
		newKey();
		askQuestion();
	 }
	 private void askQuestion()
	 {
		 while(true)
		 {
			 System.out.println("______________________________________________________________");
			 System.out.println("What is your order?");
			 System.out.println("(N)newkey | (G)getkey | (E)encrypt | (D)decrypt | (Q)quit");
			 char response = Character.toUpperCase(scanner.nextLine().charAt(0));
			 switch (response) {
			case 'N':
				newKey();
				break;

			case 'G':
				getKey();
				break;
				
			case 'E':
				encrypt();
				break;
				
			case 'D':
				decrypt();
				break;
				
			case 'Q':
				quit();
				break;
				
			default:
				System.out.println("Invalid!");
				break;
			}
		 }
	 }
	 private void newKey() 
	 {
		character = ' ';
		list.clear();
		shuffledList.clear();
		
		for(int i = 32; i < 127; i++)
		{
			list.add(Character.valueOf(character));
			character++;
		}
		
		shuffledList = new ArrayList(list);
		Collections.shuffle(shuffledList);
		System.out.println("[A new key has been generated]");
	 }
	 private void getKey() 
	 {
		System.out.println("Key: ");
		for(Character x: list)
		{
			System.out.print(x);
		}
		System.out.println();	
		for(Character x: shuffledList)
		{
			System.out.print(x);
		}
		System.out.println();
	 }
	 private void encrypt() 
	 {
		System.out.println("Enter your message: ");
		String message = scanner.nextLine();
		letters = message.toCharArray();
		for(int i = 0; i < letters.length; i++)
		{
			for(int j = 0; j < list.size(); j++)
			{
				if(letters[i] == list.get(j))
				{
					letters[i] = shuffledList.get(j);
					break;
				}
			}
		}
		System.out.println("Encrypted message: ");
		for(char x : letters)
		{
			System.out.print(x);
		}
		System.out.println();
	 }
	 private void decrypt() 
	 {
		 System.out.println("Enter your message: ");
			String message = scanner.nextLine();
			letters = message.toCharArray();
			for(int i = 0; i < letters.length; i++)
			{
				for(int j = 0; j < shuffledList.size(); j++)
				{
					if(letters[i] == shuffledList.get(j))
					{
						letters[i] = list.get(j);
						break;
					}
				}
			}
			System.out.println("Decrypted message: ");
			for(char x : letters)
			{
				System.out.print(x);
			}
			System.out.println();
		 }
	 
	 private void quit() 
	 {
		System.out.println("Menu closed.");
		System.exit(0);
	 }

}
