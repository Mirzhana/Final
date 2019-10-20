package supermegadevelopers.ayanamira.mypet

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Button
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

//TODO Something wrong with firebase conncetion

    var fbAuth = FirebaseAuth.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val emailText  = emailEdit.text.toString()
        val passwordText = passwordEdit.text.toString()


        var btnLogin = findViewById<Button>(R.id.loginButton)
        btnLogin.setOnClickListener {view ->
            signIn(view,emailText, passwordText)
        }
    }


    fun signIn(view: View, email: String, password: String){
        showMessage(view,"Authenticating...")
        fbAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, OnCompleteListener<AuthResult> { task ->
            if(task.isSuccessful){
                var intent = Intent(this, MainActivity::class.java)
                intent.putExtra("id", fbAuth.currentUser?.email)
                startActivity(intent)
            }else{
                showMessage(view,"Error: ${task.exception?.message}")
            }
        })
    }
    fun showMessage(view: View, message: String){
        Snackbar.make(view, message, Snackbar.LENGTH_INDEFINITE).setAction("Action", null).show()
    }






}
