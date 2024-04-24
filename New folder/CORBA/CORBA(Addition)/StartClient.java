    /**
     *
     * @author imed
     */
    import AdditionApp.*;
     
    import org.omg.CosNaming.*;
    import org.omg.CosNaming.NamingContextPackage.*;
    import org.omg.CORBA.*;
    import java.io.*;
    import java.util.*;
     
    public class StartClient {
     
        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
          try {
    	    ORB orb = ORB.init(args, null);
    	    org.omg.CORBA.Object objRef =   orb.resolve_initial_references("NameService");
    	    NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
    	    Addition addobj = (Addition) AdditionHelper.narrow(ncRef.resolve_str("ABC"));
     
                System.out.println("Welcome to the Calculator system:"); 
		Scanner c=new Scanner(System.in);
		for(;;){
			System.out.println("Enter Your Choice ");
    		      System.out.println("1 for Addition");
    		      System.out.println("2 for Subtraction");
    		      System.out.println("3 for Multiplication");
    		      System.out.println("4 for Division");
 			System.out.println("5 for Exit");
			int choice=c.nextInt();
			if(choice==5){
			break;
				}
			System.out.println("Enter a:");
    		      	double a=c.nextDouble();
    		      System.out.println("Enter b:");
    		      double b=c.nextDouble();
    		      switch(choice){
      		      case 1:
      		        System.out.println((int)a + " + " + (int)b + " = " + (int)addobj.add(a, b));
      		        break;
      		      case 2:
      		        System.out.println((int)a + " - " + (int)b + " = " + (int)addobj.subtract(a, b));
      		        break;
      		       case 3:
      		        System.out.println((int)a + " * " + (int)b + " = " + (int)addobj.multiply(a, b));
      		        break;
      		       case 4:
      		        System.out.println((int)a + " / " + (int)b + " = " + (int)addobj.divide(a, b));
      		        break;
      		        default:
      		        	System.out.println("Invalid Choice");
    		        }
            
			} 
		}     		    
   
           catch (Exception e) {
              System.out.println("Hello Client exception: " + e);
    	  e.printStackTrace();
           }
     
        }
     
    }
