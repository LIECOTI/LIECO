# SmallTitle | Miuix

`SmallTitle` is a basic title component in Miuix used to create small-sized title text. It follows Miuix's design style with preset font size, weight, and padding.

## Import [​](https://compose-miuix-ui.github.io/miuix/components/smalltitle#import)

kotlin

```
import top.yukonga.miuix.kmp.basic.SmallTitle
```

## Basic Usage [​](https://compose-miuix-ui.github.io/miuix/components/smalltitle#basic-usage)

SmallTitle component can be used to display small title text:

kotlin

```
SmallTitle(
    text = "Small Title"
)
```

## Customization [​](https://compose-miuix-ui.github.io/miuix/components/smalltitle#customization)

### Custom Color [​](https://compose-miuix-ui.github.io/miuix/components/smalltitle#custom-color)

kotlin

```
SmallTitle(
    text = "Small Title with Custom Color",
    textColor = Color.Red
)
```

### Custom Padding [​](https://compose-miuix-ui.github.io/miuix/components/smalltitle#custom-padding)

kotlin

```
SmallTitle(
    text = "Small Title with Custom Padding",
    insideMargin = PaddingValues(16.dp, 4.dp)
)
```

## Properties [​](https://compose-miuix-ui.github.io/miuix/components/smalltitle#properties)

### SmallTitle Properties [​](https://compose-miuix-ui.github.io/miuix/components/smalltitle#smalltitle-properties)

| Property Name | Type | Description | Default Value | Required |
| --- | --- | --- | --- | --- |
| text | String | Text content to display | \- | Yes |
| modifier | Modifier | Modifier applied to component | Modifier | No |
| textColor | Color | Title text color | MiuixTheme.colorScheme.onBackgroundVariant | No |
| insideMargin | PaddingValues | Component internal padding | SmallTitleDefaults.InsideMargin | No |

### SmallTitleDefaults Object [​](https://compose-miuix-ui.github.io/miuix/components/smalltitle#smalltitledefaults-object)

The SmallTitleDefaults object provides default values for SmallTitle components.

#### Constants [​](https://compose-miuix-ui.github.io/miuix/components/smalltitle#constants)

| Constant Name | Type | Description | Default Value |
| --- | --- | --- | --- |
| InsideMargin | PaddingValues | Component internal padding | PaddingValues(28.dp, 8.dp) |

## Advanced Usage [​](https://compose-miuix-ui.github.io/miuix/components/smalltitle#advanced-usage)

### Using with Other Components [​](https://compose-miuix-ui.github.io/miuix/components/smalltitle#using-with-other-components)

kotlin

```
var checked by remember { mutableStateOf(false) }

Column {
    SmallTitle(text = "Settings")
    Card(
        modifier = Modifier.padding(horizontal = 12.dp).padding(bottom = 12.dp)
    ) {
        SwitchPreference(
            title = "Bluetooth",
            checked = checked,
            onCheckedChange = { checked = it }
        )
    }
    HorizontalDivider(
        modifier = Modifier.padding(horizontal = 12.dp)
    )
    SmallTitle(text = "Advanced Settings")
    // Other settings items
}
```

### Custom Styling [​](https://compose-miuix-ui.github.io/miuix/components/smalltitle#custom-styling)

kotlin

```
SmallTitle(
    text = "Fully Customized Style",
    modifier = Modifier
        .fillMaxWidth()
        .background(Color.LightGray),
    textColor = Color.Blue,
    insideMargin = PaddingValues(32.dp, 12.dp)
)
```

## Changelog[](https://compose-miuix-ui.github.io/miuix/components/smalltitle#changelog)

Last edited about 2 months ago

View full history

---
Source: [SmallTitle | Miuix](https://compose-miuix-ui.github.io/miuix/components/smalltitle)