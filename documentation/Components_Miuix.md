# Components | Miuix

## Components [​](https://compose-miuix-ui.github.io/miuix/components/#components)

Miuix provides a rich set of UI components that strictly follow Xiaomi HyperOS Design Guidelines. Each component is carefully designed to ensure visual and interactive consistency with the native Xiaomi experience.

## Scaffold Components [​](https://compose-miuix-ui.github.io/miuix/components/#scaffold-components)

| Component | Description | Common Usage |
| --- | --- | --- |
| [Scaffold](https://compose-miuix-ui.github.io/miuix/components/scaffold) | Basic layout for applications | Page structure, content display |

WARNING

The Scaffold component provides a suitable container for cross-platform popup windows. Components such as `OverlayDialog`, `OverlayDropdownPreference`, `OverlaySpinnerPreference`, and `OverlayListPopup` are all implemented based on this and therefore need to be wrapped by this component.

## Basic Components [​](https://compose-miuix-ui.github.io/miuix/components/#basic-components)

| Component | Description | Common Usage |
| --- | --- | --- |
| [Surface](https://compose-miuix-ui.github.io/miuix/components/surface) | Basic container component | Content display, background container |
| [TopAppBar](https://compose-miuix-ui.github.io/miuix/components/topappbar) | Application top navigation bar | Page title, primary actions |
| [NavigationBar](https://compose-miuix-ui.github.io/miuix/components/navigationbar) | Bottom navigation component | Main page switching |
| [NavigationRail](https://compose-miuix-ui.github.io/miuix/components/navigationrail) | Side navigation component | Main page switching (Large screen) |
| [TabRow](https://compose-miuix-ui.github.io/miuix/components/tabrow) | Horizontal tab bar | Content category browsing |
| [Card](https://compose-miuix-ui.github.io/miuix/components/card) | Container with related information | Information display, content grouping |
| [BasicComponent](https://compose-miuix-ui.github.io/miuix/components/basiccomponent) | Universal base component | Custom component development |
| [Button](https://compose-miuix-ui.github.io/miuix/components/button) | Interactive element for triggering actions | Form submission, action confirmation |
| [IconButton](https://compose-miuix-ui.github.io/miuix/components/iconbutton) | Icon button component | Auxiliary actions, toolbars |
| [Text](https://compose-miuix-ui.github.io/miuix/components/text) | Display text content with various styles | Titles, body text, descriptive text |
| [SmallTitle](https://compose-miuix-ui.github.io/miuix/components/smalltitle) | Small title component | Auxiliary titles, category labels |
| [TextField](https://compose-miuix-ui.github.io/miuix/components/textfield) | Receives user text input | Form filling, search boxes |
| [Switch](https://compose-miuix-ui.github.io/miuix/components/switch) | Binary state toggle control | Setting switches, feature enabling |
| [Checkbox](https://compose-miuix-ui.github.io/miuix/components/checkbox) | Multiple selection control | Multiple choices, terms agreement |
| [RadioButton](https://compose-miuix-ui.github.io/miuix/components/radiobutton) | Single selection control | Exclusive choices, option selection |
| [Slider](https://compose-miuix-ui.github.io/miuix/components/slider) | Sliding control for value adjustment | Volume control, range selection |
| [NumberPicker](https://compose-miuix-ui.github.io/miuix/components/numberpicker) | Vertical scroll picker for number selection | Time picker, quantity selection |
| [ProgressIndicator](https://compose-miuix-ui.github.io/miuix/components/progressindicator) | Displays operation progress status | Loading, progress display |
| [Snackbar](https://compose-miuix-ui.github.io/miuix/components/snackbar) | Temporary message bar for brief feedback | Operation result, status notification |
| [Icon](https://compose-miuix-ui.github.io/miuix/components/icon) | Icon display component | Icon buttons, status indicators |
| [FloatingActionButton](https://compose-miuix-ui.github.io/miuix/components/floatingactionbutton) | Floating action button | Primary actions, quick functions |
| [FloatingToolbar](https://compose-miuix-ui.github.io/miuix/components/floatingtoolbar) | Floating toolbar | Quick actions, information display |
| [Divider](https://compose-miuix-ui.github.io/miuix/components/divider) | Content separator | Block separation, hierarchy division |
| [PullToRefresh](https://compose-miuix-ui.github.io/miuix/components/pulltorefresh) | Pull-down refresh operation | Data update, page refresh |
| [SearchBar](https://compose-miuix-ui.github.io/miuix/components/searchbar) | Search input field | Content search, quick find |
| [ColorPalette](https://compose-miuix-ui.github.io/miuix/components/colorpalette) | Grid palette with alpha slider | Theme settings, color selection |
| [ColorPicker](https://compose-miuix-ui.github.io/miuix/components/colorpicker) | Color selection control | Theme settings, color selection |

## Extended Components [​](https://compose-miuix-ui.github.io/miuix/components/#extended-components)

| Component | Description | Common Usage |
| --- | --- | --- |
| [ArrowPreference](https://compose-miuix-ui.github.io/miuix/components/arrowpreference) | Arrow component based on BasicComponent | Clickable indication, navigation hints |
| [SwitchPreference](https://compose-miuix-ui.github.io/miuix/components/switchpreference) | Switch component based on BasicComponent | Setting switches, feature enabling |
| [CheckboxPreference](https://compose-miuix-ui.github.io/miuix/components/checkboxpreference) | Checkbox component based on BasicComponent | Multiple selection, terms agreement |
| [RadioButtonPreference](https://compose-miuix-ui.github.io/miuix/components/radiobuttonpreference) | Radio button component based on BasicComponent | Exclusive choices, option selection |
| [SliderPreference](https://compose-miuix-ui.github.io/miuix/components/sliderpreference) | Slider component based on BasicComponent | Value adjustment, volume/brightness |
| [RangeSliderPreference](https://compose-miuix-ui.github.io/miuix/components/rangesliderpreference) | Range slider component based on BasicComponent | Range selection, price filter |
| [OverlayListPopup](https://compose-miuix-ui.github.io/miuix/components/overlaylistpopup) | List popup component based on BasicComponent (uses MiuixPopupUtils; requires `Scaffold`) | Option selection, feature list |
| [OverlayCascadingListPopup](https://compose-miuix-ui.github.io/miuix/components/overlaycascadinglistpopup) | Two-level cascading list popup (uses MiuixPopupUtils; requires `Scaffold`) | Submenus, grouped action panels |
| [OverlayDropdownPreference](https://compose-miuix-ui.github.io/miuix/components/overlaydropdownpreference) | Dropdown selector based on BasicComponent (uses MiuixPopupUtils; requires `Scaffold`) | Option selection, feature list |
| [OverlaySpinnerPreference](https://compose-miuix-ui.github.io/miuix/components/overlayspinnerpreference) | Advanced selector based on BasicComponent (uses MiuixPopupUtils; requires `Scaffold`) | Advanced options, feature list |
| [OverlayDropdownMenu](https://compose-miuix-ui.github.io/miuix/components/overlaydropdownmenu) | Action menu based on BasicComponent (uses MiuixPopupUtils; requires `Scaffold`) | Action menus, multi-select choices |
| [OverlayIconDropdownMenu](https://compose-miuix-ui.github.io/miuix/components/overlayicondropdownmenu) | Icon-button action menu (uses MiuixPopupUtils; requires `Scaffold`) | Toolbar actions, overflow menu |
| [OverlayIconCascadingDropdownMenu](https://compose-miuix-ui.github.io/miuix/components/overlayiconcascadingdropdownmenu) | Icon-button cascading two-level menu (uses MiuixPopupUtils; requires `Scaffold`) | Toolbar actions with submenus |
| [OverlayBottomSheet](https://compose-miuix-ui.github.io/miuix/components/overlaybottomsheet) | Bottom sheet based on BasicComponent (uses MiuixPopupUtils; requires `Scaffold`) | Bottom drawer, additional options |
| [OverlayDialog](https://compose-miuix-ui.github.io/miuix/components/overlaydialog) | Dialog window based on BasicComponent (uses MiuixPopupUtils; requires `Scaffold`) | Prompts, action confirmation |
| [WindowListPopup](https://compose-miuix-ui.github.io/miuix/components/windowlistpopup) | Window-level list popup component | Option selection, feature list |
| [WindowCascadingListPopup](https://compose-miuix-ui.github.io/miuix/components/windowcascadinglistpopup) | Window-level two-level cascading list popup | Submenus, grouped action panels |
| [WindowDropdownPreference](https://compose-miuix-ui.github.io/miuix/components/windowdropdownpreference) | Window-level dropdown selector component | Option selection, feature list |
| [WindowSpinnerPreference](https://compose-miuix-ui.github.io/miuix/components/windowspinnerpreference) | Window-level advanced selector component | Advanced options, feature list |
| [WindowDropdownMenu](https://compose-miuix-ui.github.io/miuix/components/windowdropdownmenu) | Window-level action menu component | Action menus, multi-select choices |
| [WindowIconDropdownMenu](https://compose-miuix-ui.github.io/miuix/components/windowicondropdownmenu) | Window-level icon-button action menu component | Toolbar actions, overflow menu |
| [WindowIconCascadingDropdownMenu](https://compose-miuix-ui.github.io/miuix/components/windowiconcascadingdropdownmenu) | Window-level icon-button cascading two-level menu | Toolbar actions with submenus |
| [WindowBottomSheet](https://compose-miuix-ui.github.io/miuix/components/windowbottomsheet) | Window-level bottom sheet component | Bottom drawer, additional options |
| [WindowDialog](https://compose-miuix-ui.github.io/miuix/components/windowdialog) | Window-level dialog component | Prompts, action confirmation |

## Changelog[](https://compose-miuix-ui.github.io/miuix/components/#changelog)

Last edited 23 days ago

View full history

---
Source: [Components | Miuix](https://compose-miuix-ui.github.io/miuix/components/)