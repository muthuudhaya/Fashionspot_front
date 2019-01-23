<%@page language="java" contentType="text/html"%>
<%@include file="header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form action="AddCategory" method="post">
<table align="center" class="table">
<tr>
    <td colspan="2">
    <center><h3>Category</h3></center>
    </td>
</tr>
<tr>
    <td>Category Name</td>
    <td><input type="text" name="catName"/></td>
</tr>
<tr>
    <td>Category Description</td>
    <td><input type="text" name="catDesc"/></td>
</tr>    
<tr>
    <td colspan=2 align="center"><input type="submit" value="Add Category"/></td>
</tr>    


</table>
</form>
<table class="table-bordered">
<tr>
<td>Category ID</td>
<td>Category Name</td>
<td>Category Desc</td>
<td>Operations</td>
</tr>

<c:forEach items="${listCategories}" var="category">
<tr>
    <td>${category.categoryID}</td>
    <td>${category.categoryName}</td>
    <td>${category.categoryDesc}</td>
    <td>
    <a href="<c:url value="/editCategory/${category.categoryID}"/>"class="btn btn-success">Edit</a>
    <a href="<c:url value="/deleteCategory/${category.categoryID}"/>"class="btn btn-danger">Delete</a>
    </td>
 </tr>
 </c:forEach>   
    
</table>



</body>
</html>