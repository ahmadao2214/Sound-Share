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
* AudioData:
Provides container for audio byte [].

* Beat:
Object representing list to hold description and sound file.

* LineRenderer:
Render audio data for visualizer.

* MainActivity:
Creates SectionsPagerAdapter

* RecordSoundFragment:
Play, stop and record while displaying visualizer.

* Renderer:
Canvas rendering for LineRenderer.

* SectionsPagerAdapter:
Scroll through multiple fragments

* SelectSoundFragment:
Sound selection scrollable list. Tap a sound to play audio and see the visualizer

* VisualizerView:
Element to visualize audio data.

```


###CHALLENGES:
```sh
* Configuring media player allow users to play multiple sounds.

* Updating SelectSoundFragment List after recording.

* Finding visualizer and acoustic fingerprinting library.

* Inflating list in SelectSoundFragment. 

* Modify RecordSoundFragment to append to SelectSoundFragment list.
```


###Improvements:
```sh
* Record your own beatbox sound and add to list (Check)

* Create a backend to host audio files (Check)

* Social Media integration for login and distribution

* Add collarboration feature (WORKING ON FUNCTIONAL DOC)
```
