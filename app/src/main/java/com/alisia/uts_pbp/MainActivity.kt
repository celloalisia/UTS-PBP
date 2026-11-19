package com.alisia.uts_pbp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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

            // PERBAIKAN: Konversi input menjadi Int secara aman
            val jumlah: Int = jumlahView.text.toString().trim().toInt()

            // PENJELASAN: Validasi nama peserta dan nama event
            if (teksSatu.isEmpty()) {
                satu.error = "Nama peserta harus diisi"
                return@setOnClickListener
            }

            if (teksDua.isEmpty()) {
                dua.error = "Nama event harus diisi"
                return@setOnClickListener
            }

            // Penjelasan : Validasi input angka
            if (jumlah == null) {
                jumlahView.error = "Masukkan jumlah tiket yang valid"
                return@setOnClickListener
            }

            // Penjelasan : Jumlah tiket harus 1 sampai 10
            if (jumlah !in 1..10) {
                jumlahView.error = "Jumlah tiket harus 1-10"
                return@setOnClickListener
            }

            val tarif: Int = 75000
            val total: Int = jumlah * tarif // Perbaikan : Menghitung total menggunakan perkalian Int
            val intent = Intent(this, ResultActivity::class.java) // Penjelasan : Membuat Explicit Intent ke ResultActivity

            // Penjelasan: Mengirim data String dan Int menggunakan putExtra
            intent.putExtra("nama_peserta", teksSatu)
            intent.putExtra("nama_event", teksDua)
            intent.putExtra("jumlah_tiket", jumlah)
            intent.putExtra("total_harga", total)

            // Untuk Membuka halaman hasil
            startActivity(intent)
        }
    }
}


