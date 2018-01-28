package com.badlogic.masaki.databindingpractice

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.badlogic.masaki.databindingpractice.databinding.ActivityDataBindingTestBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_binding_test)
        val binding: ActivityDataBindingTestBinding
                = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_test)
        binding.user = User("firstName!", "lastName!")

        Handler(Looper.getMainLooper())
                .postDelayed({
                    binding.user.run {
                        firstName = "hogeeee"
                        notifyChange()
                    }
                }, 2000)
    }
}
