
import java.util.Scanner;
import java.util.StringTokenizer;
public class SY4_4 {
	public static void main(String[] args) {
	System.out.println("请输入字符串：");	
    Scanner in = new Scanner(System.in);
    String s1 =in.next();; //字符串
    String s = new String(s1);
    	StringTokenizer st=new StringTokenizer(s,"#");
    	System.out.println( "Token Total: " + st.countTokens() );
    	while( st.hasMoreElements() ){
    	System.out.println(st.nextToken());
}
	}
}
