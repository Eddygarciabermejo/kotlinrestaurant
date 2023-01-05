interface RestaurantListPresenter {
    fun getRestaurants()
    fun filterRestaurants(query: String)
    abstract fun getRestaurant(id: Int)
}

class RestaurantListPresenterImpl(private val view: RestaurantListView) : RestaurantListPresenter {

    override fun getRestaurants() {
        // Aquí se debería realizar la llamada a la API para obtener la lista de restaurantes
        // Una vez que se tienen los datos, se debe llamar a view.showRestaurants(restaurants)
        // para mostrar los restaurantes en la vista
    }

    override fun filterRestaurants(query: String) {
        // Aquí se debería filtrar la lista de restaurantes según la búsqueda realizada
        // Una vez que se tiene la lista filtrada, se debe llamar a view.showRestaurants(filteredRestaurants)
        // para mostrar los restaurantes filtrados en la vista
    }

    override fun getRestaurant(id: Int) {
        TODO("Not yet implemented")
    }

}