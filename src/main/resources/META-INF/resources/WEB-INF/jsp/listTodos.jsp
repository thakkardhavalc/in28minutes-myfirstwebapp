<%@ include file="common\header.jspf" %>
<%@ include file="common\navigation.jspf" %>

<div class="container">

    <h1>Your Todos</h1>
    <table class="table">

        <thead>
            <tr>
                <th>Description</th>
                <th>Target Date</th>
                <th>Is Completed?</th>
                <th></th>
                <th></th>
            </tr>
        </thead>

        <tbody>
            <c:forEach items="${toDos}" var="toDos">
                <tr>
                    <td>${toDos.description}</td>
                    <td>${toDos.targetDate}</td>
                    <td>${toDos.done}</td>
                    <td>
                        <a href="delete-todo?id=${toDos.id}" class="btn btn-danger">Delete</a>
                    </td>
                    <td>
                        <a href="update-todo?id=${toDos.id}" class="btn btn-warning">Update</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>

    </table>

    <a href="add-todo" class="btn btn-success">Add Todo</a>

</div>

<%@ include file="common\footer.jspf" %>