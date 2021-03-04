package com.thisissadeghi.player.presentation.base

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import com.thisissadeghi.player.R
import java.lang.reflect.ParameterizedType


/**
 * Created by Ali Sadeghi
 * on 04,Mar,2021
 */
abstract class BaseFragment<V : BaseViewModel, B : ViewBinding?> : Fragment(),
    BaseViewGroup<V, B?> {
    override var binding: B? = null
    var v: View? = null

    @Suppress("UNCHECKED_CAST")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (v == null) {
            val bindingClass = (javaClass
                .genericSuperclass as ParameterizedType).actualTypeArguments[1] as Class<B>

            binding = bindingClass.getMethod(
                "inflate",
                LayoutInflater::class.java,
                ViewGroup::class.java,
                Boolean::class.java
            )
                .invoke(this, inflater, container, false) as B

            v = binding?.root
        }
        return v
    }


    fun showMessage(message: String) {
        Snackbar.make(requireView(), message, Snackbar.LENGTH_LONG).apply {
            val snackView = this.view
            snackView.setBackgroundResource(R.drawable.shape_snack_bar)
            val textView = snackView.findViewById(R.id.snackbar_text) as TextView
            textView.setTextColor(Color.WHITE)
            show()
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        v = null
        binding = null
    }
}