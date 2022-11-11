package com.speedum.jitsi_libraries_main_app.API;

import android.text.Annotation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.speedum.jitsi_libraries_main_app.API.APIModels.Foot_Print.FootPrintBody;
import com.speedum.jitsi_libraries_main_app.API.APIModels.Foot_Print.FootPrintResponse;
import com.speedum.jitsi_libraries_main_app.API.APIModels.GetColorConfig.GetColorConfigResponse.GetColorConfigReturnDatum;
import com.speedum.jitsi_libraries_main_app.API.APIModels.HomeScreenConfig.HomeScreenConfigResponse.HomeScreenConfigReturnDatum;
import com.speedum.jitsi_libraries_main_app.API.APIModels.Login_User.LoginReturnData;
import com.speedum.jitsi_libraries_main_app.API.APIModels.MeetingList.MeetingListBody.MeetingListBody;
import com.speedum.jitsi_libraries_main_app.API.APIModels.MeetingList.MeetingListResponse.MeetingListResponse;
import com.speedum.jitsi_libraries_main_app.API.APIModels.OrgInfo.GetOrgIDReturnDatum;
import com.speedum.jitsi_libraries_main_app.API.APIModels.Save_Push_Token.SavePushTokenBody;
import com.speedum.jitsi_libraries_main_app.API.APIModels.Save_Push_Token.SavePushTokenResponse;
import com.speedum.jitsi_libraries_main_app.API.APIModels.Session_Token.SessionTokenBody;
import com.speedum.jitsi_libraries_main_app.API.APIModels.Session_Token.SessionTokenResponse;
import com.speedum.jitsi_libraries_main_app.API.Comman_Data.CommonBody;
import com.speedum.jitsi_libraries_main_app.API.Comman_Data.CommonResponse;
import com.speedum.jitsi_libraries_main_app.Config;

import java.io.IOException;
import java.net.Proxy;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Interceptor;
import okhttp3.MediaType;
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
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by Nitin Sood on 2/27/2016.
 */
public class APIManager {

    public interface APIInterface {
        ///https://stackoverflow.com/questions/41078866/retrofit-authorization-bearer-token

//        @POST(INTERNAL_link)
        @POST(INTERNAL_link)
        Call<FootPrintResponse> FootPrint(@Url String Url, @Body FootPrintBody footPrintBody, @Header("Sgintprocess") String sgIntProcess, @Header("Sgintenvironment") String sgIntEnvironment);

        @POST(INTERNAL_link)
        Call<SessionTokenResponse> Create_Session(@Url String Url,@Body SessionTokenBody sessionTokenBody, @Header("Sgintprocess") String sgIntProcess, @Header("Sgintenvironment") String sgIntEnvironment);

        @POST(API_link)
        Call<CommonResponse<LoginReturnData>> authenticateLogin(@Body CommonBody authData, @Header("Sgsessiontoken") String SGSessionToken);

        @POST(API_link)
        Call<CommonResponse<GetColorConfigReturnDatum>> getColorConfig(@Body CommonBody body, @Header("Sgsessiontoken") String SGSessionToken);

        @POST(API_link)
        Call<CommonResponse<GetOrgIDReturnDatum>> getOrgInfoFromServer(@Body CommonBody body, @Header("Sgsessiontoken") String SGSessionToken);


        @POST(API_link)
        Call<CommonResponse<HomeScreenConfigReturnDatum>> getHomeScreenConfig(@Body CommonBody body, @Header("Sgsessiontoken") String SGSessionToken);

        @POST(API_link)
        Call<SavePushTokenResponse> Save_Push_Token(@Body SavePushTokenBody savePushTokenBody, @Header("Sgsessiontoken") String SGSessionToken);

        @POST(API_link)
        Call<MeetingListResponse> getMeetingList(@Body MeetingListBody body, @Header("Sgsessiontoken") String SGSessionToken);

    }

    //    private static final String API_URL = "https://qnuix.com/";/*Medstack*/
//    private static final String API_URL = "http://144.168.164.102:8100/";/*dev*/

//    private static final String API_URL = "http://144.168.162.166:8101";/*demo new*/
//    private static final String API_URL = "http://144.168.162.166:8102";/*QA server*/

    //    private static final String API_URL = "http://144.168.164.102:8103/";/*BETA*/

//    private static final String API_URL = Config.getBaseURl();
    private static final String API_URL = "https://ppe-sgultra-mindemr.speedum.tech";
//    private static final String API_URL = Config.getAPI_BaseURl();
    private static final String API_link = "/";
//    private static final String API_link = "suggestus";
//    private static final String API_link = "https://ppe-sgultra-mindemr.speedum.tech/";
//    private static final String INTERNAL_link = "https://ppe-sgint-mindemr.speedum.tech/";
    private static final String INTERNAL_link = "";
//    private static final String INTERNAL_link = "suggestus/internal";
//    /*private static final String API_link = "suggestusUltraV2/suggestus";
//    private static final String INTERNAL_link = "suggestusUltraV2/suggestus/internal";*/

  /*  private static final String API_link = "suggestusUltra/suggestus";
    private static final String INTERNAL_link = "suggestusUltra/suggestus/internal";*/


    private static APIManager ourInstance = new APIManager();

    public static APIManager getInstance() {
        return ourInstance;
    }

    private APIManager() {
    }


    final static OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(120, TimeUnit.SECONDS).writeTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
//            .sslSocketFactory(Objects.requireNonNull(getSSLSocketFactory()))
            .addInterceptor(new Interceptor() {
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

    private static final APIInterface GIT_HUB_SERVICE = REST_ADAPTER.create(APIInterface.class);

    public static APIInterface getService() {
        return GIT_HUB_SERVICE;
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
}
