import java.io.*;
public class SY3_2 {
	 public static void main(String[] args) 
	 { 
		  float num[] = new float[4]; 
		  int number=4; 
		  try{ 
		   for (int i=0;i<number;i++){ 
		    System.out.print("请输入第"+(i+1)+"个数："); 
             num[i]=Float.parseFloat(
		    		(new BufferedReader(new InputStreamReader(System.in))).readLine()); 
		   } 
		  }
		  catch(Exception e)
		  { 
		   e.printStackTrace(); 
		  } 
		  float swap; 
		  for (int i=0;i<number-1;i++) 
		   for (int j=i+1;j<number;j++){ 
		    if (num[i]>num[j]){ 
		     swap=num[i]; 
		     num[i]=num[j]; 
		     num[j]=swap; 
		    } 
		   } 
		  System.out.println("中位数为："+(num[number/2]+num[number/2-1])/2); 
		 } 
	 }
