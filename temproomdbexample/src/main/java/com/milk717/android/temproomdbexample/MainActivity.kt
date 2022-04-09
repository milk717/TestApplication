package com.milk717.android.temproomdbexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.milk717.android.temproomdbexample.data.Memo
import com.milk717.android.temproomdbexample.data.MemoDataBase
import com.milk717.android.temproomdbexample.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var db: MemoDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = MemoDataBase.getInstance(applicationContext)!!

        getMemo()

        binding.inputBtn.setOnClickListener{
            inputMemo()
            getMemo()
        }
    }

    private fun inputMemo() {
        val memo = binding.inputMemo.text.toString()

        CoroutineScope(Dispatchers.IO).launch {
            db.memoDao().insertMemo(Memo(memo))
        }
    }

    private fun getMemo() {
        var memoList = "메모 리스트\n"

        CoroutineScope(Dispatchers.Main).launch {
            val memos = CoroutineScope(Dispatchers.IO).async {
                db.memoDao().getAllMemo()
            }.await()

            for(memo in memos){
                memoList += "$memo\n"
            }
            binding.memo.text = memoList
        }
    }
}