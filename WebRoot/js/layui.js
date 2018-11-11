//一般直接写在一个js文件中
layui.use(['layer', 'form'], function(){
  var layer = layui.layer
  ,form = layui.form;
  
  layer.msg('Hello World');
});


//弹出一个提示层
function test1() {
  layer.msg('hello');
};

	
	
function test2() {
	//弹出一个页面层
	    layer.open({
	      type: 1,
	      area: ['600px', '360px'],
	      shadeClose: true, //点击遮罩关闭
	      content: '\<\div style="padding:20px;">自定义内容\<\/div>'
	    });
	  };


	 function test3() {
		  //弹出一个iframe层
		 
		    layer.open({
		      type: 2,
		      title: 'iframe父子操作',
		      maxmin: true,
		      shadeClose: true, //点击遮罩关闭层
		      area : ['800px' , '520px'],
		      content: 'test/iframe.html'
		    });
	}
	  
	  function tips() {
		//tips层
		 layer.tips('Hi，我是tips', '#tips');
		  layer.tips('我是另外一个tips，只不过我长得跟之前那位稍有些不一样。', '#test1', {
			  tips: [1, '#3595CC'],
			  time: 4000
			});
	}

	  function loading() {
		  //弹出一个loading层
		 
		    var ii = layer.load();
		    //此处用setTimeout演示ajax的回调
		    setTimeout(function(){
		      layer.close(ii);
		    }, 1000);
		
	}
	  

	  
	
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
