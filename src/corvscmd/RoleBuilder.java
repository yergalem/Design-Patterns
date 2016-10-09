package corvscmd;

public class RoleBuilder {
     
   public static DataProcessor buildRoleHierarchy(){
	   
	   Validator validator = new Validator();
	   DataWasher washer = new DataWasher();
	   Reporter reporter = new Reporter();
	   
	   validator.setSuccessor(washer);  // validator.successor = washer;   alternative
	   washer.setSuccessor(reporter);
	   
	   return validator;
   }
   
   public static DataProcessor getHandler() {
	    
		
	    return buildRoleHierarchy();
	}
	
}
