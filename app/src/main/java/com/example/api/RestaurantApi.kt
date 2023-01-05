
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Call


interface RestaurantApi {
    @GET("/restaurant")
    fun getRestaurants(): Call<List<Restaurant>>

    @GET("/restaurant/{id}")
    fun getRestaurant(@Path("id") id: Int): Call<Restaurant>
}