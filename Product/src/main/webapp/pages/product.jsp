<html>
<head>

<style>
table, td, th {
	border: 1px solid red;
}

td, th {
	padding: 10px;
}

table {
	margin: auto;
}
</style>

<script>
	var xmlhttp;

	function allProduct() {

		xmlhttp = new XMLHttpRequest();

		xmlhttp.onload = display;

		xmlhttp.open("alldata", "productapi/allProduct");

		xmlhttp.send();

	}

	function display() {

		

		var table = document.getElementById("producttable");
		
		
		table.innerhtml="";

		var headrow = document.createElement("tr");

		var pidheader = document.createElement("th");
		var pnameheader = document.createElement("th");
		var priceheading=document.createElement("th");
		var imgheading=document.createElement("th");

		var pidvalue = document.createTextNode("Product ID");
		var namevalue = document.createTextNode("Product Name");
		var pricevalue=document.createTextNode("Product price");
		var imgvalue=document.createTextNode("Product image");
		
		
		pidheader.appendChild(pidvalue);
		pnameheader.appendChild(namevalue);
		priceheading.appendChild(pricevalue);
		imgheading.appendChild(imgvalue);
		
		headrow.appendChild(pidheader);
		headrow.appendChild(pnameheader);
		headrow.appendChild(priceheading);
		headrow.appendChild(imgheading);
		
		table.appendChild(headrow);
		
		/*

		var allJsonString = xmlhttp.responseText;

		var p1 = document.getElementById("p1");

		p1.innerHTML = allJsonString;
		
		*/
		
		var data=xmlhttp.responseText;

		
		data=data.substring(1,data.length-1);
		
		var newstr="";
		
		for(var i=0;i<data.length;i++){
			
			
			var character=data[i];
			
			if(character == "," && data[i+1]=="{"){
				   newstr=newstr+"#";
				}
			else{
				newstr=newstr+character;
			}
	      }
		var jasonstring=newstr.split("#");
		
		
		
		
		for(var i=0;i<jasonstring.length;i++){
			  
			var jsonrecord=jasonstring[i];
			
											
			var object=JSON.parse(jsonrecord);
			
			
			var row=document.createElement("tr");
			
			var pidtd=document.createElement("td");
			var nametd=document.createElement("td");
			var pricetd=document.createElement("td");
			var imagetd=document.createElement("td");
			
			var pidvalue=document.createTextNode(object.pid);
			var namevalue=document.createTextNode(object.name);
			var pricevalue=document.createTextNode(object.price);
			var productimage=document.createElement("img");
			
			productimage.src="/images/"+object.imagepath;
			productimage.width="40";
			productimage.height="40";
			
			pidtd.appendChild(pidvalue);
			nametd.appendChild(namevalue);
			pricetd.appendChild(pricevalue);
			imagetd.appendChild(productimage);
			
			row.appendChild(pidtd);
			row.appendChild(nametd);
			row.appendChild(pricetd);
			row.appendChild(imagetd);
			
			table.appendChild(row);
		
		}
		
	}
		
	function getData(button)
	{
		
		var pid=document.productform.pid.value;// reading product id typed by user
		
		xmlhttp=new XMLHttpRequest(); // XMLHttpRequest is predefined class

		buttonClicked=button.value;

		if(buttonClicked=="get")
		{
						
						xmlhttp.open("get","productapi/viewproduct/"+ pid);// send pid to API method
		}
			
		xmlhttp.onload=displayResponse2; 

		
				
		xmlhttp.send();
							
	}

	function displayResponse2()
	{	
		
		var jsonstring=xmlhttp.responseText;
		
		

		var obj=JSON.parse(jsonstring); // parse() converts JSON String to JavaScript object

				
		var name=obj.name;
		var price=obj.price;
		
			document.productform.name.value=name;
			document.productform.price.value=price;
			var productImage=document.getElementById("i1");
			
			productImage.src="/images/"+obj.imagepath;
			productImage.width="40";
			productImage.height="40";
			
		
	}
		
		
		
</script>






</head>
<body>

welcome ${username}

<%!
  String imageURL="";
%>

<%
	imageURL="/images/"+ request.getAttribute("imagepath");
%>
<br><br>
<img src=<%=imageURL %> height=100px width=100px>
<br><br>


<span id="message">waiting</span>
<br><br>

	<form name="productform">

        <input type="text" name="pid"  placeholder="Enter Product Id"><br><br>
        <input type="text" name="name" placeholder="Enter Product Name"><br><br>
        <input type="text" name="price" placeholder="Enter Product Price"><br><br>
        
        <img id="i1"><br><br><br><br>
        
		<input type="button" value=alldata onclick="allProduct()">
		<input type=button value=get onclick="getData(this)">
		
		<table id="producttable">

	</table>
		

	</form>

	

	<p id="p1">All Data</p>

</body>

</html>