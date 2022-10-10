package com.protalento.servlets;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.protalento.entidades.Busqueda;
import com.protalento.jdbc.implementaciones.BusquedaImplementacion;

/**
 * Servlet implementation class Validacion
 */

@WebServlet("/validacion")
public class Validacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Validacion() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		RequestDispatcher dispatcher = request.getRequestDispatcher("busquedaWeb.jsp");
		
		Busqueda busquedas  = new Busqueda();
		busquedas.setTexto(request.getParameter("texto"));
		busquedas.setUrl(request.getParameter("url"));
		busquedas.setContenidoWeb(requestURLBodyResponse(busquedas.getUrl()));
		
		insertarBaseDatos(busquedas);
		
		request.setAttribute("busquedas", busquedas);
		
		dispatcher.forward(request, response);
				
	}
	
	private boolean insertarBaseDatos(Busqueda busquedas) {
		BusquedaImplementacion busquedaImplementacion = new BusquedaImplementacion();
		return busquedaImplementacion.insertar(busquedas);
	}
	
	
	public String requestURLBodyResponse(String url) {
		HttpClient client = HttpClient.newHttpClient();
		
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
				
		
		HttpResponse<String> response = null;
		
		try {
			response = client.send(request, BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return response.body();	
	}
	
	
}
