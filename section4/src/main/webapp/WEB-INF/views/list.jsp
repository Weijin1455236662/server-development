<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
  <head>
    <title>Person</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/list.css" />" >
    <script type="text/javascript" src="<c:url value="/resources/list.js" />"></script>
  </head>
  <body>
    <div class="listTitle">
      <h1>Address Book</h1>
      <table class="personList">
        <tr>
          <th class="name">Name</th>
          <th class="address">Address</th>
          <th class="zipCode">ZipCode</th>
          <th class="phone">Phone</th>
          <th class="modify">M</th>
          <th class="delete">D</th>
        </tr>
        <c:forEach items="${personList}" var="person" varStatus="idxStatus">
          <tr id="person_<c:out value="person.id"/>">
            <td class="tableName_${idxStatus.index}"><c:out value="${person.name}" /></td>
            <td>
              <span class="tableAddress_${idxStatus.index}"><c:out value="${person.address}" /></span>
              <input type="text" class="modifyAddress_${idxStatus.index}" value="${person.address}">
            </td>
            <td>
              <span class="tableZipCode_${idxStatus.index}"><c:out value="${person.zipCode}" /></span>
              <input type="text" class="modifyZipCode_${idxStatus.index}" value="${person.zipCode}">
            </td>
            <td>
              <span class="tablePhone_${idxStatus.index}"><c:out value="${person.phone}" /></span>
              <input type="text" class="modifyPhone_${idxStatus.index}" value="${person.phone}">
            </td>
            <td>
              <button class="modifyButton_${idxStatus.index}" onclick="modifyChange(${idxStatus.index})">Modify</button>
              <button class="modifyConfirm_${idxStatus.index} noDisplay" onclick="modifyPerson(${idxStatus.index})">Confirm</button>
              <button class="modifyCancel_${idxStatus.index} noDisplay" onclick="modifyChange(${idxStatus.index})">Cancel</button>
            </td>
            <td>
              <button class="deleteButton" onclick="deletePerson('${person.name}')">Delete</button>
            </td>
          </tr>
        </c:forEach>
      </table>
    </div>
    <a href="<c:url value="/person/add" />">Add</a>
  </body>
</html>