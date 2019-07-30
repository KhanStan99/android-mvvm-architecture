package `in`.trentweet.reminderlist.ui.home.logout

import androidx.lifecycle.ViewModel;
import `in`.trentweet.reminderlist.data.repositories.UserRepository

class LogoutViewModel(
    repository: UserRepository
) : ViewModel() {

    val user = repository.getUser()

}
