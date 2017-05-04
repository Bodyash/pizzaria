<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<nav class="navbar navbar-default">
<a class="navbar-brand" href="/"><img src="resources/images/main_logo.png" height="200" width="200"/></a>
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
              <div class="navbar-header" style="margin-left: 10px">
        </div>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="/menu">Menu <span class="sr-only">(current)</span></a></li>
        <li><a href="/about">About</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      	<li><a href="/cart"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
        <li><a href="/login"><span class="glyphicon glyphicon-user"></span> Login</a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>