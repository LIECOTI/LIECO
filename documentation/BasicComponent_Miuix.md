# BasicComponent | Miuix

`BasicComponent` is a foundational standard component in Miuix. It provides customizable content areas on the start and end sides, along with a title and summary, making it suitable for building list items, settings items, and other UI elements.

This project builds upon it to provide some extended components, enabling developers to quickly create UI components that conform to design specifications. See the usage of [Extended Components](https://compose-miuix-ui.github.io/miuix/components/#extended-components) for details.

## Import [​](https://compose-miuix-ui.github.io/miuix/components/basiccomponent#import)

kotlin

```
import top.yukonga.miuix.kmp.basic.BasicComponent
```

## Basic Usage [​](https://compose-miuix-ui.github.io/miuix/components/basiccomponent#basic-usage)

The BasicComponent can be used to display title and summary information:

kotlin

```
BasicComponent(
    title = "Setting Item Title",
    summary = "This is the description text for the setting item"
)
```

## Component Variants [​](https://compose-miuix-ui.github.io/miuix/components/basiccomponent#component-variants)

### Clickable Component [​](https://compose-miuix-ui.github.io/miuix/components/basiccomponent#clickable-component)

kotlin

```
BasicComponent(
    title = "Wi-Fi",
    summary = "Connected to MIUI-WiFi",
    onClick = { /* Handle click event */ }
)
```

### With Start Icon [​](https://compose-miuix-ui.github.io/miuix/components/basiccomponent#with-start-icon)

kotlin

```
BasicComponent(
    title = "Nickname",
    summary = "A brief introduction",
    startAction = {
        Icon(
            modifier = Modifier.padding(end = 16.dp),
            imageVector = MiuixIcons.Contacts,
            contentDescription = "Avatar Icon",
            tint = MiuixTheme.colorScheme.onBackground
        )
    },
    onClick = { /* Handle click event */ }
)
```

### With End Actions [​](https://compose-miuix-ui.github.io/miuix/components/basiccomponent#with-end-actions)

kotlin

```
var isFlightMode by remember { mutableStateOf(false) }

BasicComponent(
    title = "Flight Mode",
    endActions = {
        Switch(
            checked = isFlightMode,
            onCheckedChange = { isFlightMode = it }
        )
    }
)
```

### Custom Content Variant [​](https://compose-miuix-ui.github.io/miuix/components/basiccomponent#custom-content-variant)

In addition to the title and summary variant, BasicComponent also provides an overload that accepts custom content. This is useful when you want full control over the layout inside the component while still reusing the container and interactions:

kotlin

```
BasicComponent(
    startAction = {
        Icon(
            modifier = Modifier.padding(end = 16.dp),
            imageVector = MiuixIcons.Contacts,
            contentDescription = "Avatar Icon",
            tint = MiuixTheme.colorScheme.onBackground
        )
    },
    endActions = {
        Text("Details")
    }
) {
    Text(
        text = "Custom Title",
        style = MiuixTheme.textStyles.headline1
    )
    Text(
        text = "Custom content description",
        style = MiuixTheme.textStyles.body2
    )
}
```

## Component States [​](https://compose-miuix-ui.github.io/miuix/components/basiccomponent#component-states)

### Disabled State [​](https://compose-miuix-ui.github.io/miuix/components/basiccomponent#disabled-state)

kotlin

```
BasicComponent(
    title = "Mobile Network",
    summary = "SIM card not inserted",
    enabled = false
)
```

## Properties [​](https://compose-miuix-ui.github.io/miuix/components/basiccomponent#properties)

### BasicComponent Properties (title and summary variant) [​](https://compose-miuix-ui.github.io/miuix/components/basiccomponent#basiccomponent-properties-title-and-summary-variant)

| Property Name | Type | Description | Default Value | Required |
| --- | --- | --- | --- | --- |
| modifier | Modifier | Modifier for the component | Modifier | No |
| title | String? | Title of the component | null | No |
| titleColor | BasicComponentColors | Title color configuration | BasicComponentDefaults.titleColor() | No |
| summary | String? | Summary of the component | null | No |
| summaryColor | BasicComponentColors | Summary color configuration | BasicComponentDefaults.summaryColor() | No |
| startAction | @Composable (() -> Unit)? | Composable content on the start side of the component | null | No |
| endActions | @Composable (RowScope.() -> Unit)? | Composable content on the end side of the component | null | No |
| bottomAction | @Composable (() -> Unit)? | Composable content at the bottom of the component | null | No |
| insideMargin | PaddingValues | Internal padding of the component | BasicComponentDefaults.InsideMargin | No |
| onClick | (() -> Unit)? | Callback triggered when the component is clicked | null | No |
| onClickLabel | String? | Accessibility label describing the click action | null | No |
| role | Role? | Semantic role for accessibility services | null | No |
| holdDownState | Boolean | Whether the component is in the pressed state | false | No |
| enabled | Boolean | Whether the component is enabled | true | No |
| interactionSource | MutableInteractionSource? | Interaction source of the component | null | No |

### BasicComponent Properties (custom content variant) [​](https://compose-miuix-ui.github.io/miuix/components/basiccomponent#basiccomponent-properties-custom-content-variant)

| Property Name | Type | Description | Default Value | Required |
| --- | --- | --- | --- | --- |
| modifier | Modifier | Modifier for the component | Modifier | No |
| startAction | @Composable (() -> Unit)? | Composable content on the start side of the component | null | No |
| endActions | @Composable (RowScope.() -> Unit)? | Composable content on the end side of the component | null | No |
| bottomAction | @Composable (() -> Unit)? | Composable content at the bottom of the component | null | No |
| insideMargin | PaddingValues | Internal padding of the component | BasicComponentDefaults.InsideMargin | No |
| onClick | (() -> Unit)? | Callback triggered when the component is clicked | null | No |
| onClickLabel | String? | Accessibility label describing the click action | null | No |
| role | Role? | Semantic role for accessibility services | null | No |
| holdDownState | Boolean | Whether the component is in the pressed state | false | No |
| enabled | Boolean | Whether the component is enabled | true | No |
| interactionSource | MutableInteractionSource? | Interaction source of the component | null | No |
| content | @Composable ColumnScope.() -> Unit | Composable content of the component | \- | Yes |

### BasicComponentDefaults Object [​](https://compose-miuix-ui.github.io/miuix/components/basiccomponent#basiccomponentdefaults-object)

The BasicComponentDefaults object provides default values and color configurations for the BasicComponent.

#### BasicComponentDefaults Constants [​](https://compose-miuix-ui.github.io/miuix/components/basiccomponent#basiccomponentdefaults-constants)

| Constant Name | Type | Description | Default Value |
| --- | --- | --- | --- |
| InsideMargin | PaddingValues | Internal padding of the component | PaddingValues(16.dp) |

#### BasicComponentDefaults Methods [​](https://compose-miuix-ui.github.io/miuix/components/basiccomponent#basiccomponentdefaults-methods)

| Method Name | Type | Description |
| --- | --- | --- |
| titleColor() | BasicComponentColors | Creates title color configuration |
| summaryColor() | BasicComponentColors | Creates summary color configuration |

### BasicComponentColors Class [​](https://compose-miuix-ui.github.io/miuix/components/basiccomponent#basiccomponentcolors-class)

Used to configure the color states of the component.

| Property Name | Type | Description |
| --- | --- | --- |
| color | Color | Color in normal state |
| disabledColor | Color | Color in disabled state |

## Advanced Usage [​](https://compose-miuix-ui.github.io/miuix/components/basiccomponent#advanced-usage)

### Complex Layout Component [​](https://compose-miuix-ui.github.io/miuix/components/basiccomponent#complex-layout-component)

kotlin

```
BasicComponent(
    title = "Volume",
    summary = "Media Volume: 70%",
    startAction = {
        Icon(
            modifier = Modifier.padding(end = 16.dp),
            imageVector = MiuixIcons.Play,
            contentDescription = "Volume Icon",
            tint = MiuixTheme.colorScheme.onBackground
        )
    },
    endActions = {
        IconButton(onClick = { /* Decrease volume */ }) {
            Icon(
                imageVector = MiuixIcons.Remove,
                contentDescription = "Decrease Volume",
                tint = MiuixTheme.colorScheme.onBackground
            )
        }
        Text("70%")
        IconButton(onClick = { /* Increase volume */ }) {
            Icon(
                imageVector = MiuixIcons.Add,
                contentDescription = "Increase Volume",
                tint = MiuixTheme.colorScheme.onBackground
            )
        }
    }
)
```

### Custom Style Component [​](https://compose-miuix-ui.github.io/miuix/components/basiccomponent#custom-style-component)

kotlin

```
BasicComponent(
    title = "Custom Component",
    summary = "Using custom colors",
    titleColor = BasicComponentColors(
        color = Color.Blue,
        disabledColor = Color.Gray
    ),
    summaryColor = BasicComponentColors(
        color = Color.DarkGray,
        disabledColor = Color.LightGray
    ),
    insideMargin = PaddingValues(horizontal = 24.dp, vertical = 12.dp),
    onClick = { /* Handle option click */ }
)
```

### Usage in a List [​](https://compose-miuix-ui.github.io/miuix/components/basiccomponent#usage-in-a-list)

kotlin

```
val options = listOf("Option 1", "Option 2", "Option 3", "Option 4")

Column {
    options.forEach { option ->
        BasicComponent(
            title = option,
            onClick = { /* Handle option click */ }
        )
    }
}
```

## Changelog[](https://compose-miuix-ui.github.io/miuix/components/basiccomponent#changelog)

Last edited about 2 months ago

View full history

---
Source: [BasicComponent | Miuix](https://compose-miuix-ui.github.io/miuix/components/basiccomponent)