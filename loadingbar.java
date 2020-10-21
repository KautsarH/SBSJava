public class loadingbar
{
    public static void main(String args[])
    {
        System.out.print("\n\n\n\t\t\t...LOADING INFORMATION...\n");
        char a=186, b=177;
        System.out.print("\t\t\t");
        
        
        for (int i=0;i<25;i++)
        {
            System.out.print(b);
            for (int j=0;j<=1e8;j++); //You can also use sleep function instead of for loop
        }
        System.out.println();
        System.out.println("\t\t\t\t DATA SAVED");
    }
}
