package com.osnat.javacourse;

import java.io.IOException;
import java.lang.Math;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Exercise02 extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		double radius = 50.0;
		double pai= Math.PI;
		double area= pai *( Math.pow(radius, 2));
		
		String line1 = new String("calculation 1: Area of circle with radiu   " +radius+ "  is "+ area + "  square cm ");
		
		double hypotenuse= 50;
		double angleB= 30;
		double radians= Math.toRadians(angleB);
		double opposite= (Math.sin(radians))* hypotenuse ;
		
		String line2 = new String("calculation 2: Length of opposite where angle B is  " +angleB+ 
				" degrees, and Hypotenuse length is "+ hypotenuse+" cm is: " +opposite+ "​ cm ");
		
		
		int base=20;
		int exp=13;
		double calc= Math.pow(base, exp);
		
		String line3 = new String("calculation 3: Power of " +base+ " with exp of " +exp+ " is "+ calc );
		
		String totalResult= line1+"<br>"+line2+"<br>"+line3+"</br>";
		


			resp.setContentType("text/html");
			resp.getWriter().println(totalResult);

	}

}
