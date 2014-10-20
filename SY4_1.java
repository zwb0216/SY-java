
public class SY4_1 {
	public static void main(String[] args) 
	{ 
	  int arg[][]=new int[10][10]; 
     System.out.println("随机数组为："); 
     for (int i=0;i<10;i++)
     {   
    	 for (int j=0;j<10;j++)
    { 
	    arg[i][j]=(int)(Math.random()*100); 
        System.out.print(arg[i][j]+"\t"); 
    } 
	   System.out.print("\n"); 

	  } 

	  int max1[]=new int[10]; 
	  int max2[]=new int[10]; 
	  int ave1[]=new int[10]; 
	  int ave2[]=new int[10]; 
	  for (int j=0;j<10;j++)
	  {
	   int temp1=arg[0][j]; 
	   int sum1=0;
	   for (int i=0;i<10;i++)
	   { 
	      if (arg[i][j]>temp1) 
	     temp1=arg[i][j]; 
	     sum1+=arg[i][j];
	   }
	   max1[j]=temp1; 
       ave1[j]=sum1/10;
	   }
	  for (int i=0;i<10;i++)
	  {
	   int temp2=arg[i][0]; 
	   int sum2=0;
	   for (int j=0;j<10;j++)
	   { 
	      if (arg[i][j]>temp2) 
	     temp2=arg[i][j]; 
	     sum2+=arg[i][j];
	   }
	   max2[i]=temp2; 
       ave2[i]=sum2/10;
	   }
	  
  System.out.println("每列最大值分别为："); 
  for (int i=0;i<10;i++)
  { 
	   System.out.print(max1[i]+"\t");    
	  } 
	  System.out.print("\n"); 
	  System.out.println("每列平均值分别为："); 
	  for (int i=0;i<10;i++)
	  { 
	   System.out.print(ave1[i]+"\t");    
	  }
	 System.out.print("\n"); 
	System.out.println("每行最大值分别为："); 
	 for (int i=0;i<10;i++)
	 { 
		   System.out.print(max2[i]+"\t");    
		  } 
		  System.out.print("\n"); 
		  System.out.println("每行平均值分别为："); 
		  for (int i=0;i<10;i++)
		  { 
		   System.out.print(ave2[i]+"\t");    
		  } 
		  System.out.print("\n"); 
		}
	} 
