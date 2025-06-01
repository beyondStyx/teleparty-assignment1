DRM Video Player with Resolution Selection

This is a simple Android app built using Java as part of the Teleparty Android Developer Interview (Main Task). The app plays a DRM-protected video stream using ExoPlayer (Media3) and allows users to manually select the video resolution from a bottom sheet.

⸻

Task Summary

Objective:
Create a video player that supports DRM-protected streaming and allows users to choose a resolution manually.

Requirements:
•	Use ExoPlayer to play a DRM-protected .mpd video
•	Add a Resolution button outside the player
•	Show a list of available video resolutions
•	Update the video quality based on user selection
•	Also include an Auto mode for adaptive playback

⸻

Features
•	DRM-protected video playback using Widevine
•	Built with Media3 (ExoPlayer)
•	Bottom sheet to select video resolution (e.g., 240p, 360p, 720p, etc.)
•	Auto (Adaptive) quality option
•	Current resolution is shown in the UI
•	Simple and user-friendly interface

⸻

Video Stream Used
•	Manifest URL:
https://bitmovin-a.akamaihd.net/content/art-of-motion_drm/mpds/11331.mpd
•	License URL:
https://cwip-shaka-proxy.appspot.com/no_auth

These are public DRM test links provided by Bitmovin.

⸻

Tech Stack
•	Java
•	Android SDK
•	ExoPlayer (Media3)
•	BottomSheetDialog
•	RecyclerView

⸻

How to Run
1.	Open the project in Android Studio
2.	Build and run the app on an emulator or physical device (API 21+)
3.	The video will start playing automatically
4.	Click the Resolution button to pick a specific resolution or choose “Auto”

⸻

Notes
•	The resolution button is placed outside the PlayerView, as required
•	Logs are added throughout the app to verify:
•	Playback state changes (READY, BUFFERING, etc.)
•	Errors (if any)
•	Available resolutions
•	Currently applied video format (resolution and bitrate)
•	The selected resolution is applied using track selector overrides
•	UI is kept simple and clean without using third-party UI libraries
•   The code is fully commented to help understand the logic and flow

⸻

Author

Submitted as part of the Teleparty Android Developer Interview Process
By: Lalit Kumar Meena