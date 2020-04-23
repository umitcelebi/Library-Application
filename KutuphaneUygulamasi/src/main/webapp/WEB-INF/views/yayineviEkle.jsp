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

<td>

				<!--             	YAYINEVI EKLEME BOLUMU                        -->
<div class="form-horizontal">
  <h2>Yayınevi Ekle</h2>
  <form:form class="form-horizontal" action="/yayineviekle" modelAttribute="yayinevi" method="POST">

	<div class="form-group">
      <label class="control-label col-sm-7">Yayınevi Adi</label>
      <div class="col-sm-10">
      <form:input path="yayineviId" class="form-control" value="${upYayinevi.yayineviId}" readonly="true"/>
      </div>
    </div>
    
  	<div class="form-group">
      <label class="control-label col-sm-7">Yayınevi Adi</label>
      <div class="col-sm-10">
      <form:input path="adi" class="form-control" value="${upYayinevi.adi}"/>
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-5">Açıklama</label>
      <div class="col-sm-10">
      <form:input path="aciklama" class="form-control" value="${upYayinevi.aciklama}"/>
      </div>
    </div>
    
    
    <form:button class="btn btn-default"> Kaydet </form:button>
    
  </form:form>
</div>
</td>

<c:if test="${empty yayineviList}">
	<label class="alert alert-danger">Sistemde kayıtlı yayınevi bulunmuyor.</label>
</c:if>

<c:if test="${not empty yayineviList}">
<td>
<form:form>
<div class="container">
  <h2>Yayınevleri</h2>
  
  <table class="table table-hover">
    <thead>
      <tr>
        <th>Yayinevi ID</th>
        <th>Yayinevi Adı</th>
        <th>Yayinevi Açıklama</th>
      </tr>
    </thead>
    <tbody>
   	 <c:forEach items="${yayineviList}" var="y">
      <tr>
      <td><c:out value="${y.yayineviId}"></c:out></td>
      <td><c:out value="${y.adi}"></c:out></td>
      <td><c:out value="${y.aciklama}"></c:out></td>
      <td><a href="yayineviupdate?id=<c:out value="${y.yayineviId}"/>">Düzenle</a></td>
      <td><a href="yayinevisil?id=<c:out value="${y.yayineviId}"/>">Sil</a></td>
      </tr>
      </c:forEach>

    </tbody>
  </table>
</div>
</form:form>
</td>
</c:if>

<td>
<a href="/kitaplar" class="btn btn-primary btn-lg " role="button" aria-disabled="false">Geri</a>
</td>

</tr>

</tbody>
</table>

</body>
</html>