import java.util.Scanner;


public class SY4_3_update {
	public static void main(String[] args) 
	{ 
	System.out.println("输入方阵的行列数：");
	Scanner in= new Scanner(System.in);
	int row=in.nextInt();
	System.out.println("输入随机方阵中最大元素值：");
	int m=in.nextInt();
	
    int arg[][]=new int[row][row]; 
    System.out.println("随机数组为："); 
    for (int i=0;i<row;i++)
    {   
   	 for (int j=0;j<row;j++)
   { 
	    arg[i][j]=(int)(Math.random()*m); 
       System.out.print(arg[i][j]+"\t"); 
   } 
	   System.out.print("\n"); 

	  } 
		  int temp=0,y=0; 
		  int flag=1; 
		  for(int i=0;i<row;i++){ 
		   temp=arg[i][0]; 
		   for(int j=1;j<row;j++){ 
		    if(temp<arg[i][j]){ 
		     temp=arg[i][j]; 
		     y=j; 
		    } 
		   } 
		   for(int k=0;k<row;k++)
		   { 
		    if(arg[k][y]<temp)
		    { 
		     flag=0; 
		     break; 
		    } 
		   } 
		   if(flag==1){ 
		    System.out.println
		    ("位于("+(i+1)+","+(y+1)+")的数"+temp+"是数组的鞍点"); 
		   } 
		  } 
		 } 
}
