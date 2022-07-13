
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <spring:url value="/resources/css/bootstrap.min.css" var="mainCss" />
    <link href="${mainCss}" rel="stylesheet" />
    <spring:url value="/resources/css/style.css" var="style" />
    <link href="${style}" rel="stylesheet" />
    <meta charset="UTF-8">
    <title>History</title>
</head>

<body>
<div class="container mb-5 align-content-center">
    <a href="index"><input type="button" value="return to main page" class="btn btn-success mb-3 mt-3"></a>

    <div id="chartContainer" class="mb-3 mt-3" style="height: 370px; width: 100%;"></div>

<%--    <a><input id="update-btn" type="button" value="Update chart" class="btn btn-light mb-3 mt-3"></a>--%>

    <h2 id="table-header" class="h2">History table</h2>

    <table class="table table-dark table-striped table-hover mt-3">
        <thead class="table-header">
        <tr class="d-lg-table-row">
            <th>Name</th>
            <th>Weight</th>
            <th>Time</th>
            <th>Date</th>
            <th>Meal counter</th>
            <th>Total calories</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${food}" var="foodItem">
            <tr>
                <td>${foodItem.name}</td>
                <td>${foodItem.weight}</td>
                <td>${foodItem.time}</td>
                <td>${foodItem.date}</td>
                <td>${foodItem.mealCount}</td>
                <td>${foodItem.dayCaloriesValue}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script type="text/javascript">

    let chart;
    window.onload = function() {
            chart = new CanvasJS.Chart("chartContainer", {
            theme: "dark2",
            animationEnabled: true,
            exportEnabled: true,
            title: {
                text: "Calories eaten per day"
            },
            data: [{
                type: "column", //change type to bar, line, area, pie, etc
                dataPoints: ${chart}
            }],
            axisX:{
                reversed:  true
            }
        });
        chart.render();
    }

    <%--document.getElementById('update-btn').addEventListener('click', () => {--%>
    <%--    chart = new CanvasJS.Chart("chartContainer", {--%>
    <%--        theme: "dark2",--%>
    <%--        animationEnabled: true,--%>
    <%--        exportEnabled: true,--%>
    <%--        title: {--%>
    <%--            text: "Calories eaten per day"--%>
    <%--        },--%>
    <%--        data: [{--%>
    <%--            type: "column", //change type to bar, line, area, pie, etc--%>
    <%--            dataPoints: ${chart}--%>
    <%--        }],--%>
    <%--        axisX:{--%>
    <%--            reversed:  true--%>
    <%--        }--%>
    <%--    });--%>
    <%--    chart.render();--%>
    <%--})--%>

</script>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
</html>