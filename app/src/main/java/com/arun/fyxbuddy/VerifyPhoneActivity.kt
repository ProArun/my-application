package com.arun.fyxbuddy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.activity_verify_phone.*
import java.util.concurrent.TimeUnit

class VerifyPhoneActivity : AppCompatActivity() {
    private var varificationId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify_phone)

        layoutPhone.visibility = View.VISIBLE
        layoutVerification.visibility = View.INVISIBLE

        button_send_verification.setOnClickListener {
            //layoutPhone.visibility = View.INVISIBLE
           // layoutVerification.visibility = View.VISIBLE
            val i = Intent(applicationContext,SplashActivity::class.java)
            startActivity(i)
            finish()
        }



        /*button_send_verification.setOnClickListener {
            val phone = edit_text_phone.text.toString().trim()

            if (phone.isEmpty() || phone.length != 10) {
                edit_text_phone.error = "Enter a valid phone"
                edit_text_phone.requestFocus()
                return@setOnClickListener
            }
            val phoneNumber = '+' + ccp.selectedCountryCode + phone
            layoutPhone.visibility = View.VISIBLE
            layoutVerification.visibility = View.INVISIBLE
            PhoneAuthProvider.getInstance()
                .verifyPhoneNumber(
                    phoneNumber,
                    60,
                    TimeUnit.SECONDS,
                    this,
                    phoneAuthCallbacks
                )
           layoutPhone.visibility = View.VISIBLE
            layoutVerification.visibility = View.INVISIBLE
        }

        button_verify.setOnClickListener {

            val code = edit_text_code.text.toString().trim()

            if (code.isEmpty()) {
                edit_text_code.error = "code rewuired"
                edit_text_code.requestFocus()
                return@setOnClickListener
            }
            varificationId?.let {
                val credential = PhoneAuthProvider.getCredential(it, code)

                addPhoneNumber(credential)
            }

        }*/
    }

    /*val phoneAuthCallbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        override fun onVerificationCompleted(phoneAuthCredential: PhoneAuthCredential?) {

            phoneAuthCredential?.let {
                addPhoneNumber(it)
            }

        }

        override fun onVerificationFailed(firebaseException: FirebaseException?) {

            Toast.makeText(this@VerifyPhoneActivity, firebaseException?.message, Toast.LENGTH_LONG)
                .show()

        }

        override fun onCodeSent(
            verificationId: String?,
            token: PhoneAuthProvider.ForceResendingToken?
        ) {
            super.onCodeSent(verificationId, token)
            this@VerifyPhoneActivity.varificationId = verificationId
        }
    }

    private fun addPhoneNumber(phoneAuthCredential: PhoneAuthCredential) {
        FirebaseAuth.getInstance()
            .currentUser?.updatePhoneNumber(phoneAuthCredential)
            ?.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "phone added", Toast.LENGTH_LONG).show()

                } else {
                    Toast.makeText(this, "somthing wents worng", Toast.LENGTH_LONG).show()
                }
            }
    }*/
}