# RadioButtonPreference | Miuix

`RadioButtonPreference` is a radio button component in Miuix that provides a title, summary, and radio button control. It supports click interactions and is commonly used in single-select settings and selection lists.

## Import [​](https://compose-miuix-ui.github.io/miuix/components/radiobuttonpreference#import)

kotlin

```
import top.yukonga.miuix.kmp.preference.RadioButtonPreference
```

## Basic Usage [​](https://compose-miuix-ui.github.io/miuix/components/radiobuttonpreference#basic-usage)

RadioButtonPreference is typically used within a mutually exclusive group:

kotlin

```
var selectedIndex by remember { mutableIntStateOf(0) }

Card {
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
    RadioButtonPreference(
        title = "Option C",
        selected = selectedIndex == 2,
        onClick = { selectedIndex = 2 }
    )
}
```

## RadioButton with Summary [​](https://compose-miuix-ui.github.io/miuix/components/radiobuttonpreference#radiobutton-with-summary)

kotlin

```
var selectedIndex by remember { mutableIntStateOf(0) }

RadioButtonPreference(
    title = "Option A",
    summary = "Description for option A",
    selected = selectedIndex == 0,
    onClick = { selectedIndex = 0 }
)
```

## Component States [​](https://compose-miuix-ui.github.io/miuix/components/radiobuttonpreference#component-states)

### Disabled State [​](https://compose-miuix-ui.github.io/miuix/components/radiobuttonpreference#disabled-state)

kotlin

```
RadioButtonPreference(
    title = "Disabled RadioButton",
    summary = "This radio button is currently unavailable",
    selected = true,
    onClick = {},
    enabled = false
)
```

## Properties [​](https://compose-miuix-ui.github.io/miuix/components/radiobuttonpreference#properties)

### RadioButtonPreference Properties [​](https://compose-miuix-ui.github.io/miuix/components/radiobuttonpreference#radiobuttonpreference-properties)

| Property Name | Type | Description | Default Value | Required |
| --- | --- | --- | --- | --- |
| title | String | Title of the radio button item | \- | Yes |
| selected | Boolean | Radio button selected state | \- | Yes |
| onClick | (() -> Unit)? | Callback when radio button is clicked | \- | Yes |
| modifier | Modifier | Modifier applied to component | Modifier | No |
| titleColor | BasicComponentColors | Title text color configuration | BasicComponentDefaults.titleColor() | No |
| summary | String? | Summary description | null | No |
| summaryColor | BasicComponentColors | Summary text color configuration | BasicComponentDefaults.summaryColor() | No |
| radioButtonColors | RadioButtonColors | RadioButton control color configuration | RadioButtonDefaults.radioButtonColors() | No |
| endActions | @Composable RowScope.() -> Unit | Custom end content | {} | No |
| bottomAction | @Composable (() -> Unit)? | Custom bottom content | null | No |
| holdDownState | Boolean | Whether the component is held down | false | No |
| insideMargin | PaddingValues | Internal content padding | BasicComponentDefaults.InsideMargin | No |
| enabled | Boolean | Whether component is interactive | true | No |

## Advanced Usage [​](https://compose-miuix-ui.github.io/miuix/components/radiobuttonpreference#advanced-usage)

### Custom Colors [​](https://compose-miuix-ui.github.io/miuix/components/radiobuttonpreference#custom-colors)

kotlin

```
var selected by remember { mutableStateOf(false) }

RadioButtonPreference(
    title = "Custom Colors",
    titleColor = BasicComponentDefaults.titleColor(
        color = MiuixTheme.colorScheme.primary
    ),
    summary = "RadioButton with custom colors",
    summaryColor = BasicComponentDefaults.summaryColor(
        color = MiuixTheme.colorScheme.secondary
    ),
    selected = selected,
    onClick = { selected = !selected },
    radioButtonColors = RadioButtonDefaults.radioButtonColors(
        selectedColor = Color.Red
    )
)
```

### Using with Dialog [​](https://compose-miuix-ui.github.io/miuix/components/radiobuttonpreference#using-with-dialog)

kotlin

```
var showDialog by remember { mutableStateOf(false) }
var selectedTheme by remember { mutableIntStateOf(0) }
val themes = listOf("Light", "Dark", "System")

Scaffold {
    ArrowPreference(
        title = "Theme Settings",
        onClick = { showDialog = true },
        holdDownState = showDialog
    )

    OverlayDialog(
        title = "Theme Settings",
        show = showDialog,
        onDismissRequest = { showDialog = false }
    ) {
        Card {
            themes.forEachIndexed { index, theme ->
                RadioButtonPreference(
                    title = theme,
                    selected = selectedTheme == index,
                    onClick = { selectedTheme = index }
                )
            }
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(top = 12.dp)
        ) {
            TextButton(
                text = "Cancel",
                onClick = { showDialog = false },
                modifier = Modifier.weight(1f)
            )
            Spacer(Modifier.width(16.dp))
            TextButton(
                text = "Confirm",
                onClick = { showDialog = false },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.textButtonColorsPrimary()
            )
        }
    }
}
```

## Changelog[](https://compose-miuix-ui.github.io/miuix/components/radiobuttonpreference#changelog)

Last edited about 2 months ago

View full history

---
Source: [RadioButtonPreference | Miuix](https://compose-miuix-ui.github.io/miuix/components/radiobuttonpreference)