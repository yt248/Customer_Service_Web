<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<body>

<div>
    <h2> All Customers</h2>
    <br>
    <br>
    <table border="1" cellpadding="5">
        <tr>
            <td>Имя:</td>
            <td>Фамилия:</td>
            <td>Возраст:</td>
            <td>Адрес:</td>
        </tr>
        <c:forEach var="customer" items="${customerList}">

            <tr>
                <td>${customer.name}</td>
                <td>${customer.surName}</td>
                <td>${customer.age}</td>
                <td>${customer.address.cityName}, ${customer.address.streetName}, ${customer.address.houseNumber}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<br>
<br>


</body>
</html>