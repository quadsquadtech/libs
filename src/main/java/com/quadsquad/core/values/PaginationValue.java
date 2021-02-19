package com.quadsquad.core.values;

public class PaginationValue {

    private IntegerValue index ;
    private IntegerValue limit ;

    private StringValue sortBy ;
    private StringValue groupBy ;
    private StringValue sortOrder ;

    private IntegerValue totalCount ;

    public static Builder newBuilder() {
        return new Builder() ;
    }

    public Builder toBuilder() {

        return newBuilder()
                .setIndex(index)
                .setLimit(limit)
                .setSortBy(sortBy)
                .setGroupBy(groupBy)
                .setSortOrder(sortOrder)
                .setTotalCount(totalCount)

                ;
    }

    public static class Builder {

        private IntegerValue index ;
        private IntegerValue limit ;
        private StringValue sortBy ;
        private StringValue groupBy ;
        private StringValue sortOrder ;
        private IntegerValue totalCount ;

        public Builder setIndex(int value) {
            this.index = IntegerValue.of(value);
            return this ;
        }

        public Builder setLimit(int value) {
            this.limit = IntegerValue.of(value);
            return this ;
        }

        public Builder setSortBy(String value) {
            this.sortBy = StringValue.of(value);
            return this ;
        }

        public Builder setGroupBy(String value) {
            this.groupBy = StringValue.of(value);
            return this ;
        }

        public Builder setSortOrder(String value) {
            this.sortOrder = StringValue.of(value);
            return this ;
        }

        public Builder setTotalCount(int value) {
            this.totalCount = IntegerValue.of(value);
            return this ;
        }

        public Builder setIndex(IntegerValue value) {
            this.index = value;
            return this ;
        }

        public Builder setLimit(IntegerValue value) {
            this.limit = value;
            return this ;
        }

        public Builder setSortBy(StringValue value) {
            this.sortBy = value;
            return this ;
        }

        public Builder setGroupBy(StringValue value) {
            this.groupBy = value;
            return this ;
        }

        public Builder setSortOrder(StringValue value) {
            this.sortOrder = value;
            return this ;
        }

        public Builder setTotalCount(IntegerValue value) {
            this.totalCount = value;
            return this ;
        }

        public Builder setPaginationValue(PaginationValue value) {

            if (value == null) return this ;

            index = value.index ;
            limit = value.limit ;
            sortBy = value.sortBy ;
            groupBy = value.groupBy ;
            sortOrder = value.sortOrder ;
            totalCount = value.totalCount ;

            return this ;
        }

        public Builder setBuilder(Builder value) {

            if (value == null) return this ;

            index = value.index ;
            limit = value.limit ;
            sortBy = value.sortBy ;
            groupBy = value.groupBy ;
            sortOrder = value.sortOrder ;
            totalCount = value.totalCount ;

            return this ;
        }

        public PaginationValue build() {

            if (index == null) index = IntegerValue.ZERO ;
            if (limit == null) limit = IntegerValue.ZERO ;
            if (sortBy == null) sortBy = StringValue.EMPTY ;
            if (groupBy == null) groupBy = StringValue.EMPTY ;
            if (sortOrder == null) sortOrder = StringValue.EMPTY ;
            if (totalCount == null) totalCount = IntegerValue.ZERO ;

            final PaginationValue paginationValue = new PaginationValue() ;
            paginationValue.index = index ;
            paginationValue.limit = limit ;
            paginationValue.sortBy = sortBy ;
            paginationValue.groupBy = groupBy ;
            paginationValue.sortOrder = sortOrder ;
            paginationValue.totalCount = totalCount ;

            return paginationValue ;
        }

    }
}
