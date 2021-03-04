package com.thisissadeghi.player.presentation.base

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import com.thisissadeghi.player.R
import java.lang.reflect.ParameterizedType

/**
 * Created by Ali Sadeghi
 * on 04,Mar,2021
 */
abstract class BaseActivity<V : BaseViewModel, B : ViewBinding?> : AppCompatActivity(),
    BaseViewGroup<V, B?> {
    override var binding: B? = null

    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bindingClass =
            (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[1] as Class<B>


        binding = bindingClass.getMethod("inflate", LayoutInflater::class.java)
            .invoke(this, layoutInflater) as B

        setContentView(binding?.root)
    }

    fun showMessage(message: String) {
        binding?.let {
            Snackbar.make(it.root, message, Snackbar.LENGTH_LONG).apply {
                val snackView = this.view
                snackView.setBackgroundResource(R.drawable.shape_snack_bar)
                val textView = snackView.findViewById(R.id.snackbar_text) as TextView
                textView.setTextColor(Color.WHITE)
                show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}