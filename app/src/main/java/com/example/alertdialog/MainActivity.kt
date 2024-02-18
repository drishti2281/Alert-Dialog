package com.example.alertdialog

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.example.alertdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var binding : ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        binding?.btnAlertDialog?.setOnClickListener(){
            AlertDialog.Builder(this)
                .setTitle("Add or Remove Alphabets")
                .setMessage("1.If you click on Add 2 button,\n" +
                        "then 2 random alphabets will be added \n" +
                        "at end of text.\n" +
                        "2.If you click on Add 3 button,\n" +
                        "then 3 random alphabets will be added \n" +
                        "at end of text.")
                .setPositiveButton("Add 2",{_,_ ->
                    val random = java.util.Random()
                    val randomAlphabet1 = ('a'.toInt() + random.nextInt(26)).toChar()
                    val randomAlphabet2 = ('a'.toInt() + random.nextInt(26)).toChar()
                    binding?.txtChangeable?.setText(binding?.txtChangeable!!.text.toString()+randomAlphabet1+randomAlphabet2)

                })
                .setNeutralButton("Cancel",{_,_ ->

                })
                .setNegativeButton("Add 3",{_,_ ->
                    val random = java.util.Random()
                    val randomAlphabet1 = ('a'.toInt() + random.nextInt(26)).toChar()
                    val randomAlphabet2 = ('a'.toInt() + random.nextInt(26)).toChar()
                    val randomAlphabet3 = ('a'.toInt() + random.nextInt(26)).toChar()
                    binding?.txtChangeable?.setText(binding?.txtChangeable!!.text.toString()+randomAlphabet1+randomAlphabet2+randomAlphabet3)
                }).show()

        }


        binding?.btnCustomDialogue?.setOnClickListener(){
            var dialog = Dialog(this)
            dialog.setContentView(R.layout.custom_alert_dialogue)
            var etEnterUpdate = dialog.findViewById<EditText>(R.id.etEnterupdate)
            var btnUpdate = dialog.findViewById<Button>(R.id.btnUpdate)

            etEnterUpdate.setText(binding?.txtChangeable?.text.toString())
            btnUpdate.setOnClickListener(){
                binding?.txtChangeable?.setText(etEnterUpdate.text.toString())
                dialog.dismiss()

            }
            dialog.show()

        }


    }
}
