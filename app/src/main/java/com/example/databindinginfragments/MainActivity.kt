package com.example.databindinginfragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.databindinginfragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val mainBinding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(this@MainActivity,R.layout.activity_main)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding.button.setOnClickListener{
            if(mainBinding.edTitle.text.toString().isEmpty())
            {
                mainBinding.edTitle.error="Required"
            }
            else if (mainBinding.edDis.text.toString().isEmpty())
            {
                mainBinding.edDis.error="Required"
            }
            else{
                mainBinding.titleStr=mainBinding.edTitle.text.toString()
                mainBinding.desStr=mainBinding.edDis.text.toString()
            }
        }
        mainBinding.fragmentButton.setOnClickListener{
            startActivity(Intent(this,LoadBlankActivity::class.java))
        }
    }
}