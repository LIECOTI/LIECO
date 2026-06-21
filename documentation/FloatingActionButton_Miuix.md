# FloatingActionButton | Miuix

`FloatingActionButton` is a floating button component in Miuix, typically used to display the most important or frequently used actions on a page. It usually floats above the interface with a prominent visual effect for quick user access.

This component is typically used in conjunction with the `Scaffold` component to maintain consistent layout and behavior across different pages in the application.

## Import [​](https://compose-miuix-ui.github.io/miuix/components/floatingactionbutton#import)

kotlin

```
import top.yukonga.miuix.kmp.basic.FloatingActionButton
```

## Basic Usage [​](https://compose-miuix-ui.github.io/miuix/components/floatingactionbutton#basic-usage)

The FloatingActionButton component can be used to trigger important actions:

kotlin

```
FloatingActionButton(
    onClick = { /* Handle click event */ }
) {
    Icon(
        imageVector = MiuixIcons.Add,
        contentDescription = "Add"
    )
}
```

## Component States [​](https://compose-miuix-ui.github.io/miuix/components/floatingactionbutton#component-states)

Since this component is typically used for the most common actions, it does not have built-in state variations.

## Properties [​](https://compose-miuix-ui.github.io/miuix/components/floatingactionbutton#properties)

### FloatingActionButton Properties [​](https://compose-miuix-ui.github.io/miuix/components/floatingactionbutton#floatingactionbutton-properties)

| Property Name | Type | Description | Default Value | Required |
| --- | --- | --- | --- | --- |
| onClick | () -> Unit | Callback triggered when clicked | \- | Yes |
| modifier | Modifier | Modifier applied to the button | Modifier | No |
| shape | Shape | Shape of the button | CircleShape | No |
| containerColor | Color | Background color of the button | MiuixTheme.colorScheme.primary | No |
| shadowElevation | Dp | Shadow elevation of the button | FloatingActionButtonDefaults.ShadowElevation | No |
| minWidth | Dp | Minimum width of the button | FloatingActionButtonDefaults.MinWidth | No |
| minHeight | Dp | Minimum height of the button | FloatingActionButtonDefaults.MinHeight | No |
| content | @Composable () -> Unit | Composable content of the button | \- | Yes |

### FloatingActionButtonDefaults Object [​](https://compose-miuix-ui.github.io/miuix/components/floatingactionbutton#floatingactionbuttondefaults-object)

The FloatingActionButtonDefaults object provides default values for FloatingActionButton components.

#### Constants [​](https://compose-miuix-ui.github.io/miuix/components/floatingactionbutton#constants)

| Constant Name | Type | Description | Default Value |
| --- | --- | --- | --- |
| MinWidth | Dp | Minimum width of the button | 60.dp |
| MinHeight | Dp | Minimum height of the button | 60.dp |
| ShadowElevation | Dp | Shadow elevation of the button | 4.dp |

## Advanced Usage [​](https://compose-miuix-ui.github.io/miuix/components/floatingactionbutton#advanced-usage)

### Custom Color [​](https://compose-miuix-ui.github.io/miuix/components/floatingactionbutton#custom-color)

kotlin

```
FloatingActionButton(
    onClick = { /* Handle click event */ },
    containerColor = Color.Red
) {
    Icon(
        imageVector = MiuixIcons.Favorites,
        contentDescription = "Favorites",
        tint = Color.White
    )
}
```

### Extended Floating Action Button [​](https://compose-miuix-ui.github.io/miuix/components/floatingactionbutton#extended-floating-action-button)

kotlin

```
FloatingActionButton(
    onClick = { /* Handle click event */ },
    shape = RoundedCornerShape(16.dp),
    minWidth = 120.dp
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Icon(
            imageVector = MiuixIcons.Add,
            contentDescription = "Add",
            tint = Color.White
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text("Add", color = Color.White)
    }
}
```

### Floating Action Button with Scaffold [​](https://compose-miuix-ui.github.io/miuix/components/floatingactionbutton#floating-action-button-with-scaffold)

kotlin

```
Scaffold(
    floatingActionButton = {
        FloatingActionButton(
            onClick = { /* Handle click event */ }
        ) {
            Icon(
                imageVector = MiuixIcons.Add,
                contentDescription = "Add"
            )
        }
    },
    floatingActionButtonPosition = FabPosition.End
) { paddingValues ->
    // Content area needs to consider padding
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        // ...
    }
}
```

### Animated Floating Action Button [​](https://compose-miuix-ui.github.io/miuix/components/floatingactionbutton#animated-floating-action-button)

kotlin

```
var expanded by remember { mutableStateOf(false) }
val animatedSize by animateDpAsState(
    targetValue = if (expanded) 65.dp else 60.dp,
    label = "FAB size animation",
)

FloatingActionButton(
    onClick = { expanded = !expanded },
    minWidth = animatedSize,
    minHeight = animatedSize
) {
    Icon(
        imageVector = if (expanded) MiuixIcons.Remove else MiuixIcons.Add,
        contentDescription = if (expanded) "Remove" else "Add",
        tint = Color.White
    )
}
```

## Changelog[](https://compose-miuix-ui.github.io/miuix/components/floatingactionbutton#changelog)

Last edited about 2 months ago

View full history

---
Source: [FloatingActionButton | Miuix](https://compose-miuix-ui.github.io/miuix/components/floatingactionbutton)