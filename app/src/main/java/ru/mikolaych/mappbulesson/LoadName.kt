package ru.mikolaych.mappbulesson

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ru.mikolaych.mappbulesson.databinding.LoadNameBinding


class LoadName : Fragment() {

    private var binding:LoadNameBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = LoadNameBinding.inflate(inflater,  container, false)

        //Изменение текста
        binding?.editTextFromView?.setOnClickListener(View.OnClickListener {
            binding?.textContant?.text = "Edited"
        })
         return binding?.root

    }

}