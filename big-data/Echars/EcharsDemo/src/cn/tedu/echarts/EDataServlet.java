package cn.tedu.echarts;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EDataServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		Random rand = new Random();
		String data = "["+rand.nextInt(9999)+", "+rand.nextInt(9999)+", "+rand.nextInt(9999)+", "+rand.nextInt(9999)+", "+rand.nextInt(9999)+", "+rand.nextInt(9999)+", "+rand.nextInt(9999)+"]";
		response.getWriter().write(data);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
