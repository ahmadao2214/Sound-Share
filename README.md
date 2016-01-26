# L2BEATBOX

(Android) Sampling beat-box techniques and displaying sound frequency from selecting sample or from "Play" button.

###APIS:
Android Visualizer by FelixPalmer:
> https://github.com/felixpalmer/android-visualizer
Visualization effect drawing sound frequency.


Audio Analysis Library:
> https://code.google.com/p/musicg/
Acoustic finger printing library for implementation and analysis.


###CLASSES:
```sh
•	AudioData:
Provides container for audio byte [].

•	Beat:
Object representing list to hold description and sound file.

•	FFTData:
Provides container for FFT byte [].

•	LineRenderer:
Render audio data for visualizer.

•	MainActivity:
Creates SectionsPagerAdapter

•	RecordSoundFragment:
Play, stop and record while displaying visualizer.

•	Renderer:
Canvas rendering for LineRenderer.

•	SectionsPagerAdapter:
Scroll through multiple fragments

•	SelectSoundFragment:
Sound selection scrollable list. Tap a sound to play audio and see the visualizer

•	VisualizerView:
Element to visualize FFT data.

```


###CHALLENGES:
```sh
•	Configuring the media player after starting and playing to allow users to play multiple sounds.

•	Finding a visualizer library.

•	Finding a acoustic fingerprinting library (still a work in progress).

•	Inflating list view with visualizer in SelectSoundFragment. 

•	Incompatibility between fragments/activities.

•	Changing RecordSoundFragment to add to SelectSoundFragment list.
```


###Improvements:
```sh
•	Record your own beatbox sound and add to list

•	Create a backend to host audio files

•	Social Media integration for login and distribution

•	Add collarboration feature
```
