<html>
<head>







</head>

<body>

<span id="message">${message}</span>

<form name="productform" enctype="multipart/form-data">

  <input tyep="text" name="pid" placeholder="Enter Product ID" > <span id="errorMessage"></span><br><br>
  
  <input type="text" name="name" placeholder="Enter Product Name"><br><br>
  
  <input type="text" name="price" placeholder="Enter Product Price"><br><br>
  
  <input type="text" name="cid" placeholder="Enter Category ID"><br><br>
  
  <label>Select Photo   </label>
  <input type="file" name="images"><br><br>

  <input type="button" value="alldata" onclick="allProduct()">
  <input type=submit value=post formmethod=post formaction="saveProduct">

  <br><br><br>
  
  <table id="producttable">
  </table>

</form>

<p id="p1"> Test </p>

</body>

</html>
