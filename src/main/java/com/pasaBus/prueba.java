package com.pasaBus;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ModelDao.RecorridoDao;
import ModelDao.LocalidadesDao;
import model.DbConnector;
import model.Localidad;
import model.Recorrido;

/**
 * Servlet implementation class prueba
 */
@WebServlet("/prueba")
public class prueba extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public prueba() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter salida = response.getWriter();
		int idReco= Integer.parseInt(request.getParameter("origen"));
		int idRecol=Integer.parseInt(request.getParameter("llegada"));		
		
			RecorridoDao recDao = new RecorridoDao();//Crear objeto en una misma sentencia ver
			LinkedList<Recorrido> tabR = recDao.buscar();
			
			LocalidadesDao locDao = new LocalidadesDao();
			LinkedList<Localidad> tabL = locDao.buscar();
			
			ArrayList<Recorrido> varRec = new ArrayList<Recorrido>();
			
		for (int i = 0; i < tabR.size(); i++) {
				
				if(idReco==tabR.get(i).getIdLocOrigen()) {
					
					salida.println("<html><body>");
					salida.println("Origen:");
					for (int j = 0; j < tabL.size(); j++) {
							
						if(idReco==tabL.get(j).getId()) {
					salida.println(""+tabL.get(j).getLocalidad()+"\n");}
					}
					salida.println("</body></html>");
					
					if(idRecol==tabR.get(i).getIdLocDestino()) {
						
						salida.println("<html><body>");
						salida.println("Destino: ");
						for (int j = 0; j < tabL.size(); j++) {
								
							if(idRecol==tabL.get(j).getId()) {
						salida.println(""+tabL.get(j).getLocalidad());}
						}
						salida.println("</body></html>");
				}
				
				}
			}
	
	}
			
			
			/*salida.println("<html><body>");
			salida.println("<h1>hola</h1>");
			salida.println("<h1>hola</h1>");
			salida.println("</body></html>");/*
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
