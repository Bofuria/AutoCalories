<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <spring:url value="/resources/css/bootstrap.min.css" var="mainCss" />
    <link href="${mainCss}" rel="stylesheet" />
    <spring:url value="/resources/css/style.css" var="styleCss" />
    <link href="${styleCss}" rel="stylesheet" />

    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <div class="container md-5">
        <div class="row">
            <div class="col-md-6 m-auto">
                <h3 class="text-center m-3">
                    Auto Calories Counter
                </h3>
            </div>
            <div class="form-group">
                <form action="addFoodItem" onsubmit="return validateForm()">
                    <label class="label form-label fs-4 fst-italic">Name</label>
                    <input type="text" name="name" id="search" class="form-control from-control-lg" placeholder="Enter food name..."><br>
                    <label class="label form-label fs-4 fst-italic">Weight</label>
                    <input type="number" name="weight" class="form-control from-control-lg" placeholder="Enter food weight..."  required><br>
                    <input value="Send" type="submit" class="btn btn-light btn-outline-secondary">
                    <a href="/history"><input value="Statistics" id="stats" type="button" class="btn btn-light btn-outline-secondary"></a>
                </form>

                <!-- <form action="getFoodItem">
                    <label>id</label>
                    <input type="text" name="id"><br>
                    <input type="submit"><br>
                </form> -->
            </div>
            <div class="mt-3" id="match-list"></div>
        </div>
    </div>
</body>
<script src="<spring:url value="/resources/js/list_of_food.js" />" defer="defer"></script>
<script src="<spring:url value="/resources/js/main.js" />" defer="defer"></script>
<script src="<spring:url value="/resources/js/validation.js" />" defer="defer"></script>

</html>