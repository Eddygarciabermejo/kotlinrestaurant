
package com.example.api
import RestaurantApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiClient {
    companion object {
        private const val BASE_URL = "http://demo2066522.mockable.io"
        private var retrofit: Retrofit? = null

        fun getClient(): RestaurantApi {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }

            return retrofit!!.create(RestaurantApi::class.java)
        }
    }
}