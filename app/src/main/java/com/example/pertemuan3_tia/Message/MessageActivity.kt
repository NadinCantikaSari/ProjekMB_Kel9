package com.example.pertemuan3_tia.Message

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.pertemuan3_tia.R
import com.example.pertemuan3_tia.databinding.ActivityMessageBinding

class MessageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMessageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMessageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Toolbar dengan tombol back
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Detail Laporan"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        }

        // Data dari Intent
        val sender = intent.getStringExtra("SENDER")
        val message = intent.getStringExtra("MESSAGE")
        val avatar = intent.getStringExtra("AVATAR")
        val time = intent.getStringExtra("TIME")
        val status = intent.getStringExtra("STATUS") ?: "Diproses"

        binding.txtSendername.text = sender
        binding.txtMessage.text = message
        binding.txtTime.text = time
        binding.txtStatus.text = status
        binding.txtStatus.setBackgroundResource(statusBackground(status))
        binding.txtStatus.setTextColor(ContextCompat.getColor(this, statusTextColor(status)))

        Glide.with(this)
            .load(avatar)
            .into(binding.imgAvatar)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
