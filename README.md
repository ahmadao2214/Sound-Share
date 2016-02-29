# SOUND SHARE (Formally L2BeatBox)

Android app sharing user's beat-box recordings, creating opportunities to collaborate

###APIS:
Android Visualizer:
> https://github.com/felixpalmer/android-visualizer
Sound Frequency Visualizer.


Audio Analysis Library:
> https://code.google.com/p/musicg/
Acoustic Finger Printing.

###Improvements needed:
* Record beatbox sound and update list (Check)

* Facebook login (Check)

* Hosted Backend (Started)

* Send sound to friend

* Collaboration feature (NEED FUNCTIONAL DESIGN)

* Update visualizer live (Needs research)

* Unit tests

###Challenges:
* Configuring media player allow users to play multiple sounds.

* Updating SelectSoundFragment List after recording.

* Finding visualizer and acoustic fingerprinting library.

* Inflating list in SelectSoundFragment. 

* Modify RecordSoundFragment to append to SelectSoundFragment list.

* Implemented hosted backend

* Sending a sound through distributed system

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

* SocialMedia: 
