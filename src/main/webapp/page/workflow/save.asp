<%
'response.write request("xml")
set xmlDoc=CreateObject("Microsoft.XMLDOM") 
xmlDoc.load request 
xmlDoc.save (server.mappath("data/default.xml"))
%>