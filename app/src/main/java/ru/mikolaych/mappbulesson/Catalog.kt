package ru.mikolaych.mappbulesson

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ru.mikolaych.mappbulesson.databinding.CatalogBinding

class Catalog : AppCompatActivity(), View.OnClickListener {
    private var binding:CatalogBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CatalogBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        //Получение данных из майнактивити
        binding?.catalog?.text = intent.getStringExtra("nameBut")

        //Изменение текста


        binding?.editTextFromView?.setOnClickListener(this)
        binding?.editTextFromView2?.setOnClickListener(this)



    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.editTextFromView -> {click(binding?.editTextFromView?.text, binding?.editTextFromView?.background)}
            R.id.editTextFromView2 -> {click(binding?.editTextFromView2?.text, binding?.editTextFromView2?.background)}
        }
    }

    private fun click(text: CharSequence?, background: Drawable?) {
        binding?.catalog?.text = text
        binding?.catalog?.background = background

    }
}