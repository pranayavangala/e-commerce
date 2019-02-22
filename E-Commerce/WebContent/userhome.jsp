<!DOCTYPE HTML>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.lp.dao.MyConnection"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.lp.dao.AppDAO"%>
<%@page import="com.lp.util.AppUtil"%>
<%@page import="java.io.File"%>
<%@page import="java.util.ListIterator"%>
<%@page import="com.lp.form.Product"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<html>
<head>
<title>E-Commerce: Login</title>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href='http://fonts.googleapis.com/css?family=Roboto'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/responsiveslides.css">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script src="js/responsiveslides.min.js"></script>
<script>
	// You can also use "$(window).load(function() {"
	$(function() {

		// Slideshow 1
		$("#slider1").responsiveSlides({
			maxwidth : 1600,
			speed : 600
		});
	});
</script>

<style type="text/css">
.CSSTableGenerator {
	width: 150%;
}
</style>
<link href="./css/table.css" rel="stylesheet" type="text/css"
	media="all" />


<script type="text/javascript">
	function callServlet(pid) {
		document.location.href = "updaterank?productid=" + pid;
	}
</script>
<script src="http://www.google.com/jsapi"></script>
<script>
	google.load("jquery", "1");
</script>
<script src="js/jquery.autocomplete.js"></script>
</head>
<body>
	<!---start-wrap--->
	<div class="wrap">
		<!---start-header--->
		<div class="header">
			<!---start-logo--->
			<div class="logo">
				<a href="index.html"><font size=10>E-Commerce </font></a>
			</div>
			<!---start-logo--->
			<!---start-top-nav--->
			<div class="top-nav">
				<ul>
					<li class="active"><a href="userhome.jsp">Home</a></li>
					<li class="active"><a href="usertransaction.jsp">Transactions</a></li>
					<li class="active"><a href="recommended.jsp">Recommended</a></li>
					<li><a href="userchangepassword.jsp">Change Password</a></li>
					<li><a href="logout.jsp">logout</a></li>
				</ul>
			</div>
			<div class="clear"></div>
			<!---End-top-nav--->
		</div>
	</div>
	<!---End-header--->
	<!---start-content---->
	<div class="wrap">
		<div class="content">
			<!--start-login-->
			<div class="col span_2_of_3">
				<div class="contact-form">

					<%
						String status = request.getParameter("status");

									if (status != null) {
					%>
					<h3>
						<font color="red" size="2"><%=status%></font>
					</h3>
					<%
						} else {
					%>
					<h3>Products</h3>
					<%
						}
					%>
					<form method="get" action="userhome.jsp" name="productsearch">

						<div>
							<span><label>Enter keyword</label></span> <span> <input
								name="keyword" id="name" type="text" class="textbox"></span>
						</div>
						<div>
							<span><input type="submit" value="Submit"
								onclick="return validate()"></span>
						</div>
					</form>

					<br /> <br /> <br /> <br />
					<form action="buyproducts.jsp">
						<div class="CSSTableGenerator">
							<%
							String query = request.getParameter("keyword");

							if (query != null) {
						%>

							<table border="1">
								<tr>
									<td>Name</td>
									<td>Manufacture Name</td>
									<td>price</td>
									<td>Category</td>
									<td>Description</td>
									<td>Add To Cart</td>
								</tr>
								<%		
										List<Product> products=AppDAO.getProductsByQuery(query);
										Iterator<Product> iterator =products.iterator();

										while (iterator.hasNext()) {

											Product product = iterator.next();
								%>

								<tr>
									<td><%=product.getName()%></td>
									<td><%=product.getManifatcuredName()%></td>
									<td><%=product.getPrice()%></td>
									<td><%=product.getCategory()%></td>
									<td><%=product.getDescription()%></td>
									<td><input type="checkbox" name="productid"
										value="<%=product.getId()%>"></td>
								</tr>
								<%
									}
									}
								%>
							</table>
						</div>
						<div>
							<span><input type="submit" value="Submit"
								onclick="return validate()"></span>
						</div>
					</form>
					
					<div class="CSSTableGenerator">
						
						</div>
				</div>
				<!--End-login---->
				<div class="clear"></div>
				<div class="clear"></div>
				<div class="footer">
					<div class="footer-left">
						<a href="index.html"><font size=5>E-Commerce</font></a>
					</div>
					<div class="footer-right">
						<p>
							Design by <a href="http://www.voidmaintechnologies.com">Voidmain
								Technologies</a>
						</p>
					</div>
					<div class="clear"></div>
				</div>
			</div>
			<!---End-content---->
		</div>
		<!---start-wrap--->
</body>
</html>

