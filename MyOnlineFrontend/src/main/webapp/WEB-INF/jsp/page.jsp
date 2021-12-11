<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="images" value="/rs/images" />
<spring:url var="css" value="/rs/css" />
<spring:url var="js" value="/rs/js" />

<c:set var="contextRoot" value="${pageContext.request.contextPath }" />


<!DOCTYPE html>
<html lang="en">
<head>	
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
	
    <title> ${title} </title>
    
    <script>
    	window.contextRoot = '${contextRoot}';
    </script>
    
    
    <!-- Bootstrap Core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">
    
    <!-- Bootstrap Datatable CSS -->
    <!--  <link href="${css}/dataTables.bootstrap.css" rel="stylesheet"> -->
    
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
    
    <!-- Custom CSS -->
    <link href="${css}/modifiedStyle.css" rel="stylesheet">

</head>

<body>

    <!-- Navigation -->
    <%@include file="./shared/navbar.jsp" %>

    <!-- Page Content -->
    <c:if test="${userclickhome == true }">
    	<%@include file="home.jsp" %>
    </c:if>
    
    <c:if test="${userclickaboutus == true }">
    	<%@include file="aboutus.jsp" %>
    </c:if>
    
    <c:if test="${userclickallproducts == true || userclickcategoryproducts==true}">
    	<%@include file="products.jsp" %>
    </c:if>
    
    <c:if test="${userclickmanageproduct == true }">
    	<%@include file="manageproduct.jsp" %>
    </c:if>
    
    <c:if test="${userclicksingleproduct == true }">
    	<%@include file="singleproduct.jsp" %>
    </c:if>
    
    <c:if test="${userclicklogin == true }">
    	<%@include file="login.jsp" %>
    </c:if>
    
    <c:if test="${userclickshowcart == true }">
    	<%@include file="cart.jsp" %>
    </c:if>
    <!-- /.container -->


        <!-- Footer -->
     <%@include file="./shared/footer.jsp" %>


    <!-- /.container -->

    <!-- jQuery -->
    <script src="${js}/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${js}/bootstrap.min.js"></script>
    
    <!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script> -->
    
    <!-- Bootstrap Datatable JavaScript -->
      <script src="${js}/dataTables.bootstrap.js"></script>  
    
    <!-- Bootstrap Datatable jquery JavaScript -->
     <script src="${js}/jquery.dataTables.js"></script> 
     
     <!-- Bootstrap Bootbox JavaScript -->
     <script src="${js}/bootbox.min.js"></script> 
     
     
     <!--   <script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>  -->
    
     <!--  <script src="https://code.jquery.com/jquery-3.5.1.js"></script>  -->
    
     <!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/bootbox.js/5.5.2/bootbox.min.js"></script>  --> 
    
    <!-- Custom JavaScript -->
    <script src="${js}/myScript.js"></script>

</body>

</html>
