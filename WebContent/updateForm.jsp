<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<br><br><br><br><br><br><br><br>							
<%@ include file="include/header.jsp"%> 

 <div class="container">
	<div class="row">
      <div class="col-xs-2 col-md-2"></div>
        <div class="col-xs-8 col-md-8">
         <h2 class="text-center">게시글 수정</h2><p>&nbsp;</p>
    <div class="table table-responsive">
      <form action="/crossfit/inquire?cmd=updateProc" method="post">
        <input type="hidden" name="id" value="${principal.id}"/>
       <table class="table">
        <tr>
            <th class="success" >글번호</th>
            <td><input value="${inquireDto.inquire.id}"  class="form-control" name="id" readonly/></td>
        </tr>
                    
        <tr>
            <th class="success">작성자</th>
            <td><input value="${inquireDto.username}"  class="form-control" name="username" readonly/></td>
           
        </tr>
         
   
        <tr>
            <th class="success">제목</th>
            <td colspan="3"><input value="${inquireDto.inquire.title}" type="text" name="title"/></td>
        </tr>
         
        <tr>
            <th class="success">글 내용</th>
       		<td colspan="3"><textarea rows="3" cols="22" name="content">${inquireDto.inquire.content} </textarea></td>
        </tr>
         
        <tr>     
            <td colspan="4" class="text-center">                                                                                            
            <button type="submit" class="btn btn-warning" >수정완료 </button>         
            </td>
         
        </tr>    
      </table>
    </form>
    </div>
     
  </div>
</div>
</div>
	
					

<br><br><br><br><br><br><br><br>
<%@ include file="include/footer.jsp"%>