package com.randomNumber;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class randomNumber 
{

	/**
	 * Method for wait
	 * @param miliseconds
	 */
	public void wait(int miliseconds)
	{
		try 
		{
			Thread.sleep(miliseconds);
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}

	}

	/**
	 * Generate 10 Random Numbers and display them in ascending order
	 * @return 10 Random Numbers
	 */
	@Test
	public void generateRandomNumber()
	{
		File file = new File("resources/chromedriver.exe");
		String absolutePath = file.getAbsolutePath();
		
		System.out.println(absolutePath);
		 
		System.setProperty("webdriver.chrome.driver", absolutePath);

		WebDriver driver = new ChromeDriver();

		String url = "https://www.random.org/integers/";

		driver.manage().window().maximize(); //maximizes the window

		driver.navigate().to(url); //navigates to the URL

		wait(5000);

		driver.findElement(By.xpath("//p[contains(text(),'Generate')]/input")).clear(); //clears the text field for Generate

		wait(5000);

		driver.findElement(By.xpath("//p[contains(text(),'Generate')]/input")).sendKeys("10"); //inputs the value 10 in the Generate field

		wait(5000);	

		driver.findElement(By.xpath("//p[contains(text(),'Format in')]/input")).clear(); //clears Format in text field

		wait(5000);	

		driver.findElement(By.xpath("//p[contains(text(),'Format in')]/input")).sendKeys("10"); //inputs the value 10 in the Format in field

		wait(5000);	

		driver.findElement(By.xpath("//input[@value='Get Numbers']")).click(); //clicks on the Get Numbers Button

		wait(5000);

		String numbers = driver.findElement(By.xpath("//pre[@class='data']")).getText(); //Stores the number generated

		driver.quit();

		/**
		 * Code for splitting the numbers
		 */
		String[] splitedNumbers = numbers.split("\\s+");
		int[] numbersInt = new int[splitedNumbers.length];
		for (int i = 0; i < splitedNumbers.length; i++) 
		{
			numbersInt[i] = Integer.parseInt(splitedNumbers[i]);
		}
		
		printArray(selectionSort(numbersInt));

	}

	/**
	 * Code to sort the numbers
	 * @param Array of the random numbers generated
	 * @return
	 */
	public int[] selectionSort(int[] array) 
	{
		int index = 0;
		for(int i = 0; i < array.length; i++) {
			int minimum = array[i];
			
			for(int j = i; j < array.length; j++) {
				if(array[j] < minimum) {
					minimum = array[j];
					index = j;
				
				int temp = array[i];
				array[i] = array[index];
				array[index] = temp;
				}
			}
		}
		
		return array;
	}
	
	/**
	 * Code for printing the array
	 * @param Array of the random numbers generated
	 */
	public void printArray(int[] arr) {
		for(int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
	}
	
}
