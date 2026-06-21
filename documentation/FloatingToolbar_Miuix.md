# FloatingToolbar | Miuix

`FloatingToolbar` is a floating toolbar component in Miuix that renders its content within a container with a rounded background, arranged either horizontally or vertically. The actual placement on the screen is handled by the parent component, typically `Scaffold`.

This component is usually used in conjunction with `Scaffold`, placed in a specific position on the page to provide quick actions or display information.

## Import [​](https://compose-miuix-ui.github.io/miuix/components/floatingtoolbar#import)

kotlin

```
import top.yukonga.miuix.kmp.basic.FloatingToolbar
import top.yukonga.miuix.kmp.basic.FloatingToolbarDefaults
import top.yukonga.miuix.kmp.basic.ToolbarPosition // Used for Scaffold
```

## Basic Usage [​](https://compose-miuix-ui.github.io/miuix/components/floatingtoolbar#basic-usage)

kotlin

```
Scaffold(
    floatingToolbar = {
        FloatingToolbar {
            Row(
                modifier = Modifier.padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) { // or Column
                IconButton(onClick = { /* Action 1 */ }) {
                    Icon(MiuixIcons.Edit, contentDescription = "Edit")
                }
                IconButton(onClick = { /* Action 2 */ }) {
                    Icon(MiuixIcons.Delete, contentDescription = "Delete")
                }
            }
        }
    },
    floatingToolbarPosition = ToolbarPosition.BottomCenter // Set the position
)
```

## Properties [​](https://compose-miuix-ui.github.io/miuix/components/floatingtoolbar#properties)

### FloatingToolbar Properties [​](https://compose-miuix-ui.github.io/miuix/components/floatingtoolbar#floatingtoolbar-properties)

| Property Name | Type | Description | Default Value | Required |
| --- | --- | --- | --- | --- |
| modifier | Modifier | Modifier applied to the toolbar | Modifier | No |
| color | Color | Background color of the toolbar | FloatingToolbarDefaults.defaultColor() | No |
| cornerRadius | Dp | Corner radius of the toolbar | FloatingToolbarDefaults.CornerRadius | No |
| outSidePadding | PaddingValues | Padding outside the toolbar | FloatingToolbarDefaults.OutSidePadding | No |
| shadowElevation | Dp | The shadow elevation of the toolbar | 4.dp | No |
| showDivider | Boolean | Show divider line around the toolbar | false | No |
| content | @Composable () -> Unit | Composable content area of the toolbar | \- | Yes |

### FloatingToolbarDefaults Object [​](https://compose-miuix-ui.github.io/miuix/components/floatingtoolbar#floatingtoolbardefaults-object)

| Property Name | Type | Description | Value |
| --- | --- | --- | --- |
| CornerRadius | Dp | Default corner radius | 50.dp |
| defaultColor() | @Composable () -> Color | Default background color | MiuixTheme.colorScheme.surfaceContainer |
| OutSidePadding | PaddingValues | Default outside padding | PaddingValues(12.dp, 8.dp) |

### ToolbarPosition (for Scaffold) [​](https://compose-miuix-ui.github.io/miuix/components/floatingtoolbar#toolbarposition-for-scaffold)

Please refer to the `ToolbarPosition` options in the [Scaffold](https://compose-miuix-ui.github.io/miuix/components/scaffold#toolbarposition-options) documentation.

## Advanced Usage [​](https://compose-miuix-ui.github.io/miuix/components/floatingtoolbar#advanced-usage)

### Custom Styles [​](https://compose-miuix-ui.github.io/miuix/components/floatingtoolbar#custom-styles)

kotlin

```
FloatingToolbar(
    color = MiuixTheme.colorScheme.primaryContainer,
    cornerRadius = 16.dp,
    outSidePadding = PaddingValues(24.dp),
    showDivider = false
) {
    Row(
        modifier = Modifier.padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) { // or Column
        IconButton(onClick = { /* Action 1 */ }) {
            Icon(MiuixIcons.Edit, contentDescription = "Edit", tint = MiuixTheme.colorScheme.onPrimaryContainer)
        }
        IconButton(onClick = { /* Action 2 */ }) {
            Icon(MiuixIcons.Delete, contentDescription = "Delete", tint = MiuixTheme.colorScheme.onPrimaryContainer)
        }
    }
}
```

### Vertically Arranged Content [​](https://compose-miuix-ui.github.io/miuix/components/floatingtoolbar#vertically-arranged-content)

kotlin

```
FloatingToolbar {
    Column(
        modifier = Modifier.padding(vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        IconButton(onClick = { /* Action 1 */ }) {
            Icon(MiuixIcons.Edit, contentDescription = "Edit")
        }
        IconButton(onClick = { /* Action 2 */ }) {
            Icon(MiuixIcons.Delete, contentDescription = "Delete")
        }
    }
}
```

### Changing Position with Scaffold [​](https://compose-miuix-ui.github.io/miuix/components/floatingtoolbar#changing-position-with-scaffold)

kotlin

```
Scaffold(
    floatingToolbar = {
        FloatingToolbar {
            // toolbar content
        }
    },
    floatingToolbarPosition = ToolbarPosition.CenterEnd // Place centered on the right edge
)
```

## Changelog[](https://compose-miuix-ui.github.io/miuix/components/floatingtoolbar#changelog)

Last edited about 2 months ago

View full history

---
Source: [FloatingToolbar | Miuix](https://compose-miuix-ui.github.io/miuix/components/floatingtoolbar)