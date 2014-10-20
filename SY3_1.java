import java.io.*;
public class SY3_1 {
	public static void main(String[] args) 
	{ 
		  System.out.print("请输入一个大于6的偶数："); 
		  int num = 0; 
		  try{ 
		   num = Integer.parseInt(
				   (new BufferedReader(new InputStreamReader(System.in))).readLine()); 
		  }
		  catch(Exception e)
		  { 
		   e.printStackTrace(); 
		  } 
		  if (num%2!=0||num<6){ 
		   System.out.println("输入不正确，请重新输入"); 
		   return; 
		  } 
		  for (int i=1;i<num/2+1;i++){ 
		   if (IsPrimeNum(i)&&IsPrimeNum(num-i)) 
		    System.out.println(i+" + "+(num-i)+" = "+num); 
		  } 
		 } 
		 private static boolean IsPrimeNum(int num)
		 {   
	       if (num<=0) 
		   return false; 
           else if (num<=3) 
		   return true; 
		     else 
		   for(int i=2;i<num/2+1;i++) 
		    if (num%i==0) 
		     return false; 
		     return true; 
		 } 
	}
