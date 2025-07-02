
## Challenge
Santa is shopping for gifts and Christmas items during that time. Not everything is made in the factory.

He loads them into a shopping sleigh and hands them to a Christmas Elf, who processes the purchases using special holiday offers like `Three for One`, `Five for a Set Price` and `Ten Percent Off`.

After checking out, the Elf provides Santa with a receipt detailing the total cost, the price and quantity of each item, along with their discounts.

The Christmas Elf is also considering adding a new discount option: `Two for One`.

Teo explains to you that the relevant code is in the ShoppingSleigh class and even for the elves, this code is a mess! 💥
in [ShoppingSleigh.java](../../exercise/java/day13/src/main/java/santamarket/model/ShoppingSleigh.java)

```java
void handleOffers(Receipt receipt, Map<Product, Offer> offers, SantamarketCatalog catalog) {
        for (Product p: productQuantities().keySet()) {
            double quantity = productQuantities.get(p);
            if (offers.containsKey(p)) {
                Offer offer = offers.get(p);
                double unitPrice = catalog.getUnitPrice(p);
                int quantityAsInt = (int) quantity;
                Discount discount = null;
                int x = 1;
                if (offer.offerType == SpecialOfferType.THREE_FOR_TWO) {
                    x = 3;

                } else if (offer.offerType == SpecialOfferType.TWO_FOR_AMOUNT) {
                    x = 2;
                    if (quantityAsInt >= 2) {
                        double total = offer.argument * (quantityAsInt / x) + quantityAsInt % 2 * unitPrice;
                        double discountN = unitPrice * quantity - total;
                        discount = new Discount(p, "2 for " + offer.argument, -discountN);
                    }

                } if (offer.offerType == SpecialOfferType.FIVE_FOR_AMOUNT) {
                    x = 5;
                }
                int numberOfXs = quantityAsInt / x;
                if (offer.offerType == SpecialOfferType.THREE_FOR_TWO && quantityAsInt > 2) {
                    double discountAmount = quantity * unitPrice - ((numberOfXs * 2 * unitPrice) + quantityAsInt % 3 * unitPrice);
                    discount = new Discount(p, "3 for 2", -discountAmount);
                }
                if (offer.offerType == SpecialOfferType.TEN_PERCENT_DISCOUNT) {
                    discount = new Discount(p, offer.argument + "% off", -quantity * unitPrice * offer.argument / 100.0);
                }
                if (offer.offerType == SpecialOfferType.FIVE_FOR_AMOUNT && quantityAsInt >= 5) {
                    double discountTotal = unitPrice * quantity - (offer.argument * numberOfXs + quantityAsInt % 5 * unitPrice);
                    discount = new Discount(p, x + " for " + offer.argument, -discountTotal);
                }
                if (discount != null)
                    receipt.addDiscount(discount);
            }
        }
    }
```

He thought about it with the team and suggested an approach:
Your objective is to deploy a generic method to compute the `X for Y` discount offers, covering the existing `Three for two` discount, as well as the new `Two for one` discount.

Your starting point is `santamarket.model.ShoppingSleigh.handleOff`X for Y`ers()` method.

Start with the below Mikado graph and complete it:

- [ ] 👍Deploy a generic method to compute the `X for Y` discount offers, covering `Three for two` and `Two for one` offers
    - [ ] 👍Prepare the code for an easy addition of the `X for Y` discount type family
        - [ ] ...
            - [ ] ...
    - [ ] 👍Implement the `Two for one` discount computation
        - [ ] ...
    - [ ] 👍Refactor the existing code to use the `X for Y` discount computation method with the `Three for two` discount
- [ ] Parking-Lot (any change with no direct impact on the main goal)
    - [ ] ...

## Bonus
Add the new discount type `Two for one` on top of your refactored code.

## Note
This exercise was inspired from Emily Bache's [SupermarketReceipt refactoring kata](https://github.com/emilybache/SupermarketReceipt-Refactoring-Kata).

### Proposed Solution
[![Proposed Solution Guide](../../img/proposed-solution.webp)](solution/step-by-step.md)