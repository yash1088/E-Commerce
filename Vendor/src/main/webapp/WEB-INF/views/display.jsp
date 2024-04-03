<%@page import="Model.Photo"%>
<%@page import="Model.MyData"%>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Photo List Display</title>
</head>
<body>
    <h1>Photos:</h1>

    <%
        List<MyData> myDataList = (List<MyData>) request.getAttribute("apiData");
        if (myDataList != null && !myDataList.isEmpty()) {
            for (MyData myData : myDataList) {
                List<Photo> photoList = myData.getPhotos();
                if (photoList != null && !photoList.isEmpty()) {
                    for (Photo photo : photoList) {
    %>
                        <div>
                            <p>Photo ID: <%= photo.getId() %></p>
                            <p>User ID: <%= photo.getUser() %></p>
                            <p>Title: <%= photo.getTitle() %></p>
                            <p>Description: <%= photo.getDescription() %></p>
                            <img src="<%= photo.getUrl() %>" alt="Photo" height="150" width="150">
                            <hr>
                        </div>
    <%
                    }
                } else {
    %>
                    <p>No photos available.</p>
    <%
                }
            }
        } else {
    %>
            <p>No data available.</p>
    <%
        }
    %>
</body>
</html>
