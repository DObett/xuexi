//import org.apache.hc.client5.http.classic.methods.ClassicHttpRequests;
//import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
//import org.apache.hc.core5.http.ClassicHttpRequest;
//import org.apache.hc.core5.http.HttpHost;
//import org.apache.hc.core5.http.Method;
//import org.apache.hc.core5.util.Timeout;
//
//import java.net.URI;
//import java.text.SimpleDateFormat;
//import java.util.Locale;
//import java.util.TimeZone;
//
//public class Request {
//    public static final String DATE_FORMAT = "EEE, dd MMM yyyy HH:mm:ss zzz";
//    public static final Locale DATE_LOCALE = Locale.US;
//    public static final TimeZone TIME_ZONE = TimeZone.getTimeZone("GMT");
//
//    private final ClassicHttpRequest request;
//    private Boolean useExpectContinue;
//    private Timeout connectTimeout;
//    private Timeout responseTimeout;
//    private HttpHost proxy;
//
//    private SimpleDateFormat dateFormatter;
//
//    public Request(HttpUriRequestBase httpUriRequestBase) {
//    }
//
//    public static Request create(final Method method, final URI uri) {
//        return new Request(new HttpUriRequestBase(method.name(), uri));
//    }
//
//    public static Request create(final String methodName, final String uri) {
//        return new Request(new HttpUriRequestBase(methodName, URI.create(uri)));
//    }
//
//    public static Request create(final String methodName, final URI uri) {
//        return new Request(new HttpUriRequestBase(methodName, uri));
//    }
//
//    public static Request get(final URI uri) {
//        return new Request((HttpUriRequestBase) ClassicHttpRequests.get(uri));
//    }
//
//    public static org.apache.hc.client5.http.fluent.Request get(final String uri) {
//        return new org.apache.hc.client5.http.fluent.Request(ClassicHttpRequests.get(uri));
//    }
//
//    public static org.apache.hc.client5.http.fluent.Request head(final URI uri) {
//        return new org.apache.hc.client5.http.fluent.Request(ClassicHttpRequests.head(uri));
//    }
//
//    public static org.apache.hc.client5.http.fluent.Request head(final String uri) {
//        return new org.apache.hc.client5.http.fluent.Request(ClassicHttpRequests.head(uri));
//    }
//
//    public static org.apache.hc.client5.http.fluent.Request post(final URI uri) {
//        return new org.apache.hc.client5.http.fluent.Request(ClassicHttpRequests.post(uri));
//    }
//
//    public static org.apache.hc.client5.http.fluent.Request post(final String uri) {
//        return new org.apache.hc.client5.http.fluent.Request(ClassicHttpRequests.post(uri));
//    }
//
//    public static org.apache.hc.client5.http.fluent.Request patch(final URI uri) {
//        return new org.apache.hc.client5.http.fluent.Request(ClassicHttpRequests.patch(uri));
//    }
//
//    public static org.apache.hc.client5.http.fluent.Request patch(final String uri) {
//        return new org.apache.hc.client5.http.fluent.Request(ClassicHttpRequests.patch(uri));
//    }
//
//    public static org.apache.hc.client5.http.fluent.Request put(final URI uri) {
//        return new org.apache.hc.client5.http.fluent.Request(ClassicHttpRequests.put(uri));
//    }
//
//    public static org.apache.hc.client5.http.fluent.Request put(final String uri) {
//        return new org.apache.hc.client5.http.fluent.Request(ClassicHttpRequests.put(uri));
//    }
//
//    public static org.apache.hc.client5.http.fluent.Request trace(final URI uri) {
//        return new org.apache.hc.client5.http.fluent.Request(ClassicHttpRequests.trace(uri));
//    }
//
//    public static org.apache.hc.client5.http.fluent.Request trace(final String uri) {
//        return new org.apache.hc.client5.http.fluent.Request(ClassicHttpRequests.trace(uri));
//    }
//
//    public static org.apache.hc.client5.http.fluent.Request delete(final URI uri) {
//        return new org.apache.hc.client5.http.fluent.Request(ClassicHttpRequests.delete(uri));
//    }
//
//    public static org.apache.hc.client5.http.fluent.Request delete(final String uri) {
//        return new org.apache.hc.client5.http.fluent.Request(ClassicHttpRequests.delete(uri));
//    }
//
//    public static org.apache.hc.client5.http.fluent.Request options(final URI uri) {
//        return new org.apache.hc.client5.http.fluent.Request(ClassicHttpRequests.options(uri));
//    }
//
//    public static org.apache.hc.client5.http.fluent.Request options(final String uri) {
//        return new org.apache.hc.client5.http.fluent.Request(ClassicHttpRequests.options(uri));
//    }
//
//}
