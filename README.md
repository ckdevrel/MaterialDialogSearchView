[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-MaterialDialogSearchView-green.svg?style=flat)](https://android-arsenal.com/details/1/2589)

<a href='https://ko-fi.com/A302HW7' target='_blank'><img height='36' style='border:0px;height:36px;' src='https://az743702.vo.msecnd.net/cdn/kofi4.png?v=f' border='0' alt='Buy Me a Coffee at ko-fi.com' /></a> 

# MaterialDialogSearchView

MaterialDialogSearchView is a custom implementation of a Toolbar SearchView in a material design.
It is an alternate approach using Material dialogs as SearchView similar to the applications seen on nowadays with this type of SearchView's in the apps
like Google play, Google card's,etc.

#### **What made me to do this repo?**

This repo is truely made on the inspiration of Google play's SearchView and StackOverflow question of mine
http://stackoverflow.com/questions/30521615/implementing-google-play-and-maps-like-search-bar-android

<a href="http://imgur.com/kUwTS5P"><img src="http://i.imgur.com/kUwTS5P.gif" title="source: imgur.com" /></a>


#### **How to use?**

Regarding the usage, it is simple to go without using any third party libraries. The class files used in this repo is limited to

#### **MainActivity.java**  

This is the main class and it comprises of Custom dialog and then several logics to filter out the users suggestion in EditText.

#### **SearchAdapter.java** 

It is nothing but a adapter class extends BaseAdapter which in turn used to display the list items (i.e Country's Text and icon used in this repo) in a ListView.

#### **Utils.java**          

It is an Utility class which is used to adjust the height of ListView based on the count of child items.

#### **SharedPreference.java**   

SharedPrefernce class is used to store and retrieve recently searched values (i.e selected or clicked values from the suggestions list.)

> **Note:** 

        1. This is completely a custom implementation of mine.  Though this solution may be simple, but very effective implementing MaterialSearchView's and it will not affect any part of the coding cycle. You can use this view in activity, fragment or wherever you want. Happy coding! 
        2. Voice search will not work. It is just displayed for the UI purpose. EditText data will be cleared once if you click mic icon.

#### **Licensing**

About licensing it is free to go. You can do whatever you want with this code. I really appreciate all of your feedbacks and pull requests to improve this repo.
