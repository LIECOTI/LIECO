# NavigationBar | Miuix

`NavigationBar` is a bottom navigation bar component in Miuix, used to create navigation menus fixed at the bottom of applications. It supports 2 to 5 navigation items, offering different display modes (icon only, text only, icon and text, icon with selected label).

`FloatingNavigationBar` is a floating-style bottom navigation bar component, also supporting 2 to 5 navigation items, showing icons only.

These components are typically used in conjunction with the `Scaffold` component to maintain consistent layout and behavior across different pages in the application.

## Import [​](https://compose-miuix-ui.github.io/miuix/components/navigationbar#import)

kotlin

```
import top.yukonga.miuix.kmp.basic.NavigationBar
import top.yukonga.miuix.kmp.basic.NavigationBarItem
import top.yukonga.miuix.kmp.basic.FloatingNavigationBar
import top.yukonga.miuix.kmp.basic.FloatingNavigationBarItem
import top.yukonga.miuix.kmp.basic.NavigationBarDisplayMode
```

## Basic Usage [​](https://compose-miuix-ui.github.io/miuix/components/navigationbar#basic-usage)

### NavigationBar [​](https://compose-miuix-ui.github.io/miuix/components/navigationbar#navigationbar-1)

The NavigationBar component can be used to create bottom navigation menus fixed to the bottom:

kotlin

```
var selectedIndex by remember { mutableStateOf(0) }
val items = listOf("Home", "Profile", "Settings")
val icons = listOf(MiuixIcons.VerticalSplit, MiuixIcons.Contacts, MiuixIcons.Settings)

Scaffold(
    bottomBar = {
        NavigationBar {
            items.forEachIndexed { index, label ->
                NavigationBarItem(
                    selected = selectedIndex == index,
                    onClick = { selectedIndex = index },
                    icon = icons[index],
                    label = label
                )
            }
        }
    }
)
```

### FloatingNavigationBar [​](https://compose-miuix-ui.github.io/miuix/components/navigationbar#floatingnavigationbar)

The FloatingNavigationBar component can be used to create floating navigation menus at the bottom:

kotlin

```
var selectedIndex by remember { mutableStateOf(0) }
val items = listOf("Home", "Profile", "Settings")
val icons = listOf(MiuixIcons.VerticalSplit, MiuixIcons.Contacts, MiuixIcons.Settings)

Scaffold(
    bottomBar = {
        FloatingNavigationBar {
            items.forEachIndexed { index, label ->
                FloatingNavigationBarItem(
                    selected = selectedIndex == index,
                    onClick = { selectedIndex = index },
                    icon = icons[index],
                    label = label
                )
            }
        }
    }
)
```

## Component States [​](https://compose-miuix-ui.github.io/miuix/components/navigationbar#component-states)

### Selected State [​](https://compose-miuix-ui.github.io/miuix/components/navigationbar#selected-state)

`NavigationBarItem` automatically handles the visual style of the selected item, displaying it with bold text and highlighting the icon/text. `FloatingNavigationBarItem` highlights the icon when selected.

## Properties [​](https://compose-miuix-ui.github.io/miuix/components/navigationbar#properties)

### NavigationBar Properties [​](https://compose-miuix-ui.github.io/miuix/components/navigationbar#navigationbar-properties)

| Property Name | Type | Description | Default Value | Required |
| --- | --- | --- | --- | --- |
| modifier | Modifier | Modifier applied to the nav bar | Modifier | No |
| color | Color | Background color of the nav bar | MiuixTheme.colorScheme.surface | No |
| showDivider | Boolean | Show top divider line or not | true | No |
| defaultWindowInsetsPadding | Boolean | Apply default window insets padding | true | No |
| mode | NavigationBarDisplayMode | Display mode for items | NavigationBarDisplayMode.IconAndText | No |
| content | @Composable RowScope.() | The content of the nav bar | \- | Yes |

### NavigationBarItem Properties [​](https://compose-miuix-ui.github.io/miuix/components/navigationbar#navigationbaritem-properties)

| Property Name | Type | Description | Default Value | Required |
| --- | --- | --- | --- | --- |
| selected | Boolean | Whether the item is selected | \- | Yes |
| onClick | () -> Unit | Callback when the item is clicked | \- | Yes |
| icon | ImageVector | Icon of the item | \- | Yes |
| label | String | Label of the item | \- | Yes |
| modifier | Modifier | Modifier applied to the item | Modifier | No |
| enabled | Boolean | Whether the item is enabled | true | No |

### FloatingNavigationBar Properties [​](https://compose-miuix-ui.github.io/miuix/components/navigationbar#floatingnavigationbar-properties)

| Property Name | Type | Description | Default Value | Required |
| --- | --- | --- | --- | --- |
| modifier | Modifier | Modifier applied to the nav bar | Modifier | No |
| color | Color | Background color of the nav bar | MiuixTheme.colorScheme.surfaceContainer | No |
| cornerRadius | Dp | Corner radius of the nav bar | FloatingToolbarDefaults.CornerRadius | No |
| horizontalAlignment | Alignment.Horizontal | Horizontal alignment within its parent | CenterHorizontally | No |
| horizontalOutSidePadding | Dp | Horizontal padding outside the nav bar | FloatingNavigationBarDefaults.HorizontalOutSidePadding | No |
| shadowElevation | Dp | The shadow elevation of the nav bar | FloatingNavigationBarDefaults.ShadowElevation | No |
| showDivider | Boolean | Show divider line around the nav bar | false | No |
| defaultWindowInsetsPadding | Boolean | Apply default window insets padding | true | No |
| content | @Composable () -> Unit | The content of the nav bar | \- | Yes |

### FloatingNavigationBarItem Properties [​](https://compose-miuix-ui.github.io/miuix/components/navigationbar#floatingnavigationbaritem-properties)

| Property Name | Type | Description | Default Value | Required |
| --- | --- | --- | --- | --- |
| selected | Boolean | Whether the item is selected | \- | Yes |
| onClick | () -> Unit | Callback when the item is clicked | \- | Yes |
| icon | ImageVector | Icon of the item | \- | Yes |
| label | String | Label of the item | \- | Yes |
| modifier | Modifier | Modifier applied to the item | Modifier | No |
| enabled | Boolean | Whether the item is enabled | true | No |

### NavigationBarDefaults Object [​](https://compose-miuix-ui.github.io/miuix/components/navigationbar#navigationbardefaults-object)

The NavigationBarDefaults object provides default values for NavigationBar and NavigationBarItem components.

#### Constants [​](https://compose-miuix-ui.github.io/miuix/components/navigationbar#constants)

| Constant Name | Type | Description | Default Value |
| --- | --- | --- | --- |
| ItemHeight | Dp | Item height | 64.dp |
| IconSize | Dp | Icon size | 26.dp |
| TextFontSize | TextUnit | Text font size (TextOnly mode) | 14.sp |
| LabelFontSize | TextUnit | Label font size | 12.sp |
| IconTopPadding | Dp | Top padding for the icon | 8.dp |
| BottomPadding | Dp | Bottom padding for the label | 8.dp |
| SelectedPressedAlpha | Float | Alpha value for selected item when pressed | 0.5f |
| UnselectedPressedAlpha | Float | Alpha value for unselected item when pressed | 0.6f |
| UnselectedAlpha | Float | Alpha value for unselected item | 0.4f |

### FloatingNavigationBarDefaults Object [​](https://compose-miuix-ui.github.io/miuix/components/navigationbar#floatingnavigationbardefaults-object)

The FloatingNavigationBarDefaults object provides default values for FloatingNavigationBar and FloatingNavigationBarItem components.

#### Constants [​](https://compose-miuix-ui.github.io/miuix/components/navigationbar#constants-1)

| Constant Name | Type | Description | Default Value |
| --- | --- | --- | --- |
| HorizontalOutSidePadding | Dp | Horizontal outside padding | 36.dp |
| ShadowElevation | Dp | Shadow elevation | 1.dp |
| HorizontalPadding | Dp | Horizontal padding inside the bar | 12.dp |
| ItemSpacing | Dp | Spacing between items | 12.dp |
| IconSize | Dp | Icon size | 28.dp |
| IconPadding | Dp | Padding around the icon | 10.dp |
| SelectedPressedAlpha | Float | Alpha for selected pressed item | 0.5f |
| UnselectedPressedAlpha | Float | Alpha for unselected pressed item | 0.6f |
| UnselectedAlpha | Float | Alpha for unselected item | 0.4f |

### NavigationBarDisplayMode Enum [​](https://compose-miuix-ui.github.io/miuix/components/navigationbar#navigationbardisplaymode-enum)

| Value | Description |
| --- | --- |
| IconAndText | Show both icon and text |
| IconOnly | Show icon only |
| TextOnly | Show text only |
| IconWithSelectedLabel | Show icon always, show text only when selected |

## Advanced Usage [​](https://compose-miuix-ui.github.io/miuix/components/navigationbar#advanced-usage)

### NavigationBar [​](https://compose-miuix-ui.github.io/miuix/components/navigationbar#navigationbar-2)

#### Custom Colors [​](https://compose-miuix-ui.github.io/miuix/components/navigationbar#custom-colors)

kotlin

```
NavigationBar(
    color = Color.Red.copy(alpha = 0.3f)
) {
    // ... items ...
}
```

#### Without Divider [​](https://compose-miuix-ui.github.io/miuix/components/navigationbar#without-divider)

kotlin

```
NavigationBar(
    showDivider = false
) {
    // ... items ...
}
```

#### Handling Window Insets [​](https://compose-miuix-ui.github.io/miuix/components/navigationbar#handling-window-insets)

kotlin

```
NavigationBar(
    defaultWindowInsetsPadding = false // Handle window insets padding manually
) {
    // ... items ...
}
```

### FloatingNavigationBar [​](https://compose-miuix-ui.github.io/miuix/components/navigationbar#floatingnavigationbar-1)

#### Custom Color and Corner Radius [​](https://compose-miuix-ui.github.io/miuix/components/navigationbar#custom-color-and-corner-radius)

kotlin

```
FloatingNavigationBar(
    color = MiuixTheme.colorScheme.primaryContainer,
    cornerRadius = 28.dp
) {
    // ... items ...
}
```

#### Custom Alignment and Padding [​](https://compose-miuix-ui.github.io/miuix/components/navigationbar#custom-alignment-and-padding)

kotlin

```
FloatingNavigationBar(
    horizontalAlignment = Alignment.Start, // Align to start
    horizontalOutSidePadding = 16.dp // Set outside padding
) {
    // ... items ...
}
```

### Using with Page Navigation (Using Scaffold) [​](https://compose-miuix-ui.github.io/miuix/components/navigationbar#using-with-page-navigation-using-scaffold)

#### Using NavigationBar [​](https://compose-miuix-ui.github.io/miuix/components/navigationbar#using-navigationbar)

kotlin

```
val pages = listOf("Home", "Profile", "Settings")
val icons = listOf(MiuixIcons.VerticalSplit, MiuixIcons.Contacts, MiuixIcons.Settings)
var selectedIndex by remember { mutableStateOf(0) }

Scaffold(
    bottomBar = {
        NavigationBar {
            pages.forEachIndexed { index, label ->
                NavigationBarItem(
                    selected = selectedIndex == index,
                    onClick = { selectedIndex = index },
                    icon = icons[index],
                    label = label
                )
            }
        }
    }
) { paddingValues ->
    // Content area needs to consider padding
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Current Page: ${pages[selectedIndex]}",
            style = MiuixTheme.textStyles.title1
        )
    }
}
```

#### Using FloatingNavigationBar [​](https://compose-miuix-ui.github.io/miuix/components/navigationbar#using-floatingnavigationbar)

kotlin

```
val pages = listOf("Home", "Profile", "Settings")
val icons = listOf(MiuixIcons.VerticalSplit, MiuixIcons.Contacts, MiuixIcons.Settings)
var selectedIndex by remember { mutableStateOf(0) }

Scaffold(
    bottomBar = {
        FloatingNavigationBar {
            pages.forEachIndexed { index, label ->
                FloatingNavigationBarItem(
                    selected = selectedIndex == index,
                    onClick = { selectedIndex = index },
                    icon = icons[index],
                    label = label
                )
            }
        }
    }
) { paddingValues ->
    // Content area needs to consider padding
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Current Page: ${pages[selectedIndex]}",
            style = MiuixTheme.textStyles.title1
        )
    }
}
```

## Changelog[](https://compose-miuix-ui.github.io/miuix/components/navigationbar#changelog)

Last edited about 2 months ago

View full history

---
Source: [NavigationBar | Miuix](https://compose-miuix-ui.github.io/miuix/components/navigationbar)