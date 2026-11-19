package com.alisia.uts_pbp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val satu = findViewById<EditText>(R.id.etSatu)
        val dua = findViewById<EditText>(R.id.etDua)
        val jumlahView = findViewById<EditText>(R.id.etJumlah)
        val tombol = findViewById<Button>(R.id.btnHitung)

        tombol.setOnClickListener {
            val teksSatu = satu.text.toString().trim()
            val teksDua = dua.text.toString().trim()

            // perbaikan: Konversi input menjadi Int secara aman
            val jumlah: Int? = jumlahView.text.toString().trim().toIntOrNull()

            // penjelasan: Memeriksa nama peserta
            if (teksSatu.isEmpty()) {
                Toast.makeText(this, "Nama peserta harus diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // penjelasan: Memeriksa nama event
            if (teksDua.isEmpty()) {
                Toast.makeText(this, "Nama event harus diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // penjelasan: Memeriksa input jumlah tiket
            if (jumlah == null) {
                Toast.makeText(this, "Jumlah tiket harus berupa angka", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // penjelasan: Jumlah tiket harus 1 sampai 10
            if (jumlah !in 1..10) {
                Toast.makeText(this, "Jumlah tiket harus 1 sampai 10", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // penjelasan: Menghitung total harga tiket
            val tarif: Int = 75000
            val total: Int = jumlah * tarif

            // Penjelasan: Mengirim data ke halaman hasil
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("nama_peserta", teksSatu)
            intent.putExtra("nama_event", teksDua)
            intent.putExtra("jumlah_tiket", jumlah)
            intent.putExtra("total_harga", total)

            startActivity(intent)
        }
    }
}