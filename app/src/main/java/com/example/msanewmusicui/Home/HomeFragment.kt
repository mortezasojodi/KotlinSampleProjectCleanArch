package com.example.msanewmusicui.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.msanewmusicui.R
import org.koin.dsl.module
class HomeFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ):View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        view.findViewById<TextView>(R.id.textHome).setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_myHomeFragment_to_mySecondFragment)
        });
    }
}
//val appModule = module {
//    single<UserRepository> { UserRepositoryImpl() }
//}