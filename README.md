# L2BEATBOX
Android app providing beatbox samples to teach basic techniques.


L2Beatbox: an android application providing various beat-boxing sounds for the user to listen  and have their own chance to make an attempt of practicing the beat-boxing technique. 

Sound frequency is displayed from selecting a sample from a scrollable list or from their own recording.

APIS:
Android Visualizer by FelixPalmer
https://github.com/felixpalmer/android-visualizer
Provides visualization effect that draws an  on a canvas the sound frequency audio visualization on a graph.

Audio Analysis Library
https://code.google.com/p/musicg/
musicg-1.4.2.0
Provides acoustic finger printing library for implementation and analysis.

CLASSES
•	AudioData:
Provides container for audio byte [].

•	Beat:
Object representing list to hold Icon, description and sound file.

•	FFTData:
Provides container for FFT byte [].

•	LineRenderer:
Render audio data onto a line within a canvas for visualizer.

•	MainActivity:
Create page selection adapter to scroll through multiple fragments within application.

•	RecordSoundFragment:
Provides buttons to record stop and are able to play sound displaying within visualizer.

•	Renderer:
Provides basic canvas rendering for LineRenderer child custom class.

•	SectionsPagerAdapter:
Provides different fragments for pages to select from through the Main Activity.

•	SelectSoundFragment:
Provides sounds to select from within a list adapter and playing the sound while displaying in the visualizer.

•	VisualizerView:
Element to be displayed within XML to visualize FFT data.

CHALLENGES:
•	Figuring out to stop the media player after starting and playing it. This enables the user to hit multiple sounds without having the app crash by stop and resetting the media player every time a sound is touched.
•	Finding a visualizer library. Many of them had bad documentation and examples.
•	Finding a acoustic fingerprinting library (still a work in progress).
•	Implementing the list view with visualizer on SelectSoundFragment. 
•	Incompatibility between fragments/activities

LIMITATIONS:
•	Unable to compare sounds
•	Improvement: Record your own beatbox sound and add to list
•	Improvement: Create a backend to host audio files
•	Improvement: Create social aspect to send audio files to others for collaboration 
•	Improvement: Add video functionality for Beatchat
