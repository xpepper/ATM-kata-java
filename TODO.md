# TODO list

* [?] should we move the withdrawal logic to the `Bundle` class or leave it in the `ATM` class?
* [F] it should be disallowed to load negative quantities of banknotes
* [!] `Denomination` is a simple `enum`... is it enough?
* [R] tests should be refactored to iterate over all the available `Denomination`s?
* [F] can be configured to support different denomination sizes and currencies (e.g. `5 $`, `10 $`, `20 $`, `50 $`, `100 $`)

## doubts

* [?] why starting from the `billsFor`? What's the strategy here? Maybe to "learn" about the problem domain?