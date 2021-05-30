<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<body>
<h2>Добавление нового клиента</h2>
<form:form action="saveUpdateAddress" method="post" modelAttribute="addressDto">
    <table>
        <tr>
            <td>Customer</td>
            <td><input type="hidden" name="customerDtoId" value="${customerDto.id}"/></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td>${customerDto.name}</td>
        </tr>
        <tr>
            <td>Surname:</td>
            <td>${customerDto.surName}</td>
        </tr>
        <tr>
            <td>Age:</td>
            <td>${customerDto.age}</td>
        </tr>
        <tr>
            <td>Address</td>
        </tr>
        <tr>
            <td>City Name:</td>
            <td><form:input path="cityName"/></td>
        </tr>
        <tr>
            <td>Street Name:</td>
            <td><form:input path="streetName"/></td>
        </tr>
        <tr>
            <td>House Number:</td>
            <td><form:input path="houseNumber"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Update"></td>
        </tr>

    </table>
</form:form>
</body>
</html>
