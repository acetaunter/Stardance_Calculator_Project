# Stardance_Calculator_Project
Was made for the summer Stardance project with hackathon

Version 1.0.0 - Functional calculator in progress with bugs

Full code explenation(thoght process and nerding out a lil)

Front end- Buttons, textfields as well for the ui, 
that is majority front end for the ui

Back end- Utilizing basic concepts to make a complex system was my goal
to start from the first lines where I take the input from javafx
as an array(line 13)
this is what I then use for the creation of an equation by 
iterating through characters in a structure like 
"1+1" -> ['1' , '+', '1']

this is what I am able to loop through for the entire project 

I then am able to make an exception for /0 though this is still in development
for the actual numerical and not just string detection

using pemdas in a simple way I use contains for pemdas but
specifically (, becuase you want to loop through the internal 
parentheses

I then create another equation for parentheses(line 42)
again following similar processes for the initial creation of the equation
while loop on 44

pemdas of course follows the rules of multiplication after exponents(may add later)
so that is used as a while loop on line 52 

my variables needed are the operator, left and right number and sum number
this is used for all other parts of the project in effort to both simplify and
retain similar code logic

the conditional on line 60 works to stop when hitting that operator
again similar logic will be found later on

parsing is where it gets difficult
create a number for left being on the left side of the operator
and vise versa for the right
only difference is left is -1 and right is +1
in order to not have decimal complications I needed ti to detect any operators
instantly after hense the conditional on line 87, negative number eval is still
in process
I then add to the index for each number by making sure its less than the 
equation size and is still a digit each time
for more info check the constructors on line 86

decimals work by showing off the fact that if there is a '.' then it
should consider the dot boolean true(used to make sure there arent 
multiple dots)

after this there is tehn appending after the dot on line 98-102
and continuing for the while loop on 104

then at 108 if the boolean is true and the next index is '.'
then stop

the operator eval is just detecting whatever the var operator was and
doing that

this logic applies to most of the project up until the end
at 469 
where we implement the sublist in order to get rid of any left overs

and then create the final string using a stringbuilder to give back to 
the front end

TL;DR

front end -> javafx
buttons and textfields

back end

### input handling 
takes the equation from javafx and turns it into an arrayList<Characters>
 EX: "1+1"-> ['1','+','1']
easy to scan, easy to use

### /0 detection 
makes sure you cant divide by 0 and get an error
only works in string for now
plan to do numerical later

### PEMDAS
used evalution ordering using contains to scan in order
parentheses overarches
mult and divide first
then sub and add

### Parsing numbers

left number scans backwards from the operator
right number scan forward
decimal use boolean to check to prevent errors

### operatove eval

*mult
/divide
+add
-sub
%percent(still in progress)

### final
makes a sublist and removes old characters
put anwser into string builder
give back to ui

## planned updates for later versions

better ui
memory buttons
history of what you input
better error handling

Goal:
Even with the basics you can make something really cool
)
