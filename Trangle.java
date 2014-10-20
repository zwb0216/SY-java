public class Trangle extends SY5 implements RePrimetre{ 
 private float a=0,b=0,c=0; 
 public boolean isTrangle; 
 Trangle(float a,float b,float c)
 { 
  this.a=a; 
  this.b=b; 
  this.c=c; 
  if(a+b-c<=0||a+c-b<=0||b+c-a<=0) 
  this.isTrangle=false; 
  else 
 this.isTrangle=true; 
 } 
 public void ModifySides(float a,float b,float c) 
 { 
  this.a=a; 
  this.b=b; 
  this.c=c; 
 } 
 float ReturnArea() { 
  float p=this.a+this.b+this.c; 
  return 
(float)Math.sqrt(p*(p-this.a)*(p-this.b)*(p-this.c)); 
 } 
public float ReturnPrimetre() 
{   
	return (float)(this.a+this.b+this.c); 
 } 
} 
