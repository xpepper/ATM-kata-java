# ATM kata

You have to develop an [Automated Teller Machine](https://en.wikipedia.org/wiki/Automated_teller_machine) (ATM) allowing cash withdrawals.

The ATM main features:

* it allows cash withdrawals with the following denominations: `5 €`, `10 €`, `20 €`, `50 €`
* it keeps track of the currently available amount of banknotes on the different denominations (e.g. how many 20 € notes are still available in the ATM)
* it raises an error condition if the notes are not enough to complete the requested cash withdrawal
* it gives priority to the higher value denominations first before using the smaller denominations
* it can be configured to support different denomination sizes and currencies (e.g. `5 $`, `10 $`, `20 $`, `50 $`, `100 $`)

![](https://i.imgur.com/BnEdR9C.png) _(taken from https://www.youtube.com/watch?v=fkhm5kOUeJU)_

Credits to Piergiuliano Bossi for the original kata.
