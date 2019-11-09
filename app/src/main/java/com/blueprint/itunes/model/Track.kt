package com.blueprint.itunes.model
import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parceler
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Track(
    var wrapperType: String?,
    var kind: String?,
    var artistId: Int,
    var collectionId: Int,
    var trackId: Int,
    var artistName: String?,
    var collectionName: String?,
    var trackName: String?,
    var collectionCensoredName: String?,
    var trackCensoredName: String?,
    var artistViewUrl: String?,
    var collectionViewUrl: String?,
    var trackViewUrl: String?,
    var previewUrl: String?,
    var artworkUrl30: String?,
    var artworkUrl60: String?,
    var artworkUrl100: String?,
    var collectionPrice: Double,
    var trackPrice: Double,
    var collectionHdPrice: Double,
    var trackHdPrice: Double,
    var releaseDate: String?,
    var collectionExplicitness: String?,
    var trackExplicitness: String?,
    var discCount: Int,
    var discNumber: Int,
    var trackCount: Int,
    var trackNumber: Int,
    var trackTimeMillis: Int,
    var country: String?,
    var currency: String?,
    var primaryGenreName: String?,
    var contentAdvisoryRating:String?,
    var shortDescription:String?,
    var longDescription: String?
): Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )


    companion object : Parceler<Track> {
        override fun Track.write(parcel: Parcel, flags: Int) {

            parcel.writeString(wrapperType)
            parcel.writeString(kind)
            parcel.writeInt(artistId)
            parcel.writeInt(collectionId)
            parcel.writeInt(trackId)

            parcel.writeString(artistName)
            parcel.writeString(collectionName)
            parcel.writeString(trackName)
            parcel.writeString(collectionCensoredName)
            parcel.writeString(trackCensoredName)
            parcel.writeString(artistViewUrl)
            parcel.writeString(collectionViewUrl)
            parcel.writeString(trackViewUrl)
            parcel.writeString(previewUrl)
            parcel.writeString(artworkUrl30)
            parcel.writeString(artworkUrl60)
            parcel.writeString(artworkUrl100)

            parcel.writeDouble(collectionPrice)
            parcel.writeDouble(trackPrice)
            parcel.writeDouble(collectionHdPrice)
            parcel.writeDouble(trackHdPrice)

            parcel.writeString(releaseDate)
            parcel.writeString(collectionExplicitness)
            parcel.writeString(trackExplicitness)

            parcel.writeInt(discCount)
            parcel.writeInt(discNumber)
            parcel.writeInt(trackCount)
            parcel.writeInt(trackNumber)
            parcel.writeInt(trackTimeMillis)

            parcel.writeString(country)
            parcel.writeString(currency)
            parcel.writeString(primaryGenreName)
            parcel.writeString(contentAdvisoryRating)
            parcel.writeString(shortDescription)
            parcel.writeString(longDescription)

        }

        override fun create(parcel: Parcel): Track {
            return Track(parcel)
        }


    }




}

