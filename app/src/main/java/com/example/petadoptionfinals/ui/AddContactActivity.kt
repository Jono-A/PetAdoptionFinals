package com.example.petadoptionfinals.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.petadoptionfinals.databinding.ActivityAddContactBinding
import com.example.petadoptionfinals.databinding.ToolbarTitleBinding
import java.io.File
import java.io.FileWriter

class AddContactActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAddContactBinding
    private lateinit var toolbarBinding : ToolbarTitleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddContactBinding.inflate(layoutInflater)
        toolbarBinding = ToolbarTitleBinding.bind(binding.root)

        setContentView(binding.root)

        binding.addContact.setOnClickListener {
            if (addContact()) {
                writeData()
                startActivity(Intent(this@AddContactActivity, MainActivity::class.java))
            }
        }
    }


    private fun inputRequirements(name: String, email: String, phone: String): Boolean {
        if (name.isEmpty()) {
            binding.inName.error = "Input missing"
            return false
        }

        if (email.isEmpty()) {
            binding.inEmail.error = "Input missing"
            return false
        }

        if (phone.isEmpty()) {
            binding.inPhone.error = "Input missing"
            return false
        }

        return true
    }

    private fun addContact(): Boolean {
        val name = binding.inName.text.toString()
        val email = binding.inEmail.text.toString()
        val phone = binding.inPhone.text.toString()

        if (!inputRequirements(name, email, phone)) {
            return false
        }

        return true
    }

    private fun writeData() {
        val path: File = this.filesDir
        val file: File = File(path, "datafile.txt")
        val stream: FileWriter = FileWriter(file, true)
        try {
            stream.write("${binding.inName.text}, ${binding.inEmail.text}, ${binding.inPhone.text}\n")

        } catch (e: Exception) {

        } finally {
            stream.close()
        }
    }
}
