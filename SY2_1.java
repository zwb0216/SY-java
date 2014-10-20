import java.io.*; 
public class SY2_1 {
	 public static void main(String[] args){ 
		  int length=0,width=0; 
		  try{ 
		  System.out.print("输入长度:"); 
		  length=Integer.parseInt(
				  (new BufferedReader(new InputStreamReader(System.in))).readLine()); 
		  System.out.print("输入宽度:"); 
		  width=Integer.parseInt(
				  (new BufferedReader(new InputStreamReader(System.in))).readLine()); 
		  int area=length*width; 
		  int perimeter=2*(length+width); 
		  System.out.println("面积:"+area); 
		  System.out.println("周长:"+perimeter); 
		  }
		  catch(IOException e)
		  { 
		   e.printStackTrace(); 
		  } 
		 } 
}
