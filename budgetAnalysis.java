
public class budgetAnalysis
{
    public static void main(String[] args)
    {
        out.println("  =====================================");
	out.println("  ||       BUGDGET ANALYSIS           || ");
	out.println("  =====================================");	
	out.println("  -->Total expenses Per Day");
	for(int j=0;j<7;j++)
	{
			if (j ==0)	days=" Monday    "; 
			if (j ==1)	days=" Tuesday   ";
			if (j ==2)	days=" Wednesday ";
			if (j ==3)	days=" Thursday  ";
			if (j ==4)	days=" Friday    ";
			if (j ==5)	days=" Saturday  ";
			if (j ==6)	days=" Sunday    ";
			
			out.println("  "+(j+1)+days+" : RM "+sumPerDay[j]);	
	
	}
//expences by category
	out.println("  -->Total expenses Per Category");
	for(int i=0;i<8;i++)
	{	
		if (i== 0)	category="  1. Food           : RM ";
		if (i ==1)	category="  2. Groceries      : RM ";
		if (i ==2)	category="  3. Transportation : RM ";
		if (i ==3)	category="  4. Social         : RM ";
		if (i ==4)	category="  5. Education      : RM ";
		if (i ==5)	category="  6. Donation       : RM ";
		if (i ==6)	category="  7. Clothing       : RM ";
		if (i ==7)	category="  8. Others         : RM ";
	
		if (i== 0)	category2="Food";
		if (i ==1)	category2="Groceries";
		if (i ==2)	category2="Transportation";
		if (i ==3)	category2="Social";
		if (i ==4)	category2="Education";
		if (i ==5)	category2="Donation";
		if (i ==6)	category2="Clothing";
		if (i ==7)	category2="Others";
	
		
		
		for(int j=0;j<7;j++)
		{
			sumPerCategory[i] += category[j][i];
			//remainBudget[i] = budgetCategory[i]-sumPerCategory[i];
		}
		//find min and max per category
			if(sumPerCategory[i]>maxCategory2)
		{
			maxCategory2=sumPerCategory[i];
			maxCategory1=category2;
			
		}	
		if(sumPerCategory[i]<minCategory2)
		{
			minCategory2=sumPerCategory[i];
			minCategory1=category2;
		}
	
	
		out.println(category+sumPerCategory[i]);
	}
	
	out.println("  MAX DAY      : "+maxDay1+", RM "+maxDay2);
	out.println("  MIN DAY      : "+minDay1+", RM "+minDay2);
	out.println("  MAX CATEGORY : "+maxCategory1+", RM "+maxCategory2);
	out.println("  MIN CATEGORY : "+minCategory1+", RM "+minCategory2);
	out.println("  AVERAGE PER DAY      : RM "+avgDay);
	out.println("  AVERAGE PER CATEGORY : RM "+avgCategory);
	out.println("  TOTAL                : RM "+sumPerWeek);
	
	out.println();
	//sorting days
	
	out.println("  -->Ranking of days of most spent :");
	double temp=0;
	String tempday;
	
	String[] days3= new String[7];
	
	days3[0]="  Monday    ";
	days3[1]="  Tuesday   ";
	days3[2]="  Wednesday ";
	days3[3]="  Thursday  ";
	days3[4]="  Friday    ";
	days3[5]="  Saturday  ";
	days3[6]="  Sunday    ";
	for(int i=0;i<7;i++)
	{
		for(int j=i+1;j<7;j++)
		{
			if(sumPerDay[j]>sumPerDay[i])
			{
				temp=sumPerDay[i];
				tempday=days3[i];
				sumPerDay[i]=sumPerDay[j];
				days3[i]=days3[j];
				sumPerDay[j]=temp;
				days3[j]=tempday;
			}
		}		
	
		out.println(days3[i]+" : RM "+sumPerDay[i]);
	}
	

	out.println();
	//sorting category
	String[] category3=new String[8];
	String tempcategory;
	out.println("  -->Ranking of category of most spent:");

	category3[0]="  Food          ";
	category3[1]="  Groceries     ";
	category3[2]="  Transportation";
	category3[3]="  Social        ";
	category3[4]="  Education     ";
	category3[5]="  Donation      ";
	category3[6]="  Clothing      ";
	category3[7]="  Others        ";

	for(int i=0;i<8;i++)
	{
		for(int j=i+1;j<8;j++)
		{
			if(sumPerCategory[j]>sumPerCategory[i])
			{
				temp=sumPerCategory[i];
				tempcategory=category3[i];
				sumPerCategory[i]=sumPerCategory[j];
				category3[i]=category3[j];
				sumPerCategory[j]=temp;
				category3[j]=tempcategory;
			}
			
		}
		out.println(category3[i]+" : RM "+sumPerCategory[i]);		
	}
	
    }
}
