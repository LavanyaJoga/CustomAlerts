package com.example.kotlincustomalerts

import android.graphics.Color
import junit.framework.TestCase
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Config.OLDEST_SDK])
class AlertTest {

    lateinit var alert: Alert
    lateinit var mainActivity:MainActivity

    @Before
    fun setUp() {
        alert = Alert()
        mainActivity =  Robolectric.buildActivity(MainActivity::class.java).create().resume()
            .visible().get()
    }

    @Test
    fun nullCheck() {
        TestCase.assertNotNull(mainActivity)
    }
//    @Test
//    fun method() {
//        alert.alertWithOneButton(mainActivity,"rectangle","My Alert",
//            Color.BLACK,18f,"Title",Color.BLACK,"Submit","oval",Color.BLUE,3f,Color.WHITE,)
//    }
}