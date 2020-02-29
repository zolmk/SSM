<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/29
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FileUpload</title>
</head>
<body>
    <form action="/hello/batchupload.do" method="post" enctype="multipart/form-data">
        file:<input type="file" name="file"/><br>
        file:<input type="file" name="file"/><br>
        <input type="submit" value="上传"/>
    </form>
</body>
</html>






























