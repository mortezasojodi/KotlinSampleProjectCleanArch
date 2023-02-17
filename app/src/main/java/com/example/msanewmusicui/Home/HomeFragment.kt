package com.example.msanewmusicui.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.msanewmusicui.R
import com.example.msanewmusicui.core.data.Resource
import com.example.msanewmusicui.core.domain.model.Anime
import com.example.msanewmusicui.core.ui.AnimeAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.view_error.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.dsl.module
import timber.log.Timber

class HomeFragment: Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()
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

        if (activity != null) {
            val animeAdapter = AnimeAdapter { item -> showDetail(item) }

            homeViewModel.anime.observe(viewLifecycleOwner, { anime ->
                if (anime != null) {
                    when (anime) {
                        is Resource.Loading -> progress_bar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            progress_bar.visibility = View.GONE
                            animeAdapter.setData(anime.data)
                        }
                        is Resource.Error -> {
                            progress_bar.visibility = View.GONE
                            view_error.visibility = View.VISIBLE
                            tv_error.text = anime.message ?: getString(R.string.something_wrong)
                        }
                    }
                }
            })

            with(rv_anime) {
                layoutManager = GridLayoutManager(requireContext(), 2)
                setHasFixedSize(true)
                adapter = animeAdapter
            }
        }
//        view.findViewById<TextView>(R.id.textHome).setOnClickListener(View.OnClickListener {
//            findNavController().navigate(R.id.action_myHomeFragment_to_mySecondFragment)
//        });
    }
    private fun showDetail(anime: Anime) {
        Timber.d("OnClick : ${anime.canonicalTitle}")
        this.findNavController()
            .navigate(HomeFragmentDirections.actionMyHomeFragmentToMySecondFragment(anime))
    }
}
//val appModule = module {
//    single<UserRepository> { UserRepositoryImpl() }
//}