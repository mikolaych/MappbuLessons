package ru.mikolaych.mappbulesson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ru.mikolaych.mappbulesson.databinding.CatalogBinding

class Catalog : AppCompatActivity() {
    private var binding:CatalogBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CatalogBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        //Получение данных из майнактивити
        binding?.catalog?.text = intent.getStringExtra("nameBut")

        //Изменение текста
        binding?.editTextFromView?.setOnClickListener(View.OnClickListener {
            binding?.catalog?.text = "Edited"
        })



    }
}