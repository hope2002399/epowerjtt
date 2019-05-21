// status	0:正常 1:新增文件夹
var FILE_OPTION = {
	public_url: '${pageContext.request.contextPath}/app/publicinfo!dirPublicFolder.do',	
	personal_url: '${pageContext.request.contextPath}/app/publicinfo!dirPersonalFolder.do',
	view_url: '${pageContext.request.contextPath}/app/publicinfo!view.do',
	add_url: '${pageContext.request.contextPath}/app/publicinfo!addFolder.do',
	download_url: '${pageContext.request.contextPath}/app/publicinfo!download.do',
	download_file_url: '${pageContext.request.contextPath}/app/fileinfo!downloadfile.do',
	delete_url:'${pageContext.request.contextPath}/app/publicinfo!delete.do',
	rename_url:'${pageContext.request.contextPath}/app/publicinfo!rename.do',
	copy_url:'${pageContext.request.contextPath}/app/publicinfo!copy.do',
	move_url:'${pageContext.request.contextPath}/app/publicinfo!move.do',
	upload_url:'${pageContext.request.contextPath}/app/publicinfo!upload.do',
	status:0,
	AUTH_VIEW:0,
	AUTH_ADD:1,
	AUTH_MODIFY:2,
	TYPE_PUBLIC_CUSTOM:0,
	TYPE_PUBLIC_DEFAULT:1,
	select_folder:{}
};

var FILE_TYPES = {
		'bmp':'img',
		'gif':'img',
		'jpeg':'img',
		'jpg':'img',
		'png':'img',
		'vsd':'visio',
		'pdf':'pdf',
		'doc':'word',
		'docx':'word',
		'xls':'excel',
		'xlsx':'excel',
		'txt':'txt',
		'wav':'music',
		'mp3':'music',
		'mov':'movie',
		'rm':'movie',
		'rmvb':'movie',
		'avi':'movie',
		'mkv':'movie',
		'ppt':'ppt',
		'pptx':'ppt',
		'app':'apple',
		'exe':'exe',
		'zip':'zip',
		'rar':'zip',
		'7z':'zip',
		'apk':'apk'
};

var CAN_VIEW = {
		'img':1,'pdf':1,'word':1,'txt':1,'ppt':1,'excel':1
};

var FILES = [];
var FOLDERS = [];
var SELECTED_FILES = [];
var popMenuHandle;


// 加载公共文件夹
function dirPublicFolder(toPath) {
	var path = toPath || FILE_OPTION.infocode;
	
	if (path) {
		$.getJSON(FILE_OPTION.public_url, {path:path}, dirPublicFolderCallback);
	}
	else {
		$.getJSON(FILE_OPTION.public_url, dirPublicFolderCallback);
	}
}

function getFileType(file) {
	if (!file) return "";
	
	// 文件夹
	if (file.isfolder=='1') return "folder";
	if (FILE_TYPES[file.fileextension.toLowerCase()]) return FILE_TYPES[file.fileextension.toLowerCase()];
	return "";
}

function getFileURL(file) {
	// 文件夹
	if (file.isfolder=='1') {
		return FILE_OPTION.public_url+'?path='+file.infocode;
	}
	else if (CAN_VIEW[getFileType(file)]) {
		return FILE_OPTION.view_url+'?infocode='+file.infocode+'&type='+getFileType(file);
	}
	// 查看文件
	else {
		return 'javascript:;';
	}
}

function getLinkType(file) {
	// 文件夹
	if (file.isfolder=='1') {
		return 'dir';
	}
	else if (CAN_VIEW[getFileType(file)]) {
		return 'view';
	}
	// 查看文件
	else {
		return 'none';
	}
}

function getFileSize(file) {
	// 文件夹
	if (file.isfolder=='1') {
		return '-';
	}
	// 查看文件
	else {
		return (parseFloat(file.filesize) / (1024*1024)).toFixed(2) + ' MB';
	}
}

function getFullFilename(file) {
	return file.fileextension ? file.filename+'.'+file.fileextension : file.filename;
}

function getFileUploadtime(file) {
	return file.uploadtime.replaceAll('T', ' ');
}

function addFileSingle(file) {
	
	var html = Centit.frag["PUBLIC_FILE_LINE"]
	
	.replaceAll('{infocode}', file.infocode)
	// 替换类型
	.replaceAll('{type}', getFileType(file))
	.replaceAll('{fullFilename}', getFullFilename(file))
	// 替换文件名
	.replaceAll('{filename}', file.filename)
	// 替换类型
	.replaceAll('{atype}', getLinkType(file))
	// 替换URL
	.replaceAll('{url}', getFileURL(file))
	// 替换文件大小
	.replaceAll('{size}', getFileSize(file))
	// 替换上传者
	.replaceAll('{ownercode}', file.uploader)
	// 替换上传时间
	.replaceAll('{uploadtime}', getFileUploadtime(file));
	
	var line = FILES[0] || FOLDERS[0];
	var fileLine;
	
	if (line) {
		line.before(html);
		fileLine = line.closest('div.public-window').find('div[_data_infocode='+file.infocode+']');
	}
	else {
		var container = $('div.public-window');
		fileLine = $(html).appendTo(container).addClass('last');
	}
	
	saveData(fileLine, file);
	
	if (file.isfolder=='1') {
		FOLDERS.push(fileLine);
	}
	else {
		FILES.push(fileLine);
	}
	
}

function addFile(container, file, last) {
	var html = Centit.frag["PUBLIC_FILE_LINE"]
	
	.replaceAll('{infocode}', file.infocode)
	// 替换类型
	.replaceAll('{type}', getFileType(file))
	.replaceAll('{fullFilename}', getFullFilename(file))
	// 替换文件名
	.replaceAll('{filename}', file.filename)
	// 替换类型
	.replaceAll('{atype}', getLinkType(file))
	// 替换URL
	.replaceAll('{url}', getFileURL(file))
	// 替换文件大小
	.replaceAll('{size}', getFileSize(file))
	// 替换上传者
	.replaceAll('{ownercode}', file.uploader)
	// 替换上传时间
	.replaceAll('{uploadtime}', getFileUploadtime(file));
	
	var line = $(html).appendTo(container);
	
	if (last) {
		line.addClass('last');
	}
	
	if (file.isfolder=='1') {
		FOLDERS.push(line);
	}
	else {
		FILES.push(line);
	}
	
	saveData(line, file);
}

function saveData(line, file) {
	line.data('authority', file.authority)
		.data('dounloadcount', file.downloadcount)
		.data('filedescription', file.filedescription)
		.data('fileextension', file.fileextension)
		.data('filename', file.filename)
		.data('filesize', file.filesize)
		.data('infocode', file.infocode)
		.data('isfolder', file.isfolder)
		.data('modifytime', file.modifytime)
		.data('ownercode', file.ownercode)
		.data('uploader', file.uploader)
		.data('readcount', file.readcount)
		.data('status', file.status)
		.data('type', file.foldertype)
		.data('unitcode', file.unitcode)
		.data('uploadtime', file.uploadtime);
		
}

// 创建路径
function createPath(data) {
	$('.line.path span.ready').show();
	$('.line.path span.refresh').hide();
	
	var line = $('.file-container .line.path');
	var unitroot = data.unitroot;
	var parentcode = data.parentcode;
	var infocode = data.infocode;
	
	// 返回上一级
	if (parentcode && parentcode != '0') {
		$('a.uplevel', line).attr('href', FILE_OPTION.public_url+'?path='+parentcode).show();
	}
	else {
		$('a.uplevel', line).hide();
	}
	
	// 部门主页
	if (infocode == unitroot) {
		$('a.home', line).hide();
	}
	else {
		$('a.home', line).attr('href', FILE_OPTION.public_url+'?path='+unitroot).show();
	}
	
	// 路径
	$('div.ed', line).html('');
	
	if (data.path) {
		var path = data.path;
		var length = data.path.length;
		
		for (var i=0; i<length; i++) {
			if (i == length - 1) {
				$('div.ed', line).append('&nbsp;&nbsp;<a class="patha text">'+ path[i].FILENAME +'</a>&nbsp;&nbsp;');
			}
			else {
				$('div.ed', line).append('&nbsp;&nbsp;<a class="patha" type="dir" href="' + FILE_OPTION.public_url+'?path='+path[i].INFOCODE+'">'+ path[i].FILENAME +'</a>&nbsp;&nbsp;&gt;');
			}
		}
	}
	
	// 加载总数
	$('i', line).html(data.files.length);
	
}

function dirPublicFolderCallback(data){
	
	if (!data || '0' != data.result) {
		Centit.msgError(data.description);
		return false;
	};
	
	FILE_OPTION.username = data.username;
	FILE_OPTION.usercode = data.usercode;
	FILE_OPTION.userunit = data.userunit;
	FILE_OPTION.fileunit = data.fileunit;
	FILE_OPTION.infocode = data.infocode;
	FILE_OPTION.authority = data.authority;
	
	createPath(data);
	
	var files = data.files;
	var container = $('.public-window');
	
	// 清空
	var count = 0;
	FOLDERS = [];
	FILES = [];
	SELECTED_FILES = [];
	
	$('.public-window .line').remove();
	
	for (var i=0; i<files.length; i++) {
		
		if (i != files.length-1) {
			addFile(container, files[i], false);
		}
		else {
			addFile(container, files[i], true);
		}
		
	}
	
	selectHead();
}

/**
 * 打开新建文件夹
 */
function toAddFolder() {
	if (!authorityAdd()) {
		Centit.msgError('没有权限在非本机构创建文件夹、上传文件。');
		
		return false;
	}
	
	var html = Centit.frag["PUBLIC_NEW_FOLDER"]
	// 替换上传者
	.replaceAll('{username}', FILE_OPTION.username);
	
	var container = $('.public-window');
	var firstChild = container.find('div.line:first');
	
	// 插入
	if (firstChild[0]) {
		firstChild.before(html);
	}else {
		container.append(html);
	}
	
	var div = $('.line.new', container);
	var input = $('input', div).select();
	
	FILE_OPTION.status = 1;
}

/**
 * 关闭新建文件夹
 */
function toCancelAddFolder() {
	var container = $('.public-window');
	var div = $('.line.new', container).remove();
	FILE_OPTION.status = 0;
}

function addFolder() {
	var container = $('.public-window');
	var div = $('.line.new', container);
	var input = $('input', div).select();
	
	if (!input.val()) {
 		Centit.msgConfirm('请填写文件名。', {retryAction:function() {
			input.focus();
		}}); 
		

		return false;
	}
	
	$.post(FILE_OPTION.add_url, {filename:input.val(), root:FILE_OPTION.infocode}, addFolderCallback, 'json');
}

function addFolderCallback(data) {
	if (!data || '0' != data.result) {
		Centit.msgError(data.description);
		return false;
	};
	
	toCancelAddFolder();
	Centit.msgAlert('新建文件夹成功。');
	
	dirPublicFolder();
}

function selectFile(e, line) {
	// 新建文件夹中不可选择文件
	if (FILE_OPTION.status == 1) {
		return false;
	}
	
	$(line).toggleClass('selected');
	var container = $('.public-window');
	
	SELECTED_FILES.length = 0;
	$('div.line.selected', container).each(function(i, line) {
		SELECTED_FILES.push($(line));
	});
	
	selectHead();
}

function selectAllFile(e, button) {
	// 新建文件夹中不可选择文件
	if (FILE_OPTION.status == 1) {
		return false;
	}
	
	var $this = $(button).closest('.line');
	$this.toggleClass('selected');
	
	var container = $('.public-window');
	if ($this.hasClass('selected')) {
		
		$('div.line', container).addClass('selected');
		$('.line.operation').addClass('selected');
		$('.header').addClass('selected');
		
		SELECTED_FILES.length = 0;
		$('div.line.selected', container).each(function(i, line) {
			SELECTED_FILES.push($(line));
		});
		
	}else {
		
		$('div.line', container).removeClass('selected');
		$('.line.operation').removeClass('selected');
		$('.header').removeClass('selected');
		SELECTED_FILES.length = 0;
	}
	
	selectHead();
}

function selectHead() {
	var container = $('.file-container');
	
	if (SELECTED_FILES.length == 0) {
		$('.line.operation', container).hide();
		$('.header', container).show().removeClass('selected');
	}
	else {
		$('.line.operation', container).show().find('i').html(SELECTED_FILES.length);
		$('.header', container).hide();
	}
}

function downloadFile() {
	var files = [];
	
	for (var i=0; i<SELECTED_FILES.length; i++) {
		var line = SELECTED_FILES[i];
		files.push(line.data('infocode'));
	}
	
	$.post(FILE_OPTION.download_url, {infocode: files.join(',')}, downloadFilesCallback, 'json');
}

function downloadFilesCallback(data) {
	if (!data || '0' != data.result) {
		Centit.msgError(data.description);
		return false;
	};
	
	// 下载文件
	var downloadForm = $('#downloadForm');
	
	if (!downloadForm[0]) {
		var form = $("<form>");   //定义一个form表单
		form.attr('id', 'downloadForm');
		form.attr('style','display:none');   //在form表单中添加查询参数
		form.attr('target','');
		form.attr('method','post');
		form.attr('action',FILE_OPTION.download_file_url);
		
		var input = $('<input>'); 
		input.attr('type','hidden'); 
		input.attr('name','filecode'); 
		
		$('body').append(form);  //将表单放置在web中
		form.append(input);   //将查询参数控件提交到表单上
		downloadForm = form;
	}
	
	downloadForm.find('input[name=filecode]').val(data.filecode);
	downloadForm.submit(); 
}

function deleteFiles() {
	var files = [];
	
	for (var i=0; i<SELECTED_FILES.length; i++) {
		var line = SELECTED_FILES[i];
		var cancelFlag = false;
		var notMyFile = false;
		
		if (line.data('status') == '1' || line.data('type') == FILE_OPTION.TYPE_PUBLIC_DEFAULT) {
			cancelFlag = true;
		}
		else if (line.data('ownercode') != FILE_OPTION.usercode) {
			notMyFile = true;
		}
		else {
			files.push(line.data('infocode'));
		}
		
	}
	
	if (cancelFlag && files.length == 0) {
		Centit.msgError('所选文件为系统默认或状态为锁定，无法删除。');
		return false;
	}
	else if (cancelFlag && files.length != 0) {
		Centit.msgConfirm('所选文件有部分为系统默认或状态为锁定，这些文件将不会被删除。剩下的文件将被删除不可恢复，是否继续？', {
			retryAction: function() {
				$.post(FILE_OPTION.delete_url, {infocode: files.join(',')}, deleteFilesCallback, 'json');
			}
		});
	}
	else if (notMyFile && files.length == 0) {
		Centit.msgError('所选文件不是本人上传，无法删除。');
		return false;
	}
	else if (notMyFile && files.length != 0) {
		Centit.msgConfirm('所选文件有部分不是本人上传，这些文件将不会被删除。剩下的文件将被删除不可恢复，是否继续？', {
			retryAction: function() {
				$.post(FILE_OPTION.delete_url, {infocode: files.join(',')}, deleteFilesCallback, 'json');
			}
		});
	}
	else {
		Centit.msgConfirm('文件将被删除不可恢复，是否继续？', {
			retryAction: function() {
				$.post(FILE_OPTION.delete_url, {infocode: files.join(',')}, deleteFilesCallback, 'json');
			}
		});
	}
	
}

function deleteFilesCallback(data) {
	if (!data || '0' != data.result) {
		Centit.msgError(data.description);
		return false;
	};
	
	Centit.msgAlert('删除文件成功。');
	
	dirPublicFolder();
}

function getSort(info) {
	var btn = info.find('span.sort');
	
	// 正序
	var sort = 1;
	
	// 倒序
	if (btn.hasClass('asc')) {
		sort = 0;
	}
	
	return sort;
}

function sortFileIcon(info, sort) {
	var container = $('.public-window');
	
	// 去除原来的排序图标
	info.closest('div.line').find('span.sort').removeClass('asc').removeClass('desc');
	
	if (sort) {
		$('span.sort', info).addClass('asc');
	}
	else {
		$('span.sort', info).addClass('desc');
	}
	
	// 去除原来最后.last样式
	$('div.last.line', container).removeClass('last');
	
	if (FILES.length != 0) {
		FILES[FILES.length -1].addClass('last');
	}
	else if (FOLDERS.length != 0) {
		FOLDERS[FOLDERS.length -1].addClass('last');
	}
	
	container.hide();
	container.detach('.line');
	
	for (var i=0; i<FOLDERS.length; i++) {
		container.append(FOLDERS[i]);
	}	
	for (var i=0; i<FILES.length; i++) {
		container.append(FILES[i]);
	}	
	
	container.show();
}

/**
 * 按名称排序
 */
function sortByName(info) {
	info = $(info);
	var sort = getSort(info);
	
	if (sort) {
		FOLDERS.sort(ArraysSortByNameAsc);
		FILES.sort(ArraysSortByNameAsc);
	}
	else {
		FOLDERS.sort(ArraysSortByNameDesc);
		FILES.sort(ArraysSortByNameDesc);
	}
	
	sortFileIcon(info, sort);
}

/**
 * 按大小排序
 */
function sortBySize(info) {
	info = $(info);
	var sort = getSort(info);
	
	if (sort) {
		FOLDERS.sort(ArraysSortBySizeAsc);
		FILES.sort(ArraysSortBySizeAsc);
	}
	else {
		FOLDERS.sort(ArraysSortBySizeDesc);
		FILES.sort(ArraysSortBySizeDesc);
	}
	
	sortFileIcon(info, sort);
}

/**
 * 按上传者排序
 */
function sortByUploader(info) {
	info = $(info);
	var sort = getSort(info);
	
	if (sort) {
		FOLDERS.sort(ArraysSortByUploaderAsc);
		FILES.sort(ArraysSortByUploaderAsc);
	}
	else {
		FOLDERS.sort(ArraysSortByUploaderDesc);
		FILES.sort(ArraysSortByUploaderDesc);
	}
	
	sortFileIcon(info, sort);
}

/**
 * 按上传时间排序
 */
function sortByUploadTime(info) {
	info = $(info);
	var sort = getSort(info);
	
	if (sort) {
		FOLDERS.sort(ArraysSortByUploadTimeAsc);
		FILES.sort(ArraysSortByUploadTimeAsc);
	}
	else {
		FOLDERS.sort(ArraysSortByUploadTimeDesc);
		FILES.sort(ArraysSortByUploadTimeDesc);
	}
	
	sortFileIcon(info, sort);
}

function ArraysSortByNameAsc(file1, file2) {
	var name1 = file1.data('filename');
	var name2 = file2.data('filename');
	
	if (name1 > name2) return 1;
	if (name2 > name1) return -1;
	
	return 0;
}

function ArraysSortByNameDesc(file1, file2) {
	var name1 = file1.data('filename');
	var name2 = file2.data('filename');
	
	if (name1 > name2) return -1;
	if (name2 > name1) return 1;
	
	return 0;
}

function ArraysSortBySizeAsc(file1, file2) {
	var size1 = file1.data('filesize');
	var size2 = file2.data('filesize');
	
	if (size1 > size2) return 1;
	if (size2 > size1) return -1;
	
	return 0;
}

function ArraysSortBySizeDesc(file1, file2) {
	var size1 = file1.data('filesize');
	var size2 = file2.data('filesize');
	
	if (size1 > size2) return -1;
	if (size2 > size1) return 1;
	
	return 0;
}

function ArraysSortByUploaderAsc(file1, file2) {
	var uploader1 = file1.data('uploader');
	var uploader2 = file2.data('uploader');
	
	if (uploader1 > uploader2) return 1;
	if (uploader2 > uploader1) return -1;
	
	return 0;
}

function ArraysSortByUploaderDesc(file1, file2) {
	var uploader1 = file1.data('uploader');
	var uploader2 = file2.data('uploader');
	
	if (uploader1 > uploader2) return -1;
	if (uploader2 > uploader1) return 1;
	
	return 0;
}

function ArraysSortByUploadTimeAsc(file1, file2) {
	var uploadtime1 = file1.data('uploadtime');
	var uploadtime2 = file2.data('uploadtime');
	
	if (uploadtime1 > uploadtime2) return 1;
	if (uploadtime2 > uploadtime1) return -1;
	
	return 0;
}

function ArraysSortByUploadTimeDesc(file1, file2) {
	var uploadtime1 = file1.data('uploadtime');
	var uploadtime2 = file2.data('uploadtime');
	
	if (uploadtime1 > uploadtime2) return -1;
	if (uploadtime2 > uploadtime1) return 1;
	
	return 0;
}

function openPopMenu(btn) {
	var container = $('.file-container');
	var menu = $('.pull-down-menu.header-menu', container);
	clearTimeout(popMenuHandle);
	
	btn = $(btn);
	if (btn.hasClass('pull-down-menu')) return;
	
	var left = btn.position().left+10;
	var top = btn.position().top + btn.height();
	
	if (SELECTED_FILES.length != 1) {
		$('a.rename', menu).addClass('disable');
	}
	else {
		$('a.rename', menu).removeClass('disable');
	}
	
	menu.css({
		left:left,
		top:top
	}).show();
}

function closePopMenu() {
	var container = $('.file-container');
	var menu = $('.pull-down-menu.header-menu', container);
	
	menu.hide();
}

function toRename() {
	FILE_OPTION.status = 1;
	
	$('.pull-down-menu.header-menu').hide();
	
	if (SELECTED_FILES.length != 1) {
		FILE_OPTION.status = 0;
		return false;
	}
	
	var line = SELECTED_FILES[0];
	
	if (FILE_OPTION.TYPE_PUBLIC_DEFAULT == line.data('type')) {
		Centit.msgError('不能重命名机构默认文件夹。');
		
		cancelRename();
		return false;
	}
	
	if (!authroityRename()) {
		Centit.msgError('不能重命名非本人上传文件。');
		
		cancelRename();
		return false;
	}
	
	var info = line.find('div.info.name');
	info.find('a').hide();
	
	var rename = FILE_OPTION.RENAME_CONTAINER.show();
	rename.find('input').val(line.data('filename')).select();
	
	info.append(rename);
}

function cancelRename() {
	var line = SELECTED_FILES[0];
	var info = line.find('div.info.name');
	info.find('a').show();
	FILE_OPTION.status = 0;
	
	FILE_OPTION.RENAME_CONTAINER.detach();
}

function rename() {
	if (SELECTED_FILES.length != 1) return false;
	
	var file = SELECTED_FILES[0];
	var rename = $('#rename-container');
	var info = file.find('div.info.name');
	
	var newName = rename.find('input').val();

	if (/\.|\*|\?|\%|\_/.test(newName)) {
		Centit.msgError('文件名不能包含.*?%_等特殊字符，请重新输入。');
		
		rename.find('input').select();
		return false;
	}
	
	$.post(FILE_OPTION.rename_url, {name:newName, infocode:file.data('infocode'), root:FILE_OPTION.infocode}, renameCallback, 'json');
}

function renameCallback(data) {
	// 权限错误没有必要再修改了
	if (data.result == '1' || data.result == '2') {
		Centit.msgError(data.description);
		cancelRename();
		return false;
	};
	
	if (data.result != '0') {
		Centit.msgError(data.description);
		return false;
	};
	
	cancelRename();
	
	var file = data.file;
	var infocode = file.infocode;
	var filename = file.filename;
	
	var line = $('div.line[_data_infocode='+infocode+']');
	line.data('filename', filename);
	line.find('div.info.name').find('a').first().html(filename);
	
	Centit.msgAlert('重命名文件成功。');
}

function toUploadFile() {
	
	if (!authorityAdd()) {
		Centit.msgError('非本机构文件夹不能上传文件。');
		return false;
	}
	
	$('#publicinfo-upload').click();
}

function uploadFile(btn) {
	btn = $(btn);
	
	if (!btn.val()) {
		return;
	}
	
	//$('#uploadForm').submit();
	
 	$.ajaxFileUpload({
		url:FILE_OPTION.upload_url,
		secureuri:false,
		fileElementId:'publicinfo-upload',
		data:{path:FILE_OPTION.infocode},
		dataType:'json',
		success: uploadCallback,
		error:uploadError
	}); 
}

function uploadCallback(data) {
	if (data.result != '0') {
		Centit.msgError(data.description);
		return false;
	};
	
	addFileSingle(data.file);
}

function uploadFormData() {
	return {
		path:FILE_OPTION.infocode
	};
}

function uploadError(data, status, e) {
	Centit.msgError('文件上传失败。');
	dirPublicFolder();
}

function copyFilesCallback(data) {
	if (data.result != '0') {
		Centit.msgError(data.description);
		return false;
	};
	var file = data.file;
	
	if (file.infocode == FILE_OPTION.infocode) {
		Centit.msgAlert('复制文件成功');
		dirPublicFolder();
		return;
	}
	
	Centit.msgConfirm('复制文件成功，是否跳转到 '+file.filename+' 去查看？', {
		retryAction: function() {
			dirPublicFolder(file.infocode);
		}
	});
	
}

function moveFilesCallback(data) {
	if (data.result != '0') {
		Centit.msgError(data.description);
		return false;
	};
	var file = data.file;
	
	Centit.msgConfirm('移动文件成功，是否跳转到 '+file.filename+' 去查看？', {
		retryAction: function() {
			dirPublicFolder(file.infocode);
		},
		cancelAction: function() {
			dirPublicFolder();
		}
	});
	
}

function openFileSelectDialog(title, type) {
	
	var options = {
		title:title,
		rel:'SELECT_FOLDER_DIALOG',
		width:300,
		height:400,
		
		max:false,
		mask:true,
		maxable:false,
		minable:false,
		fresh:true,
		resizable:false,
		drawable:true,
		close:true,
		
		callback: function() {
			$('#type', $.pdialog.getCurrent()).val(type);
		}
	};
	
	$.pdialog.open("${pageContext.request.contextPath}/page/app/publicinfo/selectFolder.html", "SELECT_FOLDER_DIALOG", title, options);
}

/**
 * 附加事件
 */
function attachEvent4Publicinfo() {
	
	$('a[type=view]').die('click');
	
	// 进入目录
	$('a[type=view]').live('click', function(event) {
		var $this = $(this);
		var title = $this.attr("title") || $this.text();
		var tabid = $this.attr("rel") || "_blank";
		var fresh = eval($this.attr("fresh") || "true");
		var external = eval($this.attr("external") || "false");
		var url = unescape($this.attr("href")).replaceTmById($(event.target).parents(".unitBox:first"));
		if (!url.isFinishedTm()) {
			Centit.msgError($this.attr("warn") || Centit.msg("alertSelectMsg"));
			return false;
		}
		navTab.openTab(tabid, url,{title:title, fresh:fresh, external:external});

		event.preventDefault();
	} );
	
	$('a[type=dir]').die('click');
	// 进入目录
	$('a[type=dir]').live('click', function(event) {
		$('.line.path span.ready').hide();
		$('.line.path span.refresh').show();
		
		$.getJSON(this.href, dirPublicFolderCallback);
		event.preventDefault();
	} );
	
	$('a[type=none]').die('click');
	// 进入目录
	$('a[type=none]').live('click', function(event) {
		event.preventDefault();
		return false;
	} );
	
	// 新建文件夹
	$('.line.navigation a.add').click(function(event) {
		if (FILE_OPTION.status == 1) {
			return;	
		}
		
		toAddFolder();
		event.preventDefault();
	});
	
	var container = $('.public-window');
	$('.line.new a.sure', container).die('click');
	$('.line.new a.sure', container).live('click', function(event) {
		addFolder();
		event.preventDefault();
	});
	$('.line.new a.cancel', container).die('click');
	$('.line.new a.cancel', container).live('click', function(event) {
		toCancelAddFolder();
		event.preventDefault();
	});
	
	// 选择文件
	$('.line', container).die('click');
	$('.line', container).live('click', function(event){
		selectFile(event, this);
	});
	
	// 全选
	$('.line.operation span.check').add('.header span.check').click(function(event) {
		selectAllFile(event, this);
	});
	
	// 下载
	$('.line.operation a.download').click(function(event) {
		downloadFile();
	});
	// 删除
	$('.line.operation a.delete').click(function(event) {
		deleteFiles();
	});
	
	// 排序
	$('.line.header div.name').click(function (event) {
		sortByName(this);
	});
	
	$('.line.header div.size').click(function (event) {
		sortBySize(this);
	});
	
	$('.line.header div.owner').click(function (event) {
		sortByUploader(this);
	});
	
	$('.line.header div.time').click(function (event) {
		sortByUploadTime(this);
	});
	
	// 更多按钮
	$('.line.operation a.more').add('.pull-down-menu.header-menu').hover(function(event) {
		openPopMenu(this);
	}, function(event) {
		popMenuHandle = setTimeout("closePopMenu()", 50);
	});
	
	// 重命名
	$('.pull-down-menu.header-menu a.rename').click(function(event) {
		toRename();
	});
	
	$('#rename-container a.sure').click(function (event) {
		rename();
	});
	
	$('#rename-container a.cancel').click(function (event) {
		cancelRename();
	});
	
	// 复制
	$('.pull-down-menu.header-menu a.copyto').click(function(event) {
		openFileSelectDialog('复制项目到', 'copy');
	});
	
	// 移动
 	$('.pull-down-menu.header-menu a.moveto').click(function(event) {
 		openFileSelectDialog('移动项目到', 'move');
	}); 
}

function authority(auth, pos) {
	return ((auth >> pos) % 2) == 1;
}

/**
 * 鉴权新增文件夹、上传文件
 */
function authorityAdd() {
	if (FILE_OPTION.userunit != FILE_OPTION.fileunit) {
		return false;
	}
	
	return authority(FILE_OPTION.authority, FILE_OPTION.AUTH_ADD);
}

function authroityDelete() {
	
}

/**
 * 鉴权重命名
 */
function authroityRename() {
	var file = SELECTED_FILES[0];
	
	if (FILE_OPTION.usercode != file.data('ownercode')) {
		return false;
	}
	
	return authority(file.data('authority'), FILE_OPTION.AUTH_MODIFY);
}

$(function () {
	FILE_OPTION.RENAME_CONTAINER = $('#rename-container');
	
	dirPublicFolder();
	attachEvent4Publicinfo();
});