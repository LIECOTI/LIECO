# RadioButton | Miuix

`RadioButton` is a basic selection component in Miuix, supporting two states: selected and unselected. When selected, it displays an animated checkmark indicator. When unselected, no indicator is shown. It is suitable for single selection scenarios where only one option can be chosen from a group.

## Import [​](https://compose-miuix-ui.github.io/miuix/components/radiobutton#import)

kotlin

```
import top.yukonga.miuix.kmp.basic.RadioButton
```

## Basic Usage [​](https://compose-miuix-ui.github.io/miuix/components/radiobutton#basic-usage)

The RadioButton component is typically used within a mutually exclusive group:

kotlin

```
var selectedIndex by remember { mutableIntStateOf(0) }

Column {
    RadioButtonPreference(
        title = "Option A",
        selected = selectedIndex == 0,
        onClick = { selectedIndex = 0 }
    )
    RadioButtonPreference(
        title = "Option B",
        selected = selectedIndex == 1,
        onClick = { selectedIndex = 1 }
    )
}
```

## Component States [​](https://compose-miuix-ui.github.io/miuix/components/radiobutton#component-states)

### Disabled State [​](https://compose-miuix-ui.github.io/miuix/components/radiobutton#disabled-state)

kotlin

```
RadioButton(
    selected = true,
    onClick = null,
    enabled = false
)
```

## Properties [​](https://compose-miuix-ui.github.io/miuix/components/radiobutton#properties)

### RadioButton Properties [​](https://compose-miuix-ui.github.io/miuix/components/radiobutton#radiobutton-properties)

| Property Name | Type | Description | Default Value | Required |
| --- | --- | --- | --- | --- |
| selected | Boolean | Whether the RadioButton is currently selected | \- | Yes |
| onClick | (() -> Unit)? | Callback when the RadioButton is clicked; `null` = non-interactive | \- | Yes |
| modifier | Modifier | Modifier applied to the RadioButton | Modifier | No |
| colors | RadioButtonColors | Color configuration for the RadioButton | RadioButtonDefaults.radioButtonColors() | No |
| enabled | Boolean | Whether the RadioButton is interactive | true | No |

### RadioButtonDefaults Object [​](https://compose-miuix-ui.github.io/miuix/components/radiobutton#radiobuttondefaults-object)

The RadioButtonDefaults object provides default color configurations for the RadioButton component.

#### Methods [​](https://compose-miuix-ui.github.io/miuix/components/radiobutton#methods)

| Method Name | Type | Description |
| --- | --- | --- |
| radioButtonColors() | RadioButtonColors | Creates default color config for radio button |

### RadioButtonColors Class [​](https://compose-miuix-ui.github.io/miuix/components/radiobutton#radiobuttoncolors-class)

| Property Name | Type | Description |
| --- | --- | --- |
| selectedColor | Color | Checkmark color when selected |
| disabledSelectedColor | Color | Checkmark color when disabled and selected |

## Advanced Usage [​](https://compose-miuix-ui.github.io/miuix/components/radiobutton#advanced-usage)

### Custom Colors [​](https://compose-miuix-ui.github.io/miuix/components/radiobutton#custom-colors)

kotlin

```
var selected by remember { mutableStateOf(false) }

RadioButton(
    selected = selected,
    onClick = { selected = !selected },
    colors = RadioButtonDefaults.radioButtonColors(
        selectedColor = Color.Red
    )
)
```

### Using in Lists [​](https://compose-miuix-ui.github.io/miuix/components/radiobutton#using-in-lists)

kotlin

```
val options = listOf("Option A", "Option B", "Option C")
var selectedIndex by remember { mutableIntStateOf(0) }

Card {
    options.forEachIndexed { index, option ->
        RadioButtonPreference(
            title = option,
            selected = selectedIndex == index,
            onClick = { selectedIndex = index }
        )
    }
}
```

## Changelog[](https://compose-miuix-ui.github.io/miuix/components/radiobutton#changelog)

Last edited about 2 months ago

View full history

---
Source: [RadioButton | Miuix](https://compose-miuix-ui.github.io/miuix/components/radiobutton)