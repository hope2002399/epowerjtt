<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<!doctype html>
<head>
	<script>
		var result = '${request.result }';
		if (result == 'OK') {
			alert('文件保存成功');
			//window.close();
		}
		else if (result == 'ERROR') {
			alert('文件保存失败');
		}
	</script>
	<title>文件编辑器</title>
	<meta charset="utf-8"/>
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/pintuer/pintuer.css">
	<script src="${pageContext.request.contextPath}/scripts/jquery-1.7.2.min.js" type="text/javascript"></script>
	
	<script src="${pageContext.request.contextPath}/pintuer/pintuer.js"></script>
	<script src="${pageContext.request.contextPath}/scripts/respond.js"></script>
	    
	<link rel="stylesheet" href="${pageContext.request.contextPath}/scripts/codemirror/lib/codemirror.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/scripts/codemirror/theme/eclipse.css">
	<script src="${pageContext.request.contextPath}/scripts/codemirror/lib/codemirror.js"></script>
	<script src="${pageContext.request.contextPath}/scripts/codemirror/mode/xml/xml.js"></script>
	<script src="${pageContext.request.contextPath}/scripts/codemirror/mode/javascript/javascript.js"></script>
	<script src="${pageContext.request.contextPath}/scripts/codemirror/mode/css/css.js"></script>
	<script src="${pageContext.request.contextPath}/scripts/codemirror/mode/clike/clike.js"></script>
	<script src="${pageContext.request.contextPath}/scripts/codemirror/mode/htmlmixed/htmlmixed.js"></script>
	<script src="${pageContext.request.contextPath}/scripts/codemirror/mode/htmlembedded/htmlembedded.js"></script>
	<style type="text/css">.CodeMirror {height: 100%; border-top: 1px solid black; border-bottom: 1px solid black;}</style>
</head>
<body>
    <div class="container">
		<form id="saveFileForm" action="${pageContext.request.contextPath}/indicator/pmTemplet!saveFile.do" type="post">
			<div class="button-toolbar fixed" style="z-index: 99;">
			  <div class="button-group">
			    <button type="button" class="button bg-blue" onclick="saveFile();">
			    	<span class="icon-save text-white"></span> 保存
			    </button>
			  </div>
			</div>
			<textarea id="fileContent" name="fileContent">${request.fileContent }</textarea>
			<input type="hidden" name="filePath" id="filePath" value="${request.filePath }" >
		</form>
	</div>

	<script>
		var editor = CodeMirror.fromTextArea(document.getElementById("fileContent"), {
		  lineNumbers: true,
		  mode: "application/x-jsp"
		});
		function saveFile() {
			document.getElementById("fileContent").value = editor.getValue();

			saveFileForm.submit();
		}
	</script>
</body>