<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- FileName : uploadForm.html  파일위치 c:\tomcat4/webapps/ROOT/uploadTest -->

<Form action="receive.jsp" Method="POST" enctype="multipart/form-data">

이름 : <Input type="TEXT" name="userName"> <BR>

파일 : <Input type="FILE" name="userFile"><BR>

<input type="SUBMIT" value="전 송 ">

</Form>
