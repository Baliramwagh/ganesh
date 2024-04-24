    /**
     *
     * @author imed
     */
    import AdditionApp.*;
    import org.omg.CosNaming.*;
    import org.omg.CosNaming.NamingContextPackage.*;
    import org.omg.CORBA.*;
    import org.omg.PortableServer.*;
    import org.omg.PortableServer.POA;
    import java.util.Properties;
     
    class AdditionObj extends AdditionPOA {
      private ORB orb;
     
      public void setORB(ORB orb_val) {
        orb = orb_val; 
      }
     
      public double add(double a, double b) {
    return a + b;
  }

  public double subtract(double a, double b) {
    return a - b;
  }

  public double multiply(double a, double b) {
    return a * b;
  }

  public double divide(double a, double b) {
    return a/ b;
  }
     
      // implement shutdown() method
      public void shutdown() {
        orb.shutdown(false);
      }
    }
