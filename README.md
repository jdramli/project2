# project2

For project 2, this is an attempt to make widgets that draw lines and/or shapes on screen.  The initial focus is to create the drawing of an image
in response to some user input, such as an on screen click or a button/widget interaction. 

The first few days involve familiarization with how to set up a canvas onto a Linear or Constraint layout, and what properties are available
when this attachment is made.  Understanding more about canvas locks, and custom surface methods.  The first day was predominantly reading the 
tutorials, and setting up the project outline.

The next few days, the focus is on setting up the activity_main, the title screen, and adjusting the canvas size for what will be drawn on screen.
Buttons were added again, and the layout is partway complete.

After many failed attempts at getting proper interaction between onclick listeners and some images to display on screen, I have resorted to testing the app
over the next few days by using seekBar inputs from the tutorial to experiment with output of images.  The seekBar is handy, because it will respond
in 3 different events, including "start seek" "stop seek" and "progress changed", allowing for any generated functions to be tested and run on any of
those conditions.  This creates enough to test the user activity input vs. the expected output variations of the shapes/lines.

Using the seek bar for the next few days, more functions have been generated to manipulate and draw different circles and lines while changing the
background color of the custom surface on the app.  The functions "drawRed()", drawGreen, drawYellow, drawRandomLine, and drawEquation have been added.
These functions were created and tested in a separate project titled "seekBarJoe", and have their source code copied into text files in this repository.
The focus over these days is expanding and modifying these functions and assimilating their concepts and design into this repository.