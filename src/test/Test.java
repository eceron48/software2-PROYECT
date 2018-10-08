package test;

import java.sql.SQLException;

import modelo.DAOResidente;
import modelo.factorymethod.MYSQLDBAdapter;

public class Test {

	public static void main(String[] args) throws SQLException {
		
		DAOResidente dao=new DAOResidente();
		
		dao.mostrarTodoResidente();
		
		
	}

}
