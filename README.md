# Pictionary-Nodejs
A game of Pictionary implemented with Nodejs.<br>

How to run:
<b>npm install</b><br>
Followed by:
<b>node app</b>

Server is open at port <b>2000</b>.<br>
Navigate to <b>localhost:2000</b> in the browser(tested on chrome) and enjoy.

Word list comes from: https://www.thegamegal.com/wp-content/uploads/2011/11/Pictionary-Words-Medium.pdf<br>
You can expand the list on your own :)

<b>Known issues:</b>
1. The word file (Words.txt) has a carriage return and a new line character at the end of each line. If run on Linux system, where only a new line character is present, change line 103 from '\r\n' to '\n' in app.js file.
