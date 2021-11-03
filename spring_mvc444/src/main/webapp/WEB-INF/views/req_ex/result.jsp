<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>
</head>
<body>

    <h1>랜덤 음식: ${f}</h1>
    <!-- <h2>전체 음식: ${foods}</h2> -->

    <!-- 반복문 이용 -->
    <!-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
        : JSTL라이브러리 = 자바의 반복문이나 조건문 같은거를 태그로 쓸 수 있게 해주는 라이브러리 -->
    <h2>전체 음식:
        <c:forEach var="fName" items="${foods}">
            <!-- 땡땡이 반복문임. -->
            <span>${fName}</span> 
            <!-- 이렇게 하면 span태그 5개 생김. -->
        </c:forEach>
    </h2>
    
    <h3>첫번째 음식: ${foods[0]}</h3>


</body>
</html>