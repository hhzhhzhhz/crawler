package constant;

public enum HttpMethEnum {

    GET("get"),
    POST("post"),
    DELETE("delete"),
    UPDATE("update");

    HttpMethEnum (String method) {
    this.method = method;
    }
    String method;
}
