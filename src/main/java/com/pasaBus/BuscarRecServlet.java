package com.pasaBus;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class BuscarRecServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarRecServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			PrintWriter salida = response.getWriter();
			String idReco= request.getParameter("origen");
			String idRecol=request.getParameter("llegada");
			
			LinkedList<Recorrido> recorridos = new LinkedList<>();
			
			
		try {
				PreparedStatement st = DbConnector.getInstancia().getConn().prepareStatement("Select * FROM recorrido WHERE id_localidad_origen =" + idReco);
				
				ResultSet rs = st.executeQuery();
				
				while (rs.next()) {
					
					if(idReco.equals(rs.getString("id_localidad_llegada"))) {
					Recorrido rec = new Recorrido();
					rec.setIdLocSalida(rs.getInt("id_localidad_salida"));;
					rec.setIdLocLlegada(rs.getInt("id_localidad_llegada"));
					recorridos.add(rec);
					}
				}
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		
		for (Recorrido rec : recorridos) {
			
			int clavef= rec.getIdLocLlegada();
			salida.println("<html><body>");
			salida.println("<h1>"+clavef);
			salida.println("</h1>");
			salida.println("</body></html>");
			
		}
				
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
