(function() {
	var r, url;
	var s = location.href;
	url = 'http://wan.renren.com/';
	if (s.search(url) >= 0) {
		var head = document.getElementById("topHead");
		head.style.width = "990px";
	}
})();

/** js 函数闭包* */
(function() {

})();
// 分开
function a() {
}
a();
// 一起
(function() {
})();
/** js 函数闭包 end* */
// 
var myDiv = {
	// 函数对象
	input : function() {
		// 事件添加
		$(".payAmount", target).click(function() {
			// do something ...
		});
	},
	button : function() {

	},
	a : function() {

	}
}

// 层叠选择器，按照你的规则，有规律的组织页面
$(".pay_class h3 a").click(function() {
	var selchannel = $(this).attr("channelCode");
	// do something ...
});

$("#gameList li").each(function() {
	$(this).html('');
});

// 异步的提交表单
$.ajax({
	url : "create",
	type : "POST",
	data : $("#payform").serialize(),
	async : false,
	success : function(jsonData) {
		var data = eval("(" + jsonData + ")");
		// do something
	},
	error : function(XMLHttpRequest, textStatus, errorThrown) {
		// do something
	}
});

//
window.location.href = '连接地址';

// jQuery 提交表单
$('#thirdForm input[name="url"]').val(data.redirectUrl);
$('#thirdForm').submit();

// 切换服务器列表
$(".ser_til a").click(function() {
	var _serListname = $(".ser_listname");
	var _index = $(".ser_til a").index($(this));
	_serListname.hide().eq(_index).show();
});
