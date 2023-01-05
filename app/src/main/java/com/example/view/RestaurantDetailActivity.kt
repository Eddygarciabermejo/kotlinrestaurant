
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.pruebakotlinedgar.R
import com.example.view.*


class RestaurantDetailActivity : AppCompatActivity(), RestaurantDetailView {
    private lateinit var presenter: RestaurantDetailPresenter
    private lateinit var progressBar: ProgressBar
    private lateinit var searchView: SearchView
    val name1TextView = findViewById<TextView>(R.id.nameTextView)
    val addressTextView = findViewById<TextView>(R.id.addressTextView)
    val imageView = findViewById<ImageView>(R.id.imageView)

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_detail)
        searchView = findViewById(R.id.searchView)
        val id = intent.getIntExtra("id", 0)
        presenter = RestaurantDetailPresenterImpl(this)
        presenter.getRestaurant(id)
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun showRestaurant(restaurant: Restaurant) {
        name1TextView.text = restaurant.name
        addressTextView.text = restaurant.address
        Glide.with(this).load(restaurant.imageUrl).into(imageView)
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

}