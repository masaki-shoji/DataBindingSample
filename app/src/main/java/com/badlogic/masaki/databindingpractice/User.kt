package com.badlogic.masaki.databindingpractice

import android.databinding.BaseObservable

/**
 * Created by shojimasaki on 2018/01/28.
 */
class User(var firstName: String? = null,
           var lastName: String? = null) : BaseObservable() {
}
