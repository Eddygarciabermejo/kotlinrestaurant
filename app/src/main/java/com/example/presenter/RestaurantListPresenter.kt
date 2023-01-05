interface RestaurantListPresenter {
    fun getRestaurants()
    fun filterRestaurants(query: String)
}