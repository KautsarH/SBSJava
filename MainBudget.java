import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;
import java.text.*;


public class MainBudget
{
   public static void main(String args[]) throws Exception
   {
     
     Scanner in=new Scanner(System.in);
     BufferedReader br=new BufferedReader(new FileReader("Budget.txt"));
     PrintWriter pw= new PrintWriter (new BufferedWriter(new FileWriter("R.txt")));
     PrintWriter pw2= new PrintWriter (new BufferedWriter(new FileWriter("NR.txt")));
     
     String name;
     double[][] category= new double[7][8];//days and category
     double[] sumPerCategory=new double[8];
     double[] sumPerDay =new double[7];
     double sumPerWeekR=0,sumBudgetR=0,maxDay2R=0,minDay2R=99999,avgDayR=0,avgCategoryR=0,maxCategory2R=0,minCategory2R=9999;
     double sumPerWeekNR=0,sumBudgetNR=0,maxDay2NR=0,minDay2NR=9999,avgDayNR=0,avgCategoryNR=0,maxCategory2NR=0,minCategory2NR=9999;
     double [] sumPerDayR= new double[7];
     double []sumPerCategoryR=new double[6];
     double []sumPerDayNR=new double[7];
     double []sumPerCategoryNR=new double[8];
     String residency=" ",data=null,days=" ";//HARI
     DecimalFormat d=new DecimalFormat("00.00");
          
     Budget[] x=new Budget[2];
     R r=new R();
     NR nr= new NR();
     // Budget x=new Budget();
     
        while((data=br.readLine()) != null)
        {
            in =new Scanner(System.in);
            StringTokenizer st=new StringTokenizer(data,";");
            
            name=st.nextToken();
            residency=st.nextToken();
            
            x[0]= new R();
            x[1]=new NR();            
            
            for(int i=0;i<7;i++)
            {
                if (residency.equalsIgnoreCase("NR"))
                {
                    for(int j=0;j<8;j++)
                        category[i][j]=Double.parseDouble(st.nextToken());
                   
                    nr.setNR(name,residency,category);             
                    
                }
                
                else if (residency.equalsIgnoreCase("R"))
                {
                    for(int j=0;j<6;j++)
                        category[i][j]=Double.parseDouble(st.nextToken());
    
                    
                    r.setR(name,residency,category);
                    
                }
            }  
            
        }       
     
        for (int i=0;i<2;i++)
        {
            if (x[i] instanceof R)
            {
                sumPerDayR= r.calcSumPerDayR(category);
                sumPerWeekR = r.calcSumPerWeekR(sumPerDayR);
                avgDayR=r.calcAvgDayR(sumPerWeekR);
                sumPerCategoryR=r.calcSumPerCategoryR(category);
                avgCategoryR=r.calcAvgCategoryR(sumPerCategoryR);
                maxDay2R=r.findMaxDayR(sumPerDayR);                
                minDay2R=r.findMinDayR(sumPerDayR);
                maxCategory2R=r.findMaxCategoryR(sumPerCategoryR);                
                minCategory2R=r.findMinCategoryR(sumPerCategoryR);
                
            }
            else if (x[i] instanceof NR)
            {
                sumPerDayNR= nr.calcSumPerDayNR(category);
                sumPerWeekNR = nr.calcSumPerWeekNR(sumPerDayNR);               
                avgDayNR=nr.calcAvgDayNR(sumPerWeekNR);
                sumPerCategoryNR=nr.calcSumPerCategoryNR(category);
                avgCategoryNR=nr.calcAvgCategoryNR(sumPerCategoryNR);
                maxDay2NR=nr.findMaxDayNR(sumPerDayNR);
                minDay2NR=nr.findMinDayNR(sumPerDayNR);
                maxCategory2NR=nr.findMaxCategoryNR(sumPerCategoryNR);
                minCategory2NR=nr.findMinCategoryNR(sumPerCategoryNR);
            }
            
        }
        
        System.out.println("\t\t\t\t\t _____________________  ");
        System.out.println("\t\t\t\t\t|  _________________  |");
        System.out.println("\t\t\t\t\t| | STUDENT BUDGET  | |");
        System.out.println("\t\t\t\t\t| |_____SYSTEM______| |");
        System.out.println("\t\t\t\t\t|  ___ ___ ___   ___  |");
        System.out.println("\t\t\t\t\t| | 7 | 8 | 9 | | + | |");
        System.out.println("\t\t\t\t\t| |___|___|___| |___| |");
        System.out.println("\t\t\t\t\t| | 4 | 5 | 6 | | - | |");
        System.out.println("\t\t\t\t\t| |___|___|___| |___| |");
        System.out.println("\t\t\t\t\t| | 1 | 2 | 3 | | x | |");
        System.out.println("\t\t\t\t\t| |___|___|___| |___| |");
        System.out.println("\t\t\t\t\t| | . | 0 | = | | / | |");
        System.out.println("\t\t\t\t\t| |___|___|___| |___| |");
        System.out.println("\t\t\t\t\t|_____________________|");
        
        System.out.println("\t\t\t                          MADE BY:                             ");
        System.out.println("\t\t\t            KAUTSAR HASANAH BINTI MUHAMMAD KHAIRI             ");
        System.out.println("\t\t\t                NOR SYAHFIKA NADIA BINTI SAPAR                ");
        
        System.out.println();
      
        System.out.print("\n\n\n\t\t\t\t\t...LOADING INFORMATION...\n");
        char a=186, b=177;
        System.out.print("\t\t\t\t\t");
        
        
        for (int i=0;i<25;i++)
        {
            System.out.print(b);
            for (int j=0;j<=1e8;j++); //You can also use sleep function instead of for loop
        }
        System.out.println();
        System.out.println("\t\t\t\t\t\t DATA SAVED");
        
        JOptionPane.showMessageDialog(null,"Continue...");
        
        
        
        
        pw.println("  =================================================");
        pw.println(" ||         BUGDGET ANALYSIS FOR RESIDENT        ||");
        pw.println("  =================================================");
        pw.println();
        pw.println("  Name          : "+r.getName());
        pw.println("  Resident Type : "+r.getResidency());
        pw.println();
        pw.println("  -->Total expenses Per Day"+"\n"); 
        
        
        
        pw2.println("  =================================================");
        pw2.println(" ||      BUGDGET ANALYSIS FOR NON-RESIDENT       ||");
        pw2.println("  =================================================");
        pw2.println();
        pw2.println("  Name          : "+nr.getName()); 
        pw2.println("  Resident Type : "+nr.getResidency());
        pw2.println();
        pw2.println("  -->Total expenses Per Day"+"\n"); 
          
        for(int j=0;j<7;j++)
        {
            if (j ==0)  days=" Monday    "; 
            if (j ==1)  days=" Tuesday   ";
            if (j ==2)  days=" Wednesday ";
            if (j ==3)  days=" Thursday  ";
            if (j ==4)  days=" Friday    ";
            if (j ==5)  days=" Saturday  ";
            if (j ==6)  days=" Sunday    ";
            
            
            pw.println("  "+days+" : RM "+sumPerDayR[j]);
            pw2.println("  "+days+" : RM "+sumPerDayNR[j]);
    
        }
        pw.println();
        pw2.println();
        pw.println("  -->Total expenses Per Category"+"\n");
        pw2.println("  -->Total expenses Per Category"+"\n");
        int l=0;
        String category1=" ",category2=" ";
          
        
            for (int i=0;i<2;i++)
            {
                if (x[i] instanceof NR)
                {
                    for(l=0;l<8;l++)
                    {
                       
                        if (l ==0)  category1="  1. Food           : RM ";
                        if (l ==1)  category1="  2. Groceries      : RM ";
                        if (l ==2)  category1="  3. Transportation : RM ";
                        if (l ==3)  category1="  4. Social         : RM ";
                        if (l ==4)  category1="  5. Education      : RM ";
                        if (l ==5)  category1="  6. Donation       : RM ";
                        if (l ==6)  category1="  7. Clothing       : RM ";
                        if (l ==7)  category1="  8. Others         : RM ";
                    
                        if (l == 0) category2="Food";
                        if (l ==1)  category2="Groceries";
                        if (l ==2)  category2="Transportation";
                        if (l ==3)  category2="Social";
                        if (l ==4)  category2="Education";
                        if (l ==5)  category2="Donation";
                        if (l ==6)  category2="Clothing";
                        if (l ==7)  category2="Others";
                        
                        pw2.println(category1+sumPerCategoryNR[l]);
                                           
                    }
                    pw.println();
                    pw.println();
                    pw2.println("  -->Analysis"+"\n");
                    
                    pw2.println("  MAX DAY SPENT :  RM "+maxDay2NR);
                    pw2.println("  MIN DAY SPENT :  RM "+minDay2NR);
                    pw2.println("  MAX CATEGORY  :  RM "+maxCategory2NR);
                    pw2.println("  MIN CATEGORY  :  RM "+minCategory2NR);
                    pw2.println("  AVERAGE PER DAY      : RM "+d.format(avgDayNR));
                    pw2.println("  AVERAGE PER CATEGORY : RM "+d.format(avgCategoryNR));
                    pw2.println("  TOTAL                : RM "+sumPerWeekNR); 
                }
                else if(x[i] instanceof R)
                {   
                    for(l=0;l<6;l++)
                    {
                        
                            
                        if (l ==0)  category1="  1. Food           : RM ";
                        if (l ==1)  category1="  2. Groceries      : RM ";
                        if (l ==2)  category1="  3. Transportation : RM ";
                        if (l ==3)  category1="  4. Social         : RM ";
                        if (l ==4)  category1="  5. Education      : RM ";
                        if (l ==5)  category1="  6. Donation       : RM ";
                        if (l ==6)  category1="  7. Clothing       : RM ";
                        if (l ==7)  category1="  8. Others         : RM ";
                    
                        if (l== 0)  category2="Food";
                        if (l ==1)  category2="Groceries";
                        if (l ==2)  category2="Transportation";
                        if (l ==3)  category2="Social";
                        if (l ==4)  category2="Education";
                        if (l ==5)  category2="Donation";
                        if (l ==6)  category2="Clothing";
                        if (l ==7)  category2="Others";
                        
                        pw.println(category1+sumPerCategoryR[l]);
                    }
                    pw.println();
                    pw.println("  -->Analysis"+"\n");   
                    
                    pw.println("  MAX DAY       :  RM "+maxDay2R);
                    pw.println("  MIN DAY       :  RM "+minDay2R);
                    pw.println("  MAX CATEGORY  :  RM "+maxCategory2R);
                    pw.println("  MIN CATEGORY  :  RM "+minCategory2R);
                    pw.println("  AVERAGE PER DAY      : RM "+d.format(avgDayR));
                    pw.println("  AVERAGE PER CATEGORY : RM "+d.format(avgCategoryR));
                    pw.println("  TOTAL                : RM "+sumPerWeekR);
                }
           }
           
       
        
        br.close();
        pw.close();
        pw2.close();
        }
}    

