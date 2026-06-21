# CheckboxPreference | Miuix

`CheckboxPreference` is a checkbox component in Miuix that provides a title, summary, and checkbox control. It supports click interactions and is commonly used in multi-select settings and selection lists.

## Import [​](https://compose-miuix-ui.github.io/miuix/components/checkboxpreference#import)

kotlin

```
import top.yukonga.miuix.kmp.preference.CheckboxPreference
import top.yukonga.miuix.kmp.preference.CheckboxLocation
```

## Basic Usage [​](https://compose-miuix-ui.github.io/miuix/components/checkboxpreference#basic-usage)

CheckboxPreference component provides basic checkbox functionality:

kotlin

```
var isChecked by remember { mutableStateOf(false) }

CheckboxPreference(
    title = "Checkbox Option",
    checked = isChecked,
    onCheckedChange = { isChecked = it }
)
```

## Checkbox with Summary [​](https://compose-miuix-ui.github.io/miuix/components/checkboxpreference#checkbox-with-summary)

kotlin

```
var notificationsEnabled by remember { mutableStateOf(false) }

CheckboxPreference(
    title = "Notifications",
    summary = "Receive push notifications from the app",
    checked = notificationsEnabled,
    onCheckedChange = { notificationsEnabled = it }
)
```

## Component States [​](https://compose-miuix-ui.github.io/miuix/components/checkboxpreference#component-states)

### Disabled State [​](https://compose-miuix-ui.github.io/miuix/components/checkboxpreference#disabled-state)

kotlin

```
CheckboxPreference(
    title = "Disabled Checkbox",
    summary = "This checkbox is currently unavailable",
    checked = true,
    onCheckedChange = {},
    enabled = false
)
```

## Checkbox Position [​](https://compose-miuix-ui.github.io/miuix/components/checkboxpreference#checkbox-position)

CheckboxPreference supports placing the checkbox on the start or end side:

### Start Checkbox (Default) [​](https://compose-miuix-ui.github.io/miuix/components/checkboxpreference#start-checkbox-default)

kotlin

```
var startChecked by remember { mutableStateOf(false) }

CheckboxPreference(
    title = "Start Checkbox",
    summary = "Checkbox is on the start side (default)",
    checked = startChecked,
    onCheckedChange = { startChecked = it },
    checkboxLocation = CheckboxLocation.Start // Default value
)
```

### End Checkbox [​](https://compose-miuix-ui.github.io/miuix/components/checkboxpreference#end-checkbox)

kotlin

```
var endChecked by remember { mutableStateOf(false) }

CheckboxPreference(
    title = "End Checkbox",
    summary = "Checkbox is on the end side",
    checked = endChecked,
    onCheckedChange = { endChecked = it },
    checkboxLocation = CheckboxLocation.End
)
```

## Properties [​](https://compose-miuix-ui.github.io/miuix/components/checkboxpreference#properties)

### CheckboxPreference Properties [​](https://compose-miuix-ui.github.io/miuix/components/checkboxpreference#checkboxpreference-properties)

| Property Name | Type | Description | Default Value | Required |
| --- | --- | --- | --- | --- |
| title | String | Title of the checkbox item | \- | Yes |
| checked | Boolean | Checkbox checked state | \- | Yes |
| onCheckedChange | ((Boolean) -> Unit)? | Callback when checkbox state changes | \- | No |
| modifier | Modifier | Modifier applied to component | Modifier | No |
| titleColor | BasicComponentColors | Title text color configuration | BasicComponentDefaults.titleColor() | No |
| summary | String? | Summary description | null | No |
| summaryColor | BasicComponentColors | Summary text color configuration | BasicComponentDefaults.summaryColor() | No |
| checkboxColors | CheckboxColors | Checkbox control color configuration | CheckboxDefaults.checkboxColors() | No |
| startAction | @Composable (() -> Unit)? | Custom content after checkbox | null | No |
| endActions | @Composable (RowScope.() -> Unit)? | Custom content before checkbox | null | No |
| checkboxLocation | CheckboxLocation | Checkbox position | CheckboxLocation.Start | No |
| bottomAction | @Composable (() -> Unit)? | Custom bottom content | null | No |
| holdDownState | Boolean | Whether the component is held down | false | No |
| insideMargin | PaddingValues | Internal content padding | BasicComponentDefaults.InsideMargin | No |
| enabled | Boolean | Whether component is interactive | true | No |

## Advanced Usage [​](https://compose-miuix-ui.github.io/miuix/components/checkboxpreference#advanced-usage)

### With Right Actions [​](https://compose-miuix-ui.github.io/miuix/components/checkboxpreference#with-right-actions)

kotlin

```
var backupEnabled by remember { mutableStateOf(false) }

CheckboxPreference(
    title = "Auto Backup",
    summary = "Periodically backup your data",
    checked = backupEnabled,
    onCheckedChange = { backupEnabled = it },
    endActions = {
        Text(
            text = if (backupEnabled) "Enabled" else "Disabled",
            color = MiuixTheme.colorScheme.onSurfaceVariantActions,
            modifier = Modifier.padding(end = 6.dp)
        )
    }
)
```

### Nested Checkboxes [​](https://compose-miuix-ui.github.io/miuix/components/checkboxpreference#nested-checkboxes)

kotlin

```
var allSelected by remember { mutableStateOf(false) }
var option1 by remember { mutableStateOf(false) }
var option2 by remember { mutableStateOf(false) }
var option3 by remember { mutableStateOf(false) }

Column {
    CheckboxPreference(
        title = "Select All",
        checked = allSelected,
        onCheckedChange = { newState ->
            allSelected = newState
            option1 = newState
            option2 = newState
            option3 = newState
        }
    )
    CheckboxPreference(
        title = "Option 1",
        checked = option1,
        onCheckedChange = {
            option1 = it
            allSelected = option1 && option2 && option3
        },
        modifier = Modifier.padding(start = 24.dp)
    )
    CheckboxPreference(
        title = "Option 2",
        checked = option2,
        onCheckedChange = {
            option2 = it
            allSelected = option1 && option2 && option3
        },
        modifier = Modifier.padding(start = 24.dp)
    )
    CheckboxPreference(
        title = "Option 3",
        checked = option3,
        onCheckedChange = {
            option3 = it
            allSelected = option1 && option2 && option3
        },
        modifier = Modifier.padding(start = 24.dp)
    )
}
```

### Custom Colors [​](https://compose-miuix-ui.github.io/miuix/components/checkboxpreference#custom-colors)

kotlin

```
var customChecked by remember { mutableStateOf(false) }

CheckboxPreference(
    title = "Custom Colors",
    titleColor = BasicComponentDefaults.titleColor(
        color = MiuixTheme.colorScheme.primary
    ),
    summary = "Checkbox with custom colors",
    summaryColor = BasicComponentDefaults.summaryColor(
        color = MiuixTheme.colorScheme.secondary
    ),
    checked = customChecked,
    onCheckedChange = { customChecked = it },
    checkboxColors = CheckboxDefaults.checkboxColors(
        checkedForegroundColor = Color.Red,
        checkedBackgroundColor = MiuixTheme.colorScheme.secondary
    )
)
```

### Using with Dialog [​](https://compose-miuix-ui.github.io/miuix/components/checkboxpreference#using-with-dialog)

kotlin

```
var showDialog by remember { mutableStateOf(false) }
var privacyOption by remember { mutableStateOf(false) }
var analyticsOption by remember { mutableStateOf(false) }

Scaffold {
    ArrowPreference(
        title = "Privacy Settings",
        onClick = { showDialog = true },
        holdDownState = showDialog
    )

    OverlayDialog(
        title = "Privacy Settings",
        show = showDialog,
        onDismissRequest = { showDialog = false } // Close dialog
    ) {
        Card {
            CheckboxPreference(
                title = "Privacy Policy",
                summary = "Agree to the privacy policy terms",
                checked = privacyOption,
                onCheckedChange = { privacyOption = it }
            )

            CheckboxPreference(
                title = "Analytics Data",
                summary = "Allow collection of anonymous usage data to improve services",
                checked = analyticsOption,
                onCheckedChange = { analyticsOption = it }
            )
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(top = 12.dp)
        ) {
            TextButton(
                text = "Cancel",
                onClick = { showDialog = false }, // Close dialog
                modifier = Modifier.weight(1f)
            )
            Spacer(Modifier.width(16.dp))
            TextButton(
                text = "Confirm",
                onClick = { showDialog = false }, // Close dialog
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.textButtonColorsPrimary() // Use theme colors
            )
        }
    }
}
```

## Changelog[](https://compose-miuix-ui.github.io/miuix/components/checkboxpreference#changelog)

Last edited about 2 months ago

View full history

---
Source: [CheckboxPreference | Miuix](https://compose-miuix-ui.github.io/miuix/components/checkboxpreference)