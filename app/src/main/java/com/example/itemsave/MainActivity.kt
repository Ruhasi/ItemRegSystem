package com.example.itemsave

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Validations
        fun validate(): Boolean {

            if (etItemNo.text.toString().isEmpty()) {
                etItemNo.error = "Item name should not be blank"
                return false

            } else if (etItemName.text.toString().isEmpty()) {
                etItemName.error = "Item name should not be empty"
                return false

            } else if (etQty.length() == 0) {
                etQty.error = "Qty should not be empty"
                return false
            } else if (etUnitPrice.length() == 0) {
                etUnitPrice.error = "Unit price should not be empty"
                return false
            }
            return true
        }
            //Total price
            fun calTotal(){

                val val1 = etQty.text.toString().toDouble()
                val val2 = etUnitPrice.text.toString().toDouble()
                val result = val1 * val2

                tvTotalAmount.text = result.toString()

            }



        btnSave.setOnClickListener {
            //Toast.makeText(this@MainActivity, "Saved", Toast.LENGTH_SHORT).show()
            if (validate()) {
                Toast.makeText(this@MainActivity, "Done", Toast.LENGTH_SHORT).show()

                calTotal()
            }




        }

        btnClear.setOnClickListener {

            etItemNo.setText("")
            etItemName.setText("")
            etQty.setText("")
            etUnitPrice.setText("")
            tvTotalAmount.text = ""



        }



    }
}
