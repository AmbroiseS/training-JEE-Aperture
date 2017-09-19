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
		
		var k=10;
		
		//fill table	
		for (var i=0; i!=array.length; i++){
			
			 trHTML += '<tr><td>' + array[i].name + '</td><td>' + array[i].email + '</td>+<td>' + array[i].promotion + '</td>';
			    trHTML += '<td ' + 'class=\"text-right\">';
			    trHTML += '<a href=\"/CodeReviewMeeting/modify_member?idUser='+array[i].id+"\"";
				trHTML += ' class=\"btn btn-sm btn-warning fa fa-pencil\"> Modifier</a>';
				trHTML += '<a> </a>';
				trHTML += '<a class=\"btn btn-sm btn-danger fa fa-trash\" data-toggle=\"confirmation\"';
				trHTML += ' href=\"/CodeReviewMeeting/delete_member?idMember='+array[i].id+"\"";
				trHTML += '> Supprimer</a></td></tr>';
				
				if (i/k===1) {
					trPagin="<li><a href=\"#\">1</a></li>";
					
					$('#pagination').append(trPagin);
					
					
				}
			
		}
		/*array.forEach( function(s) { 
		    trHTML += '<tr><td>' + s.name + '</td><td>' + s.email + '</td>+<td>' + s.promotion + '</td>';
		    trHTML += '<td ' + 'class=\"text-right\">';
		    trHTML += '<a href=\"/CodeReviewMeeting/modify_member?idUser='+s.id+"\"";
			trHTML += ' class=\"btn btn-sm btn-warning fa fa-pencil\"> Modifier</a>';
			trHTML += '<a> </a>';
			trHTML += '<a class=\"btn btn-sm btn-danger fa fa-trash\" data-toggle=\"confirmation\"';
			trHTML += ' href=\"/CodeReviewMeeting/delete_member?idMember='+s.id+"\"";
			trHTML += '> Supprimer</a></td></tr>';	} );*/

		$('#memberstable').append(trHTML);
//		
//		<li><a href="#">1</a></li>
//		<li><a href="#">2</a></li>
//		<li><a href="#">3</a></li>
	}
	else{
	
		$('#validationMessage').text("Utilisateur absent");
		//empty table
		$("#memberstable tr>td").remove();
		
	}
}


