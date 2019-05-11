package programa;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;



public class conexao {
	
public static Connection con = null;
 public static  Connection getConnnection() throws ClassNotFoundException{
	 
	  
	Class.forName("com.mysql.jdbc.Driver");
	
	
	try {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tcc","root","");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
	
return con;
}

public boolean getConnection() {
	return false;
	// TODO Auto-generated method stub
	
}

public List<cadastropaciente> read() throws SQLException{
	conexao conexao = new conexao();
	conexao.getConnection();
		Connection conexao1;
	conexao1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/tcc","root","");

	
	PreparedStatement stmt = null;
	ResultSet rs = null;
	try{
	stmt = con.prepareStatement("select * from medicos");
	rs = stmt.executeQuery();
	
	while(rs.next()){
		
		cadastropaciente paciente = new cadastropaciente();
		paciente.setId(rs.getString("idmedicos"));
		paciente.setName(rs.getString("nome"));
		paciente.setId(rs.getString("data_nasc")); 
		paciente.setId(rs.getString("cpf"));
		paciente.setId(rs.getString("rg"));
		paciente.setId(rs.getString("crm"));
		paciente.setId(rs.getString("sexo"));
		 
	}
	
	}catch(SQLException ex){
		Logger.getLogger(cadastropaciente.class.getName()).log(Level.SEVERE,null, ex);

	}
	
	return  (List<cadastropaciente>) rs;
}

public PreparedStatement prepareStatement(String sql) {
	// TODO Auto-generated method stub
	return null;
}

public void close() {
	// TODO Auto-generated method stub
	
}


}