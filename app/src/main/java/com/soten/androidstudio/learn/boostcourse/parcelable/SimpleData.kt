package com.soten.androidstudio.learn.boostcourse.parcelable

import android.os.Parcel
import android.os.Parcelable

class SimpleData(
    var number: Int?,
    var message: String?
) : Parcelable {


    constructor(parcel: Parcel) : this(
        number = parcel.readInt(),
        message = parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        number?.let { parcel.writeInt(it) }
        message?.let { parcel.writeString(it) }
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SimpleData> {
        override fun createFromParcel(parcel: Parcel): SimpleData {
            return SimpleData(parcel)
        }

        override fun newArray(size: Int): Array<SimpleData?> {
            return arrayOfNulls(size)
        }
    }
}