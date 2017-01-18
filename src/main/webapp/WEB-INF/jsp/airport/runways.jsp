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
                <h2 class="basic-title">${country.airports[0].name}</h2>
                <div class="well well-lg">
                    <table class="table table-condensed table-bordered table-striped table-hover">
                        <thead>
                        <tr>
                            <td>id</td>
                            <td>airport_ref</td>
                            <td>aiport_ident</td>
                            <td>length_ft</td>
                            <td>width_ft</td>
                            <td>surface</td>
                            <td>lighted</td>
                            <td>closed</td>
                            <td>le_ident</td>
                            <td>le_latitude_deg</td>
                            <td>le_longitude_deg</td>
                            <td>le_elevation_ft</td>
                            <td>le_heading_degT</td>
                            <td>le_displaced_threshold_ft</td>
                            <td>he_ident</td>
                            <td>he_latitude_deg</td>
                            <td>he_longitude_deg</td>
                            <td>he_elevation_ft</td>
                            <td>he_heading_degT</td>
                            <td>he_displaced_threshold_ft</td>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items='${country.airports[0].runways}' var='object'>
                            <tr>
                                <td>${object.id}</td>
                                <td>${object.airport_ref}</td>
                                <td>${object.airport_ident}</td>
                                <td>${object.length_ft}</td>
                                <td>${object.width_ft}</td>
                                <td>${object.surface}</td>
                                <td>${object.lighted}</td>
                                <td>${object.closed}</td>
                                <td>${object.le_ident}</td>
                                <td>${object.le_latitude_deg}</td>
                                <td>${object.le_longitude_deg}</td>
                                <td>${object.le_elevation_ft}</td>
                                <td>${object.le_heading_degT}</td>
                                <td>${object.le_displaced_threshold_ft}</td>
                                <td>${object.he_ident}</td>
                                <td>${object.he_latitude_deg}</td>
                                <td>${object.he_longitude_deg}</td>
                                <td>${object.he_elevation_ft}</td>
                                <td>${object.he_heading_degT}</td>
                                <td>${object.he_displaced_threshold_ft}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
        </div>
    </jsp:body>
</template:admin>