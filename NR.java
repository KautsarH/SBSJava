    public class NR extends Budget
{
    protected double[][] categoryNR= new double[7][8];
    protected double[] sumPerCategory=new double[8];
    protected double[] sumPerDay=new double[7];
    protected double sumPerWeek=0;
    protected double sumCategory=0;
    protected double sumDay=0;
    protected double avgCategory=0;
    protected double avgDay=0;
    protected double maxCategory2=0;
    protected double minCategory2=9999;
    protected double maxDay2=0;
    protected double minDay2=9999;
    
   
    public NR()
    {
        super();
        
        for(int i=0;i<7;i++)        
            for(int j=0;j<8;j++)            
                categoryNR[i][j]=0;         
    }
    
    public void setNR(String n,String r,double c[][])
    {
        super.setBudget(n,r);
        for(int i=0;i<7;i++)
            for(int j=0;j<8;j++)  
                categoryNR[i][j]=c[i][j];
    }
     
    public double[] calcSumPerDayNR(double[][] c)
    {
        for (int i=0;i<7;i++)
            for (int j=0;j<8;j++)
                sumPerDay[i] += categoryNR[i][j];
        return sumPerDay;
    }
    
    public double calcSumPerWeekNR(double[] spd)
    {
        for (int i=0;i<7;i++)
            sumPerWeek +=sumPerDay[i];
        return sumPerWeek;
    }
    
    public double calcAvgDayNR(double spw)
    {
        avgDay=sumPerWeek/7;
        return avgDay;
    }
    
    public double[] calcSumPerCategoryNR(double[][] c)
    {
        for (int i=0;i<8;i++)
            for(int j=0;j<7;j++)
                sumPerCategory[i] += categoryNR[j][i];
        return sumPerCategory;
    }
    
    public double calcAvgCategoryNR(double[] spc)
    {   
        for(int j=0;j<8;j++)
                sumCategory += sumPerCategory[j];
        avgCategory=sumCategory/8;
        return avgCategory;
    }
    
    public double findMaxDayNR(double[] spd)
    {
        for(int i=0;i<7;i++)        
            if (maxDay2<sumPerDay[i])
                maxDay2=sumPerDay[i];            
        return maxDay2;
    }
    
    public double findMinDayNR(double[] spd)
    {
        for(int i=0;i<7;i++)   
            if (minDay2>sumPerDay[i])
                minDay2=sumPerDay[i];     
        return minDay2;
    }
    
     public double findMaxCategoryNR(double[] spc)
    {
        for(int i=0;i<8;i++)
            if (maxCategory2<sumPerCategory[i])
                maxCategory2=sumPerCategory[i];
  
        return maxCategory2;
    }
    
    public double findMinCategoryNR(double[] spc)
    {
        for(int i=0;i<8;i++)
            if (minCategory2>sumPerCategory[i])
                minCategory2=sumPerCategory[i];
 
        return minCategory2;
    }
  }

