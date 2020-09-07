package com.sunasterisk.crane.base

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.sunasterisk.crane.R
import com.sunasterisk.crane.utils.createProgressDialog
import com.sunasterisk.crane.utils.showSnackBar

abstract class BaseMVPActivity<T> : AppCompatActivity(), BaseContract.View<T> {

    private var progressDialog: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        this.intent = intent
    }

    override fun showProgressDialog() {
        progressDialog = createProgressDialog()
    }

    override fun dismissProgressDialog() {
        progressDialog?.dismiss()
    }

    override fun showToastMessage(message: String?) {
        if (!message.isNullOrEmpty())
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showToastMessage(stringResourceId: Int) {
        showToastMessage(getString(stringResourceId))
    }

    override fun showSnackBarMessage(message: String?) {
        if (!message.isNullOrEmpty())
            showSnackBarMessage(message)
    }

    override fun showSnackBarMessage(stringResourceId: Int) {
        showSnackBarMessage(getString(stringResourceId))
    }

    override fun onError(message: String?) {
        if (message != null) {
            (this as View).showSnackBar(message, Snackbar.LENGTH_SHORT)
        } else {
            (this as View).showSnackBar(getString(R.string.error_default_message), Snackbar.LENGTH_SHORT)
        }
    }

    override fun onError(resId: Int) {
        onError(getString(resId))
    }

    override fun onStop() {
        super.onStop()
        dismissProgressDialog()
    }

    override fun onDestroy() {
        super.onDestroy()
        dismissProgressDialog()
    }
}
