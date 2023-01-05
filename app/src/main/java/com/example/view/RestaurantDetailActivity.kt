import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.api.*
import com.example.view.*
import kotlinx.android.synthetic.main.activity_restaurant_detail.*

class RestaurantDetailActivity : AppCompatActivity(), RestaurantDetailView {

    private lateinit var presenter: RestaurantDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_detail)

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
        nameTextView.text = restaurant.name
        addressTextView.text = restaurant.address
        Glide.with(this).load(restaurant.imageUrl).into(imageView)
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }
}