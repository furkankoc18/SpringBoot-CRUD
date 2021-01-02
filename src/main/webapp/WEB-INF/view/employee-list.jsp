<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employees</title>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<form method="post" action="/employee/create">
			<div class="form-row">
				<div class="form-group col-md-4">
					<label for="name">Ad</label> <input type="text"
						value="${employee.name}" class="form-control" id="name"
						name="name" placeholder="Ad">
				</div>
				<div class="form-group col-md-4">
					<label for="surname">Soyad</label> <input type="text"
						class="form-control" id="surname" name="surname"
						placeholder="Soyad">
				</div>
				<div class="form-group col-md-4">
					<label for="gender">Cinsiyet</label> <select id="gender"
						name="gender" class="form-control">
						<option selected disabled>Seciniz...</option>
						<option value="Erkek">Erkek</option>
						<option value="Kadın">Kadın</option>
					</select>
				</div>
			</div>
			<input type="hidden" value="${uuid}" name="uuid">
			<div class="form-row">
				<div class="form-group col-md-4">
					<label for="salary">Maaş</label> <input type="number" step="0.1"
						class="form-control" id="salary" name="salary" placeholder="Maas">
				</div>
				<div class="form-group col-md-8">
					<label for="address">Adres</label>
					<textarea rows="3" class="form-control" id="address" name="address"></textarea>
				</div>
			</div>
			<input type="submit" class="btn btn-success" value="Kaydet" />
			<div class="row">
				<table class="table">
					<thead>
						<tr>
							<th>ID</th>
							<th>Ad</th>
							<th>Soyad</th>
							<th>Cinsiyet</th>
							<th>Maaş</th>
							<th>İşlemler</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${employees}" var="employee">
							<tr>
								<td>${employee.id}</td>
								<td>${employee.name}</td>
								<td>${employee.surname}</td>
								<td>${employee.gender}</td>
								<td>${employee.salary}</td>
								<td><a class="btn btn-danger"
									href="/employee/delete/${employee.uuid}">Sil</a> <a
									class="btn btn-warning" href="/employee/edit/${employee.uuid}">Düzenle</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</form>
	</div>

</body>
</html>