<%@page import="com.koreait.petshop2.model.domain.Cart"%>
<%@page import="com.koreait.petshop2.model.common.Formatter"%>
<%@page import="com.koreait.petshop2.model.common.Formatter"%>
<%@page import="com.koreait.petshop2.model.domain.Cart"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
   List<Cart> cartList = (List)request.getAttribute("cartList");
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">

<%@ include file="./../../inc/header.jsp" %>
<script>
//장바구니 비우기
function delCart(){
   if(confirm("장바구니를 모두 비우시겠습니까?")){
      location.href="/shop/cart/del";
   }   
}
//수량변경
   function editCart(){
      if(confirm("주문 수량을 변경하시겠어요?")){
         $("#cart-form").attr({
            action:"/shop/cart/edit",
            method:"post"
         });
         $("#cart-form").submit();
      }   
      
   }
</script>
</head>
<body>
<%@ include file="./../../inc/shop_navi.jsp" %>

    <!-- Breadcrumb Begin -->
    <div class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb__links">
                        <a href="../../"><i class="fa fa-home"></i> Home</a>
                        <span>Shopping cart</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->

    <!-- Shop Cart Section Begin -->
    <section class="shop-cart spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="shop__cart__table">
                        <table>
                        
                            <thead>
                                <tr>
                                    <th>Product</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Total</th>
                                    <th></th>
                                </tr>
                            </thead>
                            
                            <tbody>
                               <%int sum=0; //합계 %>
                                 <%for(Cart cart : cartList){ %>
                                <tr>
                                    <td class="cart__product__item">
                                        <a href="#"><img src="/resources/data/basic/<%=cart.getProduct_id() %>.<%=cart.getFilename()%>" alt="Product"></a>
                                        <h6><%=cart.getSubCategory().getName() %> > <%=cart.getProduct_name() %> </h6>
                                        <div class="cart__product__item__title">
                                            <h6><%=cart.getSubCategory().getName() %></h6>
                                            <div class="rating">
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                        </div>
                                    </td>
                                    <td class="cart__price"><span><%=Formatter.getCurrency(cart.getPrice()) %></span></td>
                                    <td class="cart__quantity">
                                        <div class="pro-qty">
                                            <input type="hidden" name="cart_id" value="<%=cart.getCart_id()%>">
                                            <input type="number" name="quantity" value="<%=cart.getQuantity()%>">
                                          <!--   <input type="text" value="1"> -->
                                        </div>
                                    </td>
                                        <%
                                           sum = sum + (cart.getPrice()*cart.getQuantity());
                                        %>
                                    <td class="cart__total"><%=Formatter.getCurrency(cart.getPrice()*cart.getQuantity()) %></td>
                                    <td class="cart__close"><span class="icon_close"><a href="/shop/cart/delete.do?cart_id=<%=cart.getCart_id() %>>"></a></span></td>
                                </tr>
                               <%} %>
                             
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="cart__btn">
                        <a href="../../">메인으로</a>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="cart__btn update__btn">
                        <a href="javascript:editCart()"></span> Update cart</a>
                        <a href="javascript:delCart()"></span> 카트비우기</a>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6">
                    <div class="discount__content">
                        <h6>Discount codes</h6>
                        <form action="#">
                            <input type="text" placeholder="Enter your coupon code">
                            <button type="submit" class="site-btn">Apply</button>
                        </form>
                    </div>
                </div>
                <div class="col-lg-4 offset-lg-2">
                    <div class="cart__total__procced">
                        <h6>Cart total</h6>
                        <ul>
                           <!--  <li>Subtotal <span>$ 750.0</span></li> -->
                            <li>Total <span>$ 750.0</span></li>
                        </ul>
                        <a href="#" class="primary-btn"><%=Formatter.getCurrency(sum) %></a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Shop Cart Section End -->

    <!-- Search Begin -->
    <div class="search-model">
        <div class="h-100 d-flex align-items-center justify-content-center">
            <div class="search-close-switch">+</div>
            <form class="search-model-form">
                <input type="text" id="search-input" placeholder="Search here.....">
            </form>
        </div>
    </div>
    <!-- Search End -->

    <!-- Js Plugins -->
   <%@ include file="../shopFooter.jsp"%>
   <%@ include file="./../../inc/footer.jsp"%>
</body>

</html>