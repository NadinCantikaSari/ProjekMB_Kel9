package com.example.pertemuan3_tia.More

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pertemuan3_tia.R
import com.example.pertemuan3_tia.databinding.FragmentMoreBinding

/**
 * A simple [Fragment] subclass.
 * Use the [MoreFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MoreFragment : Fragment() {

    private var _binding: FragmentMoreBinding? = null
    private val binding get() = _binding!!
    // Data untuk ArrayAdapter (1 teks per baris): nama fasilitas
    private val dataList = listOf(
        "Taman Kota Pekanbaru", "Taman Alam Mayang", "Lapangan Padel",
        "Masjid Raya An-Nur", "Taman Rumah Singgah Tuan Kadi",
        "Stadion Utama Riau", "Perpustakaan Soeman HS", "Taman Cik Puan"
    )

    // Data untuk SimpleAdapter: nama, alamat, dan kategori fasilitas (contoh data, sesuaikan alamat aslinya)
    private val dataListWithDesc = listOf(
        mapOf("title" to "Taman Kota Pekanbaru", "alamat" to "Jl. Gajah Mada, Pekanbaru", "kategori" to "Taman"),
        mapOf("title" to "Taman Alam Mayang", "alamat" to "Jl. Hasanuddin, Pekanbaru", "kategori" to "Taman"),
        mapOf("title" to "Lapangan Padel", "alamat" to "Jl. Riau, Pekanbaru", "kategori" to "Olahraga"),
        mapOf("title" to "Masjid Raya An-Nur", "alamat" to "Jl. Jend. Sudirman, Pekanbaru", "kategori" to "Tempat Ibadah"),
        mapOf("title" to "Taman Rumah Singgah Tuan Kadi", "alamat" to "Pekanbaru", "kategori" to "Taman"),
        mapOf("title" to "Stadion Utama Riau", "alamat" to "Pekanbaru", "kategori" to "Olahraga"),
        mapOf("title" to "Perpustakaan Soeman HS", "alamat" to "Pekanbaru", "kategori" to "Fasilitas Umum"),
        mapOf("title" to "Taman Cik Puan", "alamat" to "Pekanbaru", "kategori" to "Taman")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Daftar Fasilitas"

//        val adapter = ArrayAdapter(
//            requireContext(),
//            android.R.layout.simple_list_item_1,
//            dataList
//        )
//// Hubungkan listViewItems dengan adapter
//        binding.listViewItems.adapter = adapter
//// Aksi saat item diklik
//        binding.listViewItems.setOnItemClickListener { _, _, position, _ ->
//            val selectedItem = dataList[position]
//                Toast.makeText(requireContext(), "Kamu memilih: $selectedItem",
//                Toast.LENGTH_SHORT).show()
//        }

        // SimpleAdapter dengan layout item sendiri (item_facility.xml)
        val adapter = SimpleAdapter(
            requireContext(),
            dataListWithDesc,
            R.layout.item_facility,
            arrayOf("title", "alamat", "kategori"),                 // key yang diambil dari data
            intArrayOf(R.id.tvNama, R.id.tvAlamat, R.id.tvKategori) // tempat tampilnya
        )
        binding.listViewItems.adapter = adapter
        binding.listViewItems.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = dataListWithDesc[position]
            val title = selectedItem["title"]
            val kategori = selectedItem["kategori"]
            Toast.makeText(requireContext(), "Kamu memilih: $title ($kategori)", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
