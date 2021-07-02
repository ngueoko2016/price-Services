# Price-servicce

Our price decision price is divide in to two main sets:

A. Conditions: Dose our product's price/quantity satisfy this rule ?
B. Action: Which action can be apply to our order assume that it satisfy a condition? 

The satisfaction of a set of conditions by a purchase implies a set of actions on its price

-All our price configurations are store in the PriceRuleContext class  price rule context;
-We can add/remove rule configuration
-Depending of rules, more than one price configuration can be apply at same time. Ex apply rewarding and discount
-It is possible to define priceRuleContext for specific set of config's price rules

Example for this exercise:

Config A
 1. Conditions
   - ProductType equals to TYPE_ONE
   - Quantity greater than 2
 2. Actions
   - Reward one


Config B
 1. Conditions
  - ProductType equals to TYPE_TWO
  - Quantity greater than 3
 2. Actions
  - Sell each 3 product for $1


Config C
 1. Conditions
  - TotalPrice greater than $10
 2. Actions
  - Apply $2 fixed discount
