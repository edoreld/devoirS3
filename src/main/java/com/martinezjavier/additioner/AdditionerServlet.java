package com.martinezjavier.additioner;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

//assumes the current class is called MyLogger
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

/**
 * Servlet implementation class AdditionerServlet
 */
@WebServlet("/add")
public class AdditionerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int param2Default;
	private final static Logger LOGGER = Logger.getLogger(com.martinezjavier.additioner.AdditionerServlet.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdditionerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		if (request.getParameter("param1") != null && request.getParameter("param2") != null) {
			
			
			try {
				int param1 = Integer.parseInt(request.getParameter("param1"));
				int param2 = Integer.parseInt(request.getParameter("param2"));
				
				
				
				
				LOGGER.info(param1 + " + " + param2 + " = " + param1 + param2);
				out.println(param1 + param2);
				
				
			} catch (NumberFormatException e){
				resp.setStatus(500);
				out.println("Exécution impossible, paramètre manquant");
			}
		} else if (request.getParameter("param1") != null && request.getParameter("param2") == null) {
			try {
				int param1 = Integer.parseInt(request.getParameter("param1"));
				
				LOGGER.info("param2 missing. Using default value");
				LOGGER.info(param1 + " + " + param2Default + " = " + param1 + param2Default);
				out.println(param1 + param2Default);
			} catch (NumberFormatException e) {
				resp.setStatus(500);
				out.println("Exécution impossible, paramètre manquant");
			}				
		} else {
			LOGGER.info("Malformed request");
			resp.setStatus(500);
			out.println("Exécution impossible, paramètre manquant");
		}
		
//		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
		
//		resp.setLocale(Locale.ENGLISH);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		if (request.getParameter("param2") != null) {
			try {
				param2Default = Integer.parseInt(request.getParameter("param2"));
				LOGGER.info("param2's default value has been set to " + param2Default);
				out.println("OK");
				
			} catch (NumberFormatException e){
				resp.setStatus(500);
				
				out.println("Exécution impossible, paramètre manquant.");				
			}
		}
		
	}

}
