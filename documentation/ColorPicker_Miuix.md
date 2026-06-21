# ColorPicker | Miuix

`ColorPicker` is a color selection component in Miuix that allows users to pick colors by adjusting hue, saturation, brightness, and transparency. The component provides an intuitive slider interface with haptic feedback and real-time color preview.

## Import [​](https://compose-miuix-ui.github.io/miuix/components/colorpicker#import)

kotlin

```
import top.yukonga.miuix.kmp.basic.ColorPicker
```

## Basic Usage [​](https://compose-miuix-ui.github.io/miuix/components/colorpicker#basic-usage)

The ColorPicker component enables users to select custom colors:

kotlin

```
var selectedColor by remember { mutableStateOf(Color.Red) }

ColorPicker(
    color = selectedColor,
    onColorChanged = { newColor ->
        selectedColor = newColor
    }
)
```

## Component Variants [​](https://compose-miuix-ui.github.io/miuix/components/colorpicker#component-variants)

### Without Color Preview [​](https://compose-miuix-ui.github.io/miuix/components/colorpicker#without-color-preview)

By default, ColorPicker displays a preview of the currently selected color. If you don't want to show the default color preview, set `showPreview` to `false`:

kotlin

```
ColorPicker(
    color = Color.Blue,
    onColorChanged = { /* Handle color change */ },
    showPreview = false
)
```

## Haptic Feedback [​](https://compose-miuix-ui.github.io/miuix/components/colorpicker#haptic-feedback)

ColorPicker supports haptic feedback, which can be customized using the `hapticEffect` parameter. See [SliderHapticEffect](https://compose-miuix-ui.github.io/miuix/components/slider#sliderhapticeffect) for details.

kotlin

```
ColorPicker(
    color = Color.Green,
    onColorChanged = { /* Handle color change */ },
    hapticEffect = SliderHapticEffect.Step
)
```

## Properties [​](https://compose-miuix-ui.github.io/miuix/components/colorpicker#properties)

### ColorPicker Properties [​](https://compose-miuix-ui.github.io/miuix/components/colorpicker#colorpicker-properties)

| Property Name | Type | Description | Default Value | Required |
| --- | --- | --- | --- | --- |
| color | Color | Current color | \- | Yes |
| onColorChanged | (Color) -> Unit | Callback for color changes | \- | Yes |
| modifier | Modifier | Modifier for the component | Modifier | No |
| showPreview | Boolean | Show color preview | true | No |
| hapticEffect | SliderDefaults.SliderHapticEffect | Slider haptic feedback effect | SliderDefaults.DefaultHapticEffect | No |
| colorSpace | ColorSpace | Color space to use | ColorSpace.HSV | No |

## Individual Slider Components [​](https://compose-miuix-ui.github.io/miuix/components/colorpicker#individual-slider-components)

The HSV color space exposes four sliders that can be used independently. Other color spaces have their own slider families — see [Other Color Space Sliders](https://compose-miuix-ui.github.io/miuix/components/colorpicker#other-color-space-sliders).

### HsvHueSlider [​](https://compose-miuix-ui.github.io/miuix/components/colorpicker#hsvhueslider)

kotlin

```
var hue by remember { mutableStateOf(0f) }

HsvHueSlider(
    currentHue = hue,
    onHueChanged = { newHue ->
        hue = newHue * 360f
    }
)
```

### HsvSaturationSlider [​](https://compose-miuix-ui.github.io/miuix/components/colorpicker#hsvsaturationslider)

kotlin

```
var saturation by remember { mutableStateOf(0.5f) }

HsvSaturationSlider(
    currentHue = 180f, // Current hue
    currentSaturation = saturation,
    onSaturationChanged = { newSaturation ->
        saturation = newSaturation
    }
)
```

### HsvValueSlider [​](https://compose-miuix-ui.github.io/miuix/components/colorpicker#hsvvalueslider)

kotlin

```
var value by remember { mutableStateOf(0.5f) }

HsvValueSlider(
    currentHue = 180f, // Current hue
    currentSaturation = 0.5f, // Current saturation
    currentValue = value,
    onValueChanged = { newValue ->
        value = newValue
    }
)
```

### HsvAlphaSlider [​](https://compose-miuix-ui.github.io/miuix/components/colorpicker#hsvalphaslider)

kotlin

```
var alpha by remember { mutableStateOf(1f) }

HsvAlphaSlider(
    currentHue = 180f, // Current hue
    currentSaturation = 0.5f, // Current saturation
    currentValue = 0.5f, // Current value
    currentAlpha = alpha,
    onAlphaChanged = { newAlpha ->
        alpha = newAlpha
    }
)
```

### Other Color Space Sliders [​](https://compose-miuix-ui.github.io/miuix/components/colorpicker#other-color-space-sliders)

In addition to the HSV-family sliders above, each color space `ColorPicker` supports has its own set of standalone sliders:

| Color space | Sliders |
| --- | --- |
| OkHSV | `OkHsvHueSlider`, `OkHsvSaturationSlider`, `OkHsvValueSlider`, `OkHsvAlphaSlider` |
| OkLCH | `OkLchLightnessSlider`, `OkLchChromaSlider`, `OkLchHueSlider`, `OkLchAlphaSlider` |
| OkLab | `OkLabLightnessSlider`, `OkLabAChannelSlider`, `OkLabBChannelSlider`, `OkLabAlphaSlider` |

The parameter shapes mirror their HSV counterparts (current value(s) and an `on*Changed` callback, plus an optional `hapticEffect`); refer to the source KDoc for the exact parameter list of each.

## Advanced Usage [​](https://compose-miuix-ui.github.io/miuix/components/colorpicker#advanced-usage)

### Color Spaces [​](https://compose-miuix-ui.github.io/miuix/components/colorpicker#color-spaces)

ColorPicker supports multiple color spaces via `colorSpace`:

-   `ColorSpace.HSV` — classic HSV sliders (Hue, Saturation, Value, Alpha).

-   `ColorSpace.OKHSV` — perceptual HSV variant based on OkLCH, more uniform hue steps.
-   `ColorSpace.OKLAB` — OkLab sliders (Lightness, a, b, Alpha) for perceptual editing.

-   `ColorSpace.OKLCH` — OkLCH sliders (Lightness, Chroma, Hue, Alpha). Chroma is clamped to typical sRGB gamut.

Example: use the OKLCH color space

kotlin

```
ColorPicker(
    color = Color(0xFF4CAF50),
    onColorChanged = { /* Handle color change */ },
    colorSpace = ColorSpace.OKLCH
)
```

### Using in Forms [​](https://compose-miuix-ui.github.io/miuix/components/colorpicker#using-in-forms)

Combine with other input controls to create a color selection form:

kotlin

```
var currentColor by remember { mutableStateOf(Color.Red) }
var hexValue by remember(currentColor) {
    mutableStateOf(
        "#${(currentColor.red * 255).toInt().toString(16).padStart(2, '0').uppercase()}" +
                (currentColor.green * 255).toInt().toString(16).padStart(2, '0').uppercase() +
                (currentColor.blue * 255).toInt().toString(16).padStart(2, '0').uppercase()
    )
}

Surface {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Select Color",
            style = MiuixTheme.textStyles.title2
        )
        Spacer(modifier = Modifier.height(16.dp))
        ColorPicker(
            color = currentColor,
            onColorChanged = {
                currentColor = it
                hexValue = "#${(it.red * 255).toInt().toString(16).padStart(2, '0').uppercase()}" +
                        (it.green * 255).toInt().toString(16).padStart(2, '0').uppercase() +
                        (it.blue * 255).toInt().toString(16).padStart(2, '0').uppercase()
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = hexValue,
            onValueChange = { /* Add hex value parsing logic */ },
            label = "Hex Value",
            modifier = Modifier.fillMaxWidth()
        )
    }
}
```

### Using with Dialog [​](https://compose-miuix-ui.github.io/miuix/components/colorpicker#using-with-dialog)

Use ColorPicker in a dialog to create a color selector:

kotlin

```
var showColorDialog by remember { mutableStateOf(false) }
var selectedColor by remember { mutableStateOf(Color.Red) }

Scaffold {
    TextButton(
        text = "Select Color",
        onClick = { showColorDialog = true }
    )
    OverlayDialog(
        title = "Select Color",
        show = showColorDialog,
        onDismissRequest = { showColorDialog = false } // Close dialog
    ) {
        Column {
            ColorPicker(
                color = selectedColor,
                onColorChanged = { selectedColor = it }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                TextButton(
                    modifier = Modifier.weight(1f),
                    text = "Cancel",
                    onClick = { showColorDialog = false } // Close dialog
                )
                TextButton(
                    modifier = Modifier.weight(1f),
                    text = "Confirm",
                    colors = ButtonDefaults.textButtonColorsPrimary(), // Use theme color
                    onClick = {
                        showColorDialog = false
                        // Handle confirmation logic
                        // For example: save the selected color
                    })
            }
        }
    }
}
```

## Changelog[](https://compose-miuix-ui.github.io/miuix/components/colorpicker#changelog)

Last edited 29 days ago

View full history

---
Source: [ColorPicker | Miuix](https://compose-miuix-ui.github.io/miuix/components/colorpicker)