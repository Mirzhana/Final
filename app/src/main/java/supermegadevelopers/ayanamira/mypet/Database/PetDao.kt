package supermegadevelopers.ayanamira.mypet.Database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import supermegadevelopers.ayanamira.mypet.Models.Pet

@Dao
interface PetDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(pet: Pet): Long?

    @Query("SELECT * FROM pet")
    fun getPet(): List<Pet>


}