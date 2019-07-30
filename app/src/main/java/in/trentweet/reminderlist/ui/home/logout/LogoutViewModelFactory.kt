package `in`.trentweet.reminderlist.ui.home.logout

import `in`.trentweet.reminderlist.data.repositories.UserRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class LogoutViewModelFactory(
    private val repository: UserRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LogoutViewModel(repository) as T
    }
}