package ModelDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import model.DbConnector;
import model.Localidad;

public class LocalidadesDao  {
	

	public LinkedList<Localidad> buscar()
	{
		PreparedStatement st=null;
		ResultSet rs=null;
		LinkedList<Localidad> localidades = new LinkedList<>();	
		try {
			st= DbConnector.getInstancia().getConn().prepareStatement("Select * FROM localidades");
			rs= st.executeQuery();
			{
				while(rs.next()) 
				{
					Localidad loc = new Localidad();
					loc.setId(rs.getInt("id"));
					loc.setLocalidad(rs.getString("localidad"));
					localidades.add(loc);
				}
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return localidades;

	}
}
