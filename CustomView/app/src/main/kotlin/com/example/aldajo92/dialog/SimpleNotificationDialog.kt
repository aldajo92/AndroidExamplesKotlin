package com.example.aldajo92.dialog;

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.RelativeLayout
import com.example.aldajo92.customview.R

@SuppressLint("ViewConstructor")
class SimpleNotificationDialog<T : Any> private constructor(context: Context) : FrameLayout(context) {

    var preDescription : String = ""
    var title : String = ""
    var description : String = ""
    var address : String = ""
    var primaryButtonText : String = ""
    lateinit var productImage : Drawable
    lateinit var addressImage : Drawable

    var hasPreDescription : Boolean = false
    var hasTitle : Boolean = false
    var hasAddress : Boolean = false
    var hasDescription : Boolean = false
    var hasProductImage : Boolean = false
    var hasAddressImage : Boolean = false

    private var data: T? = null

    init {
//        val binding = DataBindingUtil.inflate<DialogSimpleNotificationBinding>(LayoutInflater.from(context),
//                R.layout.dialog_simple_notification, this, false)
//
//        binding.view = this
//
//        layoutParams = ViewGroup.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
//                RelativeLayout.LayoutParams.MATCH_PARENT)
//        isClickable = true
//        setBackgroundResource(R.color.black_transparent_4)
//        ViewUtil.setElevation(this, resources.getDimensionPixelSize(R.dimen.spacing_xlarge))
//
//        val margin = resources.getDimensionPixelSize(R.dimen.spacing_xxlarge)
//        val layoutParams = LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
//                RelativeLayout.LayoutParams.WRAP_CONTENT)
//        layoutParams.setMargins(margin, 0, margin, 0)
//        layoutParams.gravity = Gravity.CENTER
//        addView(binding.root, layoutParams)
//
//        setOnClickListener { dismissDialog() }
    }

    private constructor(context: Context, builder: Builder<T>) : this(context) {
        if (builder.preDescription.isNotBlank()) {
            preDescription = builder.preDescription
            hasPreDescription = true
        }
        if (builder.title.isNotBlank()) {
            title = builder.title
            hasTitle = true
        }
        if (builder.description.isNotBlank()) {
            description = builder.description
            hasDescription = true
        }
        if (builder.address.isNotBlank()) {
            address = builder.address
            hasAddress = true
        }
//        builder.productImage?.let {
//            productImage = builder.productImage
//            hasProductImage = true
//        }
//        builder.addressImage?.let {
//            addressImage = builder.addressImage
//            hasAddressImage = true
//        }
        primaryButtonText = builder.primaryButton
        data = builder.data
    }

    fun dismissDialog() {
        (parent as ViewGroup).removeView(this)
    }

    companion object {
        class Builder<T : Any> constructor(private val context: Context) {
            lateinit var preDescription: String
            lateinit var title: String
            var description: String = ""
            var address: String = ""
            var productImage: Drawable? = null
            var addressImage: Drawable? = null
            lateinit var primaryButton: String
            var data: T? = null

            fun preDescription(preDescription: String) = apply { this.preDescription = preDescription }

            fun preDescription(@StringRes resId: Int) = apply { this.preDescription = context.getString(resId) }

            fun title(title: String) = apply { this.title = title }

            fun title(@StringRes resId: Int) = apply { this.title = context.getString(resId) }

            fun description(description: String) = apply { this.description = description }

            fun description(@StringRes resId: Int) = apply { this.description = context.getString(resId) }

            fun address(address: String) = apply { this.address = address }

            fun address(@StringRes resId: Int) = apply { this.address = context.getString(resId) }

            fun addressImage(image: Drawable) = apply { this.addressImage = image }

            fun addressImage(@DrawableRes resId: Int) = apply { this.addressImage = ContextCompat.getDrawable(context, resId) }

            fun productImage(image: Drawable) = apply { this.productImage = image }

            fun productImage(@DrawableRes resId: Int) = apply { this.productImage = ContextCompat.getDrawable(context, resId) }

            fun primaryButton(primaryButton: String) = apply { this.primaryButton = primaryButton }

            fun primaryButton(@StringRes resId: Int) = apply { this.primaryButton = context.getString(resId) }

            fun data(data: T) = apply { this.data = data }

            fun build() = SimpleNotificationDialog(context, this)
        }
    }

}
