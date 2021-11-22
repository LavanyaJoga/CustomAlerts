package com.example.kotlincustomalerts

import android.app.Activity
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.Paint
import android.graphics.drawable.GradientDrawable
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import com.google.android.material.bottomsheet.BottomSheetDialog
import android.graphics.drawable.shapes.RectShape

import android.graphics.drawable.ShapeDrawable




class Alert {

    companion object {
        public fun alertWithOneButton(
            activity: Activity,
            dialogShape: String,
            alertTitle: String,
            alertTitleColor: Int,
            alertTitleTextSize:Float,
            message: String,
            messageColor: Int,
            singleButtonText: String,
            singleButtonShape: String,
            singleButtonBackgroundColor: Int,
            singleButtonCornersRadius: Float,
            singleButtonTextColor: Int
        ) {
            if (!(activity as Activity?)?.isFinishing()!!) {
                val view: View = activity.getLayoutInflater().inflate(
                    R.layout.common_bottom,
                    LinearLayout(activity), false
                )
                var dialog: BottomSheetDialog
                if (dialogShape.equals("rectangle")) {
                    dialog = BottomSheetDialog(activity, R.style.BottomSheetDialogStyle2)
                } else {
                    dialog = BottomSheetDialog(activity, R.style.BottomSheetDialogStyle)
                }

                val btOk: AppCompatButton = view.findViewById(R.id.btOk)

                val tvTitle: AppCompatTextView = view.findViewById(R.id.textTitle)
                val tvContent: AppCompatTextView = view.findViewById(R.id.tvContent)
                tvTitle.setText(alertTitle)
                tvTitle.setTextColor(alertTitleColor)
                tvTitle.textSize=alertTitleTextSize
                tvContent.setText(message)
                tvContent.setTextColor(messageColor)
                btOk.text = singleButtonText
                if (singleButtonShape.equals("rectangle")) {
                    val shape = GradientDrawable()
                    shape.shape = GradientDrawable.RECTANGLE
                    shape.setColor(singleButtonBackgroundColor)
                    shape.setCornerRadius(singleButtonCornersRadius);
                    shape.setStroke(1, singleButtonBackgroundColor)
                    btOk.setBackground(shape)
                } else if (singleButtonShape.equals("oval")) {
                    val shape = GradientDrawable()
                    shape.shape = GradientDrawable.OVAL
                    shape.setColor(singleButtonBackgroundColor)
                    shape.setStroke(1, singleButtonBackgroundColor)
                    shape.setCornerRadius(singleButtonCornersRadius);
                    btOk.setBackground(shape)
                } else {
//                    btOk.setBackgroundColor(singleButtonBackgroundColor)
                    val shape = GradientDrawable()
                    shape.shape = GradientDrawable.RECTANGLE
                    shape.setColor(singleButtonBackgroundColor)
                    shape.setStroke(1, singleButtonBackgroundColor)
                    shape.setCornerRadius(singleButtonCornersRadius);
                    btOk.setBackground(shape)


//
                }
//                btOk.setBackgroundColor(singleButtonBackgroundColor)
                btOk.setTextColor(singleButtonTextColor)
                dialog.setContentView(view)
                dialog.setCancelable(false)
                if (!activity.isFinishing()) {
                    if (dialog.isShowing()) {
                        dialog.dismiss()
                    }
                    if (!dialog.isShowing()) {
                        dialog.show();
                    }
                }
                btOk.setOnClickListener(View.OnClickListener {
                    if (!activity.isFinishing()) {
                        if (dialog.isShowing()) {
                            dialog.dismiss()
                        }
                    }
                })

            }
        }


        fun confirmationAlertWithOneButton(
            activity: Activity,
            dialogShape: String,
            alertTitle: String,
            alertTitleColor: Int,
            alertTitleTextSize:Float,
            message: String,
            messageColor: Int,
            singleButtonText: String,
            singleButtonShape: String,
            singleButtonBackgroundColor: Int,
            singleButtonCornersRadius: Float,
            singleButtonTextColor: Int,
            confirmationListener: ConformListener
        ) {
            if (!(activity as Activity?)?.isFinishing()!!) {
                val view: View = activity.getLayoutInflater().inflate(
                    R.layout.common_bottom,
                    LinearLayout(activity), false
                )
                var dialog: BottomSheetDialog
                if (dialogShape.equals("rectangle")) {
                    dialog = BottomSheetDialog(activity, R.style.BottomSheetDialogStyle2)
                } else {
                    dialog = BottomSheetDialog(activity, R.style.BottomSheetDialogStyle)
                }

                val btOk: AppCompatButton = view.findViewById(R.id.btOk)

                val tvTitle: AppCompatTextView = view.findViewById(R.id.textTitle)
                val tvContent: AppCompatTextView = view.findViewById(R.id.tvContent)
                tvTitle.setText(alertTitle)
                tvTitle.setTextColor(alertTitleColor)
                tvTitle.textSize= alertTitleTextSize
                tvContent.setText(message)
                tvContent.setTextColor(messageColor)
                btOk.text = singleButtonText
                if (singleButtonShape.equals("rectangle")) {
                    val shape = GradientDrawable()
                    shape.shape = GradientDrawable.RECTANGLE
                    shape.setColor(singleButtonBackgroundColor)
                    shape.setCornerRadius(singleButtonCornersRadius);
                    shape.setStroke(1, singleButtonBackgroundColor)
                    btOk.setBackground(shape)
                } else if (singleButtonShape.equals("oval")) {
                    val shape = GradientDrawable()
                    shape.shape = GradientDrawable.OVAL
                    shape.setColor(singleButtonBackgroundColor)
                    shape.setStroke(1, singleButtonBackgroundColor)
                    shape.setCornerRadius(singleButtonCornersRadius);
                    btOk.setBackground(shape)
                } else {
//                    btOk.setBackgroundColor(singleButtonBackgroundColor)
                    val shape = GradientDrawable()
                    shape.shape = GradientDrawable.RECTANGLE
                    shape.setColor(singleButtonBackgroundColor)
                    shape.setStroke(1, singleButtonBackgroundColor)
                    shape.setCornerRadius(singleButtonCornersRadius);
                    btOk.setBackground(shape)


//
                }
//                btOk.setBackgroundColor(singleButtonBackgroundColor)
                btOk.setTextColor(singleButtonTextColor)
                dialog.setContentView(view)
                dialog.setCancelable(false)
                if (!activity.isFinishing()) {
                    if (dialog.isShowing()) {
                        dialog.dismiss()
                    }
                    if (!dialog.isShowing()) {
                        dialog.show();
                    }
                }
                btOk.setOnClickListener(View.OnClickListener {
                    if (dialog.isShowing) {
                        dialog.dismiss()
                        confirmationListener.confirmed()
                    }
                })

            }
        }


        fun confirmationAlertWithTwoButton(
            activity: Activity,
            dialogShape: String,
            alertTitle: String,
            alertTitleColor: Int,
            alertTitleTextSize:Float,
            message: String,
            messageColor: Int,
            firstButtonText: String,
            firstButtonShape: String,
            firstButtonBackgroundColor: Int,
            firstButtonCornersRadius: Float,
            firstButtonTextColor: Int,
            firstConfirmationListener: ConformListener,
            secondButtonText: String,
            secondButtonShape: String,
            secondButtonBackgroundColor: Int,
            secondButtonCornersRadius: Float,
            secondButtonTextColor: Int,
            secondConfirmationListener: ConformListener
        ) {
            if (!(activity as Activity?)?.isFinishing()!!) {
                val view: View = activity.getLayoutInflater().inflate(
                    R.layout.common_alert_cancel,
                    LinearLayout(activity), false
                )
                var dialog: BottomSheetDialog
                if (dialogShape.equals("rectangle")) {
                    dialog = BottomSheetDialog(activity, R.style.BottomSheetDialogStyle2)
                } else {
                    dialog = BottomSheetDialog(activity, R.style.BottomSheetDialogStyle)
                }

                val btOk: AppCompatButton = view.findViewById(R.id.btOk)
                val btcancel: AppCompatButton = view.findViewById(R.id.btcancel)
                val tvTitle: AppCompatTextView = view.findViewById(R.id.textTitle)
                val tvContent: AppCompatTextView = view.findViewById(R.id.tvContent)
                tvTitle.setText(alertTitle)
                tvTitle.setTextColor(alertTitleColor)
                tvTitle.textSize= alertTitleTextSize
                tvContent.setText(message)
                tvContent.setTextColor(messageColor)
                btOk.text = firstButtonText
                if (firstButtonShape.equals("rectangle")) {
                    val shape = GradientDrawable()
                    shape.shape = GradientDrawable.RECTANGLE
                    shape.setColor(firstButtonBackgroundColor)
                    shape.setCornerRadius(firstButtonCornersRadius);
                    shape.setStroke(1, firstButtonBackgroundColor)
                    btOk.setBackground(shape)
                } else if (firstButtonShape.equals("oval")) {
                    val shape = GradientDrawable()
                    shape.shape = GradientDrawable.OVAL
                    shape.setColor(firstButtonBackgroundColor)
                    shape.setStroke(1, firstButtonBackgroundColor)
                    shape.setCornerRadius(firstButtonCornersRadius);
                    btOk.setBackground(shape)
                } else {
//                    btOk.setBackgroundColor(singleButtonBackgroundColor)
                    val shape = GradientDrawable()
                    shape.shape = GradientDrawable.RECTANGLE
                    shape.setColor(firstButtonBackgroundColor)
                    shape.setStroke(1, firstButtonBackgroundColor)
                    shape.setCornerRadius(firstButtonCornersRadius);
                    btOk.setBackground(shape)


//
                }
//                btOk.setBackgroundColor(singleButtonBackgroundColor)
                btOk.setTextColor(firstButtonTextColor)




                btcancel.text = secondButtonText
                if (secondButtonShape.equals("rectangle")) {
                    val shape = GradientDrawable()
                    shape.shape = GradientDrawable.RECTANGLE
                    shape.setColor(secondButtonBackgroundColor)
                    shape.setCornerRadius(secondButtonCornersRadius);
                    shape.setStroke(1, secondButtonBackgroundColor)
                    btcancel.setBackground(shape)
                } else if (secondButtonShape.equals("oval")) {
                    val shape = GradientDrawable()
                    shape.shape = GradientDrawable.OVAL
                    shape.setColor(secondButtonBackgroundColor)
                    shape.setStroke(1, secondButtonBackgroundColor)
                    shape.setCornerRadius(secondButtonCornersRadius);
                    btcancel.setBackground(shape)
                } else {
                    val shape = GradientDrawable()
                    shape.shape = GradientDrawable.RECTANGLE
                    shape.setColor(secondButtonBackgroundColor)
                    shape.setStroke(1, secondButtonBackgroundColor)
                    shape.setCornerRadius(secondButtonCornersRadius);
                    btcancel.setBackground(shape)

                }
                btcancel.setTextColor(secondButtonTextColor)




                dialog.setContentView(view)
                dialog.setCancelable(false)
                if (!activity.isFinishing()) {
                    if (dialog.isShowing()) {
                        dialog.dismiss()
                    }
                    if (!dialog.isShowing()) {
                        dialog.show();
                    }
                }
                btOk.setOnClickListener(View.OnClickListener {
                    if (dialog.isShowing) {
                        dialog.dismiss()
                        firstConfirmationListener.confirmed()
                    }
                })
                btcancel.setOnClickListener(View.OnClickListener {
                    if (dialog.isShowing) {
                        dialog.dismiss()
                        secondConfirmationListener.confirmed()
                    }
                })

            }
        }



        fun confirmationAlertWithThreeButtons(
            activity: Activity,
            dialogShape: String,
            alertTitle: String,
            alertTitleColor: Int,
            alertTitleTextSize:Float,
            message: String,
            messageColor: Int,
            firstButtonText: String,
            firstButtonShape: String,
            firstButtonBackgroundColor: Int,
            firstButtonCornersRadius: Float,
            firstButtonTextColor: Int,
            firstConfirmationListener: ConformListener,
            secondButtonText: String,
            secondButtonShape: String,
            secondButtonBackgroundColor: Int,
            secondButtonCornersRadius: Float,
            secondButtonTextColor: Int,
            secondConfirmationListener: ConformListener,
            thirdButtonText: String,
            thirdButtonShape: String,
            thirdButtonBackgroundColor: Int,
            thirdButtonCornersRadius: Float,
            thirdButtonTextColor: Int,
            thirdConfirmationListener: ConformListener
        ) {
            if (!(activity as Activity?)?.isFinishing()!!) {
                val view: View = activity.getLayoutInflater().inflate(
                    R.layout.common_alert_with_buttons,
                    LinearLayout(activity), false
                )
                var dialog: BottomSheetDialog
                if (dialogShape.equals("rectangle")) {
                    dialog = BottomSheetDialog(activity, R.style.BottomSheetDialogStyle2)
                } else {
                    dialog = BottomSheetDialog(activity, R.style.BottomSheetDialogStyle)
                }

                val btOk: AppCompatButton = view.findViewById(R.id.btOk)
                val btcancel: AppCompatButton = view.findViewById(R.id.btcancel)
                val btextra: AppCompatButton = view.findViewById(R.id.btextra)
                val tvTitle: AppCompatTextView = view.findViewById(R.id.textTitle)
                val tvContent: AppCompatTextView = view.findViewById(R.id.tvContent)
                tvTitle.setText(alertTitle)
                tvTitle.setTextColor(alertTitleColor)
                tvTitle.textSize= alertTitleTextSize
                tvContent.setText(message)
                tvContent.setTextColor(messageColor)
                btOk.text = firstButtonText
                if (firstButtonShape.equals("rectangle")) {
                    val shape = GradientDrawable()
                    shape.shape = GradientDrawable.RECTANGLE
                    shape.setColor(firstButtonBackgroundColor)
                    shape.setCornerRadius(firstButtonCornersRadius);
                    shape.setStroke(1, firstButtonBackgroundColor)
                    btOk.setBackground(shape)
                } else if (firstButtonShape.equals("oval")) {
                    val shape = GradientDrawable()
                    shape.shape = GradientDrawable.OVAL
                    shape.setColor(firstButtonBackgroundColor)
                    shape.setStroke(1, firstButtonBackgroundColor)
                    shape.setCornerRadius(firstButtonCornersRadius);
                    btOk.setBackground(shape)
                } else {
//                    btOk.setBackgroundColor(singleButtonBackgroundColor)
                    val shape = GradientDrawable()
                    shape.shape = GradientDrawable.RECTANGLE
                    shape.setColor(firstButtonBackgroundColor)
                    shape.setStroke(1, firstButtonBackgroundColor)
                    shape.setCornerRadius(firstButtonCornersRadius);
                    btOk.setBackground(shape)


//
                }
//                btOk.setBackgroundColor(singleButtonBackgroundColor)
                btOk.setTextColor(firstButtonTextColor)




                btcancel.text = secondButtonText
                if (secondButtonShape.equals("rectangle")) {
                    val shape = GradientDrawable()
                    shape.shape = GradientDrawable.RECTANGLE
                    shape.setColor(secondButtonBackgroundColor)
                    shape.setCornerRadius(secondButtonCornersRadius);
                    shape.setStroke(1, secondButtonBackgroundColor)
                    btcancel.setBackground(shape)
                } else if (secondButtonShape.equals("oval")) {
                    val shape = GradientDrawable()
                    shape.shape = GradientDrawable.OVAL
                    shape.setColor(secondButtonBackgroundColor)
                    shape.setStroke(1, secondButtonBackgroundColor)
                    shape.setCornerRadius(secondButtonCornersRadius);
                    btcancel.setBackground(shape)
                } else {
                    val shape = GradientDrawable()
                    shape.shape = GradientDrawable.RECTANGLE
                    shape.setColor(secondButtonBackgroundColor)
                    shape.setStroke(1, secondButtonBackgroundColor)
                    shape.setCornerRadius(secondButtonCornersRadius);
                    btcancel.setBackground(shape)

                }
                btcancel.setTextColor(secondButtonTextColor)


                btextra.text = thirdButtonText
                if (thirdButtonShape.equals("rectangle")) {
                    val shape = GradientDrawable()
                    shape.shape = GradientDrawable.RECTANGLE
                    shape.setColor(thirdButtonBackgroundColor)
                    shape.setCornerRadius(thirdButtonCornersRadius);
                    shape.setStroke(1, thirdButtonBackgroundColor)
                    btextra.setBackground(shape)
                } else if (thirdButtonShape.equals("oval")) {
                    val shape = GradientDrawable()
                    shape.shape = GradientDrawable.OVAL
                    shape.setColor(thirdButtonBackgroundColor)
                    shape.setStroke(1, thirdButtonBackgroundColor)
                    shape.setCornerRadius(thirdButtonCornersRadius);
                    btextra.setBackground(shape)
                } else {
                    val shape = GradientDrawable()
                    shape.shape = GradientDrawable.RECTANGLE
                    shape.setColor(thirdButtonBackgroundColor)
                    shape.setStroke(1, thirdButtonBackgroundColor)
                    shape.setCornerRadius(thirdButtonCornersRadius);
                    btextra.setBackground(shape)

                }
                btextra.setTextColor(thirdButtonTextColor)



                dialog.setContentView(view)
                dialog.setCancelable(false)
                if (!activity.isFinishing()) {
                    if (dialog.isShowing()) {
                        dialog.dismiss()
                    }
                    if (!dialog.isShowing()) {
                        dialog.show();
                    }
                }
                btOk.setOnClickListener(View.OnClickListener {
                    if (dialog.isShowing) {
                        dialog.dismiss()
                        firstConfirmationListener.confirmed()
                    }
                })
                btcancel.setOnClickListener(View.OnClickListener {
                    if (dialog.isShowing) {
                        dialog.dismiss()
                        secondConfirmationListener.confirmed()
                    }
                })
                btextra.setOnClickListener(View.OnClickListener {
                    if (dialog.isShowing) {
                        dialog.dismiss()
                        thirdConfirmationListener.confirmed()
                    }
                })

            }
        }

    }


}