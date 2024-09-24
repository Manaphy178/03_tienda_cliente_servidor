package servicios;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import java.util.*;
import daos.*;
import daosImpl.*;
import modelo.*;

/**
 * Servlet implementation class ServicioProducto
 */
@WebServlet("/ServicioProductos")
public class ServicioProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServicioProductos() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SombrerosDAO dao = new SombrerosDAOImpl();
		ArrayList<Sombrero> sombrero = dao.obtenerSombrero();
//		Ahora tengo que transformar los libros a json para darselos al cliente
		
		Gson gson = new Gson();
		String json = gson.toJson(sombrero);
		
		response.getWriter().print(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
