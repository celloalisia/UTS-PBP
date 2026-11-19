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

        // Ketika tombol diklik
        tombol.setOnClickListener {
            val teksSatu = satu.text.toString().trim()
            val teksDua = dua.text.toString().trim()

            // Mengubah input jumlah menjadi angka
            val jumlah: Int? = jumlahView.text.toString().trim().toIntOrNull()

            // Memeriksa nama peserta
            if (teksSatu.isEmpty()) {
                satu.error = "Nama peserta harus diisi"
                return@setOnClickListener
            }

            // Memeriksa nama event
            if (teksDua.isEmpty()) {
                dua.error = "Nama event harus diisi"
                return@setOnClickListener
            }

            // Memeriksa jumlah tiket
            if (jumlah == null) {
                jumlahView.error = "Jumlah tiket harus berupa angka"
                return@setOnClickListener
            }

            // Memeriksa batas jumlah tiket
            if (jumlah !in 1..10) {
                jumlahView.error = "Jumlah tiket harus 1 sampai 10"
                return@setOnClickListener
            }

            // Menghitung total harga tiket
            val tarif: Int = 75000
            val total: Int = jumlah * tarif

            // Mengirim data ke halaman hasil
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("nama_peserta", teksSatu)
            intent.putExtra("nama_event", teksDua)
            intent.putExtra("jumlah_tiket", jumlah)
            intent.putExtra("total_harga", total)

            startActivity(intent)
        }
    }
}
