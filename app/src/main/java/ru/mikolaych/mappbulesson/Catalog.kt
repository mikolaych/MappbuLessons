package ru.mikolaych.mappbulesson

import android.graphics.drawable.Drawable
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.CompoundButton
import android.widget.RadioGroup
import com.google.android.material.slider.Slider
import ru.mikolaych.mappbulesson.databinding.CatalogBinding

class Catalog : AppCompatActivity(), View.OnClickListener, RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener, View.OnKeyListener {

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
        binding?.check?.setOnCheckedChangeListener(this)
        binding?.check2?.setOnCheckedChangeListener(this)
        binding?.radio?.setOnCheckedChangeListener(this)
        binding?.inputField?.setOnKeyListener(this)

        binding?.slider?.addOnSliderTouchListener(object:Slider.OnSliderTouchListener{
            override fun onStartTrackingTouch(slider: Slider) {
                binding?.sliderField?.text = "Идет выбор"
            }

            override fun onStopTrackingTouch(slider: Slider) {
                binding?.sliderField?.text = "Готово!"
            }


        })
        if (binding?.slider?.value == 1.0f) binding?.catalog?.text = "1  серия"

        binding?.slider?.addOnChangeListener {slider, value, fromuser ->
//            binding?.catalog?.text = "$value  серия"
            when(value){
                1.0f -> binding?.catalog?.text = "1  серия"
                2.0f -> binding?.catalog?.text = "2  серия"
                3.0f -> binding?.catalog?.text = "3  серия"
                4.0f -> binding?.catalog?.text = "4  серия"
                5.0f -> binding?.catalog?.text = "5  серия"
            }

        }



    }

    override fun onClick(view: View?) {

        when(view?.id){
            R.id.editTextFromView -> {click(binding?.editTextFromView?.text, binding?.editTextFromView?.background)}
            R.id.editTextFromView2 -> {click(binding?.editTextFromView2?.text, binding?.editTextFromView2?.background)}
        }
    }

    private fun click(text: CharSequence?, background: Drawable?) {
        val soundClick = MediaPlayer.create(this, R.raw.click)
        soundClick.start()
        binding?.catalog?.text = text
        binding?.catalog?.background = background

    }


    override fun onCheckedChanged(compoundButton: CompoundButton, isChecked: Boolean) {
        if (isChecked){
            binding?.catalog?.text = getString(R.string.check)
        } else binding?.catalog?.text = getString(R.string.app_name)
    }

    override fun onCheckedChanged(radio: RadioGroup, p1: Int) {
        when(p1){
            R.id.radioBox1 -> binding?.catalog?.text = binding?.radioBox1?.text
            R.id.radioBox2 -> binding?.catalog?.text = binding?.radioBox2?.text

        }

    }

    override fun onKey(view: View?, i: Int, keyEvent: KeyEvent): Boolean {
        when(view?.id){
            R.id.inputField -> {
                if (keyEvent.action == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER){
                    binding?.catalog?.text = binding?.inputField?.text
                    binding?.catalog?.setText("")
                    return true
                }
            }
        }
        return false
    }
}