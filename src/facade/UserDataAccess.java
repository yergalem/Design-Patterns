package facade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import facade.UserDataAccessFacade.Mode;

public class UserDataAccess implements IDataAccess {

	private static Connection con = null;
    private String sql;
    protected Mode mode;
    
    static {
        try {
            Class.forName( "<driver>" ).newInstance();
        } catch( InstantiationException e ) {
            e.printStackTrace();
        } catch( ClassNotFoundException e ) {
            e.printStackTrace();
        } catch( IllegalAccessException e ) {
            e.printStackTrace();
        }
    }
    
    public UserDataAccess(String sql, Mode mode ) {
    	 this.sql = sql;
    	 this.mode = mode;
	}
  
    @Override
    public void openConnection() throws SQLException {
    	if( con == null ) {
    		synchronized (UserDataAccessFacade.class) {
				if(con == null)
					con = DriverManager.getConnection( "<database>" );
			}
    	}
       
    }
    @Override
    public void closeConnection( ) {
        try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    @Override
	public ResultSet executeQuery(){
		ResultSet rset = null;
		PreparedStatement prep = null;
		
		try{
			if( mode == Mode.PREPARED_STATEMENT ) 
			   prep = con.prepareStatement(sql);
			else
				prep = con.prepareCall( sql );
			
		     //prep.setString(1, value);
		
			rset = prep.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return rset;
	}
    
  
   
	
}
