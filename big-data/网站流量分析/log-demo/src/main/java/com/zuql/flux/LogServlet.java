package com.zuql.flux;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

public class LogServlet extends HttpServlet {
	private static Logger logger = Logger.getLogger(LogServlet.class);
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String qs = URLDecoder.decode(req.getQueryString(), "utf-8");

		String kvs [] = qs.split("\\&");
		StringBuilder sb = new StringBuilder();
		for(String kv : kvs ){
			String [] arr = kv.split("=");
			String v = arr.length>=2 ? arr[1] : "";
			sb.append(v+"|");
		}
		//拼接客户端ip
		sb.append(req.getRemoteAddr());

		String line = sb.toString();
		logger.info(line);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
