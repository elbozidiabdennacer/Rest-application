function myclick() {
		var pa = document.querySelector('.panier')
		window.setInterval(function() {
			pa.classList.toggle('pa')
		}, 1)
	}


	function myclick2() {
		var pa = window.document.getElementById("panier").style.visibility

		if (pa == "visible") {
			window.document.getElementById("panier").style.visibility = "hidden"
		}

		else {
			window.document.getElementById("panier").style.visibility = "visible"
		}
	}
	

	var imgs=["Image/Slide/livre1.jpg","Image/Slide/livre2.jpg","Image/Slide/livre3.jpg","Image/Slide/livre4.jpg"]
	
	var k=0
	function slides(){
		
		document.getElementById("slide").src=imgs[k];
		k++;
		if (k>3)
			k=0	
	}
	
	setInterval(slides,3000)
