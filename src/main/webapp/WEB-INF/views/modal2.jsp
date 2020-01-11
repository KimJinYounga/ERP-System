<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>DB Modal</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="Lingua project">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/styles/bootstrap4/bootstrap.min.css">
    <link
            href="${pageContext.request.contextPath}/resources/plugins/font-awesome-4.7.0/css/font-awesome.min.css"
            rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/plugins/OwlCarousel2-2.2.1/owl.carousel.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/plugins/OwlCarousel2-2.2.1/animate.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/styles/main_styles.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/styles/responsive.css">
    <script>
        document.getElementsByTagName("html")[0].className += " js";
    </script>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/timet_assets/css/common.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/timet_assets/css/style.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/timet_assets/css/container.table.css">

    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/timet_assets/css/subjects.css">
    <script
            src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<div class="row">
    <div class="col text-center">
        <button type="submit" class="form_button trans_200">수업
            목록</button>
        <button id="myBtn" type="submit" class="form_button trans_200">과목
            추가</button>
        <br>
        <form action="/classmanagement/registclass" method="POST"
              accept-charset="UTF-8" id="customsubjects"
              style="display: none; left: 317.333px;">
            <a title="닫기" class="close"></a>
            <h2>새 수업</h2>
            <dl>
                <dt>과목명</dt>
                <dd>
                    <input type="text" placeholder="예) 경제학입문" maxlength="40"
                           class="text" name="sub_Name" />
                </dd>
                <dt>교수명</dt>
                <dd>
                    <input type="text" placeholder="예) 홍길동" maxlength="40"
                           class="text" name="sub_Pfname" />
                </dd>
                <dt>시간/장소</dt>
                <dd class="timeplaces">
                    <input type="hidden" value="월" name="lec_Day" id="lec_Day" />
                    <div class="timeplace">
                        <ol class="weeks">
                            <li class="active">월</li>
                            <li>화</li>
                            <li>수</li>
                            <li>목</li>
                            <li>금</li>
                        </ol>
                        <p>
                            <select name="lec_Start" class="starthour"
                                    id="start_hour">
                                <option value="09" selected="selected">09</option>
                                <option value="10">10</option>
                                <option value="11">11</option>
                                <option value="12">12</option>
                                <option value="13">13</option>
                                <option value="14">14</option>
                                <option value="15">15</option>
                                <option value="16">16</option>
                                <option value="17">17</option>
                                <option value="18">18</option>
                            </select> <select name="lec_stm" class="startminute"
                                              id="start_min">
                            <option value="00">00</option>
                            <option value="05">05</option>
                            <option value="10">10</option>
                            <option value="15">15</option>
                            <option value="20">20</option>
                            <option value="25">25</option>
                            <option value="30">30</option>
                            <option value="35">35</option>
                            <option value="40">40</option>
                            <option value="45">45</option>
                            <option value="50">50</option>
                            <option value="55">55</option>
                        </select> <span>~</span> <select name="lec_End" class="endhour"
                                                         id="end_hour">
                            <option value="09" selected="selected">09</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                            <option value="13">13</option>
                            <option value="14">14</option>
                            <option value="15">15</option>
                            <option value="16">16</option>
                            <option value="17">17</option>
                            <option value="18">18</option>
                        </select> <select name="lec_enm" class="endminute" id="end_min">
                            <option value="00">00</option>
                            <option value="05">05</option>
                            <option value="10">10</option>
                            <option value="15">15</option>
                            <option value="20">20</option>
                            <option value="25">25</option>
                            <option value="30">30</option>
                            <option value="35">35</option>
                            <option value="40">40</option>
                            <option value="45">45</option>
                            <option value="50">50</option>
                            <option value="55">55</option>
                        </select> <input type="text" placeholder="예) 종303"
                                         class="text place" name="lec_Location" />
                        </p>
                    </div>
                    <a class="new"><strong>+</strong>더 입력</a>
                </dd>
            </dl>
            <div class="clearBothOnly"></div>
            <div class="submit">
                <input type="submit" value="저장" class="button">
            </div>
        </form>
    </div>
</div>
    <script type="text/javascript">
        var modal = document.getElementById('customsubjects');
        var btn = document.getElementById("myBtn");
        btn.onclick = function() {
            modal.style.display = "block";
        }
    </script>
</html>
--%>

<div class="container">

    <h2>모달</h2>

    <!-- 버튼 -->
    <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" >
        Launch demo modal
    </button>

    <!-- 모달 팝업 -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                </div>
                <div class="modal-body">
                    ...
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </div>
    </div>

</div>