<%-- 
    Document   : searchReults
    Created on : 17 Jul 2023, 6:50:06 PM
    Author     : andil
--%>

<%@page import="java.util.List"%>
<%@page import="com.facebook.entities.FacebookUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="searchStyle.css">
</head>
<body id="body" class="body">
    <header>
        <div class="logo-container">
            <img src="facebook.png" alt="">
        </div>
        <div class="search-container">
            <img src="search.svg" alt="">
            <form action="" method="">
                <input type="search" name="search" id="search-main" placeholder="Search anything">
            </form>
        </div>
        <div class="list-container">
            <ul>
                <li><a href="#" id="home"><i class="fa-solid fa-house"></i></a></li>
                <li><a href="#" id="videos"><i class="fa-solid fa-play"></i></a></li>
                <li><a href="#" id="market-place"><i class="fa-solid fa-shop"></i></a></li>
                <li><a href="#" id="groups"><i class="fa-solid fa-users-line"></i></a></li>
                <li><a href="#" id="gaming"><i class="fa-solid fa-gamepad"></i></a></li>
            </ul>
        </div>
        <div class="second-list">
            <ul>
                <li><a href="#" id="messenger"><button><img src="menu.svg" alt=""></button></a></li>
                <li><button onclick="toogleHidden('messeges')" id="msg-btn"><i class="fa-brands fa-facebook-messenger"></i></button></li>
                <li><button onclick="toogleHidden('notifications')" id="notif"><i class="fa-solid fa-bell"></i></button></li>
                <li><button id="user-home" onclick="toogleHidden('user-about')"><img src="user.png" alt=""></button></li>
            </ul>
        </div>
    </header>
    <div class="left-side">
        
        <a href="#"> 
            <button><i class="fa-solid fa-user"></i> Andile Mazibuko</button>
        </a>
        <a href="#"> 
            <button> <i class="fa-solid fa-bookmark" style="color: #d335f3;"></i>Saved</button>
        </a>
        <a href="#"> 
            <button><i class="fa-solid fa-user-group" style="color: #00aaff;"></i>Friends</button>
        </a>
        <a href="#"> 
            <button><i class="fa-solid fa-users-line" style="color: #00aaff;"></i>Groups</button>
        </a>
        <a href="#"> 
            <button><i class="fa-solid fa-calendar-days" style="color: #00aaff;"></i>Most recent</button>
        </a>
        <a href="#"> 
            <button><i class="fa-solid fa-shop" style="color: #00aaff;"></i>Marketplace</button>
        </a>
        <a href="#"> 
            <button><i class="fa-solid fa-play" style="color: #00aaff;"></i>Watch</button>
        </a>

        <hr style="position: absolute; left: 0;">
    </div>
    <div class="results">
        <%
            List<FacebookUser>users = (List<FacebookUser>)session.getAttribute("searchResults");
            for(FacebookUser user : users){%>
        <div class="user-container">
            <div class="prof_pic">
                <img src="user.png" alt="">
            </div>
            <div class="user-description">
                <h4>
                    <%= user.getFirstName().toLowerCase() +" "+ user.getLastName().toLowerCase() %>
                </h4>
                <p>
                    Friend. Not yet working 
                </p>
                <form action="AddFriendServlet.com" method="post">
                    <button type="submit" name="friendId" value="<%=user.getId()%>">Add Friend</button>
                </form>
            </div>
        </div>
        <%}%>
       
    </div>
    
</body>