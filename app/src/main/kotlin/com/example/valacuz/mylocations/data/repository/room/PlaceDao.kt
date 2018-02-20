package com.example.valacuz.mylocations.data.repository.room

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import com.example.valacuz.mylocations.data.PlaceItem
import com.example.valacuz.mylocations.data.PlaceType
import io.reactivex.Flowable

@Dao
interface PlaceDao {

    @Query("SELECT * FROM tbl_place")
    fun getAllPlaces(): Flowable<List<PlaceItem>>

    @Query("SELECT * FROM tbl_place_type")
    fun getAllTypes(): Flowable<List<PlaceType>>

    @Query("SELECT * FROM tbl_place WHERE place_id = :placeId")
    fun getById(placeId: String): Flowable<PlaceItem>

    @Insert(onConflict = REPLACE)
    fun addPlace(placeItem: PlaceItem)

    @Insert(onConflict = REPLACE)
    fun addPlaceTypes(types: List<PlaceType>)

    @Update(onConflict = REPLACE)
    fun updatePlace(placeItem: PlaceItem)

    @Delete
    fun deletePlace(placeItem: PlaceItem)

    @Query("DELETE FROM tbl_place")
    fun clearPlaces()
}