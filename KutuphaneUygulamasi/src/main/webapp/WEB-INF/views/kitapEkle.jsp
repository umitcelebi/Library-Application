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
<!--             	KİTAP EKLEME BOLUMU                        -->
<td>

  <h2>Kitap Ekle</h2>
  <form:form class="form-horizontal" action="/kaydet" modelAttribute="kitap" method="POST">

	<div class="form-group">
      <label class="control-label col-sm-5">Kitap ID</label>
      <div class="col-sm-7">
      <form:input path="kitapId" class="form-control" value="${upKitap.kitapId}" readonly="true" />
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-5">Kitap Adi</label>
      <div class="col-sm-7">
      <form:input path="kitapAdi" class="form-control" value="${upKitap.kitapAdi}"/>
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-5">Kitap Alt Adi</label>
      <div class="col-sm-7">
      <form:input path="kitapAltAdi" class="form-control" value="${upKitap.kitapAltAdi}"/>
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-5">Kitap Seri Adı</label>
      <div class="col-sm-7">
      <form:input path="seriAdi" class="form-control" value="${upKitap.seriAdi}"/>
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-5">Kitap ISBN</label>
      <div class="col-sm-7">
      <form:input path="isbnNo" class="form-control" value="${upKitap.isbnNo}"/>
      </div>
    </div>
    
    
     <div class="form-group">
      <label class="control-label col-sm-5">Kitap Açıklama</label>
      <div class="col-sm-7">
      <form:input path="acikama" class="form-control" value="${upKitap.acikama}"/>
      </div>
    </div>
    
     <div class="form-group">
    <label class="control-label col-sm-5" for="yazar">Yazar:</label>
    <div class="col-sm-3">
    <form:select path="yazar.yazarId" items="${yazarlar}" itemValue="yazarId" itemLabel="yazarAdi" />
    </div>
    </div>
    
    
    <div class="form-group">
    <label class="control-label col-sm-5" for="yayinevi">YayinEvi:</label>
    <div class="col-sm-5">
    <form:select path="yayinevi.yayineviId" items="${yayinevleri}" itemValue="yayineviId" itemLabel="adi"/>
    </div>
    </div>
    
    <form:button class="btn btn-default"> Kaydet </form:button>
    
  </form:form>
</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>

<td>
<a href="/kitaplar" class="btn btn-primary btn-lg " role="button" aria-disabled="false">Geri</a>
</td>
</tr>

</tbody>
</table>

</body>
</html>