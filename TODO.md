# TODO list

- withdrawal should decrease ATM quantity of notes
- withdrawal should raise an exception when cannot be performed
- a `Bundle` object should be created instead of a poor hashmap?
* [F] it should be disallowed to load negative quantities of banknotes
* [!] `Denomination` is a simple `enum`... is it enough?
* [!] smell: the denomination value (e.g. FIVE_EURO has a value of 5) is still not relevant in the system
* [R] tests should be refactored to iterate over all the available `Denomination`s?
* [?] why starting from the `billsFor`? What's the strategy here? Maybe to "learn" about the problem domain?