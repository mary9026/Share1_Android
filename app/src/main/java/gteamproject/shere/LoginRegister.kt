package gteamproject.shere

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView

class LoginRegister : AppCompatActivity() {

    lateinit var textSign : TextView
    lateinit var textRegister : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_register)

        initvar()

        setFrag(0)

        textSign.setOnClickListener {
            setFrag(0)
        }

        textRegister.setOnClickListener {
            setFrag(1)
        }


    }

    fun initvar() {
        textSign = findViewById(R.id.textSign)
        textRegister = findViewById(R.id.textRegister)
    }

    private fun setFrag(i: Int) {
        val ft = supportFragmentManager.beginTransaction()
        when(i)
        {
            0 -> {
                ft.replace(R.id.main_frame, Frag_Login()).commit()
            }
            1 -> {
                ft.replace(R.id.main_frame, Frag_Register()).commit()
            }
        }

    }





}

