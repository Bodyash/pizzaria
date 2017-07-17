<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/">
        <img src="/resources/images/main_logo.png" height="150px" width="150px" alt="Brand"/>
      </a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="/"> Pizza</a></li>
        <li><a href="/drinks"> Drinks</a></li>
        <li><a href="/desserts"> Desserts</a></li>
      </ul>
	<ul class="nav navbar-nav navbar-right">
       <sec:authorize access="hasRole('ADMIN')">
                <li>
                    <a href="<c:url value="/adminpanel"/>"><span class="glyphicon glyphicon-tasks" aria-hidden="true"></span> Admin Panel</a>
				</li>
        </sec:authorize>
       <sec:authorize access="hasRole('DBA')">
				<li>
				    <a href="<c:url value="/orderpanel"/>"><span class="glyphicon glyphicon-list" aria-hidden="true"></span> Order Panel</a>
                </li>
        </sec:authorize>
      	<li><a href="/cart"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>

            <sec:authorize access="!isAuthenticated()">
                <li>
                    <a href="<c:url value="/login"/>" role="button"><span class="glyphicon glyphicon-log-in" aria-hidden="true"></span> Login</a>
                </li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <li>
                    <a href="/cabinet" role="button">
                        <span class="glyphicon glyphicon-user" aria-hidden="true"></span> <sec:authentication property="principal.username"/>
                    </a>
                </li>
                <li>
                    <a href="<c:url value="/logout"/>" role="button"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span> Logout</a>
                </li>
            </sec:authorize>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>