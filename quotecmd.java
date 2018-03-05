package quotes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.Collections;
/**
 * @author Jeff Offutt & Mongkoldech Rajapakdee
 *         Date: Nov, 2009
 * Edited by Nicholas Rivera 2/5/2018
 *
 * Wiring the pieces together:
 *    quotecmd.java -- The front end of the program in which the quotes program executes. 
 *    QuoteList.java -- A list of quotes, representing what's read from the XML file
 *                      Used by quoteserve.java
 *    Quote.java -- A simple Quote bean; two entries, author and quote-text
 *                      Used by QuoteList.java
 *    QuoteSaxHandler.java -- Callback methods for the parser, populates QuoteList
 *                      Used by QuoteSaxParser
 *    QuoteSaxParser.java -- Parses the XML file
 *                      Used by quoteserve.javarrr
 *    quotes.js -- JS used by the HTML created in quoteserve
 *    quotes.xml -- Data file, read by QuoteSaxParser
 */
public class quotecmd
{
  //Xml file to be parsed later by QuoteSaxParser.  
   private static final String quoteFileName = "quotes\\quotes.xml";
   // Stores all the quotes from the xml file
   private static QuoteList quoteList;
   private static QuoteSaxParser saxaphone;
   private static QuoteWriter clarinet;
   //Main program
   public static void main(String[] args) throws IOException, IndexOutOfBoundsException{
     BufferedReader in = new BufferedReader(new FileReader("quotes\\output.txt"));
     //Input
     Scanner sc = new Scanner(System.in);
     //Sets Parser, and gets quoteList from the parsed xml file. 
     clarinet = new QuoteWriter();
     saxaphone = new QuoteSaxParser(quoteFileName);
     quoteList = saxaphone.getQuoteList();
     //We use these next two variables to retrieve user input, and put it into a switch statement. 
     String choice;
     char actualChoice;
     String scope = "Both";
     boolean end = true;
     //To show recent searches.
     ArrayList<String> UserSearches = new ArrayList<String>();
     ArrayList<String> CommunitySearches = new ArrayList<String>();
     String input = input = in.readLine();
     while(input != null){

       if(CommunitySearches.size() >=5){
           CommunitySearches.remove(0);
         }
       CommunitySearches.add(input);
       input = in.readLine();
     }
     if(!CommunitySearches.isEmpty())
            Collections.reverse(CommunitySearches);
     //Random quote. 
     Quote randomQuote = quoteList.getRandomQuote();
     //Keeps program running. 
     while(end){
       menu(UserSearches, CommunitySearches, randomQuote, scope);
       choice = sc.nextLine();
       actualChoice = choice.charAt(0);
       switch(actualChoice){
         /*This is the option to add quotes. What we need to do is this. We need to create a new class or modify a class
          * to write to an xml file. We have our reader class. QuoteSaxHandler. We just need to mimic that one and reverse engineer it. 
          */
         case 'n':
           boolean test = true;
           boolean test2 = true;
           String author;
           String quoteTxt;
           String keyword;
           
           //Searches for author.
           System.out.println("Author: ");
           author = sc.nextLine();
           while(test){
             if(isString(author) == false){
               System.out.println("Sorry please try again or Press '1' for exit.");
               author = sc.nextLine();
               if(author.charAt(0) == '1'){
                 test2 = false;
                        break;
               }
               
             }
             
             else
               test = false;
             
           }
           if(test == false)
             test = true;
           if(test2 == false)
             break;
           
           //Searches for Quote Text 
           System.out.println("Quote Text: ");
           quoteTxt = sc.nextLine();
           System.out.println(quoteTxt);
           while(test){
             if(isString(quoteTxt) == false){
               System.out.println("Sorry please try again or Press '1' for exit.");
               quoteTxt = sc.nextLine();
                      if(quoteTxt.charAt(0) == '1'){
                        test2 = false;
                        break;
                      }
             }
             else
               test = false;
           } 
           if(test == false)
             test = true;
           if(test2 == false)
             break;
           //Searches for Keyword. 
           System.out.println("Keyword: ");
           keyword = sc.nextLine();
           while(test){
             if(isString(keyword) == false){
               System.out.println("Sorry please try again or Press '1' for exit.");
               keyword = sc.nextLine();
               if(keyword.charAt(0) == '1'){
                 test2 = false;
                 break;
               }
             }
             else
               test = false;
           }
             
         if(test2 == true){
           clarinet.write(quoteFileName, author, quoteTxt, keyword);
           saxaphone = new QuoteSaxParser(quoteFileName);
           quoteList = saxaphone.getQuoteList();
         }
         break;
         //Search option
         case 's':
           QuoteList retVal;
           choice = sc.nextLine();
         if(scope == "Author"){
           retVal = quoteList.search(choice, 0);
         }
         else if(scope == "Quote"){
           retVal = quoteList.search(choice, 1);
         }
         else{
           retVal = quoteList.search(choice, 2);
         }
         for(int i = 0; i < retVal.getSize();i++ ){
           System.out.printf("%d. %s\n -%s\n", i, retVal.getQuote(i).getQuoteText(), retVal.getQuote(i).getAuthor());
         }
         if(UserSearches.size() >=5){
           UserSearches.remove(0);
         }
         if(CommunitySearches.size() >=5){
           CommunitySearches.remove(0);
         }
         UserSearches.add(choice);
         CommunitySearches.add(choice);  
         break;
//Quote enabling option
         case 'q':
           scope = "Quote";
           break;
           //Author enabling option
         case 'a':     
           scope = "Author";
           break;
           //Both enabling option
         case 'b':
           scope = "Both";
           break;
           //Get Random Quote
         case 'k':
           scope = "Keyword";
           break;
         case 'r':
           randomQuote = quoteList.getRandomQuote();
         break;
         case 'e':
           PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
           for(int i = CommunitySearches.size()-1; i >= 0; i--){
             if(out != null)
               out.println(CommunitySearches.get(i));
           }
           end = false;
           out.close();
           break;
           //Random Quote option  
       }
     }
     
     sc.close();
   }
   
     public static boolean isString(String str){
       for(int i = 0; i < str.length(); i++){
         if(Character.isDigit(str.charAt(i)) == true || !Character.isLetter(str.charAt(i)))
           return false;
         
       }
       return true;
     }
     
     //Prints out menu. 
     public static void menu(ArrayList<String> UserSearches, ArrayList<String> CommunitySearches, Quote randomQuote, String scope){
       System.out.printf("Random quote of the day: %s\n -%s\n\n", randomQuote.getQuoteText(), randomQuote.getAuthor());
       System.out.printf("Scope: %s\n\n", scope);
       System.out.println("User Searches\n");
       int j = 1;
       //
       for(int i = UserSearches.size()-1; i >= 0; i--){
         System.out.printf("%d. %s\n", j++,  UserSearches.get(i));
       }
       System.out.println("Community Searches\n");
       j = 1;
       for(int i = CommunitySearches.size()-1; i >= 0; i--){
         System.out.printf("%d. %s\n", j++,  CommunitySearches.get(i));
       }
       System.out.print("To focus search on the quote text press q\t");
       System.out.print("\tTo focus search on both the quote text and author name press b\n");
       System.out.print("To focus search on author name press a\t\t");
       System.out.print("To focus search on keyword press k\t\t");
       System.out.print("To search press s\n");
       System.out.print("To end program press e\t\t\t");
       System.out.print("To change random quote press r\n");
       System.out.println("To add new quote press n\n");
       
     }
     
} // end quoteserve class
