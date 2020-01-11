<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>ERP 시스템 - 자재관리</title>

    <!-- Custom fonts for this template-->
    <link href="${pageContext.request.contextPath}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${pageContext.request.contextPath}/resources/css/sb-admin-2.min.css" rel="stylesheet">

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
                    <a class="collapse-item" href="http://localhost:8080/enroll_com">거래처 조회</a>
                    <a class="collapse-item" href="http://localhost:8080/account">거래처 등록</a>
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
                    <a class="collapse-item" href="http://localhost:8080/search_res">자재 조회</a>
                    <a class="collapse-item" href="http://localhost:8080/enroll_res">자재 등록</a>
                </div>
            </div>
        </li>

        <hr class="sidebar-divider">

        <li class="nav-item">
            <a class="nav-link" href="http://localhost:8080/material_trans">
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
                        <h6 class="m-0 font-weight-bold text-primary">자재 등록</h6>
                    </div>
                </form>

                <!-- Topbar Navbar -->
                <ul class="navbar-nav ml-auto">

                    <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                    <li class="nav-item dropdown no-arrow d-sm-none">
                        <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-search fa-fw"></i>
                        </a>
                        <!-- Dropdown - Messages -->
                        <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in" aria-labelledby="searchDropdown">
                            <form class="form-inline mr-auto w-100 navbar-search">
                                <div class="input-group">
                                    <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                                    <div class="input-group-append">
                                        <button class="btn btn-primary" type="button">
                                            <i class="fas fa-search fa-sm"></i>
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </li>



                </ul>

            </nav>
            <!-- End of Topbar -->

            <!-- Begin Page Content -->
            <div class="container-fluid" style="">
                <!-- Page Heading -->
                <!-- 검색할 수 있는 공간-->


                <!-- Content Row -->
                <div class="row">
                    <!-- 자재 정보 수정  -->
                    <div class="col-xl-12 col-lg-12">
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">자재 등록</h6>
                            </div>
                            <div class="card-body">
                                <form  method="post" action="saveMaterial" >
                                <div class="form-inline mr-auto navbar-search" style="float:left; width:50%;margin-top:0.75rem;padding:0.75rem;">
                                    <div class="input-group" style=" margin-bottom:0.74rem;">
                                        <label style=" text-align:right; width:70px; margin: 0 0.75rem;">자재명</label>
                                        <input name = "materialName" type="text" class="form-control small" aria-describedby="basic-addon2" style="margin-right:2rem;background-color:white;border: 1px solid #e3e6f0;">
                                    </div>
                                    <div class="input-group" style=" margin-bottom:0.74rem;">
                                        <label style=" text-align:right;width:70px; margin: 0 0.75rem;">단가</label>
                                        <input  name = "materialMoney"type="text" class="form-control small" aria-describedby="basic-addon2" style="margin-right:2rem;background-color:white;border: 1px solid #e3e6f0;">
                                    </div>



                                </div>
                                <div class="form-inline mr-auto navbar-search" style="float:left; width:50%;margin-top:0.75rem;padding:0.75rem;">
                                    <div class="input-group" style=" margin-bottom:0.74rem;">
                                        <label style=" text-align:right;width:70px; margin: 0 0.75rem;">자재코드</label>
                                        <input name = "material" type="text" class="form-control small" aria-describedby="basic-addon2" style="margin-right:2rem;background-color:white;border: 1px solid #e3e6f0;">
                                    </div>
                                    <div class="input-group" style=" margin-bottom:0.74rem;">
                                        <label style=" text-align:right;width:70px; margin: 0 0.75rem;">규격</label>
                                        <input type="text" class="form-control small" aria-describedby="basic-addon2" style="margin-right:2rem;background-color:white;border: 1px solid #e3e6f0;">
                                    </div>
                                </div>
                                <div style="float:right; width:100%; margin-top:0.5rem;  ">
                                    <div style="width:100%;float:right;" align="right">

                                        <input type="submit" value="save" class="btn btn-primary btn-sm" style="float:right;margin-right:1rem; height:30px;width:75px;"></input>
                                    </div>
                                </div>

                                </form>
                            </div>
                        </div>


                    </div>
                </div>
            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <footer class="sticky-footer bg-white">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span>Copyright &copy; Your Website 2019</span>
                </div>
            </div>
        </footer>
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
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
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

