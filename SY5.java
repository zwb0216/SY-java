import java.util.Scanner;


public class SY5 {
	private String name; 
	public void setname(String name)
	{   
		this.name=name; 
	 } 
	 public static void main(String []args){
		 System.out.print("输入圆的半径:"); 
		 Scanner in = new Scanner(System.in);
		 int r= in.nextInt();
		 System.out.print("输入三角形的三边长度:"); 
		 Scanner in1 = new Scanner(System.in);
		 int a= in1.nextInt();
		 int b= in1.nextInt();
		 int c= in1.nextInt();
		 System.out.print("输入梯形的上底长度、下底长度和高的长度:"); 
		 Scanner in2 = new Scanner(System.in);
		 int e= in2.nextInt();
		 int d= in2.nextInt();
		 int f= in2.nextInt();
	  Cirlce circle=new Cirlce(r); 
	  System.out.println("圆的面积为："+circle.ReturnArea()); 
	  System.out.println("圆的周长为： "+ circle.ReturnPrimetre()); 
	  Trangle trangle=new Trangle(a,b,c); 
	  System.out.println("三角形的面积为："+trangle.ReturnArea()); 
	  System.out.println("三角形的周长为："+trangle.ReturnPrimetre()); 
	  Leder leder=new Leder(e,d,f); 
	  System.out.println("梯形的面积为："+leder.ReturnArea()); 
	 } 
	}
