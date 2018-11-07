/**
 * 
 */

function validateForm() {
	var resource = {}

	if (document.forms["form1"]["mid"].value != '') {

		resource["id"] = document.forms["form1"]["mid"].value
		resource["firstName"] = document.forms["form1"]["firstName"].value
		resource["middleName"] = document.forms["form1"]["middleName"].value
		resource["lastName"] = document.forms["form1"]["lastName"].value

		resource["listOfTechWorkedOn"] = document.forms["form1"]["tech1"].value 
				+ ":" + document.forms["form1"]["tech2"].value + ":"
				+ document.forms["form1"]["tech3"].value + ":"
				+ document.forms["form1"]["tech4"].value
		resource["certification"] = document.forms["form1"]["certi1"].value
				+ ":" + document.forms["form1"]["certi2"].value + ":"
				+ document.forms["form1"]["certi3"].value + ":"
				+ document.forms["form1"]["certi4"].value
		resource["projects"] = document.forms["form1"]["proj1"].value + ":"
				+ document.forms["form1"]["proj2"].value + ":"
				+ document.forms["form1"]["proj3"].value + ":"
				+ document.forms["form1"]["proj4"].value
		resource["applicationWorkLoadType"] = document.forms["form1"]["appType1"].value
				+ ":"
				+ document.forms["form1"]["appType2"].value
				+ ":"
				+ document.forms["form1"]["appType3"].value
				+ ":"
				+ document.forms["form1"]["appType4"].value
		$.ajax({
			type : "POST",
			contentType : 'application/json; charset=utf-8',
			url : window.location + "addResource",
			data : JSON.stringify(resource),
			dataType : 'json',
			success : function(result) {
				if (result == "Success") {
					alert('Data Inserted Successfully')
					document.getElementById("form1").reset();
				} else {
					alert('Data already exists')
				}
				console.log(result);
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}

		});
		event.preventDefault();
	} else {
		alert('MID is Mandatory.Please Enter to Proceed')
	}
}



function getDetails(){
	
	var idorName = document.forms["form2"]["midName"].value;
	
	$.ajax({
		type : "GET",
		url : window.location + "getResource/"+idorName,
		 dataType: 'json',
		success : function(result) {
			if(isNullOrEmpty(result)){
				alert(idorName);
				document.getElementById("form3").style.display="";
				parseDetails(result);
				
			}else{
				alert('4');
			}
			console.log(result);
		},
		error : function(e) {
			alert("Error!")
			console.log("ERROR: ", e);
		}
		
	});
	
	
	
	
}


function parseDetails(result){
	alert("form3")
	console.log(result);
	let technologies = result.listOfTechWorkedOn
	var technologiesArray = technologies.split(":")
	var certificateionArray= result.certification.split(":") ;
	var projectsArray= result.projects.split(":");
	var applnWkLoadArray= result.applicationWorkLoadType.split(":");

	document.forms["form3"]["mid"].value = 'M'+result.id
	document.forms["form3"]["firstName"].value = result.firstName
	document.forms["form3"]["middleName"].value = result.middleName
	document.forms["form3"]["lastName"].value = result.lastName
		
		
	document.forms["form3"]["tech1"].value = technologiesArray[0]
	document.forms["form3"]["tech2"].value = technologiesArray[1]
	document.forms["form3"]["tech3"].value = technologiesArray[2]
	document.forms["form3"]["tech4"].value = technologiesArray[3]
	
	document.forms["form3"]["certi1"].value = certificateionArray[0]
	document.forms["form3"]["certi2"].value = certificateionArray[1]
	document.forms["form3"]["certi3"].value = certificateionArray[2]
	document.forms["form3"]["certi4"].value = certificateionArray[3]
	
	document.forms["form3"]["proj1"].value = projectsArray[0]
	document.forms["form3"]["proj2"].value = projectsArray[1]
	document.forms["form3"]["proj3"].value = projectsArray[2]
	document.forms["form3"]["proj4"].value = projectsArray[3]
	
	document.forms["form3"]["appType1"].value = applnWkLoadArray[0]
	document.forms["form3"]["appType2"].value = applnWkLoadArray[1]
	document.forms["form3"]["appType3"].value = applnWkLoadArray[2]
	document.forms["form3"]["appType4"].value = applnWkLoadArray[3]
}

function isNullOrEmpty(data){
	if(data === null || data === 'undefined' || data === ''){
		return false
	}
	return true
}








