<%@page import="com.koreait.petshop.model.domain.Paymethod"%>
<%@page import="java.util.List"%>
<%@page import="com.koreait.petshop.model.domain.Member"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	Member member=(Member)session.getAttribute("member");
	List<Paymethod> paymethodList = (List)request.getAttribute("paymethodList");
%>
<!DOCTYPE html>
<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="./../../inc/header.jsp" %>
</head>

<body>
  
    <!-- Offcanvas Menu Begin -->
    
    <div class="offcanvas-menu-overlay"></div>
    <div class="offcanvas-menu-wrapper">
        <div class="offcanvas__close">+</div>
        <ul class="offcanvas__widget">
            <li><span class="icon_search search-switch"></span></li>
            <li><a href="#"><span class="icon_heart_alt"></span>
                <div class="tip">2</div>
            </a></li>
            <li><a href="#"><span class="icon_bag_alt"></span>
                <div class="tip">2</div>
            </a></li>
        </ul>
        <div class="offcanvas__logo">
            <a href="./index.html"><img src="/resources/img/logo.png" alt=""></a>
        </div>
        <div id="mobile-menu-wrap"></div>
        <div class="offcanvas__auth">
            <a href="#">Login</a>
            <a href="#">Register</a>
        </div>
    </div>
    <!-- Offcanvas Menu End -->

    <!-- Header Section Begin -->
  <%@ include file="./../../inc/shop_navi.jsp" %>
    <!-- Header Section End -->

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

    <!-- Checkout Section Begin -->
    <section class="checkout spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h6 class="coupon__link"><span class="icon_tag_alt"></span> <a href="/shop/cart/list">카트로 돌아가기</a> Click
                    </h6>
                </div>
            </div>
            <form action="#" class="checkout__form">
                <div class="row">
                    <div class="col-lg-8">
                        <h5>주문자정보</h5>
                        <div class="row">
	                            <div class="col-lg-6 col-md-6 col-sm-6">
	                                <div class="checkout__form__input">
	                                    <p>고객명<span>*</span></p>
	                                    <input type="text" class="form-control" id="member_name" value="" required>
	                                </div>
	                            </div>
	                            <div class="col-lg-6 col-md-6 col-sm-6">
	                                <div class="checkout__form__input">
	                                    <p>연락처<span>*</span></p>
	                                    <input type="text">
	                                </div>
	                            </div>
	                            <div class="col-lg-12">
	                                <div class="checkout__form__input">
	                                    <p>주소 <span>*</span></p>
	                                    <input type="text">
	                                </div>
	                            </div>    
	                           	<div class="col-12 mb-3">
	                                  <div class="custom-control custom-checkbox d-block mb-2">
	                                          <input type="checkbox" class="custom-control-input" id="customCheck1" onClick="setData(this)">
	                                          <label class="custom-control-label" for="customCheck1">주문자와 동일</label>
	                                  </div>
	                            </div> 
	                            <div class="col-lg-6 col-md-6 col-sm-6">
	                                <div class="checkout__form__input">
	                                    <p>고객명<span>*</span></p>
	                                    <input type="text" class="form-control" id="member_name" value="" required>
	                                </div>
	                            </div>
	                            <div class="col-lg-6 col-md-6 col-sm-6">
	                                <div class="checkout__form__input">
	                                    <p>연락처<span>*</span></p>
	                                    <input type="text">
	                                </div>
	                            </div>
	                            <div class="col-lg-12">
	                                <div class="checkout__form__input">
	                                    <p>주소 <span>*</span></p>
	                                    <input type="text">
	                                </div>
	                            </div>    
                               
                                
                       
                             </div>
                          </div>
                        <div class="col-lg-4">
                            <div class="checkout__order">
                                <h5>장바구니 목록</h5>
                                <div class="checkout__order__product">
                                    <ul>
                                        <li>
                                            <span class="top__text">상품명</span>
                                            <span class="top__text__right">금액</span>                                  
                                        </li>
                                        <li>01. Chain buck bag <span>$ 300.0</span></li>
                                        <li>02. Zip-pockets pebbled<br /> tote briefcase <span>$ 170.0</span></li>
                                        <li>03. Black jean <span>$ 170.0</span></li>
                                        <li>04. Cotton shirt <span>$ 110.0</span></li>
                                        
                                    </ul>
                                    
                                </div>
                                <div class="checkout__order__total">
                                    <ul>
                                        
                                        <li>Total <span>$ 750.0</span></li>
                                    </ul>
                                </div>
                                <div class="checkout__order__widget">
                                
                            
                                <!--결제방법선택-->
                                
                                <div class="checkout__order__total">
                                    <ul>
                                        <li>결제방법</li>
                                    </ul>
                                </div>
                                    <div class="col-12 mb-3">
                                        <select class="custom-select d-block w-100" id="country" name="paymethod_id">
                                   <%--      
                                        <%for(Paymethod paymethod : paymethodList){ %>       
                                        <option value="<%=paymethod.getPaymethod_id()%>"><%=paymethod.getMethod() %></option>	
										<%} %>
										 --%>
                                    </select>
                                    </div> 
                                
                                </div>
                                <button type="submit" class="site-btn">결제하기</button>
                            </div>
                        </div>
                        </div>
                    </div>
                </form>
            </div>
        </section>
        <!-- Checkout Section End -->

        <!-- Instagram Begin -->
        <div class="instagram">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-2 col-md-4 col-sm-4 p-0">
                        <div class="instagram__item set-bg" data-setbg="/resources/img/instagram/insta-1.jpg">
                            <div class="instagram__text">
                                <i class="fa fa-instagram"></i>
                                <a href="#">@ ashion_shop</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2 col-md-4 col-sm-4 p-0">
                        <div class="instagram__item set-bg" data-setbg="/resources/img/instagram/insta-2.jpg">
                            <div class="instagram__text">
                                <i class="fa fa-instagram"></i>
                                <a href="#">@ ashion_shop</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2 col-md-4 col-sm-4 p-0">
                        <div class="instagram__item set-bg" data-setbg="/resources/img/instagram/insta-3.jpg">
                            <div class="instagram__text">
                                <i class="fa fa-instagram"></i>
                                <a href="#">@ ashion_shop</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2 col-md-4 col-sm-4 p-0">
                        <div class="instagram__item set-bg" data-setbg="/resources/img/instagram/insta-4.jpg">
                            <div class="instagram__text">
                                <i class="fa fa-instagram"></i>
                                <a href="#">@ ashion_shop</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2 col-md-4 col-sm-4 p-0">
                        <div class="instagram__item set-bg" data-setbg="/resources/img/instagram/insta-5.jpg">
                            <div class="instagram__text">
                                <i class="fa fa-instagram"></i>
                                <a href="#">@ ashion_shop</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2 col-md-4 col-sm-4 p-0">
                        <div class="instagram__item set-bg" data-setbg="/resources/img/instagram/insta-6.jpg">
                            <div class="instagram__text">
                                <i class="fa fa-instagram"></i>
                                <a href="#">@ ashion_shop</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Instagram End -->

	<%@ include file="../shopFooter.jsp"%>
	<%@ include file="./../../inc/footer.jsp"%>
    </body>

    </html>
