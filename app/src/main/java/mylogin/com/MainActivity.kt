package mylogin.com

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.Log
import android.widget.TextView
import com.example.activityhome.HomeActivity


class MainActivity : AppCompatActivity() {

    lateinit var usernameInput : EditText
    lateinit var passwordInput : EditText
    lateinit var loginBtn : Button
    lateinit var twregister :  TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        usernameInput = findViewById(R.id.username_input)
        passwordInput = findViewById(R.id.password_input)
        loginBtn = findViewById(R.id.login_btn)
        twregister=findViewById(R.id.register_link)


        twregister.setOnClickListener {
            val intent=Intent(this,RegistroActivity::class.java)
            startActivity(intent)
        }



        loginBtn.setOnClickListener{
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()
            Log.i( "Test Credentials", "Username : $username and Password : $password")
            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)

        }



    }
}