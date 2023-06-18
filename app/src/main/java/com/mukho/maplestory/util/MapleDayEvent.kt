package com.mukho.maplestory.util

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import com.mukho.maplestory.MainActivity
import java.util.Calendar
import java.util.concurrent.TimeUnit

class MapleDayEvent (context: Context, params: WorkerParameters) : CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {
        println("이벤트가 대기열에 추가되었습니다.")

        val calendar = Calendar.getInstance().apply {
//            set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY)
//            set(Calendar.HOUR_OF_DAY, 0)
//            set(Calendar.MINUTE, 0)
//            set(Calendar.SECOND, 0)
            add(Calendar.SECOND, 10)
        }

        val initialDelay = calendar.timeInMillis - System.currentTimeMillis()

        val workRequest = PeriodicWorkRequestBuilder<MapleDayEvent>(
//            repeatInterval = 7,
//            repeatIntervalTimeUnit = TimeUnit.DAYS
            repeatInterval = 10,
            repeatIntervalTimeUnit = TimeUnit.SECONDS
        )
            .setInitialDelay(initialDelay, TimeUnit.MILLISECONDS)
            .build()

        WorkManager.getInstance(applicationContext).enqueueUniquePeriodicWork(
            "mapleDayEvent",
            ExistingPeriodicWorkPolicy.KEEP,
            workRequest
        )

        println("목요일입니다.")
        MainActivity.mapleDayEvent()
        println("목요일 초기화가 성공했습니다.")

        return Result.success()
    }
}
