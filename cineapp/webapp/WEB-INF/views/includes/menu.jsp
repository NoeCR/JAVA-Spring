<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<spring:url value="/" var="urlRoot" />
<!-- Fixed navbar -->
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="${urlRoot}">My CineSite</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">  
          <!-- Usuario no registrado -->
          	<sec:authorize access="isAnonymous()">
          		 <li><a href="${urlRoot}about">Acerca</a></li>
				 <li><a href="${urlRoot}formLogin">Login</a></li>
          	</sec:authorize>
          	<!-- Usuario registrado con permisos de editor -->
          	<sec:authorize access="hasAnyAuthority('EDITOR')">
	            <li><a href="${urlRoot}peliculas/indexPaginate?page=0">Peliculas</a></li>
	            <li><a href="${urlRoot}horarios/indexPaginate?page=0">Horarios</a></li>
	            <li><a href="${urlRoot}noticias/index">Noticias</a></li>         
	            <li><a href="${urlRoot}about">Acerca</a></li>  
	            <li><a href="${urlRoot}admin/logout">Salir</a></li> 
           </sec:authorize>  
           
           <!-- Usuario registrado con permisos de gestor -->
          	<sec:authorize access="hasAnyAuthority('GERENTE')">
	            <li><a href="${urlRoot}peliculas/indexPaginate?page=0">Peliculas</a></li>
	            <li><a href="${urlRoot}horarios/indexPaginate?page=0">Horarios</a></li>
	            <li><a href="${urlRoot}noticias/index">Noticias</a></li>
	            <li><a href="${urlRoot}banners/index">Banner</a></li>             
	            <li><a href="${urlRoot}about">Acerca</a></li>  
	            <li><a href="${urlRoot}admin/logout">Salir</a></li> 
           </sec:authorize>            
          </ul>
        </div><!--/.nav-collapse -->
      </div>
</nav>