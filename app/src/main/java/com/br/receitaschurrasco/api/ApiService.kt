package com.br.receitaschurrasco.api



import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object ApiService {

    val alPuntoApi: ALPUNTOApi = getTMDBApiClient().create(ALPUNTOApi::class.java)

    fun getTMDBApiClient(): Retrofit {
        return Retrofit.Builder()
            //.baseUrl(BuildConfig.BASE_URL)
            .baseUrl("https://private-ccbd4-aoponto.apiary-mock.com")
           // .client(getInterceptorClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

//        Failed to connect to localhost/127.0.0.1:1337
    }

//    private fun getInterceptorClient(): OkHttpClient {
//        val loggingInterceptor = HttpLoggingInterceptor()
//        if (BuildConfig.DEBUG) {
//            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
//        }
//
//        val interceptor = OkHttpClient.Builder()
//            .connectTimeout(5, TimeUnit.SECONDS)
//            .readTimeout(10, TimeUnit.SECONDS)
//            .writeTimeout(10, TimeUnit.SECONDS)
//            .addInterceptor(loggingInterceptor)
////            .addInterceptor { chain ->
////                val url = chain.request().url.newBuilder()
////                    .addQueryParameter(QUERY_PARAM_LANGUAGE_KEY, QUERY_PARAM_LANGUAGE_VALUE)
////                    .build()
////                val newRequest = chain.request().newBuilder().url(url).build()
////                chain.proceed(newRequest)
////            }
////            .addInterceptor { chain ->
////                val headers = chain.request().newBuilder()
////                    .addHeader(HEADER_CONTENT_KEY, HEADER_CONTENT_VALUE)
////                    .addHeader(API_TOKEN_KEY, "Bearer $API_TOKEN")
////                val newRequest = headers.build()
////                chain.proceed(newRequest)
////            }
//        return interceptor.build()
//    }
}