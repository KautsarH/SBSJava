public class Budget
{
    protected String name;
    protected String residency;
    
    public Budget()
    {       
        name=" ";       
        residency=" ";
    }
        
    public void setBudget(String n,String r)
    { 
        name=n;        
        residency=r;          
    }
    
     public String getName()
    {return name;}
    
    public String getResidency()
    {return residency;}
    
}


