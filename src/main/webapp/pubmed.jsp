<%-- 
    Document   : newjsp
    Created on : 30-Mar-2018, 20:39:20
    Author     : caikovsk
--%>

<%@page import="javax.naming.InitialContext"%>
<%@page import="food.diary.pubmed.entities.Article"%>
<%@page import="food.diary.pubmed.Loader"%>
<%@page import="javax.ejb.EJB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%! @EJB
            Loader bean;
        %>
        <%!     @Override
            public void init() throws ServletException {
                super.init();
                if (bean == null) {
                    bean = new Loader();
                }
            }%>
        <%
            for (Article a : bean.getArticles()) {
        %>
        <div class="article">
            <h1 class="title"><a href="<%=a.getUrl()%>"><%= a.getTitle()%></a></h1>
            <p class="abstract"><%= a.getAbstracts()%></p>
            <% if (!a.getKeywords().isEmpty()) {%>
            <p class="keywords"><span class="keywordsTitle">KEYWORDS: </span><%= a.getKeywords()%></p>
            <% } %>
        </div>
        <%
            }
        %>


    </body>
</html>
