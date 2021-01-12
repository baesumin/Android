package org.techtown.datatransfer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_first.*

class SecondFragment : Fragment(R.layout.fragment_second) {
    //val mainViewModel by activityViewModels<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener("firstToSecond"){resultKey, bundle ->
            val data = bundle.getString("data","")
            Toast.makeText(requireContext(), data, Toast.LENGTH_LONG).show()
        }

        //Toast.makeText(requireContext(), mainViewModel.data, Toast.LENGTH_LONG).show()

        button.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
        }
    }
}