<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
  <head>
    <title>Person</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
  </head>
  <body>
    <div class="personForm">
      <h1>add person info...</h1>
      <form method="POST" name="person">
              Name: <input type="text" name="name" /><br/>
              Address: <textarea name="address" cols="80" rows="5"></textarea><br/>
              Zip Code: <input type="text" name="zipCode" /><br/>
              Phone: <input type="text" name="phone" /><br/>
        <input type="submit" value="Add" />
      </form>
    </div>
  </body>
</html>