# NumberPicker | Miuix

`NumberPicker` is a basic interactive component in Miuix used for selecting a value from a range of numbers by vertical scrolling. The selected item is centered and highlighted, while surrounding items fade out and scale down. Supports infinite scrolling with the `wrapAround` parameter.

## Import [​](https://compose-miuix-ui.github.io/miuix/components/numberpicker#import)

kotlin

```
import top.yukonga.miuix.kmp.basic.NumberPicker
```

## Basic Usage [​](https://compose-miuix-ui.github.io/miuix/components/numberpicker#basic-usage)

kotlin

```
var value by remember { mutableIntStateOf(5) }

NumberPicker(
    value = value,
    onValueChange = { value = it },
    range = 0..10
)
```

## Component States [​](https://compose-miuix-ui.github.io/miuix/components/numberpicker#component-states)

### Disabled State [​](https://compose-miuix-ui.github.io/miuix/components/numberpicker#disabled-state)

kotlin

```
var value by remember { mutableIntStateOf(5) }

NumberPicker(
    value = value,
    onValueChange = { value = it },
    range = 0..10,
    enabled = false
)
```

### Infinite Scrolling [​](https://compose-miuix-ui.github.io/miuix/components/numberpicker#infinite-scrolling)

When `wrapAround` is enabled, the picker wraps from the last item back to the first, allowing continuous scrolling.

kotlin

```
var value by remember { mutableIntStateOf(0) }

NumberPicker(
    value = value,
    onValueChange = { value = it },
    range = 0..23,
    wrapAround = true
)
```

## Properties [​](https://compose-miuix-ui.github.io/miuix/components/numberpicker#properties)

### NumberPicker Properties [​](https://compose-miuix-ui.github.io/miuix/components/numberpicker#numberpicker-properties)

| Property Name | Type | Description | Default Value | Required |
| --- | --- | --- | --- | --- |
| value | Int | Current selected value. If outside range, it will be coerced | \- | Yes |
| onValueChange | (Int) -> Unit | Callback invoked when the selected value changes | \- | Yes |
| modifier | Modifier | Modifier applied to the picker | Modifier | No |
| enabled | Boolean | Whether the picker is enabled for user interaction | true | No |
| range | IntRange | The range of selectable values | 0..10 | No |
| label | (Int) -> String | Converts a value to its display string |  | No |
| visibleItemCount | Int | Number of visible items. Must be odd and at least 3 | 5 | No |
| wrapAround | Boolean | Whether the picker wraps around (infinite scrolling) | false | No |
| colors | NumberPickerColors | Color configuration of the picker | NumberPickerDefaults.colors() | No |
| textStyle | TextStyle | Text style for picker items | MiuixTheme.textStyles.title1 | No |
| itemHeight | Dp | The height of each item in the picker | NumberPickerDefaults.ItemHeight | No |

### NumberPickerDefaults Object [​](https://compose-miuix-ui.github.io/miuix/components/numberpicker#numberpickerdefaults-object)

The NumberPickerDefaults object provides default configurations for the NumberPicker component.

#### Properties [​](https://compose-miuix-ui.github.io/miuix/components/numberpicker#properties-1)

| Property Name | Type | Description | Default Value |
| --- | --- | --- | --- |
| ItemHeight | Dp | Default height of each item | 45.dp |

#### Methods [​](https://compose-miuix-ui.github.io/miuix/components/numberpicker#methods)

| Method Name | Return Type | Description |
| --- | --- | --- |
| colors() | NumberPickerColors | Creates default color configuration |

### NumberPickerColors Class [​](https://compose-miuix-ui.github.io/miuix/components/numberpicker#numberpickercolors-class)

| Property Name | Type | Description |
| --- | --- | --- |
| selectedTextColor | Color | Text color for the selected (center) item |
| unselectedTextColor | Color | Text color for unselected items |
| disabledSelectedTextColor | Color | Selected text color when disabled |
| disabledUnselectedTextColor | Color | Unselected text color when disabled |

## Advanced Usage [​](https://compose-miuix-ui.github.io/miuix/components/numberpicker#advanced-usage)

### Custom Label Format [​](https://compose-miuix-ui.github.io/miuix/components/numberpicker#custom-label-format)

kotlin

```
var hour by remember { mutableIntStateOf(9) }

NumberPicker(
    value = hour,
    onValueChange = { hour = it },
    range = 0..23,
    label = { it.toString().padStart(2, '0') }  // "00", "01", ... "23"
)
```

### Time Picker [​](https://compose-miuix-ui.github.io/miuix/components/numberpicker#time-picker)

Combine two NumberPickers to create a time picker.

kotlin

```
var hour by remember { mutableIntStateOf(16) }
var minute by remember { mutableIntStateOf(30) }

Row(
    horizontalArrangement = Arrangement.Center,
    verticalAlignment = Alignment.CenterVertically,
) {
    NumberPicker(
        value = hour,
        onValueChange = { hour = it },
        range = 0..23,
        label = { it.toString().padStart(2, '0') },
        wrapAround = true,
        modifier = Modifier.weight(1f),
    )
    Text(
        text = ":",
        fontWeight = FontWeight.Bold,
    )
    NumberPicker(
        value = minute,
        onValueChange = { minute = it },
        range = 0..59,
        label = { it.toString().padStart(2, '0') },
        wrapAround = true,
        modifier = Modifier.weight(1f),
    )
}
```

### Custom Visible Item Count [​](https://compose-miuix-ui.github.io/miuix/components/numberpicker#custom-visible-item-count)

kotlin

```
var value by remember { mutableIntStateOf(5) }

NumberPicker(
    value = value,
    onValueChange = { value = it },
    range = 1..100,
    visibleItemCount = 3
)
```

### Custom Colors [​](https://compose-miuix-ui.github.io/miuix/components/numberpicker#custom-colors)

kotlin

```
var value by remember { mutableIntStateOf(5) }

NumberPicker(
    value = value,
    onValueChange = { value = it },
    range = 0..10,
    colors = NumberPickerDefaults.colors(
        selectedTextColor = Color.Red,
        unselectedTextColor = Color.Gray
    )
)
```

## Changelog[](https://compose-miuix-ui.github.io/miuix/components/numberpicker#changelog)

Last edited about 2 months ago

View full history

---
Source: [NumberPicker | Miuix](https://compose-miuix-ui.github.io/miuix/components/numberpicker)