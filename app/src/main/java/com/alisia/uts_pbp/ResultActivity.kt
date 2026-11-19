package com.alisia.uts_pbp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // Menghubungkan TextView dengan komponen di XML
        val ringkasan = findViewById<TextView>(R.id.tvRingkasan)
        val totalView = findViewById<TextView>(R.id.tvTotal)

        // Mengambil data yang dikirim dari MainActivity
        val satu: String = intent.getStringExtra("nama_peserta") ?: ""
        val dua: String = intent.getStringExtra("nama_event") ?: ""
        val jumlah: Int = intent.getIntExtra("jumlah_tiket", 0)
        val total: Int = intent.getIntExtra("total_harga", 0)

        // Menampilkan ringkasan data pendaftaran
        ringkasan.text = "Nama Peserta: $satu\nNama Event: $dua\nJumlah Tiket: $jumlah"

        // Mengubah format angka menjadi format rupiah
        val totalRupiah = "Rp" + "%,d".format(total).replace(",", ".")

        // Menampilkan total harga
        totalView.text = "Total Harga: $totalRupiah"
    }
}