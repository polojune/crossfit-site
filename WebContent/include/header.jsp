<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Crossfit</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Crossfit template project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="js/jquery-3.3.1.min.js"></script>
<script src="styles/bootstrap-4.2.1/popper.js"></script>
<script src="styles/bootstrap-4.2.1/bootstrap.min.js"></script>
<script src="plugins/greensock/TweenMax.min.js"></script>
<script src="plugins/greensock/TimelineMax.min.js"></script>
<script src="plugins/scrollmagic/ScrollMagic.min.js"></script>
<script src="plugins/greensock/animation.gsap.min.js"></script>
<script src="plugins/greensock/ScrollToPlugin.min.js"></script>
<script src="plugins/OwlCarousel2-2.3.4/owl.carousel.js"></script>
<script src="plugins/easing/easing.js"></script>
<script src="plugins/progressbar/progressbar.min.js"></script>
<script src="plugins/parallax-js-master/parallax.min.js"></script>
<script src="js/custom.js"></script>
<link rel="stylesheet" type="text/css" href="styles/bootstrap-4.2.1/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.3.4/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.3.4/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.3.4/animate.css">
<link rel="stylesheet" type="text/css" href="styles/main_styles.css">
<link rel="stylesheet" type="text/css" href="styles/responsive.css">
<link href="/crossfit/styles/styles.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
 <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
</head>
<body>

<div class="super_container">
	
	<!-- Header -->
      <header class="header">
		<div class="header_content d-flex flex-row align-items-center justify-content-center">

			<!-- Logo -->
			<div class="logo top_align">
				<a href="index.jsp"></a>
				<div>crossfit <span>x</span></div>
				<div>the next level</div>
			</div>
			
			<nav class="main_nav navbar">

				<ul class="d-flex flex-row align-items-center justify-content-start">
	  
				<c:choose>
				   <c:when test="${empty sessionScope.principal}">
					<li class="active"><a href="index.jsp">Home</a></li>
					<li><a href="about.jsp">About us</a></li>
					<li><a href="classes.jsp">Classes</a></li>
					<li><a href="/crossfit/board?cmd=wod&page=0">WOD</a></li>
					<li><a href="contact.jsp">Contact</a></li>
					<li><a href="/crossfit/inquire?cmd=inquireHome&page=0">문의하기</a></li>
					<li><a href="join.jsp">회원가입</a></li>
					<li><a href="login.jsp">로그인</a></li>
					
				  </c:when>
		
				  <c:otherwise>
				    <li class="active"><a href="index.jsp">Home</a></li>
					<li><a href="about.jsp">About us</a></li>
					<li><a href="classes.jsp">Classes</a></li>
					<li><a href="/crossfit/board?cmd=wod&page=0">WOD</a></li>
					<li><a href="contact.jsp">Contact</a></li>
					<li><a href="/crossfit/inquire?cmd=inquireHome&page=0">문의하기</a></li>
					<li><a href="/crossfit/user?cmd=update">회원정보</a></li>
					<li><a href="/crossfit/user?cmd=logout">로그아웃</a></li>
				  
				  </c:otherwise>	
			  </c:choose>		
				</ul>
				
			</nav>
			
			<div class="header_right top_align d-flex flex-row align-items-center justify-content-start">
				<form class="form-inline d-flex justify-content-end" action="/crossfit/board">
			        <input type="hidden" name="cmd" value="search" /> 
			        <input type="hidden" name="page" value="0" /> 
				    <input type="text" name="keyword" class="form-control mr-sm-2"  placeholder="Search">
			        <button class="btn btn-primary m-1">검색</button>
				</form>
				
			</div>
		</div>
	</header>

	<!-- Menu -->

	<div class="menu">
		<div class="menu_content d-flex flex-column align-items-center justify-content-start">
			<nav class="menu_nav navbar navbar-expand-md">
				<ul class="d-flex flex-column align-items-center justify-content-start">
					<li><a href="index.jsp">Home</a></li>
					<li><a href="about.jsp">About us</a></li>
					<li><a href="classes.jsp">Classes</a></li>
					<li><a href="wod.jsp">WOD</a></li>
					<li><a href="contact.jsp">Contact</a></li>
					<li><a href="join.jsp">회원가입</a></li>
					<li><a href="login.jsp">로그인</a></li>
				</ul>
			</nav>
		</div>
	</div>
   </div>


	
