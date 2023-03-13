package com.example.kdo.ui.articleview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.kdo.R
import com.example.kdo.databinding.FragmentArticleEditBinding
import com.google.android.material.snackbar.Snackbar

class ArticleAddEditFragment : Fragment() {

    val args by navArgs<ArticleAddEditFragmentArgs>()
    lateinit var binding: FragmentArticleEditBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArticleEditBinding.inflate (
            inflater,
            container,
            false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.article = args.article
        Snackbar.make(view,args.article.toString(),Snackbar.LENGTH_LONG).show()
    }


}
