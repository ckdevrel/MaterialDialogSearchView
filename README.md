# MaterialDialogSearchView

MaterialDialogSearchView is a custom implementation and replacement for a Toolbar SearchView in a material design.
It is an alternate approach using Material dialogs as SearchView similar to the applications seen on nowadays with this type of SearchView's in the apps
like Google play, Google card's,etc.

#### **What made me to do this repo?**

This repo is truely made on the inspiration of Google play's SearchView and StackOverflow question of mine
http://stackoverflow.com/questions/30521615/implementing-google-play-and-maps-like-search-bar-android

<a href="http://imgur.com/kUwTS5P"><img src="http://i.imgur.com/kUwTS5P.gif" title="source: imgur.com" /></a>


#### **How to use?**

Regarding the usage, it is simple to go without using any third party libraries. The class files used in this repo is limited to

#### **MainActivity.java**  

This is the main class and it comprises of Custom dilaog and then several logics to filter out the users suggestion in EditText.

#### **SearchAdapter.java** 

It is nothing but a adapter class extends BaseAdapter which in turn used to display the list items (i.e Country's Text and icon used in this repo) in a ListView.

#### **Uils.java**          

It is an Utility class which is used to adjust the height of ListView based on the count of child items.

#### **SharedPreference.java**   

SharedPrefernce class is used to store and retrieve recently searched values (i.e selected or clicked values from the suggestions list.)

> **Note:** This is completely a custom implementation of mine.  Though this solution may be simple, but very effective implementing MaterialSearchView's. You can do whatever with this code without any licenses. Happy coding! 


