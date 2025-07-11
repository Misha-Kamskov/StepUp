package com.mkam.presentation

enum class AccountSetting(val title: String, val icon: Int) {
    PROFILE("Profile Setting", R.drawable.icon_profile),
    NOTIFICATIONS("Notification Setting", R.drawable.icon_notification),
    SHIPPING("Shipping Address", R.drawable.icon_cart),
    PAYMENT("Payment Info", R.drawable.icon_payment),
    DELETE("Delete Account", com.mkam.theme.R.drawable.icon_bin)
}
