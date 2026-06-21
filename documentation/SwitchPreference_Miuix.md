# SwitchPreference | Miuix

`SwitchPreference` is a switch component in Miuix that provides a title, summary, and a switch control on the right. It supports click interaction and is commonly used in settings items and preference toggles.

## Import [​](https://compose-miuix-ui.github.io/miuix/components/switchpreference#import)

kotlin

```
import top.yukonga.miuix.kmp.preference.SwitchPreference
```

## Basic Usage [​](https://compose-miuix-ui.github.io/miuix/components/switchpreference#basic-usage)

The SwitchPreference component provides basic switch functionality:

kotlin

```
var isChecked by remember { mutableStateOf(false) }

SwitchPreference(
    title = "Switch Option",
    checked = isChecked,
    onCheckedChange = { isChecked = it }
)
```

## Switch with Summary [​](https://compose-miuix-ui.github.io/miuix/components/switchpreference#switch-with-summary)

kotlin

```
var wifiEnabled by remember { mutableStateOf(false) }

SwitchPreference(
    title = "WiFi",
    summary = "Turn on to connect to wireless networks",
    checked = wifiEnabled,
    onCheckedChange = { wifiEnabled = it }
)
```

## Component States [​](https://compose-miuix-ui.github.io/miuix/components/switchpreference#component-states)

### Disabled State [​](https://compose-miuix-ui.github.io/miuix/components/switchpreference#disabled-state)

kotlin

```
SwitchPreference(
    title = "Disabled Switch",
    summary = "This switch is currently unavailable",
    checked = true,
    onCheckedChange = {},
    enabled = false
)
```

## Properties [​](https://compose-miuix-ui.github.io/miuix/components/switchpreference#properties)

### SwitchPreference Properties [​](https://compose-miuix-ui.github.io/miuix/components/switchpreference#switchpreference-properties)

| Property Name | Type | Description | Default Value | Required |
| --- | --- | --- | --- | --- |
| checked | Boolean | Switch checked state | \- | Yes |
| onCheckedChange | (Boolean) -> Unit | Switch state change callback | \- | Yes |
| title | String | Switch item title | \- | Yes |
| modifier | Modifier | Component modifier | Modifier | No |
| titleColor | BasicComponentColors | Title text color configuration | BasicComponentDefaults.titleColor() | No |
| summary | String? | Switch item summary | null | No |
| summaryColor | BasicComponentColors | Summary text color configuration | BasicComponentDefaults.summaryColor() | No |
| startAction | @Composable (() -> Unit)? | Custom start side content | null | No |
| endActions | @Composable RowScope.() -> Unit | Custom end side content (before switch) | {} | No |
| bottomAction | @Composable (() -> Unit)? | Custom bottom side content | null | No |
| switchColors | SwitchColors | Switch control color configuration | SwitchDefaults.switchColors() | No |
| insideMargin | PaddingValues | Component internal content padding | BasicComponentDefaults.InsideMargin | No |
| holdDownState | Boolean | Whether the component is held down | false | No |
| enabled | Boolean | Component interactive state | true | No |

## Advanced Usage [​](https://compose-miuix-ui.github.io/miuix/components/switchpreference#advanced-usage)

### With Start Icon [​](https://compose-miuix-ui.github.io/miuix/components/switchpreference#with-start-icon)

kotlin

```
var enabled by remember { mutableStateOf(false) }

SwitchPreference(
    title = "Test",
    summary = "Enable to allow testing",
    checked = enabled,
    onCheckedChange = { enabled = it },
    startAction = {
        Icon(
            imageVector = MiuixIcons.Sort,
            contentDescription = "Command Icon",
            tint = MiuixTheme.colorScheme.onBackground,
            modifier = Modifier.padding(end = 12.dp)
        )
    }
)
```

### With End Actions [​](https://compose-miuix-ui.github.io/miuix/components/switchpreference#with-end-actions)

kotlin

```
var locationEnabled by remember { mutableStateOf(false) }

SwitchPreference(
    title = "Location Services",
    summary = "Allow apps to access location information",
    checked = locationEnabled,
    onCheckedChange = { locationEnabled = it },
    endActions = {
        Text(
            text = if (locationEnabled) "Enabled" else "Disabled",
            color = MiuixTheme.colorScheme.onSurfaceVariantActions,
            modifier = Modifier.padding(end = 6.dp)
        )
    }
)
```

### With Animated Content Visibility [​](https://compose-miuix-ui.github.io/miuix/components/switchpreference#with-animated-content-visibility)

kotlin

```
var parentEnabled by remember { mutableStateOf(false) }
var childEnabled by remember { mutableStateOf(false) }

Column {
    SwitchPreference(
        title = "Main Setting",
        summary = "Turn on to show more options",
        checked = parentEnabled,
        onCheckedChange = { parentEnabled = it }
    )
    AnimatedVisibility(
        visible = parentEnabled
    ) {
        SwitchPreference(
            title = "Sub Setting",
            summary = "Only available when main setting is enabled",
            checked = childEnabled,
            onCheckedChange = { childEnabled = it }
        )
    }
}
```

### Custom Colors [​](https://compose-miuix-ui.github.io/miuix/components/switchpreference#custom-colors)

kotlin

```
var customEnabled by remember { mutableStateOf(false) }

SwitchPreference(
    title = "Custom Colors",
    titleColor = BasicComponentDefaults.titleColor(
        color = MiuixTheme.colorScheme.primary
    ),
    summary = "Switch with custom colors",
    summaryColor = BasicComponentDefaults.summaryColor(
        color = MiuixTheme.colorScheme.secondary
    ),
    checked = customEnabled,
    onCheckedChange = { customEnabled = it },
    switchColors = SwitchDefaults.switchColors(
        checkedThumbColor = MiuixTheme.colorScheme.primary,
        checkedTrackColor = MiuixTheme.colorScheme.primary.copy(alpha = 0.2f)
    )
)
```

### Use with Dialog [​](https://compose-miuix-ui.github.io/miuix/components/switchpreference#use-with-dialog)

kotlin

```
var showDialog by remember { mutableStateOf(false) }
var option by remember { mutableStateOf(false) }

Scaffold {
    ArrowPreference(
        title = "Advanced Settings",
        onClick = { showDialog = true },
        holdDownState = showDialog
    )
    OverlayDialog(
        title = "Advanced Settings",
        show = showDialog,
        onDismissRequest = { showDialog = false }
    ) {
        Card {
            SwitchPreference(
                title = "Experimental Features",
                summary = "Enable features under development",
                checked = option,
                onCheckedChange = { option = it }
            )
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

## Changelog[](https://compose-miuix-ui.github.io/miuix/components/switchpreference#changelog)

Last edited about 2 months ago

View full history

---
Source: [SwitchPreference | Miuix](https://compose-miuix-ui.github.io/miuix/components/switchpreference)