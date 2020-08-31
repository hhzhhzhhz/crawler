package util;

import com.sun.javafx.fxml.builder.URLBuilder;
import constant.HttpMethEnum;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class HttpClient {


    private static PoolingHttpClientConnectionManager httpPool = new PoolingHttpClientConnectionManager();

    private static HashMap<String, String> DEFALULT_HEADERS = null;

    static {
        httpPool.setMaxTotal(50);
        httpPool.setDefaultMaxPerRoute(10);
        DEFALULT_HEADERS = new HashMap<String, String>(1);
        DEFALULT_HEADERS.put("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.135 Safari/537.36");
    }

    public static CloseableHttpResponse Post(String addr, HashMap<String, String> headers, HashMap<String, String> params, String body) throws IOException, URISyntaxException{
        return post(addr, headers, params, body, null);
    }

    public static CloseableHttpResponse Post(String addr, HashMap<String, String> params, String body) throws IOException, URISyntaxException{
        return post(addr, DEFALULT_HEADERS, params, body, null);
    }

    public static CloseableHttpResponse Post(String addr, String body) throws IOException, URISyntaxException{
        return post(addr, DEFALULT_HEADERS, null, body, null);
    }

    public static CloseableHttpResponse Get(String addr,HashMap<String, String> headers, HashMap<String, String> params) throws IOException, URISyntaxException{
        return get(addr, headers, params);
    }

    public static CloseableHttpResponse Get(String addr, HashMap<String, String> params) throws IOException, URISyntaxException{
        return get(addr, DEFALULT_HEADERS, params);
    }
    public static CloseableHttpResponse Get(String addr) throws IOException, URISyntaxException{
        return get(addr, DEFALULT_HEADERS, null);
    }

    private static CloseableHttpResponse post(String addr, HashMap<String, String> headers, HashMap<String, String> params, String body, String charset)throws ClientProtocolException, IOException, URISyntaxException{
        return client(addr, HttpMethEnum.POST, headers, params, body.getBytes(null == charset ? "UTF-8" : charset));
    }

    private static CloseableHttpResponse get(String addr, HashMap<String, String> headers, HashMap<String, String> params)throws ClientProtocolException, IOException, URISyntaxException{
        return client(addr, HttpMethEnum.GET, headers, params, null);
    }



    private static  <T> T client(String url,
                               HttpMethEnum httpMethEnum,
                               HashMap<String,String> headers,
                               HashMap<String,String> params,
                               byte[] body
    ) throws IOException, URISyntaxException {
        T t = null;
        URIBuilder uri =  new URIBuilder(url);
        if (null != params) {
            for (Map.Entry<String, String> param : params.entrySet()){
                uri.setParameter(param.getKey(), param.getValue());
            }
        }

        switch (httpMethEnum){
            case GET:
                t=  get(uri.build(), headers);
                break;
            default:
                t = post(uri.build(), headers, body);
        }
        return t;
    }

    private static <T> T get (URI uri, HashMap<String, String> headers) throws IOException{
        HttpGet get = new HttpGet(uri);
        if (null != headers) {
            for (Map.Entry<String, String> header : headers.entrySet()){
                get.setHeader(header.getKey(), header.getValue());
            }
        }
        return execute(get);
    }

    private static <T> T post(URI uri, HashMap<String, String> headers , byte[] body) throws IOException {
        HttpPost post = new HttpPost(uri);
        if (null != headers) {
            for (Map.Entry<String, String> header : headers.entrySet()){
                post.setHeader(header.getKey(), header.getValue());
            }
        }
        post.setEntity(new ByteArrayEntity(body));
        return execute(post);
    }

    private static  <T> T execute(HttpUriRequest request) throws IOException {
        return (T) HttpClients.custom().setConnectionManager(httpPool).build().execute(request);
    }


}
