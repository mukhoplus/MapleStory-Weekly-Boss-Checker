package com.mukho.maplestory

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.os.Build
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.mukho.maplestory.util.MapleDayEvent

class MainActivity : AppCompatActivity() {
    companion object {
        @JvmStatic
        fun mapleDayEvent() {
            getInstance()?.thursdayReset()
        }

        @JvmStatic
        private var instance: MainActivity? = null

        @JvmStatic
        fun getInstance(): MainActivity? {
            return instance
        }

        // Notification
        private const val CHANNEL_ID = "Mukho I/O"
        private const val NOTIFICATION_ID = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        // Run Application
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        setContentView(R.layout.activity_main)
        run()
        createNotificationChannel()
        instance = this

        // Thursday Reset Event
        val mapleDayEventRequest = OneTimeWorkRequest.Builder(MapleDayEvent::class.java).build()
        WorkManager.getInstance(this).enqueue(mapleDayEventRequest)

        // ImageButton
        val hillaButton = findViewById<ImageButton>(R.id.hilla)
        val pinkbeanButton = findViewById<ImageButton>(R.id.pinkbean)
        val cygnusButton = findViewById<ImageButton>(R.id.cygnus)
        val zakumButton = findViewById<ImageButton>(R.id.zakum)
        val bloodyqueenButton = findViewById<ImageButton>(R.id.bloodyqueen)
        val banbanButton = findViewById<ImageButton>(R.id.banban)
        val pierreButton = findViewById<ImageButton>(R.id.pierre)
        val magnusButton = findViewById<ImageButton>(R.id.magnus)
        val bellumButton = findViewById<ImageButton>(R.id.bellum)
        val papulatusButton = findViewById<ImageButton>(R.id.papulatus)
        val suButton = findViewById<ImageButton>(R.id.su)
        val damianButton = findViewById<ImageButton>(R.id.damian)
        val guardianangelslimeButton = findViewById<ImageButton>(R.id.guardianangelslime)
        val lucidButton = findViewById<ImageButton>(R.id.lucid)
        val willButton = findViewById<ImageButton>(R.id.will)

        // ImageButton Handler
        hillaButton.setOnClickListener {
            disableAndGrayscaleImageButton(hillaButton)
            stoneMesoMap["hilla"]?.let { it1 -> updateMeso(it1) }
            showToast("하드 힐라를")
        }
        pinkbeanButton.setOnClickListener {
            disableAndGrayscaleImageButton(pinkbeanButton)
            stoneMesoMap["pinkbean"]?.let { it1 -> updateMeso(it1) }
            showToast("카오스 핑크빈을")
        }
        cygnusButton.setOnClickListener {
            disableAndGrayscaleImageButton(cygnusButton)
            stoneMesoMap["cygnus"]?.let { it1 -> updateMeso(it1) }
            showToast("노멀 시그너스를")
        }
        zakumButton.setOnClickListener {
            disableAndGrayscaleImageButton(zakumButton)
            stoneMesoMap["zakum"]?.let { it1 -> updateMeso(it1) }
            showToast("카오스 자쿰을")
        }
        bloodyqueenButton.setOnClickListener {
            disableAndGrayscaleImageButton(bloodyqueenButton)
            stoneMesoMap["bloodyqueen"]?.let { it1 -> updateMeso(it1) }
            showToast("카오스 블러디퀸을")
        }
        banbanButton.setOnClickListener {
            disableAndGrayscaleImageButton(banbanButton)
            stoneMesoMap["banban"]?.let { it1 -> updateMeso(it1) }
            showToast("카오스 반반을")
        }
        pierreButton.setOnClickListener {
            disableAndGrayscaleImageButton(pierreButton)
            stoneMesoMap["pierre"]?.let { it1 -> updateMeso(it1) }
            showToast("카오스 피에르를")
        }
        magnusButton.setOnClickListener {
            disableAndGrayscaleImageButton(magnusButton)
            stoneMesoMap["magnus"]?.let { it1 -> updateMeso(it1) }
            showToast("하드 매그너스를")
        }
        bellumButton.setOnClickListener {
            disableAndGrayscaleImageButton(bellumButton)
            stoneMesoMap["bellum"]?.let { it1 -> updateMeso(it1) }
            showToast("카오스 벨룸을")
        }
        papulatusButton.setOnClickListener {
            disableAndGrayscaleImageButton(papulatusButton)
            stoneMesoMap["papulatus"]?.let { it1 -> updateMeso(it1) }
            showToast("카오스 파풀라투스를")
        }
        suButton.setOnClickListener {
            disableAndGrayscaleImageButton(suButton)
            stoneMesoMap["su"]?.let { it1 -> updateMeso(it1) }
            showToast("노멀 스우를")
        }
        damianButton.setOnClickListener {
            disableAndGrayscaleImageButton(damianButton)
            stoneMesoMap["damian"]?.let { it1 -> updateMeso(it1) }
            showToast("노멀 데미안을")
        }
        guardianangelslimeButton.setOnClickListener {
            disableAndGrayscaleImageButton(guardianangelslimeButton)
            stoneMesoMap["guardianangelslime"]?.let { it1 -> updateMeso(it1) }
            showToast("노멀 가디언 엔젤 슬라임을")
        }
        lucidButton.setOnClickListener {
            disableAndGrayscaleImageButton(lucidButton)
            stoneMesoMap["lucid"]?.let { it1 -> updateMeso(it1) }
            showToast("이지 루시드를")
        }
        willButton.setOnClickListener {
            disableAndGrayscaleImageButton(willButton)
            stoneMesoMap["will"]?.let { it1 -> updateMeso(it1) }
            showToast("이지 윌을")
        }

    }

    private fun run() {
        updateMesoText()
        initStoneMesoMap()
        Toast.makeText(this, "애플리케이션이 실행되었습니다.", Toast.LENGTH_SHORT).show()
        println("애플리케이션이 실행되었습니다.")
    }
    
    private fun showToast(bossMessage: String) {
        Toast.makeText(this, "$bossMessage 잡았습니다.", Toast.LENGTH_SHORT).show()
        println("$bossMessage 잡았습니다.")
    }

    private fun disableAndGrayscaleImageButton(imageButton: ImageButton) {
        imageButton.isEnabled = false
        val colorMatrix = ColorMatrix().apply {
            setSaturation(0f)
        }
        val filter = ColorMatrixColorFilter(colorMatrix)
        imageButton.colorFilter = filter
    }

    private fun enableAndRestoreColorImageButton(imageButton: ImageButton) {
        imageButton.isEnabled = true
        imageButton.colorFilter = null
    }

    private fun resetButton() {
        enableAndRestoreColorImageButton(findViewById<ImageButton>(R.id.hilla))
        enableAndRestoreColorImageButton(findViewById<ImageButton>(R.id.pinkbean))
        enableAndRestoreColorImageButton(findViewById<ImageButton>(R.id.cygnus))
        enableAndRestoreColorImageButton(findViewById<ImageButton>(R.id.zakum))
        enableAndRestoreColorImageButton(findViewById<ImageButton>(R.id.bloodyqueen))
        enableAndRestoreColorImageButton(findViewById<ImageButton>(R.id.banban))
        enableAndRestoreColorImageButton(findViewById<ImageButton>(R.id.pierre))
        enableAndRestoreColorImageButton(findViewById<ImageButton>(R.id.magnus))
        enableAndRestoreColorImageButton(findViewById<ImageButton>(R.id.bellum))
        enableAndRestoreColorImageButton(findViewById<ImageButton>(R.id.papulatus))
        enableAndRestoreColorImageButton(findViewById<ImageButton>(R.id.su))
        enableAndRestoreColorImageButton(findViewById<ImageButton>(R.id.damian))
        enableAndRestoreColorImageButton(findViewById<ImageButton>(R.id.guardianangelslime))
        enableAndRestoreColorImageButton(findViewById<ImageButton>(R.id.lucid))
        enableAndRestoreColorImageButton(findViewById<ImageButton>(R.id.will))
    }

    // Meso Method
    private var meso = 0

    private val stoneMesoMap = mutableMapOf<String, Int>()
    private fun initStoneMesoMap() {
        stoneMesoMap["hilla"] = 6936489
        stoneMesoMap["pinkbean"] = 7923110
        stoneMesoMap["cygnus"] = 9039130
        stoneMesoMap["zakum"] = 9741285
        stoneMesoMap["bloodyqueen"] = 9806780
        stoneMesoMap["banban"] = 9818154
        stoneMesoMap["pierre"] = 9838932
        stoneMesoMap["magnus"] = 11579023
        stoneMesoMap["bellum"] = 12590202
        stoneMesoMap["papulatus"] = 26725937
        stoneMesoMap["su"] = 33942566
        stoneMesoMap["damian"] = 35517853
        stoneMesoMap["guardianangelslime"] = 46935874
        stoneMesoMap["lucid"] = 48058319
        stoneMesoMap["will"] = 52139127
    }

    private fun addCommasToNumber(number: Int): String {
        val formattedNumber = StringBuilder()
        val numberString = number.toString()
        val length = numberString.length

        for (i in 0 until length) {
            formattedNumber.append(numberString[i])
            if ((length - i - 1) % 3 == 0 && i != length - 1) {
                formattedNumber.append(",")
            }
        }

        return formattedNumber.toString()
    }
    private fun updateMesoText() {
        val labelTextView = findViewById<TextView>(R.id.meso)
        labelTextView.text = "이번주에 모은 결정석 메소량: " + addCommasToNumber(meso) + " 메소"
    }

    private fun updateMeso(stoneMeso: Int) {
        meso += stoneMeso
        updateMesoText()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Mukho I/O"
            val descriptionText = "목요일 초기화"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply{
                description = descriptionText
            }

            val notificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
            println("알림 채널 생성 성공")
        }
    }

    @SuppressLint("MissingPermission")
    private fun showNotification() {
        val notificationBuilder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.maplestory)
            .setContentTitle("메이플스토리 주간 보스 체커")
            .setContentText("주간 보스 클리어 기록이 초기화되었습니다.")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(this)) {
            notify(NOTIFICATION_ID, notificationBuilder.build())
        }
        println("알림 출력을 성공했습니다.")
    }
    private fun thursdayReset() {
        runOnUiThread {
            meso = 0
            resetButton()
            updateMesoText()
            showNotification()
        }
    }

}