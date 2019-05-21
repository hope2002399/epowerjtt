
/**
 * 
 */

/* MyConstant begin */
function MyConstant() {}
/* MyConstant end */

/* StringBuffer begin */
function StringBuffer() {
	this._strings_ = new Array();
}
StringBuffer.prototype.append = function(str) {
	this._strings_.push(str);
};
StringBuffer.prototype.toString = function() {
	return this._strings_.join('');
};
/* StringBuffer end */

/* Map begin */
function Map() {
	this._map_ = new Object();
}
Map.prototype.put = function(key, value) {
	this._map_['k_' + key] = value;
};
Map.prototype.get = function(key) {
	return this._map_['k_' + key];
};
Map.prototype.remove = function(key) {
	delete this._map_['k_' + key];
};
Map.prototype.keyset = function() {
	var array = new Array();
	for (var key in this._map_) {
		if (key.indexOf('k_') == 0) {
			array[i++] = key.substr(2);
		}
	}
	return array;
};
/* Map end */

/* StringUtils begin */
function StringUtils() {}
StringUtils.lTrim = function(str) {
	for (var i = 0; i < str.length; i++) {
		if (str.charAt(i) != ' ') {
			return str.substr(i);
		}
	}
	return '';
};
StringUtils.rTrim = function(str) {
	for (var i = str.length - 1; i>=0; i--) {
		if (str.charAt(i) != ' ') {
			return str.substr(0, i + 1);
		}
	}
	return '';
};
StringUtils.trim = function(str) {
	return StringUtils.lTrim(StringUtils.rTrim(str));
};
StringUtils.clearBlank = function(str) {
	return str.replace(/\s/g, '');
};
StringUtils.isBlank = function(str) {
	return ('' == StringUtils.clearBlank(str));
};
StringUtils.isChinese = function(str) {
	var lst = /[u00-uFF]/;
    return !lst.test(str);
};
StringUtils.strlen = function(str) {
	var strLength = 0;
	for (var i = 0; i < str.length; i++){
		if (StringUtils.isChinese(str.charAt(i))) {
			strLength += 2;
		} else {
			strLength++;
		}
	}
	return strLength;
};
StringUtils.isNumber = function(str) {
	return !isNaN(Number(str));
};
StringUtils.toNumber = function(str) {
	return Number(str);
};
StringUtils.contains = function(string, included) {
	if (string == null || string == undefined || included == null || included == undefined) {
		return false;
	} else {
		if (included == '') {
			return true;
		} else if (string.length < included.length) {
			return false;
		} else {
			var index = 0;
			for (var i=0; i < string.length; i++) {
				if (included.charAt(index) == string.charAt(i)) {
					index++;
					if (index == included.length) {
						return true;
					}
				} else {
					index = 0;
				}
			}
			return false;
		}
	}
};
/* StringUtils end */

/* CommonUtils begin */
function CommonUtils() {}
CommonUtils._webSite_;
CommonUtils.setWebSite = function(webSite) {
	if (typeof CommonUtils._webSite_ == 'undefined') {
		CommonUtils._webSite_ = webSite;
	}
};
CommonUtils.linkWebSite = function(url) {
	return (CommonUtils._webSite_ + url);
};
CommonUtils.isNvl = function(node) {
	return !node || !node.value || StringUtils.isBlank(node.value);
};
CommonUtils.showTextAreaLimited = function(textAreaId, messageId, maxLen) {
	var textAreaNode = document.getElementById(textAreaId);
	var messageNode = document.getElementById(messageId);
	if (!textAreaNode || !messageNode) {
		alert('Can not found textarea or message!');
	} else {
		try {
			var len = textAreaNode.value.length;
			if (0 == len) {
				messageNode.innerHTML = '';
			} else {
				if (len <= maxLen) {
					messageNode.innerHTML = '<font color=#0000ff>当前还可以输入 ' + (maxLen - len) + ' 字';
				} else {
					messageNode.innerHTML = '<font color=#ff0000>当前已经超出 ' + (len - maxLen) + ' 字';
				}
			}
		} catch (e) {
			messageNode.innerHTML = '<font color=#ff0000>Input check error!</font>';
		}
	}
};
CommonUtils.jsonParse = function(jsonStr) {
	return eval('(' + jsonStr + ')');
};
/* CommonUtils end */

/* MenuUtils begin */
function MenuUtils() {}
/* MenuUtils end */

/* ArrayUtils begin */
function ArrayUtils() {}
ArrayUtils.getIndex = function(array, value) {
	if (array instanceof Array) {
		for (var i=0; i<array.length; i++) {
			if (value == array[i]) {
				return i;
			}
		}
		return -1;
	}
	return false;
};
ArrayUtils.getLastIndex = function(array, value) {
	if (array instanceof Array) {
		for (var i=array.length-1; i>=0; i--) {
			if (value == array[i]) {
				return i;
			}
		}
		return -1;
	}
	return false;
};
/* ArrayUtils end */
/* CssUtils begin */
function CssUtils() {}
CssUtils.removeCss = function() {
	return false;
};
/* CssUtils end */