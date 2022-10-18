package ModelDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import model.DbConnector;
import model.Recorrido;

//RecorridoDao da problemas!

public class RecorridoDao {

	
	public LinkedList<Recorrido> buscar()
	{
		PreparedStatement st=null;
		ResultSet rs=null;
		LinkedList<Recorrido> recorridos = new LinkedList<>();	
		try {
			st= DbConnector.getInstancia().getConn().prepareStatement("Select * FROM recorrido");
			rs= st.executeQuery();
			{
				while(rs.next()) 
				{
					Recorrido rec = new Recorrido();
					rec.setIdLocOrigen(rs.getInt("id_localidadO"));
					rec.setIdLocDestino(rs.getInt("id_localidadD"));
					rec.setIdRecorrido(rs.getInt("idrecorrido"));
					rec.setHsSalida(rs.getNString("hsSalida"));
					rec.setHsLlegada(rs.getString("hsLlegada"));
					recorridos.add(rec);
				}
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return recorridos; 
		//prueba para hacer cambio
	}
}