# String-Pattern-Replacer
Replaces string(based on pattern) from multiple files.
It will search for given file type in whole directory tree and replace every occurrance of string pattern found in them. 
With default settings it will prompt before making any change.

**Usage:**
1.  Clone the project in your local repository.
    Eg. `git clone https://github.com/PankajMSharma/String-Pattern-Remover.git`
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
