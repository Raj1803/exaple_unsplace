package com.example.example_bipolar_factory;



import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UnsplashClient {

    private static Retrofit retrofit = null;
    public static Retrofit getUnsplashClient() {
        if (retrofit == null) {
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(new HeaderInterceptor(Config.unsplace_access_key)).build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(Config.BASE_URL_UNSPLACE)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
