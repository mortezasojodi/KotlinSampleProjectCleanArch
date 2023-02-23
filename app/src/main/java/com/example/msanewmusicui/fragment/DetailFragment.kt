package com.example.msanewmusicui.fragment

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.msanewmusicui.R
import com.example.msanewmusicui.core.domain.model.Anime
import com.example.msanewmusicui.databinding.ActivityDetailAnimeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailFragment: Fragment() {
    private lateinit var binding: ActivityDetailAnimeBinding
    private val args : DetailFragmentArgs by navArgs()
    private lateinit var mAnime: Anime
    private var statusFavorite: Boolean = false
    private val detailViewModel: DetailAnimeViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ):View? {
        binding = DataBindingUtil.setContentView(this.activity!!, R.layout.activity_detail_anime)
        mAnime = args.anime;
        with(binding) {
            activity = this@DetailFragment
            lifecycleOwner = this@DetailFragment
            anime = mAnime
            fab.setOnClickListener { fabListener() }
        }
        return inflater.inflate(R.layout.activity_detail_anime, container, false)
    }
    fun playTrailer(id: String) {
        val appIntent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:$id"))
        val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=$id"))

        try {
            startActivity(appIntent)
        } catch (ex: ActivityNotFoundException) {
            startActivity(webIntent)
        }
    }
    private fun fabListener() {
        statusFavorite = !statusFavorite
        detailViewModel.setFavoriteAnime(mAnime, statusFavorite)
        setStatusFavorite(statusFavorite)
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(
                ContextCompat.getDrawable(
                    this.context!!,
                    R.drawable.ic_favorite_white
                )
            )
        } else {
            binding.fab.setImageDrawable(
                ContextCompat.getDrawable(
                    this.context!!,
                    R.drawable.ic_not_favorite_white
                )
            )
        }
    }
}