package com.mukho.maplestory

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.SharedPreferences
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

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

        // Status
        private const val SHARED_PREFS_NAME = "MyPrefs"
        private const val HILLA_ENABLED_KEY = "hillaEnabled"
        private const val PINKBEAN_ENABLED_KEY = "pinkbeanEnabled"
        private const val CYGNUS_ENABLED_KEY = "cygnusEnabled"
        private const val ZAKUM_ENABLED_KEY = "zakumEnabled"
        private const val BLOODYQUEEN_ENABLED_KEY = "bloodyqueenEnabled"
        private const val BANBAN_ENABLED_KEY = "banbanEnabled"
        private const val PIERRE_ENABLED_KEY = "pierreEnabled"
        private const val MAGNUS_ENABLED_KEY = "magnusEnabled"
        private const val BELLUM_ENABLED_KEY = "bellumEnabled"
        private const val PAPULATUS_ENABLED_KEY = "papulatusEnabled"
        private const val SU_ENABLED_KEY = "suEnabled"
        private const val DAMIAN_ENABLED_KEY = "damianEnabled"
        private const val GUARDIANANGELSLIME_ENABLED_KEY = "guardianangelslimeEnabled"
        private const val LUCID_ENABLED_KEY = "lucidEnabled"
        private const val WILL_ENABLED_KEY = "willEnabled"
        private const val MESO_VALUE_KEY = "meso"
    }

    private var isHillaEnabled: Boolean = true
    private var isPinkbeanEnabled: Boolean = true
    private var isCygnusEnabled: Boolean = true
    private var isZakumEnabled: Boolean = true
    private var isBloodyqueenEnabled: Boolean = true
    private var isBanbanEnabled: Boolean = true
    private var isPierreEnabled: Boolean = true
    private var isMagnusEnabled: Boolean = true
    private var isBellumEnabled: Boolean = true
    private var isPapulatusEnabled: Boolean = true
    private var isSuEnabled: Boolean = true
    private var isDamianEnabled: Boolean = true
    private var isGuardianangelslimeEnabled: Boolean = true
    private var isLucidEnabled: Boolean = true
    private var isWillEnabled: Boolean = true

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var hillaButton: ImageButton
    private lateinit var pinkbeanButton: ImageButton
    private lateinit var cygnusButton: ImageButton
    private lateinit var zakumButton: ImageButton
    private lateinit var bloodyqueenButton: ImageButton
    private lateinit var banbanButton: ImageButton
    private lateinit var pierreButton: ImageButton
    private lateinit var magnusButton: ImageButton
    private lateinit var bellumButton: ImageButton
    private lateinit var papulatusButton: ImageButton
    private lateinit var suButton: ImageButton
    private lateinit var damianButton: ImageButton
    private lateinit var guardianangelslimeButton: ImageButton
    private lateinit var lucidButton: ImageButton
    private lateinit var willButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        // Run Application
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        setContentView(R.layout.activity_main)
        run()
        createNotificationChannel()
        sharedPreferences = getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

        instance = this

        // Thursday Reset Event
        // val mapleDayEventRequest = OneTimeWorkRequest.Builder(MapleDayEvent::class.java).build()
        // WorkManager.getInstance(this).enqueue(mapleDayEventRequest)
        findViewById<Button>(R.id.customResetButton).setOnClickListener {
            thursdayReset()
        }

        // ImageButton
        hillaButton = findViewById(R.id.hilla)
        pinkbeanButton = findViewById(R.id.pinkbean)
        cygnusButton = findViewById(R.id.cygnus)
        zakumButton = findViewById(R.id.zakum)
        bloodyqueenButton = findViewById(R.id.bloodyqueen)
        banbanButton = findViewById(R.id.banban)
        pierreButton = findViewById(R.id.pierre)
        magnusButton = findViewById(R.id.magnus)
        bellumButton = findViewById(R.id.bellum)
        papulatusButton = findViewById(R.id.papulatus)
        suButton = findViewById(R.id.su)
        damianButton = findViewById(R.id.damian)
        guardianangelslimeButton = findViewById(R.id.guardianangelslime)
        lucidButton = findViewById(R.id.lucid)
        willButton = findViewById(R.id.will)

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

    override fun onPause() {
        super.onPause()

        // Save the current state
        val editor = sharedPreferences.edit()
        editor.putBoolean(HILLA_ENABLED_KEY, hillaButton.isEnabled)
        editor.putBoolean(PINKBEAN_ENABLED_KEY, pinkbeanButton.isEnabled)
        editor.putBoolean(CYGNUS_ENABLED_KEY, cygnusButton.isEnabled)
        editor.putBoolean(ZAKUM_ENABLED_KEY, zakumButton.isEnabled)
        editor.putBoolean(BLOODYQUEEN_ENABLED_KEY, bloodyqueenButton.isEnabled)
        editor.putBoolean(BANBAN_ENABLED_KEY, banbanButton.isEnabled)
        editor.putBoolean(PIERRE_ENABLED_KEY, pierreButton.isEnabled)
        editor.putBoolean(MAGNUS_ENABLED_KEY, magnusButton.isEnabled)
        editor.putBoolean(BELLUM_ENABLED_KEY, bellumButton.isEnabled)
        editor.putBoolean(PAPULATUS_ENABLED_KEY, papulatusButton.isEnabled)
        editor.putBoolean(SU_ENABLED_KEY, suButton.isEnabled)
        editor.putBoolean(DAMIAN_ENABLED_KEY, damianButton.isEnabled)
        editor.putBoolean(GUARDIANANGELSLIME_ENABLED_KEY, guardianangelslimeButton.isEnabled)
        editor.putBoolean(LUCID_ENABLED_KEY, lucidButton.isEnabled)
        editor.putBoolean(WILL_ENABLED_KEY, willButton.isEnabled)
        editor.putInt(MESO_VALUE_KEY, meso)
        editor.apply()
    }

    override fun onResume() {
        super.onResume()

        // Restore the saved state
        isHillaEnabled = sharedPreferences.getBoolean(HILLA_ENABLED_KEY, true)
        isPinkbeanEnabled = sharedPreferences.getBoolean(PINKBEAN_ENABLED_KEY, true)
        isCygnusEnabled = sharedPreferences.getBoolean(CYGNUS_ENABLED_KEY, true)
        isZakumEnabled = sharedPreferences.getBoolean(ZAKUM_ENABLED_KEY, true)
        isBloodyqueenEnabled = sharedPreferences.getBoolean(BLOODYQUEEN_ENABLED_KEY, true)
        isBanbanEnabled = sharedPreferences.getBoolean(BANBAN_ENABLED_KEY, true)
        isPierreEnabled = sharedPreferences.getBoolean(PIERRE_ENABLED_KEY, true)
        isMagnusEnabled = sharedPreferences.getBoolean(MAGNUS_ENABLED_KEY, true)
        isBellumEnabled = sharedPreferences.getBoolean(BELLUM_ENABLED_KEY, true)
        isPapulatusEnabled = sharedPreferences.getBoolean(PAPULATUS_ENABLED_KEY, true)
        isSuEnabled = sharedPreferences.getBoolean(SU_ENABLED_KEY, true)
        isDamianEnabled = sharedPreferences.getBoolean(DAMIAN_ENABLED_KEY, true)
        isGuardianangelslimeEnabled = sharedPreferences.getBoolean(GUARDIANANGELSLIME_ENABLED_KEY, true)
        isLucidEnabled = sharedPreferences.getBoolean(LUCID_ENABLED_KEY, true)
        isWillEnabled = sharedPreferences.getBoolean(WILL_ENABLED_KEY, true)
        meso = sharedPreferences.getInt(MESO_VALUE_KEY, 0)

        hillaButton.isEnabled = isHillaEnabled
        pinkbeanButton.isEnabled = isPinkbeanEnabled
        cygnusButton.isEnabled = isCygnusEnabled
        zakumButton.isEnabled = isZakumEnabled
        bloodyqueenButton.isEnabled = isBloodyqueenEnabled
        banbanButton.isEnabled = isBanbanEnabled
        pierreButton.isEnabled = isPierreEnabled
        magnusButton.isEnabled = isMagnusEnabled
        bellumButton.isEnabled = isBellumEnabled
        papulatusButton.isEnabled = isPapulatusEnabled
        suButton.isEnabled = isSuEnabled
        damianButton.isEnabled = isDamianEnabled
        guardianangelslimeButton.isEnabled = isGuardianangelslimeEnabled
        lucidButton.isEnabled = isLucidEnabled
        willButton.isEnabled = isWillEnabled

        updateMesoText()
        if(!hillaButton.isEnabled) {
            disableAndGrayscaleImageButton(hillaButton);
        }
        if(!pinkbeanButton.isEnabled) {
            disableAndGrayscaleImageButton(pinkbeanButton);
        }
        if(!cygnusButton.isEnabled) {
            disableAndGrayscaleImageButton(cygnusButton);
        }
        if(!zakumButton.isEnabled) {
            disableAndGrayscaleImageButton(zakumButton);
        }
        if(!bloodyqueenButton.isEnabled) {
            disableAndGrayscaleImageButton(bloodyqueenButton);
        }
        if(!banbanButton.isEnabled) {
            disableAndGrayscaleImageButton(banbanButton);
        }
        if(!pierreButton.isEnabled) {
            disableAndGrayscaleImageButton(pierreButton);
        }
        if(!magnusButton.isEnabled) {
            disableAndGrayscaleImageButton(magnusButton);
        }
        if(!bellumButton.isEnabled) {
            disableAndGrayscaleImageButton(bellumButton);
        }
        if(!papulatusButton.isEnabled) {
            disableAndGrayscaleImageButton(papulatusButton);
        }
        if(!suButton.isEnabled) {
            disableAndGrayscaleImageButton(suButton);
        }
        if(!damianButton.isEnabled) {
            disableAndGrayscaleImageButton(damianButton);
        }
        if(!guardianangelslimeButton.isEnabled) {
            disableAndGrayscaleImageButton(guardianangelslimeButton);
        }
        if(!lucidButton.isEnabled) {
            disableAndGrayscaleImageButton(lucidButton);
        }
        if(!willButton.isEnabled) {
            disableAndGrayscaleImageButton(willButton);
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
        enableAndRestoreColorImageButton(findViewById(R.id.hilla))
        enableAndRestoreColorImageButton(findViewById(R.id.pinkbean))
        enableAndRestoreColorImageButton(findViewById(R.id.cygnus))
        enableAndRestoreColorImageButton(findViewById(R.id.zakum))
        enableAndRestoreColorImageButton(findViewById(R.id.bloodyqueen))
        enableAndRestoreColorImageButton(findViewById(R.id.banban))
        enableAndRestoreColorImageButton(findViewById(R.id.pierre))
        enableAndRestoreColorImageButton(findViewById(R.id.magnus))
        enableAndRestoreColorImageButton(findViewById(R.id.bellum))
        enableAndRestoreColorImageButton(findViewById(R.id.papulatus))
        enableAndRestoreColorImageButton(findViewById(R.id.su))
        enableAndRestoreColorImageButton(findViewById(R.id.damian))
        enableAndRestoreColorImageButton(findViewById(R.id.guardianangelslime))
        enableAndRestoreColorImageButton(findViewById(R.id.lucid))
        enableAndRestoreColorImageButton(findViewById(R.id.will))
    }

    // Meso Method
    private var meso: Int = 0

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