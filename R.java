    public class R extends Budget
{
    protected double[][] categoryR= new double[7][6];
    protected double[] sumPerDay=new double[7];
    protected double[] sumPerCategory=new double[6];
    protected double sumCategory=0;
    protected double sumDay=0;
    protected double sumPerWeek=0;
    protected double avgDay=0;
    protected double avgCategory=0;
    protected double maxCategory2=0;
    protected double minCategory2=999;
    protected double maxDay2=0;
    protected double minDay2=9999;
    
   
    public R()
    {
        super();
        
        for(int i=0;i<7;i++)        
            for(int j=0;j<6;j++)            
                categoryR[i][j]=0;           
    }
    
    public void setR(String n,String r,double c[][])
    {
        super.setBudget(n,r);
        for(int i=0;i<7;i++)
            for(int j=0;j<6;j++)  
                categoryR[i][j]=c[i][j];                 
    }
    
    
    public double[] calcSumPerDayR(double[][] c)
    {
        for (int i=0;i<7;i++)
            for (int j=0;j<6;j++)
                sumPerDay[i] += categoryR[i][j];
                
        return sumPerDay;
    }

    public double calcSumPerWeekR(double[] spd)
    {
        for (int i=0;i<7;i++)
            sumPerWeek +=sumPerDay[i];
        return sumPerWeek;
    }
    
    public double calcAvgDayR(double spw)
    {
        avgDay=sumPerWeek/7;
        return avgDay;
    }
    
    public double[] calcSumPerCategoryR(double[][] c)
    {
        for (int i=0;i<6;i++)
            for(int j=0;j<7;j++)
                sumPerCategory[i] += categoryR[j][i];
        return sumPerCategory;
    }
    
    public double calcAvgCategoryR(double[] spc)
    {
        for(int i=0;i<6;i++)
            sumCategory+= sumPerCategory[i];
        avgCategory=sumCategory/6;
        return avgCategory;
    }
    
    public double findMaxDayR(double[] spd)
    {
        for(int i=0;i<7;i++)        
            if (maxDay2<sumPerDay[i])
                maxDay2=sumPerDay[i];            
        return maxDay2;
    }
    
    public double findMinDayR(double[] spd)
    {
        for(int i=0;i<7;i++)
            if (minDay2>sumPerDay[i])
                minDay2=sumPerDay[i];
        return minDay2;
    }
    
     public double findMaxCategoryR(double[] spc)
    {
        for(int i=0;i<6;i++)
            if (maxCategory2<sumPerCategory[i])
                maxCategory2=sumPerCategory[i];
        return maxCategory2;
    }
    
    public double findMinCategoryR(double[] spc)
    {
        for(int i=0;i<6;i++)
            if (minCategory2>sumPerCategory[i])
                minCategory2=sumPerCategory[i];        
        return minCategory2;
    }
  }

