Narrative:
In order to find products more efficiently
As a customer
I want to be able to search for products using a combination of search criteria

Scenario: Search by keyword and price range
Given I am looking for a cheap shirt
When I search for "shirt" with a price of up to 50.00
Then I should see a product with the title No Logo Shirts

Scenario: Search by keyword and category
Given I am looking for a no-logo dress
When I search for "No Logo" in the "Womens" category
Then I should see a product with the title No Logo Assymmetric Dress

