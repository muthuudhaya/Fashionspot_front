<%@page language="java" contentType="text/html"%>
<%@include file="header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<br/><br/>
<form:form action="InsertProduct" modelAttribute="product" method="post">
<table align="center" class="table-bordered">
<tr>
     <td colspan="2">Product Info </td>
</tr>
<tr>
    <td>Product Name</td>
    <td><form:input path="productName"/></td>
</tr>
<tr>
    <td>Price</td>
    <td><form:input path="price"/></td>
</tr>
<tr>
    <td>Stock</td>
    <td><form:input path="stock"/></td>
</tr>
<tr>
    <td>Category</td>
    <td>
    <form:select path="categoryID">
    <form:option value="0" label="--Select List--"/>
    <form:options items="${categoryList}"/>
    </form:select>
    </td>
</tr>
<tr>
    <td>SupplierID</td>
    <td><form:input path="supplierID"/></td>
</tr>
<tr>
    <td>Product Desc</td>
    <td><form:input path="productDesc"/></td>
</tr>
<tr>
    <td colspan="2"><center><input type="submit" value="InsertProduct"/></center></td>
</tr>

</table>
</form:form>
</body>
</html>