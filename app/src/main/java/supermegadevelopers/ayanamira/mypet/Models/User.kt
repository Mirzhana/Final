package supermegadevelopers.ayanamira.mypet.Models


import android.arch.persistence.room.*

@Entity(foreignKeys = arrayOf(ForeignKey(entity = Pet::class, parentColumns = arrayOf("id"), childColumns = arrayOf("pet_id"))))
data class User(

        @PrimaryKey
        var userId: Long,

        @ColumnInfo(name = "user_login")
        var login: String,
        @ColumnInfo(name = "user_password")
        var password : String,

        @Embedded(prefix = "pet_")
        var pet: Pet


) {

}