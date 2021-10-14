package com.supiarti.tugas3

import android.graphics.Color

class MainActivity : AppCompatActivity() {
    companion object {
        const val REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_simple_intent = findViewById<Button>(R.id.btn_simple_intent)
        val btn_intent_with_data = findViewById<Button>(R.id.btn_intent_with_data)
        val btn_intent_parcelable = findViewById<Button>(R.id.btn_intent_parcelable)
        val btn_implicit_intent = findViewById<Button>(R.id.btn_implicit_intent)
        val btn_intent_result = findViewById<Button>(R.id.btn_intent_result)

        btn_simple_intent.setOnClickListener {
            val simpleIntent = Intent(this@MainActivity, SimpleActivity::class.java)
            startActivity(simpleIntent)
        }

        btn_intent_with_data.setOnClickListener {
            val dataIntent = Intent(this@MainActivity, ExplicitIntentActivity::class.java)
            dataIntent.putExtra(ExplicitIntentActivity.EXTRA_NAME, "Supiarti")
            dataIntent.putExtra(ExplicitIntentActivity.EXTRA_EMAIL, "ranticantik365@gmail.com")
            dataIntent.putExtra(ExplicitIntentActivity.EXTRA_UMUR, "19 tahun")
            startActivity(dataIntent)
        }

        btn_intent_parcelable.setOnClickListener {
            val parcleIntent = Intent(this@MainActivity, ParcleActivity::class.java)
            val user = User("Supiarti", "ranticantik365@gmail.com", "19 Tahun")
            parcleIntent.putExtra(ParcleActivity.EXTRA_USER, user)
            startActivity(parcleIntent)
        }

        btn_implicit_intent.setOnClickListener {
            val phoneNumber = "0895322316876"
            val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:$phoneNumber"))
            intent.putExtra("sms_body", "Hallo Rantiii")
            startActivity(intent)
        }

        btn_intent_result.setOnClickListener {
            val intent = Intent(this@MainActivity, ResultActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == 200) {
            val color = data?.getStringExtra(ResultActivity.EXTRA_COLOR)
            view_result.setBackgroundColor(Color.parseColor(color))
        }
    }
}



import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.supiarti.tugas3.model.User
import kotlinx.android.synthetic.main.activity_explicit_intent.*
import kotlinx.android.synthetic.main.activity_main.*

