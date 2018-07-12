<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Listado de Peliculas</title>
    <spring:url value="/resources" var="urlPublic"></spring:url>
    <spring:url value="/peliculas/create" var="urlFormCreate"></spring:url>
    <spring:url value="/peliculas/edit" var="urlFormEdit"></spring:url>
    <spring:url value="/peliculas/delete" var="urlFormDelete"></spring:url>
    <link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
    
  </head>

  <body>

<!-- HEADER -->
     <jsp:include page="../includes/menu.jsp"></jsp:include>

    <div class="container theme-showcase" role="main">

      <h3>Listado de Peliculas</h3>
     
     <c:if test="${msg != null }">
     	<div class='alert alert-success' role="alert">${msg}</div>
     </c:if>
     
      <a href="${urlFormCreate}" class="btn btn-success" role="button" title="Nueva Pelicula" >Nueva</a><br><br>
	
      <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered">
            <tr>
                <th>Titulo</th>
                <th>Genero</th>
                <th>Clasificacion</th>
                <th>Duracion</th>
                <th>Fecha Estreno</th>
                <th>Estatus</th>
                <th>Opciones</th>
            </tr>
            <c:forEach items="${peliculas.content}" var="p">
	            <tr>
	                <td>${p.titulo}</td>
	                <td>${p.genero}</td>
	                <td>${p.clasificacion}</td>
	                <td>${p.duracion}.min</td>
	                <td><fmt:formatDate value="${fechaEstreno}" pattern="dd-MM-yyyy"/></td>
	                <td>
	                	<c:choose>
	                		<c:when test="${p.estatus eq 'Activa'}">
	                			<span class="label label-success">${p.estatus}</span>
	                		</c:when>
	                		<c:otherwise>
	                			 <span class="label label-danger">${p.estatus}</span>
	                		</c:otherwise>
	                	</c:choose>	                
	               </td>
	                <td>
	                    <a href="${urlFormEdit}/${p.id}" class="btn btn-success btn-sm" role="button" title="Edit" ><span class="glyphicon glyphicon-pencil"></span></a>
	                    <a href="${urlFormDelete}/${p.id}" onclick="return confirm('¿Esta seguro de querer eliminar esta pelicula?')" class="btn btn-danger btn-sm" role="button" title="Eliminar" ><span class="glyphicon glyphicon-trash"></span></a>
	                </td>
	            </tr>
            </c:forEach>
        </table>
        <nav aria-label="">
			<ul class="pager">
				<li><a href="${urlPeliculas}/indexPaginate?page=${peliculas.number - 1 }">Anterior</a></li>
				<li><a href="${urlPeliculas}/indexPaginate?page=${peliculas.number + 1 }">Siguiente</a></li>
			</ul>
		</nav>
      </div>
          
      <hr class="featurette-divider">

      <!-- FOOTER -->
      <jsp:include page="../includes/footer.jsp"></jsp:include>


    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
    <script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>     
  </body>
</html>
