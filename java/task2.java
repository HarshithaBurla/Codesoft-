import java.util.Scanner;
class task2
{
   public static void main(String[] args)
   {
      Scanner s=new Scanner(System.in);
       System.out.println("Enter How many Subjects?");
      int n=s.nextInt(),total=0;
      float averagePer;
      String grade;
      int[] marks=new int[n];
       System.out.println("Enter marks for "+n+" Subjects");
      for(int i=0;i<n;i++)
      {
         System.out.println("Enter marks for "+(i+1)+" subject(out of 100)");
         marks[i]=s.nextInt();
      }
      for(int i=0;i<n;i++)
      {
        total+=marks[i];
      }
      averagePer=total/(float)n;
      if(averagePer>=90 && averagePer<=100)
      {
         grade="A+";
      }
      else if(averagePer>=80 && averagePer<90)
      {
         grade="A";
      }
      else if(averagePer>=70 && averagePer<80)
      {
         grade="B";
      }
      else if(averagePer>=60 && averagePer<70)
      {
         grade="C";
      }
      else if(averagePer>=50 && averagePer<60)
      {
         grade="D";
      }
      else if(averagePer>=40 && averagePer<50)
      {
         grade="E";
      }
      else
      {
         grade="Fail";
      }
      System.out.printf("Total Marks: %d\nAverage Percentage: %.2f\nGrade: %s", total, averagePer, grade);
    
}
}

