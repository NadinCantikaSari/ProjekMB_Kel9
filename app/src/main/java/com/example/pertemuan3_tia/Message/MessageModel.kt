package com.example.pertemuan3_tia.Message

import com.example.pertemuan3_tia.R

// Satu item riwayat laporan:
// senderName = judul laporan, messageText = lokasi, avatarUrl = foto laporan,
// time = tanggal & jam laporan, status = "Diproses" atau "Selesai"
data class MessageModel(
    val senderName: String,
    val messageText: String,
    val avatarUrl: String,
    val time: String,
    val status: String
)

// Warna chip status (dipakai di daftar dan halaman detail)
fun statusBackground(status: String): Int =
    if (status == "Selesai") R.drawable.bg_status_selesai else R.drawable.bg_status_proses

fun statusTextColor(status: String): Int =
    if (status == "Selesai") R.color.status_selesai_text else R.color.status_proses_text
