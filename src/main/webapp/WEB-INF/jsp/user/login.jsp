<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="/webjars/bootstrap/3.3.4/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="/webjars/font-awesome/4.3.0/css/font-awesome.min.css">
<link rel="stylesheet" href="/webjars/origoni-startbootstrap-clean-blog/1.0.3/css/clean-blog.min.css">
<title>Login</title>
</head>
<body>

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-custom navbar-fixed-top">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/post/list">SpringBlog</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="/blog">Home</a>
                    </li>
                    <li>
                        <a href="#about.html">About</a>
                    </li>
                    <li>
                        <a href="/post">Sample Post</a>
                    </li>
                    <li>
                        <a href="#contact.html">Contact</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    
    <header class="intro-header" style="background-image: url('/image/contact-bg.jpg')">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                    <div class="page-heading">
                        <h1>Login</h1>
                        <hr class="small">
                        <span class="subheading">Connect to Facebook</span>
                    </div>
                </div>
            </div>
        </div>
    </header>
    
    <div class="container">
		<h3>로그인</h3>

		<form:form  method="post"><!--action="/loginProcessing"  -->
			
			<!-- 파라미터 error가 있는경우 IF 통과 -->
			<c:if test="${param.error != null}">
			<div >
				잘못된 아이디나 암호입니다.
			</div>
			</c:if>
			
			<input type="text" name="username" placeholder="계정" required="required"/>
			<input type="password" name="password" placeholder="암호" required="required"/>
			<input type="submit" value="로그인"/>
		</form:form>
	</div>

	<div class="container">
		<h3>Connect to Facebook API v2.3</h3>

		<form:form action="/sign-in/naver" >
			<%-- <input type="hidden" name="_csrf" value="${_csrf.token}"></input> --%>
			<div class="formInfo">
				<p>You aren't connected to Naver yet. Click the button to connect this application with your Naver account.</p>
			</div>
			<p>
			<!-- <a href="/sign-in/naver" >네이버</a> -->
				<!-- src="/image/nid_login_complete.PNG" -->
				<button type="submit">Connect to Naver</button>
			</p>
		</form:form>
	</div>
	
	<div class="container">
		<h3><a href="/user/create" >회원가입</a></h3>

		
	</div>

    <!-- Footer -->
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                    <ul class="list-inline text-center">
                        <li>
                            <a href="https://www.facebook.com/millkyc">
                                <span class="fa-stack fa-lg">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-facebook fa-stack-1x fa-inverse"></i>
                                </span>
                            </a>
                        </li>
                        <li>
                            <a href="https://github.com/origoni">
                                <span class="fa-stack fa-lg">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-github fa-stack-1x fa-inverse"></i>
                                </span>
                            </a>
                        </li>
                        <li>
                            <a href="https://twitter.com/origoni">
                                <span class="fa-stack fa-lg">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-twitter fa-stack-1x fa-inverse"></i>
                                </span>
                            </a>
                        </li>
                    </ul>
                    <p class="copyright text-muted">Powered By <a href="http://millky.com">Millky</a> | Skin designed by <a href="http://startbootstrap.com/template-overviews/clean-blog/">Start Bootstrap</a></p>
                </div>
            </div>
        </div>
    </footer>

<script src="https://npmcdn.com/tether@1.2.4/dist/js/tether.min.js"></script>
<script src="/webjars/bootstrap/4.0.0-alpha.6-1/js/bootstrap.min.js"></script>
<script src="/webjars/origoni-startbootstrap-clean-blog/1.0.3/js/clean-blog.min.js"></script>
</body>
</html>