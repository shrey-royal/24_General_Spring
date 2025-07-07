<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Show Form</title>
  </head>
  <body>
      <h1 class="title">User Form</h1>
      <form action="send" method="post">
        <label for="name">Name: </label>
        <input type="text" name="name" id="name" /><br />
        <label for="email">Email: </label>
        <input type="email" name="email" id="email" /><br />
        <input type="submit" value="Send Data" />
      </form>
  </body>
</html>