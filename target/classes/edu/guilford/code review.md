# Code Review

## Documentation
Are there clear and correct Javadoc comments for the class, method, and/or attributes?
- No
- Javadoc comments have been added.

## Code Structure
Does the code satisfy all provided specifications?
- Only error is that in the Lamarckian Poker, the sacrificial card is added to the pool, though the README.md file says it should be added to the discard.
- Adjusted code to make this change.

Is the code consistently formatted?
- Yes, the program shows consistent formatting.

Do all methods have a clear purpose?
- Deck.size() is unnecessary -- Deck.getDeck().size() can be used instead

Is there any debugging code still present that should be commented out or otherwise modified so that it does not run in production mode?
- All debugging code is commented out

What repeated code is present that could become a single method?
- In the turn() method of LamarckianPoker, compareTo() method can be used instead of explicitly comparing ordinals
- Each player's turn in LamarckainPoker can be reduced to a single method to avoid repitition.
- Created playerturn() and called method within turn() loop

Are there any “magic number” constants that should be redefined as final variables?
- No. There are no instances where using a final variable in place of a number is more beneficial.

Is there any complexity that can be simplified by the use of multiple, clearer methods?
- Some methods used are unnecessary and can be removed for simplicity
- Blackjack.reset() and Deck.build() methods can be replced with constructors that initialize the game properly
- Adjusted code in driver accordingly
- Collections shuffle method can be used in place of the of Deck.shuffle() method

## Variables
Do all variables (both attributes and other local variables) have reasonable types and identifiers?
- The variable discard would work better as a Hand variable rather than a Deck variable, as it begins empty and adds cards.
- Code changed to make discard a Hand type and changed methods accordingly.

Does each variable have a single purpose in its scope?
- Yes, each variable has a single purpose

Whenever the code assigns a value to a variable, does the code ensure type consistency? For example, does the code use casting appropriately?
- Code ensures type consistency

Are there variables that can be removed from the code because they are redundant or unused?
- No

## Loops and conditional statements
Are there any errors in the nesting of loops and conditional statements?
- No errors

In an if-else chain or switch statement, are the most common conditions tested first?
- Yes, most common conditions are tested first

Does each if-else chain or switch statement address all possible cases?
- Yes, all cases accounted for

Can readability and robustness be improved by converting an if-else statement to a switch?
- No

Do loops (for, while, or for-each) have proper index initialization statements?
- Yes

Are loop termination conditions guaranteed to be satisfied when the program runs?
- No--addressed in debug section

Are there statements that can be moved outside of the loop (because they only need to run once) or conditional statement (because they run no matter what the result of the conditional statement is)?
- No

## General programming practice
Are indexes tested against array bounds?
- Yes

Are all return values assigned and returned correctly?
- Yes

Do methods avoid the use of print statements and instead return values or strings?
- Yes

Does each statement operate on the correct data?
- Yes

Does the code provide reasonable results for a wide range of test cases, especially including any potential edge cases?
- Yes

## Debugging
Ocassionally, there will be an IllegalArgumentException error in the LamarckianPoker class. This happens when the size of player1Hand or player2Hand is 0, as rand.nextInt(0) is invalid. This happens because the random sacrificial card may not have any matches, decreasing the hand size.

To fix this problem, modify the bounds of the conditional statement in turn() to be only between 1 and 7. Additionally, adding and using a findBestCard() method will help prevent such instances most of the time. 
