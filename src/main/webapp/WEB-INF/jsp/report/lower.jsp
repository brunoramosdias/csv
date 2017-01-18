<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template" %>
<template:admin>
<jsp:attribute name="extraStyles">
</jsp:attribute>
    <jsp:attribute name="extraScripts">
<script src="<c:url value='/assets/js/pagination-lower-script.js'/>"></script>

</jsp:attribute>
    <jsp:body>
        <div>
            <div class ="container">
                <h2 class="basic-title">Ten countrys with the least airports</h2>
                <div class="well">
                    <table class="table table-condensed table-bordered table-striped table-hover">
                        <thead>
                        <tr>
                            <td>Counrty id</td>
                            <td>Country name</td>
                            <td>Country code</td>
                            <td>Number of  airports</td>
                            <td>View airports</td>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items='${countries}' var='object'>
                            <tr>
                                <td>${object.id}</td>
                                <td>${object.name}</td>
                                <td>${object.code}</td>
                                <td>${object.airportCount}</td>
                                <td><a href="<c:url value='/airport/query/country/'/>${object.code}">View airports</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </jsp:body>
</template:admin>