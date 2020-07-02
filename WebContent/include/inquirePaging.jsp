<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<c:choose>
	<c:when test="${empty param.keyword}">

		<c:set var="pagePrev" value="/crossfit/inquire?cmd=inquireHome&page=${param.page-1}" />
		<c:set var="pageNext" value="/crossfit/inquire?cmd=inquireHome&page=${param.page+1}" />
	</c:when>
	<c:otherwise>
		<c:set var="pagePrev" value="/crossfit/board?cmd=search&page=${param.page-1}&keyword=${param.keyword}" />
		<c:set var="pageNext" value="/crossfit/board?cmd=search&page=${param.page+1}&keyword=${param.keyword}" />

	</c:otherwise>
</c:choose>

		<!-- Page Nav -->
<!--		<div class="page_nav_container">
			<div class="container">
				<div class="row">
					<div class="col">
						<div class="page_nav">
							<ul class="d-flex flex-row align-items-start justify-content-center">
							
								<li class="active"><a class="page-link" href="/crossfit/board?cmd=wod&page=${param.page-1}">Prev</a></li>
								<li><a class="page-link" href="/crossfit/board?cmd=wod&page=${param.page+1}">Next</a></li>
								
							</ul>
						</div>
					</div>
				</div>
			</div>		
		</div>
	</div>

-->

<!-- disabled -->
		<div class="page_nav_container">
			<div class="container">
				<div class="row">
					<div class="col">
						<div class="page_nav">
<ul class="d-flex flex-row align-items-start justify-content-center">
							
	<c:choose>
		<c:when test="${param.page <= 0}">
			<li class="page-item disabled"><a class="page-link" href="${pageScope.pagePrev}">Prev</a></li>
		</c:when>
		<c:otherwise>
			<li class="page-item"><a class="page-link" href="${pageScope.pagePrev}">Prev</a></li>
		</c:otherwise>
	</c:choose>

	<c:choose>
		<c:when test="${lastPage == param.page}">
			<li class="page-item disabled"><a class="page-link" href="${pageScope.pageNext}">Next</a></li>
		</c:when>
		<c:otherwise>
			<li class="page-item"><a class="page-link" href="${pageScope.pageNext}">Next</a></li>
		</c:otherwise>
	</c:choose>

</ul>
					</div>
				</div>
			</div>		
		</div>
	</div>