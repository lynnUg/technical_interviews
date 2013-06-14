public class circle
	{
	  public static void main(String [] args)
	  {

	  		//double me = 0.99;
	  		//double me2= 1-Math.pow(0.2,2);
	  		//System.out.println(me2);
	  	 double x=0.0;
	  	 double y=0.0;
	  	 for(int i=0;i<10;i++)
	  	  {
	  	  	
	  	  	x=Math.round(x*100.0)/100.0;
	  	  	y=Math.sqrt(1-Math.pow(x,2));
	  	  	y=Math.round(y*100.0)/100.0;
	  	  	int _x=(int)(x*100);
	  	  	int _y=(int)(Math.round(y*100));
	  	  	//System.out.println(_y);
	  	  	plot(_x,_y);
	  	  	x+=0.1;
	  	  	
           //System.out.println();

	  	  }
	  	  


	  }
	  public static void plot(int x,int y)
	  {
	  	//System.out.println("here");
	  	
	  	y=10-(y/10);
	  	String z="";
	  	for(int i=1;i<x;i++)
	  	{
	  		z+=" ";
	  	}
	    z+="*";
        for(int i=0;i<y;i++)
	  	{
	  	  System.out.println();
	  	}
	  	System.out.println(z+x);
	  	
	  	
	  }
	}