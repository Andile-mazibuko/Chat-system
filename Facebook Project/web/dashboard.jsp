<%-- 
    Document   : dashboard
    Created on : 09 Jul 2023, 4:53:57 PM
    Author     : andil
--%>

<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.File"%>
<%@page import="com.facebook.entities.Post"%>
<%@page import="com.facebook.processor.Notification"%>
<%@page import="com.facebook.entities.Friend"%>
<%@page import="java.util.List"%>
<%@page import="com.facebook.entities.FacebookUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Facebook</title>
    <link rel="icon" href="facebook.png">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="style.css">
</head>
<body id="body" class="body">
    
    <%
        FacebookUser user = (FacebookUser)session.getAttribute("user");
        List<Post>posts = (List<Post>)session.getAttribute("posts");
        List<Notification> friendRequests = (List<Notification>)session.getAttribute("friendRequests");
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
    %>
    <header>
        <div class="logo-container">
            <img src="facebook.png" alt="">
        </div>
        <div class="search-container">
            <img src="search.svg" alt="">
            <form action="SearchServlet.com" method="post">
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
            <button><i class="fa-solid fa-user"></i> <%=firstName+" "+lastName%></button>
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
    <div class="container">
        
        <div class="stories-container">
            <button class="btn-story"><i class="fa-sharp fa-solid fa-book-open"></i>  stories</button>
            <button class="btn-reel"><i class="fa-regular fa-clapperboard-play"></i>  Reels</button>
            <hr>
            
            <div class="stories">
               <form action="">
                    <button type="submit" value="">
                        <div class="story">
                            <div class="story-cont">
                                <img src="IMG_20230217_012654.png" alt="">
                            </div>
                            <div class="prof_pic">
                                <img src="user.png" alt="">
                            </div>
                            
                        </div>
                    </button>
                    <button type="submit" value="">
                        <div class="story">
                            <div class="story-cont">
                                <img src="IMG_20230217_012654.png" alt="">
                            </div>
                            <div class="prof_pic">
                                <img src="user.png" alt="">
                            </div>
                            
                        </div>
                    </button>
                    
                    <button type="submit" value="">
                        <div class="story">
                            <div class="story-cont">
                                <img src="IMG_20230217_012654.png" alt="">
                            </div>
                            <div class="prof_pic">
                                <img src="user.png" alt="">
                            </div>
                            
                        </div>
                    </button>
                    
                    <button type="submit" value="">
                        <div class="story">
                            <div class="story-cont">
                                <img src="IMG_20230217_012654.png" alt="">
                            </div>
                            <div class="prof_pic">
                                <img src="user.png" alt="">
                            </div>
                            
                        </div>
                    </button>
                    
                    <button type="submit" value="">
                        <div class="story">
                            <div class="story-cont">
                                <img src="IMG_20230217_012654.png" alt="">
                            </div>
                            <div class="prof_pic">
                                <img src="user.png" alt="">
                            </div>
                            
                        </div>
                    </button>
                    
                    <button type="submit" value="">
                        <div class="story">
                            <div class="story-cont">
                                <img src="IMG_20230217_012654.png" alt="">
                            </div>
                            <div class="prof_pic">
                                <img src="user.png" alt="">
                            </div>
                            
                        </div>
                    </button>
                    <button type="submit" value="">
                        <div class="story">
                            <div class="story-cont">
                                <img src="IMG_20230217_012654.png" alt="">
                            </div>
                            <div class="prof_pic">
                                <img src="user.png" alt="">
                            </div>
                            
                        </div>
                    </button>
                    
                    
                
                
            </form>
            </div>
            
        </div>
        <div class="make-post">
            <div class="post-pp">
                <img src="user.png" alt="" >
            </div>
            <button onclick="showPopUp()" class="post-pop-up">What's on your mind, <%=firstName%>?</button>
            <hr>
            <a href="" class="post-type">
                <button ><i class="fa-solid fa-play" style="color: #db1414;"></i> Live Video</button>
            </a>
            <a href="" class="post-type">
                <button ><i class="fa-solid fa-photo-film" style="color: #14bb11;"></i> Photo / Video</button>
            </a>
            <a href="" class="post-type">
                <button ><i class="fa-regular fa-face-smile" style="color: #eacb06;"></i> Feeling / Activity</button>
            </a>
        </div>
        
        <div class="make-post create-post-popup" id="post-visibility">
            <h1>Create post</h1>
            <button class="cancel" onclick="showPopUp()">x</button>
                <hr>
            <div class="create-post-pp">
                <img src="user.png" alt="">
            </div><h2><%=firstName%> <%=lastName%></h2> 
            <form action="PostServlet.com" method="post" enctype="multipart/form-data">
                <input type="text" name="post-content" placeholder="What's on your mind, <%=firstName%>?" class="post-cont">
                <input type="file" name="post-file" id="file" value="Upload Image">
                <label for="file">Upload Image</label>
                <button type="submit" value="">Post</button>
            </form> 
        </div>
        
        <div class="posts">
            <!--1st post-->
            <%
                
                for(int i = 0; i < posts.size() ;i++){
            
                File file = new File("D:/Files/projects/Git projects/Chat-system/Facebook Project/web/post/"+posts.get(i).getFileName());
                //file.createNewFile();
                
                OutputStream outputStream = new FileOutputStream(file);
                outputStream.write(posts.get(i).getPostMedia());
                outputStream.flush();
                outputStream.close();
            %>
            <div class="post pic" id="with_pic">
                <div class="post-pp">
                    <img src="user.png" alt="">
                </div>
                <div class="post-owner-username">
                    Andile Mazibuko
                </div>
                
                <div class="time-posted">
                    9h ago
                </div>
                <div class="pic-area">
                    <img src="post/<%= posts.get(i).getFileName()%>" alt="">
                </div>
                <div class="post-summary">
                    <i class="fa-solid fa-thumbs-up" style="color: rgb(15, 15, 226);"></i>
                    <i class="fa-solid fa-heart" style="color: #ff0000;"></i>
                    <span>296</span> <span>6 comments</span><span>2 shares</span>
                </div>
                <div class="action-buttons">
                    <div class="react-btns">
                        <form action="">
                            <button type="submit" name="reaction" value="like"><i class="fa-solid fa-thumbs-up" style="color: rgb(15, 15, 226);"></i></button>
                            <button type="submit" name="reaction" value="love"><i class="fa-solid fa-heart" style="color: #ff0000;"></i></button> 
                            <button type="submit" name="reaction" value="angry"><i class="fa-solid fa-face-angry" style="color: #e79118;"></i></button> 
                            <button type="submit" name="reaction" value="sad"><i class="fa-solid fa-face-sad-tear" style="color: #eca918;"></i></button>
                        </form>
                        
                    </div>
                    <div class="reaction">
                        <a href="#"><i class="fa-solid fa-thumbs-up" style="color: #fbfcfe;"></i> <span>Lke</span></a>
                        
                    </div>
                    

                    <div class="comment">
                        <a href="#"><i class="fa-regular fa-comment" style="color: #ffffff;"></i><span>comment</span></a>
                    </div>
                    <div class="share">
                        <a href="#">
                            <i class="fa-solid fa-share" style="color: #cccccc;"></i><span>Share</span></a>
                            
                    </div>
                
                </div>
            </div>

            <%}%>
            
            
            <div class="post pic" id="with_pic"></div>
            <div class="post pic" id="with_pic"></div>
            
        </div>

    </div>
    <div class="right-side">
        <div class="adds-area">
            <div class="advert">

            </div>
        </div>
        <hr>
        <div class="birthday-area">
            <img src="gift.png" alt="">
            <span> 2 friends with birthdays today</span>
        </div>
        <hr>
        <div class="friends">
            <form action="" method="">
            
                <!--Start-->
                
                <%
                    List<FacebookUser> userFriends = (List<FacebookUser>)session.getAttribute("userFriends");
                    for(int i = 0; i < userFriends.size(); i++){
                %>
                <button type="submit" class="user_msg_container" value="<%=userFriends.get(i).getId()%>">
                    <div class="post-pp">
                        <img src="user.png" alt="">
                    </div> 
                    
                    <span class="msg_sender">
                        <b><%=userFriends.get(i).getFirstName()%> <%=userFriends.get(i).getLastName()%></b>
                    </span>
                
                </button>
                <%}%>
                
                <!--The end-->

            </form>
        </div>
        
       
    </div>







    <div class="hidden messesges" id="msgs">
        <div class="msg_nav">
            <h2>Chats</h2>
            <ul>
                <li><i class="fa-regular fa-ellipsis" style="color: #c7c7c7;"></i></i></li>
                <li><i class="fa-solid fa-maximize" style="color: #c7c7c7;"></i></i></li>
                <li><i class="fa-light fa-video-plus" style="color: #b0b0b0;"></i></li>
                <li><i class="fa-solid fa-pen-to-square" style="color: #adadad;"></i></li>
            </ul>
        </div>
        <div class="msg_search">
            <form action="" >
                <div class="search-cont">
                    <i class="fa-sharp fa-solid fa-magnifying-glass" style="color: #bababa;"></i>
                    <input type="search" value="" name="search_msg" placeholder="Search in messenger">
                </div>
            </form>
        </div>
        <div class="toggle_bns">
                <button>
                    Inbox
                </button>
    
                <button>
                    communities
                </button>
            
        </div>
        <div class="hidden-content">
            <%for(int i =0; i < 5; i++){%>
            <form action="">

                <!--start-->
            <button type="submit" class="user_msg_container">
                <div class="post-pp">
                    <img src="user.png" alt="">
                </div> 
                
                <span class="msg_sender">
                    <b>Andile Mazibuko</b>
                </span>
                <span style="color: rgb(73, 119, 247)" class="msg_cont"><b>messge</b></span>
                <!--
                    for read messeges
                <p style="color: rgb(212, 209, 209)">messge</p>
                -->
                <div style="background-color: rgb(73, 119, 247);" class="msg-status-dot"></div>
                <!--
                    for read messeges
                    <div style="background-color: #fff;" class="msg-status-dot"></div>
                -->
            </button>
            <%}%>
            <!--The end-->
        </form>
        </div>
    </div>
    <div class="hidden" id="notif-hidden">
        <div class="msg_nav">
            <h2>Notifications</h2>
            
            <button class="more" >
                <img src="more-horizontal.svg" alt="">
            </button>
        
        </div>
        <div class="toggle_bns" style="top: 6%;">
            
                <button>
                    All
                </button>
        
                <button>
                    Unread
                </button>
        </div>
        <div class="hidden-content" style="height: 89%;">
           <%for(Notification notification: friendRequests){%>
            <div class="notification-container">
                <div class="post-pp" style="position: absolute; left: 2%;">
                    <img src="user.png" alt="">
                </div>
                <div class="text">
                    <%//tesing with an id%>
                    <b><%=notification.getFirstname()+" "+notification.getLastname()%></b> sent you a friend request
                    
                    <br>
                    <i>8 weeks ago</i>
                    <form action="ApproveOrDeleteFriend.com" method="post">
                        <button type="submit" value="Confirm:<%=notification.getOwnerId()%>" name="request button" style="background-color: rgb(73, 119, 247);"><b>Confirm</b></button>
                        <button type="submit" value="Delete:<%=notification.getOwnerId()%>" name="request button" ><b>Delete</b></button>
                    </form>
                </div>
            </div>
            <%}%>
            <!--
                Second notification
            -->
            
        </div>
    </div>
    <div class="hidden user-about" id="user-about">
        <div class="user-account">
            <div class="prof_pic">
                <img src="user.png" alt="">
            </div>
            <span><%=firstName +" "+ lastName%> </span>
            <hr>
        
        </div>


        <a href="" class="settings" style="top: 47%;">
            <div class="prof_pic">
                <img src="settings.svg" alt="" style="height: 60%;">
            </div>
            <span>Settings & privacy</span>
            
        </a>
        <a href="" class="log-out" style="top: 68%;">
            <div class="prof_pic">
                <img src="log-out.svg" alt="" style="height: 60%;">
            </div>
            <span>log Out</span>
            
        </a>
        
    </div>

     <script type="text/javascript" src="script.js"></script>
    
    <footer></footer>
</body>      
</html>
