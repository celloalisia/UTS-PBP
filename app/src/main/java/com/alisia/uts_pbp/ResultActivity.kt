package com.alisia.uts_pbp.

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.alisia.uts_pbp.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val ringkasan = findViewById<TextView>(R.id.tvRingkasan)
        val totalView = findViewById<TextView>(R.id.tvTotal)
        val satu: String = "Nama Peserta :"
        val dua: String = "Nama Event :" // TODO-12: terima String kedua
        val jumlah: (getInt: Int ) =  // TODO-13: terima Int (bukan getStringExtra)
        val total: Int = jumlah * 75000 // TODO-14: terima Int total
        // TODO-15: tampilkan String dan jumlah pada ringkasan
        // TODO-16: tampilkan total (konversi Int ke teks hanya di UI)
    }
}