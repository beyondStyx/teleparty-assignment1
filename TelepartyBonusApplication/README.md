TMDB Movie Metadata Viewer

This is a simple Android app developed in Java as part of the Teleparty Android Developer Interview (Bonus Task). It uses the TMDB API to fetch and display movie details.

⸻

Task Summary

Goal:
Build an app that takes a video/movie ID, connects to a streaming service API, and displays basic metadata.

What It Does:
•	Takes a TMDB movie ID as input
•	Fetches metadata like title, overview, release date, etc.
•	Displays everything in a clean layout

⸻

Features
•	Enter a TMDB Movie ID (e.g., 550)
•	Fetch and display:
•	Movie title
•	Release date
•	Overview/description
•	Runtime (in minutes)
•	Genres
•	Vote average
•	Input validation
•	Loading indicator
•	Reset button to clear everything
•	Error handling with user-friendly messages

⸻

Tech Stack
•	Java
•	Android SDK
•	Retrofit2 (API calls)
•	Gson (JSON parsing)
•	TMDB API (v3)

⸻

Sample Movie IDs
•	550 → Fight Club
•	603 → The Matrix
•	299534 → Avengers: Endgame

⸻

How to Run
1.	Open the project in Android Studio
2.	Add your TMDB API key in MainActivity.java if not already present
3.	Build and run on emulator or device

⸻

Notes
•	Designed with simplicity in mind (no third-party UI libraries)
•   The code is fully commented to help understand the logic and flow
•	Logs are added throughout to verify:
•	API calls
•	Metadata content
•	Errors (if any)

⸻

Author

Submitted as part of the Teleparty Android Developer Interview Process
By: Lalit Kumar Meena