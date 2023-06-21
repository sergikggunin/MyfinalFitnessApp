package com.example.myfinalfitnessapp.utils

import android.content.Context
import android.app.AlertDialog
import com.example.myfinalfitnessapp.R

object DialogManager {
    fun showDialog(context: Context, mId: Int, listener: Listener) {
        val builder = AlertDialog.Builder(context)
        var dialog: AlertDialog? = null
        builder.setTitle(R.string.alert)
        builder.setMessage(mId)
        builder.setPositiveButton(R.string.reset) { _, _ ->
            listener.onClick()
            dialog?.dismiss()
        }
        builder.setNegativeButton(R.string.back) { _, _ ->
            dialog?.dismiss()
        }
        dialog = builder.create()
        dialog.show()
    }

    interface Listener {
        fun onClick()
    }
}

