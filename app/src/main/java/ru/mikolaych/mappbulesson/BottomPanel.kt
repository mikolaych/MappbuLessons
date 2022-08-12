package ru.mikolaych.mappbulesson

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ru.mikolaych.mappbulesson.databinding.BottomPanelBinding


class BottomPanel : BottomSheetDialogFragment() {   //меняем Fragment на BottomSheetDialogFragment

    private var binding:BottomPanelBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BottomPanelBinding.inflate(inflater, container, false)

        binding?.textContant?.text = arguments?.getString("nameBut")

        binding?.editTextFromView?.setOnClickListener(View.OnClickListener {
            binding?.textContant?.text = "Edited"
        })



        return binding?.root
    }


}