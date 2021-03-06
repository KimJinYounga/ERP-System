<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="ko">
<%--
<head>

    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
        Launch demo modal
    </button>
</head>
<div class="modal-body">
    <h5>Popover in a modal</h5>
    <form>
        <input type="text" placeholder="예) 홍길동" maxlength="40"
               class="text" name="first" />
        <input type="text" placeholder="예) 진영" maxlength="40"
               class="text" name="second" />
        <a href="#" role="button" class="btn btn-secondary popover-test" title="Popover title" data-content="Popover body content is set in this attribute.">button</a>
    </form>
   <%-- <p>This <a href="#" role="button" class="btn btn-secondary popover-test" title="Popover title" data-content="Popover body content is set in this attribute.">button</a> triggers a popover on click.</p>
    <hr>
    <h5>List</h5>
    <p><a href="#" class="tooltip-test" title="Tooltip">first link</a>
        <a href="#" class="tooltip-test" title="Tooltip">second link</a> </p>
</div>
<script type="text/javascript">
    $('#myModal').modal(options);
    $('#myModal').modal({
        keyboard: false
    });
    $('#myModal').modal('toggle');
    $('#myModal').modal('show');

</script>

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
</html>
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>모달 창</h2>
    <!-- Trigger the modal with a button -->
    <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">검색</button>

    <!-- Modal -->
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">거래처 담당자 검색</h4>
                </div>
                <div class="modal-body">
                    <form>
                        이름 : <input type="text" placeholder="예) 홍길동" maxlength="40"
                                    class="text" name="first" />
                        &nbsp; &nbsp; 담당 회사 : <input type="text" placeholder="예) Company" maxlength="40"
                                                     class="text" name="second" />
                        <a href="#" role="button" class="btn btn-secondary popover-test" title="Popover title" data-content="Popover body content is set in this attribute." id="myBtn">검색</a>
                    </form>

                    <div class="card shadow mb-4" style="display: none;" id="customsubjects">
                        <hr>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                    <tr>
                                        <th>담당자</th>
                                        <th>전화번호</th>
                                        <th>이메일</th>
                                        <th>담당브랜드</th>
                                        <th>비고</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>jin young</td>
                                        <td>wow</td>
                                        <td>thing</td>
                                        <td>33</td>
                                        <td>1997/04/1</td>
                                    </tr>
                                    <tr>
                                        <td>Michael Bruce</td>
                                        <td>Javascript Developer</td>
                                        <td>Singapore</td>
                                        <td>29</td>
                                        <td>2011/06/27</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-dismiss="modal">Save</button>
                </div>
            </div>

        </div>
    </div>

</div>
<script type="text/javascript">
    var modal = document.getElementById('customsubjects');
    var btn = document.getElementById("myBtn");
    btn.onclick = function() {
        modal.style.display = "block";
    }
</script>

</body>
</html>