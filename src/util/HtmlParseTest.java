package util;

import model.bo.ListingInfo;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class HtmlParseTest {

    @Test
    public void test1() throws Exception{
        Document document = Jsoup.parse(EntityUtils.toString(HttpClient.Get("https://xm.ke.com/ershoufang/105105251034.html").getEntity(), "UTF-8"));
        ListingInfo listingInfo = HtmlParse.parseBeiKeHourseInfo(document, ListingInfo.class);
        System.out.println(listingInfo.toString());
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    /*
    queue
     */
    @Test
    public List<String> args () {
        return null;
    }


}
