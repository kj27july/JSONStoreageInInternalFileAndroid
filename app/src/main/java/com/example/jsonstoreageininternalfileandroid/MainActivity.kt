package com.example.jsonstoreageininternalfileandroid

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject
import java.io.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        ////if we have json object then write it in file
        val jsonDataV2 = """{
       
       "device_manufacturer" : "Samsung",
       "device_version" : 111.11,
       "device_model" : "S10",
       "battery_level" : [1,2,3,4,5],
       "battery_plugType" : {"acChargeCount" : 0,"usbChargeCountUsb" : 3,"wirelessChargeCount" : 1},
       "appUsage" : [
              {"appId": "whatsApp", "txBytes" : 5000, "rxBytes":4000},
              {"appId": "youtube", "txBytes" : 10000, "rxBytes":0}    
       ],
       "deviceUsage" : {"txBytes" : 5000, "rxBytes":4000},
       "app_foregroundTime" : [
              {"appId": "whatsApp", "foregroundTime" : "1000","visitCount" : "10"},
              {"appId": "youtube", "foregroundTime" : "1000","visitCount" : "2"},
              {"appId": "chrome", "foregroundTime" : "1000","visitCount" : "1"}
       ],
       "app_events" : [
              {"appId" : "whatsApp", "versionCode" : 1, "eventType" : 0},
              {"appId" : "YouTube", "versionCode" : 2, "eventType" : 1},
              {"appId" : "Chrome", "versionCode" : 3, "eventType" : 2}
       ]
}"""
//        val jsonData= """{
//        "device_manufacturer" : {
//            "description":"name of manufacturer",
//            "keyType" : "String"
//        },
//
//        "device_version" : {
//            "description":"Platform buld version",
//            "keyType" : "Float"
//        }}"""
        val jsonObj: JSONObject = JSONObject(jsonDataV2)
        println(jsonObj)
//        Log.d("json-1", jsonObj.toString())

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        writeToFile(jsonObj)
    }

    private fun writeToFile(data: JSONObject) {
        try {
            val outputStreamWriter =
                OutputStreamWriter(openFileOutput("jsonSOTIDataInterchange.json", Context.MODE_PRIVATE))
            Log.d("json-2", data.toString())
            outputStreamWriter.write(data.toString())
            outputStreamWriter.close()
        } catch (e: IOException) {
            Log.e("Exception", "File write failed: " + e.toString())
        }
    }
}