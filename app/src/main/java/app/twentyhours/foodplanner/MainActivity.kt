package app.twentyhours.foodplanner

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        this.findViewById<Button>(R.id.home_setting_button).setOnClickListener {
            Toast.makeText(this, "Setting button clicked", Toast.LENGTH_SHORT).show()
        }

        this.findViewById<ImageView>(R.id.home_profile_image_view).setOnClickListener {
            Toast.makeText(this, "Profile image clicked", Toast.LENGTH_SHORT).show()
        }

        val dataset = arrayOf(
            R.drawable.beef,
            R.drawable.chicken,
            R.drawable.shrimp,
            R.drawable.fish,
            R.drawable.beef,
            R.drawable.chicken,
            R.drawable.shrimp,
            R.drawable.fish
        )
        val customAdapter = CustomAdapter(dataset)

        val recyclerView:
                RecyclerView = findViewById(R.id.home_ingredient_recycler_view)
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = customAdapter
    }
}