import java.util.Scanner;
class task4
{
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter base:(usd,eur,inr)");
        String ch1=s.next();
        System.out.println("Enter amount:");
        double amt=s.nextDouble();
        System.out.println("Enter target:(usd,eur,inr)");
        String ch2=s.next();
        if(ch1.equals(ch2))
        {
            System.out.println("Both currencies are same");
        }
        else if(ch1.equals("usd") && ch2.equals("eur")){
            amt=amt*0.93;
           
        }
        else if(ch1.equals("usd") && ch2.equals("inr"))
        {
            amt=amt*82.00;
           
        }
        else if(ch1.equals("eur") && ch2.equals("usd"))
        {
            amt=amt*1.08;
        }
        else if(ch1.equals("inr") && ch2.equals("usd"))
        {
            amt=amt*0.012;
        }
        else if(ch1.equals("eur") && ch2.equals("inr"))
        {
            amt=amt*88.00;
        }
        else if( ch1.equals("inr")&& ch2.equals("eur"))
        {
            amt=amt*0.011;
        }
        else
        {
            System.out.println("Invalid base or tgarget currency");
            return;
        }
        System.out.println("amount is "+amt+ch2.toUpperCase());
    }
}
