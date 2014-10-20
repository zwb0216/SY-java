	public class Leder extends SY5{ 
		 private float ub=0,db=0,h=0; 
		 public Leder(float ub,float db,float h) { 
		  this.ub=ub; //上底
		  this.db=db; //下底
		  this.h=h; //高
		 } 
		 public float ReturnArea() { 
		  return (float)(0.5*(this.ub+this.db)*this.h); 
		 } 
		} 
