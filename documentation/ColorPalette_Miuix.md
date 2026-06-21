# ColorPalette | Miuix

`ColorPalette` is a HSV color grid component with a built‑in alpha slider and an optional gray column. It uses a single Canvas and minimizes recomposition during drag interactions. With real-time color preview.

## Import [​](https://compose-miuix-ui.github.io/miuix/components/colorpalette#import)

kotlin

```
import top.yukonga.miuix.kmp.basic.ColorPalette
```

## Basic Usage [​](https://compose-miuix-ui.github.io/miuix/components/colorpalette#basic-usage)

kotlin

```
var selectedColor by remember { mutableStateOf(Color.Red) }

ColorPalette(
    color = selectedColor,
    onColorChanged = { newColor ->
        selectedColor = newColor
    }
)
```

## Component Variants [​](https://compose-miuix-ui.github.io/miuix/components/colorpalette#component-variants)

### Without Color Preview [​](https://compose-miuix-ui.github.io/miuix/components/colorpalette#without-color-preview)

Hide the preview panel at the top by setting `showPreview` to `false`:

kotlin

```
ColorPalette(
    color = selected,
    onColorChanged = { newColor ->
        selectedColor = newColor
    },
    showPreview = false
)
```

### Customize Grid Density [​](https://compose-miuix-ui.github.io/miuix/components/colorpalette#customize-grid-density)

You can change the number of rows and hue columns, and toggle the gray column at the right:

kotlin

```
ColorPalette(
    color = selected,
    onColorChanged = { newColor ->
        selectedColor = newColor
    },
    rows = 9,
    hueColumns = 18,
    includeGrayColumn = false
)
```

### Customize Shape and Indicator [​](https://compose-miuix-ui.github.io/miuix/components/colorpalette#customize-shape-and-indicator)

Control the palette corner radius and the selection indicator radius:

kotlin

```
ColorPalette(
    color = selected,
    onColorChanged = { newColor ->
        selectedColor = newColor
    },
    cornerRadius = 20.dp,
    indicatorRadius = 12.dp
)
```

> Note: The alpha slider is built in and currently cannot be hidden.

## Properties [​](https://compose-miuix-ui.github.io/miuix/components/colorpalette#properties)

| Property | Type | Description | Default | Required |
| --- | --- | --- | --- | --- |
| color | Color | Current color | \- | Yes |
| onColorChanged | (Color) -> Unit | Callback when selection changes | \- | Yes |
| modifier | Modifier | Modifier for the component | Modifier | No |
| rows | Int | Grid rows (top: brighter/lower saturation → bottom: darker/higher) | 7 | No |
| hueColumns | Int | Number of hue columns | 12 | No |
| includeGrayColumn | Boolean | Whether to show the gray column at the right | true | No |
| showPreview | Boolean | Whether to show the color preview panel | true | No |
| cornerRadius | Dp | Palette corner radius | 16.dp | No |
| indicatorRadius | Dp | Selection indicator radius | 10.dp | No |

## Advanced Usage [​](https://compose-miuix-ui.github.io/miuix/components/colorpalette#advanced-usage)

### Using in Forms [​](https://compose-miuix-ui.github.io/miuix/components/colorpalette#using-in-forms)

Combine with other inputs to build a simple color form. The example below maintains a HEX string. You may extend it to include alpha if needed.

kotlin

```
var currentColor by remember { mutableStateOf(Color(0xFF2196F3)) }
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
        ColorPalette(
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
            onValueChange = { /* Add hex parsing logic if needed */ },
            label = "Hex Value",
            modifier = Modifier.fillMaxWidth()
        )
    }
}
```

### Using with Dialog [​](https://compose-miuix-ui.github.io/miuix/components/colorpalette#using-with-dialog)

Use `ColorPalette` in a dialog to select a color:

kotlin

```
var showColorDialog by remember { mutableStateOf(false) }
var selectedColor by remember { mutableStateOf(Color(0xFF2196F3)) }

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
            ColorPalette(
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

## Changelog[](https://compose-miuix-ui.github.io/miuix/components/colorpalette#changelog)

Last edited about 2 months ago

View full history

---
Source: [ColorPalette | Miuix](https://compose-miuix-ui.github.io/miuix/components/colorpalette)