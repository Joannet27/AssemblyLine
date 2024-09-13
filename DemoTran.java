import java.util.ArrayList;
import java.util.Scanner;
/*
   write a while loop that will ask user for the assembly line name and the manufaute widgt infotmation
   and keep looping until user choose to stop 
   
   after each infomation enter for that asseblyline add it in to the AsseblyLine object and append these data tyo stor untill the loop ends
   
   *user wish to stop*
      > print 'quality' of each assembly line in percentage with 2 decimal places 
      > print the efficiency rating base on the average assembly line quality 
         * excellent qaulity > 95.00
         * good: 90.00 < quality < 95.00
         *uneacceptable qulaity < 90.00
*/
public class DemoTran
{
   public static void main(String[]arg)
   {
      final double HIGH_AVERAGE = 95.00;
      final double LOW_AVERAGE = 90.00;
   
      String asseblyName = "";
      int total = 0;
      int reject = 0;
      String choice= "", rating = "";
      double qualitySum = 0.0, averageQuality = 0.0;
      
      Scanner keyboard = new Scanner(System.in);
      ArrayList<AssemblyLine> assemblyList = new ArrayList<AssemblyLine>();
   
   
   // while loop that runs untill user wish to stop 
      while (!choice.equalsIgnoreCase("N"))
      {
      // ask for user input 
         System.out.print("Enter the name of the assembly line: ");
         asseblyName = keyboard.nextLine();
      
         System.out.print("Enter the total number of widgets manufactured: ");
         total = keyboard.nextInt();
         while(total < 1)
         {
            System.out.println("Please enter value greater than 1");
            System.out.print("Enter the total number of widgets manufactured: ");
            total = keyboard.nextInt();
         }
         //keyboard.nextLine();
         System.out.print("Enter the number of rejected widgets manufactured: ");
         reject = keyboard.nextInt();
         while(reject < 0 || reject >= total)
         {
            System.out.println("Rejected widget should not be less than 0 and greater than or equal to total widget");
            System.out.print("Enter the number of rejected widgets manufactured: ");
            reject = keyboard.nextInt();
         }
         keyboard.nextLine();//buffer to clear the line
         System.out.print("Do you wish to enter infomation for another assembly line (Y/N)?");
         choice = keyboard.nextLine();
         
         //append inputed information into an array
         assemblyList.add(new AssemblyLine(asseblyName, total, reject));
         
      }
                  //output
                  
      // for loop to print out the assembly line infomation
      System.out.println("Quality Report: ");
      
      for(AssemblyLine assembly : assemblyList)
      {
         System.out.println("Assembly Line: " + assembly.getAssemblyName());
         //assembly.calcAcceptable();
         System.out.printf("Quality (as a percentage): %.2f \n", assembly.calcQuality());
         qualitySum += assembly.calcQuality();
         averageQuality = qualitySum/ assemblyList.size();
         
         // calculat the quality average then determine its rating
         if(averageQuality > HIGH_AVERAGE)
         {
            rating = "Excellent";
         }
         if (LOW_AVERAGE < averageQuality && averageQuality < HIGH_AVERAGE)
         {
            rating = "Good";
         }
         if(LOW_AVERAGE > averageQuality)
         {
            rating = "Uneacceptable";
         }
      }
      System.out.println();
      System.out.println("The efficiency of the factory is: " + rating);
   
   }//main body
}//class