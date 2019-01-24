<%@page language="java" contentType="text/html"%>
<%@include file="header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form action="<c:url value="/UpdateCategory"/>" method="post">
<table align="center" class="table">
<tr>
    <td colspan="2">
    <center><h3>Category</h3></center>
    </td>
</tr>
<tr>
    <td>Category ID</td>
    <td><input type="text" name="catId" value="${category.categoryID}" readonly/></td>
</tr>
<tr>
    <td>Category Name</td>
    <td><input type="text" name="catName" value="${category.categoryName}"  /></td>
</tr>
<tr>
    <td>Category Description</td>
    <td><input type="text" name="catDesc" value="${category.categoryDesc}" /></td>
</tr>    
<tr>
    <td colspan=2 align="center"><input type="submit" value="Update Category"/></td>
</tr>    





</table>
</form>


</body>
</html>