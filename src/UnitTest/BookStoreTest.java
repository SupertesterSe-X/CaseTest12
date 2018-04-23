import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import BookStore.BookStore;
import BookStore.ShoppingCart;


public class BookStoreTest {
	
	private static ShoppingCart [] shoppingCartArr;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testGetDiscount() throws IOException{
		
			 
			 File file = new File("C:\\Users\\Komgrit\\workspace\\CaseStudy12\\test\\testBookStore(getDiscount).txt");
			     Scanner input = new Scanner(file); 
			  int countLine = 0;
			   
			 		try {
			 			BufferedReader br = new BufferedReader(new FileReader(file));
			 			String line;
			 			while ((line = br.readLine()) != null) {
			 		countLine++;
			                           //  System.out.println(line);
			 			}
			 			br.close();
			 		} catch (IOException e) {
			 			// TODO Auto-generated catch block
			 			e.printStackTrace();
			 		}
			     
			          // System.out.println("-----------------------------------");
			                   //  System.out.println(countLine);
			                    // System.out.println("-----------------------------------");
			     int count =0 ;
			     
			     String testWord[] = new String[countLine*4];
			     while(input.hasNext()){
			 testWord[count] = input.next();
			    // System.out.println(input.next());   
			      count++;
			     }

			     int resultWord = count;
			     //System.out.println(resultWord);
			                  //   System.out.println("-----------------------------------");  
			   
			 for(int i =0 ; i< resultWord ; i++ ){
			 //System.out.println(testWord[i]);
			 }
			 String testWord2d[][] = new String [countLine][4];
			 int num = 0 ;
			 for(int i = 0 ;i < countLine ; i++){
			 for(int j = 0 ;j < 4 ; j++){
			 testWord2d[i][j] = testWord[num];
			 num++;
			 }
			 }
		 
		
		for(int i =0;i<countLine;i++){
			double totalOrderPrice = Double.parseDouble(testWord2d[i][0]);
			int  cusType=Integer.parseInt(testWord2d[i][1]); 
			int coupon=Integer.parseInt(testWord2d[i][2]);
			int discountExpected = Integer.parseInt(testWord2d[i][3]);
			//System.out.println(totalOrderPrice);
			
			int discountActual = BookStore.getDiscount(totalOrderPrice, cusType, coupon);
			//System.out.println(discountActual);
			assertEquals("Error: Method getDiscount()",discountExpected, discountActual);
		}
	
		
	}
	
	
	
	@Test
	public void testDiscountBalance() throws FileNotFoundException {

		File file = new File("C:\\Users\\Komgrit\\workspace\\CaseStudy12\\test\\testBookStore(getBalance).txt");
	     Scanner input = new Scanner(file); 
	  int countLine = 0;
	   
	 		try {
	 			BufferedReader br = new BufferedReader(new FileReader(file));
	 			String line;
	 			while ((line = br.readLine()) != null) {
	 		countLine++;
	                           //  System.out.println(line);
	 			}
	 			br.close();
	 		} catch (IOException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	     
	          // System.out.println("-----------------------------------");
	                   //  System.out.println(countLine);
	                    // System.out.println("-----------------------------------");
	     int count =0 ;
	     
	     String testWord[] = new String[countLine*4];
	     while(input.hasNext()){
	 testWord[count] = input.next();
	    // System.out.println(input.next());   
	      count++;
	     }

	     int resultWord = count;
	     //System.out.println(resultWord);
	                  //   System.out.println("-----------------------------------");  
	   
	 for(int i =0 ; i< resultWord ; i++ ){
	 //System.out.println(testWord[i]);
	 }
	 String testWord2d[][] = new String [countLine][4];
	 int num = 0 ;
	 for(int i = 0 ;i < countLine ; i++){
	 for(int j = 0 ;j < 3 ; j++){
	 testWord2d[i][j] = testWord[num];
	 num++;
	 }
	 }
		
		
		for(int i = 0 ; i<countLine ; i++){
			
		
		double totalOrderPrice = Double.parseDouble(testWord2d[i][0]);

		int  discount=Integer.parseInt(testWord2d[i][1]); 
	
		double netBalExpected = Double.parseDouble(testWord2d[i][2]);
		
		//double netBalActual = BookStore.getDiscountBalance(totalOrderPrice, discount);
		
		double netBalActual;
		
		netBalActual = totalOrderPrice - (totalOrderPrice * discount / 100);
		
		
		assertEquals("Error: Method getDiscountBalance",netBalExpected, netBalActual,0.0);
		}
		}
	
	
	@Test
	public void testPurchase() throws FileNotFoundException {
		
		File file = new File("C:\\Users\\Komgrit\\workspace\\CaseStudy12\\test\\testBookStore(getPurchase).txt");
	     Scanner input = new Scanner(file); 
	  int countLine = 0;
	   
	 		try {
	 			BufferedReader br = new BufferedReader(new FileReader(file));
	 			String line;
	 			while ((line = br.readLine()) != null) {
	 		countLine++;
	                           //  System.out.println(line);
	 			}
	 			br.close();
	 		} catch (IOException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	     
	          // System.out.println("-----------------------------------");
	                   //  System.out.println(countLine);
	                    // System.out.println("-----------------------------------");
	     int count =0 ;
	     
	     String testWord[] = new String[countLine*4];
	     while(input.hasNext()){
	 testWord[count] = input.next();
	    // System.out.println(input.next());   
	      count++;
	     }

	     int resultWord = count;
	     //System.out.println(resultWord);
	                  //   System.out.println("-----------------------------------");  
	   
	 for(int i =0 ; i< resultWord ; i++ ){
	 //System.out.println(testWord[i]);
	 }
	 String testWord2d[][] = new String [countLine][4];
	 int num = 0 ;
	 for(int i = 0 ;i < countLine ; i++){
	 for(int j = 0 ;j < 4 ; j++){
	 testWord2d[i][j] = testWord[num];
	 num++;
	 }
	 }
		for(int i = 0 ; i<countLine ; i++){
		
			int balance = Integer.parseInt(testWord2d[i][0]);
			double paid = Double.parseDouble(testWord2d[i][1]);
			int discount= Integer.parseInt(testWord2d[i][2]);
			double purchaseExpected = Double.parseDouble(testWord2d[i][3]);
			
			double purchaseActual =  balance - (balance * discount / 100);
			
			
			
			
			
			assertEquals("Error: Method getDiscountBalance",purchaseExpected, purchaseActual,0.0);
		}
		
	
		
		
	}
}
