package net.thucydides.showcase.jbehave.steps

import org.jbehave.core.annotations.Pending
import org.jbehave.core.annotations.Then
import org.jbehave.core.annotations.Given
import org.jbehave.core.annotations.When
import net.thucydides.showcase.jbehave.model.matchers.ProductMatcher
import org.openqa.selenium.By
import net.thucydides.showcase.jbehave.model.FilterBy

class AdvancedSearchSteps extends SimpleSearchSteps {
    @Given('I am looking for a $product')
    public void givenIAmLookingForAProduct(String product) {
        customer.opens_home_page()
    }

    @When('I search for "$keyword" with a price of up to $price')
    public void searchByKeywordAndPrice(String keyword, BigDecimal price) {
        customer.searches_for_product(FilterBy.keyword(keyword), FilterBy.maxPrice(price))
    }

    @When('I search for "$keyword" in the "$category" category')
    public void whenISearchAKeywordInACategory(String keyword, String category) {
        customer.searches_for_product(FilterBy.keyword(keyword), FilterBy.category(category))
    }
}
