package net.thucydides.showcase.jbehave.pages

import org.openqa.selenium.WebDriver
import net.thucydides.showcase.jbehave.model.FilterBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.By

class AdvancedSearchPage extends BigCommercePage {
    AdvancedSearchPage(WebDriver driver) {
        super(driver)
    }

    @FindBy(id="search_query_adv")
    WebElement searchKeyword;

    @FindBy(id="price_from")
    WebElement price_from;

    @FindBy(id="price_to")
    WebElement price_to;

    @FindBy(css="input[value='Search']")
    WebElement search

    def searchFor(FilterBy... filters) {
        setFilters(filters)
        $(search).click()
    }

    private void setFilters(FilterBy... filters) {
        filters.each { filter ->
            switch (filter.class) {
                case FilterBy.FilterByKeyword:
                    setKeywordFrom(filter);
                    break;
                case FilterBy.FilterByPrice:
                    setPriceRangeFrom(filter);
                    break;
                case FilterBy.FilterByCategory:
                    setCategoryFrom(filter);
                    break;
            }
        }
    }

    def setCategoryFrom(FilterBy.FilterByCategory filter) {
        $("#category").then(By.partialLinkText(filter.category)).click()
    }

    def setPriceRangeFrom(FilterBy.FilterByPrice filterBy) {
        if (filterBy.minPrice) {
            $(price_from).type(filterBy.minPrice.toString())
        }
        if (filterBy.maxPrice) {
            $(price_from).type(filterBy.maxPrice.toString())
        }
    }

    def setKeywordFrom(FilterBy.FilterByKeyword filterBy) {
        $(searchKeyword).type(filterBy.keyword)
    }
}
