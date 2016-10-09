package facade;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDataAccessFacade {
	
	public enum Mode { PREPARED_STATEMENT, CALLABLE };
	protected Mode mode;
	private String sql;
	
	UserDataAccess uDB = new UserDataAccess( sql, mode);
	
	// Possible to display or delegate other method to accomplish the responsibility
	
    public boolean execute() throws SQLException {
		 
    	uDB.openConnection();
        ResultSet rs = uDB.executeQuery();
    	uDB.closeConnection();
    	
    	return  rs!= null;
    	
	}
    
    
   	public String getSQL() {
   		return sql;
   	}
   	public void setSQL(String sql) {
   		this.sql = sql;
   	}
   	public Mode getMode() {
   		return mode;
   	}
   	public void setMode(Mode mode) {
   		this.mode = mode;
   	}
    
}
