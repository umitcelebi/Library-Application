<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<title>Kullanıcı Girişi</title>
  <meta charset="UTF-8">
  
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
</head>
<body>

<div class="container">
  <h2>Kayıt Ol</h2>
  
  <form:form action="save" modelAttribute="kullanici" method="POST">

  <div class="form-group">
      <label>Kullanici Adi</label>
      <form:input path="kulAdi" class="form-control"/>
    </div>
  
  <div class="form-group">
      <label for="parola">Parola:</label>
      <form:password path="parola" class="form-control"/>
    </div>

  <form:button class="btn btn-default"> Kaydet </form:button>

  </form:form>
</div>

</body>
</html>