package com.raccoon.common.dao.entity;

import org.apache.commons.lang3.builder.HashCodeBuilder;

public abstract class BaseEntity {

    public abstract Long getId();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BaseEntity that = (BaseEntity) obj;
        return that.getId() != null && that.getId().equals(getId());
    }

    @Override
    public int hashCode() {
        int initialOddNumber = 17;
        if (getId() == null) {
            return initialOddNumber;
        } else {
            return new HashCodeBuilder(initialOddNumber, 37)
                    .append(getId())
                    .toHashCode();
        }
    }
}
