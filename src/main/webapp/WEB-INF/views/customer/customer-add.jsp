<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<body>
<h2>Добавление нового клиента</h2>
<form:form action="saveCustomer" modelAttribute="customerDto">
    <table>
        <tr>
            <td>Customer</td>
            <td></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>Surname:</td>
            <td><form:input path="surName"/></td>
        </tr>
        <tr>
            <td>Age:</td>
            <td><form:input path="age"/></td>
        </tr>
        <tr>
            <td>Address</td>
            <td>
        </tr>
        <tr>
            <td>City Name:</td>
            <td><input type="text" name="cityName" placeholder="Введите название города"/></td>
        </tr>
        <tr>
            <td>Street Name:</td>
            <td><input type="text" name="streetName" placeholder="Введите название улицы"/></td>
        </tr>
        <tr>
            <td>House Number:</td>
            <td><input type="text" name="houseNumber" placeholder="Введите номер дома"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Create"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
