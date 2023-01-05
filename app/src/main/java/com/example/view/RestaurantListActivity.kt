class RestaurantListActivity : AppCompatActivity(), RestaurantListView {

    private lateinit var presenter: RestaurantListPresenter
    private lateinit var adapter: RestaurantAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_list)

        presenter = RestaurantListPresenterImpl(this)
        presenter.getRestaurants()

        adapter = RestaurantAdapter(this, mutableListOf())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                presenter.filterRestaurants(newText ?: "")
                return true
            }
        })
    }


override fun showLoading() {
    progressBar.visibility = View.VISIBLE
}

override fun hideLoading() {
    progressBar.visibility = View.GONE
}

override fun showRestaurants(restaurants: List<Restaurant>) {
    adapter.updateRestaurants(restaurants)
}

override fun showError(error: String) {
    Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
}