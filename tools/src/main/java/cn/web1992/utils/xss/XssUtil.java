package cn.web1992.utils.xss;

/**
 * Xss工具类，主要对Xss攻击非法字符进行过滤
 *                       
 * @Filename: XssUtil.java
 * @Version: 1.0
 * @Author:
 * @Email:
 *
 */
public class XssUtil {

    /**
     * xss攻击数据清洗
     */
    public static String cleanXSS(String value) {
        if (value == null)
            return null;
        value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
        value = value.replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");
        value = value.replaceAll("'", "& #39;");
        value = value.replaceAll("eval\\((.*)\\)", "");
        value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
        value = value.replaceAll("script", "");
        return value;
    }

    /**
     * xss攻击数据清洗
     */
    public static String disCleanXSS(String value) {
        if (value == null)
            return null;
        value = value.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
        value = value.replaceAll("&#40;", "\\(").replaceAll("&#41;", "\\)");
        value = value.replaceAll("&#39;", "'");
        //  value = value.replaceAll("", "eval\\((.*)\\)");
        value = value.replaceAll("\"\"", "[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']");
        // value = value.replaceAll("", "script");
        return value;
    }
}
