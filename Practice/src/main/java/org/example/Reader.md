


FILE READER                                     
* Slower and less efficient
* Can read only character by character
* Can only read from a file

Syntax:
File file = new File("path-to-file");
FileReader fr = new FileReader(file);
int i;
while((i = fr.read))!=-1) {
System.out.println((char)i);

BUFFERED READER
* Faster and more efficient
* Can read characters and lines
* Can read from any kind of character stream