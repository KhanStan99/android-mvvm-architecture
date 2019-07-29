package `in`.trentweet.reminderlist.data.db

import `in`.trentweet.reminderlist.data.db.entities.CURRENT_USER_ID
import `in`.trentweet.reminderlist.data.db.entities.User
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(user: User) : Long

    @Query("SELECT * FROM user WHERE uid = $CURRENT_USER_ID")
    fun getuser() : LiveData<User>

}