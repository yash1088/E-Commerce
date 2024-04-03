<%@page import="java.util.ArrayList"%>
<html>  
<body>  
    
<h1>Hello Second</h1>  
${name}
${pass}

 
 <li>
    <%
        for(String s:${cars}){
        %>
        
        <h1><% out.println(s); %></h1>
        <%
            }
            %>
            
<li>            


</body>  
</html>  