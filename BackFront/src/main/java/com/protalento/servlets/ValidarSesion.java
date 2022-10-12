package com.protalento.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.protalento.entidades.Usuario;
import com.protalento.enumerados.Alertas;
import com.protalento.jdbc.implementaciones.UsuarioImplementacion;
import com.protalento.jdbc.interfaces.Constantes;

@WebServlet("/sesion")
public class ValidarSesion extends HttpServlet {
	private static Logger logger = LogManager.getLogger();
	private static final long serialVersionUID = 1L;
	private UsuarioImplementacion usuarioImplementacion;

	public ValidarSesion() {
		super();
		usuarioImplementacion = new UsuarioImplementacion();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Boolean cerrarSesion = Boolean.valueOf(request.getParameter("cerrarSesion"));
		RequestDispatcher requestDispatcher;

		if (cerrarSesion && request.getSession().getId() != null) {
			request.getSession().invalidate();
			request.setAttribute("alerta", Alertas.CERRAR_SESION);
			logger.info(Alertas.CERRAR_SESION);
		}

		requestDispatcher = request.getRequestDispatcher("login.jsp");
		requestDispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final String VERSION = System.getProperty("version");
		
		String correo = request.getParameter("correo");
		String clave = request.getParameter("clave");
		String pagina = "login.jsp";
		HttpSession sesion = null;
		Usuario usuario = usuarioImplementacion.buscarPorCorreoClave(correo, clave);

		RequestDispatcher requestDispatcher;

		if (usuario != null) {

			if (usuario.getIntentosFallidos() >= Constantes.MAXIMO_INTENTOS_FALLIDOS_USUARIO) {
				request.setAttribute("alerta", Alertas.USUARIO_BLOQUEADO);
				logger.warn(usuario + " " + Alertas.USUARIO_BLOQUEADO);
			} else if (!usuario.getClave().equals(clave)) {
				request.setAttribute("alerta", Alertas.CREDENCIALES_INCORRECTAS);
				logger.warn(usuario + " " + Alertas.CREDENCIALES_INCORRECTAS);
			} else {
				sesion = request.getSession();
				sesion.setAttribute("usuario", usuario);
				sesion.setAttribute("VERSION", VERSION);
				pagina = "index.jsp";
			}
		} else {
			request.setAttribute("alerta", Alertas.CREDENCIALES_INCORRECTAS);
			logger.warn(correo + " " + Alertas.CREDENCIALES_INCORRECTAS);
		}

		requestDispatcher = request.getRequestDispatcher(pagina);
		requestDispatcher.forward(request, response);

	}

}
