<%--
  Created by IntelliJ IDEA.
  User: Artyom
  Date: 13.11.2014
  Time: 6:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>ЯМА - Каталог</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
          rel="stylesheet">
    <link rel="stylesheet" href="res/stylesheet.css">
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="res/prefixfree.min.js"></script>

    <link href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700&amp;subset=latin,cyrillic-ext"
          rel="stylesheet" type="text/css">
</head>
<body>

<div class="navbar navbar-default navbar-static-top navbar-inverse ericpol-header">
    <div class="container">
        <div class="navbar-header">
            <a type="button" href="http://localhost:8080/" class="navbar-toggle ericpol-header-menu-button" data-toggle="collapse"
               data-target=".navbar-collapse"><img src="res/menu-button-icon.gif" alt=""></a>
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          <span class="navbar-brand">
            <a href=""><img src="res/logo.png" alt=""></a>
          </span>
        </div>
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="http://localhost:8080/">Главная</a>
                </li>
                <li class="ericpol-header-active">
                    <a href="http://localhost:8080/Catalog">Каталог</a>
                </li>
                <li>
                    <a href="#">Корзина</a>
                </li>
            </ul>
        </div>
    </div>
</div>

<div class="container ericpol-catalog-container">
    <form class="ericpol-search container">
        <div>
            <input type="text" class="" placeholder="Поиск товара" value="Sony"><input type="submit" value="Поиск"/>
        </div>
    </form>

    <div class="col-md-4 left">
        <div class="block sticky search-page">
            <div class="sort" style="border-bottom: 1px solid rgba(0,0,0,0.1);">
                <table>
                    <tr>
                        <td><label for="brand">Производитель</label></td>
                        <td>
                            <select name="brand" id="brand">
                                <option value="apple">Выберите производителя</option>
                                <option value="apple">--------</option>
                                <option value="apple">Apple</option>
                                <option value="acer">Acer</option>
                                <option value="asus">Asus</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="type">Тип</label></td>
                        <td>
                            <select name="type" id="type">
                                <option value="laptop">Ноутбук</option>
                                <option value="monitor">Монитор</option>
                                <option value="keyboard">Клавиатура</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="">Цена($)</label></td>
                        <td>
                            <input type="text" style="border-right:0px;" name="from" placeholder="От"/>
                            <input type="text"  name="to" placeholder="До"/>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    <div class="col-md-8 right">
        <div class="block">
            <div class="search-result">
                Результаты поиска по запросу "Sony":
            </div>
        </div>
        <div class="block" style="margin-top: 15px !important;">
            <div class="items-view-list">
                <div class="item">
                    <img src="res/sony-vaio-noutbuk.jpg" alt=""/>
                    <div class="title">
                        Sony Vaio SVT1311MR1S
                        <div class="description">Ультрабук с 13" экраном, построенный на платформе Intel и снабженный гибридным либо твердотельным накопителем...</div>
                        <span>Цена: 550$</span>
                        <a href="http://localhost:8080/Catalog/sony-vaio-svt1311mr1s">Подробнее</a>
                    </div>
                </div>
                <div class="item">
                    <img src="res/sony-vaio-noutbuk.jpg" alt=""/>
                    <div class="title">
                        Sony Vaio SVT1311MR1S
                        <div class="description">Ультрабук с 13" экраном, построенный на платформе Intel и снабженный гибридным либо твердотельным накопителем...</div>
                        <span>Цена: 550$</span>
                        <a href="http://localhost:8080/Catalog/sony-vaio-svt1311mr1s">Подробнее</a>
                    </div>
                </div>
                <div class="item">
                    <img src="res/sony-vaio-noutbuk.jpg" alt=""/>
                    <div class="title">
                        Sony Vaio SVT1311MR1S
                        <div class="description">Ультрабук с 13" экраном, построенный на платформе Intel и снабженный гибридным либо твердотельным накопителем...</div>
                        <span>Цена: 550$</span>
                        <a href="http://localhost:8080/Catalog/sony-vaio-svt1311mr1s">Подробнее</a>
                    </div>
                </div>
                <div class="item">
                    <img src="res/sony-vaio-noutbuk.jpg" alt=""/>
                    <div class="title">
                        Sony Vaio SVT1311MR1S
                        <div class="description">Ультрабук с 13" экраном, построенный на платформе Intel и снабженный гибридным либо твердотельным накопителем...</div>
                        <span>Цена: 550$</span>
                        <a href="http://localhost:8080/Catalog/sony-vaio-svt1311mr1s">Подробнее</a>
                    </div>
                </div>
            </div>
        </div>

        <div align="center">
            <ul class="pagination">
                <li><a href="#"><span aria-hidden="true">&laquo;</span><span class="sr-only">Previous</span></a></li>
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#"><span aria-hidden="true">&raquo;</span><span class="sr-only">Next</span></a></li>
            </ul>
        </div>
    </div>
</div>

<div class="container ericpol-footer">
    <div class="col-md-4" align="left">
        <div class="title">Контакты</div>
        <ul>
            <li>+375(25)123-45-67</li>
            <li>shop@jama.com</li>
            <li>ул. Держинского, д.52</li>
        </ul>
    </div>
    <div class="col-md-4" align="center">
        <div class="title">Тех. поддержка</div>
        <ul>
            <li>+375(162)98-76-54</li>
            <li>support@jama.com</li>
        </ul>
    </div>
    <div class="col-md-4" align="right">
        <img src="res/logo-footer.png" alt="">
        <br>Designed by
        <br>
        <a href="https://github.com/ArtyomShaitor/OnlineShopEricpol/"><img src="res/github-icon.png" alt="">Ericpol Probationers</a>
    </div>
</div>
<script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<script>
    $(document).ready(function(){
        initScroll()
    });

    window.onscroll = function(){
        if( $(window).width() < 990 ) return false;
        initScroll();
    };

    initScroll = function (){
        if ( $(window).scrollTop() > 122 ) $(".left .block").addClass("sticky"); else $(".left .block").removeClass("sticky");
    };

</script>
</body>
</html>
