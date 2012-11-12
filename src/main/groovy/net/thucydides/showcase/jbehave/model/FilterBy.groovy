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

        @Override
        public String toString() {
            "[filter by keyword $keyword]";
        }
    }

    static class FilterByPrice extends FilterBy {
        BigDecimal minPrice
        BigDecimal maxPrice

        @Override
        public String toString() {
            "[filter by price from $minPrice to $maxPrice]";
        }
    }

    static class FilterByCategory extends FilterBy {
        String category

        @Override
        public String toString() {
            "[filter by category $category]";
        }
    }
}
