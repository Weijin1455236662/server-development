<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>person</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/style.css" />" >
  </head>
  <body>
    <div class="personView">
      <span>Name: </span>
      <span class="personMessage"><c:out value="${person.name}" /></span>
      <div>
        <span>Address: </span>
        <span class="spittleLocation"><c:out value="${person.address}" /></span>
      </div>
      <div>
        <span>ZipCode: </span>
        <span class="spittleLocation"><c:out value="${person.zipCode}" /></span>
      </div>
      <div>
        <span>Phone: </span>
        <span class="spittleLocation"><c:out value="${person.phone}" /></span>
      </div>
    </div>
  </body>
</html>