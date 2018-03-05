package quotes;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import junit.framework.JUnit4TestAdapter; 
import junit.framework.TestCase; 
import junit.framework.TestSuite; 
public class QuotesTesting{
  
  
 //QuoteList -- search tests.  
  

 @Test
 public void calTest1(){
   Cal cal = new Cal();
   int days = cal.cal(12, 1, 12, 10, 2017);
   assertTrue(days == 9)
 }
 /*
 //Test for Null exception
 @Test(expected=NullPointerException.class)
 public void searchStringNullTest(){
   QuoteSaxParser saxaphone;
   QuoteList result;
   QuoteList qtlst;
   saxaphone = new QuoteSaxParser("quotes\\quotes.xml");
   qtlst = saxaphone.getQuoteList();
   
   result = qtlst.search(null, 0);
 
 }
 //Tests mode 0 when an author is found. 
 @Test
 public void mode0Test1(){
   QuoteSaxParser saxaphone;
   QuoteList result;
   QuoteList qtlst;
   saxaphone = new QuoteSaxParser("quotes\\quotes.xml");
   qtlst = saxaphone.getQuoteList();
   
   result = qtlst.search("Anonymous", 0);
   
   assertTrue(result.getSize() > 0);
 }
 //Tests mode 0 when an author is not found.
  @Test
 public void mode0Test2(){
   QuoteSaxParser saxaphone;
   QuoteList result;
   QuoteList qtlst;
   saxaphone = new QuoteSaxParser("quotes\\quotes.xml");
   qtlst = saxaphone.getQuoteList();
   
   result = qtlst.search("Leftover Dinner", 0);
   
   assertTrue(result.getSize() <= 0);
 }
  
  //Tests mode 0 when an author is found, and to see if the quote has text. 
  @Test
 public void mode0Test3(){
   QuoteSaxParser saxaphone;
   QuoteList result;
   QuoteList qtlst;
   saxaphone = new QuoteSaxParser("quotes\\quotes.xml");
   qtlst = saxaphone.getQuoteList();
   
   result = qtlst.search("Anonymous", 0);
   
   assertTrue(result.getSize() > 0 && result.getQuote(0).getQuoteText().length() > 0);
 }
  
  
  //Tests mode 1 when a quote is found.
  @Test
 public void mode1Test1(){
   QuoteSaxParser saxaphone;
   QuoteList result;
   QuoteList qtlst;
   saxaphone = new QuoteSaxParser("quotes\\quotes.xml");
   qtlst = saxaphone.getQuoteList();
   
   result = qtlst.search("Anonymous", 1);
   
   assertTrue(result.getSize() <= 0);
 }
   //Tests mode 1 when a quote is  not found.
  @Test
 public void mode1Test2(){
   QuoteSaxParser saxaphone;
   QuoteList result;
   QuoteList qtlst;
   saxaphone = new QuoteSaxParser("quotes\\quotes.xml");
   qtlst = saxaphone.getQuoteList();
   
   result = qtlst.search("Why can't I just get my degree already.", 1);
   
   assertTrue(result.getSize() > 0);
 }
  
  //Tests mode 1 when a quote is found, and if it has an author. 
  @Test
  public void mode1Test3(){
   QuoteSaxParser saxaphone;
   QuoteList result;
   QuoteList qtlst;
   saxaphone = new QuoteSaxParser("quotes\\quotes.xml");
   qtlst = saxaphone.getQuoteList();
   
   result = qtlst.search("Why can't I just get my degree already.", 1);
   
   assertTrue(result.getSize() > 0 && result.getQuote(0).getAuthor().length() > 0);
  }
  

 
  
  
  //Tests mode 2 when a quote is found.
  @Test
 public void mode2Test1(){
   QuoteSaxParser saxaphone;
   QuoteList result;
   QuoteList qtlst;
   saxaphone = new QuoteSaxParser("quotes\\quotes.xml");
   qtlst = saxaphone.getQuoteList();
   
   result = qtlst.search("Anonymous", 2);
   
   assertTrue(result.getSize() > 0);
 }
   //Tests mode 1 when a quote is  not found.
  @Test
 public void mode2Test2(){
   QuoteSaxParser saxaphone;
   QuoteList result;
   QuoteList qtlst;
   saxaphone = new QuoteSaxParser("quotes\\quotes.xml");
   qtlst = saxaphone.getQuoteList();
   
   result = qtlst.search("Why can't I just get my degree already.", 2);
   
   assertTrue(result.getSize() > 0);
 }
  
  //Tests mode 1 when a quote is found, and if it has an author. 
  @Test
  public void mode2Test3(){
   QuoteSaxParser saxaphone;
   QuoteList result;
   QuoteList qtlst;
   saxaphone = new QuoteSaxParser("quotes\\quotes.xml");
   qtlst = saxaphone.getQuoteList();
   
   result = qtlst.search("Why can't I just get my degree already.", 2);
   
   assertTrue(result.getSize() > 0 && result.getQuote(0).getAuthor().length() > 0);
  }
  
  
  
  
   //Tests mode 2 when an author is found. 
 @Test
 public void mode2Test4(){
   QuoteSaxParser saxaphone;
   QuoteList result;
   QuoteList qtlst;
   saxaphone = new QuoteSaxParser("quotes\\quotes.xml");
   qtlst = saxaphone.getQuoteList();
   
   result = qtlst.search("Anonymous", 2);
   
   assertTrue(result.getSize() > 0);
 }
 
 
 //Tests mode 2 when an author is not found.
  @Test
 public void mode2Test5(){
   QuoteSaxParser saxaphone;
   QuoteList result;
   QuoteList qtlst;
   saxaphone = new QuoteSaxParser("quotes\\quotes.xml");
   qtlst = saxaphone.getQuoteList();
   
   result = qtlst.search("Leftover Dinner", 2);
   
   assertTrue(result.getSize() <= 0);
 }
  
  //Tests mode 2 when an author is found, and to see if the quote has text. 
  @Test
 public void mode2Test6(){
   QuoteSaxParser saxaphone;
   QuoteList result;
   QuoteList qtlst;
   saxaphone = new QuoteSaxParser("quotes\\quotes.xml");
   qtlst = saxaphone.getQuoteList();
   
   result = qtlst.search("Anonymous", 2);
   
   assertTrue(result.getSize() > 0 && result.getQuote(0).getQuoteText().length() > 0);
 }
  
  */
 public static void main(String[] args) {
      Result result = JUnitCore.runClasses(QuotesTesting.class);
  
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
         System.out.println("Check Tests");
      }
      

  
      System.out.printf("Successful on %d Tests!\n Failed %d Tests...\n", result.getRunCount()-result.getFailureCount(),result.getFailureCount() );
   }
}