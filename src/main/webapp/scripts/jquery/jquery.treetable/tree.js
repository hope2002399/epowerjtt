

// 树形表格
if ($.fn.treetable) {
	// 获取首行ID
	var id = $('#treeTable tbody tr:first').data('ttId');	
	$('#treeTable').treetable({
		expandable : true
	}).treetable('expandAll', true);
	$("span.indenter").bind('click',function(){
		var table = $('#treeTable tbody');
		$('tr:visible:odd', table).css({
			background:'#ffffff'
		}).attr({"bg":'#ffffff'});
		$('tr:visible:even', table).css({
			background: '#dfe4e8'
		}).attr({"bg":'red'});
	});
	
	$('#treeTable tbody td:first-child').css({
		'text-align': 'left'
	});
	
}	


$(function(){
	
//	$('select.chosen').chosen(); 
	var table = $('#treeTable tbody');
	$('tr:visible:odd', table).css({
		background:'#ffffff'
	}).attr({"bg":'#ffffff'});
	$('tr:visible:even', table).css({
		background: '#dfe4e8'
	}).attr({"bg":'#dfe4e8'});
	$('tr', table).hover(function(){
		$(this).css({
			background:'#fdecae'
		});
	},function(){
		if($(this).attr("bg")=="#ffffff"){
			$(this).css({
				background:'#ffffff'
			});
		}
		else{
			$(this).css({
				background:'#dfe4e8'
			});
		}
	});
	
	
});

