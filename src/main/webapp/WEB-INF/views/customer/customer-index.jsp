<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<body>
<sec:authorize access="hasRole('ADMIN')">
<br>
<br>
<h2>Поиск клиента по Име и Фамилии</h2>
<form action="/customers/search">
    <input type="text" name="name" placeholder="Введите имя"/>
    <input type="text" name="surname" placeholder="Введите фамилию"/>
    <input type="submit" value="Поиск">
</form>
<br>
<br>
</sec:authorize>
<div>
    <h2> All Customers</h2>
    <table border="1" cellpadding="5">
        <tr>
            <td>Имя:</td>
            <td>Фамилия:</td>
            <td>Возраст:</td>
            <td>Адрес:</td>
            <td>Изменить адрес:</td>
            <sec:authorize access="hasRole('ADMIN')">
            <td>Добавить адрес:</td>
            <td>Удалить клиента:</td>
            </sec:authorize>
        </tr>
        <c:forEach var="customer" items="${customerDtoList}">

        <c:url value="/customers/delete/" var="deleteURL">
            <c:param name="id" value="${customer.id}"/>
        </c:url>

        <c:url value="/customers/updateAddressToCustomer/" var="updateURL">
            <c:param name="id" value="${customer.id}"/>
        </c:url>

        <c:url value="/customers/addAddressToCustomer/" var="addURL">
            <c:param name="id" value="${customer.id}"/>
        </c:url>

        <tr>
            <td>${customer.name}</td>
            <td>${customer.surName}</td>
            <td>${customer.age}</td>
            <td>${customer.addressDto.cityName} ${customer.addressDto.streetName} ${customer.addressDto.houseNumber}</td>
            <td>
                <c:if test="${customer.addressDto != null}">
                    <a href="${updateURL}">Update address</a>
                </c:if>
            </td>
            <sec:authorize access="hasRole('ADMIN')">
            <td>
                <c:if test="${customer.addressDto == null}">
                    <a href="${addURL}">Add address</a>
                </c:if>
            </td>

            <td><a href="${deleteURL}">Delete</a></td>
            </sec:authorize>
        </tr>
        </c:forEach>
    </table>
</div>

<br>
<br>
<sec:authorize access="hasRole('ADMIN')">
    <form action="/customers/create">
        <input type="submit" value="Добавить нового клиента">
    </form>
</sec:authorize>
<br>
<br>

</body>
</html>