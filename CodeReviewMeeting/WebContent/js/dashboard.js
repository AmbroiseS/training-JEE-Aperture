$(document).ready(function() {
	$('[data-toggle="confirmation"]').confirmation({
	    href: function(elem){
	        return $(elem).attr('href');
	    }
	});

	//  document.location.href="/CodeReviewMeeting/delete_member?idMember="+member;
});
var requete;
//TODO 
function valider() {
   var donnees = document.getElementById("donnees");
   var url = "dashboard?valeur=" + escape(donnees.value);
   if (window.XMLHttpRequest) {
       requete = new XMLHttpRequest();
   } else if (window.ActiveXObject) {
       requete = new ActiveXObject("Microsoft.XMLHTTP");
   }
   requete.open("GET", url, true);
   requete.onreadystatechange = majIHM;
   requete.send(null);
}
//TODO 
function majIHM() {
  var message = "";

  if (requete.readyState == 4) {
    if (requete.status == 200) {
      // exploitation des données de la réponse

      var messageTag = requete.responseXML.getElementsByTagName("message")[0];
      message = messageTag.childNodes[0].nodeValue;
      mdiv = document.getElementById("validationMessage");
      if (message == "invalide") {
          mdiv.innerHTML = "<img src='ima/inv.png'>";
       } else {
          mdiv.innerHTML = "<img src='ima/val.png'>";
       }
    }
  }
}
function displayMembers(data){
	var trHTML = '';
	
	for(i in data){
		console.log(data[i].name);
	    trHTML += '<tr><td>' + data[i].name + '</td><td>' + data[i].email + '</td>+<td>' + data[i].promotion + '</td>';
	    trHTML += '<td ' + 'class=\"text-right\">'+'<a href=\"/CodeReviewMeeting/modify_member?idUser='+data[i].id+"\"";
		trHTML += ' class=\"btn btn-warning fa fa-pencil\"> Modifier</a>'
		trHTML += '<a class=\"btn btn-sm btn-danger\" data-toggle=\"confirmation\"';
		trHTML += ' href=\"/CodeReviewMeeting/delete_member?idMember='+data[i].id+"\"";
		trHTML += '><i class=\"fa fa-trash\"></i> Supprimer</a></td></tr>';
	}

	$('#memberstable').append(trHTML);
	
}


