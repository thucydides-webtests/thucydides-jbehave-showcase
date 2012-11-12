package net.thucydides.showcase.jbehave.model

class FilterBy {

    static FilterBy keyword(String keyword) {
        new FilterByKeyword(keyword: keyword)
    }

    static FilterBy maxPrice(BigDecimal maxPrice) {
        new FilterByPrice(maxPrice:maxPrice)
    }

    static FilterBy category(String category) {
        new FilterByCategory(category:category)
    }

    static class FilterByKeyword extends FilterBy {
        String keyword
    }

    static class FilterByPrice extends FilterBy {
        BigDecimal minPrice
        BigDecimal maxPrice
    }

    static class FilterByCategory extends FilterBy {
        String category
    }
}
