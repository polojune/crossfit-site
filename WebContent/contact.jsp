<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp"%>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Crossfit template project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="styles/bootstrap-4.2.1/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="styles/contact.css">
<link rel="stylesheet" type="text/css" href="styles/contact_responsive.css">
	<!-- Home -->

	<div class="home">
		<div class="parallax_background parallax-window" data-parallax="scroll" data-image-src="images/contact.jpg" data-speed="0.8"></div>
		<div class="home_container">
			<div class="container">
				<div class="row">
					<div class="col">
						<div class="home_content text-center">
							<div class="home_title">Contact</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Contact -->

	<div class="contact">
		<div class="container">
			<div class="row">
				
				<!-- Contact Content -->
				<div class="col-lg-4 contact_col">
					<div class="contact_content">
						<div class="contact_content_title">crossfit <span>x</span></div>
						<div class="contact_text">
							
						</div>
						<div class="contact_info">
							<div class="contact_title"><h1>information</h1></div>
							<ul>
								<li>Main Str, no 23, New York</li>
								<li>010-2725-8574</li>
								<li>polo_june@naver.com</li>
							</ul>
						</div>
					</div>
				</div>

				<!-- Contact Form -->
				<div class="col-lg-4 contact_col">
					<div class="contact_form_container">
						<div class="contact_title"><h1>메일보내기</h1></div>
						<form action="/crossfit/user?cmd=sendMail" method="post" class="contact_form" id="contact_form">
							<input type="text" class="contact_form_input" id="name" placeholder="Name" name="name" required="required">
							<input type="email" class="contact_form_input" id="email" placeholder="E-mail" name="email" required="required">
							<input type="text" class="contact_form_input" id="subject" placeholder="Subject" name="subject">
							<textarea class="contact_form_input contact_form_textarea" id="message" placeholder="Message" name="message" required="required"></textarea>
							<button class="contact_form_button button"><span>전송하기</span></button>
					        
						</form>
						
				     </div>
				</div>
				
				<div class="col-lg-4 contact_col">
					<div class="contact_form_container">
					    <div class="contact_title"><h1>문자보내기</h1></div>
				         <form action="/crossfit/user?cmd=sendMessage" method="post" class="contact_form" id="contact_form">
					     
						    <input type="text" class="contact_form_input" id="number" placeholder="Number: 010-2725-8574" name="number" required readonly>				
						
						  <textarea class="contact_form_input contact_form_textarea" id="message" placeholder="Message" name="message" required="required"></textarea>
							 <button class="contact_form_button button"><span>전송하기</span></button>					        
						</form>														
					</div>
				 </div> 
			</div>
		</div>
	</div>





	<!-- Kakao Map -->
  
  	<div class="container">
   		<div id="map" style="width:500px;height:500px; width:100%"></div><br/><br/><br/>
	</div>

<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9dcf857c3ceea1c2374ce5a30ada593d"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4584fffce1f6805d84fb7ce6a9906c99&libraries=services,clusterer,drawing"></script>
<script src="js/kakaomap.js"></script>
<script src="js/contact.js"></script>	
<%@ include file="include/footer.jsp"%>    