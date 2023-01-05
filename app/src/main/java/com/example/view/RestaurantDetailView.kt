interface RestaurantDetailView {
    abstract val nameTextView: Any

    fun showLoading()
    fun hideLoading()
    fun showRestaurant(restaurant: Restaurant)
    fun showError(error: String)
    abstract fun RestaurantDetailPresenterImpl(restaurantDetailActivity: RestaurantDetailActivity): RestaurantDetailPresenter
    abstract fun findViewById(searchView: Int): Any
    abstract fun setContentView(activityRestaurantDetail: Int)
}