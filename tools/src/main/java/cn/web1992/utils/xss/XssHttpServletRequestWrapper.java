package cn.web1992.utils.xss;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 防xss攻击
 *
 * @Filename: XssHttpServletRequestWrapper.java
 * @Version: 1.0
 * @Author:
 * @Email:
 */
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {

    public XssHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    public String[] getParameterValues(String parameter) {
        String[] values = super.getParameterValues(parameter);
        if ("description".equals(parameter))
            return values;
        if (values == null) {
            return null;
        }
        int count = values.length;
        String[] encodeValues = new String[count];
        for (int i = 0; i < count; i++) {
            encodeValues[i] = XssUtil.cleanXSS(values[i]);
        }
        return encodeValues;
    }

    public String getParameter(String parameter) {
        String value = super.getParameter(parameter);
        if (value == null) {
            return value;
        }
        if ("description".equals(parameter))
            return value;
        return XssUtil.cleanXSS(value);
    }

    @SuppressWarnings("unchecked")
    public Map<String, String[]> getParameterMap() {
        Map<String, String[]> map = super.getParameterMap();
        if (map == null) {
            return map;
        }
        String key;
        String[] value;
        String[] encodeValues;
        Map<String, String[]> mapEncoded = new HashMap<String, String[]>();
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            key = it.next().toString();
            value = map.get(key);
            encodeValues = new String[value.length];
            for (int i = 0; i < value.length; i++) {
                if ("description".equals(key)) {
                    encodeValues[i] = value[i];
                } else
                    encodeValues[i] = XssUtil.cleanXSS(value[i]);
            }
            mapEncoded.put(key, encodeValues);
        }
        return mapEncoded;
    }

    public Object getAttribute(String name) {
        Object value = super.getAttribute(name);
        if (value instanceof String) {
            if ("description".equals(name)) {

            } else {
                value = XssUtil.cleanXSS((String) value);
            }
        }
        return value;
    }

    public String getHeader(String name) {
        String value = super.getHeader(name);
        if (value == null) {
            return null;
        }
        return XssUtil.cleanXSS(value);
    }

}
