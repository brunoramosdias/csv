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
            <div class ="container">
                <h2 class="basic-title">Query For Country Airports</h2>
                <div class="well">
                    <form role="form" class="well" action="<c:url value='/airport/query/country'/>" method="POST">
                        <div class="form-group">
                            <label for="inputdefault">Enter Country Name or Code</label>
                            <input name="partialCountry" class="form-control" id="inputdefault" type="text">
                        </div>
                        <button type="submit" class="btn btn-primary">search <span class="glyphicon glyphicon-search"></span></button>
                    </form>
                    <table class="table table-condensed table-bordered table-striped table-hover">
                        <thead>
                        <tr>
                            <td>Counrty id</td>
                            <td>Country name</td>
                            <td>Country code</td>
                            <td>View airports</td>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items='${countries}' var='object'>
                            <tr>
                                <td>${object.id}</td>
                                <td>${object.name}</td>
                                <td>${object.code}</td>
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