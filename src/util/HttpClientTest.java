package util;


import com.alibaba.fastjson.JSONObject;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class HttpClientTest {

    @Test
    public void http() throws Exception{
        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(10);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 1000, 1000l, TimeUnit.SECONDS, queue);

        for (int i=0; i<50;i++) {
            pool.execute(()->{
                try {
                    CloseableHttpResponse  res = HttpClient.Get("https://xm.ke.com/api/newhouserecommend?type=1&query=https://xm.ke.com/ershoufang/pg2/");
                    System.out.println(EntityUtils.toString(res.getEntity(), "UTF-8"));
                }catch (Exception e) {
                }
            });

            pool.execute(()->{
                try {
                    CloseableHttpResponse  res = HttpClient.Get("https://pagead2.googlesyndication.com/getconfig/sodar?sv=200&tid=gda&tv=r20200826&st=env");
                    System.out.println("baidu->>>>"+EntityUtils.toString(res.getEntity(), "UTF-8"));
                }catch (Exception e) {
                }
            });
        }
        while (true){
        }
    }

    @Test
    public void xmer()throws Exception {
        CloseableHttpResponse response =  HttpClient.Get("https://xm.ke.com/ershoufang/");
        System.out.println(EntityUtils.toString(response.getEntity(), "UTF-8"));
    }

}
