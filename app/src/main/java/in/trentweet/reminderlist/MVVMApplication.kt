package `in`.trentweet.reminderlist

import `in`.trentweet.reminderlist.data.db.AppDatabase
import `in`.trentweet.reminderlist.data.network.MyApi
import `in`.trentweet.reminderlist.data.network.NetworkConnectionInterceptor
import `in`.trentweet.reminderlist.data.preferences.PreferenceProvider
import `in`.trentweet.reminderlist.data.repositories.QuotesRepository
import `in`.trentweet.reminderlist.data.repositories.UserRepository
import `in`.trentweet.reminderlist.ui.auth.AuthViewModelFactory
import `in`.trentweet.reminderlist.ui.home.logout.LogoutViewModelFactory
import `in`.trentweet.reminderlist.ui.home.profile.ProfileViewModelFactory
import `in`.trentweet.reminderlist.ui.home.quotes.QuotesViewModelFactory
import android.app.Application
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MVVMApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@MVVMApplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { MyApi(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { PreferenceProvider(instance()) }
        bind() from singleton { UserRepository(instance(), instance()) }
        bind() from singleton { QuotesRepository(instance(), instance(), instance()) }
        bind() from provider { AuthViewModelFactory(instance()) }
        bind() from provider { ProfileViewModelFactory(instance()) }
        bind() from provider { LogoutViewModelFactory(instance()) }
        bind() from provider { QuotesViewModelFactory(instance()) }


    }

}