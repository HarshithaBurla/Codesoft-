import java.util.Random;
import java.util.Scanner;
class task1
{
  public static void main(String[] args)
  {
    Random r=new Random();
    int attempts=10,wins=0;
    int ch,flag=0;
    Scanner s=new Scanner(System.in);

    while(true)
    {
       int rand_num=r.nextInt(1,101);
        System.out.println("Enter Guess:");
        int guess=s.nextInt();
       while(attempts!=0)
      {
       if(guess<rand_num)
       {
         System.out.println("Too Low..");
        
       }
       else if(guess>rand_num)
       {
         System.out.println("Too High..");
       }
       else
       {
         System.out.println("Guessed Correctly");
         wins+=1;
         flag=1;
         break;
       }
       attempts-=1;
       if(attempts!=0)
       {
       System.out.println("You have "+attempts+" attempts only");
       System.out.println("Enter Guess:");
       guess=s.nextInt();
       }
     }
       if(flag==0)
       {
         System.out.println("The correct number was "+rand_num);}
        System.out.println("You won "+wins+" times");
        System.out.println("Do You Want To Play Again(1/0):");
         ch=s.nextInt();
         if(ch==1)
         {
           attempts=10;
           flag=0;
         }
         else
         {
           break;
         }
       }
    
    System.out.println("Thanks for playing!");
  }
}