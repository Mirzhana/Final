package supermegadevelopers.ayanamira.mypet.Database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import supermegadevelopers.ayanamira.mypet.Models.Pet


@Database(entities = arrayOf(Pet::class), version = 1)
abstract class PetDatabase : RoomDatabase() {


abstract fun petDao():PetDao

    companion object {
        private var INSTANCE : PetDatabase? = null
        fun getInstance(context: Context): PetDatabase? {
            if(INSTANCE == null){
                synchronized(PetDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, PetDatabase::class.java, "pet.db").build()
                }
            }
            return INSTANCE
        }
        fun destroyInstance() {
            INSTANCE = null

        }
    }
}