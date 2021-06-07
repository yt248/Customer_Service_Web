<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<body>
<h2>Добавление адреса клиенту</h2>
<form:form action="saveAddressToCustomer" method="post" modelAttribute="addressDto">
    <table>
        <tr>
            <td><input type="hidden" name="id" value="${idCustomer}"/></td>
        </tr>

        <tr>
            <td>Address</td>
        </tr>
        <tr>
            <td>City Name:</td>
            <td>
                <form:input path="cityName"/>
                <form:errors cssStyle="color: brown" path="cityName"/>
            </td>
        </tr>
        <tr>
            <td>Street Name:</td>
            <td>
                <form:input path="streetName"/>
                <form:errors cssStyle="color: brown" path="streetName"/>
            </td>
        </tr>
        <tr>
            <td>House Number:</td>
            <td>
                <form:input path="houseNumber"/>
                <form:errors cssStyle="color: brown" path="houseNumber"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Add"></td>
        </tr>

    </table>
</form:form>
</body>
</html>
