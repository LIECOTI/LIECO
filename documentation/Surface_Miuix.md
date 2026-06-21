# Surface | Miuix

`Surface` is a foundational container component in Miuix, used to provide consistent background and border effects for application content, offering a unified visual foundation for interface elements. It supports simple custom styles.

## Import [​](https://compose-miuix-ui.github.io/miuix/components/surface#import)

kotlin

```
import top.yukonga.miuix.kmp.basic.Surface
```

## Basic Usage [​](https://compose-miuix-ui.github.io/miuix/components/surface#basic-usage)

The Surface component can wrap other content, providing them with background, border, and shadow effects:

kotlin

```
Surface(
    modifier = Modifier
        .size(200.dp)
        .padding(16.dp),
    color = MiuixTheme.colorScheme.background,
    shape = RoundedCornerShape(16.dp),
    shadowElevation = 4.dp
) {
    Text(
        text = "Surface Example",
        modifier = Modifier.padding(16.dp)
    )
}
```

## Properties [​](https://compose-miuix-ui.github.io/miuix/components/surface#properties)

### Basic Surface Properties [​](https://compose-miuix-ui.github.io/miuix/components/surface#basic-surface-properties)

| Property Name | Type | Description | Default Value | Required |
| --- | --- | --- | --- | --- |
| modifier | Modifier | Modifiers applied to Surface | Modifier | No |
| shape | Shape | Shape of the Surface | SurfaceDefaults.Shape | No |
| color | Color | Background color of Surface | MiuixTheme.colorScheme.surface | No |
| contentColor | Color | Content color of Surface | MiuixTheme.colorScheme.onSurface | No |
| border | BorderStroke? | Border style of Surface | null | No |
| shadowElevation | Dp | Shadow elevation of Surface | SurfaceDefaults.ShadowElevation | No |
| content | @Composable () -> Unit | Composable function for the Surface content area | \- | Yes |

### Additional Properties for Clickable Surface [​](https://compose-miuix-ui.github.io/miuix/components/surface#additional-properties-for-clickable-surface)

| Property Name | Type | Description | Default Value | Required |
| --- | --- | --- | --- | --- |
| onClick | () -> Unit | Callback triggered on click | \- | Yes |
| enabled | Boolean | Whether the component is clickable | true | No |
| interactionSource | MutableInteractionSource? | Interaction source for the component | null | No |
| indication | Indication? | Indication for click interactions | LocalIndication.current | No |

### SurfaceDefaults Object [​](https://compose-miuix-ui.github.io/miuix/components/surface#surfacedefaults-object)

The SurfaceDefaults object provides default values for Surface components.

#### Constants [​](https://compose-miuix-ui.github.io/miuix/components/surface#constants)

| Constant Name | Type | Description | Default Value |
| --- | --- | --- | --- |
| Shape | Shape | Default shape of the Surface | RectangleShape |
| ShadowElevation | Dp | Default shadow elevation | 0.dp |

## Advanced Usage [​](https://compose-miuix-ui.github.io/miuix/components/surface#advanced-usage)

### Clickable Surface [​](https://compose-miuix-ui.github.io/miuix/components/surface#clickable-surface)

Create an interactive Surface to respond to user clicks:

kotlin

```
Surface(
    onClick = { /* Handle click event */ },
    modifier = Modifier.size(200.dp).padding(16.dp),
    shape = RoundedCornerShape(16.dp),
    color = MiuixTheme.colorScheme.primaryContainer,
    shadowElevation = 4.dp
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Clickable, like a button",
            modifier = Modifier.padding(16.dp).fillMaxSize(),
            textAlign = TextAlign.Center,
        )
    }
}
```

### Custom Styles [​](https://compose-miuix-ui.github.io/miuix/components/surface#custom-styles)

Create custom styles with different shapes, colors, and borders:

kotlin

```
Surface(
    modifier = Modifier.size(200.dp).padding(16.dp),
    shape = CircleShape,
    color = MiuixTheme.colorScheme.secondaryContainer,
    border = BorderStroke(2.dp, MiuixTheme.colorScheme.secondary),
    shadowElevation = 8.dp
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Circular Surface",
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center,
        )
    }
}
```

### Combined Usage [​](https://compose-miuix-ui.github.io/miuix/components/surface#combined-usage)

Combine Surface with other components to create card-like layouts:

kotlin

```
Surface(
    modifier = Modifier.fillMaxWidth().padding(16.dp),
    shape = RoundedCornerShape(16.dp),
    color = MiuixTheme.colorScheme.surface,
    border = BorderStroke(1.dp, MiuixTheme.colorScheme.outline.copy(alpha = 0.2f)),
    shadowElevation = 4.dp
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "Card Title",
            style = MiuixTheme.textStyles.headline1
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "This is the card content area, where various components and information can be placed. The Surface component provides a unified visual container.",
            style = MiuixTheme.textStyles.body1
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { /* Handle click event */ }
        ) {
            Text("Action Button")
        }
    }
}
```

### Disabled State [​](https://compose-miuix-ui.github.io/miuix/components/surface#disabled-state)

Create a clickable Surface with a disabled state:

kotlin

```
var isEnabled by remember { mutableStateOf(false) }

Surface(
    onClick = { /* Handle click event */ },
    enabled = isEnabled,
    modifier = Modifier.size(200.dp).padding(16.dp),
    shape = RoundedCornerShape(16.dp),
    color = MiuixTheme.colorScheme.surface.copy(alpha = 0.6f),
    shadowElevation = 1.dp
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Disabled Click State",
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center,
        )
    }
}
```

## Changelog[](https://compose-miuix-ui.github.io/miuix/components/surface#changelog)

Last edited about 2 months ago

View full history

---
Source: [Surface | Miuix](https://compose-miuix-ui.github.io/miuix/components/surface)