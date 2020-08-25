package com.wrecked.byme.profil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnSave.setOnClickListener{ validasiInput() }
        setDataSpinnerGender()


    }
    private fun setDataSpinnerGender() {
        val adapter = ArrayAdapter.createFromResource(this,R.array.gender_list, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerGender.adapter = adapter
    }
    private fun validasiInput(){
        val namaInput = edtName.text.toString()
        val emailInput = edtEmail.text.toString()
        val telpInput = edtTelp.text.toString()
        val alamatInput = edtAddress.text.toString()
        val genderInput = spinnerGender.selectedItem.toString()

        when{
            namaInput.isEmpty() -> edtName.error= "Nama tidak poleh kosong"
            genderInput.equals("Pilih Kelamin") -> Toast.makeText(this,"Kelamin Harus Dipilih", Toast.LENGTH_SHORT).show()
            emailInput.isEmpty() -> edtEmail.error = "Email tidak boleh kosong"
            telpInput.isEmpty() -> edtTelp.error = "Telepon tidak boleh kosng"
            alamatInput.isEmpty() -> edtAddress.error = "Alamat tidak bboleh kosong"

            else -> {
                Toast.makeText(this, "Navigasi ke halaman profil diri", Toast.LENGTH_SHORT).show()
                navigasiKeProfilDiri()
            }
        }
    }
    private fun navigasiKeProfilDiri() {
        val intent = Intent(this, MyProfileActivity::class.java)
        val bundle = Bundle()

        val namaInput = edtName.text.toString()
        val emailInput= edtEmail.text.toString()
        val genderInput = spinnerGender.selectedItem.toString()
        val telpInput = edtTelp.text.toString()
        val alamatInput = edtAddress.text.toString()

        bundle.putString("nama", namaInput)
        bundle.putString("gender", genderInput)
        bundle.putString("email",emailInput)
        bundle.putString("telp",telpInput)
        bundle.putString("alamat",alamatInput)

        intent.putExtras(bundle)
         startActivity(intent)

    }
}
