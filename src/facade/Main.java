package facade;

import java.sql.ResultSet;
import java.sql.SQLException;

import facade.UserDataAccessFacade.Mode;

// Facade Pattern
public class Main {
	public static void main(String[] args){

	        UserDataAccessFacade util = null;
	        try {
	            util = new UserDataAccessFacade();
	            String sql = "SELECT * FROM <table> WHERE <column name> = ?";
	            util.setSQL( sql );
	           
	            
	            util.setMode( Mode.CALLABLE );
	            sql = "{call <stored procedure>( ?, ? )}";
	            util.setSQL( sql );
	           
	            
	            util.execute();
	           
	            
	            
	        } catch( SQLException e ) {
	            e.printStackTrace();
	        } finally {
	            //Clean up
	        }
	   
	}
}
