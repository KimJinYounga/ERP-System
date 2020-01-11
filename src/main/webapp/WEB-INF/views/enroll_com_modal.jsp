<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <script type="text/javascript"
            src="http://code.jquery.com/jquery-latest.js"></script>

    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Charts</title>

    <!-- Custom fonts for this template-->
    <link href="${pageContext.request.contextPath}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
          type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
          rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${pageContext.request.contextPath}/resources/css/sb-admin-2.min.css" rel="stylesheet">

    <style>
        .topbar {
            margin-right: -550px;
        }

        .card {
            border: none;
        }

        #customsubjects {
            box-shadow: none;
        }

        #selectable .ui-selecting {background: #FECA40;}
        #selectable .ui-selected {background: #F39814; color:white;}


    </style>
</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

        <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
            <div class="sidebar-brand-icon rotate-n-15">
                <i class="fas fa-laugh-wink"></i>
            </div>
            <div class="sidebar-brand-text mx-3">(주)FC 대승</div>
        </a>

        <!-- Divider -->
        <hr class="sidebar-divider my-0">

        <!-- Nav Item - Dashboard -->


        <!-- Divider -->
        <hr class="sidebar-divider">

        <!-- Heading -->
        <div class="sidebar-heading">
            Interface
        </div>

        <!-- Nav Item - Pages Collapse Menu -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
               aria-expanded="true" aria-controls="collapseTwo">
                <i class="fas fa-fw fa-cog"></i>
                <span>거래처</span>
            </a>
            <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <h6 class="collapse-header">Custom Components:</h6>
                    <a class="collapse-item" href="buttons.html">거래처 조회</a>
                    <a class="collapse-item" href="cards.html">거래처 등록</a>
                </div>
            </div>
        </li>

        <hr class="sidebar-divider">

        <!-- Nav Item - Utilities Collapse Menu -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
               aria-expanded="true" aria-controls="collapseUtilities">
                <i class="fas fa-fw fa-wrench"></i>
                <span>자재</span>
            </a>
            <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
                 data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <h6 class="collapse-header">Custom Utilities:</h6>
                    <a class="collapse-item" href="utilities-color.html">자재 조회</a>
                    <a class="collapse-item" href="utilities-border.html">자재 등록</a>
                </div>
            </div>
        </li>

        <hr class="sidebar-divider">

        <li class="nav-item">
            <a class="nav-link" href="index.html">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span>결제 대금</span></a>
        </li>

        <!-- Divider -->




        <!-- Divider -->
        <hr class="sidebar-divider d-none d-md-block">

        <!-- Sidebar Toggler (Sidebar) -->
        <div class="text-center d-none d-md-inline">
            <button class="rounded-circle border-0" id="sidebarToggle"></button>
        </div>

    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">
            <!-- Topbar -->
            <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                <!-- Sidebar Toggle (Topbar) -->
                <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                    <i class="fa fa-bars"></i>
                </button>

                <!-- Topbar Search -->
                <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                    <div class="input-group">
                        <h6 class="m-0 font-weight-bold text-primary">거래처 등록 & 조회</h6>
                    </div>
                </form>

                <div onclick="reset();" style="float:right; margin-top:0.5rem;  ">
                    <div style="float:right;" align="right">
                        <a href="#" class="btn btn-primary btn-sm" style="float:right;margin-right:1rem; width:75px;">
                            <span class="text">초기화</span>
                        </a>
                    </div>
                </div>

                <div onclick="list();" ; style="float:right; margin-top:0.5rem;">
                    <div style="float:right;" align="right">
                        <a href="#" class="btn btn-primary btn-sm" style="float:right;margin-right:1rem; width:75px;">
                            <span class="text">목록</span>
                        </a>
                    </div>
                </div>


                <div id="whghl" ; onclick="research();" ; style="float:right; margin-top:0.5rem;  ">
                    <div style="float:right;" align="right">
                        <a href="#" class="btn btn-primary btn-sm" style="float:right;margin-right:1rem; width:75px;">
                            <span class="text" color="white">조회</span>
                        </a>
                    </div>
                </div>
                <div style="float:right; margin-top:0.5rem;  ">
                    <div style="oat:right;" align="right">
                        <a href="#" class="btn btn-primary btn-sm" style="float:right;margin-right:1rem; width:75px;">
                            <span class="text">저장</span>
                        </a>
                    </div>
                </div>
                <div style="float:right; margin-top:0.5rem;  ">
                    <div style="oat:right;" align="right">
                        <a href="trans" class="btn btn-primary btn-sm"
                           style="float:right;margin-right:1rem; width:75px;">
                            <span class="text">삭제</span>
                        </a>
                    </div>
                </div>

                <!-- Topbar Navbar -->
                <ul class="navbar-nav ml-auto">

                    <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                    <li class="nav-item dropdown no-arrow d-sm-none">
                        <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-search fa-fw"></i>
                        </a>
                        <!-- Dropdown - Messages -->
                        <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                             aria-labelledby="searchDropdown">
                            <form class="form-inline mr-auto w-100 navbar-search">
                                <div class="input-group">
                                    <input type="text" class="form-control bg-light border-0 small"
                                           placeholder="Search for..." aria-label="Search"
                                           aria-describedby="basic-addon2">
                                    <div class="input-group-append">
                                        <button class="btn btn-primary" type="button">
                                            <i class="fas fa-search fa-sm"></i>
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </li>

                    <!-- Nav Item - Alerts -->


                    <!-- Nav Item - Messages -->


                    <div class="topbar-divider d-none d-sm-block"></div>

                    <!-- Nav Item - User Information -->


                </ul>

            </nav>
            <!-- End of Topbar -->
            <script type="text/JavaScript" src="http://code.jquery.com/jquery-1.7.min.js"></script>

            <script>
                function reset() {
                    alert("reset버튼을 누르셨습니다.");
                }

                function list() {
                    location.href = "${pageContext.request.contextPath}/accLists";
                }

                function research() {
                    var acc_code = $('#acc_code').val();
                    var acc_name = $('#acc_name').val();
                    var material_name = $('#material_name').val();
                    var acc_type = $('#acc_type').val();
                    var owner_type = $('#owner_type').val();
                    var owner_code = $('#owner_code').val();
                    location.href = "${pageContext.request.contextPath}/acc_code=" + acc_code + "&acc_name=" + acc_name + "&acc_type=" + acc_type + "&material_name="
                        + material_name + "&owner_code=" + owner_code + "&owner_type=" + owner_type;
                }
            </script>

            <!-- Begin Page Content -->
            <div class="container-fluid"  style="position:relative;">
                <!-- Page Heading -->
                <!-- 검색할 수 있는 공간-->
                <div class="form-inline mr-auto w-100 navbar-search"
                     style=" margin-top:-15px; margin-bottom:0.5rem;padding-right:0.75rem; padding-top:0.75rem; padding-bottom:0.75rem;">
                    <div class="input-group" style=" align-content:center">
                        <label style="margin: 0 0.75rem; margin-right:5px;">거래처코드</label>
                        <input type="text" id="acc_code" class="form-control small" aria-label="Search"
                               aria-describedby="basic-addon2"
                               style="background-color:white; border-bottom-left-radius:5px; border-top-left-radius:5px;">
                    </div>
                    <div class="input-group" style=" align-content:center; margin-left:15px;">
                        <label style="margin: 0 0.75rem; margin-right:5px;">거래처명</label>
                        <input type="text" id="acc_name" class="form-control small" aria-label="Search"
                               aria-describedby="basic-addon2"
                               style="background-color:white; border-bottom-left-radius:5px; border-top-left-radius:5px;">
                    </div>
                    <div class="input-group" style=" align-content:center; margin-left:15px;">
                        <label style="margin: 0 0.75rem; margin-right:5px;">자재</label>
                        <input type="text" id="material_name" class="form-control small" aria-label="Search"
                               aria-describedby="basic-addon2"
                               style="background-color:white; border-bottom-left-radius:5px; border-top-left-radius:5px;">
                    </div>
                    <div class="input-group" style=" align-content:center; margin-left:15px;">
                        <label style="margin: 0 0.75rem; margin-right:5px;">거래처구분</label>
                        <%--                    <input type="text" class="form-control small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2" style="background-color:white;">--%>
                        <select id="acc_type" style="height:30px; border-radius: 5px;">
                            <option value="" selected disabled hidden>==선택하세요==</option>
                            <option value="매출">매출</option>
                            <option value="매입">매입</option>
                            <option value="혼합">혼합</option>
                        </select>
                    </div>
                </div>
                <div class="form-inline mr-auto w-100 navbar-search"
                     style=" margin-top:-20px; margin-bottom:0.5rem;padding-right:0.75rem; padding-top:0.75rem; padding-bottom:0.75rem;">

                    <div class="input-group" style=" align-content:center;">
                        <label style="margin: 0 0.75rem; margin-right:5px;">사업자유형</label>
                        <%--                    <input type="text" class="form-control small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2" style="background-color:white;">--%>
                        <select id="owner_type" style="height:30px; border-radius: 5px;">
                            <option value="" selected disabled hidden>==선택하세요==</option>
                            <option value="일반사업자">일반사업자</option>
                            <option value="간이사업자">간이사업자</option>
                            <option value="면세사업자">면세사업자</option>
                        </select>

                    </div>
                    <div class="input-group" style=" align-content:center; margin-left:15px;">
                        <label style="margin: 0 0.75rem; margin-right:5px;">사업자등록번호</label>
                        <input type="text" id="owner_code" class="form-control small" aria-label="Search"
                               aria-describedby="basic-addon2"
                               style="background-color:white; border-bottom-left-radius:5px; border-top-left-radius:5px;">
                    </div>

                </div>
            </div>

            <div id="myModal" role="dialog" style="position:relative;">
                <div class="modal-dialog modal-lg">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">거래처 담당자 검색</h4>
                            <button type="button" class="close" id="modalclose">&times;</button>

                        </div>
                        <div class="modal-body">
                            이름 : <input type="text" placeholder="예) 홍길동" maxlength="40"
                                        class="text" id="first" name="first"/>
                            &nbsp; &nbsp; 담당 회사 : <input type="text" placeholder="예) Company"
                                                         maxlength="40"
                                                         class="text" id="second" name="second"/>

                            <a href="#" role="button" class="btn btn-primary btn-sm"
                               style="float:right;margin-right:1rem; width:75px;"
                               title="Popover title"
                               data-content="Popover body content is set in this attribute."
                               id="myBtn">검색</a>


                            <div class="card shadow mb-4" id="customsubjects">
                                <hr>
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table class="table table-bordered" id="" width="100%"
                                               cellspacing="0">
                                            <thead>
                                            <tr>
                                                <th>No</th>
                                                <th>담당자</th>
                                                <th>전화번호</th>
                                                <th>이메일</th>
                                                <th>담당브랜드</th>
                                            </tr>
                                            </thead>


                                            <%--                                                            <script>--%>
                                            <%--                                                                var modal = document.getElementById('customsubjects');--%>
                                            <%--                                                                var btn = document.getElementById("myBtn");--%>
                                            <%--                                                                var action='';--%>
                                            <%--                                                                var url='';--%>
                                            <%--                                                                var type='';--%>
                                            <%--                                                                var res = new Object();--%>
                                            <%--                                                                $(document).ready(function() {--%>
                                            <%--                                                                    $('#myBtn').click(function() {--%>
                                            <%--                                                                        // action='search';--%>
                                            <%--                                                                        type='POST';--%>
                                            <%--                                                                        $.ajax({--%>
                                            <%--                                                                            url : '/PTBsearch',--%>
                                            <%--                                                                            type : type,--%>
                                            <%--                                                                            data : $('#search').serialize(),--%>
                                            <%--                                                                            refresh : true,--%>
                                            <%--                                                                            success: function (result) {--%>
                                            <%--                                                                                console.log(result+"성공!");--%>
                                            <%--                                                                                res = result;--%>
                                            <%--                                                                                console.log("reload");--%>
                                            <%--                                                                                console.log(${accountPTB});--%>




                                            <%--                                                                            }--%>

                                            <%--                                                                        });--%>
                                            <%--                                                                        // location.reload();--%>
                                            <%--                                                                        modal.style.display = "block";--%>
                                            <%--                                                                        console.log("reload");--%>
                                            <%--                                                                        console.log(${accountPTB});--%>



                                            <%--                                                                    })--%>
                                            <%--                                                                })--%>



                                            <%--                                                            </script>--%>
                                            <tbody id="tableId">


                                            <c:forEach var="board" varStatus="status" items="${accountPTB}">
                                                <script type="text/javascript">
                                                    var E;

                                                    function PTBsave() {
                                                        url = "${pageContext.request.contextPath}/PTBAdd/"+E;
                                                        location.href = url;
                                                    }

                                                    function ChangeBackground(element,act) {

                                                        if (act == 'click') {
                                                            if (element.flag!= 'clicked') {
                                                                element.flag = 'clicked';
                                                                element.style.backgroundColor = '#4e73df';
                                                                element.style.color="white";
                                                                E=element.id;
                                                            } else {
                                                                element.flag = '';
                                                                element.style.backgroundColor = '#ffffff';
                                                                element.style.color="#858796";
                                                            }
                                                        }

                                                        if (act == 'out') {
                                                            if (element.flag!= 'clicked') {
                                                                element.style.backgroundColor = '#FFFFFF';
                                                                element.style.color="#858796";
                                                            } else {
                                                                element.style.backgroundColor = '#4e73df';
                                                                element.style.color="white";
                                                            }
                                                        }

                                                        if (act == 'over') {
                                                            if (element.flag!= 'clicked') {
                                                                element.style.backgroundColor = '#4e73df';
                                                                element.style.color="white";
                                                            } else {
                                                                element.style.backgroundColor = '#4e73df';
                                                                element.style.color="white";
                                                            }
                                                        }
                                                    }
                                                    function clickEvent(obj) {
                                                        // var table = document.getElementId("tableId");
                                                        // var tr = table.getElementsByTagName("tr");
                                                        // for(var i=0; i<tr.length; i++){
                                                        //     tr[i].style.background = "#FFFFFF";
                                                        // }
                                                        obj.style.backgroundColor = "#4e73df";
                                                        alert(obj.id);
                                                        // if (obj.style.backgroundColor=="#4e73df"){
                                                        //     obj.style.backgroundColor="white";
                                                        // }

                                                    }
                                                    // function changeTrColor(trObj, oldColor, newColor) {
                                                    //     trObj.style.backgroundColor = newColor;
                                                    //     trObj.onmouseout = function(){
                                                    //         trObj.style.backgroundColor = oldColor;
                                                    //     }
                                                    // }
                                                    //
                                                    // function clickTrEvent(trObj) {
                                                    //     trObj.style.backgroundColor='#4e73df';
                                                    //     alert(trObj.id);
                                                    // }
                                                </script>

<%--                                                <tr id="firstRow" onclick="javascript:clickTrEvent(this)"--%>
<%--                                                    onmouseover="javascript:changeTrColor(this, '#FFFFFF', '#F4FFFD')"--%>
<%--                                                    style="cursor:hand">--%>
<%--                                                <tr id="${board}" onclick="javascript:clickEvent(this)">--%>
                                                <tr id="${board.ptbName}" onclick="ChangeBackground(this,'click');">
                                                    <td><c:out value="${status.count}"/></td>
                                                    <td><c:out value="${board.ptbName}"/></td>
                                                    <td><c:out value="${board.ptbPhone}"/></td>
                                                    <td><c:out value="${board.ptbEmail}"/></td>
                                                    <td><c:out value="${board.ptbBrand}"/></td>
                                                </tr>
                                            </c:forEach>

                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-primary" onclick="PTBsave();">Save
                            </button>
                        </div>
                    </div>

                </div>
            </div>

            <!-- Content Row -->
            <div class="row"   style="position:relative;">
                <!-- 거래처 목록 -->
                <div class="col-xl-4 col-lg-5">
                    <div class="card shadow mb-4">
                        <!-- Card Header - Dropdown -->
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">거래처 목록</h6>

                        </div>
                        <!-- Card Body -->
                        <div class="card-body" style="overflow:auto; height:700px;">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0"
                                       style="font-size:10px;">
                                    <thead>
                                    <tr>
                                        <th>NO</th>
                                        <th>거래처코드</th>
                                        <th>거래처명</th>
                                        <th>약어명</th>
                                        <th>전화번호</th>
                                        <th>거래처구분</th>
                                    </tr>
                                    </thead>

                                    <tbody>
                                    <c:forEach varStatus="status" var="list" items="${accountLists}">
                                        <tr>
                                            <td><c:out value="${status.count}"/></td>
                                            <td>${list.accCode}</td>
                                            <td><a href="#" class="detailAcc" id="${list.accCode}">${list.accName}</a>
                                            </td>
                                            <td>${list.accSimple}</td>
                                            <td>${list.accPhone}</td>
                                            <td>${list.accType}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                                <script>
                                    $(".detailAcc").click(function () {
                                        var accCode = $(this).attr('id');
                                        url = "${pageContext.request.contextPath}/account";
                                        url = url + "/" + accCode;
                                        location.href = url;
                                    })
                                </script>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-xl-8 col-lg-7">
                    <!-- 거래서 정보 수정  -->
                    <form action="/accDetailCheck/${accDetail.accCode}" method="POST"
                          accept-charset="UTF-8" id="accDetailId">
                        <div class="card shadow mb-4">
                            <div style="display:inherit;" class="card-header py-3">
                                <h6 style="width:300px;" class="m-0 font-weight-bold text-primary">거래처 정보</h6>
                                <div style="float:right; width:100%; margin-top:0.5rem;  ">
                                    <div style="width:100%;float:right;" align="right">
                                        <%--                                        <a href="#"  class="btn btn-primary btn-sm"--%>
                                        <%--                                           style="float:right;margin-right:1rem; width:75px;">--%>
                                        <button class="btn btn-primary btn-sm"
                                                style="float:right;margin-right:1rem; width:75px;" type="submit">저장</button>


                                        <%--                                        </a>--%>
                                    </div>
                                </div>
                            </div>


                            <%--                        액션 줄 차례!!!!!!!!!--%>

                            <div class="card-body">
                                <div class="form-inline mr-auto navbar-search"
                                     style="float:left; width:50%;margin-top:0.75rem;padding:0.75rem;">
                                    <div class="input-group" style=" margin-bottom:0.74rem;">
                                        <label style=" text-align:right;width:100px; margin: 0 0.75rem;">거래처구분</label>
                                        <select name="accType">
                                            <option value="${accDetail.accType}" name="accType">${accDetail.accType}</option>
                                            <option value="매출">매출</option>
                                            <option value="매입">매입</option>
                                            <option value="혼합">혼합</option>
                                        </select>
                                        <%--                                    <input type="text" class="form-control small" aria-describedby="basic-addon2" style="margin-right:2rem;background-color:white;border: 1px solid #e3e6f0;" value="${accDetail.accType}">--%>
                                    </div>
                                    <div class="input-group" style=" margin-bottom:0.74rem;">
                                        <label style=" text-align:right;width:100px; margin: 0 0.75rem;">거래처명</label>
                                        <input type="text" class="form-control small" aria-describedby="basic-addon2"
                                               style="margin-right:2rem;background-color:white;border: 1px solid #e3e6f0;"
                                               value="${accDetail.accName}" name="accName">
                                    </div>
                                    <div class="input-group" style=" margin-bottom:0.74rem;">
                                        <label style=" text-align:right;width:100px; margin: 0 0.75rem;">사업자코드</label>
                                        <input type="text" class="form-control small" aria-describedby="basic-addon2"
                                               style="margin-right:2rem;background-color:white;border: 1px solid #e3e6f0;"
                                               value="${accDetail.ownerCode}" name="ownerCode">
                                    </div>
                                    <div class="input-group" style=" margin-bottom:0.74rem;">
                                        <label style=" text-align:right;width:100px; margin: 0 0.75rem;">예금주</label>
                                        <input type="text" class="form-control small" aria-describedby="basic-addon2"
                                               style="margin-right:2rem;background-color:white;border: 1px solid #e3e6f0;"
                                               value="${accDetail.accAccHolder}" name="accAccHolder">
                                    </div>
                                    <div class="input-group" style=" margin-bottom:0.74rem;">
                                        <label style=" text-align:right;width:100px; margin: 0 0.75rem;">계좌번호</label>
                                        <input type="text" class="form-control small" aria-describedby="basic-addon2"
                                               style="margin-right:2rem;background-color:white;border: 1px solid #e3e6f0;"
                                               value="${accDetail.accAccNumber}" name="accAccNumber">
                                    </div>


                                </div>
                                <div class="form-inline mr-auto navbar-search"
                                     style="float:left; width:50%;margin-top:0.75rem;padding:0.75rem;">
                                    <div class="input-group" style=" margin-bottom:0.74rem;">
                                        <label style=" text-align:right;width:130px; margin: 0 0.75rem;">거래처코드</label>
                                        <input type="text" class="form-control small" aria-describedby="basic-addon2"
                                               style="margin-right:2rem;background-color:white;border: 1px solid #e3e6f0;"
                                               value="${accDetail.accCode}" disabled name="accCode">
                                    </div>
                                    <div class="input-group" style=" margin-bottom:0.74rem;">
                                        <label style=" text-align:right;width:130px; margin: 0 0.75rem;">거래처약어명</label>
                                        <input type="text" class="form-control small" aria-describedby="basic-addon2"
                                               style="margin-right:2rem;background-color:white;border: 1px solid #e3e6f0;"
                                               value="${accDetail.accSimple}" name="accSimple">
                                    </div>
                                    <%--                                <div class="input-group" style=" margin-bottom:0.74rem;">--%>
                                    <%--                                    <label style=" text-align:right;width:130px; margin: 0 0.75rem;">사업자등록번호</label>--%>
                                    <%--                                    <input type="text" class="form-control small" aria-describedby="basic-addon2" style="margin-right:2rem;background-color:white;border: 1px solid #e3e6f0;" value="${accDetail.accSimple}">--%>
                                    <%--                                </div>--%>
                                    <div class="input-group" style=" margin-bottom:0.74rem;">
                                        <label style=" text-align:right;width:130px; margin: 0 0.75rem;">거래처전화번호</label>
                                        <input type="text" class="form-control small" aria-describedby="basic-addon2"
                                               style="margin-right:2rem;background-color:white;border: 1px solid #e3e6f0;"
                                               value="${accDetail.accPhone}" name="accPhone">
                                    </div>
                                    <div class="input-group" style=" margin-bottom:0.74rem;">
                                        <label style=" text-align:right;width:130px; margin: 0 0.75rem;">E-mail</label>
                                        <input type="text" class="form-control small" aria-describedby="basic-addon2"
                                               style="margin-right:2rem;background-color:white;border: 1px solid #e3e6f0;"
                                               value="${accDetail.accEmail}" name="accEmail">
                                    </div>
                                    <div class="input-group" style=" margin-bottom:0.74rem;">
                                        <label style=" text-align:right;width:130px; margin: 0 0.75rem;">우편번호</label>
                                        <input id="sample2_postcode" type="text" class="form-control small"
                                               aria-describedby="basic-addon2"
                                               style="margin-right:2rem;background-color:white;border: 1px solid #e3e6f0;" >

                                        <%--                                    <input type="button" onclick="sample2_execDaumPostcode()" value="주소검색"><br>--%>
                                        <div style="float:right;  margin-top:0.5rem;  ">
                                            <div style="float:right;" align="right">
                                                <a href="#" onclick="sample2_execDaumPostcode()"
                                                   class="btn btn-primary btn-sm"
                                                   style="float:right;margin-right:1rem; width:75px;">
                                                    <span class="text">주소검색</span>
                                                </a>
                                            </div>
                                        </div>

                                        <!-- iOS에서는 position:fixed 버그가 있음, 적용하는 사이트에 맞게 position:absolute 등을 이용하여 top,left값 조정 필요 -->

                                    </div>

                                    <div class="input-group" style=" margin-bottom:0.74rem;">
                                        <label style=" text-align:right;width:130px; margin: 0 0.75rem;">주소</label>
                                        <input id="sample2_address" type="text" class="form-control small"
                                               aria-describedby="basic-addon2"
                                               style="margin-right:2rem;background-color:white;border: 1px solid #e3e6f0;" value="${accDetail.accAddress}" name="accAddress">
                                    </div>

                                    <div class="input-group" style=" margin-bottom:0.74rem;">
                                        <label style=" text-align:right;width:130px; margin: 0 0.75rem;">상세주소</label>

                                        <input id="sample2_detailAddress" type="text" class="form-control small"
                                               aria-describedby="basic-addon2"
                                               style="margin-right:2rem;background-color:white;border: 1px solid #e3e6f0;">
                                    </div>


                                    <div id="layer"
                                         style="display:none;position:fixed;overflow:hidden;z-index:1;-webkit-overflow-scrolling:touch;">
                                        <img src="//t1.daumcdn.net/postcode/resource/images/close.png"
                                             id="btnCloseLayer"
                                             style="cursor:pointer;position:absolute;right:-3px;top:-3px;z-index:1"
                                             onclick="closeDaumPostcode()" alt="닫기 버튼">
                                    </div>

                                    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
                                    <script>
                                        // 우편번호 찾기 화면을 넣을 element
                                        var element_layer = document.getElementById('layer');

                                        function closeDaumPostcode() {
                                            // iframe을 넣은 element를 안보이게 한다.
                                            element_layer.style.display = 'none';
                                        }

                                        function sample2_execDaumPostcode() {
                                            new daum.Postcode({
                                                oncomplete: function (data) {
                                                    // 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                                                    // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                                                    // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                                                    var addr = ''; // 주소 변수
                                                    var extraAddr = ''; // 참고항목 변수

                                                    //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                                                    if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                                                        addr = data.roadAddress;
                                                        console.log("도로명 주소 clicked!");
                                                    } else { // 사용자가 지번 주소를 선택했을 경우(J)
                                                        addr = data.jibunAddress;
                                                        console.log("지번 주소 clicked!");
                                                    }

                                                    // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                                                    if (data.userSelectedType === 'R') {
                                                        // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                                                        // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                                                        console.log("data.bame=");
                                                        console.log(data.bname);
                                                        if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
                                                            extraAddr += data.bname;
                                                        }
                                                        // 건물명이 있고, 공동주택일 경우 추가한다.
                                                        if (data.buildingName !== '' && data.apartment === 'Y') {
                                                            extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                                                        }
                                                        // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                                                        if (extraAddr !== '') {
                                                            extraAddr = ' (' + extraAddr + ')';
                                                        }
                                                        console.log("extraAddr");
                                                        console.log(extraAddr);

                                                    }

                                                    // 우편번호와 주소 정보를 해당 필드에 넣는다.
                                                    document.getElementById('sample2_postcode').value = data.zonecode;
                                                    document.getElementById("sample2_address").value = addr;
                                                    // 커서를 상세주소 필드로 이동한다.
                                                    document.getElementById("sample2_detailAddress").focus();

                                                    // iframe을 넣은 element를 안보이게 한다.
                                                    // (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
                                                    element_layer.style.display = 'none';
                                                },
                                                width: '100%',
                                                height: '100%',
                                                maxSuggestItems: 5
                                            }).embed(element_layer);

                                            // iframe을 넣은 element를 보이게 한다.
                                            element_layer.style.display = 'block';

                                            // iframe을 넣은 element의 위치를 화면의 가운데로 이동시킨다.
                                            initLayerPosition();
                                        }

                                        // 브라우저의 크기 변경에 따라 레이어를 가운데로 이동시키고자 하실때에는
                                        // resize이벤트나, orientationchange이벤트를 이용하여 값이 변경될때마다 아래 함수를 실행 시켜 주시거나,
                                        // 직접 element_layer의 top,left값을 수정해 주시면 됩니다.
                                        function initLayerPosition() {
                                            var width = 300; //우편번호서비스가 들어갈 element의 width
                                            var height = 400; //우편번호서비스가 들어갈 element의 height
                                            var borderWidth = 5; //샘플에서 사용하는 border의 두께

                                            // 위에서 선언한 값들을 실제 element에 넣는다.
                                            element_layer.style.width = width + 'px';
                                            element_layer.style.height = height + 'px';
                                            element_layer.style.border = borderWidth + 'px solid';
                                            // 실행되는 순간의 화면 너비와 높이 값을 가져와서 중앙에 뜰 수 있도록 위치를 계산한다.
                                            element_layer.style.left = (((window.innerWidth || document.documentElement.clientWidth) - width) / 2 - borderWidth) + 'px';
                                            element_layer.style.top = (((window.innerHeight || document.documentElement.clientHeight) - height) / 2 - borderWidth) + 'px';
                                        }
                                    </script>


                                    <div class="input-group" style=" margin-bottom:0.74rem;">
                                        <label style=" text-align:right;width:130px; margin: 0 0.75rem;">거래게시일</label>
                                        <input type="text" class="form-control small" aria-describedby="basic-addon2"
                                               style="margin-right:2rem;background-color:white;border: 1px solid #e3e6f0;"
                                               value="${accDetail.accDate}" name="accDate" disabled>
                                    </div>
                                </div>



                            </div>
                    </form>

                </div>
                <div class="card shadow mb-4">
                    <div class="card-header py-3" style="align-content:center;">
                        <h6 class="m-0 font-weight-bold text-primary"
                            style="padding-top:0.5rem;height:100%; width:70%; float:left;">
                            거래처 담당자
                        </h6>
                        <a href="#"  class="btn btn-primary btn-sm" style="float:right; ">
                            <span class="text">Save</span>
                        </a>

                        <a href="#" class="btn btn-primary btn-sm" style="float:right;margin-right:1rem;">
                            <span class="text">Del</span>
                        </a>

                        <!-- Modal -->

                        <script type="text/javascript">
                            var modal = document.getElementById('customsubjects');
                            var btn = document.getElementById("myBtn");
                            var modalclose=document.getElementById("modalclose");
                            modalclose.onclick = function() {
                                location.href="${pageContext.request.contextPath}/account/${accCode}";
                            }
                            btn.onclick = function () {
                                modal.style.display = "block";
                                var name=$('#first').val();
                                var brand=$('#second').val();
                                console.log("first"+name);
                                console.log("second"+brand);
                                location.href="${pageContext.request.contextPath}/PTBsearch/"+name+"&"+brand;
                            }
                        </script>
                        <button id="PTBadd" class="btn btn-primary btn-sm" style="float:right;margin-right:1rem;"
                                data-toggle="modal" data-target="#myModal">
                            <span class="text">Add</span>
                        </button>
                        <%--                            <script>--%>
                        <%--                                $(document).ready(function() {--%>
                        <%--                                    $("#PTBadd").click(function() {--%>
                        <%--                                        action='PTBadd';--%>
                        <%--                                        type='POST';--%>
                        <%--                                        $("myModal").modal();--%>
                        <%--                                    })--%>
                        <%--                                })--%>

                        <%--                                function PTBadd() {--%>
                        <%--                                    location.href = "${pageContext.request.contextPath}/PTBadd";--%>
                        <%--                                }--%>

                        <%--                            </script>--%>

                    </div>
                    <div class="card-body">
                        <div class="card-body" style="overflow:auto; ">
                            <div class="table-responsive">
                                <table class="table table-bordered" width="100%" cellspacing="0"
                                       style="font-size:10px;">
                                    <thead>
                                    <tr>
                                        <th>No</th>
                                        <th>담당자</th>
                                        <th>직통번호</th>
                                        <th>E-mail</th>
                                        <th>담당브랜드</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="board" varStatus="status" items="${PTBList}">
                                        <tr>
                                            <td><c:out value="${status.count}"/></td>
                                            <td><c:out value="${board.ptbName}"/></td>
                                            <td><c:out value="${board.ptbPhone}"/></td>
                                            <td><c:out value="${board.ptbEmail}"/></td>
                                            <td><c:out value="${board.ptbBrand}"/></td>
                                        </tr>
                                    </c:forEach>

                                    </tbody>
                                </table>
                            </div>
                        </div>


                    </div>
                </div>

            </div>
        </div>
    </div>
    <!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<!-- Footer -->

<!-- End of Footer -->

</div>
<!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <a class="btn btn-primary" href="login.html">Logout</a>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript-->
<script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="${pageContext.request.contextPath}/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="${pageContext.request.contextPath}/resources/js/sb-admin-2.min.js"></script>

<!-- Page level plugins -->
<script src="${pageContext.request.contextPath}/resources/vendor/chart.js/Chart.min.js"></script>

<!-- Page level custom scripts -->
<script src="${pageContext.request.contextPath}/resources/js/demo/chart-area-demo.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/demo/chart-pie-demo.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/demo/chart-bar-demo.js"></script>

</body>

</html>
