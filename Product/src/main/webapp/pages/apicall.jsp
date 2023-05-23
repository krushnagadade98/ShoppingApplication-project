<html>

<head>

<style>
	span
	{
		font-size: 30px;
		color:red;
		margin: 400px;
	}
</style>




<script>

            var xmlhttp;
            var buttonClicked;
            var message;
            
          function sendData(button){
        	  var cid=document.categoryform.cid.value;
        	  var name=document.categoryform.name.value;
        	  
        	  var javascriptobject={"cid":cid,"name":name};
        	  
        	  xmlhttp=new XMLHttpRequest();
        	 
        	  buttonClicked=button.value;
        		  
        	  if(buttonClicked == "post"){
        		  
        	  message="Data Posted Succesfully";	  
        	  xmlhttp.open("post","categoryapi/insert");
        	  
        	  }else{
        		  
        		  
        		  message="Data Updated Succesfully";
            	  xmlhttp.open("put","categoryapi/updateCategory");

        	  }
        	  
        	  xmlhttp.onload=displayResponse;
        	  
        	  var jsonstring=JSON.stringify(javascriptobject);
        	  
        	  xmlhttp.setRequestHeader('Content-type', 'application/json')
      		
      		  xmlhttp.send(jsonstring);
        	  
        	  
          }


          function displayResponse(){
        	  alert(xmlhttp.responseText);
        	  document.getElementById("message").innerHTML=message;
        	  
        	  
          }


          function getData(button){
        	  var cid=document.categoryform.cid.value;        	  
        	  xmlhttp=new XMLHttpRequest();
        	  
        	  buttonClicked=button.value;
        	  
        	  if(buttonClicked == "get"){
        		  
        	  message="Date Retrieved Succesfully";  
        	  xmlhttp.open("get","categoryapi/getCategory/"+ cid);
        	  
        	  }else{
        		  message="Date Deleted Succesfully";  
            	  xmlhttp.open("delete","categoryapi/deleteCategory/"+ cid);
        	  }
        	  
        	  xmlhttp.onload=displayResponse2; 
        	  
        	  xmlhttp.send();
        	  
      		 

          }


          function displayResponse2(){
        	  var jsonstring=xmlhttp.responseText;
      		var obj=JSON.parse(jsonstring);
      		
    		var name=obj.name;
    		
    		if(obj.message!=undefined){
    			document.categoryform.name.value="";
    			document.getElementById("message").innerHTML=obj.message;
    		}else{
    			document.categoryform.name.value=name;

    			document.getElementById("message").innerHTML=message;
    		}
      		
          }
          
          function getAll(){
        	  xmlhttp=new XMLHttpRequest();
        	  
        	  xmlhttp.onload=displayAll;
        	  
        	  xmlhttp.open("getall","categoryapi/getAll");
        	  
        	  xmlhttp.send();

        	  }
          
          function displayAll(){
        	  
        	  
        	  var allJsonString=xmlhttp.responseText;
        	  
        	  var p1=document.getElementById("p1");
        	  
        	  p1.innerHTML=allJsonString;
          }
          
          
          
          
</script>

</head>


<body>



<span id="message">Enter The Values And Click On The Buttons</span>

<form name="categoryform">

<input name="cid" placeholder="Enter Cid"><br><br>
<input name="name" placeholder="Enter Category"><br><br>

<input type="button" value =post onclick="sendData(this)">
<input type="button" value =get onclick="getData(this)">
<input type="button" value =put onclick="sendData(this)">
<input type="button" value =delete onclick="getData(this)">
<input type="button" value=getall onclick="getAll()"><br><br>



</form>

<p id="p1">All Data</p> 

</body>

</html>