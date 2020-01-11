<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<p> test2 테이블의 데이터 조회하기</p>
<table>
    <thead>
        <tr>
            <th>testid</th>
            <th>testpw</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items = "${test2s}" var="test2">
            <tr>
                <td>${test2.testid}</td>
                <td>${test2.testpw}</td>
            </tr>
        </c:forEach>
    </tbody>

</table>