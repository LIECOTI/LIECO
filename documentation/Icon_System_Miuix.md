# Icon System

Miuix provides a rich built-in icon system that meets the primary design needs of most applications. These icons are available in five weights: Light, Normal, Regular, Medium, and Demibold.

## Installation

The basic `miuix-ui` library includes only a small set of essential icons. To access the full collection of Miuix icons, you need to add the `miuix-icons` dependency to your project.

```kotlin
// build.gradle.kts
commonMain.dependencies {
    implementation("top.yukonga.miuix.kmp:miuix-ui:<version>")
    // Add the extended icon library
    implementation("top.yukonga.miuix.kmp:miuix-icons:<version>")
}
```

## Usage

To use Miuix icons in your project, first import them correctly:

```kotlin
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import top.yukonga.miuix.kmp.basic.Icon
import top.yukonga.miuix.kmp.icon.MiuixIcons
import top.yukonga.miuix.kmp.icon.extended.Ok
import top.yukonga.miuix.kmp.icon.extended.Settings
```

Then, you can use the icons as follows:

```kotlin
// Use the Ok icon (defaults to Regular weight)
Icon(
    imageVector = MiuixIcons.Ok,
    contentDescription = "Ok",
    modifier = Modifier.size(24.dp)
)

// Use the Settings icon
Icon(
    imageVector = MiuixIcons.Settings,
    contentDescription = "Settings",
    modifier = Modifier.size(24.dp)
)

// Use a specific weight (e.g., Light)
Icon(
    imageVector = MiuixIcons.Light.Settings,
    contentDescription = "Settings (Light)",
    modifier = Modifier.size(24.dp)
)
```

## Icon Weights

Miuix icons support five weights, matching the named instances of the source font `misymbol_vf.ttf`:

* **MiuixIcons.Light**: Light weight icons (`wght=250`)
* **MiuixIcons.Normal**: Lighter-than-regular icons (`wght=305`)
* **MiuixIcons.Regular**: Regular weight icons (`wght=330`) - Default when accessing `MiuixIcons.IconName` directly
* **MiuixIcons.Medium**: Heavier-than-regular icons (`wght=430`)
* **MiuixIcons.Demibold**: Demibold weight icons (`wght=500`)

## Available Icons

### Basic Icons

Basic icons include commonly used basic UI elements such as arrows and checkmarks. These icons are also used in Miuix's own components. Below is the complete list:

| Icon Name | Light | Normal | Regular | Medium | Demibold |
| :--- | :---: | :---: | :---: | :---: | :---: |
| ArrowRight | - | - | | - | - |
| ArrowUpDown | - | - | | - | - |
| Check | - | - | | - | - |
| Search | - | - | | - | - |
| SearchCleanup | - | - | | - | - |

### Extended Icons

Extended icons include a wide variety of icons for different use cases. Below is the complete list:

| Icon Name | Light | Normal | Regular | Medium | Demibold |
| :--- | :---: | :---: | :---: | :---: | :---: |
| Add | | | | | |
| AddCircle | | | | | |
| AddFolder | | | | | |
| Alarm | | | | | |
| Album | | | | | |
| All | | | | | |
| Answer | | | | | |
| AppRecording | | | | | |
| Back | | | | | |
| Background | | | | | |
| Backup | | | | | |
| BankCards | | | | | |
| Blocklist | | | | | |
| CallRecording | | | | | |
| Carrier | | | | | |
| ChevronBackward | | | | | |
| ChevronForward | | | | | |
| Clear | | | | | |
| Close | | | | | |
| Close2 | | | | | |
| CloudFill | | | | | |
| Community | | | | | |
| Contacts | | | | | |
| ContactsBook | | | | | |
| ContactsCircle | | | | | |
| ConvertFile | | | | | |
| Copy | | | | | |
| Create | | | | | |
| Cut | | | | | |
| Delete | | | | | |
| Download | | | | | |
| Edit | | | | | |
| Email | | | | | |
| ExpandLess | | | | | |
| ExpandMore | | | | | |
| Favorites | | | | | |
| FavoritesFill | | | | | |
| File | | | | | |
| FileDownloads | | | | | |
| Filter | | | | | |
| Folder | | | | | |
| FolderFill | | | | | |
| Forward | | | | | |
| GridView | | | | | |
| Help | | | | | |
| Hide | | | | | |
| HorizontalSplit | | | | | |
| Image | | | | | |
| Import | | | | | |
| Info | | | | | |
| Layers | | | | | |
| Link | | | | | |
| ListView | | | | | |
| Location | | | | | |
| Lock | | | | | |
| MapAlbum | | | | | |
| Merge | | | | | |
| Messages | | | | | |
| Mic | | | | | |
| MicSlash | | | | | |
| MindMap | | | | | |
| Months | | | | | |
| More | | | | | |
| MoreCircle | | | | | |
| MoveFile | | | | | |
| Music | | | | | |
| Notes | | | | | |
| NotesFill | | | | | |
| Ok | | | | | |
| Paste | | | | | |
| Pause | | | | | |
| Phone | | | | | |
| Photos | | | | | |
| Pin | | | | | |
| Play | | | | | |
| Playlist | | | | | |
| Promotions | | | | | |
| Recent | | | | | |
| Recording | | | | | |
| RecordingTape | | | | | |
| Redo | | | | | |
| Refresh | | | | | |
| Remove | | | | | |
| RemoveContact | | | | | |
| Rename | | | | | |
| Replace | | | | | |
| Reply | | | | | |
| ReplyAll | | | | | |
| Report | | | | | |
| Reset | | | | | |
| RotateLeft | | | | | |
| Scan | | | | | |
| ScreenCapture | | | | | |
| ScreenMirroring | | | | | |
| Search | | | | | |
| SearchDevice | | | | | |
| SelectAll | | | | | |
| Send | | | | | |
| Settings | | | | | |
| Share | | | | | |
| Show | | | | | |
| Sidebar | | | | | |
| Sort | | | | | |
| Stopwatch | | | | | |
| Store | | | | | |
| Tasks | | | | | |
| Th1 | | | | | |
| Th10 | | | | | |
| Th11 | | | | | |
| Th12 | | | | | |
| Th13 | | | | | |
| Th14 | | | | | |
| Th15 | | | | | |
| Th16 | | | | | |
| Th17 | | | | | |
| Th18 | | | | | |
| Th19 | | | | | |
| Th2 | | | | | |
| Th20 | | | | | |
| Th21 | | | | | |
| Th22 | | | | | |
| Th23 | | | | | |
| Th24 | | | | | |
| Th25 | | | | | |
| Th26 | | | | | |
| Th27 | | | | | |
| Th28 | | | | | |
| Th29 | | | | | |
| Th3 | | | | | |
| Th30 | | | | | |
| Th31 | | | | | |
| Th4 | | | | | |
| Th5 | | | | | |
| Th6 | | | | | |
| Th7 | | | | | |
| Th8 | | | | | |
| Th9 | | | | | |
| Theme | | | | | |
| Timer | | | | | |
| TopDownloads | | | | | |
| Translate | | | | | |
| Trim | | | | | |
| Tune | | | | | |
| Undo | | | | | |
| Unlock | | | | | |
| Unpin | | | | | |
| Update | | | | | |
| UploadCloud | | | | | |
| VerticalSplit | | | | | |
| VolumeOff | | | | | |
| VolumeUp | | | | | |
| Weeks | | | | | |
| WorldClock | | | | | |
| Years | | | | | |
| ZoomOut | | | | | |
