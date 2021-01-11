<%@page import="com.koreait.petshop2.model.common.Formatter"%>
<%@page import="com.koreait.petshop2.model.domain.Product"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	List<Product> productList  = (List)request.getAttribute("productList");
%>
<!DOCTYPE html>
<html>
<head>
 <%@ include file="./../../inc/header.jsp" %>
 <meta name="viewport" content="width=device-width, initial-scale=1">
<style>

</style>	
<script>

</script>
</head>
<body>

	<%@ include file="./../../inc/shop_navi.jsp"%>

	<!--상품 시작 -->
	<section class="shop spad">
		<div class="container">
			<div class="row">
			

				<div class="col-lg-9 col-md-9">
					<div class="row">
					<%for(int i = 0; i<productList.size();i++){ %>
					<%Product product = productList.get(i) ;%>
						<div class="col-lg-4 col-md-6">
							<div class="product__item">
								<div class="product__item__pic set-bg"
									data-setbg="/resources/data/basic/<%=product.getProduct_id()%>.<%=product.getFilename()%>">
									<ul class="product__hover">
										<li><a href="/resources/data/basic/<%=product.getProduct_id()%>.<%=product.getFilename()%>"	class="image-popup">
										<span class="arrow_expand">
										</span>
										</a>
										</li>
										<li><a href="/shop/cart/cart_list"><span class="icon_bag_alt"></span></a></li>
										<li><a href="/shop/product/detail?product_id=<%=product.getProduct_id()%>"><span class="icon_bag_alt"></span></a></li>
									</ul>
								</div>
								<div class="product__item__text">
									<h6>
										<a href="#"><%=product.getProduct_name() %></a>
									</h6>
									<div class="rating">
										<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
											class="fa fa-star"></i> <i class="fa fa-star"></i> <i
											class="fa fa-star"></i>
									</div>
									<div class="product__price"><%=Formatter.getCurrency(product.getPrice()) %></div>
								</div>
							</div>
						</div>
					<%} %>
					</div>
				</div>
			</div>

			<!-- 상품  끝-->
			
			<div class="col-lg-12 text-center">
				<div class="pagination__option">
					<a href="#">1</a> <a href="#">2</a> <a href="#">3</a> <a href="#"><i
						class="fa fa-angle-right"></i></a>
				</div>
			</div>
			
		</div>
		</div>
		</div>
		</div>
	</section>

	<%@ include file="../shopFooter.jsp"%>
	<%@ include file="./../../inc/footer.jsp"%>

</body>

</html>