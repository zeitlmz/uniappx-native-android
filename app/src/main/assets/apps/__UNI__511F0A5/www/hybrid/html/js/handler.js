// 在iframe内部执行以下代码
var iframeId = window.frameElement.getAttribute('id');
// 或者使用简写形式（两者等价）
var iframeId = this.frameElement.id;
// 等待初始化完毕
document.addEventListener('UniAppJSBridgeReady', () => {
	window.parent.postMessage({
		action: 'onJSBridgeReady',
		data: '',
		iframeId: iframeId
	}, '*');
	uni.postMessage({
		data: {
			action: 'onJSBridgeReady'
		}
	})

})

// window.addEventListener('message', function(event) {

//   // 根据消息内容执行相应的操作或调用函数
//   if (typeof event.data === 'object' && event.data.action === 'callFunctionInIframe') {
//     var data = event.data.data;
//     myFunctionInIframe(data);
//   }
// });


var qr = null
// 绘制二维码。
//https://github.com/soldair/node-qrcode?tab=readme-ov-file#createtext-options
function createQrcode(size, foreground, background, text, logo, logoSize, padding) {
	// let width = window.frameElement.offsetWidth
	// let height = window.frameElement.offsetHeight
	var canvas = document.getElementById("qrcode")
	// canvas.width=width
	// canvas.height=height
	// canvas.style.width=width+'px'
	// canvas.style.height=height+'px'
	canvas.style.display = "block"
	let ctx = canvas.getContext("2d");
	ctx.clearRect(0, 0, canvas.width, canvas.height);
	document.body.style.overflow = "hidden"
	document.body.style.height = "100%"
	size = size || 128;
	padding = padding || 2
	QRCode.toCanvas(canvas, text || 'xui', {
		element: canvas,
		width: size,
		errorCorrectionLevel: 'H',
		margin: padding,
		color: {
			dark: foreground || "black",
			light: background || "white"
		}
	})
	if (logo) {
		let ctx = canvas.getContext("2d");
		let img = new Image();
		logoSize = logoSize || 50
		img.width = logoSize + "px"
		img.height = logoSize + "px"
		img.src = logo
		img.onload = function() {
			let x = (size - logoSize) / 2
			let y = x;
			ctx.drawImage(img, x, y, logoSize, logoSize)
		}
	}

}
//获取二维码图片。
function QrcodeToDateUrl() {
	if (qr) {
		let imgdata = qr.toDataURL();
		uni.postMessage({
			data: {
				action: 'img',
				url: imgdata
			}
		})
	} else {
		uni.postMessage({
			data: {
				action: 'error',
			}
		})
	}
}


var ect = null;

function getchart() {
	if (ect) return ect;
	let dom = document.getElementById('echart');
	return echarts.init(dom);
}

function chart_setSize() {
	let width = window.innerWidth
	let height = window.innerHeight
	let dom = document.getElementById('echart');
	let domhtml = document.getElement
	dom.style.width = width + 'px'
	dom.style.height = height + 'px'
	document.getElementsByTagName('html')[0].style = 'overflow:hidden'
}

function parseJsonWithFunction(jsonString) {
	// 如果输入不是字符串，直接返回
	if (typeof jsonString !== 'string') {
		return jsonString;
	}
	
	try {
		// 首先尝试直接解析，如果是普通JSON可以直接解析成功
		return JSON.parse(jsonString);
	} catch (e) {
		// 如果解析失败，可能包含函数，进行预处理
	}
	
	// 预处理：识别并处理各种函数形式
	let processedStr = jsonString;
	
	// 处理常规函数定义 "key": function(params) { ... }
	processedStr = processedStr.replace(/"([^"]+)"\s*:\s*(function\s*\([^)]*\)\s*\{)/g, function(match, key, funcStart) {
		// 找到函数的开始位置
		const startIndex = jsonString.indexOf(match) + match.length - 1; // -1 是为了包含 { 字符
		let braceCount = 1; // 已经找到了第一个 {
		let endIndex = startIndex;

		// 寻找匹配的结束括号
		for (let i = startIndex + 1; i < jsonString.length; i++) {
			if (jsonString[i] === '{') braceCount++;
			if (jsonString[i] === '}') braceCount--;
			
			if (braceCount === 0) {
				endIndex = i;
				break;
			}
		}

		// 提取完整的函数字符串
		const fullFuncStr = jsonString.substring(jsonString.indexOf(funcStart, jsonString.indexOf(match)), endIndex + 1);
		// 转义函数字符串中的双引号和反斜杠
		const escapedFuncStr = fullFuncStr.replace(/\\/g, '\\\\').replace(/"/g, '\\"');
		
		return `"${key}": "${escapedFuncStr}"`;
	});
	
	// 处理箭头函数 - 带花括号形式 "key": (params) => { ... }
	processedStr = processedStr.replace(/"([^"]+)"\s*:\s*(\([^)]*\)\s*=>\s*\{)/g, function(match, key, funcStart) {
		// 找到函数的开始位置
		const startIndex = jsonString.indexOf(match) + match.length - 1; // -1 是为了包含 { 字符
		let braceCount = 1; // 已经找到了第一个 {
		let endIndex = startIndex;

		// 寻找匹配的结束括号
		for (let i = startIndex + 1; i < jsonString.length; i++) {
			if (jsonString[i] === '{') braceCount++;
			if (jsonString[i] === '}') braceCount--;
			
			if (braceCount === 0) {
				endIndex = i;
				break;
			}
		}

		// 提取完整的函数字符串
		const fullFuncStr = jsonString.substring(jsonString.indexOf(funcStart, jsonString.indexOf(match)), endIndex + 1);
		// 转义函数字符串中的双引号和反斜杠
		const escapedFuncStr = fullFuncStr.replace(/\\/g, '\\\\').replace(/"/g, '\\"');
		
		return `"${key}": "${escapedFuncStr}"`;
	});
	
	// 处理箭头函数 - 简写形式 "key": (params) => expression
	processedStr = processedStr.replace(/"([^"]+)"\s*:\s*(\([^)]*\)\s*=>\s*[^{\n,}]+)([,}])/g, function(match, key, funcBody, ending) {
		// 转义函数字符串中的双引号和反斜杠
		const escapedFuncStr = funcBody.replace(/\\/g, '\\\\').replace(/"/g, '\\"');
		return `"${key}": "${escapedFuncStr}"${ending}`;
	});
	
	// 处理单参数箭头函数 - 无括号 "key": param => expression
	processedStr = processedStr.replace(/"([^"]+)"\s*:\s*([a-zA-Z0-9_$]+\s*=>\s*[^{\n,}]+)([,}])/g, function(match, key, funcBody, ending) {
		// 转义函数字符串中的双引号和反斜杠
		const escapedFuncStr = funcBody.replace(/\\/g, '\\\\').replace(/"/g, '\\"');
		return `"${key}": "${escapedFuncStr}"${ending}`;
	});
	
	try {
		const parsed = JSON.parse(processedStr);
		
		// 递归处理对象，将字符串形式的函数转换回函数
		function restoreFunctions(obj) {
			if (typeof obj !== 'object' || obj === null) return obj;
			
			for (let key in obj) {
				if (typeof obj[key] === 'string') {
					const value = obj[key].trim();
					
					// 检测是否为函数字符串
					const isFunctionStr = 
						// 常规函数
						/^\s*function\s*\([^)]*\)\s*\{[\s\S]*\}\s*$/.test(value) ||
						// 箭头函数 - 带花括号
						/^\s*\([^)]*\)\s*=>\s*\{[\s\S]*\}\s*$/.test(value) ||
						// 箭头函数 - 简写形式
						/^\s*\([^)]*\)\s*=>\s*[^{\s][\s\S]*$/.test(value) ||
						// 单参数箭头函数 - 无括号
						/^\s*[a-zA-Z0-9_$]+\s*=>\s*[^{\s][\s\S]*$/.test(value) ||
						// 单参数箭头函数 - 带花括号
						/^\s*[a-zA-Z0-9_$]+\s*=>\s*\{[\s\S]*\}\s*$/.test(value);
					
					if (isFunctionStr) {
						try {
							// 处理箭头函数
							if (value.includes('=>')) {
								let params = [];
								let body = '';
								
								if (value.trim().startsWith('(')) {
									// 带括号的参数列表
									const arrowMatch = value.match(/^\s*\(([^)]*)\)\s*=>/);
									if (arrowMatch) {
										params = arrowMatch[1].split(',').map(p => p.trim());
										const bodyStart = value.indexOf('=>') + 2;
										body = value.substring(bodyStart).trim();
									}
								} else {
									// 单参数无括号
									const arrowMatch = value.match(/^\s*([a-zA-Z0-9_$]+)\s*=>/);
									if (arrowMatch) {
										params = [arrowMatch[1].trim()];
										const bodyStart = value.indexOf('=>') + 2;
										body = value.substring(bodyStart).trim();
									}
								}
								
								// 处理箭头函数体
								if (body) {
									if (body.startsWith('{') && body.endsWith('}')) {
										// 带花括号的函数体，去掉花括号
										body = body.substring(1, body.length - 1).trim();
										obj[key] = new Function(...params, body);
									} else {
										// 简写形式，添加return
										obj[key] = new Function(...params, `return ${body}`);
									}
								}
							} else if (value.startsWith('function')) {
								// 处理普通函数
								const funcMatch = value.match(/function\s*\(([^)]*)\)\s*\{([\s\S]*)\}\s*$/);
								if (funcMatch) {
									const params = funcMatch[1].split(',').map(p => p.trim());
									const body = funcMatch[2].trim();
									obj[key] = new Function(...params, body);
								}
							}
						} catch (e) {
							console.error('函数创建错误:', e, value);
						}
					}
				} else if (typeof obj[key] === 'object') {
					restoreFunctions(obj[key]);
				}
			}
			return obj;
		}
		
		return restoreFunctions(parsed);
	} catch (error) {
		console.error('JSON 解析错误:', error);
		return null;
	}
}
// 解码 JSON 字符串（包括深层解码）
function decodeJSON(jsonString) {
	// 如果输入不是字符串，直接返回
	if (typeof jsonString !== 'string') {
		return jsonString;
	}
	
	try {
		// 首先尝试直接解析，如果是普通JSON可以直接解析成功
		return JSON.parse(jsonString, function(key, value) {
			// 检测是否为函数字符串
			if (typeof value === 'string') {
				// 匹配各种函数定义模式
				const isFunctionStr = 
					// 常规函数
					/^\s*function\s*\([^)]*\)\s*\{[\s\S]*\}\s*$/.test(value) ||
					// 箭头函数 - 带花括号
					/^\s*\([^)]*\)\s*=>\s*\{[\s\S]*\}\s*$/.test(value) ||
					// 箭头函数 - 简写形式
					/^\s*\([^)]*\)\s*=>\s*[^{\s][\s\S]*$/.test(value) ||
					// 单参数箭头函数 - 无括号
					/^\s*[a-zA-Z0-9_$]+\s*=>\s*[^{\s][\s\S]*$/.test(value) ||
					// 单参数箭头函数 - 带花括号
					/^\s*[a-zA-Z0-9_$]+\s*=>\s*\{[\s\S]*\}\s*$/.test(value);

				if (isFunctionStr) {
					// 如果是函数字符串，尝试转换为函数
					try {
						// 使用Function构造函数创建函数
						if (value.includes('=>')) {
							// 处理箭头函数
							let params = [];
							let body = '';
							
							if (value.trim().startsWith('(')) {
								// 带括号的参数列表
								const arrowMatch = value.match(/^\s*\(([^)]*)\)\s*=>/);
								if (arrowMatch) {
									params = arrowMatch[1].split(',').map(p => p.trim());
									const bodyStart = value.indexOf('=>') + 2;
									body = value.substring(bodyStart).trim();
								}
							} else {
								// 单参数无括号
								const arrowMatch = value.match(/^\s*([a-zA-Z0-9_$]+)\s*=>/);
								if (arrowMatch) {
									params = [arrowMatch[1].trim()];
									const bodyStart = value.indexOf('=>') + 2;
									body = value.substring(bodyStart).trim();
								}
							}
							
							// 处理箭头函数体
							if (body) {
								if (body.startsWith('{') && body.endsWith('}')) {
									// 带花括号的函数体，去掉花括号
									body = body.substring(1, body.length - 1).trim();
									return new Function(...params, body);
								} else {
									// 简写形式，添加return
									return new Function(...params, `return ${body}`);
								}
							}
						} else {
							// 处理普通函数
							const funcMatch = value.match(/function\s*\(([^)]*)\)\s*\{([\s\S]*)\}\s*$/);
							if (funcMatch) {
								const params = funcMatch[1].split(',').map(p => p.trim());
								const body = funcMatch[2].trim();
								return new Function(...params, body);
							}
						}
					} catch (e) {
						console.error('函数创建错误:', e, value);
						// 如果函数创建失败，返回原始字符串
						return value;
					}
				}
			}
			return value;
		});
	} catch (error) {
		// 如果JSON解析失败，尝试使用parseJsonWithFunction处理
		try {
			return parseJsonWithFunction(jsonString);
		} catch (e) {
			console.error('JSON 解析错误:', error);
			return null;
		}
	}
}

function chart_setOption(optionStr) {
	chart_setSize()
	// 基于准备好的dom，初始化echarts实例
	let chart = getchart();
	if (!optionStr) return;
	//  JSON.parse(optionStr)
	let option = decodeJSON(optionStr)

	chart.setOption(option)
}

function chart_call(funName, optionStr, eventsid) {

	chart_setSize()
	let filterevents = ["click"]
	// 基于准备好的dom，初始化echarts实例
	let chart = getchart();

	if (filterevents.includes(funName)) {

		chart['on'](funName, function(params) {
			delete params.event
			window.parent.postMessage({
				action: funName,
				eventId: eventsid,
				data: JSON.stringify(params),
				iframeId: iframeId
			}, '*');

			uni.postMessage({
				data: {
					action: funName,
					eventId: eventsid,
					data: JSON.stringify(params)
				}
			})

		})
	} else {

		try {
			let option = JSON.parse(optionStr)
			chart[funName](option)
		} catch (e) {
			chart[funName]()
		}
	}



}