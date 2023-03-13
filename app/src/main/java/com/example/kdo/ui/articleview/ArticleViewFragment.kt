package com.example.kdo.ui.articleview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.kdo.bo.Article
import com.example.kdo.databinding.FragmentArticleViewBinding
import com.example.kdo.repository.ArticleRepository
import com.google.android.material.snackbar.Snackbar

class ArticleViewFragment : Fragment() {

    lateinit var favb : FragmentArticleViewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        favb = FragmentArticleViewBinding.inflate(
            inflater,container, false
        )
        return favb.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        favb.article = ArticleRepository.getArticle(4)
        if (favb.article == null) Snackbar.make(
            favb.titleArticleView,
            "Article indisponible",
            5000
        ).show() else {
            //Regle métier pour afficher la date d'achat si la checkbox est Checked
            if (favb.article?.achete != null) favb.dateView.isVisible = favb.article?.achete!!
        }
        favb.urlButton.setOnClickListener {
            Snackbar.make(favb.root,favb.article?.url ?: "pas d'url",5000
            ).show()
        }

        // bouton droite SMS
        val buttonClickSms = favb.smsButton
        buttonClickSms.setOnClickListener{
            Snackbar.make(buttonClickSms, "Confirmer l'envoi du SMS", 3000).show()
        }
        // bouton central édition
        val buttonClick = favb.editButton
        buttonClick.setOnClickListener {
            val direction = ArticleViewFragmentDirections
                .actionArticleViewFragmentToArticleAddEditFragment(
                    favb.article!!
                )
            Navigation.findNavController(view)
                .navigate(direction)
        }

    }
}

