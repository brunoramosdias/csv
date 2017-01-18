<%--
  Created by IntelliJ IDEA.
  User: brunoramosdias
  Date: 29/12/16
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template" %>
<template:admin>
<jsp:attribute name="extraStyles">
<link rel="stylesheet" href="<c:url value='/assets/css/pagination/jqpagination.css'/>" />
</jsp:attribute>
    <jsp:attribute name="extraScripts">
<script src="<c:url value='/assets/js/jquery.jqpagination.js'/>"></script>
</jsp:attribute>
    <jsp:body>
        <div>
            <div class ="container min-container">
                <h2 class="basic-title">Reports </h2>
                <div class="well">
                    <a href="<c:url value='/airport/reports/top'/>" class="btn btn-success"><span class="glyphicon glyphicon-print"></span> Countries with most airports</a>
                    <a href="<c:url value='/airport/reports/lower'/>" class="btn btn-success"><span class="glyphicon glyphicon-print"></span> Countries with less airports</a>
                </div>
            </div>
        </div>
    </jsp:body>
</template:admin>
