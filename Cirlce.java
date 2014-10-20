public class Cirlce extends SY5 implements RePrimetre{ 
 private float r; 
 public Cirlce(float r)
 { 
	 this.r=r; 
 } 
 public float ReturnArea() 
 { 
  return (float)3.1415*this.r*this.r; 
 }  
 public float ReturnPrimetre() 
 { 
  return (float)(2*3.1415*this.r); 
 } 
} 
