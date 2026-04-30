package com.example.calculator;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculate")
public class CalculatorServlet extends HttpServlet {
    private Calculator calculator = new Calculator();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String num1Str = request.getParameter("num1");
        String num2Str = request.getParameter("num2");
        String operation = request.getParameter("operation");
        
        try {
            double num1 = Double.parseDouble(num1Str);
            double num2 = Double.parseDouble(num2Str);
            double result = 0;

            switch (operation) {
                case "add":
                    result = calculator.add(num1, num2);
                    break;
                case "subtract":
                    result = calculator.subtract(num1, num2);
                    break;
                case "multiply":
                    result = calculator.multiply(num1, num2);
                    break;
                case "divide":
                    result = calculator.divide(num1, num2);
                    break;
                default:
                    request.setAttribute("error", "Invalid operation");
                    break;
            }
            request.setAttribute("result", result);
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid number format");
        } catch (ArithmeticException e) {
            request.setAttribute("error", e.getMessage());
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
