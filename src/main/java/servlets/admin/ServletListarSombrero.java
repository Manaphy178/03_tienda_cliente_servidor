package servlets.admin;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.SombrerosDAO;
import daosImpl.SombrerosDAOImpl;
import modelo.Sombrero;

@WebServlet("/admin/ServletListarSombrero")
public class ServletListarSombrero extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SombrerosDAO sombrerosDAO = new SombrerosDAOImpl();
		List<Sombrero> sombreros = sombrerosDAO.obtenerSombrero();
		request.setAttribute("info_listado", sombreros);
		RequestDispatcher rd = request.getRequestDispatcher("sombreros.jsp");
		rd.forward(request, response);
	}

}
