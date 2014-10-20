
public class SY4_3 {
	public static void main(String[] args) 
	{ 
		  int row=5; 
		  int arr[][]=
	{{1,2,3,4,5},{5,1,2,3,6},{4,5,1,2,7},{3,4,5,1,9},{2,3,4,5,10}
		};   
		  System.out.println("数组为："); 
		  for(int i=0;i<row;i++)
		  { 
		   for(int j=0;j<row;j++)
		   { 
		    System.out.print(arr[i][j]+"\t"); 
		   } 
		   System.out.println(""); 
		  } 
		  int temp=0,y=0; 
		  int flag=1; 
		  for(int i=0;i<row;i++){ 
		   temp=arr[i][0]; 
		   for(int j=1;j<row;j++){ 
		    if(temp<arr[i][j]){ 
		     temp=arr[i][j]; 
		     y=j; 
		    } 
		   } 
		   for(int k=0;k<row;k++)
		   { 
		    if(arr[k][y]<temp)
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
