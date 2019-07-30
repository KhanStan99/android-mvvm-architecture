package `in`.trentweet.reminderlist.ui.home.logout

import `in`.trentweet.reminderlist.R
import `in`.trentweet.reminderlist.databinding.LayoutLogoutConfirmBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class LogoutFragment : DialogFragment(), KodeinAware {

    override val kodein by kodein()

    private lateinit var viewModel: LogoutViewModel
    private val factory: LogoutViewModelFactory by instance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: LayoutLogoutConfirmBinding =
            DataBindingUtil.inflate(inflater, R.layout.layout_logout_confirm, container, false)
        viewModel = ViewModelProviders.of(this, factory).get(LogoutViewModel::class.java)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }


}
