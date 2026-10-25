package com.example.pertemuan3_tia.Message

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.pertemuan3_tia.databinding.ItemMessageBinding

class MessageAdapter(
    context: Context,
    private val messages: List<MessageModel>
) : ArrayAdapter<MessageModel>(context, 0, messages) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ItemMessageBinding.inflate(LayoutInflater.from(context), parent, false)
        val view = binding.root
        val data = messages[position]

        // Muat gambar dari URL ke ImageView
        Glide.with(context)
            .load(data.avatarUrl)
            .into(binding.avatarImg)

        binding.textSender.text = data.senderName
        binding.textMessage.text = data.messageText
        binding.textTime.text = data.time

        // Chip status: warna berbeda untuk Diproses dan Selesai
        binding.textStatus.text = data.status
        binding.textStatus.setBackgroundResource(statusBackground(data.status))
        binding.textStatus.setTextColor(ContextCompat.getColor(context, statusTextColor(data.status)))

        // Klik laporan: buka halaman detail laporan (Latihan 5.4)
        view.setOnClickListener {
            val i = Intent(context, MessageActivity::class.java)
            i.putExtra("SENDER", data.senderName)
            i.putExtra("MESSAGE", data.messageText)
            i.putExtra("AVATAR", data.avatarUrl)
            i.putExtra("TIME", data.time)
            i.putExtra("STATUS", data.status)
            context.startActivity(i)
        }
        return view
    }
}
