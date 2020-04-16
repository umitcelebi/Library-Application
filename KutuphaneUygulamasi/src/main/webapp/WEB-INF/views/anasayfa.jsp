<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>

<title>Ana Sayfa</title>
  <meta charset="UTF-8">
  
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
</head>
<body>

<a href="/kitapekle" class="btn btn-primary btn-lg " role="button" aria-disabled="false">Kitap Ekle</a>
<a href="/yazarlar" class="btn btn-primary btn-lg " role="button" aria-disabled="false">Yazar Ekle</a>
<a href="/yayinevleri" class="btn btn-primary btn-lg " role="button" aria-disabled="false">Yayinevi Ekle</a>
<a href="/kitaplar" class="btn btn-primary btn-lg " role="button" aria-disabled="false">Tüm Kitaplar</a>


<div class="container">
  <h2>Kitap Ara</h2>
  
  <form:form action="searchbyname" modelAttribute="kitap" method="GET">

  	<div class="form-group">
      <label class="control-label col-sm-1">Kitap Adı</label>
      <div class="col-sm-5">
      <form:input path="kitapAdi" class="form-control" />
      </div>
    </div>


  <form:button class="btn btn-default"> Ara </form:button>

  </form:form>
</div>

<form:form>

<div class="container">
  <h2>Kitaplar</h2>
  
  <table class="table table-hover">
    <thead>
      <tr>
        <th><a href="orderbyid">ID</a></th>
        <th><a href="bykitapadi">Kitap Adı</a> </th>
        <th>Kitap Alt Adı</th>
        <th>Kitap Seri Adı</th>
        <th>Kitap ISBN</th>
        <th>Açıklama</th>
        <th>Yazarı</th>
        <th>YayınEvi</th>
      </tr>
    </thead>
    <tbody>
   	 <c:forEach items="${kitaplar}" var="k">
      <tr>
      <td><c:out value="${k.kitapId}"></c:out></td>
      <td><c:out value="${k.kitapAdi}"></c:out></td>
      <td><c:out value="${k.kitapAltAdi}"></c:out></td>
      <td><c:out value="${k.seriAdi}"></c:out></td>
      <td><c:out value="${k.isbnNo}"></c:out></td>
      <td><c:out value="${k.acikama}"></c:out></td>
      <td><c:out value="${k.yazar.yazarAdi}"></c:out></td>
      <td><c:out value="${k.yayinevi.adi}"></c:out></td>
      <td><a href="kitapduzenle?id=<c:out value="${k.kitapId}"/>">Düzenle</a></td>
      <td><a href="deletebook?id=<c:out value="${k.kitapId}"/>">Sil</a></td>
      </tr>
      </c:forEach>

    </tbody>
  </table>
</div>

</form:form>

</body>
</html>