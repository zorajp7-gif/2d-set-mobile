package com.example.twodset

import android.app.Activity
import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast

class MainActivity : Activity() {
    private lateinit var web: WebView
    private val defaultUrl = "https://twod-set-backend-2.onrender.com/api/live"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        web = findViewById(R.id.webView)
        web.settings.javaScriptEnabled = true
        web.settings.domStorageEnabled = true
        web.settings.allowFileAccess = true
        web.settings.allowContentAccess = true
        web.webViewClient = WebViewClient()
        web.addJavascriptInterface(Bridge(), "AndroidBridge")
        web.loadUrl("file:///android_asset/index.html")
    }

    inner class Bridge {
        @JavascriptInterface
        fun getUrl(): String =
            getPreferences(MODE_PRIVATE).getString("api_url", defaultUrl) ?: defaultUrl

        @JavascriptInterface
        fun saveUrl(url: String) {
            getPreferences(MODE_PRIVATE).edit().putString("api_url", url.trim()).apply()
            runOnUiThread {
                Toast.makeText(this@MainActivity, "API link saved", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
