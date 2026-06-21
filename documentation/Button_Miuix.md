# Button | Miuix

`Button` is a basic interactive component in Miuix, used to trigger actions or events. It provides multiple style options, including primary buttons, secondary buttons, and text buttons.

## Import [​](https://compose-miuix-ui.github.io/miuix/components/button#import)

kotlin

```
import top.yukonga.miuix.kmp.basic.Button
```

## Basic Usage [​](https://compose-miuix-ui.github.io/miuix/components/button#basic-usage)

The Button component can be used to trigger actions or events:

kotlin

```
Button(
    onClick = { /* Handle click event */ }
) {
    Text("Button")
}
```

## Button Types [​](https://compose-miuix-ui.github.io/miuix/components/button#button-types)

Miuix provides various types of buttons suitable for different scenarios and levels of importance:

### Primary Button [​](https://compose-miuix-ui.github.io/miuix/components/button#primary-button)

kotlin

```
Button(
    onClick = { /* Handle click event */ },
    colors = ButtonDefaults.buttonColorsPrimary()
) {
    Text("Primary Button")
}
```

### Secondary Button [​](https://compose-miuix-ui.github.io/miuix/components/button#secondary-button)

kotlin

```
Button(
    onClick = { /* Handle click event */ },
    colors = ButtonDefaults.buttonColors()
) {
    Text("Secondary Button")
}
```

### Text Button [​](https://compose-miuix-ui.github.io/miuix/components/button#text-button)

kotlin

```
TextButton(
    text = "Text Button",
    onClick = { /* Handle click event */ }
)
```

## Component States [​](https://compose-miuix-ui.github.io/miuix/components/button#component-states)

### Disabled State [​](https://compose-miuix-ui.github.io/miuix/components/button#disabled-state)

kotlin

```
Button(
    onClick = { /* Handle click event */ },
    enabled = false
) {
    Text("Disabled Button")
}
```

## Properties [​](https://compose-miuix-ui.github.io/miuix/components/button#properties)

### Button Properties [​](https://compose-miuix-ui.github.io/miuix/components/button#button-properties)

| Property Name | Type | Description | Default Value | Required |
| --- | --- | --- | --- | --- |
| onClick | () -> Unit | Callback triggered on click | \- | Yes |
| modifier | Modifier | Modifier applied to the button | Modifier | No |
| enabled | Boolean | Whether the button is clickable | true | No |
| cornerRadius | Dp | Corner radius of the button | ButtonDefaults.CornerRadius | No |
| minWidth | Dp | Minimum width of the button | ButtonDefaults.MinWidth | No |
| minHeight | Dp | Minimum height of the button | ButtonDefaults.MinHeight | No |
| colors | ButtonColors | Button color configuration | ButtonDefaults.buttonColors() | No |
| insideMargin | PaddingValues | Internal padding of the button | ButtonDefaults.InsideMargin | No |
| interactionSource | MutableInteractionSource? | Interaction source for the button | null | No |
| indication | Indication? | Indication for click interactions | LocalIndication.current | No |
| content | @Composable RowScope.() -> Unit | Composable function for button content | \- | Yes |

### TextButton Properties [​](https://compose-miuix-ui.github.io/miuix/components/button#textbutton-properties)

| Property Name | Type | Description | Default Value | Required |
| --- | --- | --- | --- | --- |
| text | String | Text displayed on the button | \- | Yes |
| onClick | () -> Unit | Callback triggered on click | \- | Yes |
| modifier | Modifier | Modifier applied to the button | Modifier | No |
| enabled | Boolean | Whether the button is clickable | true | No |
| cornerRadius | Dp | Corner radius of the button | ButtonDefaults.CornerRadius | No |
| minWidth | Dp | Minimum width of the button | ButtonDefaults.MinWidth | No |
| minHeight | Dp | Minimum height of the button | ButtonDefaults.MinHeight | No |
| colors | TextButtonColors | Text button color configuration | ButtonDefaults.textButtonColors() | No |
| insideMargin | PaddingValues | Internal padding of the button | ButtonDefaults.InsideMargin | No |
| interactionSource | MutableInteractionSource? | Interaction source for the button | null | No |
| indication | Indication? | Indication for click interactions | LocalIndication.current | No |

### ButtonDefaults Object [​](https://compose-miuix-ui.github.io/miuix/components/button#buttondefaults-object)

The ButtonDefaults object provides default values and color configurations for button components.

#### Constants [​](https://compose-miuix-ui.github.io/miuix/components/button#constants)

| Constant Name | Type | Description | Default Value |
| --- | --- | --- | --- |
| MinWidth | Dp | Minimum width of the button | 58.dp |
| MinHeight | Dp | Minimum height of the button | 40.dp |
| CornerRadius | Dp | Corner radius of the button | 16.dp |
| InsideMargin | PaddingValues | Internal padding of the button | PaddingValues(horizontal = 16.dp, vertical = 13.dp) |

#### Methods [​](https://compose-miuix-ui.github.io/miuix/components/button#methods)

| Method Name | Type | Description |
| --- | --- | --- |
| buttonColors() | ButtonColors | Creates color configuration for secondary buttons |
| buttonColorsPrimary() | ButtonColors | Creates color configuration for primary buttons |
| textButtonColors() | TextButtonColors | Creates color configuration for secondary text buttons |
| textButtonColorsPrimary() | TextButtonColors | Creates color configuration for primary text buttons |

## Advanced Usage [​](https://compose-miuix-ui.github.io/miuix/components/button#advanced-usage)

### Button with Icon [​](https://compose-miuix-ui.github.io/miuix/components/button#button-with-icon)

kotlin

```
Button(
    onClick = { /* Handle click event */ }
) {
    Icon(
        imageVector = MiuixIcons.Favorites,
        contentDescription = "Favorites"
    )
    Spacer(modifier = Modifier.width(8.dp))
    Text("Button with Icon")
}
```

### Custom Style Button [​](https://compose-miuix-ui.github.io/miuix/components/button#custom-style-button)

kotlin

```
Button(
    onClick = { /* Handle click event */ },
    colors = ButtonDefaults.buttonColors(
        color = Color.Red.copy(alpha = 0.7f)
    ),
    cornerRadius = 8.dp
) {
    Text("Custom Button")
}
```

### Loading State Button [​](https://compose-miuix-ui.github.io/miuix/components/button#loading-state-button)

kotlin

```
var isLoading by remember { mutableStateOf(false) }
val scope = rememberCoroutineScope()

Button(
    onClick = {
        isLoading = true
        // Simulate operation
        scope.launch {
            delay(2000)
            isLoading = false
        }
    },
    enabled = !isLoading
) {
     AnimatedVisibility(
        visible = isLoading
    ) {
        CircularProgressIndicator(
            modifier = Modifier.padding(end = 8.dp),
            size = 20.dp,
            strokeWidth = 4.dp
        )
    }
    Text("Submit")
}
```

## Changelog[](https://compose-miuix-ui.github.io/miuix/components/button#changelog)

Last edited 16 days ago

View full history

---
Source: [Button | Miuix](https://compose-miuix-ui.github.io/miuix/components/button)