package com.github.jlgrock;

import java.util.Objects;

/**
 * Test Class created for testing abstract serializer/deserializer
 */
public class TestRecord {
    private String name;
    private String phone;

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public void setPhone(final String phoneIn) {
        phone = phoneIn;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestRecord that = (TestRecord) o;
        return Objects.equals(phone, that.phone) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phone, name);
    }
}
