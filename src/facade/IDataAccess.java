package facade;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public interface IDataAccess {
	public void openConnection() throws SQLException;
	public ResultSet executeQuery();	
	public void closeConnection() throws SQLException;
	
}
