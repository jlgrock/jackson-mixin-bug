package com.github.jlgrock;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.Objects;

/**
 * Test Class created for testing abstract serializer/deserializer
 */
@JsonDeserialize(builder = TestRecordWithBuilder.Builder.class)
public class TestRecordWithBuilder {
	private String name;
	private String phone;

	@JsonCreator
    public TestRecordWithBuilder(final Builder builder) {
        name = builder.builderName;
        phone = builder.builderPhone;
    }

	public String getPhone() {
		return phone;
	}

	public String getName() {
		return name;
	}

	public static Builder builder() {
	    return new Builder();
    }

    @JsonPOJOBuilder
	public static class Builder {
        private String builderName;
        private String builderPhone;

        public Builder withPhone(final String tinIn) {
            builderPhone = tinIn;
            return this;
        }

        public Builder withName(final String nameIn) {
            builderName = nameIn;
            return this;
        }

        public TestRecordWithBuilder build() {
            return new TestRecordWithBuilder(this);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestRecordWithBuilder that = (TestRecordWithBuilder) o;
        return Objects.equals(phone, that.phone) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phone, name);
    }
}
