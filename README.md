# LinkedList_Playlist

Hey everyone!

This is another small project of mine. As I've continued learning about different types of lists in Java, I started wondering how to make a playlist where you can add some of your favourite songs and navigate through them.
<br>


The main problem was the way linked lists in Java are designed. The pointer, which refers to the next or previous item, is situated between two elements. This means, while using the common next() or previous() methods,
the pointer will give you the value it has just jumped over. It makes the implementation of the simple function of a playlist where you can go back to the previous song or move forward to the next one a lot more complex.
But I've found a solution which you can check in my code.
<br>

UPD: I have added an inner class SongList to the Album class in order to increase the level of encapsulation. From now on the Main method does not have a direct access to the songs being added to the album.


Feel free to explore my tiny application where you can add some songs to the playlist, replay/remove the current song or just skip backwards/forward. 

Have fun!
