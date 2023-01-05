

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pruebakotlinedgar.R


class RestaurantAdapter(
    private val context: Context,
    private var restaurants: MutableList<Restaurant>
) : RecyclerView.Adapter<RestaurantAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_restaurant, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return restaurants.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val restaurant = restaurants[position]
        holder.bind(restaurant)
    }

    fun updateRestaurants(newRestaurants: List<Restaurant>) {
        restaurants.clear()
        restaurants.addAll(newRestaurants)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(restaurant: Restaurant) {
            // Asigna los valores de cada restaurante a los elementos de la vista
        }
    }
}
