package util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.util.EntityUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HtmlParse {

    final static String REPLACE_CHART[] = new String[]{"fbExpoId: \\$\\.getQuery\\(\\'fb_expo_id\\'\\),", " showType: \\$\\.getQuery\\(\\'show_type\\'\\),"};

    public static List<String> parseBeiKeLink(Document document) {
        Elements elements = document.select("a[href]");
        List<String> links = new ArrayList<String>();
        String href = "";
        for (Element element : elements) {
            href = element.attr("href");
            if (href.endsWith(".html")) {
                links.add(href);
            }
        }
        return links;
    }

    public static <T> T parseBeiKeHourseInfo(Document document, Class<T> t) {
        T info = null;
        Elements links = document.select("script");
        for (Element link : links) {
            String data = link.data();
            if (data.contains("window.GLOBAL_INFOS")) {
                for (String rep : REPLACE_CHART) {
                    data = data.replaceAll(rep, "");
                }
                info = (T) JSONObject.parseObject(data.split("window.GLOBAL_INFOS = ")[1], t);
            }
        }
        return info;
    }

}
