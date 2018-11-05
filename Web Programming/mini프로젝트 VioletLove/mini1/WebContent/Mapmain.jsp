<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"%>

<!doctype html>

<html lang="en">

<head>

<meta charset="utf-8">

<meta name="viewport"
   content="width=device-width, initial-scale=1, shrink-to-fit=no">

<meta name="description" content="">

<meta name="author" content="">

<link rel="icon" href="../../../../favicon.ico">



<title>Violet Love JMTMap</title>



<!-- Bootstrap core CSS -->

<link href="css/bootstrap.min.css" rel="stylesheet">



<!-- Custom styles for this template -->
<link
   href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900"
   rel="stylesheet">
<link href="blog.css" rel="stylesheet">

<style type="text/css">
.button{
        margin-left: 10%;
         background-color: transparent !important;
      border-color: transparent;
      color: black;
   
}
#nav {
   border: 1px solid #ccc;
   border-width: 1px 0;
   list-style: none;
   margin: 0;
   padding: 0;
   text-align: center;
}

#nav li {
   display: inline;
}

#nav a {
   display: inline-block;
   padding: 10px;
}

.menubar p {
   clear: left;
}

.my-hr1 {
   border: 4;
   height: 1px;
   background: #ccc;
}

.map_wrap, .map_wrap * {
   margin: 0;
   padding: 0;
   font-family: 'Malgun Gothic', dotum, '돋움', sans-serif;
   font-size: 12px;
}

.map_wrap a, .map_wrap a:hover, .map_wrap a:active {
   color: #000;
   text-decoration: none;
}

.map_wrap {
   position: relative;
   width: 100%;
   height: 500px;
}

#menu_wrap {
   position: absolute;
   top: 0;
   left: 0;
   bottom: 0;
   width: 250px;
   margin: 10px 0 30px 10px;
   padding: 5px;
   overflow-y: auto;
   background: rgba(255, 255, 255, 0.7);
   z-index: 1;
   font-size: 12px;
   border-radius: 10px;
}

.bg_white {
   background: #fff;
}

#menu_wrap hr {
   display: block;
   height: 1px;
   border: 0;
   border-top: 2px solid #5F5F5F;
   margin: 3px 0;
}

#menu_wrap .option {
   text-align: center;
}

#menu_wrap .option p {
   margin: 10px 0;
}

#menu_wrap .option button {
   margin-left: 5px;
}

#placesList li {
   list-style: none;
}

#placesList .item {
   position: relative;
   border-bottom: 1px solid #888;
   overflow: hidden;
   cursor: pointer;
   min-height: 65px;
}

#placesList .item span {
   display: block;
   margin-top: 4px;
}

#placesList .item h5, #placesList .item .info {
   text-overflow: ellipsis;
   overflow: hidden;
   white-space: nowrap;
}

#placesList .item .info {
   padding: 10px 0 10px 55px;
}

#placesList .info .gray {
   color: #8a8a8a;
}

#placesList .info .jibun {
   padding-left: 26px;
   background:
      url(http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_jibun.png)
      no-repeat;
}

#placesList .info .tel {
   color: #009900;
}

#placesList .item .markerbg {
   float: left;
   position: absolute;
   width: 36px;
   height: 37px;
   margin: 10px 0 0 10px;
   background:
      url(http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png)
      no-repeat;
}

#placesList .item .marker_1 {
   background-position: 0 -10px;
}

#placesList .item .marker_2 {
   background-position: 0 -56px;
}

#placesList .item .marker_3 {
   background-position: 0 -102px
}

#placesList .item .marker_4 {
   background-position: 0 -148px;
}

#placesList .item .marker_5 {
   background-position: 0 -194px;
}

#placesList .item .marker_6 {
   background-position: 0 -240px;
}

#placesList .item .marker_7 {
   background-position: 0 -286px;
}

#placesList .item .marker_8 {
   background-position: 0 -332px;
}

#placesList .item .marker_9 {
   background-position: 0 -378px;
}

#placesList .item .marker_10 {
   background-position: 0 -423px;
}

#placesList .item .marker_11 {
   background-position: 0 -470px;
}

#placesList .item .marker_12 {
   background-position: 0 -516px;
}

#placesList .item .marker_13 {
   background-position: 0 -562px;
}

#placesList .item .marker_14 {
   background-position: 0 -608px;
}

#placesList .item .marker_15 {
   background-position: 0 -654px;
}

#pagination {
   margin: 10px auto;
   text-align: center;
}

#pagination a {
   display: inline-block;
   margin-right: 10px;
}

#pagination .on {
   font-weight: bold;
   cursor: default;
   color: #777;
}
.my-hr1 {
   border: 4;
   height: 1px;
   background: #ccc;
}

body {
  	background: url("image/배경1.png") no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
	margin-top: 50px;
}
/* 제목이랑 로그인 회원가입 */
.titlecolor {
   color: #EAEAEA;
   font-size: 100%
}

.titlecolor:hover {
   color: #C170EA;
   text-decoration: none !important;
}
/* 메뉴바  */
.innercolor {
   color: #BDBDBD;
   font-size: 150%;
}

.innercolor:hover {
   color: #C170EA;
}
/* 버튼 투명화시키고 이미지 넣음 */
.aaa {
   background-color: transparent !important;
   background-image: none !important;
   border-color: transparent;
   border: none;
   color: #FFFFFF;
}
/* 메뉴바 위치 */
#headdddd ul {
   margin-left: 30%;
   list-style: none;
   margin-bottom: 20px;
}

.food{color:#E8D9FF;}

.titlecolor{color: #EAEAEA;}
.titlecolor:hover{color:#C170EA;text-decoration:none !important;}
.innercolor{color:#BDBDBD;}
.innercolor:hover{color:#C170EA;text-decoration:none !important;}
</style>


</head>
<body>
  <div class="container">
     <header class="blog-header py-3">
         <div
            class="row flex-nowrap justify-content-between align-items-center">
            <div class="col-4 text-center" align="center">
               <a class="titlecolor" href="Mainlist.do">
               <h1>Violet Love</h1> </a>
            </div>
            
            <div class="col-4 d-flex justify-content-end align-items-center">
               <a class="text-muted" href="#"> <svg
                     xmlns="http://www.w3.org/2000/svg" width="20" height="20"
                     viewBox="0 0 24 24" fill="none" stroke="currentColor"
                     stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                     class="mx-3">
                     <circle cx="10.5" cy="10.5" r="7.5"></circle>
                     <line x1="21" y1="21" x2="15.8" y2="15.8"></line>
                  </svg>
               </a> 
             <%  
            String id = (String) session.getAttribute("idSession");
            
            if(id == null){
               System.out.println("세션값 없음");
               %>
                    <a class="titlecolor" href="Login.jsp">login</a>&nbsp;
                    <a class="titlecolor" href="Signup.jsp">signup</a>
               <%
            } else {
               System.out.println("세션값 있음");
               %>
               <a class="titlecolor" href="Login.jsp">logout</a>
               <%
            }
               %>
            </div>
         </div>
         
      </header>
      <hr class="my-hr1">
   
      <header id="headdddd">
         <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
            <button class="aaa" type="button" data-toggle="collapse"data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            <span><img src="image/하트트.png"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
               <ul class="navbar-nav mr-auto">
                  <li class="nav-item"><a class="innercolor" href="Mypage.jsp">MyPage</a>&nbsp; &nbsp; &nbsp; &nbsp;</li>
                  <li class="nav-item"><a class="innercolor" href="list.do">Story</a>&nbsp;&nbsp; &nbsp; &nbsp;</li>
                  <li class="nav-item"><a class="innercolor" href="Mapmain.jsp">JMT map</a>&nbsp; &nbsp; &nbsp; &nbsp;</li>
                   <li class="nav-item"><a class="innercolor" href="Utube.jsp">Play</a>&nbsp;
               </ul>
            </div>
         </nav>
      </header>
   <hr class="my-hr1">
<div class="dropdown">
   &nbsp; &nbsp; &nbsp; &nbsp;
  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
   JMT List <span class="caret"></span>
  </button>
  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
        <li><input type="button" id="butn" class="button" value="#서면 맛집" onclick="button1()"></li>
      <li><input type="button" class="button" value="#남포동 맛집" onclick="button2()"></li>
      <li><input type="button" class="button" value="#해운대 맛집" onclick="button3()"></li>
      <li><input type="button" class="button" value="#동래 맛집" onclick="button4()"></li>
      <li><input type="button" class="button" value="#범어사 맛집" onclick="button5()"></li>
  </ul>
  <br><br>
</div>

   <main role="main" class="container" align="right">
   <div class="row">
      <div class="col-md-8 blog-main">


         <div class="blog-post">


            <div class="map_wrap">
               <div id="map"
                  style="width: 150%; height: 100%; position: relative; overflow: hidden;"></div>

               <div id="menu_wrap" class="bg_white">
                  <div class="option">
                     <div>
                        <form onsubmit="searchPlaces(); return false;">
                           keyword : <input type="text" value="서면 맛집" id="keyword"
                              size="15">
                           <button type="submit">search</button>
                        </form>
                     </div>
                  </div>
                  <hr>
                  <ul id="placesList"></ul>
                  <div id="pagination"></div>
               </div>

               <script type="text/javascript"
                  src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1b032c1996e179f015dfc92690e85686&libraries=services"></script>

               <script>
                  // 마커를 담을 배열입니다
                  var markers = [];

                  var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
                  mapOption = {
                     center : new daum.maps.LatLng(37.566826,
                           126.9786567), // 지도의 중심좌표
                     level : 3
                  // 지도의 확대 레벨
                  };

                  // 지도를 생성합니다    
                  var map = new daum.maps.Map(mapContainer, mapOption);

                  // 장소 검색 객체를 생성합니다
                  var ps = new daum.maps.services.Places();

                  // 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다
                  var infowindow = new daum.maps.InfoWindow({
                     zIndex : 1
                  });

                  // 키워드로 장소를 검색합니다
                  searchPlaces();

                  var keyword;

                  // 키워드 검색을 요청하는 함수입니다

                  function searchPlaces() {

                     keyword = document.getElementById('keyword').value;

                     // 키워드 유효성 검사
                     if (!keyword.replace(/^\s+|\s+$/g, '')) {
                        alert('키워드를 입력해주세요!');
                        return false;
                     }

                     // 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
                     ps.keywordSearch(keyword, placesSearchCB);
                  }

                  function button1() {
                     keyword = "서면 맛집";
                     ps.keywordSearch(keyword, placesSearchCB);
                  }
                  function button2() {
                     keyword = "남포동 맛집"
                     ps.keywordSearch(keyword, placesSearchCB);
                  }
                  function button3() {
                     keyword = "해운대 맛집"
                     ps.keywordSearch(keyword, placesSearchCB);
                  }
                  function button4() {
                     keyword = "동래 맛집"
                     ps.keywordSearch(keyword, placesSearchCB);
                  }
                  function button5() {
                     keyword = "범어사 맛집"
                     ps.keywordSearch(keyword, placesSearchCB);
                  }
                  
                  
                  // 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
                  function placesSearchCB(data, status, pagination) {
                     if (status === daum.maps.services.Status.OK) {

                        // 정상적으로 검색이 완료됐으면
                        // 검색 목록과 마커를 표출합니다
                        displayPlaces(data);

                        // 페이지 번호를 표출합니다
                        displayPagination(pagination);

                     } else if (status === daum.maps.services.Status.ZERO_RESULT) {

                        alert('검색 결과가 존재하지 않습니다.');
                        return;

                     } else if (status === daum.maps.services.Status.ERROR) {

                        alert('검색 결과 중 오류가 발생했습니다.');
                        return;

                     }
                  }

                  // 검색 결과 목록과 마커를 표출하는 함수입니다
                  function displayPlaces(places) {

                     var listEl = document.getElementById('placesList'), menuEl = document
                           .getElementById('menu_wrap'), fragment = document
                           .createDocumentFragment(), bounds = new daum.maps.LatLngBounds(), listStr = '';

                     // 검색 결과 목록에 추가된 항목들을 제거합니다
                     removeAllChildNods(listEl);

                     // 지도에 표시되고 있는 마커를 제거합니다
                     removeMarker();

                     for (var i = 0; i < places.length; i++) {

                        // 마커를 생성하고 지도에 표시합니다
                        var placePosition = new daum.maps.LatLng(
                              places[i].y, places[i].x), marker = addMarker(
                              placePosition, i), itemEl = getListItem(
                              i, places[i]); // 검색 결과 항목 Element를 생성합니다

                        // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
                        // LatLngBounds 객체에 좌표를 추가합니다
                        bounds.extend(placePosition);

                        // 마커와 검색결과 항목에 mouseover 했을때
                        // 해당 장소에 인포윈도우에 장소명을 표시합니다
                        // mouseout 했을 때는 인포윈도우를 닫습니다
                        (function(marker, title) {
                           daum.maps.event
                                 .addListener(marker, 'mouseover',
                                       function() {
                                          displayInfowindow(
                                                marker, title);
                                       });

                           daum.maps.event.addListener(marker,
                                 'mouseout', function() {
                                    infowindow.close();
                                 });

                           itemEl.onmouseover = function() {
                              displayInfowindow(marker, title);
                           };

                           itemEl.onmouseout = function() {
                              infowindow.close();
                           };

                        })(marker, places[i].place_name);

                        fragment.appendChild(itemEl);
                     }

                     // 검색결과 항목들을 검색결과 목록 Elemnet에 추가합니다
                     listEl.appendChild(fragment);
                     menuEl.scrollTop = 0;

                     // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
                     map.setBounds(bounds);

                  }

                  // 검색결과 항목을 Element로 반환하는 함수입니다
                  function getListItem(index, places) {

                     var el = document.createElement('li'), itemStr = '<span class="markerbg marker_'
                           + (index + 1)
                           + '"></span>'
                           + '<div class="info">'
                           + '   <h5>'
                           + places.place_name + '</h5>';

                     if (places.road_address_name) {
                        itemStr += '    <span>'
                              + places.road_address_name + '</span>'
                              + '   <span class="jibun gray">'
                              + places.address_name + '</span>';
                     } else {
                        itemStr += '    <span>' + places.address_name
                              + '</span>';
                     }

                     itemStr += '  <span class="tel">' + places.phone
                           + '</span>' + '</div>';

                     el.innerHTML = itemStr;
                     el.className = 'item';

                     return el;
                  }

                  // 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
                  function addMarker(position, idx, title) {
                     var imageSrc = 'http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
                     imageSize = new daum.maps.Size(36, 37), // 마커 이미지의 크기
                     imgOptions = {
                        spriteSize : new daum.maps.Size(36, 691), // 스프라이트 이미지의 크기
                        spriteOrigin : new daum.maps.Point(0,
                              (idx * 46) + 10), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
                        offset : new daum.maps.Point(13, 37)
                     // 마커 좌표에 일치시킬 이미지 내에서의 좌표
                     }, markerImage = new daum.maps.MarkerImage(
                           imageSrc, imageSize, imgOptions), marker = new daum.maps.Marker(
                           {
                              position : position, // 마커의 위치
                              image : markerImage
                           });

                     marker.setMap(map); // 지도 위에 마커를 표출합니다
                     markers.push(marker); // 배열에 생성된 마커를 추가합니다

                     return marker;
                  }

                  // 지도 위에 표시되고 있는 마커를 모두 제거합니다
                  function removeMarker() {
                     for (var i = 0; i < markers.length; i++) {
                        markers[i].setMap(null);
                     }
                     markers = [];
                  }

                  // 검색결과 목록 하단에 페이지번호를 표시는 함수입니다
                  function displayPagination(pagination) {
                     var paginationEl = document
                           .getElementById('pagination'), fragment = document
                           .createDocumentFragment(), i;

                     // 기존에 추가된 페이지번호를 삭제합니다
                     while (paginationEl.hasChildNodes()) {
                        paginationEl
                              .removeChild(paginationEl.lastChild);
                     }

                     for (i = 1; i <= pagination.last; i++) {
                        var el = document.createElement('a');
                        el.href = "#";
                        el.innerHTML = i;

                        if (i === pagination.current) {
                           el.className = 'on';
                        } else {
                           el.onclick = (function(i) {
                              return function() {
                                 pagination.gotoPage(i);
                              }
                           })(i);
                        }

                        fragment.appendChild(el);
                     }
                     paginationEl.appendChild(fragment);
                  }

                  // 검색결과 목록 또는 마커를 클릭했을 때 호출되는 함수입니다
                  // 인포윈도우에 장소명을 표시합니다
                  function displayInfowindow(marker, title) {
                     var content = '<div style="padding:5px;z-index:1;">'
                           + title + '</div>';

                     infowindow.setContent(content);
                     infowindow.open(map, marker);
                  }

                  // 검색결과 목록의 자식 Element를 제거하는 함수입니다Q~
                  function removeAllChildNods(el) {
                     while (el.hasChildNodes()) {
                        el.removeChild(el.lastChild);
                     }
                  }
               </script>

            </div>
         </div>
      </div>
   </div>
   </main>
   <br>
   
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
      integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
      crossorigin="anonymous"></script>
   <script>
      window.jQuery
            || document
                  .write('<script src="js/vendor/jquery-slim.min.js"><\/script>')
   </script>
   <script src="js/vendor/popper.min.js"></script>
   <script src="js/bootstrap.min.js"></script>
   <script src="js/vendor/holder.min.js"></script>
   <script>
      Holder.addTheme('thumb', {
         bg : '#55595c',
         fg : '#eceeef',
         text : 'Thumbnail'
      });
   </script>
</html>