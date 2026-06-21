# OverlayDropdownMenu | Miuix

`OverlayDropdownMenu` is a `BasicComponent` wrapper that opens an `OverlayDropdownPopup` when clicked. Unlike `OverlayDropdownPreference`, it does not own a single selection index — selection state lives entirely on each `DropdownItem`'s `selected` and `onClick`. Use it for action menus, multi-select menus, or any case where the items in a popup do not share one mutually exclusive choice.

Prerequisite

This component depends on `Scaffold` providing `MiuixPopupHost` to render popup content. It must be used within `Scaffold`, otherwise popup content will not render correctly.

## Import [​](https://compose-miuix-ui.github.io/miuix/components/overlaydropdownmenu#import)

kotlin

```
import top.yukonga.miuix.kmp.menu.OverlayDropdownMenu
import top.yukonga.miuix.kmp.basic.DropdownEntry
import top.yukonga.miuix.kmp.basic.DropdownItem
```

## Basic Usage [​](https://compose-miuix-ui.github.io/miuix/components/overlaydropdownmenu#basic-usage)

Wrap a single `DropdownEntry` to render a basic dropdown menu row:

kotlin

```
var selectedIndex by remember { mutableStateOf(0) }
val entry = DropdownEntry(
    items = listOf("Option 1", "Option 2", "Option 3").mapIndexed { index, text ->
        DropdownItem(
            text = text,
            selected = selectedIndex == index,
            onClick = { selectedIndex = index },
        )
    }
)

Scaffold {
    OverlayDropdownMenu(
        title = "Dropdown Menu",
        entry = entry
    )
}
```

## Grouped Menu [​](https://compose-miuix-ui.github.io/miuix/components/overlaydropdownmenu#grouped-menu)

Pass a `List<DropdownEntry>` to render multiple groups separated by dividers. By default, `collapseOnSelection` is `entries.size <= 1`, so multi-group menus stay open after each selection.

kotlin

```
var sizeIndex by remember { mutableStateOf(0) }
var colorIndex by remember { mutableStateOf(0) }
val entries = listOf(
    DropdownEntry(
        items = listOf("Small", "Medium").mapIndexed { index, text ->
            DropdownItem(text = text, selected = sizeIndex == index, onClick = { sizeIndex = index })
        }
    ),
    DropdownEntry(
        items = listOf("Red", "Green", "Blue").mapIndexed { index, text ->
            DropdownItem(text = text, selected = colorIndex == index, onClick = { colorIndex = index })
        }
    )
)

Scaffold {
    OverlayDropdownMenu(
        title = "Grouped Menu",
        entries = entries,
        collapseOnSelection = false
    )
}
```

## Multi Select [​](https://compose-miuix-ui.github.io/miuix/components/overlaydropdownmenu#multi-select)

Selection state lives on `DropdownItem.selected`, so multiple items can be selected simultaneously by toggling each item's value from `onClick`.

kotlin

```
var selected by remember { mutableStateOf(setOf("A1", "B2")) }
val entries = listOf(
    DropdownEntry(
        items = listOf("A1", "A2").map { text ->
            DropdownItem(
                text = text,
                selected = text in selected,
                onClick = {
                    selected = if (text in selected) selected - text else selected + text
                }
            )
        }
    ),
    DropdownEntry(
        items = listOf("B1", "B2", "B3").map { text ->
            DropdownItem(
                text = text,
                selected = text in selected,
                onClick = {
                    selected = if (text in selected) selected - text else selected + text
                }
            )
        }
    )
)

Scaffold {
    OverlayDropdownMenu(
        title = "Multi Select Menu",
        entries = entries,
        collapseOnSelection = false
    )
}
```

## Observe Expanded State [​](https://compose-miuix-ui.github.io/miuix/components/overlaydropdownmenu#observe-expanded-state)

kotlin

```
var expanded by remember { mutableStateOf(false) }
val entry = DropdownEntry(
    items = listOf("Option 1", "Option 2", "Option 3").map { DropdownItem(text = it) }
)

Scaffold {
    OverlayDropdownMenu(
        title = "Observe Expanded",
        summary = if (expanded) "Expanded" else "Collapsed",
        entry = entry,
        onExpandedChange = { expanded = it }
    )
}
```

## Component States [​](https://compose-miuix-ui.github.io/miuix/components/overlaydropdownmenu#component-states)

### Disabled State [​](https://compose-miuix-ui.github.io/miuix/components/overlaydropdownmenu#disabled-state)

kotlin

```
OverlayDropdownMenu(
    title = "Disabled Menu",
    summary = "This menu is currently unavailable",
    entry = DropdownEntry(items = listOf(DropdownItem(text = "Option 1"))),
    enabled = false
)
```

The menu is also implicitly disabled when no `DropdownEntry` contains any items.

## Properties [​](https://compose-miuix-ui.github.io/miuix/components/overlaydropdownmenu#properties)

### OverlayDropdownMenu Properties (Entries Overload) [​](https://compose-miuix-ui.github.io/miuix/components/overlaydropdownmenu#overlaydropdownmenu-properties-entries-overload)

| Property Name | Type | Description | Default Value | Required |
| --- | --- | --- | --- | --- |
| entries | List<DropdownEntry> | Dropdown entry groups separated by dividers | \- | Yes |
| title | String | Title of the menu row | \- | Yes |
| modifier | Modifier | Modifier applied to the component | Modifier | No |
| titleColor | BasicComponentColors | Title text color configuration | BasicComponentDefaults.titleColor() | No |
| summary | String? | Summary description of the menu | null | No |
| summaryColor | BasicComponentColors | Summary text color configuration | BasicComponentDefaults.summaryColor() | No |
| dropdownColors | DropdownColors | Color configuration for dropdown items | DropdownDefaults.dropdownColors() | No |
| startAction | @Composable (() -> Unit)? | Custom start side content | null | No |
| bottomAction | @Composable (() -> Unit)? | Custom bottom side content | null | No |
| insideMargin | PaddingValues | Internal content padding | BasicComponentDefaults.InsideMargin | No |
| maxHeight | Dp? | Maximum height of the dropdown popup | null | No |
| enabled | Boolean | Whether component is interactive | true | No |
| renderInRootScaffold | Boolean | Whether to render the popup in the root (outermost) Scaffold. When true, the popup covers the full screen. When false, it renders within the current Scaffold's bounds with position compensation | true | No |
| collapseOnSelection | Boolean | Whether to close the popup after each selection | entries.size <= 1 | No |
| onExpandedChange | ((Boolean) -> Unit)? | Callback when the expanded state changes | null | No |

### Entry Overload Properties [​](https://compose-miuix-ui.github.io/miuix/components/overlaydropdownmenu#entry-overload-properties)

| Property Name | Type | Description | Default Value | Required |
| --- | --- | --- | --- | --- |
| entry | DropdownEntry | Single dropdown entry group | \- | Yes |
| collapseOnSelection | Boolean | Whether to close the popup after selection | true | No |

All other parameters are identical to the entries overload above.

### DropdownEntry Properties [​](https://compose-miuix-ui.github.io/miuix/components/overlaydropdownmenu#dropdownentry-properties)

| Property Name | Type | Description | Default Value | Required |
| --- | --- | --- | --- | --- |
| items | List<DropdownItem> | Items shown in this dropdown group | \- | Yes |
| enabled | Boolean | Whether this group is enabled. False disables all items; true still respects each item's enabled state | true | No |

### DropdownItem Properties [​](https://compose-miuix-ui.github.io/miuix/components/overlaydropdownmenu#dropdownitem-properties)

| Property Name | Type | Description | Default Value | Required |
| --- | --- | --- | --- | --- |
| text | String | Text shown for the item | \- | Yes |
| enabled | Boolean | Whether the item can be clicked. Disabled items are gray | true | No |
| selected | Boolean | Whether the item is selected | false | No |
| onClick | (() -> Unit)? | Callback invoked when the item is clicked | null | No |
| icon | @Composable ((Modifier) -> Unit)? | Icon shown before the item text | null | No |
| summary | String? | Summary text shown below the item text | null | No |
| children | List<DropdownItem>? | Optional submenu items; cascading variants only | null | No |

### DropdownColors Properties [​](https://compose-miuix-ui.github.io/miuix/components/overlaydropdownmenu#dropdowncolors-properties)

| Property Name | Type | Description |
| --- | --- | --- |
| contentColor | Color | Color of the option title |
| summaryColor | Color | Color of the option summary |
| containerColor | Color | Background color of the option |
| selectedContentColor | Color | Title color of the selected option |
| selectedSummaryColor | Color | Summary color of the selected option |
| selectedContainerColor | Color | Background color of the selected option |
| selectedIndicatorColor | Color | Color of the selected indicator icon |

## Changelog[](https://compose-miuix-ui.github.io/miuix/components/overlaydropdownmenu#changelog)

Last edited about 1 month ago

View full history

---
Source: [OverlayDropdownMenu | Miuix](https://compose-miuix-ui.github.io/miuix/components/overlaydropdownmenu)