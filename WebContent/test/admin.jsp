<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>FileUpload Form</title>
<style>
     #uploadFormArea{
       margin : auto; 
       width : 350px; 
       border : 1px solid black; 
     
     }
     .td_title{ 
        font-size:xx-large; 
        text-align: center;
     }

</style>

</head>
<body>
<section id = "uploadFormArea">
<form action="/crossfit/board?cmd=UploadProc" method="post" enctype="multipart/form-data">
<table> 
     <tr> 
         <td colspan="2" class = "td_title">게시판</td>
     <tr>
      
      <tr>

     <tr>
         <td><label for ="name">제목 : </label></td><td><input
         type="text" name="title" id="title"></td> 
     <tr>
         <td><label for ="fileName">파일명 : </label></td><td><input
         type="file" name="fileName" id="fileName"></td>  
     <tr>
             <th>내용</th>
                <td><textarea rows="3" cols="22" id="content" name="content"></textarea></td>
     </tr>
     <tr>
        <td colspan=2 align=center><input type="submit" value="전송"></td>
     </tr>                       
 
</table>
</form>
</section>

</body>
</html>