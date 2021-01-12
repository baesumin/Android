package org.techtown.datatransfer

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.os.bundleOf
import androidx.fragment.app.*
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment(R.layout.fragment_first) {
    //val mainViewModel by activityViewModels<MainViewModel>()
    val getContent = registerForActivityResult(ActivityResultContracts.GetContent()){
        imageView.setImageURI(it)
    }

    val getStartActivityForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){activityResult ->
        activityResult.data?.let {intent ->
            intent.extras?.let{bundle ->
                Log.d("FirstFragment", "result: ${bundle
                    .getString("data","world")}")
            }

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        button.setOnClickListener {
//            //mainViewModel.data = "hello"
//            setFragmentResult("firstToSecond", bundleOf("data" to "hello"))
//            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
//        }



        button.setOnClickListener {
            //MIME TYPE
            //getContent.launch("image/*")
            Intent(requireContext(), ResultActivity::class.java).apply {
                getStartActivityForResult.launch(this)
            }

        }
    }

}