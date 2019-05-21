function relocate() {
	var mydiv = document.getElementById("myDiv");
	var height = Math.abs(document.body.clientHeight + document.body.scrollTop
			- 40);
	
	//window.status = document.body.clientHeight + " " + document.body.scrollTop;
	mydiv.style.top = height;
	document.body.scrollTop>0?mydiv.style.display="":mydiv.style.display="none";
}
window.onscroll = relocate;
window.onresize = relocate;