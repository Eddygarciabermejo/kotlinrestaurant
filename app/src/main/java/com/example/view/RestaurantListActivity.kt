
package com.example.view
import Restaurant
import RestaurantAdapter
import RestaurantListPresenter
import RestaurantListPresenterImpl
import RestaurantListView
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.ProgressBar
import android.widget.SearchView
import android.widget.Toast
import android.os.Bundle

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pruebakotlinedgar.R
import androidx.recyclerview.widget.RecyclerView


class RestaurantListActivity() : AppCompatActivity(), RestaurantListView {

    private lateinit var presenter: RestaurantListPresenter
    private lateinit var adapter: RestaurantAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_list)

        searchView = findViewById(R.id.searchView)
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
