# WindowIconDropdownMenu | Miuix

`WindowIconDropdownMenu` is an `IconButton` wrapper that opens a `WindowDropdownPopup` (rendered at window level via `Dialog`) when clicked. It is intended for toolbar action slots, such as the actions area of `TopAppBar`, where a single icon needs to expand into a list of actions, sort options, or filter toggles. Unlike `OverlayIconDropdownMenu`, it does not require a `Scaffold`.

## Import [​](https://compose-miuix-ui.github.io/miuix/components/windowicondropdownmenu#import)

kotlin

```
import top.yukonga.miuix.kmp.menu.WindowIconDropdownMenu
import top.yukonga.miuix.kmp.basic.DropdownEntry
import top.yukonga.miuix.kmp.basic.DropdownItem
```

## Basic Usage [​](https://compose-miuix-ui.github.io/miuix/components/windowicondropdownmenu#basic-usage)

Place `WindowIconDropdownMenu` in the `actions` slot of a `TopAppBar` (or `SmallTopAppBar`). Clicking the icon opens the popup. This is the typical use case — a toolbar action button that expands into a list of menu items. Unlike `OverlayIconDropdownMenu`, no `Scaffold` is required around the menu itself, but a `Scaffold` is still the natural way to host a `TopAppBar`.

kotlin

```
val entry = DropdownEntry(
    items = listOf("Edit", "Duplicate", "Share", "Delete").map { text ->
        DropdownItem(text = text, onClick = { /* handle action */ })
    }
)

Scaffold(
    topBar = {
        SmallTopAppBar(
            title = "Inbox",
            actions = {
                WindowIconDropdownMenu(entry = entry) {
                    Icon(imageVector = MiuixIcons.Edit, contentDescription = "Action menu")
                }
            }
        )
    }
) { padding ->
    // page content
}
```

## Sort / Single Select [​](https://compose-miuix-ui.github.io/miuix/components/windowicondropdownmenu#sort-single-select)

For sort menus or radio-style choices, set `selected` on each `DropdownItem` and let `collapseOnSelection = true` (default for the entry overload) close the popup after each pick.

kotlin

```
var sortIndex by remember { mutableStateOf(0) }
val entry = DropdownEntry(
    items = listOf("Name", "Date", "Size").mapIndexed { index, text ->
        DropdownItem(text = text, selected = sortIndex == index, onClick = { sortIndex = index })
    }
)

WindowIconDropdownMenu(entry = entry) {
    Icon(imageVector = MiuixIcons.Sort, contentDescription = "Sort")
}
```

## Multi Select [​](https://compose-miuix-ui.github.io/miuix/components/windowicondropdownmenu#multi-select)

Track a `Set` of selected values, toggle each item from `onClick`, and pass `collapseOnSelection = false` so the popup stays open between picks.

kotlin

```
var selected by remember { mutableStateOf(setOf("Photos")) }
val entry = DropdownEntry(
    items = listOf("Photos", "Videos", "Files").map { text ->
        DropdownItem(
            text = text,
            selected = text in selected,
            onClick = {
                selected = if (text in selected) selected - text else selected + text
            }
        )
    }
)

WindowIconDropdownMenu(entry = entry, collapseOnSelection = false) {
    Icon(imageVector = MiuixIcons.SelectAll, contentDescription = "Multiple selection")
}
```

## Grouped Menu [​](https://compose-miuix-ui.github.io/miuix/components/windowicondropdownmenu#grouped-menu)

Pass `entries: List<DropdownEntry>` to render multiple groups separated by dividers.

kotlin

```
val entries = listOf(
    DropdownEntry(items = listOf("Item A-1", "Item A-2").map { DropdownItem(text = it) }),
    DropdownEntry(items = listOf("Item B-1", "Item B-2", "Item B-3").map { DropdownItem(text = it) })
)

WindowIconDropdownMenu(entries = entries) {
    Icon(imageVector = MiuixIcons.MoreCircle, contentDescription = "More")
}
```

## Component States [​](https://compose-miuix-ui.github.io/miuix/components/windowicondropdownmenu#component-states)

### Disabled State [​](https://compose-miuix-ui.github.io/miuix/components/windowicondropdownmenu#disabled-state)

kotlin

```
WindowIconDropdownMenu(
    entry = DropdownEntry(items = listOf(DropdownItem(text = "Option 1"))),
    enabled = false
) {
    Icon(imageVector = MiuixIcons.MoreCircle, contentDescription = "More")
}
```

The menu is also implicitly disabled when no `DropdownEntry` contains any items.

## Properties [​](https://compose-miuix-ui.github.io/miuix/components/windowicondropdownmenu#properties)

### WindowIconDropdownMenu Properties (Entries Overload) [​](https://compose-miuix-ui.github.io/miuix/components/windowicondropdownmenu#windowicondropdownmenu-properties-entries-overload)

| Property Name | Type | Description | Default Value | Required |
| --- | --- | --- | --- | --- |
| entries | List<DropdownEntry> | Dropdown entry groups separated by dividers | \- | Yes |
| modifier | Modifier | Modifier applied to the wrapping `Box` | Modifier | No |
| enabled | Boolean | Whether the icon button is interactive | true | No |
| maxHeight | Dp? | Maximum height of the dropdown popup | null | No |
| dropdownColors | DropdownColors | Color configuration for dropdown items | DropdownDefaults.dropdownColors() | No |
| collapseOnSelection | Boolean | Whether to close the popup after each selection | entries.size <= 1 | No |
| onExpandedChange | ((Boolean) -> Unit)? | Callback when the expanded state changes | null | No |
| backgroundColor | Color | Background color of the underlying `IconButton` | Color.Unspecified | No |
| cornerRadius | Dp | Corner radius of the underlying `IconButton` | IconButtonDefaults.CornerRadius | No |
| minHeight | Dp | Minimum height of the underlying `IconButton` | IconButtonDefaults.MinHeight | No |
| minWidth | Dp | Minimum width of the underlying `IconButton` | IconButtonDefaults.MinWidth | No |
| content | @Composable () -> Unit | The icon (or other composable) shown inside the button | \- | Yes |

### Entry Overload Properties [​](https://compose-miuix-ui.github.io/miuix/components/windowicondropdownmenu#entry-overload-properties)

| Property Name | Type | Description | Default Value | Required |
| --- | --- | --- | --- | --- |
| entry | DropdownEntry | Single dropdown entry group | \- | Yes |
| collapseOnSelection | Boolean | Whether to close the popup after selection | true | No |

All other parameters are identical to the entries overload above.

### DropdownEntry Properties [​](https://compose-miuix-ui.github.io/miuix/components/windowicondropdownmenu#dropdownentry-properties)

| Property Name | Type | Description | Default Value | Required |
| --- | --- | --- | --- | --- |
| items | List<DropdownItem> | Items shown in this dropdown group | \- | Yes |
| enabled | Boolean | Whether this group is enabled. False disables all items; true still respects each item's enabled state | true | No |

### DropdownItem Properties [​](https://compose-miuix-ui.github.io/miuix/components/windowicondropdownmenu#dropdownitem-properties)

| Property Name | Type | Description | Default Value | Required |
| --- | --- | --- | --- | --- |
| text | String | Text shown for the item | \- | Yes |
| enabled | Boolean | Whether the item can be clicked. Disabled items are gray | true | No |
| selected | Boolean | Whether the item is selected | false | No |
| onClick | (() -> Unit)? | Callback invoked when the item is clicked | null | No |
| icon | @Composable ((Modifier) -> Unit)? | Icon shown before the item text | null | No |
| summary | String? | Summary text shown below the item text | null | No |
| children | List<DropdownItem>? | Optional submenu items; cascading variants only | null | No |

### DropdownColors Properties [​](https://compose-miuix-ui.github.io/miuix/components/windowicondropdownmenu#dropdowncolors-properties)

| Property Name | Type | Description |
| --- | --- | --- |
| contentColor | Color | Color of the option title |
| summaryColor | Color | Color of the option summary |
| containerColor | Color | Background color of the option |
| selectedContentColor | Color | Title color of the selected option |
| selectedSummaryColor | Color | Summary color of the selected option |
| selectedContainerColor | Color | Background color of the selected option |
| selectedIndicatorColor | Color | Color of the selected indicator icon |

## Changelog[](https://compose-miuix-ui.github.io/miuix/components/windowicondropdownmenu#changelog)

Last edited about 1 month ago

View full history

---
Source: [WindowIconDropdownMenu | Miuix](https://compose-miuix-ui.github.io/miuix/components/windowicondropdownmenu)