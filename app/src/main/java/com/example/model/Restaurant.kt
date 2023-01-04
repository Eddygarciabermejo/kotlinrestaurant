class RestaurantService {
    private val api: RestaurantApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://demo2066522.mockable.io/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        api = retrofit.create(RestaurantApi::class.java)
    }

    fun getApi(): RestaurantApi {
        return api
    }
}