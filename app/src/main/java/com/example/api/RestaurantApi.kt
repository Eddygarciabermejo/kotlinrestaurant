interface RestaurantApi {
    @GET("restaurant")
    fun getRestaurants(): Call<List<Restaurant>>

    @GET("restaurant/{id}")
    fun getRestaurant(@Path("id") id: String): Call<Restaurant>
}