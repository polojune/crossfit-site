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
<link rel="stylesheet" type="text/css" href="styles/bootstrap-4.2.1/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.3.4/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.3.4/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.3.4/animate.css">
<link rel="stylesheet" type="text/css" href="styles/main_styles.css">
<link rel="stylesheet" type="text/css" href="styles/responsive.css">
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
			<nav class="main_nav">
				<ul class="d-flex flex-row align-items-center justify-content-start">
				<c:choose>
				   <c:when test="${empty sessionScope.principal}">
					<li class="active"><a href="index.jsp">Home</a></li>
					<li><a href="about.jsp">About us</a></li>
					<li><a href="classes.jsp">Classes</a></li>
					<li><a href="/crossfit/board?cmd=wod">WOD</a></li>
					<li><a href="contact.jsp">Contact</a></li>
					<li><a href="join.jsp">회원가입</a></li>
					<li><a href="login.jsp">로그인</a></li>
				  </c:when>
		
				  <c:otherwise>
				    <li class="active"><a href="index.jsp">Home</a></li>
					<li><a href="about.jsp">About us</a></li>
					<li><a href="classes.jsp">Classes</a></li>
					<li><a href="/crossfit/board?cmd=wod">WOD</a></li>
					<li><a href="contact.jsp">Contact</a></li>
					<li><a href="/crossfit/user?cmd=update">회원정보</a></li>
					<li><a href="/crossfit/user?cmd=logout">로그아웃</a></li>
				  
				  </c:otherwise>	
			  </c:choose>		
				</ul>
			</nav>
			<div class="header_right top_align d-flex flex-row align-items-center justify-content-start">
				<div class="search_container">
					<div class="search_form_container">
						<form action="#" class="search_form" id="search_form">
							<input type="text" class="search_input" required="required">
						</form>
					</div>
					<div class="search_button top_align">
						<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" viewBox="0 0 512 512" enable-background="new 0 0 512 512" width="512px" height="512px">
							<g>
								<path d="M495,466.2L377.2,348.4c29.2-35.6,46.8-81.2,46.8-130.9C424,103.5,331.5,11,217.5,11C103.4,11,11,103.5,11,217.5   S103.4,424,217.5,424c49.7,0,95.2-17.5,130.8-46.7L466.1,495c8,8,20.9,8,28.9,0C503,487.1,503,474.1,495,466.2z M217.5,382.9   C126.2,382.9,52,308.7,52,217.5S126.2,52,217.5,52C308.7,52,383,126.3,383,217.5S308.7,382.9,217.5,382.9z" fill="#FFFFFF"/>
							</g>
						</svg>
					</div>
				</div>
				<div class="contact_button trans_400"><a href="contact.jsp">Get in touch</a></div>
				<div class="hamburger"><i class="fa fa-bars" aria-hidden="true"></i></div>
			</div>
		</div>
	</header>

	<!-- Menu -->

	<div class="menu">
		<div class="menu_content d-flex flex-column align-items-center justify-content-start">
			<nav class="menu_nav">
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

