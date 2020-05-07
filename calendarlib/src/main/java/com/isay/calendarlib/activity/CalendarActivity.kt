package com.isay.calendarlib.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.isay.calendarlib.R
import com.isay.commonserverlib.constants.ARouterPathConstants

@Route(path = ARouterPathConstants.CALENDAR_HOME)
class CalendarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
    }
}
