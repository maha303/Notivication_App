package com.example.notivication_app

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.notivication_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  //  private lateinit var edMessage:EditText
  //  private lateinit var btnAdd:Button

    private val channelId = "myapp.notifications"
    private val description = "Notification App Example"
    lateinit var builder: Notification.Builder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val b =ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

    //    edMessage=findViewById(R.id.edMessage)
     //   val m =edMessage.text.toString()

     //   btnAdd=findViewById(R.id.btnAdd)

        b.btnAdd.setOnClickListener {

            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            val intent = Intent(this, Main3Activity::class.java)
            val pendingIntent =
                PendingIntent.getActivities(this, 0, arrayOf(intent), PendingIntent.FLAG_UPDATE_CURRENT)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val notificationChannel = NotificationChannel(channelId, description, NotificationManager.IMPORTANCE_HIGH)
                notificationManager.createNotificationChannel(notificationChannel)

                builder = Notification.Builder(this, channelId)
                    .setSmallIcon(R.drawable.panda)
                    .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.ic_launcher_background))
                    .setContentIntent(pendingIntent)
                    .setContentTitle("My Notification")
                    .setContentText(b.edMessage.text)
            } else  {
                builder = Notification.Builder(this)
                    .setSmallIcon(R.drawable.panda)
                    .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.ic_launcher_background))
                    .setContentIntent(pendingIntent)
                    .setContentTitle("My Notification")
                    .setContentText(b.edMessage.text)
            }

            notificationManager. notify(1234, builder.build())

        }
    }
}