package ru.mikolaych.mappbulesson

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import ru.mikolaych.mappbulesson.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding:ActivityMainBinding? = null  //Подключение байндинг

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val clickVaw = MediaPlayer.create(this, R.raw.click)

        //Загрузка фрагмента

        binding?.fragmentLoad?.setOnClickListener(View.OnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.content, LoadName()).commit()
            binding?.fragmentLoad?.visibility = View.GONE
        })

        //Загрузка активити
        binding?.activityLoad?.setOnClickListener(View.OnClickListener {
            val startCatalogActivity = Intent(this, Catalog::class.java)

            //Передача данных(текст кнопки)
            startCatalogActivity.putExtra("nameBut", binding?.activityLoad?.text)

            startActivity(startCatalogActivity)

        })

        //Выезжающая панель
        binding?.panel?.setOnClickListener(View.OnClickListener {
            val panel = BottomPanel()
            clickVaw.start()
            //Передача параметров
            val parameters = Bundle()
            parameters.putCharSequence("nameBut", binding?.panel?.text)
            panel.arguments = parameters
            panel.show(supportFragmentManager, "panel")

        })







    }
}