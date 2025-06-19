package com.nsj.samplenewsapp.ui.theme

import androidx.compose.ui.graphics.Color

val color_transparent = Color.Transparent

val eligibility_bg_card = Color(0xFFD7ECF5)

val md_theme_light_primary = Color(0xFF7D1D36)//9b4051
val md_theme_light_onPrimary = Color(0xFFFFFFFF)
val md_theme_light_primaryContainer = Color(0xFFE7E0DB)//FFD9dd
val md_theme_light_onPrimaryContainer = Color(0xFF7D1D36)//#7D1D36 : R100 : OLD:0xFF400012
val md_theme_light_secondary = Color(0xFF76565A)
val md_theme_light_onSecondary = Color(0xFFFFFFFF)
val md_theme_light_secondaryContainer = Color(0xFFFFD9DD)
val md_theme_light_onSecondaryContainer = Color(0xFF2C1518)
val md_theme_light_tertiary = Color(0xFF2D7862)
val md_theme_light_onTertiary = Color(0xFFFFFFFF)
val md_theme_light_tertiaryContainer = Color(0xFFFFDDB8)
val md_theme_light_onTertiaryContainer = Color(0xFF2A1700)
val md_theme_light_error = Color(0xFFBA1A1A)
val md_theme_light_errorContainer = Color(0xFFFFDAD6)
val md_theme_light_onError = Color(0xFFFFFFFF)
val md_theme_light_onErrorContainer = Color(0xFF410002)
val md_theme_light_background = Color(0xFFFFFBFF)
val md_theme_light_onBackground = Color(0xFF111111)
val md_theme_light_outline = Color(0xFF847374)
val md_theme_light_inverseOnSurface = Color(0xFFFBEEEE)
val md_theme_light_inverseSurface = Color(0xFF362F2F)
val md_theme_light_inversePrimary = Color(0xFFFFB2BB)
val md_theme_light_surfaceTint = Color(0xFF9B4051)
val md_theme_light_outlineVariant = Color(0xFFD7C1C3)
val md_theme_light_scrim = Color(0xFF000000)
val md_theme_light_surface = Color(0xFFFFF8F7)
val md_theme_light_onSurface = Color(0xFF201A1B)
val md_theme_light_surfaceVariant = Color(0xFFF1EAE5)//FFF4DDDF
val md_theme_light_onSurfaceVariant = Color(0x80111111)//Color(0xFF111111).copy(alpha = 0.5f)//FF524344

val md_theme_dark_primary = Color(0xFFFFB2BB)
val md_theme_dark_onPrimary = Color(0xFF5F1125)
val md_theme_dark_primaryContainer = Color(0xFF7D293A)
val md_theme_dark_onPrimaryContainer = Color(0xFFFFD9DD)
val md_theme_dark_secondary = Color(0xFFE5BDC0)
val md_theme_dark_onSecondary = Color(0xFF43292D)
val md_theme_dark_secondaryContainer = Color(0xFF5C3F43)
val md_theme_dark_onSecondaryContainer = Color(0xFFFFD9DD)
val md_theme_dark_tertiary = Color(0xFFE9BF8F)
val md_theme_dark_onTertiary = Color(0xFF452B07)
val md_theme_dark_tertiaryContainer = Color(0xFF5E411C)
val md_theme_dark_onTertiaryContainer = Color(0xFFFFDDB8)
val md_theme_dark_error = Color(0xFFFFB4AB)
val md_theme_dark_errorContainer = Color(0xFF93000A)
val md_theme_dark_onError = Color(0xFF690005)
val md_theme_dark_onErrorContainer = Color(0xFFFFDAD6)
val md_theme_dark_background = Color(0xFF201A1B)
val md_theme_dark_onBackground = Color(0xFFECE0E0)
val md_theme_dark_outline = Color(0xFF9F8C8E)
val md_theme_dark_inverseOnSurface = Color(0xFF201A1B)
val md_theme_dark_inverseSurface = Color(0xFFECE0E0)
val md_theme_dark_inversePrimary = Color(0xFF9B4051)
val md_theme_dark_surfaceTint = Color(0xFFFFB2BB)
val md_theme_dark_outlineVariant = Color(0xFF524344)
val md_theme_dark_scrim = Color(0xFF000000)
val md_theme_dark_surface = Color(0xFF181212)
val md_theme_dark_onSurface = Color(0xFFD0C4C4)
val md_theme_dark_surfaceVariant = Color(0xFF524344)
val md_theme_dark_onSurfaceVariant = Color(0xFFD7C1C3)

val md_theme_color_card = Color(0xFFE9ECEE)

// Common colors should be added here which is common for both Light/Dark Mode
val md_theme_claret = Color(0xFF601C32)
val md_theme_claret_dark = Color(0xFF2F080F)
val md_theme_claret_dark_splash = Color(0xFF0E0424)


val md_theme_cyan_lime_green = Color(0xFF285548)
val inactive_track_color = Color(0x4DFFFFFF)
val active_track_color = Color(0x80E7E0DB)
val inactive_link = Color(0xFF505050)

val seed = Color(0xFF6F2534)
val light_ = Color(0xFF9B4051)
val light_on = Color(0xFFFFFFFF)
val light_Container = Color(0xFFFFD9DD)
val light_onContainer = Color(0xFF400012)
val dark_ = Color(0xFFFFB2BB)
val dark_on = Color(0xFF5F1125)
val dark_Container = Color(0xFF7D293A)
val dark_onContainer = Color(0xFFFFD9DD)
val service_fee_component_bg = Color(0xFFE9ECEF)
val service_fee_total = Color(0x4D111111)


fun String?.parse() : Color {
    var color = Color.Black
    this?.let{
        if(it.startsWith("#")){
            color = Color(android.graphics.Color.parseColor(it))
        }
    }
    return color
}


