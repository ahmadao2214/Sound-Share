# L2BEATBOX
Android app providing beatbox samples to teach basic techniques.

L2BEATBOX
L2Beatbox is an android application providing various beat-boxing sounds for the user to listen to and then have their own chance to make their own attempt of a beat-boxing sound. 

Users can see the sound frequency from either selecting a sound from a scrollable list or of their own recording.
User can select different functionality (screens)  of the app simply by scrolling right.

Unfinished: Sound comparison. Third screen provides an attempt at comparing 2 sounds providing a score and their similarity. The library does not provide enough documentation and results from testing were not consistent. 

     
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

•	CompareSoundFragment:
Incomplete sound comparison fragment providing score and similarity values between selected and user recorded sound. Testing did not provide consistent results to complete.

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
•	Finding a visualizer library that worked well and was easy to use. Many of them had bad documentation and examples.
•	Finding a acoustic fingerprinting library (still a work in progress)
•	Implementing the list view alongside the visualizer on the select sound screen. 
•	Incompatibility between fragments/activities

LIMITATIONS:
•	Unable to compare sounds
•	Improvement: Record your own beatbox sound and add to list
•	Improvement: Create a backend to host audio files
•	Improvement: Create social aspect to send audio files to others for collaboration (Collaboration method????)
•	Improvement: Add video functionality for Beatchat (Beat-boxing snap chat?!)

OVERALL EXPERIENCE:
Fun but difficult. Being able to develop in android requires patience and time. I am happy to have had an opportunity to create an application that was unique and relevant to me particular interest but I have a lot to learn still. It was great taking the class and understanding little things that added to my overall comprehension behind Android, Android development and Android Architecture. I hope to eventually release and Android Application to the Google Play Store in order to establish myself as a true android developer and hopefully find employment opportunities through that experience. Android has always been difficult but in the face of adversity, it reminds you to have perseverance to make accomplishments of various sizes.
