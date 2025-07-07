package com.nsj.samplenewsapp.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

/**
 * ExColor Temporary class for grouping to avoid constructor limitation, please refactor in appreciate groups
 */
@Immutable
class ExColor(
    val componentToastBgDefault: Color, // 0xFF151414 0xFF3F3D3D
    val bgPrimarySoft: Color, // 0x4DBB4E6B 0x80BB4E6B
    val componentsSegmentedControlTabBg: Color // 0xFFFFFFFF 0x29FFFFFF
)

@Immutable
class AppColorScheme(

    val surfaceZero: Color,
    val confirmationBackground: Color,
    val emphasisFullInverse: Color,
    val emphasisInverse: Color,
    val emphasis: Color,
    val onEmphasis: Color,
    //  val emphasis65: Color,
    val emphasis50: Color,
    val emphasis25: Color,
    val neutral: Color,
    val secondaryInverse: Color,
    val secondary: Color,
    val onSecondary: Color,
    val secondary75: Color,
    val secondary25: Color,
    val primary: Color,
    val onPrimary: Color,
    val primaryContainer: Color,
    val onPrimaryContainer: Color,
    val primaryContainerLight: Color,
    val successStrong: Color,
    val success: Color,
    val successExtraLight: Color,
    val positiveDefault: Color,
    val positiveSoft: Color,
    val warningExtraStrong: Color,
    val warning: Color,
    val onWarningMedium: Color,
    val error: Color,
    val errorPressed: Color,
    val onError: Color,
    val errorExtraLight: Color,
    val information: Color,
    val onInformation: Color,
    val onPrivacyLight: Color,
    val hybridChipIndicator: Color,
    val warningBannerBorder: Color,
    val componentSpinner100M: Color,
    val componentSpinner0M: Color,
    val componentSpinner100W: Color,
    val componentSpinner0W: Color,
    val textSystemNegativeStronger: Color,
    val textSystemWarningStrong: Color,
    val textSystemWarningStronger: Color,
    val textFixedWhiteHighEmphasis: Color,
    val textFixedWhiteMediumEmphasis: Color,
    val textFixedWhiteLowEmphasis: Color,
    val textFixedBlackHighEmphasis: Color,
    val textFixedBlackMediumEmphasis: Color,
    val textSystemPositiveStronger: Color,
    val textSystemInfoStronger: Color,
    val bgSystemNegativeSoft: Color,
    val bgSystemNegativeSofter: Color,
    val bgSystemNegativeSoftest: Color, //0xFFF9E9E9  0xFF340303
    val bgSystemWarningHover: Color,
    val bgSystemWarningSofter: Color,
    val bgSystemWarningSoft: Color,
    val bgSystemPositiveSoft: Color,
    val bgSystemPositiveSofter: Color,
    val bgSystemPositiveSoftest: Color, //0xFFE3ECE6 0xFF092014
    val bgSystemPositiveDefault: Color,
    val bgSystemPositivePress: Color,
    val bgSystemInfoSoft: Color,
    val bgSystemInfoSofter: Color,
    val bgSystemInfoDefault: Color,
    val bgSystemInfoStrong: Color,
    val componentsShimmerBg: Color,
    val componentsShimmerGradient0: Color,
    val componentsShimmerGradient100: Color,
    //Home screen
    val bgHomeMorningGradient: Color,
    val bgHomeAfternoonGradient: Color,
    val bgHomeEveningGradient: Color,
    //Bottom Navigation
    val bgBottomNavigation: Color,
    val bgBottomNavSelected: Color,
    val bgBottomNavNormal: Color,
    //Background color for popup-window or dialog
    val bgPopupWindow: Color,

    //*********************************************************************
    //Alpha - 100% High : FF, 68% Medium: AD, 50% Low: 80, 12% LOW: 1F, 32% Disabled: 52
    //*********************************************************************

    // Text Colors Token
    val textHighEmphasis: Color, //0xFF000000 0xFFFFFFFF
    val textMediumEmphasis: Color, //0xAD000000 0xADFFFFFF
    val textLowEmphasis: Color, //0x80000000 0x80FFFFFF
    val textDisabled: Color, // 0x52000000 0x52FFFFFF
    val textPrimaryDefault: Color, //0xFF7D1D36 0xFFDC8998
    val textPrimaryStrong: Color, //#E1A7B0 #5B1120
    val textPrimaryStronger: Color, // 0xFF35121B 0xFFE7C5CA
    val textInvertHighEmphasis: Color, //0xFFFFFFFF 0xFF000000
    val textSystemNegativeDefault: Color, //0xFFBF2121  0xFFE27575
    val textSystemPositiveDefault: Color, //0xFF337654  0xFF54A178
    val textSystemNegativeStrong: Color, //0xFF941717  0xFFEDAAAA
    //Text Colors Fixed: ****IT WILL BE SAME ACROSS THEME****

    //Background Colors Token
    val bgCard: Color, // 0xFFFFFFFF 0x0AFFFFFF
    val bgPrimaryDefault: Color, // 0xFF7D1D36 0xFF9B2645
    val bgPrimaryPress: Color, // 0xFF35121B 0xFF5B1120
    val bgPrimarySoftest: Color, // 0x1ABB4E6B 0x33BB4E6B
    val bgFixedWhite: Color, // 0xFFFFFFFF
    val bgCardBlur: Color, // 0x69000000
    val bgElevation1: Color, // 0xFFF9F8F8 0xFF151414
    val bgElevationPlus1: Color, // 0xE5FFFFFF 0xE52E2C2C
    val bgNeutral: Color, // 0xFF000000 0xFFFFFFFF
    val bgNeutral5: Color, // 0x0D000000 0x0AFFFFFF
    val bgNeutral8: Color, // 0x14000000 0x14FFFFFF
    val bgNeutral100: Color, // 0x00000000 0xFFFFFFFF
    val bgSecondarySaffron: Color, // 0xFFD48320
    val bgSecondaryMidnight: Color, // 0xFF162F55 0xFF193B6B
    val bgSystemInfoSoftest: Color, //0xFFDCE4F9 0xFF0A1B35
    val bgSystemWarningSoftest: Color, //0xFFFDEEDA 0xFF2A1301
    val bgSystemWarningDefault: Color, // 0xFFF9C151
    val bgSystemNegativeDefault: Color, // 0xFFBF2121 0xFFDC4646
    val bgSystemNegativePress: Color, // 0xFF781111 0xFF941717
    val componentsButtonOutlinedBg: Color, //0xFFFFFFFF  0x29FFFFFF
    val componentsButtonOutlinedBgPress: Color, //0x29000000  0x14FFFFFF
    val componentsOverlayBg: Color, // 0x3D000000  0x80000000

    //bg Knowledge Stronger Token
    val bgSystemKnowledgeSoftest: Color, // 0xFFE7E3F2 0xFF1B1427

    // text Knowledge Stronger Token
    val textSystemKnowledgeStronger: Color, // 0xFF4F4075 0xFFDBD6ED

    //Border Color Token
    val borderLowEmphasis: Color, // 0x80000000    0x80FFFFFF
    val borderFixedBlackLowEmphasis: Color, // 0x1F000000
    val borderFixedWhiteLowEmphasis: Color, // 0x1FFFFFFF
    val borderSystemKnowledge: Color, // 0xFF9784C8    0xFFAA9CD3
    val borderSystemNegative: Color, // 0xFF941717  0xFFDC4646
    val borderSystemPositive: Color, // 0xFF286044  0xFF54A178
    val componentsDividerLargeBg: Color, // 0x14000000    0xAD000000
    val borderSystemInfo: Color, //0xFF396DBB 0xFF5792EE
    val borderSystemWarning: Color, //0xFFAC5C16 0xFFF4A236

    // Component Colors Token
    val componentButtonSecondaryText: Color,

    val bgElevation0: Color, // 0xFFFFFFFF 0xFF1D1C1C
    val ambientColor: Color,
    val imgBgColor: Color

)

val lightColorScheme: AppColorScheme = AppColorScheme(

    surfaceZero = qt_theme_light_surface_zero,
    emphasisFullInverse = qt_theme_text_full_black,
    emphasisInverse = qt_theme_text_default,
    emphasis = qt_theme_light_emphasis_100,
    onEmphasis = qt_theme_text_default,
    emphasis50 = qt_theme_light_emphasis_50,
    emphasis25 = qt_theme_light_emphasis_25,
    //emphasis65 = qt_theme_light_emphasis_65,
    neutral = qt_theme_light_neutral,
    secondaryInverse = qt_theme_dark_secondary_100,
    secondary = qt_theme_light_secondary_100,
    onSecondary = qt_theme_text_default,
    secondary75 = qt_theme_light_secondary_75,
    secondary25 = qt_theme_light_secondary_25,
    primary = qt_theme_light_primary,
    onPrimary = qt_theme_text_inverse,
    primaryContainer = qt_theme_light_primary_container_strong,
    onPrimaryContainer = qt_theme_text_default,
    primaryContainerLight = qt_theme_light_primary_container,
    successStrong = qt_theme_light_success_strong,
    success = qt_theme_light_success,
    successExtraLight = qt_theme_light_success_extra_light,
    positiveDefault = qt_theme_light_positive,
    positiveSoft = qt_theme_light_positive_soft,
    warningExtraStrong = qt_theme_light_warning_extra_strong,
    warning = qt_theme_light_warning,
    onWarningMedium = qt_theme_light_warning_pressed,
    error = qt_theme_light_error,
    errorPressed = qt_theme_light_error_pressed,
    onError = qt_theme_text_inverse,
    errorExtraLight = qt_theme_light_error_extra_light,
    information = qt_theme_light_information,
    onInformation = qt_theme_text_inverse,
    onPrivacyLight = qt_theme_light_privacy,
    hybridChipIndicator = hybrid_chip_indicator_color,
    confirmationBackground = qt_confirmation_background,
    warningBannerBorder = qt_theme_warning_banner_border,
    componentSpinner100M = qt_theme_light_components_spinner_100M,
    componentSpinner0M = qt_theme_light_components_spinner_0M,
    componentSpinner100W = qt_theme_light_components_spinner_100W,
    componentSpinner0W = qt_theme_light_components_spinner_0W,
    textSystemNegativeStronger = qt_theme_light_text_system_negative_stronger,
    textSystemWarningStrong = qt_theme_light_text_system_warning_strong,
    textSystemWarningStronger = qt_theme_light_text_system_warning_stronger,
    textFixedWhiteHighEmphasis = qt_theme_text_inverse,
    textFixedWhiteMediumEmphasis = qt_text_fixedWhite_MediumEmphasis,
    textFixedWhiteLowEmphasis = qt_text_fixedWhite_lowEmphasis,
    textFixedBlackHighEmphasis = qt_theme_text_full_black,
    textFixedBlackMediumEmphasis = qt_border_fixed_black_mediumEmphasis,
    textSystemPositiveStronger = qt_theme_light_text_system_positive_stronger,
    textSystemInfoStronger = qt_theme_light_text_system_info_stronger,
    bgSystemNegativeSoft = qt_theme_light_bg_system_negative_soft,
    bgSystemNegativeSofter = qt_theme_light_bg_system_negative_softer,
    bgSystemNegativeSoftest = qt_theme_light_bg_system_negative_softest,
    bgSystemWarningHover = qt_theme_light_bg_system_warning_soft,
    bgSystemWarningSofter = qt_theme_light_bg_system_warning_softer,
    bgSystemWarningSoft = qt_theme_light_bg_system_warning_soft,
    bgSystemPositiveSoft = qt_theme_light_bg_system_positive_soft,
    bgSystemPositiveSofter = qt_theme_light_bg_system_positive_softer,
    bgSystemPositiveSoftest = qt_theme_light_bg_system_positive_softest,
    bgSystemPositiveDefault = qt_theme_light_bg_system_positive_default,
    bgSystemPositivePress = qt_theme_light_bg_system_positive_press,
    bgSystemInfoSoft = qt_theme_light_bg_system_info_soft,
    bgSystemInfoSofter = qt_theme_light_bg_system_info_softer,
    bgSystemInfoDefault = qt_theme_light_bg_system_info_default,
    bgSystemInfoStrong = qt_theme_light_bg_system_info_strong,
    componentsShimmerBg = qt_theme_components_shimmer_bg,
    componentsShimmerGradient0 = qt_theme_components_gradient_0,
    componentsShimmerGradient100 = qt_theme_components_gradient_100,
    //Home screen
    bgHomeMorningGradient = qt_bgHomeMorningGradient,
    bgHomeAfternoonGradient = qt_bgHomeAfternoonGradient,
    bgHomeEveningGradient = qt_bgHomeEveningGradient,
    //Bottom Navigation
    bgBottomNavigation = qt_bgBottomNavigation,
    bgBottomNavSelected = qt_bgBottomNavSelected,
    bgBottomNavNormal = qt_bgBottomNavNormal,

    // Text Colors Light
    textHighEmphasis = qt_text_highEmphasis,
    textMediumEmphasis = qt_text_mediumEmphasis,
    textLowEmphasis = qt_text_lowEmphasis,
    textDisabled = qt_text_disabled,
    textPrimaryDefault = qt_text_primary_default,
    textPrimaryStronger = qt_text_primary_stronger,
    textPrimaryStrong = qt_text_primary_strong,
    textInvertHighEmphasis = qt_text_invert_highEmphasis,
    textSystemNegativeDefault = qt_text_system_negative_default,
    textSystemPositiveDefault = qt_text_system_positive_default,
    textSystemNegativeStrong = qt_text_system_negative_strong,

    //Background color
    bgCard = qt_theme_light_surface_scroll,
    bgPrimaryDefault = qt_bg_primary_default,
    bgPrimaryPress = qt_bg_primary_press,
    bgPrimarySoftest = qt_bg_primarySoftest,
    bgFixedWhite = qt_bg_fixedWhite,
    bgCardBlur = qt_bg_CardBlur,
    bgElevation1 = qt_bg_elevation_1,
    bgElevationPlus1 = qt_bg_elevation_plus_1,
    bgNeutral = qt_bg_neutral,

    bgNeutral8 = qt_bg_Neutral8,
    bgNeutral100 = qt_bg_Neutral100,
    bgNeutral5 = qt_bg_Neutral5,
    bgSecondarySaffron = qt_bg_secondary_saffron,
    bgSecondaryMidnight = qt_bg_secondary_midnight,
    bgSystemInfoSoftest = qt_bg_systemInfoSoftest,
    bgSystemWarningSoftest = qt_bg_systemWarningSoftest,
    bgSystemWarningDefault = qt_bg_systemWarningDefault,
    bgSystemNegativeDefault = qt_bg_systemNegativeDefault,
    bgSystemNegativePress = qt_bg_systemNegativePress,
    componentsButtonOutlinedBg = qt_componentsButtonOutlinedBg,
    componentsButtonOutlinedBgPress = qt_componentsButtonOutlinedBgPress,
    componentsOverlayBg = qt_componentsOverlayBg,
    bgPopupWindow = qt_theme_light_popup_bg,


    //Border colors
    borderLowEmphasis = qt_border_lowEmphasis,
    borderFixedBlackLowEmphasis = qt_border_fixed_black_lowEmphasis,
    borderFixedWhiteLowEmphasis = qt_border_fixed_white_lowEmphasis,
    borderSystemNegative = qt_borderSystemNegative,
    borderSystemPositive = qt_borderSystemPositive,
    borderSystemInfo = qt_border_systemInfo,
    borderSystemWarning = qt_border_systemWarning,

    // Component colors
    componentButtonSecondaryText = qt_component_button_secondary_text,
    bgSystemKnowledgeSoftest = qt_bgSystemKnowledgeSoftest,
    textSystemKnowledgeStronger = qt_textSystemKnowledgeStronger,
    borderSystemKnowledge = qt_borderSystemKnowledge,
    componentsDividerLargeBg = qt_componentsDividerLargeBg,
    bgElevation0 = qt_bg_elevation_0,
    ambientColor = qt_light_ambientColor,
    imgBgColor = qt_dark_text_lowEmphasis
)

val darkColorScheme: AppColorScheme = AppColorScheme(
    surfaceZero = qt_theme_dark_surface_zero,
    emphasisFullInverse = qt_theme_text_inverse,
    emphasisInverse = qt_theme_text_inverse,
    emphasis = qt_theme_dark_emphasis_100,
    onEmphasis = qt_theme_text_inverse,
    emphasis50 = qt_theme_dark_emphasis_50,
    emphasis25 = qt_theme_dark_emphasis_25,
    //  emphasis65 = qt_theme_light_emphasis_65,
    neutral = qt_theme_dark_neutral,
    secondaryInverse = qt_theme_light_secondary_100,
    secondary = qt_theme_dark_secondary_100,
    onSecondary = qt_theme_text_default,
    secondary75 = qt_theme_dark_secondary_75,
    secondary25 = qt_theme_dark_secondary_25,
    primary = qt_theme_dark_primary,
    onPrimary = qt_theme_text_default,
    primaryContainer = qt_theme_dark_primary_container_strong,
    onPrimaryContainer = qt_theme_text_inverse,
    primaryContainerLight = qt_theme_dark_primary_container,
    successStrong = qt_theme_dark_success_strong,
    success = qt_theme_dark_success,
    successExtraLight = qt_theme_dark_success_extra_light,
    positiveDefault = qt_theme_light_positive,
    positiveSoft = qt_theme_dark_positive_soft,
    warningExtraStrong = qt_theme_dark_warning_extra_strong,
    warning = qt_theme_dark_warning,
    onWarningMedium = qt_theme_light_warning_pressed,
    error = qt_theme_dark_error,
    errorPressed = qt_theme_dark_error_pressed,
    onError = qt_theme_text_inverse,
    errorExtraLight = qt_theme_dark_error_extra_light,
    information = qt_theme_dark_information,
    onInformation = qt_theme_text_inverse,
    hybridChipIndicator = hybrid_chip_indicator_color,
    confirmationBackground = qt_confirmation_background,
    warningBannerBorder = qt_theme_warning_banner_border,
    onPrivacyLight = qt_theme_light_privacy,
    componentSpinner100M = qt_theme_dark_components_spinner_100M,
    componentSpinner0M = qt_theme_dark_components_spinner_0M,
    componentSpinner100W = qt_theme_dark_components_spinner_100W,
    componentSpinner0W = qt_theme_dark_components_spinner_0W,
    textSystemNegativeStronger = qt_theme_dark_text_system_negative_stronger,
    textSystemWarningStrong = qt_theme_dark_text_system_warning_strong,
    textSystemWarningStronger = qt_theme_dark_text_system_warning_stronger,
    textFixedWhiteHighEmphasis = qt_theme_text_inverse,
    textFixedWhiteMediumEmphasis = qt_text_fixedWhite_MediumEmphasis,
    textFixedWhiteLowEmphasis = qt_text_fixedWhite_lowEmphasis,
    textFixedBlackHighEmphasis = qt_theme_text_full_black,
    textFixedBlackMediumEmphasis = qt_border_fixed_black_mediumEmphasis,
    textSystemPositiveStronger = qt_theme_dark_text_system_positive_stronger,
    textSystemInfoStronger = qt_theme_dark_text_system_info_stronger,
    bgSystemNegativeSoft = qt_theme_dark_bg_system_negative_soft,
    bgSystemNegativeSofter = qt_theme_dark_bg_system_negative_softer,
    bgSystemNegativeSoftest = qt_theme_dark_bg_system_negative_softest,
    bgSystemWarningHover = qt_theme_light_bg_system_warning_soft,
    bgSystemWarningSofter = qt_theme_dark_bg_system_warning_softer,
    bgSystemWarningSoft = qt_theme_dark_bg_system_warning_soft,
    bgSystemPositiveSoft = qt_theme_dark_bg_system_positive_soft,
    bgSystemPositiveSofter = qt_theme_dark_bg_system_positive_softer,
    bgSystemPositiveSoftest = qt_theme_dark_bg_system_positive_softest,
    bgSystemPositiveDefault = qt_theme_dark_bg_system_positive_default,
    bgSystemPositivePress = qt_theme_dark_bg_system_positive_press,
    bgSystemInfoSoft = qt_theme_dark_bg_system_info_soft,
    bgSystemInfoSofter = qt_theme_dark_bg_system_info_softer,
    bgSystemInfoDefault = qt_theme_dark_bg_system_info_default,
    bgSystemInfoStrong = qt_theme_dark_bg_system_info_strong,
    componentsShimmerBg = qt_theme_dark_components_shimmer_bg,
    componentsShimmerGradient0 = qt_theme_dark_components_gradient_0,
    componentsShimmerGradient100 = qt_theme_dark_components_gradient_100,
    //Home screen
    bgHomeMorningGradient = qt_dark_bgHomeMorningGradient,
    bgHomeAfternoonGradient = qt_dark_bgHomeAfternoonGradient,
    bgHomeEveningGradient = qt_dark_bgHomeEveningGradient,
    //Bottom Navigation
    bgBottomNavigation = qt_dark_bgBottomNavigation,
    bgBottomNavSelected = qt_dark_bgBottomNavSelected,
    bgBottomNavNormal = qt_dark_bgBottomNavNormal,

    // Text Colors Dark
    textHighEmphasis = qt_dark_text_highEmphasis,
    textMediumEmphasis = qt_dark_text_mediumEmphasis,
    textLowEmphasis = qt_dark_text_lowEmphasis,
    textDisabled = qt_dark_text_disabled,
    textPrimaryDefault = qt_dark_text_primary_default,
    textPrimaryStrong = qt_dark_text_primary_strong,
    textPrimaryStronger = qt_dark_text_primary_stronger,
    textInvertHighEmphasis = qt_dark_text_invert_highEmphasis,
    textSystemNegativeDefault = qt_dark_text_system_negative_default,
    textSystemPositiveDefault = qt_dark_text_system_positive_default,
    textSystemNegativeStrong = qt_dark_text_system_negative_strong,

    //Background color
    bgCard = qt_theme_dark_surface_scroll,
    bgPrimaryDefault = qt_dark_bg_primary_default,
    bgPrimaryPress = qt_dark_bg_primary_press,
    bgPrimarySoftest = qt_dark_bg_primarySoftest,
    bgFixedWhite = qt_bg_fixedWhite,
    bgCardBlur = qt_bg_CardBlur,
    bgElevation1 = qt_dark_bg_elevation_1,
    bgElevationPlus1 = qt_dark_bg_elevation_plus_1,
    bgNeutral = qt_dark_bg_neutral,
    bgNeutral8 = qt_dark_bg_Neutral8,
    bgNeutral100 = qt_dark_bg_Neutral100,
    bgNeutral5 = qt_dark_bg_Neutral5,
    bgSecondarySaffron = qt_bg_secondary_saffron,
    bgSecondaryMidnight = qt_dark_bg_secondary_midnight,
    bgSystemInfoSoftest = qt_dark_bg_systemInfoSoftest,
    bgSystemWarningSoftest = qt_dark_bg_systemWarningSoftest,
    bgSystemWarningDefault = qt_bg_systemWarningDefault,
    bgSystemNegativeDefault = qt_dark_bg_systemNegativeDefault,
    bgSystemNegativePress = qt_dark_bg_systemNegativePress,
    componentsButtonOutlinedBg = qt_dark_componentsButtonOutlinedBg,
    componentsButtonOutlinedBgPress = qt_dark_componentsButtonOutlinedBgPress,
    componentsOverlayBg = qt_dark_componentsOverlayBg,
    bgPopupWindow = qt_theme_dark_popup_bg,

    //Border colors
    borderLowEmphasis = qt_dark_border_lowEmphasis,
    borderFixedBlackLowEmphasis = qt_border_fixed_black_lowEmphasis,
    borderFixedWhiteLowEmphasis = qt_border_fixed_white_lowEmphasis,
    borderSystemNegative = qt_dark_borderSystemNegative,
    borderSystemPositive = qt_dark_borderSystemPositive,
    borderSystemInfo = qt_dark_border_systemInfo,
    borderSystemWarning = qt_dark_border_systemWarning,

    // Component colors
    componentButtonSecondaryText = qt_dark_component_button_secondary_text,
    bgSystemKnowledgeSoftest = qt_dark_bgSystemKnowledgeSoftest,
    textSystemKnowledgeStronger = qt_dark_textSystemKnowledgeStronger,
    borderSystemKnowledge = qt_dark_borderSystemKnowledge,
    componentsDividerLargeBg = qt_dark_componentsDividerLargeBg,
    bgElevation0 = qt_dark_bg_elevation_0,
    ambientColor = qt_dark_ambientColor,
    imgBgColor = qt_text_lowEmphasis
)