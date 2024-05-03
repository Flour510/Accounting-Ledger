# Welcome to the $ Money Management Tool

In this repository you will find the code written in the Java language, that builds an Accounting Ledger application. According to these instructions, the application is to be built with these specifications in mind:

In this project, we will use the skills we have accumulated about Java programming to create a Command Line Interface application. With this application the user can track all financial transactions for personal use.  - Capstone 1 Accouting Ledger

# Screens
When you run the code, the terminal displays a greeting to the user, followed by a display of the Home screen and the different screen options you can navigate into. The user can input a number from 1 - 4 to make a selection to go into a next screen page as shown below:

![Screenshot 2024-05-02 at 10 22 54 PM](https://github.com/Flour510/Accounting-Ledger/assets/99916123/543ef2ce-b0e7-438f-86b5-dbf4700a26e0)

## Add Deposit Screen
If the user inputs selection 1 from the home screen and presses enter, they will be prompted into that screen and be prompted a message to enter: 

* Deposit Data, Vendor Data, Deposit Amount 

Followed by confirmation of their successful deposit and a prompt with a question of their next move plus options for their next action. The user can input a selection from A - C as shown below:

![Screenshot 2024-05-02 at 10 33 52 PM](https://github.com/Flour510/Accounting-Ledger/assets/99916123/55408a4d-7cf0-46bc-b543-30a16b4350c2)

## Make Payment (Debit) Screen
If the user inputs selection 2 from the home menu and presses enter, they will be prompted into that screen and be prompted a message to enter: 

* Payment Data, Vendor Data, Payment Amount

Followed by confirmation of their successful payment and a prompt with a question of their next move plus options for their next action. The user can input a selection from A - C as shown below:

![Screenshot 2024-05-02 at 10 38 06 PM](https://github.com/Flour510/Accounting-Ledger/assets/99916123/ea1deead-cbb8-4572-8f8a-0adb309a52c8)

## Ledger Screen
If the user inputs selection 3 from the home screen and presses enter, they will be prompted into that screen and be prompted a message to enter a selection from 1 - 5: 

* Display all entries, Deposits only, Payments only, Reports / Custom Search, Home 

![Screenshot 2024-05-02 at 10 45 21 PM](https://github.com/Flour510/Accounting-Ledger/assets/99916123/0178a63f-24fa-4009-bd54-dbc417ab3346)

## Display All Entries Screen
If the user inputs selection 1 of the ledger menu and presses enter, they will be prompted into that screen and a display of all of the users transactions will print. Followed by a question prompting the user for their next choice, with 3 choices from A - C as shown below: 

![Screenshot 2024-05-02 at 10 49 55 PM](https://github.com/Flour510/Accounting-Ledger/assets/99916123/d1dd0e44-7735-4e0f-b816-747ad1667d1e)

## Deposits Only Screen
If the user inputs selection 2 of the ledger menu and presses enter, they will be prompted into that screen and a display of only the users deposit transactions will print. Followed by a question prompting the user for their next choice from 3 choices from A - C as shown below: 

![Screenshot 2024-05-02 at 10 51 04 PM](https://github.com/Flour510/Accounting-Ledger/assets/99916123/94bac4ef-b3a3-4bd6-ab39-9b862bf7bf0f)

## Payments Only Screen
If the user inputs selection 3 of the ledger menu and presses enter, they will be prompted into that screen and a display of only the users payment transactions will print. Followed by a question prompting the user for their next choice from 3 choices from A - C as shown below: 

![Screenshot 2024-05-02 at 10 57 22 PM](https://github.com/Flour510/Accounting-Ledger/assets/99916123/31bdd709-51fc-4bc2-8dc0-a5efcb6bf477)

## Reports / Custom Search Screen
If the user inputs selection 4 of the ledger menu and presses enter, they will be prompted into that screen and a choose a report menu with options from 1 - 6 will print with the following choices:

* Month To Date, Previous Month, Year To Date, Previous Year, Search by Vendor, Back 

![Screenshot 2024-05-02 at 10 59 37 PM](https://github.com/Flour510/Accounting-Ledger/assets/99916123/53deb1fd-c3bd-45d5-905c-0137ff90239f)

## Month To Date Report Screen
If the user inputs selection 1 of the reports/custom search menu and presses enter, they will be prompted into that screen and a display of trasactions in order from the begining of the month to the current date will print. Followed by a question prompting the user for their next choice from 3 choices from A - C as shown below: 

![Screenshot 2024-05-02 at 11 04 25 PM](https://github.com/Flour510/Accounting-Ledger/assets/99916123/0502b253-d8f7-434e-a3fb-fca30e98609e)

## Previous Month Report Screen
If the user inputs selection 2 of the reports/custom search menu and presses enter, they will be prompted into that screen and a display of trasactions from the previous month will print. Followed by a question prompting the user for their next choice from 3 choices from A - C as shown below: 

![Screenshot 2024-05-02 at 11 07 06 PM](https://github.com/Flour510/Accounting-Ledger/assets/99916123/491cd522-51d9-4688-a03c-5c5350d5e9f3)

## Year To Date Report Screen
If the user inputs selection 3 of the reports/custom search menu and presses enter, they will be prompted into that screen and a display of trasactions in order from the begining of the year to the current date will print. Followed by a question prompting the user for their next choice from 3 choices from A - C as shown below: 

![Screenshot 2024-05-02 at 11 10 49 PM](https://github.com/Flour510/Accounting-Ledger/assets/99916123/1a950743-571b-4cb4-891b-588cdcd6e83b)

## Previous Year Report Screen
If the user inputs selection 4 of the reports/custom search menu and presses enter, they will be prompted into that screen and a display of trasactions from the previous year will print. Followed by a question prompting the user for their next choice from 3 choices from A - C as shown below: 

![Screenshot 2024-05-02 at 11 11 59 PM](https://github.com/Flour510/Accounting-Ledger/assets/99916123/06847bb5-0129-49c5-9a2d-d7849ccfb237)

## Search By Vendor Report Screen
If the user inputs selection 5 of the reports/custom search menu and presses enter, they will be prompted into that screen where they will be askd to input a vendor name to search by. This will print all the trasactions associated with that vendor name. Followed by a question prompting the user for their next choice from 3 choices from A - C as shown below: 

![Screenshot 2024-05-02 at 11 16 14 PM](https://github.com/Flour510/Accounting-Ledger/assets/99916123/fcff080d-4433-4431-87c9-10545ee5509d)

## Interesting Piece of the Code
One part of this code I found interesting to build is option 4 - Reports / Custom Search. Creating this 
sub-menu was challenging for me and threw me way off. At first I couldnt understand how to make this work. Unitl I recieved help and advice that this sub-menu was basically just implementing the same code that was used to create the home menu. Once you can figure out how to make one method, the rest will flow!

![Screenshot 2024-05-02 at 11 23 46 PM](https://github.com/Flour510/Accounting-Ledger/assets/99916123/40bd9e5b-a87f-4137-be0c-b27405b23128)



