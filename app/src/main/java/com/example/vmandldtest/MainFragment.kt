package com.example.vmandldtest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.vmandldtest.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var binding: FragmentMainBinding? = null

    private lateinit var adapter: UserAdapter

    private lateinit var recyclerView: RecyclerView

    private lateinit var userViewModel: MainFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater,container,false)
        recyclerView = binding?.listOfNames!!
        adapter = UserAdapter()
        recyclerView.adapter = adapter
        userViewModel = ViewModelProvider(this).get(MainFragmentViewModel::class.java)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var name = binding?.editName?.text.toString()
        var surname = binding?.editSurname?.text.toString()
        binding?.addBtn?.setOnClickListener {
            userViewModel.populateList(name, surname)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}