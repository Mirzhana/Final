package supermegadevelopers.ayanamira.mypet.Database
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import supermegadevelopers.ayanamira.mypet.Models.User


@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User): Long?

    @Query("SELECT * FROM user")
    fun getUsers(): List<User>
}