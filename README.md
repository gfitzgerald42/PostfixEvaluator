# PostfixEvaluator
*This program is a postfix evaluator.
*It reads information from a file given on the command line and
*computes the answer (sum, difference, quotient, or product)
*and prints out the answer.

*In postfix, the operator comes after its two operands. 
*Below are a few expressions with infix on the left and the postfix equivalent on the right (extra spacing added for readability):
*6-9→69- 4+5*2→452*+ 4*5-2→45*2-

*Postfix expressions are simpler to evaluate than are infix expressions because there are no parentheses or precedence rules. 
*Instead, expressions are evaluated in the order the operands and operators appear. It is for this reason that compilers and 
*interpreters generally translate infix expressions into postfix, and then generate assembly code that carries out the postfix computation.
