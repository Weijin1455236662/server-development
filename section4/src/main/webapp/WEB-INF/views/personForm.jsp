<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
<h1>Register</h1>

<sf:form method="POST" commandName="person" >
  <sf:errors path="*" element="div" cssClass="errors" />
  <sf:label path="name"
      cssErrorClass="error">Name</sf:label>:
    <sf:input path="name" cssErrorClass="error" /><br/>
  <sf:label path="address"
      cssErrorClass="error">Address</sf:label>:
    <sf:input path="address" cssErrorClass="error" /><br/>
  <sf:label path="zipCode"
      cssErrorClass="error">ZipCode</sf:label>:
    <sf:input path="zipCode" cssErrorClass="error" /><br/>
  <sf:label path="phone"
      cssErrorClass="error">Phone</sf:label>:
    <sf:input path="phone" cssErrorClass="error" /><br/>
  <input type="submit" value="Add" />
</sf:form>
