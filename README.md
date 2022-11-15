# String-Pattern-Replacer
Replaces string(based on pattern) from multiple files within a directory structure.
It can be configured to replace only in certain file types. 
With default settings it will prompt before making any change but you can change this setting.

# STATUS - DEVELOPMENT COMPLETE

# Why I created this repository?
-   Problem: I was facing a issue where I had to replace words within a big project with another word. But same word will replace
    the old word everytime. This was very repeatitive task. It would have taken me 2 days to perform this task for whole project.
-   I couldn't find IDE which was configurable to do this.
-   Thus I created this repositoory.

**Usage:**
1.  Clone the project in your local repository.
    Eg. `git clone https://github.com/PankajMSharma/String-Pattern-Replacer.git`
2.  Import the project to Eclipse IDE.
3.  Run the project as application.
4.  Enter the path of directory in console when prompted. Tool will look for every file in the given drirectory tree.

Please edit the static variables as per your requirement. For eg,
1.  **fileType**
    Add the file extensions to this variable which needs to be changed. For eg, ".txt" or ".ts"
2.  **promptBeforeChange** 
    If you need prompting before the tool changes any line, set this variable to true.
3.  **textToReplace**
    Add all the string patterns that needs to be replaced from all files.
4.  **replacedText**
    Add the text which you need to be replaced with. If you just want to remove the string you can set this to empty string.
