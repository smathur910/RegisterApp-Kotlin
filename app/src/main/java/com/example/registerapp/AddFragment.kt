package com.example.registerapp

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.util.*


class AddFragment : Fragment() {


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val add = inflater.inflate(R.layout.fragment_add, container, false)

        val dbBtn = add.findViewById<Button>(R.id.dobBtn)
        var dobDetail = add.findViewById<TextView>(R.id.dobPick)
        var tmDetail = add.findViewById<TextView>(R.id.timePick)
        val tmBtm = add.findViewById<Button>(R.id.timeBtn)

        var uName = add.findViewById<EditText>(R.id.userName)
        var uEmail = add.findViewById<EditText>(R.id.userEmail)
        var uGender = add.findViewById<RadioGroup>(R.id.userGender)
        var uCondition = add.findViewById<CheckBox>(R.id.uCheckBox)
        var btn = add.findViewById<Button>(R.id.okBtn)


        fun validUser(): Boolean {
            val userName = uName.text.toString().trim { it <= ' ' }
            return if (!userName.isEmpty()) {
                if (userName.length >= 5 && userName.length <= 30) {
                    true
                } else {
                    uName.error = "Please enter valid Username"
                    false
                }
            } else {
                uName.error = "Please enter a Username"
                true
            }
        }

        fun validEmail(): Boolean {
            val userEmail = uEmail.text.toString().trim { it <= ' ' }
            val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
            return if (userEmail.isEmpty()) {
                uEmail.error = "Please enter Email"
                false
            } else if (!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()) {
                uEmail.error = "Please enter valid Email"
                false
            } else {
                uEmail.error = null
                true
            }
        }

        fun validateGender(): Boolean {


            return if (uGender.checkedRadioButtonId == -1) {
                Toast.makeText(requireContext(), "Please Select Gender", Toast.LENGTH_SHORT).show()
                false
            } else {

                true
            }
        }

        fun validateCheck(): Boolean {
            return if (uCondition.isChecked) {
                true
            } else {
                Toast.makeText(requireContext(), "Please Select T&C", Toast.LENGTH_SHORT).show()
                false
            }
        }


        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)




        dbBtn.setOnClickListener{
            val dpd = DatePickerDialog( requireContext(), DatePickerDialog.OnDateSetListener{view, mYear, mMonth, mDay ->
                dobDetail.text = ""+mDay+"/"+mMonth+"/"+mYear
            }, year, month, day )
            dpd.show()
        }

        tmBtm.setOnClickListener{
            val timeSetListener = TimePickerDialog.OnTimeSetListener{view: TimePicker?, hourOfDay: Int, minute: Int ->
                c.set(Calendar.HOUR_OF_DAY, hourOfDay)
                c.set(Calendar.MINUTE, minute)

                tmDetail.text = SimpleDateFormat("HH:mm").format(c.time)

            }
            TimePickerDialog(requireContext(), timeSetListener, c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), false).show()
        }


        btn.setOnClickListener{
            if(!validUser() or !validEmail() or !validateGender() or !validateCheck()){
                return@setOnClickListener
            }
        }


        return add
    }



}