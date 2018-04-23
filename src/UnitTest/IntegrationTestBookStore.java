import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

import BookStore.BookStore;


public class IntegrationTestBookStore {

	@Test
	public void test() throws FileNotFoundException {
		
		 File file = new File("C:\\Users\\Komgrit\\workspace\\CaseStudy12\\test\\IntegrationTest.txt");
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
	     
	     String testWord[] = new String[countLine*5];
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
	 String testWord2d[][] = new String [countLine][5];
	 int num = 0 ;
	 for(int i = 0 ;i < countLine ; i++){
	 for(int j = 0 ;j < 5 ; j++){
	 testWord2d[i][j] = testWord[num];
	 num++;
	 }
	 }
 

for(int i =0;i<countLine;i++){
	//get discount
	double totalOrderPrice = Double.parseDouble(testWord2d[i][0]);
	int  cusType=Integer.parseInt(testWord2d[i][1]); 
	int coupon=Integer.parseInt(testWord2d[i][2]);
	int discountExpected = Integer.parseInt(testWord2d[i][3]);
	int discountActual = BookStore.getDiscount(totalOrderPrice, cusType, coupon );
	assertEquals("Error: Method getDiscount()",discountExpected, discountActual);
	
	//getNetBalance
	double netBalExpected = Double.parseDouble(testWord2d[i][4]);
	double netBalActual = totalOrderPrice - (totalOrderPrice * discountActual / 100); 
	
	assertEquals("Error: Method getDiscountBalance",netBalExpected, netBalActual,0.0);
}
	}

}
