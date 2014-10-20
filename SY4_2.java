
public class SY4_2 {
	public static void main(String[] args) 
	{ 
		  int row=10; 
		  int num[][]=new int[row][row]; 
		  for(int i=0;i<row;i++)
		  { 
		   for(int j=0;j<=i;j++)
		   { 
		    if(j==0||j==i)
		    { 
		     num[i][j]=1; 
		     System.out.print(num[i][j]+"\t"); 
		    } 
		    else if(i>1){ 
		 num[i][j]=num[i-1][j]+num[i-1][j-1]; 
		     System.out.print(num[i][j]+"\t"); 
		    } 
		   } 
		   System.out.println(""); 
		  } 
		 } 
}
