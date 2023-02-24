package my.edu.tarc.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import org.w3c.dom.Text
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Linking between UI and code
        val imageViewBMI: ImageView = findViewById(R.id.imageView2)
        val editTextNumberWeight : EditText = findViewById(R.id.editTextWeight)
        val editTextNumberHeight : EditText = findViewById(R.id.editTextNumberHeight)
        val buttonCalculate: Button = findViewById(R.id.buttonCalculate)
        val buttonReset : Button = findViewById(R.id.buttonReset)
        val textViewStatus : TextView = findViewById(R.id.textViewStatus)
        val textViewBMI : TextView = findViewById(R.id.textViewBMI)

        buttonCalculate.setOnClickListener {
            if(editTextNumberWeight.text.isEmpty()){
                editTextNumberWeight.setError(getString(R.string.value_required))
                return@setOnClickListener
            }

            if(editTextNumberHeight.text.isEmpty()){
                editTextNumberHeight.setError(getString(R.string.value_required))
                return@setOnClickListener
            }

            var weight = editTextNumberWeight.text.toString().toFloat()
            var height = editTextNumberHeight.text.toString().toFloat()
            var bmi = weight/(height/100).pow(2)
            //BodyMassIndex: 18.42
            textViewBMI.text = String.format("%S : %.2f",getString(R.string.bmi), bmi)
            if(bmi < 18.5){
                imageViewBMI.setImageResource(R.drawable.under)

                textViewStatus.text = String.format("%s : %s", getString(R.string.status),getString(R.string.under))
            }else if(bmi > 18.5 && bmi<24.9){
                imageViewBMI.setImageResource(R.drawable.normal)

                textViewStatus.text = String.format("%s : %s", getString(R.string.status),getString(R.string.normal))
            }else if(bmi > 25){
                imageViewBMI.setImageResource(R.drawable.over)

                textViewStatus.text = String.format("%s : %s", getString(R.string.status),getString(R.string.over))
            }


        }

        buttonReset.setOnClickListener {
            editTextNumberHeight.text.clear()
            editTextNumberWeight.text.clear()
            imageViewBMI.setImageResource(R.drawable.empty)
            textViewBMI.text = getString(R.string.bmi)
            textViewStatus.text = getString(R.string.status)
        }

    }
}