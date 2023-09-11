<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <%-- 브라우저에게 jsp 페이지라는것을 알려줌 --%>

<p>
	현재 시간 : <%= Calendar.getInstance().getTime() %>
</p>