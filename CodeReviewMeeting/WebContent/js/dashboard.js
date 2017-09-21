$(document).ready(function() {
	//activate toggle confirmation
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
		for (var i=0; i!=array.length; i++){
			
			 trHTML += '<tr><td>' + array[i].name + '</td><td>' + array[i].email + '</td>+<td>' + array[i].promotion + '</td>';
			    trHTML += '<td ' + 'class=\"text-right\">';
			    trHTML += '<a href=\"/CodeReviewMeeting/modify_member?idUser='+array[i].id+"\"";
				trHTML += ' class=\"btn btn-sm btn-warning fa fa-pencil\"> Modifier</a>';
				trHTML += '<a> </a>';
				trHTML += '<a class=\"btn btn-sm btn-danger fa fa-trash\" data-toggle=\"confirmation\"';
				trHTML += ' href=\"/CodeReviewMeeting/delete_member?idMember='+array[i].id+"\"";
				trHTML += '> Supprimer</a></td></tr>';
				
			
		}
		$('#memberstable').append(trHTML);
		paginate(Math.ceil(array.length / 10));	
	}
	else{
	
		$('#validationMessage').text("Utilisateur absent");
		//empty table
		$("#memberstable tr>td").remove();
		
	}
}

function paginate(npages){
	    var recordPerPage = 40; 
	    var totalPages = npages; 
	    
		$("#pagination li").remove();

	    for (i = 0; i!=totalPages; i++) {  
	    	$('#pagination').append('<li><a>'+(i+1)+'</a></li>');
	    }   
	 	    
	    $('memberstable').find('#tablebody tr>td').hide(); 
	    var tr = $('#tablebody tr>td'); 
	    for (var i = 0; i != recordPerPage - 1; i++) {   
	        $(tr[i]).show(); 
	    } 
	    $('li').click(function(event) {  
	        $('#memberstable').find('#tablebody tr>td').hide();  
	        var nBegin = ($(this).text() - 1) * recordPerPage;  
	        var nEnd = $(this).text() * recordPerPage; 
	        
	        for (var i = nBegin; i != nEnd; i++)   {   
	            $(tr[i]).show();  
	        } 
	    });
	    $('#memberstable').find('#tablebody tr>td').hide();
	    var nBegin = 0;  
        var nEnd = recordPerPage; 
        for (var i = nBegin; i != nEnd; i++)   {   
            $(tr[i]).show();  
        } 
	
	
}


