<%@page import="com.koreait.petshop.model.domain.Image"%>
<%@page import="com.koreait.petshop.model.domain.Color"%>
<%@page import="com.koreait.petshop.model.domain.TopCategory"%>
<%@page import="com.koreait.petshop.model.domain.Psize"%>
<%@page import="com.fasterxml.jackson.core.format.DataFormatMatcher"%>
<%@page import="com.koreait.petshop.model.common.Formatter"%>
<%@page import="com.koreait.petshop.model.domain.Product"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	Product product =(Product)request.getAttribute("product");

%>
<!DOCTYPE html>
<html>
<head>
 <%@ include file="./../../inc/header.jsp" %>
 <meta name="viewport" content="width=device-width, initial-scale=1">
<style>

</style>	
<script>
 $('input[name="psize"]').val();

</script>
</head>
<body>

	<%@ include file="./../../inc/shop_navi.jsp"%>


	    <!-- Product Details Section Begin -->
	   <%--  <input type="hidden" name="product_id" value="<%=product.getProduct_id()%>"> --%>
    <section class="product-details spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <div class="product__details__pic">
                        <%for(int i=0;i<product.getImageList().size();i++){ %>
                        <div class="product__details__pic__left product__thumb nice-scroll">
                                	<%Image image = product.getImageList().get(i); %>   
                                	<%if(i>=4)break; //총 4개까지만 허용할 것이므로..%>   
                            <a class="pt active" href="#product-1">
                                <img src="/resources/data/addon/<%=image.getImage_id() %>.<%=image.getFilename()%>">
                          </a>
                        </div>
                          <%} %>
                        <div class="product__details__slider__content">
                            <div class="product__details__pic__slider owl-carousel">
                                <img data-hash="product-1" class="product__big__img" src="/resources/data/basic/<%=product.getProduct_id()%>.<%=product.getFilename()%>">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="product__details__text">
                        <h3><%=product.getProduct_name() %></h3>
                      
                        <div class="rating">
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            
                        </div>
                        <div class="product__details__price"><%=Formatter.getCurrency(product.getPrice()) %></div>
                        <p><%=product.getDetail() %></p>
                        <div class="product__details__button">
                            <div class="quantity">
                                <span>Quantity:</span>
                                <div class="pro-qty">
                                    <input type="text" value="1">
                                </div>
                            </div>
                            <a href="/shop/cart/cartlist" class="cart-btn"><span class="icon_bag_alt"></span> Add to cart</a>
                          
                        </div>
                        <div class="product__details__widget">
                            <ul>
                                
                                <li>
                                    <span>Available color:</span>
                                    <div class="color__checkbox">
                                      <%for(int i=0; i<product.getColor().size();i++){ %>
	                                    <%Color color = product.getColor().get(i); %>
                                            <input type="radio" name="color__radio" ><%=color.getPicker() %>
                                    <%} %>
                                    </div>
                                    
                                </li>
                                <li>
                            
                                    <span>Available size:</span>
                                    <div class="size__btn">
	                                    <%for(int i=0; i<product.getPsize().size();i++){ %>
	                                    <%Psize psize = product.getPsize().get(i); %>
	                                       <input type="radio" name="psize"><%=psize.getPetfit() %>
	                                    <%}%>
                                    </div>
                                 
                                </li>
                                
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-lg-12">
                    <div class="product__details__tab">
                        <ul class="nav nav-tabs" role="tablist">
                            
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#tabs-3" role="tab">Reviews (  )</a>
                            </li>
                        </ul>
                   
                    </div>
                </div>
            </div>
            
        </div>
    </section>
    <!-- Product Details Section End -->

			
		</div>
		</div>
		</div>
		</div>
	</section>

	<%@ include file="../shopFooter.jsp"%>
	<%@ include file="./../../inc/footer.jsp"%>

</body>

</html>