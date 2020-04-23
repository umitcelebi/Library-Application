<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>

	<title>Kitap Girişi</title>
  	<meta charset="UTF-8">
  
 	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
</head>
<body>

<table>
<tbody>

<tr>
								<!--             	YAZAR EKLEME BOLUMU                        -->
<td>
<a href="/kitaplar" class="btn btn-primary btn-lg " role="button" aria-disabled="false">Geri</a>

<div class="form-horizontal">
  <h2>Yazar Ekle</h2>
  <form:form class="form-horizontal" action="/yazarekle" modelAttribute="yazar" method="POST">

	<div class="form-group">
      <label class="control-label col-sm-3">Yazar ID</label>
      <div class="col-sm-7">
      <form:input path="yazarId" class="form-control" value="${upYazar.yazarId}" readonly="true"/>
      </div>
    </div>
  	<div class="form-group">
      <label class="control-label col-sm-3">Yazar Adi</label>
      <div class="col-sm-7">
      <form:input path="yazarAdi" class="form-control" value="${upYazar.yazarAdi}"/>
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-3">Açıklama</label>
      <div class="col-sm-7">
      <form:input path="aciklama" class="form-control" value="${upYazar.aciklama}"/>
      </div>
    </div>
    
    
    <form:button class="btn btn-default"> Kaydet </form:button>
    
  </form:form>
</div>
</td>

<td>

<form:form>

<div class="container">
  <h2>Yazarlar</h2>
  
  <table class="table table-hover">
    <thead>
      <tr>
        <th>Yazar ID</th>
        <th>Yazar Adı</th>
        <th>Yazar Açıklama</th>
      </tr>
    </thead>
    <tbody>
   	 <c:forEach items="${yazarlar}" var="y">
      <tr>
      <td><c:out value="${y.yazarId}"></c:out></td>
      <td><c:out value="${y.yazarAdi}"></c:out></td>
      <td><c:out value="${y.aciklama}"></c:out></td>
      <td><a href="yazarupdate?id=<c:out value="${y.yazarId}"/>">Düzenle</a></td>
      <td><a href="yazarsil?id=<c:out value="${y.yazarId}"/>">Sil</a></td>
      </tr>
      </c:forEach>

    </tbody>
  </table>
</div>

</form:form>

</td>

</tr>

</tbody>
</table>

</body>
</html>