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
        <li><a href="/">Pizza</a></li>
        <li><a href="/drinks">Drinks</a></li>
        <li><a href="/desserts">Desserts</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
       <sec:authorize access="hasRole('ADMIN')">
                <li>
                    <a href="<c:url value="/adminpanel"/>"> Admin Panel</a>
				</li>
        </sec:authorize>
       <sec:authorize access="hasRole('DBA')">
				<li>
				    <a href="<c:url value="/orderpanel"/>"> Order Panel</a>
                </li>
        </sec:authorize>
      	<li><a href="/cart"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>

            <sec:authorize access="!isAuthenticated()">
                <li>
                    <a href="<c:url value="/login"/>" role="button">Login</a>
                </li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <li>
                    <a href="/cabinet" role="button">
                        <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                        &nbsp;
                        <sec:authentication property="principal.username"/>
                    </a>
                </li>
                <li>
                    <a href="<c:url value="/logout"/>" role="button">Logout</a>
                </li>
            </sec:authorize>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>