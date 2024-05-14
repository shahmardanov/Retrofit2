package com.example.retrofitapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.retrofitapp.databinding.FragmentHomeBinding
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val api = ApiUtils.createApi()
    private val userAdapter = UserAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvHome.adapter = userAdapter
        Picasso.get()
            .load("https://fastly.picsum.photos/id/22/4434/3729.jpg?hmac=fjZdkSMZJNFgsoDh8Qo5zdA_nSGUAWvKLyyqmEt2xs0")
            .into(binding.imageView);
        userAdapter.onClickItem = {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                    it
                )
            )
        }
        getApi()
    }

    fun getApi() {
        binding.progressBar3.visibility = View.VISIBLE
        api.getUser().enqueue(object : Callback<TodoListResponse> {
            override fun onResponse(
                call: Call<TodoListResponse>,
                response: Response<TodoListResponse>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        it.todos?.let { it1 ->
                            binding.progressBar3.visibility = View.GONE
                            userAdapter.updateList(it1)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<TodoListResponse>, t: Throwable) {
                binding.progressBar3.visibility = View.GONE
            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}