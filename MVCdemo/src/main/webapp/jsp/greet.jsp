 
<h2>Hello ${message}</h2> 
<%-- ${ }: Used to read attribute form controller class via Modal Map --%>
<%-- Scripplet Tag <% %>: Used to write java code --%>
<%
  int i=8,j=7;
  int tot = i+j;
  System.out.println(tot);
%>

<p>Sum of <%=i%> and <%=j%> is <%=tot%> </p>


 
 
 