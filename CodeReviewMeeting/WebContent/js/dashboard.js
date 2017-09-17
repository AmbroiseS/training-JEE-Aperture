$(document).ready(function() {
	$('[data-toggle="confirmation"]').confirmation({
	    href: function(elem){
	        return $(elem).attr('href');
	    }
	});
	console.log("boom");
	pagination();

});


function pagination(){
	$("#memberstable").DataTable({
		"columnDefs": [ { "targets": [0, 1, 2, 3], // column or columns numbers
			"orderable": false, // set orderable for selected columns 
			}],
		"info":     false,
		"bLengthChange": false,
		"oLanguage": {
	        "sEmptyTable": "Pas de résultat", //when empty
	                    "sSearch": "<span>Rechercher</span> _INPUT_", //search
	                    "sLengthMenu": "<span>Show entries:</span> _MENU_", //label
	                    "oPaginate": { "sFirst": "Fdrst", "sLast": "Last", "sNext": ">", "sPrevious": "<" } //pagination
	            }
	});
   
}

