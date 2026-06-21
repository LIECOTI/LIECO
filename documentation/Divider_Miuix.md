# Divider | Miuix

`Divider` is a basic layout component in Miuix used to separate content in lists and layouts. It provides both horizontal and vertical divider styles.

## Import [​](https://compose-miuix-ui.github.io/miuix/components/divider#import)

kotlin

```
import top.yukonga.miuix.kmp.basic.HorizontalDivider // Horizontal divider
import top.yukonga.miuix.kmp.basic.VerticalDivider   // Vertical divider
```

## Basic Usage [​](https://compose-miuix-ui.github.io/miuix/components/divider#basic-usage)

### Horizontal Divider [​](https://compose-miuix-ui.github.io/miuix/components/divider#horizontal-divider)

Horizontal divider is used to separate vertically arranged content:

kotlin

```
Column {
    Text("Content Above")
    HorizontalDivider()
    Text("Content Below")
}
```

### Vertical Divider [​](https://compose-miuix-ui.github.io/miuix/components/divider#vertical-divider)

Vertical divider is used to separate horizontally arranged content:

kotlin

```
Row {
    Text("Left Content")
    VerticalDivider()
    Text("Right Content")
}
```

## Properties [​](https://compose-miuix-ui.github.io/miuix/components/divider#properties)

### HorizontalDivider Properties [​](https://compose-miuix-ui.github.io/miuix/components/divider#horizontaldivider-properties)

| Property Name | Type | Description | Default Value | Required |
| --- | --- | --- | --- | --- |
| modifier | Modifier | Modifier applied to the divider | Modifier | No |
| thickness | Dp | Thickness of the divider | DividerDefaults.Thickness | No |
| color | Color | Color of the divider | DividerDefaults.DividerColor | No |

### VerticalDivider Properties [​](https://compose-miuix-ui.github.io/miuix/components/divider#verticaldivider-properties)

| Property Name | Type | Description | Default Value | Required |
| --- | --- | --- | --- | --- |
| modifier | Modifier | Modifier applied to the divider | Modifier | No |
| thickness | Dp | Thickness of the divider | DividerDefaults.Thickness | No |
| color | Color | Color of the divider | DividerDefaults.DividerColor | No |

### DividerDefaults Object [​](https://compose-miuix-ui.github.io/miuix/components/divider#dividerdefaults-object)

The DividerDefaults object provides default values for the divider components.

#### Constants [​](https://compose-miuix-ui.github.io/miuix/components/divider#constants)

| Constant Name | Type | Description | Default Value |
| --- | --- | --- | --- |
| Thickness | Dp | Default thickness of divider | 0.75.dp |
| DividerColor | Color | Default color of divider | MiuixTheme.colorScheme.dividerLine |

## Advanced Usage [​](https://compose-miuix-ui.github.io/miuix/components/divider#advanced-usage)

### Custom Thickness Divider [​](https://compose-miuix-ui.github.io/miuix/components/divider#custom-thickness-divider)

kotlin

```
Column {
    Text("Content Above")
    HorizontalDivider(
        thickness = 2.dp
    )
    Text("Content Below")
}
```

### Custom Color Divider [​](https://compose-miuix-ui.github.io/miuix/components/divider#custom-color-divider)

kotlin

```
Column {
    Text("Content Above")
    HorizontalDivider(
        color = Color.Red
    )
    Text("Content Below")
}
```

### Divider with Padding [​](https://compose-miuix-ui.github.io/miuix/components/divider#divider-with-padding)

kotlin

```
Column {
    Text("Content Above")
    HorizontalDivider(
        modifier = Modifier.padding(horizontal = 16.dp)
    )
    Text("Content Below")
}
```

### Using Vertical Divider Between Buttons [​](https://compose-miuix-ui.github.io/miuix/components/divider#using-vertical-divider-between-buttons)

kotlin

```
Row(
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
) {
    Button(onClick = { /* Handle click event */ }) {
        Text("Cancel")
    }
    VerticalDivider(
        modifier = Modifier.height(24.dp)
    )
    Button(onClick = { /* Handle click event */ }) {
        Text("Confirm")
    }
}
```

## Changelog[](https://compose-miuix-ui.github.io/miuix/components/divider#changelog)

Last edited about 2 months ago

View full history

---
Source: [Divider | Miuix](https://compose-miuix-ui.github.io/miuix/components/divider)