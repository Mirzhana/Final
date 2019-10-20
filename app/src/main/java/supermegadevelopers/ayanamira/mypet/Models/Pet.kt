package supermegadevelopers.ayanamira.mypet.Models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Pet(
        @PrimaryKey
        var id:Long,

        @ColumnInfo(name = "pet_name")
        var name: String,

        @ColumnInfo(name = "pet_type")
        var type: String
) {
}