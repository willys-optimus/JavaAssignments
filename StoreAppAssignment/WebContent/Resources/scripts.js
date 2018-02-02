 function validateQty() { 
	var txtL =  document.forms.length;
	for (i = 0; i < txtL; i++){
		var x = document.forms[i]["quantity"].value;
			if( x == "") { 
				alert("Please enter a quantity"); 	
				return false;
			}
		}
 } 
