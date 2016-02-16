# SOUND SHARE (Formally L2BEATBOX)

Android app sharing user's beat-box recordings, creating opportunities to collaborate

###APIS:
Android Visualizer by FelixPalmer:
> https://github.com/felixpalmer/android-visualizer
Visualization effect drawing sound frequency.


Audio Analysis Library:
> https://code.google.com/p/musicg/
Acoustic finger printing library for implementation and analysis.


###Classes:
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

* LoginFragment:
Facebook login functionality

* OnlineDatabase:
Firebase API to host database



###Challenges:
* Configuring media player allow users to play multiple sounds.

* Updating SelectSoundFragment List after recording.

* Finding visualizer and acoustic fingerprinting library.

* Inflating list in SelectSoundFragment. 

* Modify RecordSoundFragment to append to SelectSoundFragment list.


###Improvements:
* Record beatbox sound and add to list (Check)

* Social Media integration to login (Check)

* Hosted Backend (Started)

* Distributed System

* Add collab feature (NEED FUNCTIONAL DESIGN)
