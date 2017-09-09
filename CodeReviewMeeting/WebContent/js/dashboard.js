$(document).ready(function() {
	$('[data-toggle="confirmation"]').confirmation({
	    href: function(elem){
	        return $(elem).attr('href');
	    }
	});

	//  document.location.href="/CodeReviewMeeting/delete_member?idMember="+member;
});
