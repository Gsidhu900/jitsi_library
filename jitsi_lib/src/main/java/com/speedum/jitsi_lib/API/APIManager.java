package com.speedum.jitsi_lib.API;

import android.text.Annotation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.speedum.jitsi_lib.API.APIModels.GetJWTToken.GetJWTTokenReturnData;
import com.speedum.jitsi_lib.API.APIModels.Session_Token.SessionTokenBody;
import com.speedum.jitsi_lib.API.APIModels.Session_Token.SessionTokenResponse;

import java.io.IOException;
import java.net.Proxy;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Url;

/**
 * Created by gagan on 2/27/2016.
 */
public class APIManager {

    public interface APIInterface {
        @POST(API_link)
        Call<SessionTokenResponse> Create_Session(@Url String Url, @Body SessionTokenBody sessionTokenBody, @Header("Sgintprocess") String sgIntProcess, @Header("Sgintenvironment") String sgIntEnvironment);

       @POST(API_link)
        Call<CommonResponse<GetJWTTokenReturnData>> getJwtToken(@Url String Url, @Body CommonBody body, @Header("Sgsessiontoken") String SGSessionToken);



    }
//    private static com.speedum.healthstore.Config Config=new Config();
//    private static String Api_link= Util.CheckForNullValue(Config.getAPI_Link());
//    private static String mHeader="";

    private static final String API_URL = "http://144.168.164.102:8100/";
    //    private static final String API_link =  (!Api_link.equalsIgnoreCase(""))?Api_link:"";
    private static final String API_link = "";
    private static final String INTERNAL_link = "suggestusUltra/suggestus/internal";

    private static APIManager ourInstance = new APIManager();

    public static APIManager getInstance() {
        return ourInstance;
    }

    private APIManager() {
    }


    final static OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(320, TimeUnit.SECONDS).writeTimeout(120, TimeUnit.SECONDS)
            .sslSocketFactory(getSSLSocketFactory())
            .readTimeout(320, TimeUnit.SECONDS).addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();

                    Request request = original.newBuilder()
                            //"Content-type: application/json"
                            .header("User-Agent", "vHelp")
                            .header("Content-type", "application/json")
                            .header("Accept", "application/json")
//                            .addHeader("Authorization", "Bearer" + Common.mToken)
                            .method(original.method(), original.body())
                            .build();
                    return chain.proceed(request);
                }
            }).build();
    final static OkHttpClient client = okHttpClient;
    final static Gson gson = new GsonBuilder().create();
    private static final Retrofit REST_ADAPTER = new Retrofit.Builder()
            .addConverterFactory(new GsonStringConverterFactory())
            .baseUrl(API_URL).addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build();

    final static public class GsonStringConverterFactory extends Converter.Factory {


        public Converter<?, RequestBody> toRequestBody(Proxy.Type type, Annotation[] annotations) {
            if (String.class.equals(type))// || (type instanceof Class && ((Class<?>) type).isEnum()))
            {
                return new Converter<String, RequestBody>() {
                    @Override
                    public RequestBody convert(String value) throws IOException {
                        MediaType MEDIA_TYPE = MediaType.parse("application/json");
                        return RequestBody.create(MEDIA_TYPE, value);
                    }
                };
            }
            return null;
        }
    }

    private static SSLSocketFactory getSSLSocketFactory() {
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            return sslSocketFactory;
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            return null;
        }

    }

    private static final APIInterface GIT_HUB_SERVICE = REST_ADAPTER.create(APIInterface.class);

    public static APIInterface getService() {
        return GIT_HUB_SERVICE;
    }


}
