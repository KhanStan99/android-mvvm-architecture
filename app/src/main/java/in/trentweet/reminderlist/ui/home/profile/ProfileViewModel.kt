package `in`.trentweet.reminderlist.ui.home.profile

import androidx.lifecycle.ViewModel;
import `in`.trentweet.reminderlist.data.repositories.UserRepository

class ProfileViewModel(
    repository: UserRepository
) : ViewModel() {

    val user = repository.getUser()

}
