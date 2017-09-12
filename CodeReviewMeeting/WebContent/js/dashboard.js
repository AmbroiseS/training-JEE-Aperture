$(document).ready(function() {
	$('[data-toggle="confirmation"]').confirmation({
	    href: function(elem){
	        return $(elem).attr('href');
	    }
	});

});


var requete;

function valider() {
   var donnees = document.getElementById("donnees");
   var url = "dashboard?valeur=" + escape(donnees.value);
   if (window.XMLHttpRequest) {
       requete = new XMLHttpRequest();
   } else if (window.ActiveXObject) {
       requete = new ActiveXObject("Microsoft.XMLHTTP");
   }
   requete.open("GET", url, true);
   requete.onreadystatechange = getResponseList;
   requete.send();
}

function getResponseList() {
  if (requete.readyState == 4) {
    if (requete.status == 200) {
    	displayMembers(requete.responseText,1);   
    }
  }
}

function displayMembers(data,from){
	
	if(data !== 'undefined' && data !== ''){
		
		$('#validationMessage').text("");

		var array = data;
		var trHTML = '';

	    if(from == 1){
		   array= $.parseJSON(data);
		}
	    
		//empty table
		$("#memberstable tr>td").remove();
		
		//fill table	
		array.forEach( function(s) { 
		    trHTML += '<tr><td>' + s.name + '</td><td>' + s.email + '</td>+<td>' + s.promotion + '</td>';
		    trHTML += '<td ' + 'class=\"text-right\">'+'<a href=\"/CodeReviewMeeting/modify_member?idUser='+s.id+"\"";
			trHTML += ' class=\"btn btn-warning fa fa-pencil\"> Modifier</a>'
			trHTML += '<a class=\"btn btn-sm btn-danger\" data-toggle=\"confirmation\"';
			trHTML += ' href=\"/CodeReviewMeeting/delete_member?idMember='+s.id+"\"";
			trHTML += '><i class=\"fa fa-trash\"></i> Supprimer</a></td></tr>';	} );

		$('#memberstable').append(trHTML);
		
	}
	else{
	
		$('#validationMessage').text("Utilisateur absent");
		//empty table
		$("#memberstable tr>td").remove();
		
	}

	
	
}


