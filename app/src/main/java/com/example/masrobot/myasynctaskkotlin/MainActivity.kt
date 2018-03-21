package com.example.masrobot.myasynctaskkotlin

import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val DEMO_ASYNC = "DemoAsync"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val demoAsync = DemoAsync()
        demoAsync.execute("Halo Ini Demo AsyncTask")
    }

    private inner class DemoAsync: AsyncTask<String, Void, String>() {
        override fun onPreExecute() {
            super.onPreExecute()
            tv_status.text = "status : onPreExecute"
        }

        override fun doInBackground(vararg params: String): String {
            Log.d(DEMO_ASYNC, "status : doInBackground")
            try {
                Thread.sleep(5000)
            } catch (e: Exception) {
                Log.d(DEMO_ASYNC, e.message)
            }

            return params[0]
        }

        override fun onPostExecute(s: String?) {
            super.onPostExecute(s)
            tv_status.text = "status : onPostExecute ${s}"
        }
    }
}
