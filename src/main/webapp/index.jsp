<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Simple Java Calculator</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 50px; }
        .result { color: green; font-weight: bold; }
        .error { color: red; }
        form { border: 1px solid #ccc; padding: 20px; display: inline-block; }
    </style>
</head>
<body>
    <h2>Java Web Calculator</h2>
    
    <form action="calculate" method="post">
        <input type="text" name="num1" placeholder="Number 1" required>
        <select name="operation">
            <option value="add">+</option>
            <option value="subtract">-</option>
            <option value="multiply">*</option>
            <option value="divide">/</option>
        </select>
        <input type="text" name="num2" placeholder="Number 2" required>
        <button type="submit">Calculate</button>
    </form>

    <div style="margin-top: 20px;">
        <% if (request.getAttribute("result") != null) { %>
            <div class="result">Result: <%= request.getAttribute("result") %></div>
        <% } %>
        
        <% if (request.getAttribute("error") != null) { %>
            <div class="error">Error: <%= request.getAttribute("error") %></div>
        <% } %>
    </div>
</body>
</html>
