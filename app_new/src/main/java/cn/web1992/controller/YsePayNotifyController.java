package cn.web1992.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author web1992
 * @date 2017/3/28 14:43
 * @desc
 */
@Controller
@RequestMapping("wap")
public class YsePayNotifyController {


	private static Logger LOG = LoggerFactory.getLogger(YsePayNotifyController.class);


	//@Autowired
	//YsePayNotifyService notifyService;

	@RequestMapping(value = "/notify")
	@ResponseBody
	public String callback(HttpServletRequest request, HttpServletResponse response) {

		Map<String, String> paramMap = getParamMap(request.getParameterMap());


		try {
			//获取银盛POST过来反馈信息
			Map<String, String> params        = new HashMap<String, String>();
			Map                 requestParams = request.getParameterMap();
			for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
				String   name     = (String) iter.next();
				String[] values   = (String[]) requestParams.get(name);
				String   valueStr = "";
				for (int i = 0; i < values.length; i++) {
					valueStr = (i == values.length - 1) ? valueStr + values[i]
							: valueStr + values[i] + ",";
				}
				System.out.println("name：" + name + " value:" + valueStr);
				params.put(name, valueStr);
			}

			//交易目前所处的状态
			String trade_status = request.getParameter("trade_status");

			LOG.info("paramMap={}" + paramMap);
			System.out.println("YsePayNotifyController#callback paramMap={}" + paramMap);
			//notifyService.notify(paramMap);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}


		return "success";
	}


	private Map<String, String> getParamMap(Map<String, String[]> parameterMap) {
		if (parameterMap.size() > 0) {
			Map<String, String> map = new HashMap<>();
			for (String _key : parameterMap.keySet()) {
				map.put(_key, parameterMap.get(_key)[0]);
			}
			return map;
		}
		return null;
	}

	public static void main(String[] args) {

	}
}

