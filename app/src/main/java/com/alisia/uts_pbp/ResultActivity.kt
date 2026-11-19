package com.alisia.uts_pbp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val ringkasan = findViewById<TextView>(R.id.tvRingkasan)
        val totalView = findViewById<TextView>(R.id.tvTotal)

        val satu: String = intent.getStringExtra("nama_peserta") ?: ""
        val dua: String = intent.getStringExtra("nama_event") ?: ""
        val jumlah: Int = intent.getIntExtra("jumlah_tiket", 0)
        val total: Int = intent.getIntExtra("total_harga", 0)

        ringkasan.text = "Nama Peserta: $satu\nNama Event: $dua\nJumlah Tiket: $jumlah"
        val totalRupiah = "Rp" + "%,d".format(total).replace(",", ".")

        totalView.text = "Total Harga: $totalRupiah"
    }
}
