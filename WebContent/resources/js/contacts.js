setTimeout(function(){
	Typed.new('.element .type', {
		strings: ["chown bodyash /world \nWorking^1000.^1000.^1000.^2000\nDONE!"],
	    typeSpeed: 100,
	    callback: function() {
	    	$(".typed-cursor").hide();
	    }
	});
}, 0);

setTimeout(function(){
	$(".element1").css("display", "inherit");
	Typed.new('.element1 .type', {
		strings: ["^3000sudo apt-get install world-controller\n"],
	    typeSpeed: 100,
	    callback: function() {
	    	setTimeout(function(){
	    		$(".typed-cursor").hide();
	    	}, 2000);
	    }
	});
}, 11000);

setTimeout(function(){
	$(".element2").css("display", "inherit");
}, 22000);

