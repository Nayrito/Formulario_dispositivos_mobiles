package com.example.formulario

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private var sex = "Male"
    private var hobbies= ""
    private var birth_day = ""
    private var born_city = ""


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //////////////Calendario////////////////


        btBirth.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)+1
            val day = c.get(Calendar.DAY_OF_MONTH)

            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                // Display Selected date in textbox
                birth_day = ("" + dayOfMonth + " /" + monthOfYear + "/ " + year)
            }, year, month, day)
            dpd.show()
        }




        btSave.setOnClickListener {
            var name = etName.text.toString()
            var pass1 = etPassword.text.toString()
            var pass2 = etPassword2.text.toString()
            var email = etEmail.text.toString()

            born_city= spPlace.selectedItem.toString()


            if(name.isEmpty()) {
                Toast.makeText(this,"Error, fill name",Toast.LENGTH_SHORT).show()
            }else if(pass1.isEmpty() || pass2.isEmpty()){
                    Toast.makeText(this,"Error,fill passwords",Toast.LENGTH_SHORT).show()
                }else if(email.isEmpty()){
                        Toast.makeText(this,"Error, fill email",Toast.LENGTH_SHORT).show()
                    }else if(birth_day.isEmpty()) {
                            Toast.makeText(this, "Error, Fill birth day", Toast.LENGTH_SHORT).show()
                        } else if(hobbies.isEmpty()) {
                                Toast.makeText(this, "Error,select one hobbie at least", Toast.LENGTH_SHORT).show()
                            }else if(sex.isEmpty()){
                                    Toast.makeText(this, "Error,select sex", Toast.LENGTH_SHORT).show()
                                }else if(born_city.equals("City")){
                                        Toast.makeText(this, "Error,select born city", Toast.LENGTH_SHORT).show()
                                    }else if(!pass1.equals(pass2)) {
                                           Toast.makeText(this, "Error,passwords doesn't match", Toast.LENGTH_SHORT).show()
                                        }else{
                tvShow.text = "Name:"+name+"\n"+"Password:"+pass1+"\n"+"Email:"+email+"\n"+"Birth Day:"+birth_day+"\n"+"Hobbies:"+hobbies+"\n"+"Sex:"+sex+"\n"+"Born City:"+ born_city
                hobbies = ""
                                            }



        }
    }
    fun onCheckboxClicked(view: View){
        if (view is CheckBox){
            when (view.id){
                R.id.cbSports ->
                    if (view.isChecked){
                        hobbies += " Sports "
                    }
                R.id.cbCamping->
                    if (view.isChecked){
                        hobbies += " Camping "
                    }
                R.id.cbGames ->
                    if (view.isChecked){
                        hobbies += " Video Games "
                    }
                R.id.cbReading ->
                    if (view.isChecked){
                        hobbies += " Reading "
                    }
            }
        }
    }
    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            when (view.id) {
                R.id.rbMale ->
                    if (view.isChecked) {
                        sex = "Male"
                    }
                R.id.rbFemale ->
                    if (view.isChecked) {
                        sex = "Female"
                    }
            }
        }
    }

}
