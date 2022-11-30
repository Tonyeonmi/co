 package com.example.mycoroutineapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.mycoroutineapplication.databinding.FragmentPostBinding


 /**
 * A simple [Fragment] subclass.
 * Use the [PostFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PostFragment : Fragment() {

    var binding: FragmentPostBinding? = null
    val viewModel : PostViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding?.root
    }

     override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
         super.onViewCreated(view, savedInstanceState)

         viewModel.numPosts.observe(viewLifecycleOwner) {
             binding?.txtNumPosts?.text = it.toString()
         }
         binding?.btnRetrieve?.setOnClickListener {
            viewModel.retrievePosts()
         }
     }

}