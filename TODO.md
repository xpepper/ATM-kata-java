# TODO list
* [F] withdrawal bundles of only 5€ notes 
  - add a `Bundle#value` method
  - withdrawal should raise an exception when cannot be performed
  - withdrawal should not leave negative note quantities
* [F] withdrawal bundles of other denominations too (10, 20, 50)
* [F] gives priority to the higher value denominations first before using the smaller denominations
* [F] it should be disallowed to load negative quantities of banknotes
* [!] `Denomination` is a simple `enum`... is it enough?
* [R] tests should be refactored to iterate over all the available `Denomination`s?
* [F] can be configured to support different denomination sizes and currencies (e.g. `5 $`, `10 $`, `20 $`, `50 $`, `100 $`)

## doubts

* [?] why starting from the `billsFor`? What's the strategy here? Maybe to "learn" about the problem domain?