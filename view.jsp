<%-- 
    Document   : tictactoe
    Created on : Mar 17, 2022, 8:36:07 PM
    Author     : Andualem Teshome
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>TicTacToe</title>
    <style>
      body {
       text-align: center;
      }
      .tile { 
        width:100px;
        height:100px; 
        border:1px black solid;
        font-size:xx-large;
      }

      .tile:hover{
        background-color:darkgray;
      }
      form{ 
       display: inline-block;
      }

      .winning{
       background-color:yellow;
      }
    </style>
  </head>
  <body>
    <h1>TicTacToe</h1>
    <p>X: ${stats.xwins} O: ${stats.owins} TIES ${stats.tie}</p>
    <c:forEach var="row" items="${game.board}" >
     <c:forEach var="tile" items="${row}" >
      <form action="GameServlet" method="post">
        <input type="hidden" name="row" value="${tile.row}" />
        <input type="hidden" name="col" value="${tile.col}" />
        <input class="tile ${tile.winning? 'winning': ''}" type="submit" name="clicked" value="${tile}"/>
      </form>
     </c:forEach>
     <br>
    </c:forEach>
    <h3>${game.message}</h3>
    <form method="GameServlet" method="post">
      <input type="submit" name="newgame" value="New Game" />
    </form>
  </body>
</html>
