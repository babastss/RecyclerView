package com.bastian.recyclerview

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bastian.recyclerview.adapter.AdapterTeamBola
import com.bastian.recyclerview.databinding.ActivityMainBinding
import com.bastian.recyclerview.model.Pemain

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listPemain = ArrayList<Pemain>()
        listPemain.add(Pemain("Hendika Arga",R.drawable.arga,"Gelandang Serang","1.72 m","Brebes (Indonesia)","1 November 1993"))
        listPemain.add(Pemain("Soni Setiawan",R.drawable.soni,"Bek Kanan","1.75 m","Tegal (Indonesia)","10 April 1993 "))
        listPemain.add(Pemain("Wisnu Nugroho",R.drawable.wisnu,"Penyerang Tengah","1.76 m","Tegal (Indonesia)","26 November 1996"))
        listPemain.add(Pemain("Yoga Pratama",R.drawable.yoga,"Penyerang Sayap Kiri","1.75 m","Kebumen (Indonesia)","13 Maret 1998"))

        binding.list.adapter = AdapterTeamBola(this,listPemain,object : AdapterTeamBola.OnClickListener {
            override fun detailData(item: Pemain?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_pemain)

                    val Image = this.findViewById<ImageView>(R.id.image_pemain)
                    val nama = this.findViewById<TextView>(R.id.txtNamaPemain)

                    val posisi = this.findViewById<TextView>(R.id.txtPosisi)
                    val tinggi = this.findViewById<TextView>(R.id.txtTinggi)
                    val tempatlahir = this.findViewById<TextView>(R.id.txtTempatLahir)
                    val tgllahir = this.findViewById<TextView>(R.id.txtTanggalLahir)
                    val btn = this.findViewById<Button>(R.id.btnClose)

                    Image.setImageResource(item?.foto ?:0)
                    nama.text = "${item?.nama}"
                    posisi.text = "${item?.posisi}"
                    tinggi.text = "${item?.tinggi}"
                    tempatlahir.text = "${item?.tempatlahir}"
                    tgllahir.text = "${item?.tgllahir}"

                    btn.setOnClickListener {
                        this.dismiss()
                    }
                }.show()
            }

        })

    }
}