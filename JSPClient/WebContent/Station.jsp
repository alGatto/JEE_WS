<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="fr.ynov.gattuso.service.*"%>
<%
WeatherStationSOAPServiceProxy stub=new WeatherStationSOAPServiceProxy();
WeatherStation[] ws=stub.seeWeatherStation();
Instrument[] instru=new Instrument[0];
String refStation=null;
if(request.getParameter("action")!=null){
String action=request.getParameter("action");
if(action.equals("instrument")){
refStation=request.getParameter("refStation");
instru=stub.seeInstrument(refStation);
}
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Weather Station YNOVM</title>
</head>
<body>
	<form action="Transport.jsp" method="get">
Weather Station:
<select name="refCarg">
<option>-----</option>
<% for(WeatherStation c:ws) {%>
<option value="<%=c.getReference()%>"
<%if(c.getReference().equals(refStation)){ %> selected="selected" <%} %> >
<%=c.getReference()%>
</option>
<%} %>
</select>
<input type="submit" name="action" value="marchandises">
</form>
<table border="1" width="80%">
<tr>
<th>Id</th><th>Name</th><th>Station</th>
</tr>
<% for(Instrument m:instru){%>
<tr>
<td><%=m.getId()%></td><td><%=m.getName()%></td><td>
<%=m.getStation()%></td>
</tr>
<%} %>
</table>
</body>
</html>