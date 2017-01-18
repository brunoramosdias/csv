<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template" %>
<template:admin>
<jsp:attribute name="extraStyles">
</jsp:attribute>
    <jsp:attribute name="extraScripts">
<script src="<c:url value='/assets/js/pagination-script.js'/>"></script>

</jsp:attribute>
    <jsp:body>
        <div>
                <h2 class="basic-title">${country.name}</h2>
                <div class="well">
                    <table class="table table-condensed table-bordered table-striped table-hover">
                        <thead>
                        <tr>
                            <td>id</td>
                            <td>Name</td>
                            <td>Type</td>
                            <td>Continent</td>
                            <td>Runways by airport</td>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items='${country.airports}' var='object'>
                            <tr>
                                <td>${object.id}</td>
                                <td>${object.name}</td>
                                <td>${object.type}</td>
                                <td>${object.continent}</td>
                                <td><a href="<c:url value='/airport/query/country/'/>${country.code}/${object.id}">View runways</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
    </jsp:body>
</template:admin>