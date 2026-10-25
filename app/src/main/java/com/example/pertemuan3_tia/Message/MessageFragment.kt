package com.example.pertemuan3_tia.Message

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.pertemuan3_tia.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {

    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!
    // Foto contoh dari picsum.photos (ganti dengan foto laporan asli kalau sudah ada)
    private val messageList = listOf(
        MessageModel("Kerusakan Lampu Taman", "Taman Kota Pekanbaru", "https://picsum.photos/seed/laporan1/200", "12 Okt 2025 • 11.24", "Diproses"),
        MessageModel("Sampah Berserakan", "Taman Alam Mayang", "https://picsum.photos/seed/laporan2/200", "10 Okt 2025 • 15.30", "Selesai"),
        MessageModel("Bangku Rusak", "Taman Kota Pekanbaru", "https://picsum.photos/seed/laporan3/200", "8 Okt 2025 • 09.12", "Diproses"),
        MessageModel("Jalur Rusak", "Lapangan Padel", "https://picsum.photos/seed/laporan4/200", "5 Okt 2025 • 16.48", "Selesai"),
        MessageModel("Toilet Kurang Bersih", "Masjid Raya An-Nur", "https://picsum.photos/seed/laporan5/200", "3 Okt 2025 • 13.05", "Selesai"),
        MessageModel("Pagar Taman Patah", "Taman Alam Mayang", "https://picsum.photos/seed/laporan6/200", "1 Okt 2025 • 10.40", "Diproses"),
        MessageModel("Keran Air Rusak", "Masjid Raya An-Nur", "https://picsum.photos/seed/laporan7/200", "28 Sep 2025 • 08.15", "Selesai"),
        MessageModel("Genangan Air", "Lapangan Padel", "https://picsum.photos/seed/laporan8/200", "25 Sep 2025 • 17.20", "Diproses"),
        MessageModel("Tempat Sampah Penuh", "Taman Kota Pekanbaru", "https://picsum.photos/seed/laporan9/200", "22 Sep 2025 • 07.50", "Selesai"),
        MessageModel("Cat Pagar Mengelupas", "Taman Alam Mayang", "https://picsum.photos/seed/laporan10/200", "20 Sep 2025 • 14.35", "Diproses")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Riwayat Laporan"

        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItems.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
