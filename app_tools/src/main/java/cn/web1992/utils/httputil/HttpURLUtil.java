package cn.web1992.utils.httputil;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;


public final class HttpURLUtil {
	
	public static String doPost(String reqUrl, Map<String, String> parameters){
		return doPost(reqUrl, parameters, "UTF-8");
	}
	
	/**
	 * 
	 * @param reqUrl
	 * @param parameters
	 * @return
	 */
	public static String doPost(String reqUrl, Map<String, String> parameters, String charset) {
        HttpURLConnection urlConn = null;
        try {
            urlConn = sendPost(reqUrl, parameters, charset);
            String responseContent = getContent(urlConn, charset);
            return responseContent.trim();
        } finally {
            if (urlConn != null) {
                urlConn.disconnect();
                urlConn = null;
            }
        }
    }
	
	public static String doPost(String reqUrl,String body,String charset) throws Exception {
        HttpURLConnection urlConn = null;
        URL url = new URL(reqUrl);
        urlConn = (HttpURLConnection) url.openConnection();
        urlConn.setRequestMethod("POST");
        urlConn.setConnectTimeout(30000);
        urlConn.setReadTimeout(50000);
        urlConn.setDoOutput(true);
        byte[] b = body.getBytes(charset);
        urlConn.getOutputStream().write(b, 0, b.length);
        urlConn.getOutputStream().flush();
        urlConn.getOutputStream().close();
        String content = getContent(urlConn, charset);
        return content.trim();
    }
	
	/**
	 * 
	 * @param urlConn
	 * @return
	 */
	private static String getContent(HttpURLConnection urlConn, String charset) {
        try {
            String responseContent = null;
            InputStream in = urlConn.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(in, charset));
            String tempLine = rd.readLine();
            StringBuffer tempStr = new StringBuffer();
            String crlf = System.getProperty("line.separator");
            while (tempLine != null) {
                tempStr.append(tempLine);
                tempStr.append(crlf);
                tempLine = rd.readLine();
            }
            responseContent = tempStr.toString();
            rd.close();
            in.close();
            return responseContent;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
	
	/**
	 * 
	 * @param reqUrl
	 * @param parameters
	 * @return
	 */
	private static HttpURLConnection sendPost(String reqUrl, Map<String, String> parameters, String charset) {
        HttpURLConnection urlConn = null;
        try {
            String params = generatorParamString(parameters, charset);
            //FileLogger.urlLog.info("post | url : " + reqUrl + "?" + params);
//            System.out.print("post | url : " + reqUrl + "?" + params);
            URL url = new URL(reqUrl);
            urlConn = (HttpURLConnection) url.openConnection();
            urlConn.setRequestMethod("POST");
            // urlConn
            // .setRequestProperty(
            // "User-Agent",
            // "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.3) Gecko/20100401 Firefox/3.6.3");
            urlConn.setConnectTimeout(30000);// （单位：毫秒）jdk
            urlConn.setReadTimeout(50000);// （单位：毫秒）jdk 1.5换成这个,读操作超时
            urlConn.setDoOutput(true);
            byte[] b = params.getBytes();
            urlConn.getOutputStream().write(b, 0, b.length);
            urlConn.getOutputStream().flush();
            urlConn.getOutputStream().close();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        return urlConn;
    }
	
	
	 /**
     * 将parameters中数据转换成用"&"链接的http请求参数形式
     * 
     * @param parameters
     * @return
     */
    public static String generatorParamString(Map<String, String> parameters, String charset) {
        StringBuffer params = new StringBuffer();
        if (parameters != null) {
            for (Iterator<String> iter = parameters.keySet().iterator(); iter.hasNext();) {
                String name = iter.next();
                String value = parameters.get(name);
                if(value == null){
                	continue;
                }
                params.append(name + "=");
                try {
                    params.append(URLEncoder.encode(value, charset));
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e.getMessage(), e);
                } catch (Exception e) {
                    String message = String.format("'%s'='%s'", name, value);
                    throw new RuntimeException(message, e);
                }
                
                if (iter.hasNext()) {
                	params.append("&");
                }
            }
        }
        return params.toString();
    }
    
    /**
     * 
     * @param link
     * @param charset
     * @return
     */
    public static String doGet(String link, String charset, int timeout) {
        try {
        	//FileLogger.urlLog.info("get | url : " + link);
            URL url = new URL(link);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");
            conn.setReadTimeout(timeout);
            conn.setConnectTimeout(timeout);
            BufferedInputStream in = new BufferedInputStream(conn.getInputStream());
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for (int i = 0; (i = in.read(buf)) > 0;) {
                out.write(buf, 0, i);
            }
            out.flush();
            String s = new String(out.toByteArray(), charset);
            return s;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
    
    /**
     * UTF-8编码
     * 
     * @param link
     * @return
     */
    public static String doGet(String link) {
        return doGet(link, "UTF-8", 50000);
    }
    
    public static String doGet(String link, int timeout){
    	return doGet(link, "UTF-8", timeout);
    }
    
    /**
     * url 编码
     * @param url
     * @param enc
     * @return
     */
    public static String urlEncoding(String url, String enc) {
    	try {
			return URLEncoder.encode(url, enc);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
    }
}
