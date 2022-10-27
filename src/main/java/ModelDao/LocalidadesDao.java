package ModelDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import model.DbConnector;
import model.Localidad;

public class LocalidadesDao  {
	

	public LinkedList<Localidad> getLocalidades()
	{
		LinkedList<Localidad> localidades = new LinkedList<>();
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			st= DbConnector.getInstancia().getConn().prepareStatement("Select * FROM localidades");
			//---Se establece y se crea la sentencia SQL--
			rs= st.executeQuery();
			//--Se ejecuta la sentencia SQL--
			{
				while(rs.next()) 
				{
					Localidad loc = new Localidad();
					loc.setId(rs.getInt("id"));
					loc.setLocalidad(rs.getString("localidad"));
					localidades.add(loc);
				}
				//Se recorre el ResultSet
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return localidades;

	}
	
	
	public void add(Localidad l) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into localidades(id, id_privincia, localidad) values(?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setInt(1, l.getId_privincia());
		    stmt.setString(2, l.getLocalidad());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                l.setId(keyResultSet.getInt(1));
            }

			
		}  catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
	
		}
  }
}