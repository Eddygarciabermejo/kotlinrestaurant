interface RestaurantDetailView {
    fun showLoading()
    fun hideLoading()
    fun showRestaurant(restaurant: Restaurant)
    fun showError(error: String)
}