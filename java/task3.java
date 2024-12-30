import java.util.Scanner;
class atm
{
   userAcc acc;
   atm(userAcc acc)
   {
     this.acc=acc;
   }
   int withdraw(int amount)
   {
      if(amount<=0 || amount<100)
      {
        System.out.println("Invalid amount. Please enter a positive value.");
         return 0;
      }
      if(acc.balance>=amount)
      {
      acc.balance-=amount;
      return amount;
      }
      else
      {
        System.out.println("Insufficient balance. Your current balance is " + acc.balance);
         return 0;
      }
   }
   void deposit(int amount)
   {
       if (amount <= 0) {
         System.out.println("Invalid amount. Please enter a positive value.");
         return;
      }
      acc.balance+=amount;
      System.out.println("Deposited Succesfully");
   }  
}
class userAcc
{
  int balance=0;
  int balanceEnquiry()
  {
     return balance;
  }
}
class task3
{
  public static void main(String[] args)
  {
      Scanner s=new Scanner(System.in);
      int amt,res;
      userAcc obj=new userAcc();
      atm a=new atm(obj);
      while(true)
      {
      System.out.println("1.Withdraw\n2.Deposit\n3.Balance enquiry\n");
      int ch=s.nextInt();
      if(ch==1)
      {
        System.out.println("Enter amount to withdraw(end with zeros:");
        amt=s.nextInt();
        res=a.withdraw(amt);
        if(res!=0){
        System.out.println("Collect the cash "+amt );}
      }
      else if(ch==2)
      {
        System.out.println("Enter amount to deposit(end with zeros):");
        amt=s.nextInt();
        a.deposit(amt);
      }
      else if(ch==3)
      {
         System.out.println("Your current balance is: "+obj.balanceEnquiry());
      }
     else {
            System.out.println("Invalid choice. Please select again.");
         }
      System.out.println("Do you want to perform another transaction? (yes/no)");
      String c=s.next();
      if(c.equalsIgnoreCase("no"))
       {
        break;
       }
    }
  }
}
      

      