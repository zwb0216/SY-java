
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

	  int max[]=new int[10]; 
	  int ave[]=new int[10]; 
	  for (int i=0;i<10;i++)
	  { 
	   int temp=arg[i][0]; 
	   int sum=0; 
	   for (int j=0;j<10;j++)
	   { 
	    if (arg[i][j]>temp) 
	     temp=arg[i][j]; 
	     sum+=arg[i][j];     
	   }    
	   max[i]=temp; 
       ave[i]=sum/10; 
       } 
  System.out.println("每行最大值分别为："); 
  for (int i=0;i<10;i++)
  { 
	   System.out.print(max[i]+"\t");    
	  } 
	  System.out.print("\n"); 
	  System.out.println("每行平均值分别为："); 
	  for (int i=0;i<10;i++)
	  { 
	   System.out.print(ave[i]+"\t");    
	  } 
	  System.out.print("\n"); 
	 } 
	} 
