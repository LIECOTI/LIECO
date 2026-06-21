# ArrowPreference | Miuix

`ArrowPreference` is a directional indicator component in Miuix, typically used for navigation or displaying additional content. It provides a title, summary, and right arrow icon with click interaction support, commonly used in settings, menu items, or list items.

## Import [​](https://compose-miuix-ui.github.io/miuix/components/arrowpreference#import)

kotlin

```
import top.yukonga.miuix.kmp.preference.ArrowPreference
```

## Basic Usage [​](https://compose-miuix-ui.github.io/miuix/components/arrowpreference#basic-usage)

The ArrowPreference component provides basic click navigation functionality:

kotlin

```
ArrowPreference(
    title = "Setting Item",
    onClick = { /* Handle click event */ }
)
```

## Arrow with Summary [​](https://compose-miuix-ui.github.io/miuix/components/arrowpreference#arrow-with-summary)

kotlin

```
ArrowPreference(
    title = "Wireless Network",
    summary = "Connected to WIFI-HOME",
    onClick = { /* Handle click event */ }
)
```

## Component States [​](https://compose-miuix-ui.github.io/miuix/components/arrowpreference#component-states)

### Disabled State [​](https://compose-miuix-ui.github.io/miuix/components/arrowpreference#disabled-state)

kotlin

```
ArrowPreference(
    title = "Disabled Item",
    summary = "This item is currently unavailable",
    enabled = false,
    onClick = { /* Won't be triggered */ }
)
```

### Hold Down State [​](https://compose-miuix-ui.github.io/miuix/components/arrowpreference#hold-down-state)

ArrowPreference supports controlling the hold-down state through the `holdDownState` parameter, typically used for visual feedback when displaying popup dialogs:

kotlin

```
var showDialog by remember { mutableStateOf(false) }

Scaffold {
    ArrowPreference(
        title = "Open Dialog",
        summary = "Click to show dialog",
        onClick = { showDialog = true },
        holdDownState = showDialog
    )
    // Define dialog elsewhere
    OverlayDialog(
        title = "Dialog",
        show = showDialog,
        onDismissRequest = { showDialog = false }
    ) {
        // Dialog content
    }
}
```

## Properties [​](https://compose-miuix-ui.github.io/miuix/components/arrowpreference#properties)

### ArrowPreference Properties [​](https://compose-miuix-ui.github.io/miuix/components/arrowpreference#arrowpreference-properties)

| Property Name | Type | Description | Default Value | Required |
| --- | --- | --- | --- | --- |
| title | String | Arrow item title | \- | Yes |
| modifier | Modifier | Modifier applied to component | Modifier | No |
| titleColor | BasicComponentColors | Title text color configuration | BasicComponentDefaults.titleColor() | No |
| summary | String? | Arrow item summary description | null | No |
| summaryColor | BasicComponentColors | Summary text color configuration | BasicComponentDefaults.summaryColor() | No |
| startAction | @Composable (() -> Unit)? | Custom start side content | null | No |
| endActions | @Composable RowScope.() -> Unit | Custom end side content (slot) | {} | No |
| bottomAction | @Composable (() -> Unit)? | Custom bottom content | null | No |
| insideMargin | PaddingValues | Internal content padding | BasicComponentDefaults.InsideMargin | No |
| onClick | (() -> Unit)? | Callback triggered on click | null | No |
| holdDownState | Boolean | Whether component is held down | false | No |
| enabled | Boolean | Whether component is interactive | true | No |

### ArrowPreferenceDefaults Object [​](https://compose-miuix-ui.github.io/miuix/components/arrowpreference#arrowpreferencedefaults-object)

The ArrowPreferenceDefaults object provides default color configuration for the trailing arrow icon.

#### ArrowPreferenceDefaults Methods [​](https://compose-miuix-ui.github.io/miuix/components/arrowpreference#arrowpreferencedefaults-methods)

| Method Name | Type | Description |
| --- | --- | --- |
| endActionColors | EndActionColors | Returns tint colors used by the trailing arrow icon |

### Arrow Tint [​](https://compose-miuix-ui.github.io/miuix/components/arrowpreference#arrow-tint)

-   The trailing arrow icon is always shown and tinted automatically.

-   Tint uses `MiuixTheme.colorScheme.onSurfaceVariantActions` when `enabled = true`.
-   Tint uses `MiuixTheme.colorScheme.disabledOnSecondaryVariant` when `enabled = false`.

## Advanced Usage [​](https://compose-miuix-ui.github.io/miuix/components/arrowpreference#advanced-usage)

### With Start Icon [​](https://compose-miuix-ui.github.io/miuix/components/arrowpreference#with-start-icon)

kotlin

```
ArrowPreference(
    title = "Personal Information",
    summary = "View and edit your profile",
    startAction = {
        Icon(
            imageVector = MiuixIcons.Contacts,
            contentDescription = "Personal Icon",
            tint = MiuixTheme.colorScheme.onBackground,
            modifier = Modifier.padding(end = 16.dp)
        )
    },
    onClick = { /* Handle click event */ }
)
```

### With End Actions [​](https://compose-miuix-ui.github.io/miuix/components/arrowpreference#with-end-actions)

kotlin

```
ArrowPreference(
    title = "Storage Space",
    summary = "Manage app storage space",
    endActions = {
        Text("12.5 GB")
    },
    onClick = { /* Handle click event */ }
)
```

### Using with Dialog [​](https://compose-miuix-ui.github.io/miuix/components/arrowpreference#using-with-dialog)

kotlin

```
var showDialog by remember { mutableStateOf(false) }
var language by remember { mutableStateOf("Simplified Chinese") }

Scaffold {
ArrowPreference(
    title = "Language Settings",
    summary = "Select app display language",
    endActions = {
        Text(language)
    },
    onClick = { showDialog = true },
    holdDownState = showDialog
)
    OverlayDialog(
        title = "Select Language",
        show = showDialog,
        onDismissRequest = { showDialog = false }
    ) {
        // Dialog content
        Card {
            ArrowPreference(
                title = "Simplified Chinese",
                onClick = {
                    language = "Simplified Chinese"
                    showDialog = false
                }
            )
            ArrowPreference(
                title = "English",
                onClick = {
                    language = "English"
                    showDialog = false
                }
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextButton(
                text = "Cancel",
                onClick = { showDialog = false },
                modifier = Modifier.weight(1f).padding(top = 8.dp)
            )
        }
    }
}
```

## Changelog[](https://compose-miuix-ui.github.io/miuix/components/arrowpreference#changelog)

Last edited about 2 months ago

View full history

---
Source: [ArrowPreference | Miuix](https://compose-miuix-ui.github.io/miuix/components/arrowpreference)