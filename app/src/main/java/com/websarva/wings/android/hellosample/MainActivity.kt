package com.websarva.wings.android.hellosample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Buttonオブジェクトを取得
        val btClick = findViewById<Button>(R.id.btClick)
        // リスナクラスのインスタンスを生成
        val listener = HelloListener()
        // 表示ボタンにリスナを設定
//        btClick.setOnClickListener(listener)
        // オブジェクト式で記述する場合
//        btClick.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(view: View) {
//                // 名前入力欄であるEditTextオブジェクトを取得
//                val input = findViewById<EditText>(R.id.etName)
//                // メッセージを表示するTextViewオブジェクトを取得
//                val output = findViewById<TextView>(R.id.tvOutput)
//                // 入力された文字列を取得
//                val inputStr = input.text.toString()
//                // メッセージ表示
//                output.text = inputStr + "さん、こんにちは"
//            }
//        })
        // メソッドを一つしか持たない場合
        btClick.setOnClickListener { view: View ->
            // 名前入力欄であるEditTextオブジェクトを取得
            val input = findViewById<EditText>(R.id.etName)
            // メッセージを表示するTextViewオブジェクトを取得
            val output = findViewById<TextView>(R.id.tvOutput)
            // 入力された文字列を取得
            val inputStr = input.text.toString()
            // メッセージ表示
            output.text = inputStr + "さん、こんにちは"
        }

        // Buttonオブジェクトを取得
        val btClear = findViewById<Button>(R.id.btClear)
        // クリアボタンにリスナを設定
        btClear.setOnClickListener(listener)

    }

    // ボタンをクリックしたときのリスナクラス
    private inner class HelloListener : View.OnClickListener {

        // イベントハンドラ
        override fun onClick(view: View) {
            // 名前入力欄であるEditTextオブジェクトを取得
            val input = findViewById<EditText>(R.id.etName)
            // メッセージを表示するTextViewオブジェクトを取得
            val output = findViewById<TextView>(R.id.tvOutput)
            // R値に応じて処理分岐
            when (view.id) {
                // 表示ボタンの場合
                R.id.btClick -> {
                    // 入力された文字列を取得
                    val inputStr = input.text.toString()
                    // メッセージ表示
                    output.text = inputStr + "さん、こんにちは"
                }
                //クリアボタンの場合
                R.id.btClear -> {
                    input.setText("")
                    output.text = ""
                }
            }
        }
    }
}