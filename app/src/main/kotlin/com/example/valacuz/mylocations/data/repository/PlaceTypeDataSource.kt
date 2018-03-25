package com.example.valacuz.mylocations.data.repository

import com.example.valacuz.mylocations.data.PlaceType
import io.reactivex.Completable
import io.reactivex.Flowable

interface PlaceTypeDataSource : TimingsDataSource {

    fun getAllTypes(): Flowable<List<PlaceType>>

    fun addTypes(types: List<PlaceType>): Completable

    fun clearTypes(): Completable
}