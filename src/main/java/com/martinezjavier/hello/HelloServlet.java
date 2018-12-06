package com.martinezjavier.hello;

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
 * Servlet implementation class HelloServlet
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int param2Default;
	private final static Logger LOGGER = Logger.getLogger(com.martinezjavier.hello.HelloServlet.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		out.println(sayHello());
		
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

	public String sayHello() {
		return "Hello world.";
	}
}
