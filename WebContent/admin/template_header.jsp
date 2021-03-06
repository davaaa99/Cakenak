<!doctype html>
<html>
<head>
	<meta charset="UTF-8">

	<title>Cakenak - Admin </title>	
	<!-- <link rel="stylesheet" type="text/css" href="<?php echo base_url() ?>assets/css/style.css"> -->
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<link href="<c:url value = "../css/bootstrap.min.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value = "../css/font-awesome.min.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value = "../css/prettyPhoto.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value = "../css/animate.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value = "../css/main.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value = "../css/responsive.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value = "../css/price-range.css" />" rel="stylesheet" type="text/css"/>
</head>
<body>
        <header>
            <div id='headertext' >
            <nav class="navbar navbar-expand-lg navbar-light bg-light" >
                <a class="nav-link" href="index.jsp" class="headerBar" id="homeBtn" style="font-family: 'Cream Cake'; color: #FF7C93; font-size:3vw;"> Cakenak </a>
                <!-- <a class="navbar-brand" href="#">Navbar</a> -->
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                
                <div class="col-sm-7" style="margin-right: 10px;">
                            <div class="search_box pull-right" style="padding-right: 10px;">
                                <form action="SearchForProduct">
                                <input type="text" placeholder="Search" name="search"/>
                                </form>
                            </div>
                </div>
                
                <div class="navbar-collapse collapse" id="navbarNav"> 
                    <ul class="navbar-nav ml-auto" style="margin-right: 10px;">
                    <c:if test="${!empty LoginUser && LoginUser.tipeakun =='ROLE_COSTUMER' }">
                                        <li class="nav-item" style="padding-right: 10px;">
                                        	<a href="Profile"><i class="fa fa-user"></i> ${LoginUser.username}</a>
                                        </li>
                                        <li class="nav-item" style="padding-right: 10px;">
                                        	<a href="CartHandlerServlet"><i class="fa fa-shopping-cart"></i> Cart (<span id="number"></span> )</a>
                                        </li>
                                        <li class="nav-item" style="padding-right: 10px;"><a href="#">
                                        	<i class="fa fa-usd"></i>${LoginUser.cash}</a>
                                        </li>
                                         <li class="nav-item" style="padding-right: 10px;">
                                         	<a href="ScratchCards.jsp"><i class="fa fa-cc-visa"></i> Charge </a>
                                         </li>
                                        <li class="nav-item" style="padding-right: 10px;">
                                        	<a href="logout"><i class="fa fa-sign-out"></i> Logout</a>
                                        </li>
                    	<script type="text/javascript">var userID = '${LoginUser.idpembeli}';</script>
                    </c:if>
                                        
                    <c:if test="${!empty LoginUser && LoginUser.tipeakun =='ROLE_ADMIN' }">
                    	<li class="nav-item" style="padding-right: 10px;"><a href="/"><i class="fa fa-cog"></i> Panel Admin </a></li>
                    	<li class="nav-item" style="padding-right: 10px;"><a href="logoutadmin"><i class="fa fa-sign-out"></i> Logout</a></li>
                    </c:if>
                    
                    <c:if test="${!empty LoginUser && LoginUser.tipeakun =='ROLE_SELLER' }">
                    	<li class="nav-item" style="padding-right: 10px;"><a href="seller"><i class="fa fa-cog"></i> Panel Seller </a></li>
                    	<li class="nav-item" style="padding-right: 10px;"><a href="seller/logout"><i class="fa fa-sign-out"></i> Logout</a></li>
                    </c:if>

                    <c:if test="${empty LoginUser}">
                    <li class="nav-item" style="padding-right: 10px;" >
                        <button class="btnd btn-secondary dropdown-toggle navbar-toggle" style="margin-bottom: 2%;" type="button" 
										  id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
										    Login
										  </button>
										  <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuButton">
										    <a class="dropdown-item" href="../login.jsp">Pembeli</a>
										    <a class="dropdown-item" href="../penjual/loginpenjual.jsp">Penjual</a>
										    <a class="dropdown-item" href="loginadmin.jsp">Admin</a>
										  </div>
                    </li>
                    </c:if>

                    
                    </ul>
                </div>
            </nav>
        </div>
  </header>
		<div id="contentwrapper">


