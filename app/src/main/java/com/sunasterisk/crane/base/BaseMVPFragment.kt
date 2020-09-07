package com.sunasterisk.crane.base

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.sunasterisk.crane.R
import com.sunasterisk.crane.utils.createProgressDialog
import com.sunasterisk.crane.utils.showSnackBar

abstract class BaseMVPFragment<T> : Fragment(), BaseContract.View<T> {

    private var progressDialog: Dialog? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity) {
            // Assign Activity Component
        }
    }

    override fun showProgressDialog() {
        progressDialog = (context as Activity).createProgressDialog()
    }

    override fun dismissProgressDialog() {
        progressDialog?.dismiss()
    }

    override fun showToastMessage(message: String?) {
        if (!message.isNullOrEmpty())
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
    override fun showToastMessage(stringResourceId: Int) {
        showSnackBarMessage(getString(stringResourceId))
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

    override fun onDestroy() {
        super.onDestroy()
        dismissProgressDialog()
    }
}
