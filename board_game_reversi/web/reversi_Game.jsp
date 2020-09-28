<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : reversi_Game
    Created on : Nov 16, 2017, 1:45:41 PM
    Author     : saifalkayali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="GameCSS.css">
        <title>Reversi Game</title>
    </head>
    <body>
        <h1> Welcome to Reversi: The Thinking Challenge</h1>
        <h2> <div class="gameStatus"></div><br>
                    Current Player : <span class="${game.currentPlayer}">${game.currentPlayer}</span></h2>
        <h2> <div class="gameStatus"></div> Black Score:${game.blackScore} <br>
            White Score:${game.whiteScore}
        </h2>
        <td colspan="3">
        <form action="reset">
            <input class="resetBtn" type="submit" value="Restart" name="resetBtn" />
        </form>
    </td>
    
          
        <table  border="1" cellspacing="0">
            
            
            <c:forEach var="row" items="${game.board}" varStatus="rowStat" >
              
                    <tr>
                    
                    <c:forEach var="col" items="${row}" varStatus="colStat">
                    
                        <td> <div class="${col.color}Token">
                                <c:choose>
                                    <c:when test="${empty col}">
                                        <form action="play">
                                            <input type="hidden" name="row" value="${rowStat.index}" />
                                            <input type="hidden" name="col" value="${colStat.index}" />
                                            <input class="open" type="submit" value="&nbsp;" name="markBtn">
                                        </form>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="${col.color}Token"></div>
                                    </c:otherwise>
                                </c:choose>

                            </div>
                        </td> 
                    </c:forEach>
                </tr>
            </c:forEach>
            
        </table>
    <td colspan="3">
        <form action="quit">
            <input class="quitBtn" type="submit" value="Quit" name="Quit" />
        </form>
    </td>    
    <h2 class="errMsg"><br><c:if test="game.errMsg != \"\" ">
        </c:if>${game.errMsg}</h2> 
        
    </body>
    
</html>
